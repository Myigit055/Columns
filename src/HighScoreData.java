public class HighScoreData {
    private String name;
    private double score;

    public HighScoreData(String name, double d) {
        this.name = name;
        this.score = d;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
