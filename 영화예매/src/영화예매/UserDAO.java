package 영화예매;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	 private Connection conn;
	 private PreparedStatement pstmt;
	 private ResultSet rs;
	   
	  public UserDAO() {
	     try {
	        String dbURL = "";
	        String dbID = "";
	        String dbPassword = "";
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
	         pstmt.setString(1, user.getname());
	         pstmt.setString(2, user.getid());
	         pstmt.setString(3, user.getpassword());
	         pstmt.setInt(4, user.getage());
	         pstmt.setString(5, user.getgender());
	         pstmt.executeUpdate();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	   }
	  public int login(String userID, String userPassword) {
			String SQL = "select password from members where id = ?";//한번 꼬아서 사용하기 위해 "?" 사용
			
			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1,  userID);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString(1).equals(userPassword)) {
						return 1; //로그인 성공
					}
					else {
						return 0;//비밀번호 불일치
					}
				}
				return -1; //아이디가 없음
			} catch(Exception e) {
				e.printStackTrace();
			}
			return -2;//데이터베이스 오류
		}
}
