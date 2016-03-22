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
 * @author alessio
 */ 
public class RailTrack {
    
    private double x;
    private double y;
    
    private BufferedImage railTrack1;
    
    public RailTrack(double x, double y, Game game){
        this.x = x;
        this.y = y;
    
        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
    
        railTrack1 = ss.grabImage(1, 3, 32, 32); 
    }
    
    
    public void tick(){
       
    }
    
    
    public void render(Graphics g){
    g.drawImage(railTrack1, (int)x, (int)y, null);
    }
}
