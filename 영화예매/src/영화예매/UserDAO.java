package 영화예매;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	 private Connection conn;
	 private PreparedStatement pstmt;//보안을 위해 사용
	 private ResultSet rs;
	   
	  public UserDAO() {
	     try {
	        String dbURL = "jdbc:mysql://localhost:3306/movie?serverTimezone=UTC";
	        String dbID = "root";
	        String dbPassword = "qorrjsgh1534";
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
	     } catch(Exception e) {
	         e.printStackTrace();
	     }
	   }
	  
	  public void join(User user) {
	      String SQL = "insert into members values(?, ?, ?, ?, ?)";
	      try {
	         pstmt = conn.prepareStatement(SQL);
	         pstmt.setString(1, user.getid());
	         pstmt.setString(2, user.getpassword());
	         pstmt.setString(3, user.getname());
	         pstmt.setInt(4, user.getage());
	         pstmt.setString(5, user.getgender());
	         pstmt.executeUpdate();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	   }
}
