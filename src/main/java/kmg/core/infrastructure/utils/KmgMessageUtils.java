package kmg.core.infrastructure.utils;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import kmg.core.infrastructure.common.KmgCommonLogMessageTypes;
import kmg.core.infrastructure.common.KmgCommonMessageTypes;
import kmg.core.infrastructure.common.KmgCommonGenMessageTypes;
import kmg.core.infrastructure.type.KmgString;

/**
 * KMGメッセージユーティリティ<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.2.0
 */
public final class KmgMessageUtils {

    /**
     * コード埋め込みフォーマット
     *
     * @since 0.2.0
     */
    private static final String CODE_EMBEDDING_FORMAT = "[%s] %s"; //$NON-NLS-1$

    /**
     * リソースバンドルマップ
     *
     * @since 0.1.0
     */
    private static final Map<String, ResourceBundle> bundleMap;

    /**
     * プロパティファイル名の配列
     *
     * @since 0.1.0
     */
    @SuppressWarnings("nls")
    private static final String[] PROPERTY_FILES = {
        "kmg-core-messages", "kmg-core-messages-log"
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
     * メッセージパターンの引数の数と実際の引数の数が一致しているかチェックする<br>
     *
     * @since 0.1.0
     *
     * @param messagePattern
     *                       メッセージパターン
     * @param messageArgs
     *                       メッセージの引数
     *
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
     * ログメッセージを取得する<br>
     * メッセージタイプに対応するメッセージパターンを取得し、指定された引数で置換します。 このメソッドは {@link #getMessage(KmgCommonMessageTypes, Object[], boolean)} を
     * コード埋め込みフラグをtrueに設定して呼び出す便利メソッドです。
     *
     * @since 0.1.0
     *
     * @param type
     *                    メッセージの種類。対応するリソースからメッセージパターンを取得するために使用されます。
     * @param messageArgs
     *                    メッセージの引数。メッセージパターン内のプレースホルダーを置換するために使用されます。 nullの場合、メッセージパターンをそのまま返します。
     *
     * @return メッセージ。メッセージコードが先頭に埋め込まれます（例：「[E001] エラーメッセージ」）。
     *
     * @see #getMessage(KmgCommonMessageTypes, Object[], boolean)
     * @see KmgCommonGenMessageTypes
     */
    public static String getLogMessage(final KmgCommonLogMessageTypes type, final Object[] messageArgs) {

        /* コード埋め込みフラグをtrueに設定して、メッセージを取得 */
        final String result = KmgMessageUtils.getMessage(type, messageArgs, true);

        return result;

    }

    /**
     * コード埋め込みフラグを設定してメッセージを取得する<br>
     * メッセージタイプに対応するメッセージパターンを取得し、指定された引数で置換します。 コード埋め込みフラグがtrueの場合、メッセージコードをメッセージの先頭に付加します。
     *
     * @since 0.2.0
     *
     * @param type
     *                          メッセージの種類。対応するリソースからメッセージパターンを取得するために使用されます。
     * @param messageArgs
     *                          メッセージの引数。メッセージパターン内のプレースホルダーを置換するために使用されます。 nullの場合、メッセージパターンをそのまま返します。
     *                          空の配列や必要な引数数が不足している場合は、利用可能な引数のみで置換します。
     * @param codeEmbeddingFlag
     *                          コード埋め込みフラグ。trueの場合、メッセージコードをメッセージの先頭に追加します。 例: "[E001] エラーメッセージ"
     *
     * @return メッセージ。メッセージパターンが空の場合は空文字列を返します。
     *
     * @see KmgCommonGenMessageTypes
     * @see #getMessagePattern(KmgCommonMessageTypes)
     * @see #checkMessageArgsCount(String, Object[])
     */
    public static String getMessage(final KmgCommonMessageTypes type, final Object[] messageArgs,
        final boolean codeEmbeddingFlag) {

        String       result         = KmgString.EMPTY;
        final String messagePattern = KmgMessageUtils.getMessagePattern(type);

        /* 引数のチェック */

        // メッセージパターンが空の場合か
        if (KmgString.isEmpty(messagePattern)) {
            // 空の場合

            // 空文字列を返す

            return result;

        }

        // メッセージの引数が空の場合か/
        if (KmgArrayUtils.isEmpty(messageArgs)) {
            // 空の場合

            // メッセージパターンをそのまま返す

            result = messagePattern;
            return result;

        }

        /* メッセージの取得 */

        // メッセージパターンと引数を使用してメッセージをフォーマットする
        String message = MessageFormat.format(messagePattern, messageArgs);

        // コード埋め込みフラグがtrueか
        if (codeEmbeddingFlag) {
            // trueの場合

            // メッセージコードを先頭に付加する
            message = String.format(KmgMessageUtils.CODE_EMBEDDING_FORMAT, type.getCode(), message);

        }

        result = message;
        return result;

    }

    /**
     * メッセージを取得する<br>
     * メッセージタイプに対応するメッセージパターンを取得し、指定された引数で置換します。 このメソッドは {@link #getMessage(KmgCommonMessageTypes, Object[], boolean)} を
     * コード埋め込みフラグをfalseに設定して呼び出す便利メソッドです。
     *
     * @since 0.1.0
     *
     * @param type
     *                    メッセージの種類。対応するリソースからメッセージパターンを取得するために使用されます。
     * @param messageArgs
     *                    メッセージの引数。メッセージパターン内のプレースホルダーを置換するために使用されます。 nullの場合、メッセージパターンをそのまま返します。
     *
     * @return メッセージ。メッセージコードは埋め込まれません。
     *
     * @see #getMessage(KmgCommonMessageTypes, Object[], boolean)
     * @see KmgCommonGenMessageTypes
     */
    public static String getMessage(final KmgCommonGenMessageTypes type, final Object[] messageArgs) {

        /* コード埋め込みフラグをfalseに設定して、メッセージを取得 */
        final String result = KmgMessageUtils.getMessage(type, messageArgs, false);

        return result;

    }

    /**
     * メッセージパターンの引数の数を取得する<br>
     *
     * @since 0.1.0
     *
     * @param messagePattern
     *                       メッセージパターン
     *
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
     * @since 0.1.0
     *
     * @param type
     *             メッセージの種類
     *
     * @return メッセージパターン。見つからない場合は空文字
     */
    public static String getMessagePattern(final KmgCommonMessageTypes type) {

        String result = KmgString.EMPTY;

        /* 引数のチェック */
        if (type == null) {

            return result;

        }

        if (type.getKey() == null) {

            return result;

        }

        /* 全てのプロパティファイルから該当するメッセージパターンを探す */
        for (final ResourceBundle bundle : KmgMessageUtils.bundleMap.values()) {

            try {

                result = bundle.getString(type.getKey());
                return result;

            } catch (@SuppressWarnings("unused") final java.util.MissingResourceException e) {

                // 該当するメッセージが見つからない場合は次のバンドルを探す
                continue;

            }

        }

        return result;

    }

    /**
     * 一般メッセージを取得する<br>
     * メッセージタイプに対応するメッセージパターンを取得し、指定された引数で置換します。 このメソッドは {@link #getMessage(KmgCommonMessageTypes, Object[], boolean)} を
     * コード埋め込みフラグをfalseに設定して呼び出す便利メソッドです。
     *
     * @since 0.2.0
     *
     * @param type
     *                    メッセージの種類。対応するリソースからメッセージパターンを取得するために使用されます。
     * @param messageArgs
     *                    メッセージの引数。メッセージパターン内のプレースホルダーを置換するために使用されます。 nullの場合、メッセージパターンをそのまま返します。
     *
     * @return メッセージ。メッセージコードは埋め込まれません。
     *
     * @see #getMessage(KmgCommonMessageTypes, Object[], boolean)
     * @see KmgCommonGenMessageTypes
     */
    public static String getMsgMessage(final KmgCommonGenMessageTypes type, final Object[] messageArgs) {

        /* コード埋め込みフラグをfalseに設定して、メッセージを取得 */
        final String result = KmgMessageUtils.getMessage(type, messageArgs, false);

        return result;

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
     */
    private KmgMessageUtils() {

        // 処理なし
    }
}
