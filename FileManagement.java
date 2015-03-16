package saveload;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManagement implements SaveLoadInterface{

	public FileManagement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//public void save(String board1, String board2, String path) {
	public void save(BattleshipBoard spiller1, BattleshipBoard spiller2, String path){
		//for celle i spiller1, spiller1= getCell[i][i] 
		String board1="";
		String board2="";
		char type;
		//board1
		for(int i=0; i<10; i++){
			for(int j=0 ;j<10 ;j++){
				type = spiller1.getCell(i,j).getType();
				board1 += type;
			}
			board1+="\n";
		}
		
		//board2
		for(int i=0; i<10; i++){
			for(int j=0 ;j<10 ;j++){
				type = spiller2.getCell(i,j).getType();
				board2 += type;
			}
			board2+="\n";
		}
		try{
			PrintWriter output1 = new PrintWriter(path);
			output1.write(board1);
			output1.write(board2);
							
		output1.close();

			}
			catch (FileNotFoundException e) {
		}
	}
	
	@Override
	public void load(BattleshipBoard spiller1, BattleshipBoard spiller2, String path) {
		String resultBoard1="";
		String resultBoard2="";

		try {
			Scanner input = new Scanner(new FileReader(path));
		
			for(int i=0; i<10;i++){
		
					if((input.hasNextLine())){
					resultBoard1 += input.nextLine();
					
					}
				}
			for(int j=0; j<10;j++){
				//HER ER DET NOE FEIL, hvordan vil jeg hente det ut?
				if((input.hasNextLine())){
				resultBoard2 += input.nextLine();
				}
			}
				System.out.println(resultBoard2);
			
			
			int pikk =0;
			int vagina = 0;
			for(int j=0; j<10;j++){
				for(int g=0; g<10;g++){
					spiller1.getCell(j, g).setType(resultBoard1.charAt(vagina++));
					spiller2.getCell(j, g).setType(resultBoard2.charAt(pikk++));
				}
			}

			/*Scanner input = new Scanner(new FileReader(path));
			while(input.hasNextLine()){
				resultBoard += input.nextLine() + "\n";
			}
			
			resultBoard = resultBoard.substring(0, resultBoard.lastIndexOf("\n"));
			input.close();*/
			input.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
