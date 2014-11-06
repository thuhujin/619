import java.util.Deque;
import java.util.Map;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
//import io.undertow.util.Headers;

public class Server2 {
	final static String info = "Noidea,5083-4407-3648,8876-1303-8769";

	public static void main(final String[] args) {
		String dnsname = args[0];
		String sqlpw = args[1];
		final ConSql cs = new ConSql(sqlpw);
		Undertow server = Undertow.builder().addHttpListener(80, dnsname).setHandler(new HttpHandler() {
		@Override
		public void handleRequest(final HttpServerExchange exchange) throws Exception {
			Map<String, Deque<String>> mp = exchange.getQueryParameters();
			String time = mp.get("tweet_time").getFirst();
			time = time.replace(" ", "+");
			String ans = info+"\n"+cs.getTweet(mp.get("userid").getFirst(), time);
			exchange.getResponseSender().send(ans);
		}
		}).build();
	server.start();
	}
}