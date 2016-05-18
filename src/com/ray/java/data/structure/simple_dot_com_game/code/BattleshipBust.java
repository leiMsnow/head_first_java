package com.ray.java.data.structure.simple_dot_com_game.code;

import java.util.ArrayList;

/**
 * Created by dangdang on 5/10/16.
 */
public class BattleshipBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<Battleship> battleshipList = new ArrayList<>();
    private int numOfGuesses = 0;

    public void setUpGame() {

        Battleship blackPeal = new Battleship();
        blackPeal.setShipName("blackPeal");
        Battleship ghost = new Battleship();
        ghost.setShipName("ghost");
        Battleship revenge = new Battleship();
        revenge.setShipName("revenge");

        battleshipList.add(blackPeal);
        battleshipList.add(ghost);
        battleshipList.add(revenge);

        System.out.println("Your goal is to sink three battleship");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (Battleship battleship : battleshipList) {
            ArrayList<String> newLocation = helper.placeBattleship(3);
            battleship.setLocationCells(newLocation);
        }
    }

    public void startPlaying() {
        while (!battleshipList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }

        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (Battleship battleship : battleshipList) {
            result = battleship.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                battleshipList.remove(battleship);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Battleship are dead! Your stock is now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out befor your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }


}
