package kmg.core.infrastructure.utils;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import kmg.core.domain.types.KmgCoreGenMessageTypes;
import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.type.KmgString;

/**
 * KMGパスユーティリティ<br>
 * <p>
 * このクラスはファイルパスの操作に関するユーティリティメソッド群を提供します。<br>
 * 特にJavaクラスおよびオブジェクトに関連するパス操作（ビルドパスの取得、クラスの完全パスの取得など）、 ファイル名の抽出、内部クラスやプロキシクラスの処理などの機能を持っています。<br>
 * 全てのメソッドは静的（static）で、インスタンス化せずに使用することができます。<br>
 * </p>
 * <p>
 * 主な機能：
 * <ul>
 * <li>クラスまたはオブジェクトからビルドパスを取得</li>
 * <li>クラスとファイル名から完全パスを生成</li>
 * <li>ファイルパスからファイル名のみを抽出</li>
 * <li>プロキシクラスやInner Classに対応したシンプルなクラス名の取得</li>
 * </ul>
 * </p>
 * <p>
 * 使用例：
 *
 * <pre>
 *
 * // クラスのビルドパスを取得
 * Path binPath = KmgPathUtils.getBinPath(MyClass.class);
 *
 * // ファイル名のみを取得
 * String fileName = KmgPathUtils.getFileNameOnly(Paths.get("path/to/file.txt"));
 *
 * // クラスとファイル名からフルパスを取得
 * Path fullPath = KmgPathUtils.getClassFullPath(MyClass.class, Paths.get("config.xml"));
 * </pre>
 * </p>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
@SuppressWarnings("nls")
public final class KmgPathUtils {

    /**
     * プロキシクラスの区切り文字
     *
     * @since 0.2.0
     */
    private static final String PROXY_CLASS_SEPARATOR = "$$";

    /**
     * 内部クラス区切り文字
     *
     * @since 0.2.0
     */
    private static final char INNER_CLASS_SEPARATOR = '$';

    /**
     * ファイル拡張子区切り文字
     *
     * @since 0.2.0
     */
    private static final char FILE_EXTENSION_SEPARATOR = '.';

    /**
     * パス区切り文字
     *
     * @since 0.2.0
     */
    private static final char PATH_SEPARATOR = '/';

    /**
     * パス区切り文字（文字列）
     *
     * @since 0.2.0
     */
    private static final String PATH_SEPARATOR_STR = "/";

    /**
     * クラスパスフォーマット
     *
     * @since 0.2.0
     */
    private static final String CLASS_PATH_FORMAT = "%s/%s/%s";

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

            final KmgCoreGenMessageTypes msgTypes = KmgCoreGenMessageTypes.KMGCORE_GEN24000;
            final Object[]               msgArgs  = {
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
        result = fileNameTmp.substring(0, fileNameTmp.lastIndexOf(KmgPathUtils.FILE_EXTENSION_SEPARATOR));
        return result;

    }

    /**
     * シンプルなクラス名を返す<br>
     * <p>
     * クラスのシンプルな名前を返す。<br>
     * クラス名に「$$」が含まれている場合は、その前の部分だけを返す。<br>
     * </p>
     *
     * @since 0.2.0
     *
     * @param zlass
     *              クラス
     *
     * @return シンプルなクラス名
     */
    public static String getSimpleClassName(final Class<?> zlass) {

        String result = null;

        if (zlass == null) {

            return result;

        }

        result = zlass.getSimpleName();

        // $$があるか
        if (result.contains(KmgPathUtils.PROXY_CLASS_SEPARATOR)) {

            // $$がある場合

            // $$の前の部分だけを使用する

            result = result.substring(0, result.indexOf(KmgPathUtils.PROXY_CLASS_SEPARATOR));

        }

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
        final int dollarIndex = classFullPath.indexOf(KmgPathUtils.INNER_CLASS_SEPARATOR);

        if (dollarIndex > 0) {

            classFullPath = classFullPath.substring(0, dollarIndex);

        }

        classFullPath = KmgString.snakeCase(classFullPath);
        classFullPath
            = KmgString.concat(packageName.replace(KmgPathUtils.FILE_EXTENSION_SEPARATOR, KmgPathUtils.PATH_SEPARATOR),
                KmgPathUtils.PATH_SEPARATOR_STR, classFullPath);

        String binPathStr = KmgString.EMPTY;

        if (binPath != null) {

            binPathStr = binPath.toAbsolutePath().toString();

        }

        result = Paths.get(String.format(KmgPathUtils.CLASS_PATH_FORMAT, binPathStr, classFullPath, fileName));

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
