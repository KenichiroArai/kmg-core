package kmg.core.infrastructure.utils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

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

    /** リソースバンドル */
    private static ResourceBundle bundle;

    static {

        KmgMessageUtils.bundle = ResourceBundle.getBundle("messages");

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
     *                    メッセージの種類
     * @param messageArgs
     *                    メッセージの引数
     * @return メッセージ
     */
    public static String getMessage(final KmgMsgMessageTypes type, final Object[] messageArgs) {

        String result = KmgString.EMPTY;

        if ((type == null) || (type.getCode() == null)) {

            return result;

        }

        final String messagePattern = KmgMessageUtils.bundle.getString(type.getCode());

        if ((messageArgs != null) && (messageArgs.length > 0)) {

            result = MessageFormat.format(messagePattern, messageArgs);

        } else {

            result = messagePattern;

        }
        return result;

    }

    /**
     * サンプル
     *
     * @param args
     *             引数
     */
    public static void main(final String[] args) {

        final String message = KmgMessageUtils.getMessage(KmgMsgMessageTypes.KMGMSGE11100, new Object[] {
            "test2136"
        });
        System.out.println(message);

    }
}
