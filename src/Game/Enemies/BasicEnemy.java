/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Enemies;

import city.cs.engine.Body;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;


/**
 *
 * @author chale
 */
public abstract class BasicEnemy extends Walker{
    
    protected static final Shape enemyShape = new PolygonShape(-1f,1f, 1f,1f, 1f,-0.75f, 0.45f,-1f, -0.45f,-1f, -1f,-0.75f);

    
    public BasicEnemy(World world) {
        super(world, enemyShape);
    }
    
    public Body getEnemy(){
        return this;
    }
    
    public abstract void marioJumpedOnEnemy();
    
    public abstract void killedByFireBall();
    
    public abstract void collideWithJumpingBrick();
    
    public abstract int life();
    
    public abstract void decreseLife();
    
    public abstract float getWalkingSpeed();
    
    public abstract void changeWalkingDirection();

}
