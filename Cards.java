package blackJack;
import java.util.*;

public class Cards {

	private int value;
	private int suit;


	public Cards(int val, int suit){
		
		value = val;
		this.suit = suit;
	
	}

	public int getVal(){
		
		return value;
	
	}

	public int getSuit(){

		return suit;
	
	}

	
	

}