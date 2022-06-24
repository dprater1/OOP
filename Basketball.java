import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.*;
import java.util.Scanner;
public class Basketball {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("What is the first name of the player you'd like to search?");
        String first = in.nextLine();
        System.out.println("What is the last name of the player you'd like to search?");
        String last = in.nextLine();
        
        PlayerData data = new PlayerData(first, last);
        
    }

    

}

class PlayerData{
    private String firstName;
    private String lastName;
    public PlayerData(){
        this.firstName = "";
        this.lastName = "";
    }
    public PlayerData(String first, String last){
        this.firstName = first;
        this.lastName = last;
    }

    public String PPG(){
    final String lebronurl = getInfo(firstName, lastName);
    
    try {
        final Document docu = Jsoup.connect(lebronurl).get();
        //tr:eq(0)
        for(Element row : docu.select("table#per_game > tfoot > tr:eq(0)")){
                final String ticker = row.select("[data-stat=pts_per_g]").text();
            System.out.println(ticker + " | ");
            }
    }
   catch (Exception ex){
     ex.printStackTrace();
    }
    return "";
}

    public String getInfo(String first, String last){
        String baseURL = "https://www.basketball-reference.com/players/";
        String lastN;
        if(last.length() < 5) lastN = last.substring(0, last.length()).toLowerCase();
        else lastN = last.substring(0,5).toLowerCase();
        String lastLet = last.substring(0,1).toLowerCase();
        String firsttwo = first.substring(0,2).toLowerCase();

        String finalUrl = baseURL + lastLet + "/" + lastN + firsttwo + "01.html";

        return finalUrl;

    }


}

