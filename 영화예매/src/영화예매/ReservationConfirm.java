package 영화예매;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ReservationConfirm extends JFrame {
	private JPanel contentPane;
	private String[] colname = {"아이디", "영화관 종류", "영화 이름", "영화 가격", "상영 시간", "표 수", "좌석"};
	public static DefaultTableModel model;
	User user = new User();
	public static JTable table;
	public static int n;
	
	public ReservationConfirm(Ticket ticket) {
		setTitle("영화 예매 프로그램");
		
		model = new DefaultTableModel(colname, 0);
		table = new JTable(model);
		TicketDAO ticketdao = new TicketDAO();
		ticketdao.print(ticket);
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("예매 취소");
		btn1.addActionListener(e -> {
			n = table.getSelectedRow();
			
			System.out.println(model.getValueAt(n, 0));
			ticketdao.delete(n);
			
			DefaultTableModel tm = (DefaultTableModel)table.getModel();
			if(n >= 0 && n < table.getRowCount()) {
				tm.removeRow(n);
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 33, 619, 173);
		getContentPane().add(scrollPane);
		
		btn1.setBounds(172, 396, 97, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("닫기");
		btn2.addActionListener(e ->{
			dispose();
		});
		btn2.setBounds(413, 396, 97, 23);
		contentPane.add(btn2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 494);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}

