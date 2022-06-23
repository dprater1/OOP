public class Basketball {
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

