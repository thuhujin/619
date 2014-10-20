import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Deque;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class Server {
    final static BigInteger big = new BigInteger("6876766832351765396496377534476050002970857483815262918450355869850085167053394672634315391224052153");
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    final static String info = "NoIdea,5083-4407-3648,8876-1303-8769";

    public static void main(final String[] args) {
    	String dnsname = args[0];
        Undertow server = Undertow.builder()
                .addHttpListener(80, dnsname)
                .setHandler(new HttpHandler() {
                    @Override
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                    	String key = exchange.getQueryParameters().get("key").getFirst();
                    	
                    	String ans = (new BigInteger(key)).divide(big).toString();
                    	ans += "\n"+info+"\n"+sdf.format(new Date())+"\n";
                        exchange.getResponseSender().send(ans);
                    }
                }).build();
        server.start();
    }
}