package kmg.core.domain.model.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import kmg.core.domain.model.KmgReflectionModel;
import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.types.KmgLogMessageTypes;

/**
 * KMGリフレクションモデル<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
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
     * クラス用コンストラクタ<br>
     *
     * @author KenichiroArai
     * @since 1.0.0
     * @version 1.0.0
     * @param clazz
     *                        対象クラス
     * @param constructorArgs
     *                        コンストラクタに渡す引数
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    public KmgReflectionModelImpl(final Class<?> clazz, final Object... constructorArgs) throws KmgDomainException {

        try {

            final Class<?>[] parameterTypes = new Class<?>[constructorArgs.length];

            for (int i = 0; i < constructorArgs.length; i++) {

                parameterTypes[i] = constructorArgs[i].getClass();

            }

            this.object = this.getNewInstance(clazz, parameterTypes, constructorArgs);

        } catch (final InstantiationException e) {

            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

        } catch (final IllegalAccessException e) {

            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

        } catch (final IllegalArgumentException e) {

            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

        } catch (final InvocationTargetException e) {

            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

        } catch (final NoSuchMethodException e) {

            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

        } catch (final SecurityException e) {

            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

        }
        this.clazz = clazz;

    }

    /**
     * オブジェクト用コンストラクタ<br>
     *
     * @author KenichiroArai
     * @since 1.0.0
     * @version 1.0.0
     * @param object
     *               対象オブジェクトのインスタンス
     */
    public KmgReflectionModelImpl(final Object object) {

        this.object = object;
        this.clazz = object.getClass();

    }

    /**
     * フィールド名に該当するフィールドに値を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param fieldName
     *                  フィールド名
     * @return 値
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Override
    public Object get(final String fieldName) throws KmgDomainException {

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

            // TODO 2021/06/06 KenichiroArai KMGの例外にする
            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

        }

        if (this.lastGetField == null) {

            return result;

        }

        this.lastGetField.setAccessible(true);

        try {

            result = this.getValue(this.lastGetField, this.object);

        } catch (final SecurityException e) {

            // TODO 2021/06/06 KenichiroArai KMGの例外にする
            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

        } catch (final IllegalAccessException e) {

            // TODO 2021/06/06 KenichiroArai KMGの例外にする
            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

        }

        return result;

    }

    /**
     * 最後に取得したフィールドを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
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
     * @sine 1.0.0
     * @version 1.0.0
     * @param methodName
     *                   メソッド名
     * @param parameters
     *                   パラメータ
     * @return 返却値
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Override
    public Object getMethod(final String methodName, final Object... parameters) throws KmgDomainException {

        Object result = null;

        if (methodName == null) {

            return result;

        }

        /* パラメータクラスの設定 */
        final Class<?>[] parameterTypes = new Class[parameters.length];
        int              i              = 0;

        for (final Object param : parameters) {

            parameterTypes[i] = param.getClass();
            i++;

        }

        /* メソッドの取得 */
        Method   method      = null;
        Class<?> targetClazz = this.clazz;

        try {

            while (targetClazz != Object.class) {

                try {

                    try {

                        method = this.getMethod(targetClazz, methodName, parameterTypes);

                        // メソッドが見つかった
                        break;

                    } catch (@SuppressWarnings("unused") final NoSuchMethodException e) {

                        method = targetClazz.getDeclaredMethod(methodName, parameterTypes);

                        // メソッドが見つかった
                        break;

                    }

                } catch (@SuppressWarnings("unused") final NoSuchMethodException e) {

                    targetClazz = targetClazz.getSuperclass();

                }

            }

        } catch (final SecurityException | IllegalArgumentException e) {

            // TODO 2021/06/06 KenichiroArai KMGの例外にする
            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

        }

        if (method == null) {

            return result;

        }

        /* privateメソッドのアクセス許可の設定 */
        method.setAccessible(true);

        /* メソッドの呼び出し */
        try {

            result = this.invoke(method, this.object, parameters);

        } catch (final SecurityException | IllegalAccessException | IllegalArgumentException
            | InvocationTargetException e) {

            // TODO 2021/06/06 KenichiroArai KMGの例外にする
            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

        }

        return result;

    }

    /**
     * フィールド名に該当するフィールドに値を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param fieldName
     *                  フィールド名
     * @param value
     *                  値
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Override
    public void set(final String fieldName, final Object value) throws KmgDomainException {

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

            // TODO 2021/06/06 KenichiroArai KMGの例外にする
            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

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

                    // TODO 2021/06/06 KenichiroArai KMGの例外にする
                    throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

                }

            }
            this.setValue(this.lastGetField, this.object, fieldValue);

        } catch (final IllegalAccessException e) {

            // TODO 2021/06/06 KenichiroArai KMGの例外にする
            throw new KmgDomainException(e.getMessage(), KmgLogMessageTypes.NONE, e);

        }

    }

    /**
     * フィールド名に該当するフィールドを宣言したフィールドとして返す<br>
     *
     * @param targetClazz
     *                    クラス
     * @param name
     *                    フィールド名
     * @return 宣言フィールド
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
     * @return フィールド
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
     * メソッドを取得する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param targetClazz
     *                       クラス
     * @param name
     *                       メソッド名
     * @param parameterTypes
     *                       パラメータ型
     * @return メソッド
     * @throws NoSuchMethodException
     *                               メソッドが存在しない例外
     * @throws SecurityException
     *                               セキュリティ例外
     */
    @SuppressWarnings("static-method")
    protected Method getMethod(final Class<?> targetClazz, final String name, final Class<?>[] parameterTypes)
        throws NoSuchMethodException, SecurityException {

        final Method result = targetClazz.getMethod(name, parameterTypes);
        return result;

    }

    /**
     * クラスのコンストラクタを取得し、インスタンスを生成する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param targetClazz
     *                        対象クラス
     * @param parameterTypes
     *                        パラメータ型
     * @param constructorArgs
     *                        コンストラクタ引数
     * @return インスタンス
     * @throws NoSuchMethodException
     *                                   メソッドが存在しない例外
     * @throws SecurityException
     *                                   セキュリティ例外
     * @throws InstantiationException
     *                                   インスタンス化例外
     * @throws IllegalAccessException
     *                                   不正アクセス例外
     * @throws IllegalArgumentException
     *                                   不正な引数例外
     * @throws InvocationTargetException
     *                                   呼び出し対象例外
     */
    @SuppressWarnings("static-method")
    protected Object getNewInstance(final Class<?> targetClazz, final Class<?>[] parameterTypes,
        final Object... constructorArgs) throws NoSuchMethodException, SecurityException, InstantiationException,
        IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        final Object result = targetClazz.getDeclaredConstructor(parameterTypes).newInstance(constructorArgs);
        return result;

    }

    /**
     * フィールドから値を取得する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param field
     *                     フィールド
     * @param targetObject
     *                     オブジェクト
     * @return 値
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
     * @sine 1.0.0
     * @version 1.0.0
     * @param method
     *                     メソッド
     * @param targetObject
     *                     対象オブジェクト
     * @param parameters
     *                     パラメータ
     * @return 呼び出し結果
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
     * @sine 1.0.0
     * @version 1.0.0
     * @param field
     *                     フィールド
     * @param targetObject
     *                     対象オブジェクト
     * @param value
     *                     設定値
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
}
