package kmg.core.infrastructure.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMG配列ユーティリティテスト<br>
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
public class KmgArrayUtilsTest {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgArrayUtilsTest() {

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
        final Object[] testTarget = null;

        /* テスト対象の実行 */
        final boolean actual = KmgArrayUtils.isEmpty(testTarget);

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
        final Object[] testTarget = {
            "test"
        };

        /* テスト対象の実行 */
        final boolean actual = KmgArrayUtils.isEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "要素がある場合はfalseを返すべき");

    }

    /**
     * isEmpty メソッドのテスト - 準正常系:空配列の場合
     *
     * @since 0.1.0
     */
    @Test
    public void testIsEmpty_semiEmptyArray() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final Object[] testTarget = {};

        /* テスト対象の実行 */
        final boolean actual = KmgArrayUtils.isEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空配列の場合はtrueを返すべき");

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
        final Object[] testTarget = null;

        /* テスト対象の実行 */
        final boolean actual = KmgArrayUtils.isNotEmpty(testTarget);

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
        final Object[] testTarget = {
            "test"
        };

        /* テスト対象の実行 */
        final boolean actual = KmgArrayUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "要素がある場合はtrueを返すべき");

    }

    /**
     * isNotEmpty メソッドのテスト - 準正常系:空配列の場合
     *
     * @since 0.1.0
     */
    @Test
    public void testIsNotEmpty_semiEmptyArray() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final Object[] testTarget = {};

        /* テスト対象の実行 */
        final boolean actual = KmgArrayUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空配列の場合はfalseを返すべき");

    }
}
