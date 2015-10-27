import java.util.Scanner;

/**
 * These tests will help you test your methods as you implement each one.
 */
public class Tests {
  
  static void testDieRoll() {
    System.out.print("Testing Die#roll... ");
    boolean passingTest = true;
    
    // Let's roll our die 10,000 times and count the number of times
    // each face value comes up.
    Die die = new Die();
    int[] valueCounts = new int[6];
    for(int i = 0; i < 10000; i++) {
      die.roll();
      if(die.getValue() < 1 || die.getValue() > 6) {
        System.out.print(""+die.getValue() + " is not a valid roll... ");
        passingTest = false;
        break;
      }
      valueCounts[die.getValue()-1]++;
    }
    
    // Now, if we rolled all valid numbers, lets test to make sure
    // each value came up at least one time.
    if(passingTest) {
      for(int i = 0; i < valueCounts.length; i++) {
        if(valueCounts[i] == 0) {
          System.out.print(" did not roll any " + (i+1) + "s... ");
          passingTest = false;
          break;
        }
      }
    }
    
    if(passingTest) {
      System.out.println("passed :)");
    } else {
      System.out.println("error(s) :(");
    }
  }
  
  static void testRolledOneOnlyOnce() {
    System.out.print("Testing Game.rolledOneOnlyOnce... ");
    boolean passingTest = true;
    passingTest = passingTest && expect(false, Game.rolledOneOnlyOnce(6,6), "Rolled 6, 6");
    passingTest = passingTest && expect(false, Game.rolledOneOnlyOnce(1,1), "Rolled 1, 1");
    passingTest = passingTest && expect(true,  Game.rolledOneOnlyOnce(1,6), "Rolled 1, 6");
    passingTest = passingTest && expect(true,  Game.rolledOneOnlyOnce(6,1), "Rolled 1, 6");
    if(passingTest) {
      System.out.println("passed :)");
    } else {
      System.out.println("error(s) :(");
    }
  }
  
  static void testSnakeEyes() {
    System.out.print("Testing Game.snakeEyes... ");
    boolean passingTest = true;
    passingTest = passingTest && expect(false, Game.snakeEyes(6,6), "Rolled 6, 6");
    passingTest = passingTest && expect(true,  Game.snakeEyes(1,1), "Rolled 1, 1");
    passingTest = passingTest && expect(false, Game.snakeEyes(1,6), "Rolled 1, 6");
    passingTest = passingTest && expect(false, Game.snakeEyes(6,1), "Rolled 6, 1");
    if(passingTest) {
      System.out.println("passed :)");
    } else {
      System.out.println("error(s) :(");
    }
  }
  
  static void testRollResult() {
    System.out.print("Testing Game.rollResult... ");
    Die die1, die2;
    die1 = new Die();
    die2 = new Die();
    
    boolean rolledOne = false, rolledSnakeEyes = false, rolledPoints = false;
    boolean passingTest = true;
    for(int i = 0; i < 10000; i++) {
    	die1.roll();
    	die2.roll();
      int result = Game.rollResult(die1, die2);
      if(result == -1) {
        passingTest = passingTest && expect(true, Game.snakeEyes(die1.getValue(),die2.getValue()), "-1 is for snakeEyes");
        rolledSnakeEyes = true;
      } else if(result == 0) {
        passingTest = passingTest && expect(true, Game.rolledOneOnlyOnce(die1.getValue(),die2.getValue()), "0 is for rolledOnceOnlyOnce");
        rolledOne = true;
      } else {
        passingTest = passingTest && expect(false, Game.snakeEyes(die1.getValue(),die2.getValue()), "-1 is for snakeEyes");
        passingTest = passingTest && expect(false, Game.rolledOneOnlyOnce(die1.getValue(),die2.getValue()), "0 is for rolledOnceOnlyOnce");
        rolledPoints = true;
      }
      if(passingTest == false) { break; }
    }
    
    if((rolledOne && rolledSnakeEyes && rolledPoints) == false) {
      System.out.print("In 10,000 tries, did not roll one of each outcome?... ");
      passingTest = false;
    }
    
    if(passingTest) {
      System.out.println("passed :)");
    } else {
      System.out.println("error(s) :(");
    }
  }
  
