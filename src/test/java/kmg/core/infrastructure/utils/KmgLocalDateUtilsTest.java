package kmg.core.infrastructure.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGローカル日付ユーティリティテスト<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgLocalDateUtilsTest {

    /**
     * formatYyyyMmDd メソッドのテスト - nullの場合（Date）
     */
    @Test
    public void testFormatYyyyMmDd_nullDate() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final Date testTarget = null;

        /* テスト対象の実行 */
        final String actual = KmgLocalDateUtils.formatYyyyMmDd(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * formatYyyyMmDd メソッドのテスト - nullの場合（LocalDate）
     */
    @Test
    public void testFormatYyyyMmDd_nullLocalDate() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final LocalDate testTarget = null;

        /* テスト対象の実行 */
        final String actual = KmgLocalDateUtils.formatYyyyMmDd(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * formatYyyyMmDd メソッドのテスト - 正常な日付の場合（Date）
     */
    @Test
    public void testFormatYyyyMmDd_validDate() {

        /* 期待値の定義 */
        final String expected = "2023/04/01";

        /* 準備 */
        final LocalDate date       = LocalDate.of(2023, 4, 1);
        final Date      testTarget = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        /* テスト対象の実行 */
        final String actual = KmgLocalDateUtils.formatYyyyMmDd(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "正しい日付文字列が返されるべき");

    }

    /**
     * formatYyyyMmDd メソッドのテスト - 正常な日付の場合（LocalDate）
     */
    @Test
    public void testFormatYyyyMmDd_validLocalDate() {

        /* 期待値の定義 */
        final String expected = "2023/04/01";

        /* 準備 */
        final LocalDate testTarget = LocalDate.of(2023, 4, 1);

        /* テスト対象の実行 */
        final String actual = KmgLocalDateUtils.formatYyyyMmDd(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "正しい日付文字列が返されるべき");

    }

    /**
     * from メソッドのテスト - nullの場合
     */
    @Test
    public void testFrom_null() {

        /* 期待値の定義 */
        final LocalDate expected = null;

        /* 準備 */
        final Date testTarget = null;

        /* テスト対象の実行 */
        final LocalDate actual = KmgLocalDateUtils.from(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * from メソッドのテスト - 正常な日付の場合
     */
    @Test
    public void testFrom_validDate() {

        /* 期待値の定義 */
        final LocalDate expected = LocalDate.of(2023, 4, 1);

        /* 準備 */
        final LocalDate date       = LocalDate.of(2023, 4, 1);
        final Date      testTarget = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        /* テスト対象の実行 */
        final LocalDate actual = KmgLocalDateUtils.from(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "正しい日付が返されるべき");

    }

    /**
     * parseYyyyMmDd メソッドのテスト - 空文字の場合
     */
    @Test
    public void testParseYyyyMmDd_empty() {

        /* 期待値の定義 */
        final LocalDate expected = null;

        /* 準備 */
        final String testTarget = "";

        /* テスト対象の実行 */
        final LocalDate actual = KmgLocalDateUtils.parseYyyyMmDd(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空文字の場合はnullを返すべき");

    }

    /**
     * parseYyyyMmDd メソッドのテスト - nullの場合
     */
    @Test
    public void testParseYyyyMmDd_null() {

        /* 期待値の定義 */
        final LocalDate expected = null;

        /* 準備 */
        final String testTarget = null;

        /* テスト対象の実行 */
        final LocalDate actual = KmgLocalDateUtils.parseYyyyMmDd(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * parseYyyyMmDd メソッドのテスト - 正常な日付文字列の場合
     */
    @Test
    public void testParseYyyyMmDd_validDate() {

        /* 期待値の定義 */
        final LocalDate expected = LocalDate.of(2023, 4, 1);

        /* 準備 */
        final String testTarget = "2023/04/01";

        /* テスト対象の実行 */
        final LocalDate actual = KmgLocalDateUtils.parseYyyyMmDd(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "正しい日付が返されるべき");

    }
}
