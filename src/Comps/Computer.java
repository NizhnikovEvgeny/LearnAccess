/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comps;

/**
 *
 * @author Женя
 */
public class Computer {
     private int ID;
    private final CPU cpu;
    private final GPU gpu;
    public Computer(CPU cpu,GPU gpu){
        this.cpu=cpu;
        this.gpu=gpu;
    }

    public int getID() {
        return ID;
    }
    public CPU getCPU(){
        return cpu;
    }
    public GPU getGPU(){
        return gpu;
    }
}
