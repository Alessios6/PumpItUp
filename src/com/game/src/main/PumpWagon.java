/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.src.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author thoma
 */
public class PumpWagon extends GameObject {
    
    private BufferedImage wagon;

    public PumpWagon(int x, int y, ID id, Game game) {
        super(x, y, id);
        
        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
        wagon = ss.grabImage(1, 1, 32, 32);
        
        velX = 5;
        
    }

    public void tick() {
        
    }

    public void render(Graphics g) {
        g.drawImage(wagon, (int)x, (int)y, null);
    }
    
}
