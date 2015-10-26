import java.util.Scanner;


public class Game {

	public static void main(String[] args) {
		GameAux.intro();
		Scanner keyboard=new Scanner(System.in);
		Player p1=new Player(GameAux.setPlayer(keyboard, 1)); //p1 will represent player 1
		Player p2=new Player(GameAux.setPlayer(keyboard, 2));//p2 will represent player 2
		Die d1=new Die();//d1 will represent die 1 in the game
		Die d2=new Die();//d2 will represent die 2 in the game
		GameAux.gameLoop(p1, p2, d1, d2, keyboard);
		String winner=winningName(p1.getScore(),p1.getName(),p2.getScore(),p2.getName());
		GameAux.report(GameAux.getWinner(p1, p2, winner));	
	}
	
//Here you will implement the rest of the methods described in the assignment prompt.
	
	

}
