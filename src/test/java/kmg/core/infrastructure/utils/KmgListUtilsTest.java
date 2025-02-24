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
 * 
 * @sine 0.1.0
 * 
 * @version 0.1.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgListUtilsTest {

    /**
     * isEmpty メソッドのテスト - 異常系:nullの場合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testIsEmpty_errorNull() {

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
     * isEmpty メソッドのテスト - 正常系:要素がある場合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testIsEmpty_normalHasElements() {

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
     * isEmpty メソッドのテスト - 準正常系:空リストの場合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testIsEmpty_semiEmptyList() {

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
     * isNotEmpty メソッドのテスト - 異常系:nullの場合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testIsNotEmpty_errorNull() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final List<?> testTarget = null;

        /* テスト対象の実行 */
        final boolean actual = KmgListUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はfalseを返すべき");

    }

    /**
     * isNotEmpty メソッドのテスト - 正常系:要素がある場合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testIsNotEmpty_normalHasElements() {

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
     * isNotEmpty メソッドのテスト - 準正常系:空リストの場合
     * 
     * @author KenichiroArai
     * 
     * @sine 0.1.0
     * 
     * @version 0.1.0
     */
    @Test
    public void testIsNotEmpty_semiEmptyList() {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        final List<?> testTarget = new ArrayList<>();

        /* テスト対象の実行 */
        final boolean actual = KmgListUtils.isNotEmpty(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "空リストの場合はfalseを返すべき");

    }
}
