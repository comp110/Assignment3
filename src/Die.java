public class Die {
	private int value;

	public Die() {
		this.value = 0;
	}

	public void roll() {	//You must edit this method.
	  this.value = 0;
	}
	
	int getValue() {
		return this.value;
	}
	
	void setValue(int value) {
	  this.value = value;
	}
}
