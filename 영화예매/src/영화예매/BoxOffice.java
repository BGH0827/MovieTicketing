package 영화예매;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BoxOffice extends JFrame {
	static int sel;
	String[] title = {"순위", "영화 제목", "개봉일", "누적관객수"};
	String[][] strss = new String[10][4];
	JTable table;
	JScrollPane scroll;
	JButton btn = new JButton("닫기");
	
	public BoxOffice(int num, String address) {
		try {
			   Document doc = Jsoup.connect(address).timeout(12000).get();
			   Elements maincontents;
			   
			   if(num == 0) {
				   maincontents = doc.select("weeklyBoxOffice");
				   setTitle("주간박스오피스");
			   }
			   else {
				   maincontents = doc.select("dailyBoxOffice");
				   setTitle("일간박스오피스");
			   }
			   Elements contents = maincontents.select("movieNm");
			   
			   int idx = 0;
			   for(Element element : contents) {
				   if(idx < 10) {
					   strss[idx][1] = element.text().toString();
					   strss[idx][0] = Integer.toString(idx+1);
				   }
				   else {
					   break;
				   }
				   idx++;
			   }
			   
			   Elements content = maincontents.select("openDt");
			   idx = 0;
			   for(Element element : content) {
				   if(idx < 10) {
					   strss[idx][2] = element.text().toString();
				   }
				   else {
					   break;
				   }
				   idx++;
			   }
			   
			   Elements cont = maincontents.select("audiAcc");
			   idx = 0;
			   for(Element element : cont) {
				   if(idx < 10) {
					   strss[idx][3] = element.text().toString();
				   }
				   else {
					   break;
				   }
				   idx++;
			   }
			   
		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		DefaultTableModel model = new DefaultTableModel(strss,title);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		add(scroll);
		add(btn, BorderLayout.SOUTH);
		btn.addActionListener(e -> {
			dispose();
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setSize(450,225);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}

class BoxOfficeSelect{
	private static String addressday = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=1d9aa39c4936f28e82c30d3b8bb836f1&targetDt=";//파싱하고자 하는 사이트
	private static String addressweek = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml?key=1d9aa39c4936f28e82c30d3b8bb836f1&targetDt=";//파싱하고자 하는 사이트
	String address = "";
	Time time = new Time();
	public BoxOfficeSelect(int num) {
		if(num == 0) {
			address+=addressweek;
			address+=Integer.toString(time.getnum()-7);
		}
		else {
			address+=addressday;
			address+=Integer.toString(time.getnum());
		}
		new BoxOffice(num, address);
	}
}

class Time{
	int num;
	public Time() {
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyyMMdd");
			
		Date time = new Date();
					
		String time1 = format1.format(time);
		int num = Integer.parseInt(time1)-1;
		setnum(num);
	}
	public int getnum() {
		return num;
	}
	public void setnum(int num) {
		this.num = num;
	}
}

class BoxOfficeChoice extends JFrame {
	JButton[] btn = new JButton[3];

	public BoxOfficeChoice() {
	setTitle("영화 예매 프로그램");
	
	btn[0] = new JButton("일간");
	btn[1] = new JButton("주간");
	btn[2] = new JButton("닫기");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	btn[0].addActionListener(e ->{
		new BoxOfficeSelect(1);
	});
	
	btn[1].addActionListener(e ->{
		new BoxOfficeSelect(0);
	});

	btn[2].addActionListener(e ->{
		dispose();
	});
	
	panel1.setLayout(new GridLayout(0,2));
	panel2.setLayout(new GridLayout(0,1));
	panel1.add(btn[0]);
	panel1.add(btn[1]);
	panel2.add(btn[2],"South");
	add(panel1);
	add(panel2,BorderLayout.SOUTH);
	setSize(300, 200);
	setLocationRelativeTo(null);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}