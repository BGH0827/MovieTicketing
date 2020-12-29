package 영화예매;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MegaBox {
   String address = "https://www.megabox.co.kr/theater/list";
   String[] str = new String[8];
   String[] strs = new String[8];
   public MegaBox(User user) {
      try {
         Document doc = Jsoup.connect(address).get();
         Elements content = doc.select("div").select("button.sel-city");
         
         int idx = 0;
         for(Element e : content) {
            str[idx] = e.text().toString();
            idx++;
         }
         
         idx = 0;
         Elements contents = doc.select("div.theater-list");
         for(Element es : contents) {
            strs[idx] = es.text().toString();
            idx++;
         }
         
         //makebtn(str, strs, s2, user);
         /*String[] seoul = strs[0].split(" ");
         String[] gye = strs[1].split(" ");
         String[] incheon = strs[2].split(" ");
         String[] chung = strs[3].split(" ");
         String[] busan = strs[4].split(" ");
         String[] geonla = strs[5].split(" ");
         String[] gangwon  = strs[6].split(" ");
         String[] jeju = strs[7].split(" ");
         for(int i = 0; i < seoul.length; i++) {
            System.out.println(seoul[i]);
         }*/
         
         idx = 0;
         Elements contentss = doc.select("div.theater-list").select("li");
         for(Element ess : contentss) {
            System.out.println("https://www.megabox.co.kr/theater/time?brchNo=" + ess.attr("data-brch-no"));
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}