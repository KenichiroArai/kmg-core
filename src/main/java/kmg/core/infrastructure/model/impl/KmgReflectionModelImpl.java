package kmg.core.infrastructure.model.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import kmg.core.domain.types.KmgMsgMessageTypes;
import kmg.core.infrastructure.exception.KmgReflectionException;
import kmg.core.infrastructure.model.KmgReflectionModel;

/**
 * KMGリフレクションモデル<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
public class KmgReflectionModelImpl implements KmgReflectionModel {

    /** オブジェクト */
    private final Object object;

    /** クラス */
    private final Class<?> clazz;

    /** 最後に取得したフィールド */
    private Field lastGetField;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @since 1.0.0
     *
     * @version 1.0.0
     *
     * @param object
     *               対象オブジェクトのインスタンス
     */
    public KmgReflectionModelImpl(final Object object) {

        this.object = object;

        // objectがクラスならインスタンスを生成する
        if (object instanceof Class<?>) {

            this.clazz = (Class<?>) object;

        } else {

            this.clazz = object.getClass();

        }

    }

    /**
     * フィールド名に該当するフィールドに値を返す<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param fieldName
     *                  フィールド名
     *
     * @return 値
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Override
    public Object get(final String fieldName) throws KmgReflectionException {

        Object result = null;

        if (fieldName == null) {

            return result;

        }

        this.lastGetField = null;
        Class<?> targetClazz = this.clazz;

        try {

            while (targetClazz != Object.class) {

                try {

                    try {

                        this.lastGetField = this.getField(targetClazz, fieldName);

                        // フィールドが見つかった
                        break;

                    } catch (@SuppressWarnings("unused") final NoSuchFieldException e) {

                        this.lastGetField = this.getDeclaredField(targetClazz, fieldName);

                        // フィールドが見つかった
                        break;

                    }

                } catch (@SuppressWarnings("unused") final NoSuchFieldException e) {

                    targetClazz = targetClazz.getSuperclass();

                }

            }

        } catch (final SecurityException e) {

            final KmgMsgMessageTypes msgTypes = KmgMsgMessageTypes.KMGMSGE11200;
            final Object[]           msgArgs  = {
                fieldName, targetClazz, this.lastGetField
            };
            throw new KmgReflectionException(this, msgTypes, msgArgs, e);

        }

        if (this.lastGetField == null) {

            return result;

        }

        this.lastGetField.setAccessible(true);

        try {

            result = this.getValue(this.lastGetField, this.object);

        } catch (final SecurityException e) {

            final KmgMsgMessageTypes msgTypes = KmgMsgMessageTypes.KMGMSGE11201;
            final Object[]           msgArgs  = {
                fieldName, targetClazz, this.lastGetField
            };
            throw new KmgReflectionException(this, msgTypes, msgArgs, e);

        } catch (final IllegalAccessException e) {

            final KmgMsgMessageTypes msgTypes = KmgMsgMessageTypes.KMGMSGE11202;
            final Object[]           msgArgs  = {
                fieldName, targetClazz, this.lastGetField
            };
            throw new KmgReflectionException(this, msgTypes, msgArgs, e);

        }

        return result;

    }

    /**
     * 最後に取得したフィールドを返す<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @return 最後に取得したフィールド
     */
    @Override
    public Field getLastGetField() {

        final Field result = this.lastGetField;
        return result;

    }

    /**
     * メソッド名に該当するメソッドを呼び出す<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param methodName
     *                   メソッド名
     * @param parameters
     *                   パラメータ
     *
     * @return 返却値
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Override
    public Object getMethod(final String methodName, final Object... parameters) throws KmgReflectionException {

        Object result = null;

        /* 引数のチェック */

        if (methodName == null) {

            return result;

        }

        /* 対象のメソッドを取得 */
        Method   targetMethod = null;
        Class<?> targetClazz  = this.clazz;

        while (targetClazz != Object.class) {

            /* 宣言されているメソッドを取得 */
            Method[] searchMethods = null;

            try {

                searchMethods = this.getDeclaredMethods(targetClazz);

            } catch (final SecurityException e) {

                final KmgMsgMessageTypes msgTypes = KmgMsgMessageTypes.KMGMSGE11203;
                final Object[]           msgArgs  = {
                    methodName, targetClazz
                };
                throw new KmgReflectionException(this, msgTypes, msgArgs, e);

            }

            /* 一致するメソッドを探索する */
            for (final Method searchMethod : searchMethods) {

                // メソッド名が一致するか
                if (!searchMethod.getName().equals(methodName)) {

                    continue;

                }

                // パラメータ数が一致するか
                if (searchMethod.getParameterCount() != parameters.length) {

                    continue;

                }

                // パラメータの型チェック
                final Class<?>[] paramTypes = searchMethod.getParameterTypes();
                boolean          match      = true;

                for (int i = 0; i < paramTypes.length; i++) {

                    if (parameters[i] == null) {

                        continue;

                    }

                    if (!paramTypes[i].isAssignableFrom(parameters[i].getClass())) {

                        match = false;
                        break;

                    }

                }

                if (match) {

                    targetMethod = searchMethod;
                    break;

                }

            }

            if (targetMethod != null) {

                break;

            }
            targetClazz = targetClazz.getSuperclass();

        }

        if (targetMethod == null) {

            return result;

        }

        /* メソッドの呼び出し */

        // privateメソッドのアクセス許可の設定
        targetMethod.setAccessible(true);

        try {

            result = this.invoke(targetMethod, this.object, parameters);

        } catch (final SecurityException e) {

            final KmgMsgMessageTypes msgTypes = KmgMsgMessageTypes.KMGMSGE11204;
            final Object[]           msgArgs  = {
                methodName, targetClazz
            };
            throw new KmgReflectionException(this, msgTypes, msgArgs, e);

        } catch (final IllegalAccessException e) {

            final KmgMsgMessageTypes msgTypes = KmgMsgMessageTypes.KMGMSGE11205;
            final Object[]           msgArgs  = {
                methodName, targetClazz
            };
            throw new KmgReflectionException(this, msgTypes, msgArgs, e);

        } catch (final IllegalArgumentException e) {

            final KmgMsgMessageTypes msgTypes = KmgMsgMessageTypes.KMGMSGE11206;
            final Object[]           msgArgs  = {
                methodName, targetClazz
            };
            throw new KmgReflectionException(this, msgTypes, msgArgs, e);

        } catch (final InvocationTargetException e) {

            final KmgMsgMessageTypes msgTypes = KmgMsgMessageTypes.KMGMSGE11207;
            final Object[]           msgArgs  = {
                methodName, targetClazz
            };
            throw new KmgReflectionException(this, msgTypes, msgArgs, e);

        }

        return result;

    }

    /**
     * フィールド名に該当するフィールドに値を設定する<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param fieldName
     *                  フィールド名
     * @param value
     *                  値
     *
     * @throws KmgReflectionException
     *                                KMGドメイン例外
     */
    @Override
    public void set(final String fieldName, final Object value) throws KmgReflectionException {

        if (fieldName == null) {

            return;

        }

        this.lastGetField = null;
        Class<?> targetClazz = this.clazz;

        try {

            while (targetClazz != Object.class) {

                try {

                    try {

                        this.lastGetField = this.getField(targetClazz, fieldName);

                        // フィールドが見つかった
                        break;

                    } catch (@SuppressWarnings("unused") final NoSuchFieldException e) {

                        this.lastGetField = this.getDeclaredField(targetClazz, fieldName);

                        // フィールドが見つかった
                        break;

                    }

                } catch (@SuppressWarnings("unused") final NoSuchFieldException e) {

                    targetClazz = targetClazz.getSuperclass();

                }

            }

            if (this.lastGetField == null) {

                return;

            }

        } catch (final SecurityException e) {

            final KmgMsgMessageTypes msgTypes = KmgMsgMessageTypes.KMGMSGE11209;
            final Object[]           msgArgs  = {
                fieldName, targetClazz, this.lastGetField
            };
            throw new KmgReflectionException(this, msgTypes, msgArgs, e);

        }

        this.lastGetField.setAccessible(true);

        try {

            if (value == null) {

                this.setValue(this.lastGetField, this.object, null);
                return;

            }

            Object fieldValue = value;

            if (this.lastGetField.getType() == BigDecimal.class) {

                try {

                    fieldValue = new BigDecimal(value.toString());

                } catch (final NumberFormatException e) {

                    final KmgMsgMessageTypes msgTypes = KmgMsgMessageTypes.KMGMSGE11210;
                    final Object[]           msgArgs  = {
                        fieldName, targetClazz, this.lastGetField
                    };
                    throw new KmgReflectionException(this, msgTypes, msgArgs, e);

                }

            }
            this.setValue(this.lastGetField, this.object, fieldValue);

        } catch (final IllegalAccessException e) {

            final KmgMsgMessageTypes msgTypes = KmgMsgMessageTypes.KMGMSGE11211;
            final Object[]           msgArgs  = {
                fieldName, targetClazz, this.lastGetField
            };
            throw new KmgReflectionException(this, msgTypes, msgArgs, e);

        }

    }

    /**
     * フィールド名に該当するフィールドを宣言したフィールドとして返す<br>
     *
     * @param targetClazz
     *                    クラス
     * @param name
     *                    フィールド名
     *
     * @return 宣言フィールド
     *
     * @throws SecurityException
     *                              セキュリティ例外
     * @throws NoSuchFieldException
     *                              フィールドが存在しない例外
     */
    @SuppressWarnings("static-method")
    protected Field getDeclaredField(final Class<?> targetClazz, final String name)
        throws NoSuchFieldException, SecurityException {

        final Field result = targetClazz.getDeclaredField(name);
        return result;

    }

    /**
     * フィールド名に該当するフィールドを返す<br>
     *
     * @param targetClazz
     *                    クラス
     * @param name
     *                    フィールド名
     *
     * @return フィールド
     *
     * @throws SecurityException
     *                              セキュリティ例外
     * @throws NoSuchFieldException
     *                              フィールドが存在しない例外
     */
    @SuppressWarnings("static-method")
    protected Field getField(final Class<?> targetClazz, final String name)
        throws NoSuchFieldException, SecurityException {

        final Field result = targetClazz.getField(name);
        return result;

    }

    /**
     * フィールドから値を取得する<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param field
     *                     フィールド
     * @param targetObject
     *                     オブジェクト
     *
     * @return 値
     *
     * @throws SecurityException
     *                                セキュリティ例外
     * @throws IllegalAccessException
     *                                不正アクセス例外
     */
    @SuppressWarnings("static-method")
    protected Object getValue(final Field field, final Object targetObject)
        throws SecurityException, IllegalAccessException {

        final Object result = field.get(targetObject);
        return result;

    }

    /**
     * メソッドを呼び出す<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param method
     *                     メソッド
     * @param targetObject
     *                     対象オブジェクト
     * @param parameters
     *                     パラメータ
     *
     * @return 呼び出し結果
     *
     * @throws IllegalAccessException
     *                                   不正アクセス例外
     * @throws IllegalArgumentException
     *                                   不正な引数例外
     * @throws InvocationTargetException
     *                                   呼び出し対象例外
     */
    @SuppressWarnings("static-method")
    protected Object invoke(final Method method, final Object targetObject, final Object... parameters)
        throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        final Object result = method.invoke(targetObject, parameters);
        return result;

    }

    /**
     * フィールドに値を設定する<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param field
     *                     フィールド
     * @param targetObject
     *                     対象オブジェクト
     * @param value
     *                     設定値
     *
     * @throws SecurityException
     *                                セキュリティ例外
     * @throws IllegalAccessException
     *                                不正アクセス例外
     */
    @SuppressWarnings("static-method")
    protected void setValue(final Field field, final Object targetObject, final Object value)
        throws SecurityException, IllegalAccessException {

        field.set(targetObject, value);

    }

    /**
     * 宣言されているメソッドを返す<br>
     *
     * @author KenichiroArai
     *
     * @sine 1.0.0
     *
     * @version 1.0.0
     *
     * @param targetClazz
     *                    クラス
     *
     * @return 宣言されているメソッド
     *
     * @throws SecurityException
     *                           セキュリティ例外
     */
    @SuppressWarnings("static-method")
    protected Method[] getDeclaredMethods(final Class<?> targetClazz) throws SecurityException {

        final Method[] result = targetClazz.getDeclaredMethods();
        return result;

    }
}
