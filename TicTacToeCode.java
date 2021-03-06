import java.util.*;

public class TicTacToe
{
  
  private String Winner = "";
  
  
  private boolean gameOver = false;
  private String playerMarker = "X";
  private String player2Marker = "O";
  

  Scanner in = new Scanner(System.in);
  

  private String a="1",b="2",c="3",d="4",e="5",f="6",g="7",h="8",i="9";
  
  private String Line="";
  
  HashMap<Integer,String> game = new HashMap<Integer,String>();
 
  public static void main(String[] args) {
    
    System.out.println("Willkommen bei TicTacToe.");
    
    new TicTacToe();
  }
  
  public TicTacToe(){
    Line = line(9);
    
    game.put(1,a);
    game.put(2,b);
    game.put(3,c);
    game.put(4,d);
    game.put(5,e);
    game.put(6,f);
    game.put(7,g);
    game.put(8,h);
    game.put(9,i);
    
    while(!gameOver) {
      buildBoard();
    
      playerGuess();
      gameOver=GameOver();
      if (gameOver==true) {
        break;
      }
      System.out.println();
      buildBoard();
      Player2Guess();
      
      gameOver = GameOver();
      System.out.println();
      
      }
    buildBoard();
    

    if (Winner.equals("Player")) {
      System.out.println("Spieler 1 hat gewonnen!");
      return;
    }if(Winner.equals("Player2")) {
      System.out.println("Spieler 2 hat gewonnen!");
      return;
    }
    else  {
      System.out.println("Gleichstand!");
      
    }
    
  }
  
  public boolean GameOver() {
    int index = 1;
    int x=index;
    for(int i = 1;i<=3;i++) {
      if(game.get(x).equals(game.get(x+3)) && game.get(x+3).equals(game.get(x+6))){
        whoWon(x);
        return true;
      
      }else {
        x++;
      }
    }
    x=index;
    
    for(int i=1;i<=3;i++) {
      
      if(game.get(x).equals(game.get(x+1)) && game.get(x+1).equals(game.get(x+2))) {
        whoWon(x);
        return true;
      
      }else {
        x+=3;
      }
    }
    if(game.get(1).equals(game.get(5)) && game.get(5).equals(game.get(9))){
      whoWon(1);
      return true;
    
    }if (game.get(3).equals(game.get(5)) && game.get(5).equals(game.get(7))){
      whoWon(3);
      return true;
    
    }

    else {
      int counter = 0;
      for(int i =1; i<=9; i++) {
        if(game.get(i).equals("X") || game.get(i).equals("O")) {
          counter++;
          }
        
        }
       if(counter==9) {
         return true;
       }
    return false;
    }
  }
   
  
  public String line(int x){
     
    if(x==0) {
      Line +="\n";
      return Line;
      
    }
    else{
    Line += "-";
    return line(x-1);
    }
    
  }
  
  

  public int Player2Guess() {

    int guess;
    System.out.println("Bitte setze nun eine Zahl von 1-9 um auf dem Board zu platzieren.");
    guess = in.nextInt();
    
    if ((guess>9) || (guess<1)) {
      System.out.println("Error: Du musst eine Nummer zwischen 1-9 eingeben");
      return playerGuess();
    }else if(isOkToPlay(guess)) {
      placeMarker(guess,player2Marker);
      return 1;
    }else {
      System.out.println("Error: Diese Position ist belegt!");
      return playerGuess();
    }
  }
  
  
  public void placeMarker(int a,String marker) {
    game.replace(a, marker);
  }
  
  
  public boolean isOkToPlay(int a) {
    if (game.get(a).equals("X") || game.get(a).equals("O")) {
      return false;
    }else {
      return true;
    }
  }
  
  
  public int playerGuess() {
    int guess;
    System.out.println("Bitte setze nun eine Zahl von 1-9 um auf dem Board zu platzieren.");
    guess = in.nextInt();
    
    if ((guess>9) || (guess<1)) {
      System.out.println("Error: Du musst eine Nummer zwischen 1-9 eingeben");
      return playerGuess();
    }else if(isOkToPlay(guess)) {
      placeMarker(guess,playerMarker);
      return 1;
    }else {
      System.out.println("Error: Diese Position ist belegt!");
      return playerGuess();
    }
  }
  
  
  public void whoWon(int x) {
    if (game.get(x).equals("X")) {
      Winner = "Player";
    }if(game.get(x).equals("O")) {
      Winner = "Player2";
    }
  }
  
  
  public void buildBoard() {
        System.out.print(game.get(1)+" | "+game.get(2)+" | "+game.get(3)+"\n"+
         Line+
         game.get(4)+" | "+game.get(5)+ " | "+game.get(6)+"\n"+
         Line+
         game.get(7)+" | "+game.get(8)+" | "+game.get(9)+"\n");
  }
}
