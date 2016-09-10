package io.vertx.example;

import javax.annotation.PostConstruct;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.templ.FreeMarkerTemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.vertx.ext.web.Router.router;

@Component
public class AppVerticle {

    private Vertx vertx;
    private FreeMarkerTemplateEngine engine;

    @Autowired
    public AppVerticle(final Vertx vertx, final FreeMarkerTemplateEngine engine) {
        this.vertx = vertx;
        this.engine = engine;
    }

    @PostConstruct
    public void start() throws Exception {
        final Router router = router(vertx);
        router.route().handler(BodyHandler.create());

        router.getWithRegex("/|/index.html")
          .produces("text/html")
          .blockingHandler(routingContext -> engine.render(routingContext, "templates/index/index.ftl", res -> {
              if (res.succeeded()) {
                  routingContext.response().end(res.result());
              } else {
                  routingContext.fail(res.cause());
              }
          }));

        // Serve the static pages
        router.route().handler(StaticHandler.create());
        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }
}