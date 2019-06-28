/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Trackers;

import Game.Enemies.BasicEnemy;
import Game.Game;
import Game.Levels.GameLevel;
import city.cs.engine.Body;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.UserView;
import java.io.IOException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class Tracker implements StepListener{

    private UserView view;
    private Body body;
    private GameLevel w;
    private ArrayList<BasicEnemy> enemies;
    private Game game;
  
     public Tracker(UserView view, GameLevel w, Game game) {
        this.view = view;
        this.body = w.getPlayer();
        this.w = w;
        this.game = game;
        enemies = w.getEnemies();
    }
    
    @Override
    public void preStep(StepEvent e) {
        
    }

    @Override
    public void postStep(StepEvent e) {
        
        
        enemiesStartWalk();
        if(body.getPosition().x == w.getFlagPositionX()){
            try {
                game.goNextLevel();
            } catch (IOException ex) {
                Logger.getLogger(Tracker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(w.getGameOver() || w.getSubtractLife()){
            
            view.setCentre(new Vec2(0, -50));
            
        } else {
            switch (game.getLevel()) {
                case 1:
                    if (body.getPosition().x < 0){
                        view.setCentre(new Vec2(0,0));
                    } else if (body.getPosition().x > w.getPositonSecretRoom().x-6){
                        view.setCentre(new Vec2(w.getPositonSecretRoom().x+11,0));
                    } else if (body.getPosition().x >= 0 && body.getPosition().x < w.getCastelPositionX()-1){
                        view.setCentre(new Vec2(body.getPosition().x, 0));
                    }
                    else {
                        view.setCentre(new Vec2(w.getCastelPositionX()-1, 0));
                    }   break;
                case 2:
                    if(body.getPosition().x < 16){
                        view.setCentre(new Vec2(0,0));
                    } else if(body.getPosition().x < 32){
                        view.setCentre(new Vec2(32,0));
                    } else if(body.getPosition().x > 32 && body.getPosition().x <= 386){
                        view.setCentre(new Vec2(body.getPosition().x, 0));
                    } else if(body.getPosition().x <= 402){
                        view.setCentre(new Vec2(386,0));
                    }else if(body.getPosition().x <= 418){
                        view.setCentre(new Vec2(418,0));
                    } else if(body.getPosition().x>418 && body.getPosition().x <= 462){
                        view.setCentre(new Vec2(body.getPosition().x, 0));
                    } else if(body.getPosition().x > 462 && body.getPosition().x <= 480 ){
                        view.setCentre(new Vec2(462,0));
                    } else if(body.getPosition().x > 480){
                        view.setCentre(new Vec2(494,0));
                    }   break;
                case 3:
                    view.setCentre(new Vec2(body.getPosition().x, 0));
                    break;
                default:
                    break;
            }

            
        }
        
        if(body.getPosition().y < -18){
            
            if(w.getPlayer().getLife() < 0 ){
                w.setGameOver();
                view.setCentre(new Vec2(0, -50));
            } else {
            w.getPlayer().setPosition(new Vec2(1,0));
            w.getPlayer().decreseLife();
            w.getPlayer().setState(1);
            w.setSubtractLife();
            view.setCentre(new Vec2(0, -50));
            }
        }
       
    }
    
    public void enemiesStartWalk(){
//        System.out.println(player.getPosition().x);
//        System.out.println(mushrooms.get(0).getPosition().x);
        for(int i=0; i < enemies.size(); i++){
            if (body.getPosition().x > enemies.get(i).getPosition().x-20){
                enemies.get(i).startWalking(enemies.get(i).getWalkingSpeed()); 
                //System.out.println("this is being called");
            } if(enemies.get(i).getPosition().y < -11){
                enemies.get(i).stopWalking();
            }
        }
    }
}
