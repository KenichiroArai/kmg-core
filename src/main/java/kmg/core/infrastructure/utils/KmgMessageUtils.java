package kmg.core.infrastructure.utils;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
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

    /** リソースバンドルマップ */
    private static final Map<String, ResourceBundle> bundleMap = new HashMap<>();

    /** プロパティファイル名の配列 */
    private static final String[] PROPERTY_FILES = {
        "messages", "messages-log"
    };

    static {

        for (final String propertyFile : KmgMessageUtils.PROPERTY_FILES) {

            KmgMessageUtils.bundleMap.put(propertyFile, ResourceBundle.getBundle(propertyFile));

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

        // 全てのプロパティファイルから該当するメッセージを探す
        String messagePattern = null;

        for (final ResourceBundle bundle : KmgMessageUtils.bundleMap.values()) {

            try {

                messagePattern = bundle.getString(type.getCode());
                break;

            } catch (@SuppressWarnings("unused") final java.util.MissingResourceException e) {

                // 該当するメッセージが見つからない場合は次のバンドルを探す
                continue;

            }

        }

        // メッセージが見つからない場合は空文字を返す
        if (messagePattern == null) {

            return result;

        }

        // メッセージの引数を置換
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
            "test2150"
        });
        System.out.println(message);

    }
}
