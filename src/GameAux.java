import java.util.Scanner;

public class GameAux {

	public static void intro() {
		System.out.println("Welome to Pig!");
	}
	
	public static void play() {
    GameAux.intro();
    Scanner keyboard=new Scanner(System.in);
    Player p1=new Player(GameAux.setPlayer(keyboard, 1)); //p1 will represent player 1
    Player p2=new Player(GameAux.setPlayer(keyboard, 2));//p2 will represent player 2
    Die d1=new Die();//d1 will represent die 1 in the game
    Die d2=new Die();//d2 will represent die 2 in the game
    GameAux.gameLoop(p1, p2, d1, d2, keyboard);
    String winner=Game.winningName(p1,p2);
    GameAux.report(GameAux.getWinner(p1, p2, winner));
	}

	public static String setPlayer(Scanner goo, int pnum) {
		System.out.println("Player " + pnum + ": Please type in your name.");
		return goo.nextLine();
	}

	public static void report(Player winner) {
		System.out.println("" + winner.getName() + " wins with a score of "
				+ winner.getScore() + "!");
	}

	public static Player getWinner(Player p1, Player p2, String name) {
		if (p1.getName().equals(p2.getName())) {
			if (p1.getScore() > p2.getScore())
				return p1;
			return p2;
		}
		if (name.equals(p1.getName()))
			return p1;
		return p2;
	}

	public static void gameLoop(Player p1, Player p2, Die d1, Die d2, Scanner k) {
		int roundNumber = 1;
		while (Game.gameOver(p1.getScore(), p2.getScore()) != 1) {
			System.out.println("Round " + roundNumber);
			System.out.println("Enter any key to continue");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			k.next();
			System.out.println("" + p1.getName() + "'s turn.");
			boolean p1turn = true;
			int potential1 = 0;
			while (p1turn) {
				int result = Game.rollResult(d1, d2);
				int d1val = d1.getValue();
				int d2val = d2.getValue();
				System.out.println("Rolled a [" + d1.getValue() + "] and a [" + d2.getValue() + "].");
				if (result == -1) {
					System.out
							.println("Uh-oh! Snake eyes! Your score is reduced to zero and your turn is over! Sorry :(");
					p1.clearScore();
					p1turn = false;
				} else if (result == 0) {
					System.out
							.println("You rolled a one! You do not get any points this round. Sorry!");
					p1turn = false;
				} else {
					potential1 += result;
					System.out.println("Your potential score this round is "
							+ potential1);
					System.out
							.println("Your current score is " + p1.getScore());
					System.out.println("Your opponent's current score is "
							+ p2.getScore());
					if (Game.holding(k)) {
						p1.addPoints(potential1);
						p1turn = false;
					}
				}
			}
			System.out.println("Enter any key to continue");
			System.out.println();
			k.next();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("" + p2.getName() + "'s turn.");
			boolean p2turn = true;
			int potential2 = 0;
			while (p2turn) {
				int result = Game.rollResult(d1, d2);
				int d1val = d1.getValue();
				int d2val = d2.getValue();
				System.out.println("Rolled a [" + d1.getValue() + "] and a [" + d2.getValue() + "].");
				if (result == -1) {
					System.out
							.println("Uh-oh! Snake eyes! Your score is reduced to zero and your turn is over! Sorry :(");
					p2.clearScore();
					p2turn = false;
				} else if (result == 0) {
					System.out
							.println("You rolled a one! You do not get any points this round. Sorry!");
					p2turn = false;
				} else {
					potential2 += result;
					System.out.println("Your potential score this round is "
							+ potential2);
					System.out
							.println("Your current score is " + p2.getScore());
					System.out.println("Your opponent's current score is "
							+ p1.getScore());
					if (Game.holding(k)) {
						p2.addPoints(potential2);
						p2turn = false;
					}
				}
			}
			roundNumber++;
			
		}
	}
}
