package org.social.campus;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class Runner {
  public static void main(String[] args) {
    final Vertx vertx = Vertx.vertx(new VertxOptions().setClustered(false));

    vertx.deployVerticle(new MainVerticle());
  }
}
