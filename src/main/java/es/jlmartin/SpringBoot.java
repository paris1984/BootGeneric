package es.jlmartin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Anotaciones para iniciar springboot y el contexto de spring
 */
@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ImportResource({"classpath*:Bean.xml"})
public class SpringBoot {

    /**
     * Metodo principal de springboot
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

        SpringApplication.run(SpringBoot.class, args);
    }
}
