import enigma.core.Enigma;

public class GameStart {
	public static void main(String[] args) {
		Enigma.getConsole("Columns Game", 120, 25, 20);
		new ColumnsGame();
	}
}
