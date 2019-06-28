/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Collisions;

import Game.Enemies.BasicEnemy;
import Game.Levels.GameLevel;
import Game.Player.FireBall;
import Game.Player.Player;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *
 * @author chale
 */
public class FireBallEnemyCollision implements CollisionListener{
    
    private final BasicEnemy enemy;
    private final FireBall fireBall;
    private GameLevel world;
    private final Player player;

    public FireBallEnemyCollision(BasicEnemy enemy, FireBall fireBall, Player player, GameLevel world) {
        this.enemy = enemy;
        this.fireBall = fireBall;
        this.player = player;
        this.world = world;
        
    }

    
    
    @Override
    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof BasicEnemy && e.getOtherBody() instanceof FireBall){
            enemy.destroy();
            world.getFireBalls().get(world.getFireBalls().indexOf(world.getFireBall())).destroy();
            world.getFireBalls().remove(0);
            player.addPoints(250);
        }
    }
    
}
