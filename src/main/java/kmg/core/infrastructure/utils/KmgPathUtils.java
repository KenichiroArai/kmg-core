package kmg.core.infrastructure.utils;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import kmg.core.domain.types.KmgMsgMessageTypes;
import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.type.KmgString;

/**
 * KMGパスユーティリティ<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
public final class KmgPathUtils {

    /**
     * ビルドパスを返す<br>
     * <p>
     * クラスのビルドパスを返す。<br>
     * </p>
     *
     * @since 0.1.0
     *
     * @param zlass
     *              クラス
     *
     * @return ビルドパス
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    public static Path getBinPath(final Class<?> zlass) throws KmgDomainException {

        Path result = null;

        if (zlass == null) {

            return result;

        }

        try {

            result = KmgPathUtils.getCodeSourceLocation(zlass);

        } catch (final URISyntaxException e) {

            final KmgMsgMessageTypes msgTypes = KmgMsgMessageTypes.KMGMSGE24000;
            final Object[]           msgArgs  = {
                zlass.getName()
            };
            throw new KmgDomainException(msgTypes, msgArgs, e);

        }

        return result;

    }

    /**
     * ビルドパスを返す<br>
     * <p>
     * オブジェクトのビルドパスを返す。<br>
     * </p>
     *
     * @since 0.1.0
     *
     * @param obj
     *            オブジェクト
     *
     * @return ビルドパス
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    public static Path getBinPath(final Object obj) throws KmgDomainException {

        Path result = null;

        if (obj == null) {

            return result;

        }

        result = KmgPathUtils.getBinPath(obj.getClass());

        return result;

    }

    /**
     * クラスとファイル名からクラスのフルパスを返す<br>
     * <p>
     * 例：パッケージ名に「com.sample」、クラス名に「SampleDao」、ファイル名に「sample.sql」の場合、 「ビルドパス/com/sample/sample_dao/sample.sql」を返す。<br>
     * クラス名が空の場合は、空を返す。<br>
     * </p>
     *
     * @since 0.1.0
     *
     * @param zlass
     *                 クラス
     * @param fileName
     *                 ファイル名
     *
     * @return クラスのフルパス
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    public static Path getClassFullPath(final Class<?> zlass, final Path fileName) throws KmgDomainException {

        Path result = null;

        if (zlass == null) {

            return result;

        }

        final Path binPath = KmgPathUtils.getBinPath(zlass);
        result = KmgPathUtils.getClassFullPath(binPath, zlass.getPackageName(), zlass.getSimpleName(), fileName);
        return result;

    }

    /**
     * オブジェクトとファイル名からクラスのフルパスを返す<br>
     * <p>
     * 例：パッケージ名に「com.sample」、クラス名に「SampleDao」、ファイル名に「sample.sql」の場合、 「ビルドパス/com/sample/sample_dao/sample.sql」を返す。<br>
     * クラス名が空の場合は、空を返す。<br>
     * </p>
     *
     * @since 0.1.0
     *
     * @param object
     *                 オブジェクト
     * @param fileName
     *                 ファイル名
     *
     * @return クラスのフルパス
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    public static Path getClassFullPath(final Object object, final String fileName) throws KmgDomainException {

        Path result = null;

        if (object == null) {

            return result;

        }

        Class<?> zlass = null;

        if (object instanceof Class<?>) {

            zlass = (Class<?>) object;

        } else {

            zlass = object.getClass();

        }

        result = KmgPathUtils.getClassFullPath(zlass, Paths.get(fileName));
        return result;

    }

    /**
     * ファイル名のみを返す<br>
     * <p>
     * ファイルパスがnullの場合は、nullを返す。<br>
     * 拡張子のないファイル名のみを返す。<br>
     * ファイルパスがディレクトリの場合はファイルパスをそのまま返す。<br>
     * </p>
     *
     * @since 0.1.0
     *
     * @param filePath
     *                 ファイルパス
     *
     * @return true：ファイル名のみ
     */
    public static String getFileNameOnly(final Path filePath) {

        String result = null;

        if (filePath == null) {

            return result;

        }

        final String fileNameTmp = filePath.getFileName().toString();
        result = fileNameTmp.substring(0, fileNameTmp.lastIndexOf('.'));
        return result;

    }

    /**
     * クラスのコードソースの場所を取得する<br>
     * <p>
     * クラスのコードソースの場所をパスとして返す。<br>
     * </p>
     *
     * @since 0.1.0
     *
     * @param zlass
     *              クラス
     *
     * @return コードソースの場所
     *
     * @throws URISyntaxException
     *                            URI構文例外
     */
    protected static Path getCodeSourceLocation(final Class<?> zlass) throws URISyntaxException {

        Path result = null;

        if (zlass == null) {

            return result;

        }

        result = Paths.get(zlass.getProtectionDomain().getCodeSource().getLocation().toURI());

        return result;

    }

    /**
     * ビルドパスとパッケージ名、クラス名、ファイル名からクラスのフルパスを返す<br>
     * <p>
     * 例：パッケージ名に「com.sample」、クラス名に「SampleDao」、ファイル名に「sample.sql」の場合、 「ビルドパス/com/sample/sample_dao/sample.sql」を返す。<br>
     * クラス名が空の場合は、空を返す。<br>
     * </p>
     *
     * @since 0.1.0
     *
     * @param binPath
     *                    ビルドパス
     * @param packageName
     *                    パッケージ名
     * @param className
     *                    クラス名
     * @param fileName
     *                    ファイル名
     *
     * @return クラスのフルパス
     */
    private static Path getClassFullPath(final Path binPath, final String packageName, final String className,
        final Path fileName) {

        Path result = null;

        if (KmgString.isEmpty(className)) {

            return result;

        }

        String classFullPath = className;
        // $が含まれている場合は$より前のクラスを取得する
        final int dollarIndex = classFullPath.indexOf('$');

        if (dollarIndex > 0) {

            classFullPath = classFullPath.substring(0, dollarIndex);

        }

        classFullPath = KmgString.snakeCase(classFullPath);
        classFullPath = KmgString.concat(packageName.replace('.', '/'), "/", classFullPath); //$NON-NLS-1$

        String binPathStr = KmgString.EMPTY;

        if (binPath != null) {

            binPathStr = binPath.toAbsolutePath().toString();

        }

        result = Paths.get(String.format("%s/%s/%s", binPathStr, classFullPath, fileName)); //$NON-NLS-1$

        return result;

    }

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    private KmgPathUtils() {

        // 処理無し
    }
}
