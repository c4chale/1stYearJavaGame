/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Levels;
import Game.Collisions.FireBallEnemyCollision;
import Game.Collisions.EnemyCollision;
import Game.Collisions.EnemyPipeCollision;
import Game.Collisions.MarioCastelCollision;
import Game.Collisions.MarioFriableBrickCollision;
import Game.Collisions.MarioEnemyCollision;
import Game.Collisions.MarioQuestionBrickCollision;
import Game.Enemies.BasicEnemy;
import Game.Enemies.Goomba;
import Game.Enemies.KoopaTroopa;
import Game.Game;
import Game.Graphics.BgImages;
import Game.Items.Bricks.FriableBrick;
import Game.Items.Bricks.QuestionBrick;
import Game.Items.Obstacles.Castel;
import Game.Items.Obstacles.Flag;
import Game.Items.Obstacles.Pipe;
import Game.Items.PowerUps.Coin;
import Game.Items.PowerUps.SuperMushroom;
import Game.Player.FireBall;
import Game.Player.Player;
import city.cs.engine.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public abstract class GameLevel extends World implements ActionListener{
    
    protected Player player;
    protected Pipe pipe;
    public Flag flag;
    public FireBall fireBall;
    public ArrayList<FireBall> fireBalls;
    public Castel castel;
    public ArrayList<BasicEnemy> enemies;
    public Goomba enemy;
    public SuperMushroom sMushroom;
    public QuestionBrick qBrick;
    public FriableBrick fBrick;
    public Coin coin;
    public BgImages bgImage;
    public Game game;
    public Timer timer;
    public KoopaTroopa koopa;
    private int indexKoopa;
    
    
    
    
    public void populate(Game game) throws IOException{
        player = setPlayer();
        this.game = game;
    }
    
    public Player getPlayer(){
        return player;
    }
    
    public Pipe getPipe(){
        return pipe;
    }
    
    public FriableBrick getFBrick(){
        return fBrick;
    }
    
    public ArrayList<FireBall> getFireBalls(){
        return fireBalls;
    }
    
    public FireBall getFireBall(){
        return fireBall;
    }
    
    public abstract int getTimeRemaining();
    
    public abstract Player setPlayer();
    
    public abstract boolean isCompleted();
    
    public abstract boolean getGameOver();
    
    public abstract void setGameOver();
    
    public abstract boolean getSubtractLife();
    
    public abstract void setSubtractLife();
    
    public abstract Vec2 getPosTeleport();
    
    public abstract Vec2 getPositonSecretRoom();
    
    public abstract Vec2 getPosTeleportRight();
    
    public abstract Vec2 getPositionExitTeleport();
    
    public abstract ArrayList<BasicEnemy> getEnemies();
    
    public abstract int getFlagPositionX();
    
    public abstract int getCastelPositionX();
     
    public abstract int getLenghtLevel();
    
    
    
    public void addGround(String s, int x, int y){
        x = x*2-15;
        
        Shape boxShape = new BoxShape(1f, 1f);
        Body ground = new StaticBody(this, boxShape);
        ground.setPosition(new Vec2(x, y));
        ground.addImage(new BodyImage("data/" + s + ".png", 2));
            
    }
    
    public void addBrick(String s, int x, int y){
        x = x*2-15;
        
        Shape boxShape = new BoxShape(1f, 1f);
        fBrick = new FriableBrick(this);
        fBrick.addCollisionListener(new MarioFriableBrickCollision(player, fBrick, this));
        fBrick.setPosition(new Vec2(x, y));
        fBrick.addImage(new BodyImage("data/" + s + ".png", 2));
            
    }
    
    public void addQuestionBrick(String s, int x, int y){
         
        Shape boxShape = new BoxShape(1f, 1f);
        qBrick = new QuestionBrick(this, new Vec2(x*2-15, y));
        qBrick.addCollisionListener(new MarioQuestionBrickCollision(player, qBrick, sMushroom, this));
            
    }
    public void addPipe(String s,int x, int y){
        x=x*2-15;
        pipe = new Pipe(this, new Vec2 (x, y), s, this);
    }
    
   public void addCoin(String s, int x, int y){
         
        Shape boxShape = new BoxShape(1f, 1f);
        coin = new Coin(this);
        coin.getBody().setPosition(new Vec2(x*2-15, y));
            
    }
   
    public Coin getCoin(){
        return coin;
    }
   
    public void addBgImages(String s, int x, int y){
        x=x*2-15;
        bgImage = new BgImages(this, s);
        bgImage.setPosition(new Vec2(x,y));
       
    }
     
    public void addFlag(String s, int x, int y){
        x=x*2-15;
        flag = new Flag(this, new Vec2(x, y), s);
    }
     
    
    public void addEnemy(String nameEnemy, int x, int y){
        
        x=x*2-15;
        
                
        if("goomba".equals(nameEnemy)){
        
            BasicEnemy newEnemy = new Goomba(this, new Vec2(x, y), nameEnemy);
        
            newEnemy.addCollisionListener(new FireBallEnemyCollision(newEnemy, fireBall, player, this));

            newEnemy.addCollisionListener(new MarioEnemyCollision(player, newEnemy, this));
            
            EnemyPipeCollision gpc = new EnemyPipeCollision(newEnemy, pipe);
            this.addStepListener(gpc);
            newEnemy.addCollisionListener(gpc);

            EnemyCollision ec = new EnemyCollision(newEnemy, this);
            this.addStepListener(ec);
            newEnemy.addCollisionListener(ec);

            enemies.add(newEnemy);
        } else if("koopaTroopa".equals(nameEnemy)){
            
            BasicEnemy newEnemy = new KoopaTroopa(this, new Vec2(x, y), nameEnemy);
        
            newEnemy.addCollisionListener(new FireBallEnemyCollision(newEnemy, fireBall, player, this));

            newEnemy.addCollisionListener(new MarioEnemyCollision(player, newEnemy, this));
            
            EnemyPipeCollision epc = new EnemyPipeCollision(newEnemy, pipe);
            this.addStepListener(epc);
            newEnemy.addCollisionListener(epc);
            
           
            EnemyCollision ec = new EnemyCollision(newEnemy, this);
            this.addStepListener(ec);
            newEnemy.addCollisionListener(ec);
            
            
            
            enemies.add(newEnemy);
            indexKoopa = enemies.indexOf(newEnemy);
        }
    }
    
    public int getIndexKoopa(){
        return indexKoopa;
    }
    
    public void addCollisionListenersPipe(){
        for(BasicEnemy enemy : enemies){
            pipe.addCollisionListener(new EnemyPipeCollision(enemy, pipe));
        }
    }
    
    public void addCastel(String s, int x, int y){
        x=x*2-15;
        castel = new Castel(this, new Vec2(x,y));
                castel.addImage(new BodyImage("data/"+s+".png",2));
                castel.addCollisionListener(new MarioCastelCollision(game, this));
    }
    
    public void shoot(){
        if(player.getDirection()==0){
            fireBall = new FireBall(this, new Vec2(player.getPosition().x+1.5f,player.getPosition().y));
            
            for(BasicEnemy enemy : enemies){
                fireBall.addCollisionListener(new FireBallEnemyCollision(enemy, fireBall, player, this));
            }
            fireBall.applyForce(new Vec2(player.getPosition().x+800, player.getPosition().y-500));

            if(fireBalls.size() >= 3){
                fireBalls.get(0).destroy();
                fireBalls.remove(0);
                fireBalls.add(fireBall);
            } else {
                fireBalls.add(fireBall);
            }

        } else {
            fireBall = new FireBall(this, new Vec2(player.getPosition().x-1.5f,player.getPosition().y));
            
            for(BasicEnemy enemy : enemies){
                fireBall.addCollisionListener(new FireBallEnemyCollision(enemy, fireBall, player, this));
            }
            fireBall.applyForce(new Vec2(player.getPosition().x-800, player.getPosition().y-500));

             if(fireBalls.size() >= 3){
                fireBalls.get(0).destroy();
                fireBalls.remove(0);
                fireBalls.add(fireBall);
            } else {
                fireBalls.add(fireBall);

            }
             
             
        }
    }
}
