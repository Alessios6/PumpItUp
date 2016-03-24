/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Alessio
 */
public class PowerUp {
    
    static public double x;
    static public double y;
    
    private BufferedImage powerUp;
    
    public PowerUp(double x, double y, Game game){
        this.x = x;
        this.y = y;
    
        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
    
        powerUp = ss.grabImage(2, 1, 32, 32); 
    }
    
    
    public void tick(){
       
    }
    
    
    public void render(Graphics g){
    g.drawImage(powerUp, (int)x, (int)y, null);
    }
}
