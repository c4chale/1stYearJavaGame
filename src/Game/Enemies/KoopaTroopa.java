/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Enemies;

import Game.Levels.GameLevel;
import city.cs.engine.BodyImage;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class KoopaTroopa extends BasicEnemy{
    
     private GameLevel world;
    
    private float walkingSpeed = -3;
    private float runningSpeed = -12;
    private int life = 2;
    
    public KoopaTroopa(World world, Vec2 pos, String img) {
        super(world);
        setPosition(new Vec2(pos));
        addImage(new BodyImage("data/" + img +"Left.gif", 3));
        
    }



    @Override
    public void marioJumpedOnEnemy() {
        //addAnimation
    }

    @Override
    public void killedByFireBall() {
        //addAnimation
    }

    @Override
    public void collideWithJumpingBrick() {
        if (world.getPlayer().getPosition().x >= this.getPosition().x-2 && world.getPlayer().getPosition().x <= this.getPosition().x+2 && world.getPlayer().getPosition().y >= this.getPosition().y-3){
            this.decreseLife();
        }
    }

    @Override
    public int life() {
         return life;
    }

    @Override
    public void decreseLife() {
        life--;
        if(life==1){
             walkingSpeed = runningSpeed * -1;
            
             if(walkingSpeed < 0){
                 
                removeAllImages();
                addImage(new BodyImage("data/koopaTroopaLeft.gif", 3));
                
            } else {
                
                removeAllImages();
                addImage(new BodyImage("data/koopaTroopaRight.gif", 3));
            }  
        } else if(life == 0){
            this.destroy();
        }
    }
    
    @Override
    public float getWalkingSpeed() {
        return walkingSpeed;
    }

    @Override
    public void changeWalkingDirection() {
        if(life == 1){
            
            walkingSpeed = runningSpeed * -1;
            
            if(walkingSpeed < 0){
                removeAllImages();
                addImage(new BodyImage("data/koopaLeft.gif", 2));
                
            } else{
                
                removeAllImages();
                addImage(new BodyImage("data/koopaRight.gif", 2));
            }
            
        } else {
            
            walkingSpeed =  walkingSpeed * -1;
            
             if(walkingSpeed < 0){
                 
                removeAllImages();
                addImage(new BodyImage("data/koopaTroopaLeft.gif", 3));
                
            } else {
                
                removeAllImages();
                addImage(new BodyImage("data/koopaTroopaRight.gif", 3));
            }  
        }
    }
}
