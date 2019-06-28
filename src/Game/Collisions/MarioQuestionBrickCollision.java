/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Collisions;

import Game.Items.Bricks.QuestionBrick;
import Game.Items.PowerUps.SuperMushroom;
import Game.Levels.GameLevel;
import Game.Player.Player;
import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class MarioQuestionBrickCollision implements CollisionListener {

    private Player player;
    private QuestionBrick qBrick;
    private SuperMushroom sMushroom;
    private GameLevel world;

    public MarioQuestionBrickCollision(Player player, QuestionBrick qBrick, SuperMushroom sMushroom, GameLevel world) {
        this.player = player;
        this.qBrick = qBrick;
        this.sMushroom = sMushroom;
        this.world = world;
    }
    
    
    
    @Override
    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof QuestionBrick && e.getOtherBody()== player &&
                player.getPosition().y < qBrick.getPosition().y-1f){

            
            if (qBrick.getState() == false){
                qBrick.activateState();
                player.addPoints(250);
                
                if(player.getState() == 1 && qBrick.getHaveMushroom()){
                    sMushroom = new SuperMushroom(world, new Vec2(qBrick.getPosition().x, qBrick.getPosition().y+2f));
                    sMushroom.addCollisionListener(this);
                    sMushroom.startWalking(3);
                } else if(player.getState() == 2 && qBrick.getHaveMushroom()){
                    sMushroom = new SuperMushroom(world, new Vec2(qBrick.getPosition().x, qBrick.getPosition().y+2f));
                    sMushroom.removeAllImages();
                    sMushroom.addImage(new BodyImage("data/flower.png", 2f));
                    sMushroom.addCollisionListener(this);  
                } else {
                    player.addCoin();
                }
            }
         
        }
        
        if(e.getReportingBody() instanceof SuperMushroom &&
                e.getOtherBody() instanceof Player){
            if(player.getState()<3){
                player.increseState();
            }
            sMushroom.destroy();
            player.addPoints(200);
        }
        
    }
    
}
