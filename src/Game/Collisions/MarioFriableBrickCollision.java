/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Collisions;

import Game.Items.Bricks.FriableBrick;
import Game.Levels.GameLevel;
import Game.Player.Player;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *
 * @author chale
 */
public class MarioFriableBrickCollision implements CollisionListener{

    private Player player;
    private FriableBrick fBrick;
    private GameLevel world;

    public MarioFriableBrickCollision(Player player, FriableBrick fBrick, GameLevel world) {
        this.player = player;
        this.fBrick = fBrick;
        this.world = world;
    }

    
    @Override
    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof FriableBrick &&
                e.getOtherBody() instanceof Player &&
                player.getPosition().x >= fBrick.getPosition().x-1 && 
                player.getPosition().x <= fBrick.getPosition().x+1 &&
                player.getPosition().y <= fBrick.getPosition().y){
            
            world.getFBrick().hitFromBottom();
            
            if(world.getPlayer().getState() > 1){
                world.getPlayer().addPoints(100);
                fBrick.destroy();
            } 
            
            
        }
    }
    
}