  static void testGameOver() {
    System.out.print("Testing Game.gameOver... ");
    boolean passingTest = true;
    passingTest = passingTest && expect(-1, Game.gameOver(0, 0), "When scores are 0, 0");
    passingTest = passingTest && expect(-1, Game.gameOver(49, 49), "When scores are 49, 49");
    passingTest = passingTest && expect(1, Game.gameOver(49, 50), "When scores are 49, 50");
    passingTest = passingTest && expect(1, Game.gameOver(50, 49), "When scores are 50, 49");
    passingTest = passingTest && expect(-1, Game.gameOver(50, 50), "When scores are 50, 50");
    passingTest = passingTest && expect(1, Game.gameOver(50, 51), "When scores are 50, 51");
    passingTest = passingTest && expect(1, Game.gameOver(51, 50), "When scores are 51, 50");
    passingTest = passingTest && expect(0, Game.gameOver(47, 49), "When scores are 47, 49");
    passingTest = passingTest && expect(-1, Game.gameOver(51, 51), "When scores are 51, 51");
    passingTest = passingTest && expect(1, Game.gameOver(52, 51), "When scores are 52, 51");
    passingTest = passingTest && expect(1, Game.gameOver(51, 52), "When scores are 51, 52");
    if(passingTest) {
      System.out.println("passed :)");
    } else {
      System.out.println("error(s) :(");
    }
  }
  
  static void testWinningName() {
    System.out.print("Testing Game.winningName... ");
    Player p1 = new Player("Kris");
    p1.addPoints(60);
    Player p2 = new Player("Jay");
    p2.addPoints(50);
    boolean passingTest = true;
    passingTest = passingTest && expect("Kris", Game.winningName(p1,p2), "Kris: 60, Jay: 50");
    p1.addPoints(-10);
    p2.addPoints(10);
    passingTest = passingTest && expect("Jay", Game.winningName(p2,p1), "Jay: 60, Kris: 50");
    if(passingTest) {
      System.out.println("passed :)");
    } else {
      System.out.println("error(s) :(");
    }
  }
  
  static void testHolding() {
    System.out.println("Testing Game.holding... ");
    boolean passingTest = true;
    System.out.println("// BEGIN TESTS... Ignore output here unless you see failures.");
    passingTest = passingTest && expect(true, Game.holding(new Scanner("1")), "When user presses 1");
    passingTest = passingTest && expect(false, Game.holding(new Scanner("2")), "When user presses 2");
    if(passingTest) {
    System.out.println("// BEGIN UNRECOGNIZED TESTS (You SHOULD see \"Unrecognized Option\" below)");
      passingTest = passingTest && expect(true, Game.holding(new Scanner("0\n1")), "When user enters 0 then 1");
      passingTest = passingTest && expect(false, Game.holding(new Scanner("3\n2")), "When user enters 3 then 2");
      System.out.println("// END OUTPUT TESTS");
    }
    System.out.print("\nTests for Game.holding... ");
    if(passingTest) {
      System.out.println("passed* :) (*Be sure you see the 'Unrecognized option!' message printed above.)");
    } else {
      System.out.println("error(s) :(");
    }
  }
  
  static boolean expect(boolean expected, boolean actual, String message) {
    if(expected == actual) {
      return true;
    } else {
      System.out.print(message + " Expected:" + expected + " Returned:" + actual + " ... ");
      return false;
    }
  }
  
  static boolean expect(int expected, int actual, String message) {
    if(expected == actual) {
      return true;
    } else {
      System.out.print(message + " Expected:" + expected + " Returned:" + actual + " ... ");
      return false;
    }
  }
  
  static boolean expect(String expected, String actual, String message) {
    if(expected.equals(actual)) {
      return true;
    } else {
      System.out.print(message + " Expected:" + expected + " Returned:" + actual + " ... ");
      return false;
    }
  }

}
