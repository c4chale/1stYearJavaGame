/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Player;

import Game.Levels.GameLevel;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public abstract class Player extends Walker {
    
    static Shape playerShape = new PolygonShape(-0.8f,1f, 0.8f,1f, 0.8f,-0.75f, 0.45f,-1f, -0.45f,-1f, -0.8f,-0.75f);
    
    GameLevel world;
    
    public Player(World world) {
        super(world, playerShape);
    }
    
    public abstract int getLife();
    
    public abstract void decreseLife();
    
    public abstract void increseLife();
    
    public abstract void setState(int state);
    
    public abstract void decreseState();
    
    public abstract void increseState();
    
    public abstract int getState();
    
    public abstract Vec2 getInitialPosition();
    
    public abstract void setInitialPosition(int x, int y);
    
    public abstract int getDirection();
    
    public abstract void setDirection(int direction);
    
    public abstract float getWalkingSpeed();
    
    public abstract void setWalkingSpeed(float x);
    
    public abstract float getJumpingSpeed();
    
    public abstract float getGravity();
   
    public abstract int getCoinCount();
    
    public abstract void addCoin();
    
    public abstract int getPoints();
    
    public abstract void addPoints(int points);
    
}
