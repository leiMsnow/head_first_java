package com.ray.java.data.structure.simple_dot_com_game.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dangdang on 5/10/16.
 */
public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int shipCount = 0;

    public String getUserInput(String prompt) {

        String inputLine = null;
        System.out.println(prompt + " ");
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = is.readLine();
            if (inputLine.length() == 0)
                return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeBattleship(int shipSize) {

        ArrayList<String> alphaCells = new ArrayList<>();
        String[] alphacoords = new String[shipSize];
        String temp;
        int[] coords = new int[shipSize];
        int attempts = 0;
        boolean success = false;
        int location;

        shipCount++;
        int incr = 1;
        if ((shipCount % 2) == 1) {
            incr = gridLength;
        }

        while (!success & attempts++ < 200) {
            location = (int) (Math.random() * gridSize);
            int x = 0;
            success = true;
            while (success && x < shipSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize) {
                        success = false;
                    }
                    if (x > 0 && (location % gridLength == 0)) {
                        success = false;
                    }
                } else {
                    success = false;
                }
            }
        }


        int x = 0;
        int row = 0;
        int column = 0;

        while (x < shipSize) {
            grid[coords[x]] = 1;
            row = (coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }

        return alphaCells;
    }
}
