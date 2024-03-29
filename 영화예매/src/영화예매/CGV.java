package 영화예매;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CGV extends JFrame{
	private final static String address = "http://www.cgv.co.kr/reserve/show-times/";//파싱하고자 하는 사이트
	String str = new String();
	String[] title = {"서울", "경기", "인천", "강원", "대전/충청", "대전/충청", "대구", "부산/울산", "부산/울산", "경상", "광주/전라/제주", "광주/전라/제주", "광주/전라/제주"};
	String[] titles = {"서울", "경기", "인천", "강원", "대전/충청", "대구", "부산/울산", "경상", "광주/전라/제주"};
	int[] titlenum = {1, 2, 202, 12, 3, 205, 11, 5, 207, 204, 4, 6, 206};
	
	String[] s;
	String[] s1;
	
	JLabel[] lbl = null;
	
	JPanel panelseoul = new JPanel();
	JPanel panelgye = new JPanel();
	JPanel panelincheon = new JPanel();
	JPanel panelgangwon = new JPanel();
	JPanel panelchung = new JPanel();
	JPanel paneldaegu = new JPanel();
	JPanel panelbusan = new JPanel();
	JPanel panelcurrent = new JPanel();
	JPanel paneljeju = new JPanel();//지역마다 패널들 지정
	JTabbedPane tp = new JTabbedPane();//패널전환할 사용

	public CGV(User user)  {
		setTitle("영화 예매 프로그램");
		try {
			Document doc = Jsoup.connect(address).get();
			Elements contents = doc.select("div").select("#contents").select("script");
			
			str = contents.toString();
			String[] regioncode = str.split("RegionCode\":");
			String[] theatercode = str.split("TheaterCode\":");//해당하는 var 부분 가져옴
			String[] theatername = str.split("TheaterName\":");
			
			s = new String[regioncode.length-2];//극장 지역 위치(ex)서울, 경기)
			s1 = new String[theatercode.length-1];//극장 코드 번호
			String[] s2 = new String[theatername.length-1];//극장 시네마 위치
			
			for(int i = 0; i < s.length; i++) {
				s[i] = regioncode[i+1].substring(regioncode[i+1].indexOf("\"")+1, regioncode[i+1].indexOf("\","));//대분류(ex) 서울 : 01);
				
				for(int j = 0; j < titlenum.length; j++) {
					if(s[i].substring(0,1).equals("0")) {
						s[i] = s[i].substring(1);
					}
					if (s[i].indexOf(",") >= 0){
						s[i] = s[i].substring(0,1);
					}
					if(s[i].equals(Integer.toString(titlenum[j]))){
						s[i] = title[j];
					}
				}
			}//지역명 가져옴
			
			for(int i = 1; i < titles.length; i++) {
				for(int j = 0; j < s.length; j++) {
					if(s[j].equals(titles[i])) {
						s[j] = " ";
						break;
					}
				}
			}
			s[0] = " ";
			int j = 0;
			for(int i = 0; i < s.length; i++) {
				if(!s[i].equals(" ")) {
					s[j] = s[i];
					j++;
				}
			}//지역명 1개씩 삭제(더 가져옴)
			
			for(int i = 0; i < s1.length; i++) {
				s1[i] = theatercode[i+1].substring(1,5);//영화관 코드
			}//영화관 코드 가져오기
			for(int i = 0; i < s2.length; i++) {
				s2[i] = theatername[i+1].substring(theatername[i+1].indexOf("\"")+1, theatername[i+1].indexOf("\","));//영화관 명
			}//영화관 명 가져오기
			
			makebtn(s,s1,s2, user);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void makebtn(String[] s, String[] s1, String[] s2, User user) {
		JLabel[] lbl = new JLabel[s2.length];//버튼 생성(영화관 갯수에 맞춰 크기 지정)
		JButton[] close = new JButton[lbl.length];
		
		for(int i = 0; i < close.length; i++) {
			close[i] = new JButton("닫기");
			close[i].setForeground(new Color(0xffffff));
			close[i].setBorderPainted(false);
			close[i].setContentAreaFilled(false);
		}
		
		for(int i = 0; i < s2.length; i++) {
			lbl[i] = new JLabel(s2[i]);// + "(" + s1[i] + ")");
			lbl[i].setForeground(new Color(0xffffff));
		}
		
		for(int i = 0; i < s2.length; i++) {
			JLabel lbl2 = new JLabel(" / ");
			
			if(s[i].equals("서울")) {
				lbl[i].setForeground(new Color(0xffffff));
				panelseoul.add(lbl[i]);
				lbl2.setForeground(new Color(0xffffff));
				panelseoul.add(lbl2);
			}
			else if(s[i].equals("경기")) {
				lbl[i].setForeground(new Color(0xffffff));
				panelgye.add(lbl[i]);
				lbl2.setForeground(new Color(0xffffff));
				panelgye.add(lbl2);
			}
			else if(s[i].equals("인천")) {
				lbl[i].setForeground(new Color(0xffffff));
				panelincheon.add(lbl[i]);
				lbl2.setForeground(new Color(0xffffff));
				panelincheon.add(lbl2);
			}
			else if(s[i].equals("강원")) {
				lbl[i].setForeground(new Color(0xffffff));
				panelgangwon.add(lbl[i]);
				lbl2.setForeground(new Color(0xffffff));
				panelgangwon.add(lbl2);
			}
			else if(s[i].equals("대전/충청")) {
				lbl[i].setForeground(new Color(0xffffff));
				panelchung.add(lbl[i]);
				lbl2.setForeground(new Color(0xffffff));
				panelchung.add(lbl2);
			}
			else if(s[i].equals("대구")) {
				lbl[i].setForeground(new Color(0xffffff));
				paneldaegu.add(lbl[i]);
				lbl2.setForeground(new Color(0xffffff));
				paneldaegu.add(lbl2);
			}
			else if(s[i].equals("부산/울산")) {
				lbl[i].setForeground(new Color(0xffffff));
				panelbusan.add(lbl[i]);
				lbl2.setForeground(new Color(0xffffff));
				panelbusan.add(lbl2);
			}
			else if(s[i].equals("경상")) {
				lbl[i].setForeground(new Color(0xffffff));
				panelcurrent.add(lbl[i]);
				lbl2.setForeground(new Color(0xffffff));
				panelcurrent.add(lbl2);
			}
			else if(s[i].equals("광주/전라/제주")) {
				lbl[i].setForeground(new Color(0xffffff));
				paneljeju.add(lbl[i]);
				lbl2.setForeground(new Color(0xffffff));
				paneljeju.add(lbl2);
			}
			
			panelseoul.add(close[0], BorderLayout.SOUTH);
			panelseoul.setForeground(new Color(0xffffff));
			panelseoul.setBackground(new Color(0x000000));
			
			panelgye.add(close[1]);
			panelgye.setForeground(new Color(0xffffff));
			panelgye.setBackground(new Color(0x000000));
			
			panelincheon.add(close[2]);
			panelincheon.setForeground(new Color(0xffffff));
			panelincheon.setBackground(new Color(0x000000));
			
			panelgangwon.add(close[3]);
			panelgangwon.setForeground(new Color(0xffffff));
			panelgangwon.setBackground(new Color(0x000000));
			
			panelchung.add(close[4]);
			panelchung.setForeground(new Color(0xffffff));
			panelchung.setBackground(new Color(0x000000));
			
			paneldaegu.add(close[5]);
			paneldaegu.setForeground(new Color(0xffffff));
			paneldaegu.setBackground(new Color(0x000000));
			
			panelbusan.add(close[6]);
			panelbusan.setForeground(new Color(0xffffff));
			panelbusan.setBackground(new Color(0x000000));
			
			panelcurrent.add(close[7]);
			panelcurrent.setForeground(new Color(0xffffff));
			panelcurrent.setBackground(new Color(0x000000));
			
			paneljeju.add(close[8]);
			paneljeju.setForeground(new Color(0xffffff));
			paneljeju.setBackground(new Color(0x000000));
		}//패널에 버튼추가
		
		for(int i = 0; i < lbl.length; i++) {
	         lbl[i].addMouseListener(new java.awt.event.MouseAdapter() {
	               @Override
	               public void mouseClicked(MouseEvent e) {
	                       String spli = ((JLabel) e.getSource()).getText();
	                       for(int j = 0; j < s2.length; j++) {
	                      if(spli.equals(s2[j])) {
	                         new CGVParsing(s, s1, s2, j, user);
	                         System.out.println(s[j] + "\n" + s1[j] + "\n" + s2[j]);
	                         dispose();
	                      }
	                   }
	               }
	           });
	      }
		tp.add("서울",panelseoul);
		tp.add("경기",panelgye);
		tp.add("인천",panelincheon);
		tp.add("강원",panelgangwon);
		tp.add("대전/충청",panelchung);
		tp.add("대구",paneldaegu);
		tp.add("부산/울산",panelbusan);
		tp.add("경상",panelcurrent);
		tp.add("광주/전라/제주",paneljeju);//각 영화관 지역별 패널 추가
		tp.setBackground(Color.white);
		add(tp);
		
		for(int i = 0; i < lbl.length; i++) {
			close[i].addActionListener(e -> {
				dispose();
			});
		}
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}