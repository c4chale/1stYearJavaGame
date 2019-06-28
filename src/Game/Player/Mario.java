/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Player;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class Mario extends Player{
    
    
    private int life;
    private int state;
    private Vec2 pos;
    private int direction;
    private boolean hasStar;
    private int coinCount;
    private int points;
    private Fixture s;
    AttachedImage a;
    
    
    private static final float JUMPING_SPEED = 45;
    private static float WALKING_SPEED = 7;
    private static final float GRAVITY = 9.8f; 
    
    private static BodyImage image = new BodyImage("data/marioRight.png", 2);
    
    public Mario(World world) {
        super(world);
        setGravityScale(GRAVITY);
        
        life = 3;
        state = 1;
        direction = 0;
        
        addImage(image);
    }

    public boolean hasStar(){
        return hasStar;
    }
    
    public void setHasStar(boolean hasStar){
        this.hasStar = hasStar;
    }
    
    @Override
     public void addCoin(){
        coinCount++;
    }
   
    @Override
    public int getCoinCount(){
        return coinCount;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void addPoints(int points) {
        this.points = this.points + points;
    }
     
    
    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void decreseLife() {
        life--;
    }
    
    @Override
    public void increseLife() {
        life++;
    }

    /**
     *
     * @param state
     * 
     * 0 = death
     * 1 = small Mario
     * 2 = Super Mario
     * 3 = fire Mario
     */
    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void decreseState() {
        state--;
        
        switch (state) {
            case 1:
                
                s.destroy();
                this.removeAllImages();
                this.addImage(new BodyImage("data/marioRight.png", 2));
                break;
            case 2:
                this.removeAllImages();
                this.addImage(new BodyImage("data/bigMarioRight.png", 4));
                break;
            case 3:
                this.removeAllImages();
                this.addImage(new BodyImage("data/fireMarioRight.png", 4));
                break;
            default:
                break;
        }
    }

    @Override
    public void increseState() {
        state++;
        
        switch (state) {
            case 1:
                this.removeAllImages();
                this.addImage(new BodyImage("data/marioRight.png", 2));
                break;
            case 2:
                s = new SolidFixture(this, new BoxShape(0.8f, 1f, new Vec2(0, 2)));
                System.out.println(this.getPosition());
                
                this.removeAllImages();
                a = new AttachedImage(this, new BodyImage("data/bigMarioRight.png"), 4, 0, new Vec2(0, 1));
                break;
            case 3:
                this.removeAllImages();
                this.addImage(new BodyImage("data/fireMarioRight.png", 4));
                break;
            default:
                break;
        }
    }
    
    

    @Override
    public Vec2 getInitialPosition() {
        return pos;
    }

    @Override
    public void setInitialPosition(int x, int y) {
        pos = new Vec2(x,y);
    }

    @Override
    public int getDirection() {
        return direction;
    }

    /**
     *
     * @param direction
     * 0 = dx;
     * 1 = sx;
     */
    @Override
    public void setDirection(int direction) {
        this.direction = direction;
    }  

    @Override
    public float getWalkingSpeed() {
        return WALKING_SPEED;
    }

    @Override
    public void setWalkingSpeed(float x) {
        WALKING_SPEED = x;
    }
    

    @Override
    public float getJumpingSpeed() {
        return JUMPING_SPEED;
    }

    @Override
    public float getGravity() {
        return GRAVITY;
    }
    
    
}
