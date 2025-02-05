package kmg.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * KMG<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SpringBootApplication
public class KmgCoreApplication {

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
        ctx.close();

    }

}
