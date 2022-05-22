import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HighScoreTable {
    private DoublyLinkedList data = new DoublyLinkedList();

    public HighScoreTable() {
        this.data = readHighScoreTableFile();
        sortHighScoreTable();
    }

    private DoublyLinkedList readHighScoreTableFile() { // read the file and fill the DLL with object(name, score)
        DoublyLinkedList highScoreTable = new DoublyLinkedList();
        File reader = new File("HighScoreTable.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                String name = currentLine.split("   ")[0];
                String score = currentLine.split("   ")[1];
                HighScoreData scoreData = new HighScoreData(name, Double.parseDouble(score));
                DoubleNode newScore = new DoubleNode(scoreData);
                highScoreTable.insertAtEnd(newScore);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return highScoreTable;
    }

    private void sortHighScoreTable() { /* sort sýkýntýlý tekrar bakýlacak */
    	DoublyLinkedList sortedList = new DoublyLinkedList();
        sortedList.insert(data.getIndex(0).getData(), 0); 

        for (int i = 1; i < data.length(); i++) {
            HighScoreData highScoreData = (HighScoreData) data.getIndex(i).getData();

            for (int j = 0; j < i; j++) {
                if (j == i - 1) {
                    sortedList.insertAtEnd(new DoubleNode(highScoreData));
                    break;
                }

                HighScoreData prevHighScoreData = (HighScoreData) sortedList.getIndex(j).getData();
                if (highScoreData.getScore() >= prevHighScoreData.getScore()) {
                    sortedList.insert(highScoreData, j);
                    break;
                }
            }
        }

        this.data = sortedList;
    }

    public void printScores() { // print scores
        System.out.println("High Score Table\n");
        for (int i = 0; i < data.length(); i++) {
            HighScoreData scoreData = (HighScoreData) data.getIndex(i).getData();

            System.out.print(scoreData.getName());
            for (int j = 0; j < 15 - scoreData.getName().length(); j++)
                System.out.print(" ");
            System.out.print(scoreData.getScore() + "\n");
        }
    }

    public void addPlayerScore(int score) { // add player score to scoreboard
        HighScoreData scoreData = new HighScoreData("You", score);
        DoubleNode playerScore = new DoubleNode(scoreData);
        data.insertAtEnd(playerScore);
        sortHighScoreTable();
    }

}
