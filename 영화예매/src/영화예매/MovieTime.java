package 영화예매;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MovieTime extends JFrame{
	JLabel lbl,lbl1;
	JButton back = new JButton("극장 선택");
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	
	String str = new String();
	public MovieTime(String theatername, String[][] movieinfo, String[] movieinfomationstring, String[][] wherehow, String address, User user) {
		setTitle(theatername);
		
		JLabel[] movienamelabel = new JLabel[movieinfo.length];
		JButton[] choice = new JButton[movienamelabel.length];
		
		for(int i = 0; i < choice.length; i++) {
			choice[i] = new JButton("선택");
		}
		
		for(int i = 0; i < movieinfo.length; i++) {
			lbl = new JLabel(movieinfo[i][0]);
			movienamelabel[i] = new JLabel(movieinfo[i][1]);
			lbl1 = new JLabel(movieinfo[i][2]);
			panel.add(lbl);
			panel.add(movienamelabel[i]);
			panel.add(lbl1);
			panel.add(choice[i]);
			add(panel, BorderLayout.CENTER);
		}
		panel.setLayout(new GridLayout(movieinfo.length,1));//한줄로 하기

		for(int i = 0; i < movieinfo.length; i++) {
			movienamelabel[i].addMouseListener(new java.awt.event.MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	    			for(int j = 0; j < movieinfo.length; j++) {
	    				if(e.getSource().equals(movienamelabel[j])) {
	    					new CGVInformation(movieinfo[j][1], movieinfomationstring[j], user);
	    				}
	    			}
	            }
			});
		}
			
		for(int i = 0; i < movieinfo.length; i++) {
			choice[i].addActionListener(e -> {
				for(int j = 0; j < movieinfo.length; j++) {
					if(e.getSource().equals(choice[j])) {
						new CGVSelectTime(theatername, movieinfo[j][0], movieinfo[j][1], movieinfo[j][2], address, user);
					}
				}
			});
		}
		
		panel1.add(back);
		add(panel1, BorderLayout.SOUTH);
		
		back.addActionListener(e -> {
			dispose();
			new CGV(user);
		});
		
		int size = 0;
		if(movieinfo.length > 5) {
			size +=100;
		}
		//panel1.setLayout(new FlowLayout());//한줄로 하기
		setSize(500, 300+size);
		setLocationRelativeTo(null);//창가운데 띄우기
		setVisible(true);
	}
}