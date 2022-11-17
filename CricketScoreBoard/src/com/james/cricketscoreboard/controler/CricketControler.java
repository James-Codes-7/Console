package controler;

import model.Batsman;
import model.Bowlers;
import model.Teams;
import repository.CricketDatabase;
import view.CricketView;

import java.util.ArrayList;
import java.util.List;

public class CricketControler {

    private CricketDatabase cricketDatabase;
    private ArrayList<List<String>> playerNameList = new ArrayList<>();
    private CricketView cricketView;
    ArrayList<String> playerScore = new ArrayList<>();

    public void readTheInputes(ArrayList<String> arrayList) {
        List<String> firstTeam = new ArrayList<>();
        List<String> secondTeam = new ArrayList<>();
        int listSize = arrayList.size(), index = 0;
        String lines = "";
        for (index = 0; index < listSize; index++) {
            if (index == 0) {
                lines = arrayList.get(index);
                String teamsName[] = lines.split(",");
                firstTeam.add(teamsName[0]);
                secondTeam.add(teamsName[1]);
            }
            if (index == 1) {
                lines = arrayList.get(index);
                firstTeam.add(lines);
            }
            if (index == 2) {
                lines = arrayList.get(index);
                secondTeam.add(lines);
            }
            if (index > 2) {
                lines = arrayList.get(index);
                String score[] = lines.split(",");
                for (int i = 0; i < score.length; i++) {
                    playerScore.add(score[i]);
                }
            }
        }
        playerNameList.add(firstTeam);
        playerNameList.add(secondTeam);
        splitData(playerNameList);
        addScoreToPlayers(playerScore);
        cricketView.displayScore(cricketDatabase.getBatingTeam(), cricketDatabase.getBowlingTeam());
    }
    private void addScoreToPlayers(ArrayList<String> scoreList) {

        int teamScore = 0, totalBall = 0;
        Teams battingTeam = cricketDatabase.getBatingTeam();
        Batsman firstBatsMan = battingTeam.getBatsmanList().get(0);
        Batsman secondBatsMan = battingTeam.getBatsmanList().get(1);
        Batsman striker = firstBatsMan;

        Teams bowlingTeam = cricketDatabase.getBowlingTeam();
        Bowlers firstBowler = bowlingTeam.getBowlersList().get(0);
        Bowlers secondBowler = bowlingTeam.getBowlersList().get(1);
        Bowlers currentBowler = firstBowler;
        int battingTeamScore = 0;
        int count = 0, extra = 0, size = scoreList.size();
        for (int index = 0; index < size; index++) {
            totalBall++;

            if (scoreList.get(index).equals("W")) {
                striker.setBatsManStatus("");
                striker.setStrinkingBalls((striker.getStrinkingBalls() + 1));
                currentBowler.setTotalbolls(currentBowler.getTotalbolls() + 1);
                currentBowler.setNumberOfWicketsTake(currentBowler.getNumberOfWicketsTake() + 1);
                if (count < 2) {
                    striker = battingTeam.getBatsmanList().get(2);
                    firstBatsMan = striker;
                    count++;
                    if (count != 2) continue;
                }
                if (count == 2) {
                    battingTeam.setTeamStatus("all out");
                    battingTeam.setExtra(extra);
                    battingTeam.setTeamScore((byte) teamScore);
                    firstBatsMan = bowlingTeam.getBatsmanList().get(0);
                    secondBatsMan = bowlingTeam.getBatsmanList().get(1);
                    firstBowler = battingTeam.getBowlersList().get(0);
                    secondBowler = battingTeam.getBowlersList().get(1);
                    currentBowler = firstBowler;
                    striker = firstBatsMan;
                    battingTeamScore = teamScore;
                    teamScore = 0;
                    extra = 0;
                    totalBall = 0;
                    count++;
                    continue;
                } else {
                    if (striker == firstBatsMan) {
                        striker = bowlingTeam.getBatsmanList().get(2);
                        firstBatsMan = striker;
                    } else {
                        striker = bowlingTeam.getBatsmanList().get(2);
                        secondBatsMan = striker;
                    }
                }
            }
            if (scoreList.get(index).equals("0")) {
                striker.setStrinkingBalls((striker.getStrinkingBalls() + 1));
                currentBowler.setTotalbolls((currentBowler.getTotalbolls() + 1));
            }
            if (scoreList.get(index).equals("1")) {

                striker.setStrinkingBalls((striker.getStrinkingBalls() + 1));
                striker.setBatsManScore((striker.getBatsManScore() + 1));
                currentBowler.setTotalbolls((currentBowler.getTotalbolls() + 1));
                currentBowler.setScoreGivenToBatsman(currentBowler.getScoreGivenToBatsman() + 1);
                if (striker == firstBatsMan) {
                    striker = secondBatsMan;
                    secondBatsMan = firstBatsMan;
                    firstBatsMan = striker;
                }
                teamScore += 1;
            }
            if (scoreList.get(index).equals("2")) {
                striker.setBatsManScore((striker.getBatsManScore() + 2));
                striker.setStrinkingBalls((striker.getStrinkingBalls() + 1));
                currentBowler.setTotalbolls((currentBowler.getTotalbolls() + 1));
                currentBowler.setScoreGivenToBatsman(currentBowler.getScoreGivenToBatsman() + 2);
                teamScore += 2;
            }
            if (scoreList.get(index).equals("4")) {
                striker.setBatsManScore((striker.getBatsManScore() + 4));
                striker.setStrinkingBalls((striker.getStrinkingBalls() + 1));
                currentBowler.setTotalbolls((currentBowler.getTotalbolls() + 1));
                currentBowler.setScoreGivenToBatsman(currentBowler.getScoreGivenToBatsman() + 4);
                teamScore += 4;
            }
            if (scoreList.get(index).equals("6")) {
                striker.setBatsManScore((striker.getBatsManScore() + 6));
                striker.setStrinkingBalls((striker.getStrinkingBalls() + 1));
                currentBowler.setTotalbolls((currentBowler.getTotalbolls() + 1));
                currentBowler.setScoreGivenToBatsman(currentBowler.getScoreGivenToBatsman() + 6);
                teamScore += 6;
            }
            if (scoreList.get(index).equals("0WD")) {
                striker.setStrinkingBalls((striker.getStrinkingBalls() + 1));
                currentBowler.setScoreGivenToBatsman(currentBowler.getScoreGivenToBatsman() + 1);
                extra += 1;
                totalBall--;
                continue;
            }
            if (scoreList.get(index).equals("0NB")) {
                striker.setStrinkingBalls((striker.getStrinkingBalls() + 1));
                currentBowler.setScoreGivenToBatsman(currentBowler.getScoreGivenToBatsman() + 1);
                extra += 1;
                totalBall--;
                continue;
            }
            if (totalBall % 6 == 0) {
                striker = secondBatsMan;
                secondBatsMan = firstBatsMan;
                firstBatsMan = striker;

                currentBowler = secondBowler;
                secondBowler = firstBowler;
                firstBowler = currentBowler;
            }
            if (totalBall == 30) {
                battingTeam.setExtra(extra);
                battingTeam.setTeamScore(teamScore);
                firstBatsMan = bowlingTeam.getBatsmanList().get(0);
                secondBatsMan = bowlingTeam.getBatsmanList().get(1);
                firstBowler = battingTeam.getBowlersList().get(0);
                secondBowler = battingTeam.getBowlersList().get(1);
                currentBowler = firstBowler;
                striker = firstBatsMan;
                totalBall = 0;
                teamScore = 0;
            }
        }
        bowlingTeam.setExtra(extra);
        bowlingTeam.setTeamScore(teamScore);
        if (battingTeamScore < teamScore) {
            bowlingTeam.setTeamStatus("Win");
        }
    }

