import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;

public class WebService extends Verticle {

  public void start() {
    HttpServer server = vertx.createHttpServer();
    
    final BigInteger big = new BigInteger("6876766832351765396496377534476050002970857483815262918450355869850085167053394672634315391224052153");
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    final String info = "NoIdea,5083-4407-3648,8876-1303-8769";

    server.requestHandler(new Handler<HttpServerRequest>() {
        public void handle(HttpServerRequest request) {
          String key = request.params().get("key");
          String ans = (new BigInteger(key)).divide(big).toString();
          request.response().putHeader("Content-Length", ans.length()+58+"");
          ans += "\n"+info+"\n"+sdf.format(new Date())+"\n";
          request.response().write(ans);
          request.response().end();
        }
    });

    server.listen(80);
  }
}