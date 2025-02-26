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
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgMapUtilsTest {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgMapUtilsTest() {

        // 処理なし
    }

    /**
     * isEmpty メソッドのテスト - 異常系:nullの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testIsEmpty_errorNull() {

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
     * isEmpty メソッドのテスト - 正常系:要素がある場合
     *
     * @since 0.1.0
     */
    @Test
    public void testIsEmpty_normalHasElements() {

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
     * isEmpty メソッドのテスト - 準正常系:空マップの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testIsEmpty_semiEmptyMap() {

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
     * isNotEmpty メソッドのテスト - 異常系:nullの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testIsNotEmpty_errorNull() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final Map<?, ?> testTarget = null;

        /* テスト対象の実行 */
        final boolean actual = KmgMapUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はfalseを返すべき");

    }

    /**
     * isNotEmpty メソッドのテスト - 正常系:要素がある場合
     *
     * @since 0.1.0
     */
    @Test
    public void testIsNotEmpty_normalHasElements() {

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
     * isNotEmpty メソッドのテスト - 準正常系:空マップの場合
     *
     * @since 0.1.0
     */
    @Test
    public void testIsNotEmpty_semiEmptyMap() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final Map<String, String> testTarget = new HashMap<>();

        /* テスト対象の実行 */
        final boolean actual = KmgMapUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空マップの場合はfalseを返すべき");

    }
}
