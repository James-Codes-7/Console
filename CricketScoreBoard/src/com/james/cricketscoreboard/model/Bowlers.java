package model;

public class Bowlers {

    private String bowlerName;

    private int numberOfWicketsTake;

    private int numberOfOversBowled;

    private int totalbolls;

    private int scoreGivenToBatsman=0;

    public int getScoreGivenToBatsman() {
        return scoreGivenToBatsman;
    }

    public void setScoreGivenToBatsman(int scoreGivenToBatsman) {
        this.scoreGivenToBatsman = scoreGivenToBatsman;
    }

    public String getBowlerName() {
        return bowlerName;
    }

    public void setBowlerName(String bowlerName) {
        this.bowlerName = bowlerName;
    }

    public int getNumberOfWicketsTake() {
        return numberOfWicketsTake;
    }

    public void setNumberOfWicketsTake(int numberOfWicketsTake) {
        this.numberOfWicketsTake = numberOfWicketsTake;
    }

    public int getNumberOfOversBowled() {
        return numberOfOversBowled;
    }

    public void setNumberOfOversBowled(int numberOfOversBowled) {
        this.numberOfOversBowled = numberOfOversBowled;
    }

    public int getTotalbolls() {
        return totalbolls;
    }

    public void setTotalbolls(int totalbolls) {
        this.totalbolls = totalbolls;
    }
}
