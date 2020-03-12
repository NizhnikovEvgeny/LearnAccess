/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comps;


import java.util.Random;

/**
 *
 * @author Женя
 */
public class CPU {
    private int ID;
    private String name;
    private double speed;
    public CPU(int id){
        Random random = new Random();
        this.name = random.ints(48, 123)
      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
      .limit(5)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
        System.out.println(this.name);
        
        this.speed = 1 + (100-1)*random.nextDouble();
        System.out.println(this.speed);
        this.ID = id;
    }

    public int getID() {
        return ID;
    }
    public String getName(){
        return name;
    }
    public double getSpeed(){
        return speed;
    }
    
}
