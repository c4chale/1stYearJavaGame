/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Collisions;

import Game.Enemies.BasicEnemy;
import Game.Enemies.KoopaTroopa;
import Game.Levels.GameLevel;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

/**
 *
 * @author chale
 */
public class EnemyCollision implements StepListener, CollisionListener{

    private final BasicEnemy enemy;
    private boolean collide;
    private GameLevel world;
    KoopaTroopa koopaTroopa;

    public EnemyCollision(BasicEnemy enemy, GameLevel world) {
        this.enemy = enemy;
        collide = false;
        this.world = world;
    } 
    
    
    
    
    @Override
    public void preStep(StepEvent e) {
        
    }

    @Override
    public void postStep(StepEvent e) {
        if(collide){
            enemy.changeWalkingDirection();
            collide = false;
        }
    }

    @Override
    public void collide(CollisionEvent e) {
        
        if(e.getReportingBody() instanceof KoopaTroopa &&
                e.getOtherBody() instanceof BasicEnemy &&
                world.getEnemies().get(world.getIndexKoopa()).life()==1){
            
            e.getOtherBody().destroy();
            
        } else if(e.getReportingBody() instanceof BasicEnemy && e.getOtherBody() instanceof BasicEnemy){
            collide = true;
        }
        
//        if(e.getOtherBody().getClass().equals(BasicEnemy.class)){
//          collide = true;
//        }
    }
    
}
