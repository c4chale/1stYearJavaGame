/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items.PowerUps;

import Game.Player.Player;
import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Sensor;
import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *
 * @author chale
 */
public class Coin extends Sensor implements SensorListener{
    private static final Shape coinShape = new BoxShape(1f,1f);
    
    
    public int count;
   
    
    public Coin(World w) {
        super(new StaticBody(w), coinShape);
        this.addSensorListener(this);
        this.getBody().addImage(new BodyImage("data/coin.gif", 2f)); 
        count=0;
        
    }

    @Override
    public void beginContact(SensorEvent e) {
        if(e.getContactBody() instanceof Player){
            ((Player)e.getContactBody()).addCoin();
            ((Player)e.getContactBody()).addPoints(150);
            this.getBody().destroy();
        }
    }

    @Override
    public void endContact(SensorEvent e) {
        
    }
    
   
    
    
    
}
