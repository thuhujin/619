import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.io.Closeable;

public class Main {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public void main() throws Exception {
    try {
      // this will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // setup the connection with the DB.
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/?"
              + "user=jin&password=19920204");
      // statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // resultSet gets the result of the SQL query
      resultSet = statement
          .executeQuery("select * from mysqlDB.twittertable limit 10");
      writeResultSet(resultSet);
      return;
    } catch (Exception e) {
      throw e;
    }
  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    // now get some metadata from the database
    System.out.println("The columns in the table are: ");
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // resultSet is initialised before the first data set
    while (resultSet.next()) {
      // it is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g., resultSet.getSTring(2);
      String tweet_id = resultSet.getString("");
      String user_id = resultSet.getString("");
      Date date = resultSet.getDate("");
      String twitter = resultSet.getString("");
      System.out.println("user_id: " + user_id);
    }
  }
}



  // // you need to close all three to make sure
  // private void close() {
  //   close(resultSet);
  //   close(statement);
  //   close(connect);
  // }
  // private void close(Closeable c) {
  //   try {
  //     if (c != null) {
  //       c.close();
  //     }
  //   } catch (Exception e) {
  //   // don't throw now as it might leave following closables in undefined state
  //   }
  // }
