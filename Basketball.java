import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.*;

public class Basketball {
    public static void main(String args[]){

        final String lebronurl = "https://www.basketball-reference.com/players/j/jamesle01.html";
    
            try {
                final Document docu = Jsoup.connect(lebronurl).get();

                for(Element row : docu.select("table#per_game > tfoot > tr")){
                        final String ticker = row.select("[data-stat=pts_per_g]").text();
                    System.out.println(ticker);
                    break;
                    }
            }
           catch (Exception ex){
             ex.printStackTrace();
            }
           

    }
    private String team;
    

    public Basketball(){
        this.team = "";
       
    }

    public Basketball(String player){
        this.team = "";
        
    }

    public void setTeam(String team){
        this.team = team;
    }
    public String getTeam(){
        return team;
    }
    
    

}

class Player extends Basketball{
    
   
    private String name;
    private int rings;
    private int MVPs;
    
    public Player(){
        this.name = "";
        this.rings = 0;
        this.MVPs = 0;
    }
    public Player(String player){
        this.name = player;
        this.rings = 0;
        this.MVPs = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


}

