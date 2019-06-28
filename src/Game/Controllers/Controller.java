/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Controllers;

import Game.Enemies.BasicEnemy;
import Game.Items.Obstacles.Pipe;
import Game.Levels.GameLevel;
import Game.Player.FireBall;
import Game.Player.Player;
import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class Controller extends KeyAdapter {

    private Player player;
    private Pipe pipe;
    private GameLevel world;
    public FireBall fireBall;
    private BasicEnemy enemy;
    private AttachedImage a;
    
    public Controller(Player player, GameLevel world){
        this.player = player;
        this.world = world;
        this.pipe = world.getPipe();
                
        
    }
   
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_Q:
                // Q = quit
                System.exit(0);
            case KeyEvent.VK_UP:
                // Arrow_up = jump
                Vec2 v = player.getLinearVelocity();
                // only jump if body is not already jumping
                if (Math.abs(v.y) < 0.01f) {
                    player.jump(player.getJumpingSpeed());
                    } 
                switch (player.getState()) {
                    case 1:
                        player.removeAllImages();
                        if(player.getDirection()==0){
                        player.addImage(new BodyImage("data/marioRightJump.png", 2));
                        } else{
                            player.addImage(new BodyImage("data/marioLeftJump.png", 2));
                        }
                        break;
                    case 2:
                        player.removeAllImages();
                        if(player.getDirection()==0){
//                        player.addImage(new BodyImage("data/bigMarioRightJump.png",4));
                            a = new AttachedImage(player, new BodyImage("data/bigMarioRightJump.png"), 4, 0, new Vec2(0, 1));
                        } else{
//                            player.addImage(new BodyImage("data/bigMarioLeftJump.png",4));
                            a = new AttachedImage(player, new BodyImage("data/bigMarioLeftJump.png"), 4, 0, new Vec2(0, 1));
                        }
                        break;
                    case 3:
                        player.removeAllImages();
                        if(player.getDirection()==0){
//                        player.addImage(new BodyImage("data/fireMarioRightJump.png",4));
                            a = new AttachedImage(player, new BodyImage("data/fireMarioRightjump.png"), 4, 0, new Vec2(0, 1));
                        }else {
//                            player.addImage(new BodyImage("data/fireMarioLeftJump.png",4));
                            a = new AttachedImage(player, new BodyImage("data/fireMarioLeftJump.png"), 4, 0, new Vec2(0, 1));
                        }
                        break;
                    default:
                        break;
                }
                break;
                
            case KeyEvent.VK_DOWN:
                // arrow Down = stoop
                v = player.getLinearVelocity();
                if (Math.abs(v.y) < 0.01f) {
                    player.applyForce(new Vec2(0,-1));
                    }
                if(player.getPosition().x >= world.getPosTeleport().x-2 && player.getPosition().x <= world.getPosTeleport().x+2 && player.getPosition().y < world.getPosTeleport().y+2){
                    player.setPosition(world.getPositonSecretRoom());
                } else if(player.getState()==2){
                    player.removeAllImages();
                    if(player.getDirection()==0){
//                    player.addImage(new BodyImage("data/bigMarioDownRight.png",4));
                    a = new AttachedImage(player, new BodyImage("data/bigMarioDownRight.png"), 4, 0, new Vec2(0, 1));
                    } else {
//                        player.addImage(new BodyImage("data/bigMarioDownLeft.png",4));
                        a = new AttachedImage(player, new BodyImage("data/bigMarioDownLeft.png"), 4, 0, new Vec2(0, 1));   
                    }
                } else if(player.getState()==3){
                    player.removeAllImages();
                     if(player.getDirection()==0){
//                    player.addImage(new BodyImage("data/fireMarioDownRight.png",4));
                        a = new AttachedImage(player, new BodyImage("data/fireMarioRight.png"), 4, 0, new Vec2(0, 1));
                     } else{
//                         player.addImage(new BodyImage("data/fireMarioDownLeft.png",4));
                        a = new AttachedImage(player, new BodyImage("data/fireMarioLeft.png"), 4, 0, new Vec2(0, 1));
                     }
                }
                break;
                    
            case KeyEvent.VK_LEFT:
                player.setDirection(1);
                player.startWalking(-player.getWalkingSpeed()); // Arrow_left = walk left    
                
                switch (player.getState()) {
                    case 1:
                        player.removeAllImages();
                        player.addImage(new BodyImage("data/marioLeft.gif", 2));
                        break;
                    case 2:
                        player.removeAllImages();
//                        player.addImage(new BodyImage("data/bigMarioLeft.gif",4));
                        a = new AttachedImage(player, new BodyImage("data/bigMarioLeft.gif"), 4, 0, new Vec2(0, 1));
                        break;
                    case 3:
                        player.removeAllImages();
//                        player.addImage(new BodyImage("data/fireMarioLeft.gif",4));
                        a = new AttachedImage(player, new BodyImage("data/fireMarioLeft.gif"), 4, 0, new Vec2(0, 1));
                        break;
                    default:
                        break;
                }
                break;
                
            case KeyEvent.VK_RIGHT:
                player.setDirection(0);
                player.startWalking(player.getWalkingSpeed()); // arrow_right = walk right     
                
                if(player.getPosition().y >= world.getPosTeleportRight().y-2 && player.getPosition().y <= world.getPosTeleportRight().y+2 && player.getPosition().x > world.getPosTeleportRight().x-3){
                    player.setPosition(world.getPositionExitTeleport());
                    
                }
                
                switch (player.getState()) {
                    case 1:
                        player.removeAllImages();
                        player.addImage(new BodyImage("data/marioRight.gif", 2));
                        break;
                    case 2:
                        player.removeAllImages();
//                        player.addImage(new BodyImage("data/bigMarioRight.gif",4));
                        a = new AttachedImage(player, new BodyImage("data/bigMarioRight.gif"), 4, 0, new Vec2(0, 1));
                        break;
                    case 3:
                        player.removeAllImages();
//                        player.addImage(new BodyImage("data/fireMarioRight.gif",4));
                        a = new AttachedImage(player, new BodyImage("data/fireMarioRight.gif"), 4, 0, new Vec2(0, 1));
                        break;
                    default:
                        break;
                }
               break;
                
            case KeyEvent.VK_SHIFT:
                // shift = speed up
               player.setWalkingSpeed(player.getWalkingSpeed()*2);
                break;
                
            case KeyEvent.VK_SPACE:
                // space = fire;
                if(player.getState() == 3){
                    world.shoot();
                }
                break;
                
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_SHIFT:
                // released shift = speed up removed
                player.setWalkingSpeed(player.getWalkingSpeed()/2);
                break;
            case KeyEvent.VK_UP:
                if(player.getDirection()==0){
                    switch (player.getState()) {
                        case 1:
                            player.removeAllImages();
                            player.addImage(new BodyImage("data/marioRight.png", 2));
                            break;
                        case 2:
                            player.removeAllImages();
//                            player.addImage(new BodyImage("data/bigMarioRight.png",4));
                            a = new AttachedImage(player, new BodyImage("data/bigMarioRight.png"), 4, 0, new Vec2(0, 1));
                            break;
                        case 3:
                            player.removeAllImages();
//                            player.addImage(new BodyImage("data/fireMarioRight.png",4));
                            a = new AttachedImage(player, new BodyImage("data/fireMarioRight.png"), 4, 0, new Vec2(0, 1));
                            break;
                        default:
                            break;
                    }
                }else {
                    switch (player.getState()) {
                        case 1:
                            player.removeAllImages();
                            player.addImage(new BodyImage("data/marioLeft.png", 2));
                            break;
                        case 2:
                            player.removeAllImages();
//                            player.addImage(new BodyImage("data/bigMarioLeft.png",4));
                            a = new AttachedImage(player, new BodyImage("data/bigMarioLeft.png"), 4, 0, new Vec2(0, 1));
                            break;
                        case 3:
                            player.removeAllImages();
//                            player.addImage(new BodyImage("data/fireMarioLeft.png",4));
                            a = new AttachedImage(player, new BodyImage("data/bigMarioLeft.png"), 4, 0, new Vec2(0, 1));
                            break;
                        default:
                            break;
                    }
                }   break;
            case KeyEvent.VK_DOWN:
                if(player.getDirection()==0){
                    switch (player.getState()) {
                        case 1:
                            player.removeAllImages();
                            player.addImage(new BodyImage("data/marioRight.png", 2));
                            break;
                        case 2:
                            player.removeAllImages();
//                            player.addImage(new BodyImage("data/bigMarioRight.png",4));
                            a = new AttachedImage(player, new BodyImage("data/bigMarioRight.png"), 4, 0, new Vec2(0, 1));
                            break;
                        case 3:
                            player.removeAllImages();
//                            player.addImage(new BodyImage("data/fireMarioRight.png",4));
                            a = new AttachedImage(player, new BodyImage("data/fireMarioRight.png"), 4, 0, new Vec2(0, 1));
                            break;
                        default:
                            break;
                    }
                }else {
                    switch (player.getState()) {
                        case 1:
                            player.removeAllImages();
                            player.addImage(new BodyImage("data/marioLeft.png", 2));
                            break;
                        case 2:
                            player.removeAllImages();
//                            player.addImage(new BodyImage("data/bigMarioLeft.png",4));
                            a = new AttachedImage(player, new BodyImage("data/bigMarioLeft.png"), 4, 0, new Vec2(0, 1));
                            break;
                        case 3:
                            player.removeAllImages();
//                            player.addImage(new BodyImage("data/fireMarioLeft.png",4));
                            a = new AttachedImage(player, new BodyImage("data/fireMarioLeft.png"), 4, 0, new Vec2(0, 1));
                            break;
                        default:
                            break;
                    }
                }   break;
            case KeyEvent.VK_LEFT:
                player.stopWalking();
                switch (player.getState()) {
                    case 1:
                        player.removeAllImages();
                        player.addImage(new BodyImage("data/marioLeft.png", 2));
                        break;
                    case 2:
                        player.removeAllImages();
    //                            player.addImage(new BodyImage("data/bigMarioLeft.png",4));
                        a = new AttachedImage(player, new BodyImage("data/bigMarioLeft.png"), 4, 0, new Vec2(0, 1));
                        break;
                    case 3:
                        player.removeAllImages();
    //                            player.addImage(new BodyImage("data/fireMarioLeft.png",4));
                        a = new AttachedImage(player, new BodyImage("data/fireMarioLeft.png"), 4, 0, new Vec2(0, 1));
                        break;
                    default:
                        break;
                    }   
                break;
                
            case KeyEvent.VK_RIGHT:
                player.stopWalking();
                switch (player.getState()) {
                    case 1:
                        player.removeAllImages();
                        player.addImage(new BodyImage("data/marioRight.png", 2));
                        break;
                    case 2:
                        player.removeAllImages();
//                            player.addImage(new BodyImage("data/bigMarioLeft.png",4));
                        a = new AttachedImage(player, new BodyImage("data/bigMarioRight.png"), 4, 0, new Vec2(0, 1));
                        break;
                    case 3:
                        player.removeAllImages();
//                            player.addImage(new BodyImage("data/fireMarioLeft.png",4));
                        a = new AttachedImage(player, new BodyImage("data/fireMarioRight.png"), 4, 0, new Vec2(0, 1));
                        break;
                    default:
                        break;
                    }   
                break;
            default:
                break;
        } 
        
    }
        
    public void setBody(Player player){
        this.player = player;
    }
    
    
}
