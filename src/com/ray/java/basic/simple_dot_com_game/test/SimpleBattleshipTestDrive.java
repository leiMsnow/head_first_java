package com.ray.java.basic.simple_dot_com_game.test;

import com.ray.java.basic.simple_dot_com_game.code.BattleshipBust;

/**
 * 战舰测试类
 * Created by dangdang on 5/9/16.
 */
public class SimpleBattleshipTestDrive {

    public static void main(String[] args) {

        BattleshipBust game = new BattleshipBust();
        game.setUpGame();
        game.startPlaying();

    }

}