    private void splitData(ArrayList<List<String>> teamlist) {

        byte split = 0;
        int setUp = 0;
        for (List<String> stringList : teamlist) {
            Teams teams = new Teams();
            split = 0;
            for (String data : stringList) {
                if (split == 0) {
                    teams.setTeamName(data);
                    split++;
                    continue;
                }
                if (split == 1) {
                    String[] players = data.split(",");
                    Batsman batsman = new Batsman();
                    batsman.setBatsManame(players[0]);
                    teams.setBatsmanList(batsman);
                    batsman = new Batsman();
                    batsman.setBatsManame(players[1]);
                    teams.setBatsmanList(batsman);
                    batsman = new Batsman();
                    batsman.setBatsManame(players[2]);
                    teams.setBatsmanList(batsman);
                    Bowlers bowlers = new Bowlers();
                    bowlers.setBowlerName(players[3]);
                    teams.setBowlersList(bowlers);
                    bowlers = new Bowlers();
                    bowlers.setBowlerName(players[4]);
                    teams.setBowlersList(bowlers);
                    if (setUp == 0) {
                        cricketDatabase.setBatingTeam(teams);
                    } else cricketDatabase.setBowlingTeam(teams);
                    split++;
                }
            }
            setUp++;
        }
    }

    public void display() {
        Teams teams = cricketDatabase.getBatingTeam();
        System.out.println("Team Name:" + teams.getTeamName());
        ArrayList<Bowlers> bowlersList = cricketDatabase.getBatingTeam().getBowlersList();
        System.out.println("Batting");
        ArrayList<Batsman> batsmenList = cricketDatabase.getBatingTeam().getBatsmanList();
        for (Batsman batsman : batsmenList) {
            System.out.println(batsman.getBatsManame() + "-" + batsman.getBatsManScore() + "(" + batsman.getStrinkingBalls() + ")\n");
        }
        System.out.println("Bouling");
        for (Bowlers bowlers : bowlersList) {
            System.out.println(bowlers.getBowlerName() + "-" + bowlers.getTotalbolls() / 6 + "." + bowlers.getTotalbolls() % 6 + "-" + bowlers.getNumberOfWicketsTake() + "\n");
        }


        System.out.println("Batting");
        batsmenList = cricketDatabase.getBowlingTeam().getBatsmanList();
        for (Batsman batsman : batsmenList) {
            System.out.println(batsman.getBatsManame() + "-" + batsman.getBatsManScore() + "(" + batsman.getStrinkingBalls() + ")\n");
        }

        System.out.println("Bowling");
        bowlersList = cricketDatabase.getBowlingTeam().getBowlersList();
        for (Bowlers bowlers : bowlersList) {
            System.out.println(bowlers.getBowlerName() + "-" + bowlers.getTotalbolls() / 6 + "." + bowlers.getTotalbolls() % 6 + "-" + bowlers.getNumberOfWicketsTake() + "\n");
        }

        System.out.println(cricketDatabase.getBatingTeam().getTeamScore() + cricketDatabase.getBatingTeam().getExtra());
        System.out.println(cricketDatabase.getBowlingTeam().getTeamScore() + cricketDatabase.getBowlingTeam().getExtra());
    }

    public CricketControler(CricketView cricketView) {
        cricketDatabase = CricketDatabase.getInstance();
        this.cricketView = cricketView;
    }

}
