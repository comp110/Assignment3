import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
	  
	  // Tests for Die class
	  Tests.testDieRoll();
	  
	  // Once your Die test is passing, uncomment
	  // Each of the following tests one-by-one and
	  // get them to passing, too!
//	  Tests.testRolledOneOnlyOnce();
//    Tests.testSnakeEyes();
//	  Tests.testRollResult();
//	  Tests.testGameOver();
//	  Tests.testWinningName();
//	  Tests.testHolding();
	  
	  // Once ALL of your tests are passing, you can play Pig!
	  // Just comment out your test runs above and uncomment the line below.
	  // GameAux.play();
	}
	
	// Below are the method definitions you must implement
	// So that the program compiles AFTER successfully implementing Die#roll()
	
	public static boolean rolledOneOnlyOnce(int d1, int d2) {
	  return false;
	}
	
	public static boolean snakeEyes(int d1, int d2) {
	  return false;
	}
	
	public static int rollResult(Die d1, Die d2) {
	  return -1;
	}
	
	public static int gameOver(int score1, int score2) {
	  return -1;
	}
	
	public static String winningName(Player p1, Player p2) {
		return "TODO";
	}
	
	public static boolean holding(Scanner keyboard) {
	  return false;
	}

}
