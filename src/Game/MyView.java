/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Items.PowerUps.Coin;
import Game.Levels.GameLevel;
import Game.Player.Player;
import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author chale
 */
public class MyView extends UserView {
  
   private final GameLevel world;
   private final Player player;
   private final Image imageCoin;
   private final Image imageMario;
   private final Coin coin;
   private final Game game;
         
   //private GraphicInterface gi;
   
    
    public MyView(World w, Player player, Game game, int width, int height) {
        super(w, width, height);
        this.player = player;
        this.world = (GameLevel) w;
        this.game = game;
        imageCoin = new ImageIcon("data/coin.gif").getImage();
        imageMario = new ImageIcon("data/marioRight.png").getImage();
        
        coin = ((GameLevel)w).getCoin();
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        if(game.getLevel() ==1){
            if (player.getPosition().x > world.getPositonSecretRoom().x-6 || world.getGameOver() || world.getSubtractLife()){
                g.setColor(Color.black);
            } else{
                g.setColor(new Color(99, 184, 255, 168));
            }
        } else if(game.getLevel() == 2){
            if(player.getPosition().x <= 16 || player.getPosition().x > 402 && player.getPosition().x < 480){
                g.setColor(new Color(99, 184, 255, 168));
            } else if(world.getGameOver() || world.getSubtractLife()){
                g.setColor(Color.black);
            } else { 
                g.setColor(Color.black);
            }
        } else if(game.getLevel() == 3){
            g.setColor(new Color(99, 184, 255, 168));
        }
        g.fillRect(0, 0, 640, 640);
        
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        if(!world.getGameOver()){
            if(!world.getSubtractLife()){
                g.setColor(Color.white);
                g.setFont(new Font("helvetica", Font.BOLD, 20));
                g.drawString("MARIO", 60, 40);
                g.drawString(String.format("%06d",(int)world.getPlayer().getPoints()), 60, 60);

                g.drawImage(imageCoin, 206, 45, this);
                g.drawString(String.format("x %03d", world.getPlayer().getCoinCount()) , 225, 60);

                g.drawImage(imageMario, 370, 45, this);
                g.drawString(String.format("x %02d", world.getPlayer().getLife()) , 392, 60);

                g.drawString("TIME", 500, 40);
                g.drawString(String.format("%03d",world.getTimeRemaining()) , 508, 60);
            } else{
                g.setColor(Color.white);
                g.setFont(new Font("helvetica", Font.BOLD, 30));
                
                g.drawImage(imageMario, 280, 315, 30, 30, this);
                g.drawString(String.format("x %02d", world.getPlayer().getLife()) , 320, 340);
            }
        } else{
            g.setColor(Color.white);
            g.setFont(new Font("helvetica", Font.BOLD, 50));
            g.drawString("GAME OVER", 165, 340);
             
        }
    }
    
}
