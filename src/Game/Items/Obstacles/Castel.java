/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items.Obstacles;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class Castel extends StaticBody{
    
    private static final Shape shapeCastel = new BoxShape(1,1);
    
    public Castel(World w, Vec2 pos) {
        super(w, shapeCastel);
        setPosition(new Vec2 (pos));
        
    }
    
}
