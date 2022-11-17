package repository;

import model.Teams;

public class CricketDatabase {

    private Teams batingTeam;
    private Teams bowlingTeam;

    private CricketDatabase() {
        batingTeam = new Teams();
        bowlingTeam = new Teams();
    }

    private static CricketDatabase cricketDatabase;

    public static CricketDatabase getInstance() {
        if (cricketDatabase == null)
            cricketDatabase = new CricketDatabase();
        return cricketDatabase;
    }

    public Teams getBatingTeam() {
        return batingTeam;
    }

    public void setBatingTeam(Teams batingTeam) {
        this.batingTeam = batingTeam;
    }

    public Teams getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(Teams bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }
}
