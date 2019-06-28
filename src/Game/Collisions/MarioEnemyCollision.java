/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Collisions;

import Game.Enemies.BasicEnemy;
import Game.Levels.GameLevel;
import Game.Player.Player;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class MarioEnemyCollision implements CollisionListener {

    public final Player player;
    private final BasicEnemy enemy;
    private GameLevel world;

    public MarioEnemyCollision(Player player, BasicEnemy enemy, GameLevel world) {
        this.player = player;
        this.enemy = enemy;
        this.world = world;
    }
    
    
    
    
    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof BasicEnemy && e.getOtherBody() instanceof Player && player.getPosition().y-0.9f > enemy.getPosition().y){
            enemy.decreseLife();
            player.applyForce(new Vec2(0,20000));
            if(enemy.life()==0){
                enemy.destroy();
            }
        } else if (e.getReportingBody() instanceof BasicEnemy && e.getOtherBody() instanceof Player){
            if(player.getState() == 1){
                player.setPosition(new Vec2(1,0));
                player.decreseLife();
                world.setSubtractLife();
            }
            
            if(player.getState()>1){
                player.decreseState();
            }
            
            if (player.getLife()<0){
                world.setGameOver();
            
            }
        }
    }
}
