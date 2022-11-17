package view;

import controler.CricketControler;
import model.Batsman;
import model.Bowlers;
import model.Teams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CricketView {
    private Scanner scanner = new Scanner(System.in);
    private CricketControler cricketControler;

    public static void main(String[] args) {

        CricketView cricketView = new CricketView();
        cricketView.pageView();
    }

    public CricketView() {
        cricketControler = new CricketControler(this);
    }

    private void pageView() {
        System.out.println("-->Cricket<--");

        try {
            File file = new File("D:\\java cmd prorams\\CricketInput.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string = bufferedReader.readLine();
            ArrayList<String> inputList = new ArrayList<>();
            while (string != null) {
                inputList.add(string);
                string = bufferedReader.readLine();
            }
            cricketControler.readTheInputes(inputList);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayScore(Teams battingTeam, Teams bowlingTeam) {
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------->Score Board<----------------------------------------");
        System.out.printf("%s                                                            %s\n", battingTeam.getTeamName(), bowlingTeam.getTeamName());

        System.out.printf("%d/%d(%s)                                                      %d/%d(%s)\n", battingTeam.getTeamScore(), battingTeam.getExtra(), battingTeam.getTeamStatus(), bowlingTeam.getTeamScore(), bowlingTeam.getExtra(), bowlingTeam.getTeamStatus());

        List<Batsman> battingTeamBatsmanList = battingTeam.getBatsmanList();
        List<Batsman> bowlingTeamBatsManList = bowlingTeam.getBatsmanList();
        Batsman batsman;
        Batsman bowlingTeamBatsMan;
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("\nBatting                                                          Bating\n");
        for (int i = 0; i < 3; i++) {
            batsman = battingTeamBatsmanList.get(i);
            bowlingTeamBatsMan = bowlingTeamBatsManList.get(i);
            System.out.printf("%-7s-%-3d-%-3d                                                 %-7s-%-3d-%-3d\n",
                    batsman.getBatsManame() + batsman.getBatsManStatus(), batsman.getBatsManScore(),
                    batsman.getStrinkingBalls(), bowlingTeamBatsMan.getBatsManame() + bowlingTeamBatsMan.getBatsManStatus(),
                    bowlingTeamBatsMan.getBatsManScore(), bowlingTeamBatsMan.getStrinkingBalls());
        }
        Bowlers batingTeamBowlers;
        Bowlers bowlingTeamBowlers;
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Bowling                                                            Bowling\n");
        for (int i = 0; i < 2; i++) {
            batingTeamBowlers = battingTeam.getBowlersList().get(i);
            bowlingTeamBowlers = bowlingTeam.getBowlersList().get(i);
            System.out.printf("%-8s-%-4s-%d/%d                                                 %-8s-%-4s-%d/%d\n",
                    batingTeamBowlers.getBowlerName(), batingTeamBowlers.getTotalbolls() / 6 + "." + batingTeamBowlers.getTotalbolls() % 6
                    , batingTeamBowlers.getScoreGivenToBatsman(), batingTeamBowlers.getNumberOfWicketsTake(),
                    bowlingTeamBowlers.getBowlerName(), bowlingTeamBowlers.getTotalbolls() / 6 + "." + bowlingTeamBowlers.getTotalbolls() % 6,
                    bowlingTeamBowlers.getScoreGivenToBatsman(),
                    bowlingTeamBowlers.getNumberOfWicketsTake());

        }


    }
}
