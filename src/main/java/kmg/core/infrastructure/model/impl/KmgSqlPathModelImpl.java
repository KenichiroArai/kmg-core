package kmg.core.infrastructure.model.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import kmg.core.domain.types.KmgCoreGenMessageTypes;
import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.model.KmgSqlPathModel;
import kmg.core.infrastructure.type.KmgString;

/**
 * KMGSQLパスモデル<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
public class KmgSqlPathModelImpl implements KmgSqlPathModel {

    /** パラメータ抽出用の正規表現 */
    @SuppressWarnings("nls")
    private static final String PARAM_EXTRACT_REGEX = "/\\*(.+)\\*/.*";

    /** パラメータ抽出用の置換パターン */
    @SuppressWarnings("nls")
    private static final String PARAM_EXTRACT_REPLACE = "$1";

    /** 末尾改行削除用の正規表現 */
    @SuppressWarnings("nls")
    private static final String TRAILING_NEWLINE_REGEX = "\\R+$";

    /**
     * SQLファイルパス
     *
     * @since 0.1.0
     */
    private final Path sqlFilePath;

    /**
     * パラメータをは変換する<br>
     * <p>
     * 変換する文字列が空の場合は、変換する文字列をそのまま返す。
     * </p>
     *
     * @since 0.1.0
     *
     * @param str
     *            変換する文字列
     *
     * @return 返還後の文字列
     */
    private static String convertParameters(final String str) {

        String result = null;

        if (KmgString.isEmpty(str)) {

            result = str;
            return result;

        }

        result = str.replaceAll(KmgSqlPathModelImpl.PARAM_EXTRACT_REGEX, KmgSqlPathModelImpl.PARAM_EXTRACT_REPLACE);

        return result;

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
     *
     * @param zlass
     *                        クラス
     * @param sqlFileNamePath
     *                        SQLファイル名パス
     */
    public KmgSqlPathModelImpl(final Class<?> zlass, final Path sqlFileNamePath) {

        this.sqlFilePath = sqlFileNamePath;

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
     *
     * @param object
     *                        オブジェクト
     * @param sqlFileNamePath
     *                        SQLファイル名パス
     */
    public KmgSqlPathModelImpl(final Object object, final Path sqlFileNamePath) {

        this.sqlFilePath = sqlFileNamePath;

    }

    /**
     * SQLにして返す<br>
     * <p>
     * SQLパスで受け取ったファイルの中身をSQLにして返す。<br>
     * 読み込んだファイルの末尾の改行は全て削除して返す。<br>
     * コメントに埋め込まれたパラメータをパラメータに変換する。<br>
     * コメントの後にあるサンプル値を削除する。<br>
     * 例：&#047;*:sampleId*&#047;'サンプル'→:sampleId<br>
     * 例：&#047;*:sampleId*&#047;123→:sampleId<br>
     * </p>
     *
     * @since 0.1.0
     *
     * @return SQLにして返す
     *
     * @throws KmgDomainException
     *                            KMGドメイン例外
     */
    @Override
    public String toSql() throws KmgDomainException {

        final StringBuilder sqlTmp = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(this.sqlFilePath)) {

            String line = null;

            while ((line = br.readLine()) != null) {

                final String tmp = KmgSqlPathModelImpl.convertParameters(line);
                sqlTmp.append(tmp);
                sqlTmp.append(System.lineSeparator());

            }

        } catch (final IOException e) {

            final KmgCoreGenMessageTypes msgTypes = KmgCoreGenMessageTypes.KMGCORE_GEN11100;
            final Object[]               msgArgs  = {
                this.sqlFilePath
            };
            throw new KmgDomainException(msgTypes, msgArgs, e);

        }

        final String result = sqlTmp.toString().replaceAll(KmgSqlPathModelImpl.TRAILING_NEWLINE_REGEX, KmgString.EMPTY);

        return result;

    }

}
