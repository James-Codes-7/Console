package model;

public class Batsman {

    private String batsManame;

    private int batsManScore;
    private String batsManStatus="*";
    private int strinkingBalls;

    public String getBatsManStatus() {
        return batsManStatus;
    }

    public void setBatsManStatus(String batsManStatus) {
        this.batsManStatus = batsManStatus;
    }
    public String getBatsManame() {
        return batsManame;
    }
    public void setBatsManame(String batsManame) {
        this.batsManame = batsManame;
    }
    public int getBatsManScore() {
        return batsManScore;
    }
    public void setBatsManScore(int batsManScore) {
        this.batsManScore = batsManScore;
    }
    public int getStrinkingBalls() {
        return strinkingBalls;
    }
    public void setStrinkingBalls(int strinkingBalls) {
        this.strinkingBalls = strinkingBalls;
    }
}
