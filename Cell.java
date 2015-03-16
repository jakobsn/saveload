package saveload;

public class Cell {

	private char type;
	private boolean isShot=false;
	
	public Cell(char type){
		this.type = type;
	}
	
	
	@Override
	public String toString(){
		if(isShot){
			return String.valueOf(type);
		}
		else{
			return " ";
		}
		
	}
	
	protected void setType(char type){
		if(type=='~' || type=='O' || type=='X' || type=='.')
		this.type=type;
		else{
			System.out.println("feil type, homoomoo");
		}
	}
	
	public char getType(){
		return type;
	}
	
	public void Shot(){
//		if (isShot==true){
	//		System.out.println("Kan ikke skyte samme plassen to ganger");
		//}
		if(type=='X'){
			type='O';
			System.out.println("Du traff!");
		}
		else if(type=='.'){
			type='~';
			System.out.println("Du bomma!");
		}
		isShot=true;
	}

	public boolean getIsShot() {
		// TODO Auto-generated method stub
		return isShot;
	}
	public void changeIsShot(){
		if(isShot==true){
			isShot=false;
		}
		else{
			isShot=true;
		}
	}
	
}
