package kmg.core.infrastructure.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGＰＯＩユーティリティテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgPoiUtilsTest {

    /**
     * getCell メソッドのテスト - 行が存在しない場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetCell_noRow() throws Exception {

        /* 期待値の定義 */
        final Cell expected = null;

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet = workbook.createSheet();

            /* テスト対象の実行 */
            final Cell actual = KmgPoiUtils.getCell(sheet, 0, 0);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "行が存在しない場合はnullを返すべき");

        }

    }

    /**
     * getStringFormulaValue メソッドのテスト - 空白を返す数式の場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringFormulaValue_blankFormula() throws Exception {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setCellFormula("INDIRECT(\"\"&\"\")");  // BLANKを返す数式
            workbook.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(testTarget);

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringFormulaValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "数式の計算結果（空白）が返されるべき");

        }

    }

    /**
     * getStringFormulaValue メソッドのテスト - 真偽値を返す数式の場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringFormulaValue_booleanFormula() throws Exception {

        /* 期待値の定義 */
        final String expected = "true";

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setCellFormula("TRUE");
            workbook.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(testTarget);

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringFormulaValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "数式の計算結果（真偽値）が返されるべき");

        }

    }

    /**
     * getStringFormulaValue メソッドのテスト - エラーを返す数式の場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringFormulaValue_errorFormula() throws Exception {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setCellFormula("1/0");  // エラーを発生させる数式
            workbook.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(testTarget);

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringFormulaValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "数式の計算結果（エラー）が返されるべき");

        }

    }

    /**
     * getStringFormulaValue メソッドのテスト - _NONEを返す数式の場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringFormulaValue_noneFormula() throws Exception {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setCellFormula("NA()");  // _NONEを返す数式
            workbook.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(testTarget);

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringFormulaValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "数式の計算結果（_NONE）が返されるべき");

        }

    }

    /**
     * getStringFormulaValue メソッドのテスト - 数値を返す数式の場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringFormulaValue_numericFormula() throws Exception {

        /* 期待値の定義 */
        final String expected = "123.0";

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setCellFormula("123.0");
            workbook.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(testTarget);

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringFormulaValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "数式の計算結果（数値）が返されるべき");

        }

    }

    /**
     * getStringFormulaValue メソッドのテスト - 文字列を返す数式の場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringFormulaValue_stringFormula() throws Exception {

        /* 期待値の定義 */
        final String expected = "test";

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setCellFormula("\"test\"");
            workbook.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(testTarget);

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringFormulaValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "数式の計算結果（文字列）が返されるべき");

        }

    }

    /**
     * getStringRangeValue メソッドのテスト - 結合セルの場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringRangeValue_mergedCell() throws Exception {

        /* 期待値の定義 */
        final String expected = "test";

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet     = workbook.createSheet();
            final Row   row       = sheet.createRow(0);
            final Cell  firstCell = row.createCell(0);
            firstCell.setCellValue("test");
            sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 1));
            final Cell testTarget = sheet.getRow(0).createCell(1);

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringRangeValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "結合セルの左上のセルの値が返されるべき");

        }

    }

    /**
     * getStringRangeValue メソッドのテスト - 結合範囲外のセルの場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringRangeValue_outsideMergedRegion() throws Exception {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet     = workbook.createSheet();
            final Row   row       = sheet.createRow(0);
            final Cell  firstCell = row.createCell(0);
            firstCell.setCellValue("test");
            sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 1));  // (0,0)-(1,1)の範囲を結合

            // 結合範囲外のセル(2,2)を作成
            final Row  outsideRow = sheet.createRow(2);
            final Cell testTarget = outsideRow.createCell(2);

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringRangeValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "結合範囲外のセルの場合はnullを返すべき");

        }

    }

    /**
     * getStringValue メソッドのテスト - 真偽値セルの場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringValue_booleanCell() throws Exception {

        /* 期待値の定義 */
        final String expected = "true";

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setCellValue(true);

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "セルの真偽値が文字列として返されるべき");

        }

    }

    /**
     * getStringValue メソッドのテスト - エラーセルの場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringValue_errorCell() throws Exception {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setCellErrorValue(FormulaError.DIV0.getCode());

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "エラーセルの場合はnullを返すべき");

        }

    }

    /**
     * getStringValue メソッドのテスト - 数式セルの場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringValue_formulaCell() throws Exception {

        /* 期待値の定義 */
        final String expected = "123.0";

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setCellFormula("123.0");
            workbook.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(testTarget);

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "数式セルの場合は計算結果が文字列として返されるべき");

        }

    }

    /**
     * getStringValue メソッドのテスト - _NONEセルの場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringValue_noneCell() throws Exception {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            // _NONEタイプのセルを作成（通常は直接作成できないため、この方法で代用）
            testTarget.setBlank();
            testTarget.removeCellComment();

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "_NONEタイプのセルの場合はnullを返すべき");

        }

    }

    /**
     * getStringValue メソッドのテスト - nullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringValue_null() {

        /* 期待値の定義 */
        final String expected = null;

        /* 準備 */
        final Cell testTarget = null;

        /* テスト対象の実行 */
        final String actual = KmgPoiUtils.getStringValue(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はnullを返すべき");

    }

    /**
     * getStringValue メソッドのテスト - 数値セルの場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringValue_numericCell() throws Exception {

        /* 期待値の定義 */
        final String expected = "123.0";

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setCellValue(123.0);

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "セルの数値が文字列として返されるべき");

        }

    }

    /**
     * getStringValue メソッドのテスト - 文字列セルの場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetStringValue_stringCell() throws Exception {

        /* 期待値の定義 */
        final String expected = "test";

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setCellValue("test");

            /* テスト対象の実行 */
            final String actual = KmgPoiUtils.getStringValue(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "セルの文字列値が返されるべき");

        }

    }

    /**
     * isEmptyCell メソッドのテスト - 空のセルの場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsEmptyCell_emptyCell() throws Exception {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setBlank();

            /* テスト対象の実行 */
            final boolean actual = KmgPoiUtils.isEmptyCell(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "空のセルの場合はtrueを返すべき");

        }

    }

    /**
     * isEmptyCell メソッドのテスト - 値が入っているセルの場合
     *
     * @throws Exception
     *                   例外が発生した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsEmptyCell_nonEmptyCell() throws Exception {

        /* 期待値の定義 */
        final boolean expected = false;

        /* 準備 */
        try (Workbook workbook = WorkbookFactory.create(true)) {

            final Sheet sheet      = workbook.createSheet();
            final Row   row        = sheet.createRow(0);
            final Cell  testTarget = row.createCell(0);
            testTarget.setCellValue("test");

            /* テスト対象の実行 */
            final boolean actual = KmgPoiUtils.isEmptyCell(testTarget);

            /* 検証の実施 */
            Assertions.assertEquals(expected, actual, "値が入っているセルの場合はfalseを返すべき");

        }

    }

    /**
     * isEmptyCell メソッドのテスト - nullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsEmptyCell_null() {

        /* 期待値の定義 */
        final boolean expected = true;

        /* 準備 */
        final Cell testTarget = null;

        /* テスト対象の実行 */
        final boolean actual = KmgPoiUtils.isEmptyCell(testTarget);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "nullの場合はtrueを返すべき");

    }
}
