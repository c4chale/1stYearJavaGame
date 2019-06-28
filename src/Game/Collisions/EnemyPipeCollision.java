/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Collisions;

import Game.Enemies.BasicEnemy;
import Game.Enemies.Goomba;
import Game.Items.Obstacles.Pipe;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

/**
 *
 * @author chale
 */
public class EnemyPipeCollision implements CollisionListener, StepListener {

    private final BasicEnemy enemy;
    private final Pipe pipe;

    
    private boolean collide;
    
    public EnemyPipeCollision(BasicEnemy enemy, Pipe pipe) {
        this.enemy = enemy;
        this.pipe = pipe;
    }
            
    
    
    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof BasicEnemy && e.getOtherBody() instanceof Pipe){
            collide = true;
        } 
        
        
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
    
}
