package blackJack;
import java.util.*;

public class Deck{

	ArrayList <Cards> deck  = new ArrayList<Cards>();

	public Deck(int num){

		int i,j,k;

		for(i=0;i<num;i++){

			for(k=1 ; k<=4; k++){
			
				for(j=1; j<=13; j++){

					Cards c = new Cards(j,k);
					deck.add(c);

				}

			}
		}
	}

	public void shuffleDeck(){

		Random random = new Random();
    	Cards temp;
    	for(int i=0; i<200; i++){

			int index1 = random.nextInt(deck.size()-1);
			int index2 = random.nextInt(deck.size()-1);
			temp = deck.get(index2);
			deck.set(index2, deck.get(index1));
			deck.set(index1, temp);

    	}	

	}

	public Cards drawCard(){
    
    	Cards c;
    	c = deck.get(0);
    	deck.remove(0);
    	return c;

	}

}