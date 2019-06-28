/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items.Bricks;

import city.cs.engine.*;

/**
 *
 * @author chale
 */
public interface BasicBrick{
    
    public static Shape brickShape = new BoxShape(1f,1f);
    
    
    public void hitFromBottom();
    
    public void removeIt();
    
    public boolean hasEnemyOnTop();
    
    public void setHasCoin(int coins);
    
    public int getCoins();
    
    
    
}
