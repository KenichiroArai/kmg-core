package kmg.core.infrastructure.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGローカル日時ユーティリティテスト<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgLocalDateTimeUtilsTest {

    /**
     * formatYyyyMmDdHhMmSsSss メソッドのテスト - 異常系:nullの場合（Date）
     *
     * @since 0.1.0
     */
    @Test
    public void testFormatYyyyMmDdHhMmSsSss_errorNullDate() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final Date testTarget = null;

        /* テスト対象の実行 */
        final String actual = KmgLocalDateTimeUtils.formatYyyyMmDdHhMmSsSss(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * formatYyyyMmDdHhMmSsSss メソッドのテスト - 異常系:nullの場合（LocalDateTime）
     *
     * @since 0.1.0
     */
    @Test
    public void testFormatYyyyMmDdHhMmSsSss_errorNullLocalDateTime() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final LocalDateTime testTarget = null;

        /* テスト対象の実行 */
        final String actual = KmgLocalDateTimeUtils.formatYyyyMmDdHhMmSsSss(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * formatYyyyMmDdHhMmSsSss メソッドのテスト - 正常系:正常な日付の場合（Date）
     *
     * @since 0.1.0
     */
    @Test
    public void testFormatYyyyMmDdHhMmSsSss_normalValidDate() {

        /* 期待値の定義 */
        final String expected = "2023/04/01 12:34:56.000";

        /* 準備 */
        final LocalDateTime dateTime   = LocalDateTime.of(2023, 4, 1, 12, 34, 56);
        final Date          testTarget = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

        /* テスト対象の実行 */
        final String actual = KmgLocalDateTimeUtils.formatYyyyMmDdHhMmSsSss(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "正しい日時文字列が返されるべき");

    }

    /**
     * formatYyyyMmDdHhMmSsSss メソッドのテスト - 正常系:正常な日時の場合（LocalDateTime）
     *
     * @since 0.1.0
     */
    @Test
    public void testFormatYyyyMmDdHhMmSsSss_normalValidLocalDateTime() {

        /* 期待値の定義 */
        final String expected = "2023/04/01 12:34:56.000";

        /* 準備 */
        final LocalDateTime testTarget = LocalDateTime.of(2023, 4, 1, 12, 34, 56);

        /* テスト対象の実行 */
        final String actual = KmgLocalDateTimeUtils.formatYyyyMmDdHhMmSsSss(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "正しい日時文字列が返されるべき");

    }

    /**
     * from メソッドのテスト - 異常系:nullの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testFrom_errorNull() {

        /* 期待値の定義 */
        final LocalDateTime expected = null;

        /* 準備 */
        final Date testTarget = null;

        /* テスト対象の実行 */
        final LocalDateTime actual = KmgLocalDateTimeUtils.from(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * from メソッドのテスト - 正常系:正常な日付の場合
     *
     * @since 0.1.0
     */
    @Test
    public void testFrom_normalValidDate() {

        /* 期待値の定義 */
        final LocalDateTime expected = LocalDateTime.of(2023, 4, 1, 12, 34, 56);

        /* 準備 */
        final LocalDateTime dateTime   = LocalDateTime.of(2023, 4, 1, 12, 34, 56);
        final Date          testTarget = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

        /* テスト対象の実行 */
        final LocalDateTime actual = KmgLocalDateTimeUtils.from(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "正しい日時が返されるべき");

    }

    /**
     * parseYyyyMmDdHhMmSsSss メソッドのテスト - 異常系:nullの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testParseYyyyMmDdHhMmSsSss_errorNull() {

        /* 期待値の定義 */
        final LocalDate expected = null;

        /* 準備 */
        final String testTarget = null;

        /* テスト対象の実行 */
        final LocalDate actual = KmgLocalDateTimeUtils.parseYyyyMmDdHhMmSsSss(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * parseYyyyMmDdHhMmSsSss メソッドのテスト - 正常系:正常な日時文字列の場合
     *
     * @since 0.1.0
     */
    @Test
    public void testParseYyyyMmDdHhMmSsSss_normalValidDateTime() {

        /* 期待値の定義 */
        final LocalDate expected = LocalDate.of(2023, 4, 1);

        /* 準備 */
        final String testTarget = "2023/04/01 12:34:56.789";

        /* テスト対象の実行 */
        final LocalDate actual = KmgLocalDateTimeUtils.parseYyyyMmDdHhMmSsSss(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "正しい日時が返されるべき");

    }

    /**
     * parseYyyyMmDdHhMmSsSss メソッドのテスト - 準正常系:空文字の場合
     *
     * @since 0.1.0
     */
    @Test
    public void testParseYyyyMmDdHhMmSsSss_semiEmpty() {

        /* 期待値の定義 */
        final LocalDate expected = null;

        /* 準備 */
        final String testTarget = "";

        /* テスト対象の実行 */
        final LocalDate actual = KmgLocalDateTimeUtils.parseYyyyMmDdHhMmSsSss(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空文字の場合はnullを返すべき");

    }
}
