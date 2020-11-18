package 영화예매;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Menu1 extends JFrame {
	ImageIcon img = new ImageIcon(Menu1.class.getResource("1.jpg"));
	JPanel p = new JPanel();
	JLabel l = new JLabel();
	JButton b1 = new JButton("로그인");
	JButton b2 = new JButton("회원가입");

	public Menu1() {
		setTitle("영화관 예매 프로그램");
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		b1.setFont(new Font("맑은고딕", Font.CENTER_BASELINE, 50));
		b2.setFont(new Font("맑은고딕", Font.CENTER_BASELINE, 50));
		
		p.setLayout(null);
		p.setBackground(Color.black);
		l.setHorizontalAlignment(JLabel.CENTER);
		
		l.setBounds(0, 150, 1000, 100);
		b1.setBounds(350, 450, 300, 100);
		b2.setBounds(350, 650, 300, 100);
		
		b1.setBackground(new Color(000, 000, 000));
		b2.setBackground(new Color(000, 000, 000));
		
		b1.setBorder(new LineBorder(Color.white, 3));
		b2.setBorder(new LineBorder(Color.white, 3));
		
		b1.setForeground(new Color(0xFFFFFF));
		b2.setForeground(new Color(0xFFFFFF));
		
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			
			}
			public void mouseExited(MouseEvent e) {
			
			}
			public void mousePressed(MouseEvent e) {
				new Login();
				dispose();
			}
		});
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				new SignUp();
				dispose();
			}
		});
		l.setIcon(img);
		p.add(l);
		p.add(b1);
		p.add(b2);
		add(p);

		setVisible(true);
	}
}
