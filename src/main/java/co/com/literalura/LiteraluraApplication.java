package co.com.literalura;

import co.com.literalura.utility.ConstantsUtil;
import co.com.literalura.view.MenuHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
    private final MenuHandler menuHandler;

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            menuHandler.start();
        } catch (Exception e) {
            System.out.println(ConstantsUtil.ERROR_MESSAGE.concat(e.getMessage()));
        }
    }
}
