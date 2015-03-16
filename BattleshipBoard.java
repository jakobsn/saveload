package saveload;

public class BattleshipBoard {

	private Cell board[][] = new Cell[10][10];
	
	public BattleshipBoard(String boardstart){
		for (int i=0; i<10; i++){
			for (int j=0; j<10; j++){
		
				board[i][j] = new Cell(boardstart.charAt(i*11+j));
			}
		}
	}
	
	public void printBoard(){
		System.out.println("_____________________________________");
		System.out.println("\t|1 |2 |3 |4 |5 |6 |7 |8 |9 |10|");
		for (int i=0; i<10; i++){
			System.out.print(i+1+"____\t"+"|_");
			for (int j=0; j<10; j++){
				char celle = getCell(i,j).getType();
				if(celle == '.'||celle=='X'){
					celle=' ';
				}
				//System.out.println(celle);
				System.out.print(""+celle+"|_");
				

				//System.out.print(""+board[i][j]+"|_");
				
			}
			System.out.print("\n");
		}
		System.out.println("–––––––––––––––––––––––––––––––––––––");
	}
	
	public Cell getCell(int x, int y){
		return board[y][x];
	}
	
	public boolean isGameOver(){
		for (int i=0; i<10; i++){
			for (int j=0; j<10; j++){
				if(board[i][j].getType() == 'X'){
					return false;
				}
			}
		}
		return true;
	}

	
	
	public void shoot(int x, int y){
		board[y][x].Shot();
	}

}
