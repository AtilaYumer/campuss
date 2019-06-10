package org.social.campus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

public class HttpServerVerticle extends AbstractVerticle {

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    HttpServer server = vertx.createHttpServer();

    Router router = Router.router(vertx);
    router.get("/app/*").handler(StaticHandler.create().setCachingEnabled(false));
    router.get("/").handler(context -> context.reroute("/app/index.html"));

    vertx.createHttpServer().requestHandler(router)
      .listen(8888, http -> {
      if (http.succeeded()) {
        startFuture.complete();
     //   System.out.println("HTTP server started on port 8888");
      } else {
        startFuture.fail(http.cause());
      }
    });
  }
}
