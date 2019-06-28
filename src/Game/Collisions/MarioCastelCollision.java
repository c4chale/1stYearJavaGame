/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Collisions;

import Game.Game;
import Game.Items.Obstacles.Castel;
import Game.Levels.GameLevel;
import Game.Player.Player;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chale
 */
public class MarioCastelCollision implements CollisionListener {
    private Game game;
    private GameLevel world;
          
    
    public MarioCastelCollision(Game game, GameLevel world) {
        this.game = game;
        this.world = world;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Castel && e.getOtherBody() instanceof Player && world.isCompleted()) {
            System.out.println("Going to next level...");
            try {
                game.goNextLevel();
            } catch (IOException ex) {
                Logger.getLogger(MarioCastelCollision.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}