package saveload;

public interface SaveLoadInterface {

	public void save(BattleshipBoard s, BattleshipBoard c, String path);
	public void load(BattleshipBoard s, BattleshipBoard c,String path);
	
	
}
