package Game;


import Game.Controllers.Controller;
import Game.Controllers.GUI;
import Game.Levels.GameLevel;
import Game.Levels.LevelOne.Level_11;
import Game.Levels.LevelOne.Level_12;
import Game.Levels.LevelOne.Level_13;
import Game.Trackers.Tracker;
import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chale
 */
public class Game {
    
    private GameLevel world;
    private UserView view;
    private Controller controller;
    private int level;
    private boolean inPause = false;
    
    
    // initialise a new game
    public Game(){
        
        // make the world
        level = 1;
        try{
            world = new Level_11("data/level_11.csv");
            world.populate(this);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
        
        // make the view ----> -31, 31(x); -17, 17(y)
        view = new MyView(world, world.getPlayer(), this, 640, 640);
        
        
        // display the view in a frame
        final JFrame frame = new JFrame("SuperMarioBros");
        
        Container buttons = new GUI(this, world);
        frame.add(buttons, BorderLayout.SOUTH);
        
        // quit the game when the window is close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        
        // add a controller
        controller = new Controller(world.getPlayer(), world);
        frame.addKeyListener(controller);
        
        // add the tracker
        world.addStepListener((StepListener) new Tracker(view, world, this));
        
        //  grid over the view
        // view.setGridResolution(2);
        
        // debugging view
         JFrame debugView = new DebugViewer(world, 500, 500);
        
        world.start();
        
    } 
    
    public int getLevel(){
        return level;
    }
    
    public void goNextLevel() throws IOException {
        world.stop();
        if (level == 3) {
            System.exit(0);
        } else {
            level++;
            if (level == 2){
            // get a new world
                world = new Level_12("data/level_12.csv");
            } else if (level == 3){
                world = new Level_13("data/level_13.csv");
            }
            
            // fill it with bodies
            world.populate(this);
            
            // show the new world in the view
            view.setWorld(world);
            
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            
            
            
            world.addStepListener((StepListener) new Tracker(view, world, this));
          
            
            // start!
            world.start();
        }
    }
    
    
    
    /** 
     * run the Game
     * @param args 
     */
    public static void main(String[] args) {
        new Game();
    }
}


