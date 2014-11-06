//import java.io.BufferedReader;
package hbase;
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
	byte[] byte_family = Bytes.toBytes("family");
	public ConSql(String password){
		try {
			// Connect to Hbase
			Configuration config = HBaseConfiguration.create();
			config.clear();
//			config.set("hbase.zookeeper.quorum", "ec2-54-173-2-112.compute-1.amazonaws.com");
			config.set("hbase.zookeeper.quorum", "54.173.2.112");
			config.setInt("hbase.zookeeper.property.clientPort", 2181);
			config.set("hbase.master", "54.173.2.112:60000");
			
			table = new HTable(config, "twitterdata");
			System.out.println("connected to Hbase");
		} catch (Exception ex) {
			System.out.println("HbaseException: " + ex.getMessage());}
		}
	public String getTweet(String user_id, String time) throws IOException {
		String answer;
		// Configure Get Query to Hbase
		Get g = new Get(Bytes.toBytes(user_id+":"+time));
//		g.setMaxVersions(5);  // will return last 5 versions of row
		Result r = table.get(g);
		// returns all versions of this column
		byte[] temp = r.getValue(byte_family, Bytes.toBytes("tweet"));
		answer = Bytes.toString(temp);
		// Compose Return String
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
