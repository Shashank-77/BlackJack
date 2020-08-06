package blackJack;
import java.util.*;
public class Player{

	public ArrayList<Cards> player = new ArrayList<Cards>();
	private int score;

	public Player(){

		score=0;
	}
	public void getCard(Cards dealt){

		player.add(dealt);

	}

	public void calcScore(){

		score = 0;
		Cards scr;
		int i;
		int val;
		Scanner s = new Scanner(System.in);

		for(i=0; i<player.size(); i++){
			
			scr = player.get(i);
			if(scr.getVal() == 1){
				System.out.print("Would you like your ace to be 1/11?:");
				val = s.nextInt(); // MAKE EXCEPTION FOR 1 or 11
				score += val;
			}
			else{
		
				if(scr.getVal()>10){
					val = 10;
				}

				else{
					val = scr.getVal();
				}

				score += val;

			

			}
		}

		if (score > 21)
			score = -1;

	}

	public void calcScored(){

		score = 0;
		Cards scr ;
		int i;
		int val;
		Scanner s = new Scanner(System.in);

		for(i=0; i<player.size(); i++){
			
			scr = player.get(i);

			if(scr.getVal()==1){
				if (score <= 10)
					val = 11;
				else	
					val = 1;
			}

			else if(scr.getVal()>10){
				val = 10;
			}

			else{
				val = scr.getVal();
			}
			
			score += val;

			}
		
		if (score > 21)
			score = -1;

		

		if(score == -1){

			score = 0;

			for(i=0; i<player.size(); i++){

				scr = player.get(i);

				if(scr.getVal()==1){
					val = 1;
				}

				else if(scr.getVal()>10){
				val = 10;
				}

				else{
				val = scr.getVal();
				}
			
				score += val;
			}

		}

		if (score > 21)
			score = -1;

	} 
	//ACE CONDITION
	

	public int getScore(){
		return score;
	}


}



