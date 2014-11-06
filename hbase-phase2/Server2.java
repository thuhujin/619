package hbase;
import java.util.Deque;	
//import java.util.HashMap;
import java.util.Map;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
//import io.undertow.server.handlers.cache.CacheHandler;
import io.undertow.server.handlers.cache.DirectBufferCache;
//import io.undertow.util.Headers;

public class Server2 {
    final static String info = "Noidea,5083-4407-3648,8876-1303-8769,1354-6111-8069";
    static DirectBufferCache dcache = null;
//    @SuppressWarnings("rawtypes")
//	static Map<String, String> hm = null;
    
    public static void main(final String[] args) {
    	String dnsname = args[0];
    	String sqlpw = args[1];
    	final long st=System.nanoTime();
    	final ConSql cs = new ConSql(sqlpw);
//    	hm = new HashMap<String, String>();
//    	dcache = new DirectBufferCache(512, 200, 1073741824);

    	Undertow server = Undertow.builder()
                .addHttpListener(80, "54.173.2.112")
                .setHandler(new HttpHandler() {
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                    	long end1=System.nanoTime();
                    	Map<String, Deque<String>> mp = exchange.getQueryParameters();
                    	String time = mp.get("tweet_time").getFirst();
                    	String userid = mp.get("userid").getFirst();
                    	time = time.replace(" ", "+");
//                    	String cans = hm.get(userid+time);
//                    	if (cans != null){
//                    		exchange.getResponseSender().send(cans);
//                    	}else{
                    		String ans = info+"\n"+cs.getTweet(userid, time)+"\n";
//                        	exchange.getResponseSender().send(ans);
//                        	hm.put(userid+time, ans);
                        	exchange.getResponseSender().send(ans);
                        	long end2=System.nanoTime();
                        	System.out.println(Long.toString((end1-st)/1000000)+","+Long.toString((end2-end1)/1000000));
//                    	}
                    }
                }).build();
        server.start();
    }
}