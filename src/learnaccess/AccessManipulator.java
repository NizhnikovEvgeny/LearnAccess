/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learnaccess;

import Comps.CPU;
import Comps.Computer;
import Comps.GPU;
import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Женя
 */
public class AccessManipulator {
        ArrayList<CPU> cpuList = new ArrayList<>();
        ArrayList<GPU> gpuList = new ArrayList<>();
        ArrayList<Computer> compList = new ArrayList<>();
    public AccessManipulator(){};
    
    public void createSimpleDB() throws IOException{
        String DBname = "Computer.accdb";
        Database newDB = DatabaseBuilder.create(Database.FileFormat.V2010, new File(DBname));
        TableBuilder ComputerTable = new TableBuilder("Computer");
        TableBuilder CPU = new TableBuilder("CPU");
        TableBuilder GPU = new TableBuilder("GPU");
        
        CPU.addColumn(new ColumnBuilder("ID",DataType.INT));
        CPU.addColumn(new ColumnBuilder("Name",DataType.TEXT));
        CPU.addColumn(new ColumnBuilder("Clock Speed",DataType.DOUBLE));
        
        GPU.addColumn(new ColumnBuilder("ID",DataType.INT));
        GPU.addColumn(new ColumnBuilder("Name",DataType.TEXT));
        GPU.addColumn(new ColumnBuilder("Memory",DataType.DOUBLE));
        
        ComputerTable.addColumn(new ColumnBuilder("ID",DataType.INT));
        ComputerTable.addColumn(new ColumnBuilder("CPU",DataType.TEXT));
        ComputerTable.addColumn(new ColumnBuilder("GPU",DataType.TEXT));
        Table computer = ComputerTable.toTable(newDB);
        Table cpu = CPU.toTable(newDB);
        Table gpu = GPU.toTable(newDB);  
        System.out.println(compList.get(13));
        for (int i = 1;i<=100;i++){
            cpu.addRow(i,cpuList.get(i-1).getName(),cpuList.get(i-1).getSpeed());
        }
        for (int i = 1; i <= 100; i++) {
            gpu.addRow(i,gpuList.get(i-1).getName(),gpuList.get(i-1).getMemory());
        }
        for (int i = 1; i <= 100; i++) {
            computer.addRow(i,compList.get(i-1).getCPU().getName(),compList.get(i-1).getGPU().getName());
        }
        
    }
    public void out(){
        cpuList.add(new CPU(1));
        System.out.println(cpuList.get(0));
    }
    
    
    
    public void generate(){
                     
        Random random = new Random();
        for (int i = 1;i<=100;i++){
            cpuList.add(new CPU(i));
        }
        
        for (int i = 1; i <= 100; i++) {
            gpuList.add(new GPU(i));
        }
        
        compList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            compList.add(new Computer(cpuList.get(random.nextInt(99)),gpuList.get(random.nextInt(99))));
        }
        System.out.println(compList.get(15));
        System.out.println(cpuList.get(14));
        }

   
}
