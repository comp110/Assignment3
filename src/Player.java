
public class Player {
	private String name;
	private int score;
	public Player(String name){
		this.name=name;
		this.score=0;
	}
		  public String getName() {
		    return this.name;
		  }
		  
		  public void addPoints(int points) {
		    this.score += points;
		  }
		  
		  
		  public int getScore() {
		    return this.score;
		  }
		  
		  public String toString() {
		    return name + " has " + score + " points.";
		  }
		  
		  public void clearScore(){
			  this.score=0;
		  }
		  
}
