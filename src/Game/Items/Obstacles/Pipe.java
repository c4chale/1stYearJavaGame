/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items.Obstacles;

import Game.Levels.GameLevel;
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
public class Pipe extends StaticBody {
    
   private static final Shape pipeShape = new BoxShape(1f,1f);
   public boolean hasTeleport;
   private GameLevel w;
   

   
    public Pipe (World world, Vec2 vec2, String image, GameLevel w) {
        super(world, pipeShape);
        this.w = w;
        setPosition(new Vec2 (vec2));
        addImage(new BodyImage ("data/"+image+".png", 2f));
        
    }
    
    public void setHasTeleport(){
        hasTeleport = true;
    }
    
    public boolean getHasTeleport(){
        return hasTeleport;
    } 
}
