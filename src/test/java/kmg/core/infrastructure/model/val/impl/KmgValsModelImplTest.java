package kmg.core.infrastructure.model.val.impl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kmg.core.infrastructure.model.val.KmgValDataModel;
import kmg.core.infrastructure.model.val.KmgValsModel;
import kmg.core.infrastructure.types.msg.KmgCoreValMsgTypes;

/**
 * KMGバリデーション集合モデルのテスト<br>
 *
 * @author KenichiroArai
 *
 * @version 0.2.0
 *
 * @since 0.2.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgValsModelImplTest {

    /**
     * addData メソッドのテスト - 正常系：複数のデータが追加される場合
     *
     * @since 0.2.0
     */
    @Test
    public void testAddData_normalMultipleData() {

        /* 期待値の定義 */
        final int     expectedSize       = 3;
        final boolean expectedIsEmpty    = false;
        final boolean expectedIsNotEmpty = true;

        /* 準備 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();
        final KmgValDataModel  testData1  = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ1"
        });
        final KmgValDataModel  testData2  = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ2"
        });
        final KmgValDataModel  testData3  = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ3"
        });

        /* テスト対象の実行 */
        testTarget.addData(testData1);
        testTarget.addData(testData2);
        testTarget.addData(testData3);

        /* 検証の準備 */
        final List<KmgValDataModel> actualDatas      = testTarget.getDatas();
        final boolean               actualIsEmpty    = testTarget.isEmpty();
        final boolean               actualIsNotEmpty = testTarget.isNotEmpty();

        /* 検証の実施 */
        Assertions.assertEquals(expectedSize, actualDatas.size(), "データサイズが一致しません");
        Assertions.assertEquals(expectedIsEmpty, actualIsEmpty, "空状態が正しくありません");
        Assertions.assertEquals(expectedIsNotEmpty, actualIsNotEmpty, "非空状態が正しくありません");
        Assertions.assertEquals(testData1, actualDatas.get(0), "1番目のデータが一致しません");
        Assertions.assertEquals(testData2, actualDatas.get(1), "2番目のデータが一致しません");
        Assertions.assertEquals(testData3, actualDatas.get(2), "3番目のデータが一致しません");

    }

    /**
     * addData メソッドのテスト - 正常系：正常にデータが追加される場合
     *
     * @since 0.2.0
     */
    @Test
    public void testAddData_normalValidData() {

        /* 期待値の定義 */
        final int     expectedSize       = 1;
        final boolean expectedIsEmpty    = false;
        final boolean expectedIsNotEmpty = true;

        /* 準備 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();
        final KmgValDataModel  testData   = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ"
        });

        /* テスト対象の実行 */
        testTarget.addData(testData);

        /* 検証の準備 */
        final List<KmgValDataModel> actualDatas      = testTarget.getDatas();
        final boolean               actualIsEmpty    = testTarget.isEmpty();
        final boolean               actualIsNotEmpty = testTarget.isNotEmpty();

        /* 検証の実施 */
        Assertions.assertEquals(expectedSize, actualDatas.size(), "データサイズが一致しません");
        Assertions.assertEquals(expectedIsEmpty, actualIsEmpty, "空状態が正しくありません");
        Assertions.assertEquals(expectedIsNotEmpty, actualIsNotEmpty, "非空状態が正しくありません");
        Assertions.assertEquals(testData, actualDatas.get(0), "追加されたデータが一致しません");

    }

    /**
     * addData メソッドのテスト - 準正常系：nullデータが渡された場合
     *
     * @since 0.2.0
     */
    @Test
    public void testAddData_semiNullData() {

        /* 期待値の定義 */
        final int     expectedSize    = 0;
        final boolean expectedIsEmpty = true;

        /* 準備 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();

        /* テスト対象の実行 */
        testTarget.addData(null);

        /* 検証の準備 */
        final List<KmgValDataModel> actualDatas   = testTarget.getDatas();
        final boolean               actualIsEmpty = testTarget.isEmpty();

        /* 検証の実施 */
        Assertions.assertEquals(expectedSize, actualDatas.size(), "nullデータが追加されています");
        Assertions.assertEquals(expectedIsEmpty, actualIsEmpty, "空状態が正しくありません");

    }

    /**
     * コンストラクタのテスト - 正常系：正常にインスタンスが作成される場合
     *
     * @since 0.2.0
     */
    @Test
    public void testConstructor_normal() {

        /* 期待値の定義 */
        final boolean expectedIsEmpty = true;

        /* テスト対象の実行 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();

        /* 検証の準備 */
        final boolean               actualIsEmpty = testTarget.isEmpty();
        final List<KmgValDataModel> actualDatas   = testTarget.getDatas();

        /* 検証の実施 */
        Assertions.assertNotNull(testTarget, "インスタンスが作成されていません");
        Assertions.assertEquals(expectedIsEmpty, actualIsEmpty, "初期状態で空でありません");
        Assertions.assertNotNull(actualDatas, "データリストがnullです");

    }

    /**
     * getDatas メソッドのテスト - 正常系：空のリストが返される場合
     *
     * @since 0.2.0
     */
    @Test
    public void testGetDatas_normalEmptyList() {

        /* 期待値の定義 */
        final int expectedSize = 0;

        /* 準備 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();

        /* テスト対象の実行 */
        final List<KmgValDataModel> testResult = testTarget.getDatas();

        /* 検証の準備 */
        final int actualSize = testResult.size();

        /* 検証の実施 */
        Assertions.assertNotNull(testResult, "データリストがnullです");
        Assertions.assertEquals(expectedSize, actualSize, "空リストのサイズが正しくありません");

    }

    /**
     * getDatas メソッドのテスト - 正常系：データが含まれるリストが返される場合
     *
     * @since 0.2.0
     */
    @Test
    public void testGetDatas_normalWithData() {

        /* 期待値の定義 */
        final int expectedSize = 2;

        /* 準備 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();
        final KmgValDataModel  testData1  = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ1"
        });
        final KmgValDataModel  testData2  = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ2"
        });
        testTarget.addData(testData1);
        testTarget.addData(testData2);

        /* テスト対象の実行 */
        final List<KmgValDataModel> testResult = testTarget.getDatas();

        /* 検証の準備 */
        final int actualSize = testResult.size();

        /* 検証の実施 */
        Assertions.assertNotNull(testResult, "データリストがnullです");
        Assertions.assertEquals(expectedSize, actualSize, "データリストのサイズが一致しません");
        Assertions.assertEquals(testData1, testResult.get(0), "1番目のデータが一致しません");
        Assertions.assertEquals(testData2, testResult.get(1), "2番目のデータが一致しません");

    }

    /**
     * isEmpty メソッドのテスト - 正常系：空の場合
     *
     * @since 0.2.0
     */
    @Test
    public void testIsEmpty_normalEmpty() {

        /* 期待値の定義 */
        final boolean expectedIsEmpty = true;

        /* 準備 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();

        /* テスト対象の実行 */
        final boolean testResult = testTarget.isEmpty();

        /* 検証の準備 */
        final boolean actualIsEmpty = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedIsEmpty, actualIsEmpty, "空状態の判定が正しくありません");

    }

    /**
     * isEmpty メソッドのテスト - 正常系：空ではない場合
     *
     * @since 0.2.0
     */
    @Test
    public void testIsEmpty_normalNotEmpty() {

        /* 期待値の定義 */
        final boolean expectedIsEmpty = false;

        /* 準備 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();
        final KmgValDataModel  testData   = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ"
        });
        testTarget.addData(testData);

        /* テスト対象の実行 */
        final boolean testResult = testTarget.isEmpty();

        /* 検証の準備 */
        final boolean actualIsEmpty = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedIsEmpty, actualIsEmpty, "非空状態の判定が正しくありません");

    }

    /**
     * isNotEmpty メソッドのテスト - 正常系：空の場合
     *
     * @since 0.2.0
     */
    @Test
    public void testIsNotEmpty_normalEmpty() {

        /* 期待値の定義 */
        final boolean expectedIsNotEmpty = false;

        /* 準備 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();

        /* テスト対象の実行 */
        final boolean testResult = testTarget.isNotEmpty();

        /* 検証の準備 */
        final boolean actualIsNotEmpty = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedIsNotEmpty, actualIsNotEmpty, "空状態での非空判定が正しくありません");

    }

    /**
     * isNotEmpty メソッドのテスト - 正常系：空ではない場合
     *
     * @since 0.2.0
     */
    @Test
    public void testIsNotEmpty_normalNotEmpty() {

        /* 期待値の定義 */
        final boolean expectedIsNotEmpty = true;

        /* 準備 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();
        final KmgValDataModel  testData   = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ"
        });
        testTarget.addData(testData);

        /* テスト対象の実行 */
        final boolean testResult = testTarget.isNotEmpty();

        /* 検証の準備 */
        final boolean actualIsNotEmpty = testResult;

        /* 検証の実施 */
        Assertions.assertEquals(expectedIsNotEmpty, actualIsNotEmpty, "非空状態での非空判定が正しくありません");

    }

    /**
     * merge メソッドのテスト - 正常系：空のモデルをマージする場合
     *
     * @since 0.2.0
     */
    @Test
    public void testMerge_normalEmptyModel() {

        /* 期待値の定義 */
        final int expectedSize = 1;

        /* 準備 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();
        final KmgValDataModel  testData   = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ"
        });
        testTarget.addData(testData);
        final KmgValsModel testMergeModel = new KmgValsModelImpl();

        /* テスト対象の実行 */
        testTarget.merge(testMergeModel);

        /* 検証の準備 */
        final List<KmgValDataModel> actualDatas = testTarget.getDatas();
        final int                   actualSize  = actualDatas.size();

        /* 検証の実施 */
        Assertions.assertEquals(expectedSize, actualSize, "空モデルマージ後のサイズが正しくありません");
        Assertions.assertEquals(testData, actualDatas.get(0), "元のデータが保持されていません");

    }

    /**
     * merge メソッドのテスト - 正常系：空のターゲットに空ではないモデルをマージする場合
     *
     * @since 0.2.0
     */
    @Test
    public void testMerge_normalEmptyTargetWithData() {

        /* 期待値の定義 */
        final int expectedSize = 2;

        /* 準備 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();

        final KmgValsModel    testMergeModel = new KmgValsModelImpl();
        final KmgValDataModel testData1      = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ1"
        });
        final KmgValDataModel testData2      = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ2"
        });
        testMergeModel.addData(testData1);
        testMergeModel.addData(testData2);

        /* テスト対象の実行 */
        testTarget.merge(testMergeModel);

        /* 検証の準備 */
        final List<KmgValDataModel> actualDatas      = testTarget.getDatas();
        final int                   actualSize       = actualDatas.size();
        final boolean               actualIsEmpty    = testTarget.isEmpty();
        final boolean               actualIsNotEmpty = testTarget.isNotEmpty();

        /* 検証の実施 */
        Assertions.assertEquals(expectedSize, actualSize, "マージ後のサイズが正しくありません");
        Assertions.assertFalse(actualIsEmpty, "マージ後に空状態になっています");
        Assertions.assertTrue(actualIsNotEmpty, "マージ後に非空状態になっていません");
        Assertions.assertEquals(testData1, actualDatas.get(0), "マージされたデータ1が正しくありません");
        Assertions.assertEquals(testData2, actualDatas.get(1), "マージされたデータ2が正しくありません");

    }

    /**
     * merge メソッドのテスト - 正常系：データを含むモデルをマージする場合
     *
     * @since 0.2.0
     */
    @Test
    public void testMerge_normalWithData() {

        /* 期待値の定義 */
        final int expectedSize = 3;

        /* 準備 */
        final KmgValsModelImpl testTarget = new KmgValsModelImpl();
        final KmgValDataModel  testData1  = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ1"
        });
        testTarget.addData(testData1);

        final KmgValsModel    testMergeModel = new KmgValsModelImpl();
        final KmgValDataModel testData2      = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ2"
        });
        final KmgValDataModel testData3      = new KmgValDataModelImpl(KmgCoreValMsgTypes.NONE, new Object[] {
            "テストデータ3"
        });
        testMergeModel.addData(testData2);
        testMergeModel.addData(testData3);

        /* テスト対象の実行 */
        testTarget.merge(testMergeModel);

        /* 検証の準備 */
        final List<KmgValDataModel> actualDatas = testTarget.getDatas();
        final int                   actualSize  = actualDatas.size();

        /* 検証の実施 */
        Assertions.assertEquals(expectedSize, actualSize, "マージ後のサイズが正しくありません");
        Assertions.assertEquals(testData1, actualDatas.get(0), "元のデータが正しくありません");
        Assertions.assertEquals(testData2, actualDatas.get(1), "マージされたデータ1が正しくありません");
        Assertions.assertEquals(testData3, actualDatas.get(2), "マージされたデータ2が正しくありません");

    }

}
