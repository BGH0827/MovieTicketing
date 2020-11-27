package 영화예매;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class seat extends JFrame{
	JButton[][] btn = new JButton[9][14];
	JLabel[] lbl = new JLabel[9];
	JButton input = new JButton("입력");
	JButton close = new JButton("닫기");
	JLabel selectseat = new JLabel("영화관 좌석을 선택하세요.");
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	int x = 60, y = 20;
	int num = 1;
	int count = 0;
	String strr = "";
	String[] str;
	public seat(Movie movie, User user) {
		super("좌석예매");
		str = new String[movie.getmovieperson()];
		
		panel.add(selectseat);
		selectseat.setForeground(Color.white);
		panel.setBackground(Color.BLACK);
		selectseat.setFont(new Font("나눔고딕",Font.BOLD, 15));
		add(panel, BorderLayout.NORTH);
		
		for(int i = 0; i < lbl.length; i++) {
			lbl[i] = new JLabel(Character.toString((char) ((char)65+i)));
			lbl[i].setBounds(20, y, 70, 70);
			lbl[i].setForeground(Color.RED);
			lbl[i].setFont(new Font("나눔고딕",Font.BOLD, 20));
			panel1.add(lbl[i]);
			y+=80;
		}//A~~
		y = 20;
		for(int i = 0; i < btn.length; i++) {
			for(int j = 0; j < btn[i].length; j++) {
				btn[i][j] = new JButton(Integer.toString(num));
				num++;
				btn[i][j].setFont(new Font("나눔고딕",Font.BOLD, 15));
				btn[i][j].setBounds(x, y, 70, 70);
				btn[i][j].setForeground(Color.black);
				btn[i][j].setBackground(Color.gray);
				if(j == 3) {
					x+=20;
				}
				if(j == 9) {
					x+=20;
				}
				x+=80;
				panel1.add(btn[i][j]);
			}
			num = 1;
			x = 60;
			y+= 80;
		}//좌석
		panel1.setLayout(null);
		panel1.setBackground(Color.BLACK);
		add(panel1);
		
		panel2.add(close);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		close.setForeground(Color.white);
		close.setFont(new Font("나눔고딕",Font.BOLD, 20));
		panel2.setBackground(Color.BLACK);
		add(panel2, BorderLayout.SOUTH);
		
		
		count = movie.getmovieperson();
		System.out.println("count : " + count);
		for(int i = 0; i < btn.length; i++) {
			for(int j = 0; j < btn[i].length; j++) {
				final int ii = i;
				final int jj = j;
				btn[i][j].addActionListener(e -> {
					str[2-count] = lbl[ii].getText() + btn[ii][jj].getText();
					count--;
					btn[ii][jj].setText("");
					btn[ii][jj].setBackground(Color.red);
					if(count == 0) {
						int result = JOptionPane.showConfirmDialog(null, "선택하신 좌석으로 예매하시겠습니까?");
						if(result == 0) {
							for(int z = 0; z < str.length; z++) {
								strr += str[z] + ",";
							}
							movie.setmovieseat(strr);
							/*try {
								//new DatabaseMovie(movie,0);
								//new DatabaseMovie(movie,2);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}*/
							dispose();
							System.out.println(strr);
						}
						else {
							dispose();
							new seat(movie, user);
						}
					}
				});
			}
		}
		close.addActionListener(e ->{
			dispose();
		});
		
		setSize(1300,900);
		setLocationRelativeTo(null);//창가운데 띄우기
		setVisible(true);
	}
}