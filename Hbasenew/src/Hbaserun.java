
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class Hbaserun {
	private static HTable table;
	public static void main(String[] args) throws IOException {
		// You need a configuration object to tell the client where to connect.
		// When you create a HBaseConfiguration, it reads in whatever you've set
		// into your hbase-site.xml and in hbase-default.xml, as long as these
		// can be found on the CLASSPATH
		Configuration config = HBaseConfiguration.create();
		table = new HTable(config, "twitterdata");
		//Query by rowkey
		System.out.println("input query string:");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		String userinput = bufferRead.readLine();
		Get g = new Get(Bytes.toBytes(userinput));
		Result r = table.get(g);
		byte[] tweet_id = r.getValue(Bytes.toBytes("family"),Bytes.toBytes("tweet_id"));
		String tweet_idStr = Bytes.toString(tweet_id);
		byte[] sentiment = r.getValue(Bytes.toBytes("family"),Bytes.toBytes("sentiment"));
		String sentimentStr = Bytes.toString(sentiment);
		byte[] tweet = r.getValue(Bytes.toBytes("family"),Bytes.toBytes("tweet"));
		String tweetStr = Bytes.toString(tweet);
		System.out.println(tweet_idStr + " " + sentimentStr + " "+ tweetStr);
		// //Query by scanning
		// Scan s = new Scan();
		// s.addColumn(Bytes.toBytes("family"));
		// ResultScanner scanner = table.getScanner(s);
		// try {
		// for (Result rr = scanner.next(); rr != null; rr = scanner.next()) {
		// // print out the row we found and the columns we were looking
		// // for
		// System.out.println("Found row: " + rr);
		// }

		} 
}
