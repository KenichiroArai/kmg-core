package kmg.core.infrastructure.utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGマップユーティリティテスト<br>
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
public class KmgMapUtilsTest {

    /**
     * isEmpty メソッドのテスト - 空マップの場合
     */
    @Test
    public void testIsEmpty_emptyMap() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final Map<String, String> testTarget = new HashMap<>();

        /* テスト対象の実行 */
        final boolean actual = KmgMapUtils.isEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空マップの場合はtrueを返すべき");

    }

    /**
     * isEmpty メソッドのテスト - 要素がある場合
     */
    @Test
    public void testIsEmpty_hasElements() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final Map<String, String> testTarget = new HashMap<>();
        testTarget.put("key", "value");

        /* テスト対象の実行 */
        final boolean actual = KmgMapUtils.isEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "要素がある場合はfalseを返すべき");

    }

    /**
     * isEmpty メソッドのテスト - nullの場合
     */
    @Test
    public void testIsEmpty_null() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final Map<?, ?> testTarget = null;

        /* テスト対象の実行 */
        final boolean actual = KmgMapUtils.isEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はtrueを返すべき");

    }

    /**
     * isNotEmpty メソッドのテスト - 空マップの場合
     */
    @Test
    public void testIsNotEmpty_emptyMap() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final Map<String, String> testTarget = new HashMap<>();

        /* テスト対象の実行 */
        final boolean actual = KmgMapUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空マップの場合はfalseを返すべき");

    }

    /**
     * isNotEmpty メソッドのテスト - 要素がある場合
     */
    @Test
    public void testIsNotEmpty_hasElements() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final Map<String, String> testTarget = new HashMap<>();
        testTarget.put("key", "value");

        /* テスト対象の実行 */
        final boolean actual = KmgMapUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "要素がある場合はtrueを返すべき");

    }

    /**
     * isNotEmpty メソッドのテスト - nullの場合
     */
    @Test
    public void testIsNotEmpty_null() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final Map<?, ?> testTarget = null;

        /* テスト対象の実行 */
        final boolean actual = KmgMapUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はfalseを返すべき");

    }
}
