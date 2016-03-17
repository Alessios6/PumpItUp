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
 * @author thoma
 */
public class Wagon {
    
    private double x;
    private double y;
    
    private double velocityX = 0;
    private double velocityY = 0;
    
    private BufferedImage wagon;
    
    public Wagon(double x, double y, Game game){
        this.x = x;
        this.y = y;
        
        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
        
        wagon = ss.grabImage(1, 1, 32, 32);
    }
    
    public void tick(){
        x += velocityX;
    }
    
    public void render(Graphics g){
        
        g.drawImage(wagon, (int)x, (int)y, null);
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public void setVelocityX(double velocityX){
        this.velocityX = velocityX;
    }
}
