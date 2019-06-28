/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Graphics;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.GhostlyFixture;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *
 * @author chale
 */
public class BgImages extends StaticBody{
    private static final Shape tileSize = new BoxShape(1f,1f);
    
    public BgImages(World w, String s) {
        super(w);
        GhostlyFixture f = new GhostlyFixture(this, tileSize);
        addImage(new BodyImage("data/"+s+".png",2));
    }
    
}
