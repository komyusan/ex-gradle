package jp.ac.uryukyu.ie.e235736;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarriorTest {
    @Test
    void attackWWSTest(){
        Warrior warrior=new Warrior("ユリウス",4000,5000);
        Enemy enemy=new Enemy("邪神D",999999,999999);
        int originHP=enemy.getHitPoint();
        for(int i=0;i<3;i++){
            warrior.attackWithWeponSkill(enemy);
            assertEquals(warrior.getAttack()*1.5,originHP-enemy.getHitPoint());
            originHP=enemy.getHitPoint();
        } 
    }
}