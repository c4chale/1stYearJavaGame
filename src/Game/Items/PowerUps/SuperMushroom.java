/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items.PowerUps;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class SuperMushroom extends Walker {
    
     private static final Shape mushroomShape = new PolygonShape(-1f,1f, 1f,1f, 1f,-0.75f, 0.45f,-1f, -0.45f,-1f, -1f,-0.75f);
    
    public SuperMushroom(World world, Vec2 pos) {
        super(world, mushroomShape);
        setPosition(new Vec2(pos));
        addImage(new BodyImage("data/superMushroom.png", 2));
    }
    
}
