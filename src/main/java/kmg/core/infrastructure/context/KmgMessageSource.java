package kmg.core.infrastructure.context;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import kmg.core.infrastructure.common.MessageTypes;

/**
 * KMGメッセージリソース
 */
public class KmgMessageSource {

    /** メッセージリソース */
    @Autowired
    private MessageSource messageSource;

    /**
     * メッセージを取得する
     *
     * @param messageTypes
     *                     メッセージの種類
     * @return メッセージ
     */
    public String getMessage(final MessageTypes messageTypes) {

        final String result = this.getMessage(messageTypes, null);
        return result;

    }

    /**
     * メッセージを取得する
     *
     * @param messageTypes
     *                     メッセージの種類
     * @param args
     *                     引数
     * @return メッセージ
     */
    public String getMessage(final MessageTypes messageTypes, final Object[] args) {

        final String result = this.messageSource.getMessage(messageTypes.getCode(), args, Locale.JAPANESE);
        return result;

    }

}
