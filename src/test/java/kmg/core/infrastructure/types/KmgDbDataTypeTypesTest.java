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
 * @sine 0.1.0
 *
 * @version 0.1.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgDbDataTypeTypesTest {

    /**
     * get メソッドのテスト - 正常系：値の取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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
     * getDefault メソッドのテスト - 正常系：デフォルト値の取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    @Test
    public void testGetDefault_normalValue() {

        /* 期待値の定義 */
        final KmgDbDataTypeTypes expected = KmgDbDataTypeTypes.NONE;

        /* テスト対象の実行 */
        final KmgDbDataTypeTypes actual = KmgDbDataTypeTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getDetail メソッドのテスト - 正常系：詳細情報の取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    @Test
    public void testGetDetail_normalValue() {

        /* 期待値の定義 */
        final String expected = "4バイト整数";

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.INTEGER;

        /* テスト対象の実行 */
        final String actual = testType.getDetail();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "詳細情報が一致しません");

    }

    /**
     * getDisplayName メソッドのテスト - 正常系：表示名の取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    @Test
    public void testGetDisplayName_normalValue() {

        /* 期待値の定義 */
        final String expected = "4バイト整数";

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.INTEGER;

        /* テスト対象の実行 */
        final String actual = testType.getDisplayName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "表示名が一致しません");

    }

    /**
     * getEnum メソッドのテスト - 正常系：存在する値の取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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
     * getEnum メソッドのテスト - 準正常系：存在しない値の取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    @Test
    public void testGetEnum_semiNonExistingValue() {

        /* 期待値の定義 */
        final KmgDbDataTypeTypes expected = KmgDbDataTypeTypes.NONE;

        /* 準備 */
        final String testValue = "存在しない値";

        /* テスト対象の実行 */
        final KmgDbDataTypeTypes actual = KmgDbDataTypeTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "存在しない値の場合、NONEが返されること");

    }

    /**
     * getInitValue メソッドのテスト - 正常系：初期値の取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    @Test
    public void testGetInitValue_normalValue() {

        /* 期待値の定義 */
        final KmgDbDataTypeTypes expected = KmgDbDataTypeTypes.NONE;

        /* テスト対象の実行 */
        final KmgDbDataTypeTypes actual = KmgDbDataTypeTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * getKey メソッドのテスト - 正常系：キーの取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    @Test
    public void testGetKey_normalValue() {

        /* 期待値の定義 */
        final String expected = "4バイト整数";

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.INTEGER;

        /* テスト対象の実行 */
        final String actual = testType.getKey();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "キーが一致しません");

    }

    /**
     * getType メソッドのテスト - 正常系：BIG_DECIMAL型の型情報取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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
        Assertions.assertEquals(expected, actual, "BIG_DECIMAL型の型情報が一致しません");

    }

    /**
     * getType メソッドのテスト - 正常系：DATE型の型情報取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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
        Assertions.assertEquals(expected, actual, "DATE型の型情報が一致しません");

    }

    /**
     * getType メソッドのテスト - 正常系：INTEGER型の型情報取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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
        Assertions.assertEquals(expected, actual, "INTEGER型の型情報が一致しません");

    }

    /**
     * getType メソッドのテスト - 正常系：NONE型の型情報取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    @Test
    public void testGetType_normalNone() {

        /* 期待値の定義 */
        final Type expected = null;

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.NONE;

        /* テスト対象の実行 */
        final Type actual = testType.getType();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "NONE型の型情報が一致しません");

    }

    /**
     * getType メソッドのテスト - 正常系：TIME型の型情報取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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
        Assertions.assertEquals(expected, actual, "TIME型の型情報が一致しません");

    }

    /**
     * toString メソッドのテスト - 正常系：INTEGER型の文字列表現の取得
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
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
