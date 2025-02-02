package kmg.core;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;

/**
 * KMG<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SpringBootApplication
public class KmgCoreApplication {

    /** メッセージリソース */
    @Autowired
    private MessageSource messageSource;

    /**
     * ほげ
     *
     * @param params
     *               パラメータ
     */
    public void hoge(final String[] params) {

        System.out.println(this.messageSource.getMessage("KMGMSGE11100", params, Locale.JAPANESE));

    }

    /**
     * エントリポイント<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param args
     *             オプション
     */
    public static void main(final String[] args) {

        @SuppressWarnings("resource")
        final ConfigurableApplicationContext ctx = SpringApplication.run(KmgCoreApplication.class, args);

        final KmgCoreApplication app = ctx.getBean(KmgCoreApplication.class);
        app.hoge(new String[] {
            "21:48:52"
        });

        ctx.close();

    }

}
