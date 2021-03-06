/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.hslu.sw04;

/**
 *
 * @author Flavio Waser
 */
public class Motor implements Switchable {
    
    /*
    * Attribute
    */
    private int rpm;

    public Motor(int rpm) {
        this.rpm = rpm;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }
    
    @Override
    public void switchOn(){
         setRpm(100);
    }
    
    @Override
    public void switchOff(){
        setRpm(0);
    }
    
    @Override
    public boolean isSwitchedOn(){
        if(getRpm() > 0){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean isSwitchedOff(){
        if(getRpm() == 0){
            return true;
        } else {
            return false;
        }
    }
    
}
