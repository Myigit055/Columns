import enigma.core.Enigma;

public class GameStart {
	public static void main(String[] args) throws InterruptedException {
		enigma.console.Console eng =Enigma.getConsole("Columns Game", 40, 25, 30);
		new ColumnsGame(eng);
	}
}
