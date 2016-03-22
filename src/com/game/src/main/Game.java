/*
 * This is a game with the purpose of helping elderly people recover from a 
 * hip prothese operation. 
 *
 * version 0.5
 */
package com.game.src.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @authors:
 * - Thomas Nap
 * 
 */

public class Game extends Canvas implements Runnable{
    
    public static final int WIDTH = 540;
    public static final int HEIGHT = WIDTH / 12 * 9; //405
    public static final int SCALE = 2;
    public final String TITLE = "PumpItUp";
    
    private boolean running = false;
    private Thread thread;
    
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;
    private BufferedImage background = null;
    
    private Handler handler;

    //in this method all the objects are initialised
    private void init(){
        requestFocus(); //focus on the screen when app started
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            spriteSheet = loader.loadImage("/sprite_sheet.png");
            background = loader.loadImage("/background.png");
            
        } catch (IOException e){
            e.printStackTrace();
        }
        
        addKeyListener(new KeyInput(this));
        

       handler = new Handler();
       handler.addObject(new PumpWagon(100, 100, ID.PumpWagon, this));
    }
    
    //this method is used to start the thread
    private synchronized void start(){
        //if running is already true we dont want to be in this method
        if (running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    //this method is used to stop the thread
    private synchronized void stop(){
        if(!running){
            return;
        }
        running = false;
        try{
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        
        System.exit(1);
    }
    
    //this method is where the gameloop is defined
    public void run(){
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(updates + " Ticks, Fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    //this method is where all the updates go
    private void tick(){ //update
        
        handler.tick();
    }
    
    //this method draws all the objects on screen
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        
        if (bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        ///////Draw everything below//////////
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(background, -50, -300, null);
        
        //////////////////////////////////////
        
        handler.render(g);
        
        
        //////////////////////////////////////
        g.dispose();
        bs.show();
    }
    
    //key input goes below
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT){
            
        }
        else if(key == KeyEvent.VK_RIGHT){
            //myWagon.setVelocityX(5);
        }
    }
    
    public void keyReleased(KeyEvent e){
       int key = e.getKeyCode();
       
       if(key == KeyEvent.VK_LEFT){
           //myWagon.setVelocityX(0);
       }
       if(key == KeyEvent.VK_RIGHT){
           //myWagon.setVelocityX(0);
       }
    }
    
    public static void main (String args[]){
        Game game = new Game();
        
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        
        JFrame frame = new JFrame(game.TITLE);                  //add a title to the frame
        frame.add(game);                                        //add the game to the frame
        frame.pack();                                           //Sizes the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Pressing the X on the window closes the game
        frame.setResizable(false);                              //makes the frame not resizable
        frame.setLocationRelativeTo(null);                      //it's not setting it to a location on the screen
        frame.setVisible(true);                                 //makes the frame visible on the screen
    
        game.start();
    }
    
    public BufferedImage getSpriteSheet(){
        return spriteSheet;
     
    }
    
}
