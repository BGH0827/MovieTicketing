package 영화예매;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JPasswordField textField2;
	int result;
	User user = new User();
	
	public Login() {
		setTitle("영화 예매 프로그램");
		add(textField2 = new JPasswordField());
		textField2.setEchoChar('*');
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("로그인");
		label1.setFont(new Font("굴림", Font.PLAIN, 30));
		label1.setBounds(12, 10, 111, 42);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("아이디 :");
		label2.setBounds(101, 131, 100, 35);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("비밀번호 :");
		label3.setBounds(101, 218, 100, 35);
		contentPane.add(label3);
		
		textField1 = new JTextField();
		textField1.setBounds(202, 131, 200, 35);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JPasswordField();
		textField2.setColumns(10);
		textField2.setBounds(202, 218, 200, 35);
		contentPane.add(textField2);
		
		JButton button1 = new JButton("로그인");
		button1.setBounds(101, 360, 97, 23);
		contentPane.add(button1);
		
		button1.addActionListener(e -> {
		user.setid(textField1.getText());
		user.setpassword(textField2.getText());
		UserDAO userdao = new UserDAO();
		result = userdao.login(user.getid(), user.getpassword());
		if(result == 1) {
			dispose();
			new Menu2(user);
		}
		else if(result == 0){
			//알림창 띄우기(비밀번호 불일치)
		}
		else if(result == -1){
			//알림창 띄우기(아이디 없음)
		}
		else {
			//디비오류
		}
	});
		
		JButton button2 = new JButton("취소");
		button2.setBounds(305, 360, 97, 23);
		contentPane.add(button2);
		
		button2.addActionListener(e ->{
			dispose();
			new Menu1();
		});
		contentPane.setBackground(new Color(0xffffcc));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
