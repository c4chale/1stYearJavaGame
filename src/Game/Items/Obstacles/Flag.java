/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items.Obstacles;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Sensor;
import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class Flag extends Sensor implements SensorListener{
    
    private static Shape flagShape = new BoxShape(1f,1f);
    
    public Flag(World w, Vec2 pos, String s) {
        super(new StaticBody(w), flagShape);
        this.addSensorListener(this);
        this.getBody().setPosition(new Vec2(pos));
        this.getBody().addImage(new BodyImage("data/" + s + ".png", 2));
    }

    @Override
    public void beginContact(SensorEvent e) {
        
    }

    @Override
    public void endContact(SensorEvent e) {
        
    }
    
    
}
