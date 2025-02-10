package kmg.core.infrastructure.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMG配列ユーティリティテスト<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
public class KmgArrayUtilsTest {

    /**
     * isEmpty メソッドのテスト - 空配列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsEmpty_emptyArray() {

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
     * isEmpty メソッドのテスト - 要素がある場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsEmpty_hasElements() {

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
     * isEmpty メソッドのテスト - nullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsEmpty_null() {

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
     * isNotEmpty メソッドのテスト - 空配列の場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsNotEmpty_emptyArray() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final Object[] testTarget = {};

        /* テスト対象の実行 */
        final boolean actual = KmgArrayUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空配列の場合はfalseを返すべき");

    }

    /**
     * isNotEmpty メソッドのテスト - 要素がある場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsNotEmpty_hasElements() {

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
     * isNotEmpty メソッドのテスト - nullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsNotEmpty_null() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final Object[] testTarget = null;

        /* テスト対象の実行 */
        final boolean actual = KmgArrayUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はfalseを返すべき");

    }
}
