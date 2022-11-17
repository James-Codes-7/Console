package model;

import java.util.ArrayList;

public class Teams {

    private static Teams teams;

    private int teamScore;
    private int totalBall;
    private String teamStatus="not out";
    private int extra;
    private String teamName;

    public String getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(String teamStatus) {
        this.teamStatus = teamStatus;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    private ArrayList<Bowlers> bowlersList=new ArrayList<>();
    private  ArrayList<Batsman> batsmanList=new ArrayList<>();

    public int getTotalBall() {
        return totalBall;
    }

    public void setTotalBall(int totalBall) {
        this.totalBall = totalBall;
    }
    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    public ArrayList<Bowlers> getBowlersList() {
        return bowlersList;
    }
    public void setBowlersList(Bowlers bowlersList) {
        this.bowlersList.add(bowlersList);
    }
    public ArrayList<Batsman> getBatsmanList() {
        return batsmanList;
    }
    public void setBatsmanList(Batsman batsmanList) {
        this.batsmanList.add(batsmanList);
    }
}
