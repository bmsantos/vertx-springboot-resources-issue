package io.vertx.example;


import io.vertx.core.Vertx;
import io.vertx.ext.web.templ.FreeMarkerTemplateEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    Vertx vertx;
    FreeMarkerTemplateEngine engine;

    @Bean
    public Vertx getVertxInstance() {
        if (this.vertx == null) {
            this.vertx = Vertx.vertx();
        }
        return this.vertx;
    }

    @Bean
    public FreeMarkerTemplateEngine templateEngine() {
        if (engine == null) {
            engine = FreeMarkerTemplateEngine.create();
        }
        return engine;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}