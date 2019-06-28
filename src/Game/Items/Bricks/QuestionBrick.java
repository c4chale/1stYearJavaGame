/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items.Bricks;

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
public class QuestionBrick extends StaticBody implements BasicBrick{
    
    private static final Shape brickShape = new BoxShape(1f,1f);
   
    private boolean activationState = false;
    private boolean haveMushroom = false;
    private int coinInside;
    private boolean hasCoin;
   
    public QuestionBrick (World world, Vec2 pos) {
        super(world, brickShape);
        setPosition(new Vec2 (pos));
        addImage(new BodyImage("data/questionBrick.gif", 2));
    }
    
    public boolean getState(){
        return activationState;
    }
    
    public void activateState(){
        activationState = true;
        removeAllImages();
        addImage(new BodyImage("data/questionBrickActive.png",2));
        
    }
    
    public void setHaveMushroom(){
        haveMushroom = true;
    }
    
    public boolean getHaveMushroom(){
        return haveMushroom;
    }

    @Override
    public void hitFromBottom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeIt() {
        destroy();
    }

    @Override
    public boolean hasEnemyOnTop() {
        return true;
    }

    @Override
    public void setHasCoin(int coins) {
       hasCoin = true;
       coinInside = coins;
    }

    @Override
    public int getCoins() {
        return coinInside;
    }
}
