package kmg.core.infrastructure.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import kmg.core.infrastructure.type.KmgString;

/**
 * KMGローカル日付ユーティリティ<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
public final class KmgLocalDateUtils {

    /**
     * フォーマッタパターン（yyyy/MM/dd）
     *
     * @since 0.1.0
     */
    private static final String FORMATTER_PATTERN_YYYY_MM_DD = "yyyy/MM/dd"; //$NON-NLS-1$

    /**
     * フォーマットyyyy/MM/dd<br>
     * <p>
     * 日付を日付文字列（yyyy/MM/dd）にして返す。
     * </p>
     *
     * @since 0.1.0
     *
     * @param date
     *             日付
     *
     * @return 日付文字列（yyyy/MM/dd）
     */
    public static String formatYyyyMmDd(final Date date) {

        String result = null;

        if (date == null) {

            return result;

        }
        final LocalDate localDate = KmgLocalDateUtils.from(date);
        result = localDate.format(DateTimeFormatter.ofPattern(KmgLocalDateUtils.FORMATTER_PATTERN_YYYY_MM_DD));
        return result;

    }

    /**
     * フォーマットyyyy/MM/dd<br>
     * <p>
     * ローカル日付を日付文字列（yyyy/MM/dd）にして返す。
     * </p>
     *
     * @since 0.1.0
     *
     * @param localDate
     *                  ローカル日付
     *
     * @return 日付文字列（yyyy/MM/dd）
     */
    public static String formatYyyyMmDd(final LocalDate localDate) {

        String result = null;

        if (localDate == null) {

            return result;

        }
        result = localDate.format(DateTimeFormatter.ofPattern(KmgLocalDateUtils.FORMATTER_PATTERN_YYYY_MM_DD));
        return result;

    }

    /**
     * 日付からローカル日付へ/dd<br>
     * <p>
     * 日付をからローカル日付にして返す。
     * </p>
     *
     * @since 0.1.0
     *
     * @param date
     *             日付
     *
     * @return ローカル日付
     */
    public static LocalDate from(final Date date) {

        LocalDate result = null;

        if (date == null) {

            return result;

        }
        result = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return result;

    }

    /**
     * 解析yyyy/MM/dd<br>
     * <p>
     * 日付文字列（yyyy/MM/dd）を解析し、ローカル日付にして返す。
     * </p>
     *
     * @since 0.1.0
     *
     * @param dateStr
     *                日付文字列（yyyy/MM/dd）
     *
     * @return ローカル日付
     */
    public static LocalDate parseYyyyMmDd(final String dateStr) {

        LocalDate result = null;

        if (KmgString.isEmpty(dateStr)) {

            return result;

        }
        result = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(KmgLocalDateUtils.FORMATTER_PATTERN_YYYY_MM_DD));
        return result;

    }

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    private KmgLocalDateUtils() {

        // 処理無し
    }
}
