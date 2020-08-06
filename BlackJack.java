import blackJack.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

class BlackJack{


	public static void showCards(Player p){

		ListIterator<Cards> itr = p.player.listIterator();
		Cards c ;

		while(itr.hasNext()){

			c = itr.next();
			int suite;
			int val;
			val = c.getVal();
			suite = c.getSuit();
			
			String suit;

			if(suite==1){
				suit = "Spades";
			}
			else if(suite==2){
				suit = "Clubs";
			}
			else if(suite==3){
				suit = "Hearts";
			}
			else {
				suit = "Diamonds";
			}

			System.out.println("-----------------");
			System.out.println("|               |");
			System.out.println("|               |");
			System.out.println("|               |");
		

			if(val<10 && val > 1){
				System.out.println("|  Card:  "+val+"     |");
			}
			else if(val==10)
				System.out.println("|  Card:  "+val+"    |");
			else if(val == 11){
				System.out.println("|  Card: Jack   |");
			}

			else if(val == 12){
					System.out.println("|  Card: Queen  |");
			}
			else if(val == 13){
					System.out.println("|  Card: King   |");
			}
			else if(val == 1){
					System.out.println("|   Card: Ace   |");
			}
			System.out.println("|               |");
			System.out.println("|               |");
			System.out.println("|               |");
			System.out.println("-----------------");
		}

	}

	public static void showCard(Player p){

		Cards c ;
		int val;
		int suite;
		c = p.player.get(0);
		val = c.getVal();
		suite = c.getSuit();

		String suit;

			if(suite==1){
				suit = "Spades";
			}
			else if(suite==2){
				suit = "Clubs";
			}
			else if(suite==3){
				suit = "Hearts";
			}
			else {
				suit = "Diamonds";
			}


			System.out.println("-----------------");
			System.out.println("|               |");
			System.out.println("|               |");
			System.out.println("|               |");
		

			if(val<10 && val > 1){
				System.out.println("|  Card:  "+val+"     |");
			}
			else if(val==10)
				System.out.println("|  Card:  "+val+"    |");
			else if(val == 11){
				System.out.println("|  Card: Jack   |");
			}

			else if(val == 12){
					System.out.println("|  Card: Queen  |");
			}
			else if(val == 13){
					System.out.println("|  Card: King   |");
			}
			else if(val == 1){
					System.out.println("|   Card: Ace   |");
			}
			System.out.println("|               |");
			System.out.println("|               |");
			System.out.println("|               |");
			System.out.println("-----------------");

	}
	
	public static void main(String args[]){

		int lost=0;

		Scanner s = new Scanner(System.in);
	
		

		System.out.print("Enter number of decks:");
		int no= s.nextInt();
		Deck d = new Deck(no);
		d.shuffleDeck();

		int betMoney = 0;
		System.out.println("How many chips do you want to buy?");
		betMoney = s.nextInt();


		while(betMoney > 0){

			System.out.println("How much would you like to bet: (Remaining chips :"+betMoney+")");
			int bet = s.nextInt();
			Player p = new Player();
			//Dealing cards to players

			Cards card1 ;
			Cards card2 ;
			card1 = d.drawCard();
			card2 = d.drawCard();

			p.getCard(card1);
			p.getCard(card2);


			Player dealer = new Player();
			card1 = d.drawCard();
			card2 = d.drawCard();

			dealer.getCard(card1);
			dealer.getCard(card2);
			dealer.calcScored();


			System.out.println("-----------------Let's Play!-----------------");

			System.out.println("Player's cards:");
			showCards(p);
			p.calcScore();
			System.out.println("Player Score:" + p.getScore());



			System.out.println("Dealer's card:");
			showCard(dealer);

			int ch = 0;

			while(ch == 0){

				System.out.println("would you like to hit(0) or stand(1)");
				// DOUBLE DOWN CASE

				ch = s.nextInt();
				if(ch==0){
					
					card1 = d.drawCard();
					p.getCard(card1);
					System.out.println("Player's cards:");
					showCards(p);
					p.calcScore();
					if(p.getScore() != -1 )
						System.out.println("Player Score:" + p.getScore());
					else
						System.out.println("Player Score crossed 23!");
				}
				if(p.getScore() == -1){
					ch = 1;
					lost = 1;
				}

			}
			int ifEntered = 0;
			if(lost == 0){

				while(dealer.getScore() <= 17 && dealer.getScore()!= -1 && dealer.getScore()<=p.getScore()){

					System.out.println("Thinking.......");
					try
					{
 					   Thread.sleep(1000);
					}		
					catch(InterruptedException ex)
					{		
    					Thread.currentThread().interrupt();
					}	
					ifEntered = 1;
					card1 = d.drawCard();
					dealer.getCard(card1);
					System.out.println("Dealer's cards:");
					showCards(dealer);
					dealer.calcScored();
					if(dealer.getScore() != -1 )
						System.out.println("Dealer Score:" + dealer.getScore());
					else
						System.out.println("Dealer Score crossed 21!");

				}
			}

			if (ifEntered == 0){
				System.out.println("Dealer's cards:");
				showCards(dealer);
				dealer.calcScored();
				if(dealer.getScore() != -1 )
					System.out.println("Dealer Score:" + dealer.getScore());
				else
					System.out.println("Dealer Score crossed 21!");
			}

			if(dealer.getScore() <  p.getScore()){
				System.out.println("PLAYER WINS!!!!");
				betMoney+=bet;
			}
			else if(dealer.getScore() == p.getScore()) 
				System.out.println("Draw");	
			
			else{
				betMoney-=bet;
				System.out.println("LOST!!!!!");
			}

			String enter = s.nextLine();
			System.out.println("Enter to continue");
			String ente1 = s.nextLine();

			System.out.print("\033[H\033[2J");  
    		System.out.flush();  

		}
		System.out.println("-------------YOURE ALL OUT OF CASH-------------");
		System.out.println(" Better luck next time");
	}

}