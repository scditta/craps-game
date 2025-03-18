import java.util.Scanner;

public class CrapsWager {
	
	private int[] dice = new int[2];
	private int sum;
	private int establishedPoint;
	private double bankBalance = 1000;
	private double wager;
	
	public void insertWager() {
		double wager;
		do {
			System.out.print("Enter a wager (> 0 AND <= $" + String.format("%.2f", this.bankBalance) + "): ");
	        @SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
	        wager = input.nextDouble();
		}while(wager <= 0 || wager > this.bankBalance);
        this.wager = wager;
	}
	
	//member function playGame() which runs the game
	public void playGame() {
		insertWager();
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
			 bust();
		}else if(this.sum == 7 || this.sum == 11) {
			System.out.println("You win the game!");
			win();
		}else {
			System.out.println("Point is (established) set to " + this.sum);
			this.establishedPoint = this.sum; //stores the sum to the establishedPoint member variable
			point(); //calls the member function point()
		}
		
		System.out.println(chatterBot());
		playGame();
	}
	
	
	public String chatterBot() {
		String[] chatter = {
				"Oh, you’re going for broke, huh?",
				"Aw c’mon, take a chance!",
				"You’re up big. Now’s the time to cash in your chips!",
				"Keep it going, you're winning big!"
		};
		
		int random = (int)(Math.random() * chatter.length);
		
		return chatter[random];
	}
	
	public void point() {
		//loops until 7 or the established point is equal to the sum
		do {
			roll();
		}while(this.sum != 7 && this.sum != this.establishedPoint);
		
		if(this.sum == 7) {
			System.out.println("Craps, you lose the game.");
			bust();
		}
		if(this.sum == this.establishedPoint) {
			System.out.println("You win the game!");
			win();
		}
	}
	
	public void win() {
			this.bankBalance += this.wager;
			System.out.println("Your bank balance is now " + String.format("%.2f", this.bankBalance) + "!");
	}
	
	
	public void bust() {
		this.bankBalance -= this.wager;
		
		if(this.bankBalance <= 0) {
			System.out.println("Sorry, you busted!");
			//exits program because you have no more money!
			System.exit(0);
		}else {
			System.out.println("Your bank balance is now " + String.format("%.2f", this.bankBalance) + "!");
		}
	}

	public static void main(String[] args) {
		CrapsWager crap = new CrapsWager(); //create the an object of CrapsWager
		crap.playGame(); //runs the game
	}
}