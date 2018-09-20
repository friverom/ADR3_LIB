/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpi_sw_io;

import java.io.Serializable;

/**
 * Class to create an image of RPI_IO board data. 
 * 
 * @author Federico
 */
public class RPI_Data implements Serializable{
    
    private int inputs=0;
    private int outputs=0;
    private double[] analogs= new double [8];
    private int flags=0;
    private double[] setpoints= new double[8];

    public RPI_Data() {
        
        for( int i=0;i<8;i++) {
            this.analogs[i]=0.0;
            this.setpoints[i]=0.0;
        }
    }

    public void setFlags(int flags){
        this.flags=flags;
    }
    
    public int getFlags(){
        return flags;
    }
    
    public boolean getFlag(int flag){
        if((getBit(flag)&flags)==0){
            return false;
        } else {
            return true;
        }
    }
    
    public void setInputs(int inputs) {
        this.inputs = inputs;
    }
     
    public int getInputs() {
        return inputs;
    }
    
    public boolean getInput(int in){
        
        if((getBit(in)&inputs)==0){
            return false;
        } else {
            return true;
        }
    }
    
    public void setOutputs(int out){
        this.outputs=out;
    }
    public int getOutputs() {
        return outputs;
    }

    public boolean getOutput(int out){
        if((getBit(out)&outputs)==0){
            return false;
        } else {
            return true;
        }
    }
    
    public double[] getAnalogs() {
        return analogs;
    }

    public double getAnalog(int channel){
        if(channel>0 && channel<9){
            return analogs[channel-1];
        } else {
            return 0.0;
        }
    }
       
    public void setAnalogs(double[] analogs) {
        this.analogs = analogs;
    }
    
    public void setAnalog(int channel,double value){
        if(channel>0 && channel<9){
            this.analogs[channel-1]=value;
        }
    }
    
    public double[] getSetpoints(){
        return setpoints;
    }
    
    public void setSetpoints(double [] setp){
        this.setpoints=setp;
    }
    
    public double getSetpoint(int setp){
        if(setp>0 && setp<9){
            return setpoints[setp-1];
        } else {
            return 0.0;
        }
    }
    private int getBit(int rly){
        
        if(rly==1){
            return 1;
        } else {
            return 1<<(rly-1);
        }
        
    }
    
    
    
}
