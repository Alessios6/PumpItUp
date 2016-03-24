/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.src.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Thomas Nap
 */
public class KeyInput extends KeyAdapter {
    
    private Handler handler;
    
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    
     public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.PumpWagon){
                
                if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
                if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
            }
        }
        
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.PumpWagon){
                
                if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
                if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
            }
        }
    }
    
    
}
