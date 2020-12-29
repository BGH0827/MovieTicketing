package 영화예매;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Menu2 extends JFrame{
   JPanel p = new JPanel();
   JButton[] b = new JButton[6];
   Ticket ticket = new Ticket();
   
   public Menu2(User user) {
	  setTitle("영화관 선택");
      setSize(1000, 1000);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      b[0] = new JButton("CGV");
      b[1] = new JButton("메가박스");
      b[2] = new JButton("롯데시네마");
      b[3] = new JButton("박스오피스 순위");
      b[4] = new JButton("예약 확인");
      b[5] = new JButton("닫기");
      
      b[0].addActionListener(e -> {
				dispose();
				new CGV(user);
      });
      b[1].addActionListener(e -> {
			
			dispose();
      });
      b[2].addActionListener(e -> {
			
			dispose();
      });
      b[3].addActionListener(e -> {
			new BoxOfficeChoice();
      });
      b[4].addActionListener(e -> {
			new ReservationConfirm(ticket);
      });
      b[5].addActionListener(e -> {
			dispose();
      });
      for(int i = 0; i < b.length; i++){
            b[i].setFont(new Font("맑은고딕", Font.CENTER_BASELINE, 50));
      }

      p.setLayout(null);
      p.setBackground(Color.black);
      
      for(int i = 0; i < b.length; i++){
            b[i].setBackground(new Color(000, 000, 000));
      }

      for(int i = 0; i < b.length; i++){
            b[i].setBorder(new LineBorder(Color.white, 3));
      }
  
      for(int i = 0; i < b.length; i++) {
         b[i].setForeground(new Color(0xFFFFFF));
      }
      
      for(int i = 0; i < 3; i++) {
         b[i].setBounds(30+(i*320), 100, 280, 280);
      }
      int j = 0;
      for(int i = 3; i < 6; i++) {
         b[i].setBounds(300, 450 + (j*200), 400, 100);
         j++;
      }
      
      for(int i = 0; i < b.length; i++) {
         p.add(b[i]);
      }
      add(p);
      
      setVisible(true);
   }
}