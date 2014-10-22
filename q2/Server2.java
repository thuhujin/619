import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConSql {
	
	Connection conn = null;
	
	public ConSql(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tweet_db", "root" , "db15319root");
        	System.out.println("connect mysql");
		} catch (Exception ex) {
        	System.out.println("SQLException: " + ex.getMessage());
        }
	}
	
	public String getTweet(String user_id, String time) {
        Statement stmt = null;
        ResultSet rs = null;
        String answer = "";
        try {
        	stmt = conn.createStatement();
        	rs = stmt.executeQuery("SELECT tweet_id, score, content FROM tweets WHERE user_id = "+user_id+" AND time = '"+time+"'");
        	while(rs.next()){
        	    String res = rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+"\n";         
                answer += res;
        	}
        } catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}
		return answer;
	}
}