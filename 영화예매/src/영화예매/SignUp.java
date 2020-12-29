package 영화예매;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignUp extends JFrame {
	private JPanel contentPane;
	User user = new User();
	String gender = new String();
	
	public SignUp() {
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextField name = new JTextField();
		name.setFont(new Font("굴림", Font.PLAIN, 40));
		name.setBounds(400, 100, 400, 50);
		panel.add(name);
		
		JTextField id = new JTextField();
		id.setFont(new Font("굴림", Font.PLAIN, 40));
		id.setBounds(400, 180, 400, 50);
		panel.add(id);
		
		JTextField password = new JTextField();
		password.setFont(new Font("굴림", Font.PLAIN, 40));
		password.setBounds(400, 260, 400, 50);
		panel.add(password);
		
		JTextField age = new JTextField();
		age.setFont(new Font("굴림", Font.PLAIN, 40));
		age.setBounds(400, 340, 400, 50);
		panel.add(age);
		
		JLabel label0 = new JLabel("회원가입");
		label0.setFont(new Font("굴림", Font.PLAIN, 40));
		label0.setBounds(20, 0, 250, 60);
		panel.add(label0);
		
		JLabel label1 = new JLabel("이름 :");
		label1.setFont(new Font("굴림", Font.PLAIN, 20));
		label1.setBounds(200, 100, 200, 50);
		panel.add(label1);
		
		JLabel label2 = new JLabel("아이디 :");
		label2.setFont(new Font("굴림", Font.PLAIN, 20));
		label2.setBounds(200, 180, 200, 50);
		panel.add(label2);
		
		JLabel label3 = new JLabel("비밀번호 :");
		label3.setFont(new Font("굴림", Font.PLAIN, 20));
		label3.setBounds(200, 260, 200, 50);
		panel.add(label3);
		
		JLabel label4 = new JLabel("나이 :");
		label4.setFont(new Font("굴림", Font.PLAIN, 20));
		label4.setBounds(200, 340, 200, 50);
		panel.add(label4);
		
		JLabel label5 = new JLabel("성별 :");
		label5.setFont(new Font("굴림", Font.PLAIN, 20));
		label5.setBounds(200, 420, 200, 50);
		panel.add(label5);
		
		JRadioButton radio1 = new JRadioButton("남");
		radio1.setFont(new Font("굴림", Font.PLAIN, 20));
		radio1.setBounds(400, 435, 58, 23);
		
		JRadioButton radio2 = new JRadioButton("여");
		radio2.setFont(new Font("굴림", Font.PLAIN, 20));
		radio2.setBounds(500, 436, 58, 23);
		
		ButtonGroup groupRd = new ButtonGroup();
		groupRd.add(radio1);
		groupRd.add(radio2);
		panel.add(radio1);
		panel.add(radio2);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 500, 984, 161);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JButton button1 = new JButton("완료");
		button1.setBounds(350, 50, 100, 50);
		panel1.add(button1);
		
		button1.addActionListener(e -> {
			user.setname(name.getText());
			user.setid(id.getText());
			user.setpassword(password.getText());
			user.setage(Integer.parseInt(age.getText()));
			
			if(radio1.isSelected()) {
				gender = "남";
			}
			else {
				gender = "여";
			}
			user.setgender(gender);
			
			UserDAO userdao = new UserDAO();
			userdao.join(user);
			dispose();
			new Menu1();
		});
		
		JButton button2 = new JButton("취소");
		button2.setBounds(550, 50, 100, 50);
		panel1.add(button2);
		
		button2.addActionListener(e -> {
			dispose();
			new Menu1();
		});
		
		panel.setBackground(new Color(0xffffcc));
		panel1.setBackground(new Color(0Xffffcc));
		setTitle("영화관 예매 프로그램");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
