package com.ray.java.data.structure.simple_io;

import java.io.*;

/**
 * Created by dangdang on 5/16/16.
 */
public class GameCharacter implements Serializable {

    int power;
    String type;
    String[] weapons;

    public GameCharacter(int power, String type, String[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeapons() {

        String result = "";
        for (String weapon : weapons) {
            result += weapon;
        }

        return result;
    }

    public void setWeapons(String[] weapons) {
        this.weapons = weapons;
    }


    public static void saveData() {
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(30, "Troll", new String[]{"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(100, "Magician", new String[]{"spells", "invisibility"});


        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            oos.writeObject(one);
            oos.writeObject(two);
            oos.writeObject(three);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Game.ser"));
            one = (GameCharacter) ois.readObject();
            two = (GameCharacter) ois.readObject();
            three = (GameCharacter) ois.readObject();

            System.out.println("one:" + one.getType());
            System.out.println("two:" + two.getType());
            System.out.println("three:" + three.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveFile() {
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(30, "Troll", new String[]{"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(100, "Magician", new String[]{"spells", "invisibility"});

        try {
            FileWriter fileWriter = new FileWriter("game.txt");
            fileWriter.write(one.getPower() + "," + one.getType() + "," + one.getWeapons() + "\n");
            fileWriter.write(two.getPower() + "," + two.getType() + "," + two.getWeapons() + "\n");
            fileWriter.write(three.getPower() + "," + three.getType() + "," + three.getWeapons() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

