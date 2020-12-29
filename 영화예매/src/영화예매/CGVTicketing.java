package 영화예매;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CGVTicketing extends JFrame{
	Ticket ticket = new Ticket();
	String runningtime, seat;
	int totalprice, price, price1, totalperson;
	Choice personnumber, personnumber1;
	JTextField cardnumber, cardtime;
	JPanel panel,panel1, paneltop;
	JButton btn = new JButton("입력");
	JLabel lbl1 = new JLabel("조조");
	JLabel lbl2 = new JLabel("성인, 청소년 : 6000");
	JLabel lbl3 = new JLabel("일반");
	JLabel lbl4 = new JLabel("성인 : 9000원, 청소년 : 7000원");
	LineBorder lb = new LineBorder(Color.black, 1);
	
	public CGVTicketing(String idstring, String cinematype, String moviename, String timeseat, User user) {
		super("영화 예매 프로그램");
		String runningtime = timeseat.substring(0,timeseat.indexOf("잔"));
		System.out.println(runningtime);
		String seat = timeseat.substring(timeseat.indexOf("잔"));
		System.out.println(seat);
		
		panel = new JPanel();
		panel1 = new JPanel();
		paneltop = new JPanel();
		
		paneltop.setLayout(new GridLayout(0,1));
		if(Integer.parseInt(runningtime.substring(0,2)) <= 10) {
			lbl1.setBorder(lb);
			lbl1.setHorizontalAlignment(JLabel.CENTER);
			paneltop.add(lbl1);
			lbl2.setBorder(lb);
			lbl2.setHorizontalAlignment(JLabel.CENTER);
			paneltop.add(lbl2);
		}
		else {
			lbl3.setBorder(lb);
			lbl3.setHorizontalAlignment(JLabel.CENTER);
			paneltop.add(lbl3);
			lbl4.setBorder(lb);
			lbl4.setHorizontalAlignment(JLabel.CENTER);
			paneltop.add(lbl4);
		}//조조,일반
		panel.setLayout(new GridLayout(0, 2));
		panel.add(new JLabel("성인 인원수", JLabel.CENTER));
		
		personnumber = new Choice();
		for(int i = 0; i < 30; i++) {
			personnumber.addItem(Integer.toString(i));
		}
		panel.add(personnumber);
		
		panel.add(new JLabel("청소년 인원수", JLabel.CENTER));
		personnumber1 = new Choice();
		for(int i = 0; i < 30; i++) {
			personnumber1.addItem(Integer.toString(i));
		}
		panel.add(personnumber1);
		
		if(Integer.parseInt(runningtime.substring(0,2)) <= 10) {
			price  = Integer.parseInt(personnumber.getSelectedItem()) * 6000;
			price1 = Integer.parseInt(personnumber1.getSelectedItem()) * 6000;
		}
		else {
			price  = Integer.parseInt(personnumber.getSelectedItem()) * 9000;
			price1 = Integer.parseInt(personnumber1.getSelectedItem()) * 7000;
		}//조조,일반
		
		panel.add(new JLabel("카드 번호 : ", JLabel.CENTER));
		panel.add(cardnumber = new JTextField());
		
		panel.add(new JLabel("카드 유효기간 : ", JLabel.CENTER));
		panel.add(cardtime = new JTextField());
		
		panel1.setLayout(new GridLayout(0, 1));
		panel1.add(btn);
		
		btn.addActionListener(e -> {
			totalperson = Integer.parseInt(personnumber.getSelectedItem()) + Integer.parseInt(personnumber1.getSelectedItem());
			totalprice = price+price1;
			System.out.println(totalprice);
			
			ticket.setId(idstring);
			ticket.setCinemaType(cinematype);
			ticket.setMovieName(moviename);
			ticket.setRunningTime(runningtime);
			ticket.setPerson(totalperson);
			ticket.setMoviePrice(totalprice);
			new seat(ticket, user);
			//System.out.println("입력완료");
			dispose();
		});
		panel.setBackground(new Color(0xffffff));
		add(panel);
		panel1.setBackground(new Color(0xffffff));
		add(panel1, BorderLayout.SOUTH);
		paneltop.setBackground(new Color(0xffffff));
		add(paneltop, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setLocationRelativeTo(null);//창가운데 띄우기
		setVisible(true);
	}
}