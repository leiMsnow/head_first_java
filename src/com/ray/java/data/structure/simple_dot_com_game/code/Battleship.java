package com.ray.java.data.structure.simple_dot_com_game.code;

import java.util.ArrayList;

/**
 * 战舰
 * Created by dangdang on 5/9/16.
 */
public class Battleship {

    private ArrayList<String> locations;

    private String shipName = "Wood";

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public void setLocationCells(ArrayList<String> locations) {
        this.locations = locations;
    }

    public String checkYourself(String userGuess) {

        String result = "miss";
        int index = locations.indexOf(userGuess);
        if (index >= 0) {

            locations.remove(index);
            if (locations.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }
        }

        return result;
    }

}
