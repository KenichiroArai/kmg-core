package kmg.core.infrastructure.utils;

/**
 * KMG配列ユーティリティ<br>
 *
 * @author KenichiroArai
 *
 * @sine 0.1.0
 *
 * @version 0.1.0
 */
public final class KmgArrayUtils {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     */
    private KmgArrayUtils() {

        // 処理無し
    }

    /**
     * 対象が空か<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @param target
     *               対象
     *
     * @return true：空、false：空ではない
     */
    public static boolean isEmpty(final Object[] target) {

        boolean result = true;

        if (target == null) {

            return result;

        }

        if (target.length == 0) {

            return result;

        }

        result = false;
        return result;

    }

    /**
     * 対象が空ではないか<br>
     *
     * @author KenichiroArai
     *
     * @sine 0.1.0
     *
     * @version 0.1.0
     *
     * @param target
     *               対象
     *
     * @return true：空ではない、false：空
     */
    public static boolean isNotEmpty(final Object[] target) {

        final boolean result = !KmgArrayUtils.isEmpty(target);
        return result;

    }
}
