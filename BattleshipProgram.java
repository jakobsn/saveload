package saveload;

import java.util.Scanner;

public class BattleshipProgram {
	
	private int tur = 1;

	BattleshipBoard spiller1= new BattleshipBoard("...XX.....\n...XX..XXX\n...XX.....\n..........\n..........\n.X........\n.X...XXX..\n.X........\n.X..XX....\n.........."); 
	BattleshipBoard spiller2= new BattleshipBoard(".XXX......\n.XXX....X.\n........X.\n........X.\n...XX...X.\n..........\n..X..XXX..\n..X.......\n..X.......\n..........");
	
	DoRedo angre = new DoRedo(spiller1, spiller2);
	
	
	public boolean checkInput(String xy){
		if(!xy.matches("[1][0][ ][1][0]") && !xy.matches("[1-9][ ][1-9]") && !xy.matches("[1][0][ ][1-9]")&& !xy.matches("[1-9][ ][1][0]")){
			System.out.println("Feil grammatikk på input");
			return false;
		}
			return true;
	}
	
	public  int getTur(){
		return tur;
	}
	
	public void run(){
		
		Scanner input = new Scanner(System.in);
		String valg;
		
		
		System.out.println("Velkommen til battleships motherfuckers");
		
		DoRedo doRedo = new DoRedo(spiller1,spiller2);
		
		FileManagement saveLoad = new FileManagement();
		while(!(spiller1.isGameOver()==true)||!(spiller2.isGameOver()==true)){
			System.out.println("Skriv inn koordinater på formen X Y for å skyte, z: angre, y: gjenta, s: lagre, l: hente");
			System.out.println("Spiller" + tur +" sin tur.");
			
			valg = input.nextLine();
			
			
			
			//
			
			if(valg.equals("z")){
				doRedo.reverseAction(doRedo.undo(), tur);
				byttTur();

			}
			
			else if(valg.equals("y")){
				int redotur=0;
				if(tur==1){
					redotur=2;
				}
				else if(tur==2){
					redotur=1;
				}
				doRedo.reverseAction(doRedo.redo(), redotur);
				byttTur();
				
			}
			
			else if(valg.equals("s")){
				System.out.println("Hva heter filen du vil lagre til?");
				String path = input.nextLine();
				path = "/home/jakob/Documents/" + path;
				saveLoad.save(spiller1, spiller2, path);
				
			}
			else if(valg.equals("l")){
				System.out.println("Hva Heter filen du vil hente fra?");
				String path = input.nextLine();
				path = "/home/jakob/Documents/" + path;
				saveLoad.load(spiller1, spiller2,path);
			}
			
			else if(checkInput(valg)==true){				
				//
				
				doRedo.saveAction(valg);
				int y = Integer.parseInt(valg.split(" ")[1])-1;
				int x = Integer.parseInt(valg.split(" ")[0])-1;
				
				if(getTur()==1){
					if(spiller2.getCell(x,y).getIsShot()==false){
					spiller2.shoot(x, y);
					spiller2.printBoard();}
					else{
						byttTur();
						System.out.println("Kan ikke skyte samme plassen to ganger");
					}
					
				}
				else{
					if(spiller1.getCell(x,y).getIsShot()==false){
						spiller1.shoot(x, y);
						spiller1.printBoard();}
						else{
							byttTur();
							System.out.println("Kan ikke skyte samme plassen to ganger");
						}
					}
				//^
				byttTur();
				doRedo.redoMoves.clear();
			}
		}
		byttTur();
		System.out.println("GAME OVER!");
		System.out.println("Spiller"+tur+" vant!");
		
		input.close();
	}
	
	public void byttTur(){
		if(tur==1){
			tur=2;
		}
		else{
			tur=1;
		}
	}
	
	public void Save(BattleshipBoard spiller1, BattleshipBoard spiller2){
		//for celle i spiller1, spiller1= getCell[i][i] 
		
	}
	
	public static void main(String[] args){
		BattleshipProgram prog = new BattleshipProgram();
		prog.run();
	}
}
