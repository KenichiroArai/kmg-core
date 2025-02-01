package kmg.core.infrastructure.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGリストユーティリティテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgListUtilsTest {

    /**
     * isEmpty メソッドのテスト - 空リストの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsEmpty_emptyList() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final List<?> testTarget = new ArrayList<>();

        /* テスト対象の実行 */
        final boolean actual = KmgListUtils.isEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空リストの場合はtrueを返すべき");

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
        final List<String> testTarget = Arrays.asList("test");

        /* テスト対象の実行 */
        final boolean actual = KmgListUtils.isEmpty(testTarget);

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
        final List<?> testTarget = null;

        /* テスト対象の実行 */
        final boolean actual = KmgListUtils.isEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はtrueを返すべき");

    }

    /**
     * isNotEmpty メソッドのテスト - 空リストの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsNotEmpty_emptyList() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final List<?> testTarget = new ArrayList<>();

        /* テスト対象の実行 */
        final boolean actual = KmgListUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空リストの場合はfalseを返すべき");

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
        final List<String> testTarget = Arrays.asList("test");

        /* テスト対象の実行 */
        final boolean actual = KmgListUtils.isNotEmpty(testTarget);

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
        final List<?> testTarget = null;

        /* テスト対象の実行 */
        final boolean actual = KmgListUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はfalseを返すべき");

    }
}
