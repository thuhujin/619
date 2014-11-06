//import java.io.BufferedReader;
import java.io.IOException;
//import java.util.Collections;
//import java.util.List;
//import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class ConSql {
	private static HTable table;
	public ConSql(String password){
		try {
			Configuration config = HBaseConfiguration.create();
			table = new HTable(config, "twitterdata2");
			System.out.println("connect Hbase");
		} catch (Exception ex) {
			System.out.println("HbaseException: " + ex.getMessage());}
		}
	public String getTweet(String user_id, String time) throws IOException {
		String answer;
		Get g = new Get(Bytes.toBytes(user_id+":"+time));
//		g.setMaxVersions(5);  // will return last 5 versions of row
		Result r = table.get(g);
		// returns all versions of this column
		byte[] tweet_id = r.getValue(Bytes.toBytes("family"),Bytes.toBytes("tweet_id"));
		String tweet_idStr = Bytes.toString(tweet_id);
		byte[] sentiment = r.getValue(Bytes.toBytes("family"),Bytes.toBytes("sentiment"));
		String sentimentStr = Bytes.toString(sentiment);
		byte[] tweet = r.getValue(Bytes.toBytes("family"),Bytes.toBytes("tweet"));
		String tweetStr = Bytes.toString(tweet);
		answer = tweet_idStr + ":" + sentimentStr + ":"+ tweetStr+"\n";
//		System.out.println(answer);
	
//		List<KeyValue> tweet_id_list = r.getColumn(Bytes.toBytes("family"),Bytes.toBytes("tweet_id"));
////		List<KeyValue> sentiment_list = r.getColumn(Bytes.toBytes("family"),Bytes.toBytes("sentiment"));
////		List<KeyValue> tweet_list = r.getColumn(Bytes.toBytes("family"),Bytes.toBytes("tweet"));
//		List<Integer> num_tweet_id_list = null;
//		for(KeyValue kv : tweet_id_list)
//		{
//			num_tweet_id_list.add(Integer.parseInt(Bytes.toString(kv.getValue())));
//		}
//		Collections.sort(num_tweet_id_list);
//		System.out.println("OK");
//		for(Integer myint : num_tweet_id_list)
//		{
//			System.out.println(myint.toString());
//		}
		return answer;

	}
}
