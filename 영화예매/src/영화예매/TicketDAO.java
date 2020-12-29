package 영화예매;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TicketDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	String[] arr = new String[7];
	
	public TicketDAO() {
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
	  
	  public void Insert(Ticket ticket) {
	      String SQL = "insert into ticketing values(?, ?, ?, ?, ?, ?, ?)";
	      try {
	         pstmt = conn.prepareStatement(SQL);
	         pstmt.setString(1, ticket.getId());
	         pstmt.setString(2, ticket.getCinemaType());
	         pstmt.setString(3, ticket.getMovieName());
	         pstmt.setInt(4, ticket.getMoviePrice());
	         pstmt.setString(5, ticket.getRunningTime());
	         pstmt.setInt(6, ticket.getPerson());
	         pstmt.setString(7, ticket.getSeat());
	         pstmt.executeUpdate();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	   }
	  
	  public ArrayList<ReservationConfirm> print(Ticket ticket) {
		  ArrayList<ReservationConfirm> list = new ArrayList<ReservationConfirm>();
		  String SQL = "select * from ticketing";
		  ReservationConfirm.model.setNumRows(0);
		  try {
			  pstmt = conn.prepareStatement(SQL);
			  rs = pstmt.executeQuery();
			  
			  while(rs.next()) {
				  ticket.setId(rs.getString("id"));
				  arr[0] = ticket.getId();
				  ticket.setCinemaType(rs.getString("cinematype"));
				  arr[1] = ticket.getCinemaType();
				  ticket.setMovieName(rs.getString("moviename"));
				  arr[2] = ticket.getMovieName();
				  ticket.setMoviePrice(rs.getInt("movieprice"));
				  arr[3] = "" + ticket.getMoviePrice();
				  ticket.setRunningTime(rs.getString("runningtime"));
				  arr[4] = ticket.getRunningTime();
				  ticket.setPerson(rs.getInt("person"));
				  arr[5] = "" + ticket.getPerson();
				  ticket.setSeat(rs.getString("seat"));
				  arr[6] = ticket.getSeat();
				  ReservationConfirm.model.addRow(arr);
			  }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  return list;
	  }
	  
	  public int delete(int n) {
		  String SQL = "delete from ticketing where id = ? and MovieName = ?";
		  int result = 0;
		  
		  try {
			  pstmt = conn.prepareStatement(SQL);
			  ReservationConfirm.n = ReservationConfirm.table.getSelectedRow();
			  pstmt.setString(1, "" + ReservationConfirm.model.getValueAt(n, 0));
			  pstmt.setString(2, "" + ReservationConfirm.model.getValueAt(n, 2));
			  result = pstmt.executeUpdate();
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  return result;
	  }

	  public int login(String userID, String userPassword) {
			String SQL = "select password from members where id = ?";
			
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