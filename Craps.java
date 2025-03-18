
public class Craps {

	private int[] dice = new int[2];
	private int sum;
	private int establishedPoint;
	
	//member function playGame() which runs the game
	public void playGame() {
		roll();
		checker();
	}
	
	public void roll() {
		
		//loops through the member variable dice integer array and initializes the random number(1-6) to 
		//the index
		for(int i = 0; i < this.dice.length; i++) {
			this.dice[i] = (int)(Math.random() * 6) + 1;
		}
		
		//stores the sum
		this.sum = this.dice[0] + this.dice[1];
		
		//prints both dice rolls as well as the sum
		System.out.println("You rolled " + this.dice[0] + " + " + this.dice[1] + " = " + this.sum);
	}
	
	public void checker() {
		//checks if the player won, lost or if a point was established
		if(this.sum == 2 || this.sum == 3 || this.sum == 12) {
			 System.out.println("Craps, you lose the game.");
		}else if(this.sum == 7 || this.sum == 11) {
			System.out.println("You win the game!");
		}else {
			System.out.println("Point is (established) set to " + this.sum);
			this.establishedPoint = this.sum; //stores the sum to the establishedPoint member variable
			point(); //calls the member function point()
		}
	}
	
	public void point() {
		//loops until 7 or the established point is equal to the sum
		do {
			roll();
		}while(this.sum != 7 && this.sum != this.establishedPoint);
		
		if(this.sum == 7) {
			System.out.println("Craps, you lose the game.");
		}
		if(this.sum == this.establishedPoint) {
			System.out.println("You win the game!");
		}
	}

	public static void main(String[] args) {
		Craps crap = new Craps(); //create the an object of Craps
		crap.playGame(); //runs the game
	}

}
