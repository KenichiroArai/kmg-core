package kmg.core.infrastructure.types;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kmg.core.infrastructure.type.KmgString;

/**
 * KMGＤＢ型の種類のテスト<br>
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
public class KmgDbDataTypeTypesTest {

    /**
     * get メソッドのテスト - 正常系：値の取得
     */
    @Test
    public void testGet_normalValue() {

        /* 期待値の定義 */
        final String expected = "4バイト整数";

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.INTEGER;

        /* テスト対象の実行 */
        final String actual = testType.get();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系：存在する値の取得
     */
    @Test
    public void testGetEnum_normalExistingValue() {

        /* 期待値の定義 */
        final KmgDbDataTypeTypes expected = KmgDbDataTypeTypes.INTEGER;

        /* 準備 */
        final String testValue = "4バイト整数";

        /* テスト対象の実行 */
        final KmgDbDataTypeTypes actual = KmgDbDataTypeTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getName メソッドのテスト - 正常系：名称の取得
     */
    @Test
    public void testGetName_normalValue() {

        /* 期待値の定義 */
        final String expected = "4バイト整数";

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.INTEGER;

        /* テスト対象の実行 */
        final String actual = testType.getName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "名称が一致しません");

    }

    /**
     * getType メソッドのテスト - 正常系：BigDecimal型の取得
     */
    @Test
    public void testGetType_normalBigDecimal() {

        /* 期待値の定義 */
        final Type expected = BigDecimal.class;

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.BIG_DECIMAL;

        /* テスト対象の実行 */
        final Type actual = testType.getType();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "型が一致しません");

    }

    /**
     * getType メソッドのテスト - 正常系：LocalDate型の取得
     */
    @Test
    public void testGetType_normalDate() {

        /* 期待値の定義 */
        final Type expected = LocalDate.class;

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.DATE;

        /* テスト対象の実行 */
        final Type actual = testType.getType();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "型が一致しません");

    }

    /**
     * getType メソッドのテスト - 正常系：Integer型の取得
     */
    @Test
    public void testGetType_normalInteger() {

        /* 期待値の定義 */
        final Type expected = Integer.class;

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.INTEGER;

        /* テスト対象の実行 */
        final Type actual = testType.getType();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "型が一致しません");

    }

    /**
     * getType メソッドのテスト - 正常系：LocalDateTime型の取得
     */
    @Test
    public void testGetType_normalTime() {

        /* 期待値の定義 */
        final Type expected = LocalDateTime.class;

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.TIME;

        /* テスト対象の実行 */
        final Type actual = testType.getType();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "型が一致しません");

    }

    /**
     * getValue メソッドのテスト - 正常系：値の取得
     */
    @Test
    public void testGetValue_normalValue() {

        /* 期待値の定義 */
        final String expected = "4バイト整数";

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.INTEGER;

        /* テスト対象の実行 */
        final String actual = testType.getValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * toString メソッドのテスト - 正常系：INTEGER型の文字列表現の取得
     */
    @Test
    public void testToString_normalInteger() {

        /* 期待値の定義 */
        final String expected = "4バイト整数";

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.INTEGER;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "INTEGERの場合、'4バイト整数'が返されること");

    }

    /**
     * toString メソッドのテスト - 正常系：LONG型の文字列表現の取得
     */
    @Test
    public void testToString_normalLong() {

        /* 期待値の定義 */
        final String expected = "8バイト整数";

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.LONG;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "LONGの場合、'8バイト整数'が返されること");

    }

    /**
     * toString メソッドのテスト - 正常系：NONE型の文字列表現の取得
     */
    @Test
    public void testToString_normalNone() {

        /* 期待値の定義 */
        final String expected = KmgString.EMPTY;

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.NONE;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "NONEの場合、空文字が返されること");

    }
}
