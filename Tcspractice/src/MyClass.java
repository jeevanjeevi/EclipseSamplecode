
import java.util.*;                  
public class MyClass
{

public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
  Player[] player = new Player[4];
  for(int i=0;i<player.length;i++){
    int id=sc.nextInt();
    String cty=sc.next();
    String  side=sc.next();

    double price= sc.nextDouble();
    player[i]=new Player(id,cty,side,price);
  }
  String search= sc.next();
  Player[] players = searchPlayerForMatch(search,player);
  Player temp=null;
  for(int i=0;i<players.length;i++){
    for(int j=i+1;j<players.length;j++){
      if(players[i].getid()>players[j].getid()){
        temp = players[i];
        players[i]= players[j];
        players[j]= temp;
      }
    }
  }
  for(int i=0;i<players.length;i++){
    System.out.println(players[i].getid());
  }
  
}      


public static Player[] searchPlayerForMatch(String search, Player[] players)
{   Player[] p = new Player[0];
   for(int i=0; i<players.length;i++){
     if(players[i].getside().equalsIgnoreCase(search)){
       p =Arrays.copyOf(p ,p.length+1);
       p[p.length-1]=players[i];
     }
   }
 return p;
}
}

class Player
{
private int id;
  private String cty;
  private String side;
  private double price;
  
  public Player(int id, String cty,String side,double price){
    this.id= id;
    this.cty = cty;
    this.side = side;
    this.price = price;
  }
  public int getid(){
    return this.id;
  }
   public String getside(){
    return this.side;
  }
}