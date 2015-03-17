package saveload;

import java.util.Stack;

public class DoRedo {

	BattleshipBoard spiller1;
	BattleshipBoard spiller2;
	
	public DoRedo(BattleshipBoard spiller1, BattleshipBoard spiller2){
		this.spiller1 = spiller1;
		this.spiller2 = spiller2;
	}
	
	Stack<String> moves = new Stack<>();
	Stack<String> redoMoves = new Stack<>();

	
	public void saveAction(String action){
		moves.push(action);
	}
	
	public void reverseAction(String action, int tur){
		/*if(action.equals("down")){
			return"up";
		}*/
		int y = Integer.parseInt(action.split(" ")[1])-1;
		int x = Integer.parseInt(action.split(" ")[0])-1;
		
		if(tur == 1){
		
		char type = spiller1.getCell(x, y).getType();		
		
		spiller1.getCell(x, y).changeIsShot();
		
		if(type == '~'){
			type='.';
			spiller1.getCell(x , y).setType(type);
		}
		else if(type=='X'){
			type='O';
		}
		
		else if(type=='O'){
			type='X';
			spiller1.getCell(x , y).setType(type);

		}
		else if(type=='.'){
			type='~';
			spiller1.getCell(x , y).setType(type);
		}
		}
		else if(tur == 2){
			
			char type = spiller2.getCell(x, y).getType();
			spiller2.getCell(x, y).changeIsShot();
			
			if(type == '~'){
				type='.';
				spiller2.getCell(x , y).setType(type);
			}
			else if(type=='X'){
				type='O';
			}
			
			else if(type=='O'){
				type='X';
				spiller2.getCell(x , y).setType(type);

			}
			else if(type=='.'){
				type='~';
				spiller2.getCell(x , y).setType(type);
			}
			}
		//return type;
	}
	
	public String undo(){
		// I hovedprogrammet må jeg sjekke om denne funskjonen returnerer null HAHA

		if(moves.size()==0){
			throw new IllegalArgumentException("kan ikke angre før du har gjort noe, jævla retard");
		}
		else{
		String lastState = moves.pop();
		redoMoves.push(lastState);
		
		return lastState;}
	}
	public String redo(){
		if(redoMoves.size()==0){
			throw new IllegalArgumentException("kan ikke gjenta før du har angra, jævla retard");
		}
		else{
		String lastState = redoMoves.pop();
		moves.push(lastState);
		
		return lastState;}
	}
	
}
