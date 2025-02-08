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
    private static final Map<String, ResourceBundle> bundleMap;

    /** プロパティファイル名の配列 */
    private static final String[] PROPERTY_FILES = {
        "messages", "messages-log"
    };

    static {

        /* リソースバンドルを読み込み、マップに格納する */
        bundleMap = new HashMap<>();

        // 各プロパティファイルのリソースバンドルを取得し、リソースバンドルマップに登録する
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

        /* 引数のチェック */

        if (type == null) {

            return result;

        }

        if (type.getCode() == null) {

            return result;

        }

        /* 全てのプロパティファイルから該当するメッセージを探す */
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

        // メッセージが見つからないか
        if (messagePattern == null) {
            // メッセージが見つからない場合

            return result;

        }

        /* メッセージの引数を埋め込みメッセージを作成する */

        if (messageArgs == null) {

            result = messagePattern;
            return result;

        }

        if (messageArgs.length <= 0) {

            result = messagePattern;
            return result;

        }

        result = MessageFormat.format(messagePattern, messageArgs);

        return result;

    }

    /**
     * メッセージパターンの引数の数と実際の引数の数が一致しているかチェックする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messagePattern
     *                       メッセージパターン
     * @param messageArgs
     *                       メッセージの引数
     * @return true：一致している、false：一致していない
     */
    public static boolean checkMessageArgsCount(final String messagePattern, final Object[] messageArgs) {

        boolean result = false;

        /* 引数のチェック */
        if (messagePattern == null) {

            return result;

        }

        /* メッセージパターンの引数の数をカウントする */
        int patternCount = 0;

        try {

            final MessageFormat messageFormat = new MessageFormat(messagePattern);
            patternCount = messageFormat.getFormatsByArgumentIndex().length;

        } catch (@SuppressWarnings("unused") final IllegalArgumentException e) {

            return result;

        }

        /* メッセージの引数の数をカウントする */
        int argsCount = 0;

        if (messageArgs != null) {

            argsCount = messageArgs.length;

        }

        /* メッセージパターンの引数の数とメッセージの引数の数が一致しているかチェックする */
        result = patternCount == argsCount;

        return result;

    }

    /**
     * メッセージパターンの引数の数を取得する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messagePattern
     *                       メッセージパターン
     * @return メッセージパターンの引数の数
     */
    public static int getMessageArgsCount(final String messagePattern) {

        int result = 0;

        /* 引数のチェック */
        if (messagePattern == null) {

            return result;

        }

        /* メッセージパターンの引数の数をカウントする */
        try {

            final MessageFormat messageFormat = new MessageFormat(messagePattern);
            result = messageFormat.getFormatsByArgumentIndex().length;

        } catch (@SuppressWarnings("unused") final IllegalArgumentException e) {

            // 処理なし

        }

        return result;

    }

    /**
     * メッセージパターンを取得する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param type
     *             メッセージの種類
     * @return メッセージパターン
     */
    public static String getMessagePattern(final KmgMsgMessageTypes type) {

        String result = KmgString.EMPTY;

        /* 引数のチェック */
        if (type == null) {

            return result;

        }

        if (type.getCode() == null) {

            return result;

        }

        /* 全てのプロパティファイルから該当するメッセージパターンを探す */
        for (final ResourceBundle bundle : KmgMessageUtils.bundleMap.values()) {

            try {

                result = bundle.getString(type.getCode());
                break;

            } catch (@SuppressWarnings("unused") final java.util.MissingResourceException e) {

                // 該当するメッセージが見つからない場合は次のバンドルを探す
                continue;

            }

        }

        return result;

    }
}
