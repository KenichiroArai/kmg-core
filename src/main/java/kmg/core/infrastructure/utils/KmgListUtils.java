package kmg.core.infrastructure.utils;

import java.util.List;

/**
 * KMGリストユーティリティ<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
public final class KmgListUtils {

    /**
     * 対象が空か<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @param target
     *               対象
     *
     * @return true：空、false：空ではない
     */
    public static boolean isEmpty(final List<?> target) {

        boolean result = true;

        if (target == null) {

            return result;

        }

        if (target.isEmpty()) {

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
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @param target
     *               対象
     *
     * @return true：空ではない、false：空
     */
    public static boolean isNotEmpty(final List<?> target) {

        final boolean result = !KmgListUtils.isEmpty(target);
        return result;

    }

    /**
     * デフォルトコンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private KmgListUtils() {

        // 処理無し
    }
}
