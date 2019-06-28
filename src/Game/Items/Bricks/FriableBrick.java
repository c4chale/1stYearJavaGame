/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items.Bricks;

import Game.Enemies.*;
import Game.Levels.GameLevel;
import Game.Player.Player;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class FriableBrick extends StaticBody implements BasicBrick{

    private BasicEnemy enemy;
    private Player player;
    private static final Shape brickShape = new BoxShape(1f,1f);
    private boolean hasCoin;
    private int coinInside;
    private GameLevel world;
    
    public FriableBrick(World w) {
        super(w, brickShape);
        world = (GameLevel)w;
        
    }
    
    

    @Override
    public void hitFromBottom() {
        
        move(new Vec2(this.getPosition().x, this.getPosition().y+1));
        move(new Vec2(this.getPosition().x, this.getPosition().y-1));
        
    }

    @Override
    public void removeIt() {
        this.destroy();
    }

    @Override
    public boolean hasEnemyOnTop() {
        if(enemy.getEnemy().getPosition().x == this.getPosition().x){
            return true;
        }else
            
        return false;
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
