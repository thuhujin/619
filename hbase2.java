import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseConnector {
public static void main(String[] args) throws IOException {
// You need a configuration object to tell the client where to connect.
// When you create a HBaseConfiguration, it reads in whatever you've set
// into your hbase-site.xml and in hbase-default.xml, as long as these
// can be found on the CLASSPATH
Configuration config = HBaseConfiguration.create();

// This instantiates an HTable object that connects you to the
// "twitterdata" table.
HTable table = new HTable(config, "twitterdata");


//Query by rowkey

Get g = new Get(Bytes.toBytes("452163813807116288"));
Result r = table.get(g);
byte[] value = r.getValue(Bytes.toBytes("family"));
// If we convert the value bytes, we should get back 'Some Value', the
// value we inserted at this location.
String valueStr = Bytes.toString(value);
System.out.println("GET: " + valueStr);

//Query by scanning
//HBase is not good for scanning, 
Scan s = new Scan();
s.addColumn(Bytes.toBytes("family"));
ResultScanner scanner = table.getScanner(s);
try {
for (Result rr = scanner.next(); rr != null; rr = scanner.next()) {
// print out the row we found and the columns we were looking
// for
System.out.println("Found row: " + rr);
}

// The other approach is to use a foreach loop. Scanners are
// iterable!
// for (Result rr : scanner) {
// System.out.println("Found row: " + rr);
// }
} finally {
// Make sure you close your scanners when you are done!
// Thats why we have it inside a try/finally clause
scanner.close();
}
}
}
