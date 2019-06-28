/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Enemies;

import Game.Levels.GameLevel;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class Goomba extends BasicEnemy{

    private GameLevel world;
    
    private float walkingSpeed = -3;
    private int life = 1;
    
    public Goomba(World world, Vec2 pos, String s) {
        super(world);
        setPosition(new Vec2(pos));
        addImage(new BodyImage("data/goomba.gif", 2));
        
    }

    @Override
    public void marioJumpedOnEnemy() {
        this.destroy(); // add animation
    }

    @Override
    public void killedByFireBall() {
        this.destroy(); // add animation
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
        if(life == 0){
            this.destroy();
        }
    }

    @Override
    public float getWalkingSpeed() {
        return walkingSpeed;
    }

    @Override
    public void changeWalkingDirection() {
        walkingSpeed = walkingSpeed * -1;
    }

    
    
}
