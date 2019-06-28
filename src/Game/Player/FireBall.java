/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Player;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class FireBall extends DynamicBody{
    
    private static final Shape fireBallShape = new CircleShape(0.5f);
    private int bounceCount;
    public FireBall(World w, Vec2 pos) {
        super(w,fireBallShape);
        setPosition(pos);
        addImage(new BodyImage("data/fireBall.gif", 1));
    }
    
    public int getBounceCount(){
        return bounceCount;
    }
    
    public void increseBounceCount(){
        bounceCount++;
    }
}
