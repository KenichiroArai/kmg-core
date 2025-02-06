package kmg.core.infrastructure.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import kmg.core.infrastructure.type.KmgString;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * KMGメッセージユーティリティ<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public final class KmgMessageUtils {

    /** プロパティ */
    private static Properties properties;

    static {

        KmgMessageUtils.properties = new Properties();

        try (InputStream input = KmgMessageUtils.class.getClassLoader().getResourceAsStream("messages.properties")) {

            KmgMessageUtils.properties.load(input);

        } catch (final IOException e) {

            // TODO KenichiroArai 2025/02/06 ログを出力する
        }

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    private KmgMessageUtils() {

        // 処理なし
    }

    /**
     * メッセージを取得する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param type
     *             メッセージの種類
     * @return メッセージ
     */
    public static String getMessage(final KmgMsgMessageTypes type) {

        String result = KmgString.EMPTY;

        if ((type == null) || (type.getCode() == null)) {

            return result;

        }
        result = KmgMessageUtils.properties.getProperty(type.getCode(), type.getCode());
        return result;

    }

    /**
     * サンプル
     *
     * @param args
     *             引数
     */
    public static void main(final String[] args) {

        final String message = KmgMessageUtils.getMessage(KmgMsgMessageTypes.KMGMSGE11100);
        System.out.println(message);

    }
}
