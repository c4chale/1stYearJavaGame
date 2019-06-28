/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Levels.LevelOne;

import Game.Collisions.MarioCastelCollision;
import Game.Collisions.MarioEnemyCollision;
import Game.Collisions.MarioFriableBrickCollision;
import Game.Collisions.MarioQuestionBrickCollision;
import Game.Enemies.BasicEnemy;
import Game.Game;
import Game.Levels.GameLevel;
import Game.Player.Mario;
import Game.Player.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 *
 * @author chale
 */
public class Level_12 extends GameLevel implements ActionListener {

    private final String fileName;
    private String[] tokens;
    private Timer timer;
    private int timeRemaining;
    private int timeToRender;
    private boolean gameOver;
    private boolean subtractLifeState;

    public Level_12(String fileName) throws IOException {
        this.fileName = fileName;
        timeRemaining = 300;
        timeToRender = 3;
        gameOver = false;
        subtractLifeState = false;
    }
    
    
     @Override 
    public void populate(Game game) throws IOException{
        super.populate(game);
        
        enemies = new ArrayList<>();
        fireBalls = new ArrayList<>();
        
        timer = new Timer(1000, this);
        timer.setInitialDelay(3000); 
        timer.start();
        
       
        
        
        
        FileReader fr = new FileReader(fileName);   
        BufferedReader reader = new BufferedReader(fr);
        
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            int lineCount = 9;
            while (line != null) {
                
                tokens = line.split(",");
                
                for(int i=0; i<tokens.length; i++){
                    switch (tokens[i]) {
                        case "0":
                            addGround("ground",i, lineCount);
                            break;                      
                        case "29":
                            addBrick("brick",i,lineCount);
                            break;
                        case "23":
                            addQuestionBrick("questionBrick",i,lineCount);
                            break;
                        case "27": // brick with growing mushroom
                            addQuestionBrick("questionBrick",i,lineCount);
                            qBrick.setHaveMushroom();
                            break;
                        case "1":
                            addBrick("friableBrick",i,lineCount);
                            break;
                        case "52":
                            addCoin("coin",i,lineCount);
                            break;
                        case "58":
                            addGround("blueGround",i,lineCount);
                            break;
                        case "71":
                            addBrick("blueFriableBrick",i,lineCount);
                            break;
                        case "87":
                            addPipe("blueBrick",i,lineCount);
                            break;
                        case "248":
                            addFlag("flagTop",i,lineCount);
                            break;
                        case "277":
                            addFlag("flag",i,lineCount);
                            break;
                        case "232":
                            addPipe("pipe1",i,lineCount);
                            break;
                        case "233":
                            addPipe("pipe2",i,lineCount);
                            break;
                        case "261":
                            addPipe("pipe3",i,lineCount);
                            break;
                        case "262":
                            addPipe("pipe4",i,lineCount);
                            break;
                        case "234":
                            addPipe("pipe21",i,lineCount);
                            break;
                        case "235":
                            addPipe("pipe41",i,lineCount);
                            break;
                        case "236":
                            addPipe("pipe6",i,lineCount);
                            break;
                        case "263":
                            addPipe("pipe11",i,lineCount);
                            break;
                        case "264":
                            addPipe("pipe31",i,lineCount);
                            break;
                        case "265":
                            addPipe("pipe5",i,lineCount);
                            break;
                        case "11":
                            addCastel("11",i,lineCount);
                            break;
                        case "12":
                            addCastel("12",i,lineCount);
                            break;
                        case "13":
                            addCastel("13",i,lineCount);
                            break;
                        case "14":
                            addCastel("14",i,lineCount);
                            break;
                        case "40":
                            addCastel("40",i,lineCount);
                            break;
                        case "41":
                            addCastel("41",i,lineCount);
                            break;
                        case "42":
                            addCastel("42",i,lineCount);
                            break;
                        case "354":
                            addBrick("354",i,lineCount);
                            break;
                        case "16":
                            addEnemy("goomba", i,lineCount+2);
                            break;
                        case "190": //KoopaTroopa
                            addEnemy("koopaTroopa",i,lineCount+2);
                            break;
                        default:
                            break;
                    }
                }
                
                for(int i=0; i<tokens.length; i++){
                        switch (tokens[i]) {
                            case "240":
                                addBgImages("240",i,lineCount);
                                break;
                            case "241":
                                addBgImages("241",i,lineCount);
                                break;
                            case "242":
                                addBgImages("242",i,lineCount);
                                break;
                            case "269":
                                addBgImages("269",i,lineCount);
                                break;
                            case "270":
                                addBgImages("270",i,lineCount);
                                break;
                            case "271":
                                addBgImages("271",i,lineCount);
                                break;
                            case "580":
                                addBgImages("580",i,lineCount);
                                break;
                            case "581":
                                addBgImages("581",i,lineCount);
                                break;
                            case "582":
                                addBgImages("582",i,lineCount);
                                break;
                            case "609":
                                addBgImages("609",i,lineCount);
                                break;
                            case "610":
                                addBgImages("610",i,lineCount);
                                break;
                            case "611":
                                addBgImages("611",i,lineCount);
                                break;
                            case "272":
                                addBgImages("272",i,lineCount);
                                break;
                            case "273":
                                addBgImages("273",i,lineCount);
                                break;
                            case "274":
                                addBgImages("274",i,lineCount);
                                break;
                            default:
                                break; 
                        }
                    }   
                
                line = reader.readLine();
                lineCount-=2;
            }
            System.out.println("...done.");
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
            
        }
    
    }
    
    @Override
    public int getTimeRemaining() {
        return timeRemaining;
    }

    @Override
    public Player setPlayer() {
        player = new Mario(this);
        player.setPosition(new Vec2(0,0));
        player.addCollisionListener(new MarioEnemyCollision(player,enemy, this));
        player.addCollisionListener(new MarioQuestionBrickCollision(player, qBrick, sMushroom, this));
        player.addCollisionListener(new MarioFriableBrickCollision(player, fBrick, this));
        player.addCollisionListener(new MarioCastelCollision(game, this));
        
        return player;
    }

    @Override
    public boolean isCompleted() {
        return player.getPosition().x >= flag.getBody().getPosition().x;
    }

    @Override
    public boolean getGameOver() {
        return gameOver;
    }

    @Override
    public void setGameOver() {
        gameOver = true;
    }

    @Override
    public boolean getSubtractLife() {
        return subtractLifeState;
    }

    @Override
    public void setSubtractLife() {
        subtractLifeState = true;
        this.stop();
    }

    @Override
    public Vec2 getPosTeleport() {
        Vec2 pos;
        pos = new Vec2(224, -3);
        
        return pos;
    }

    @Override
    public Vec2 getPositonSecretRoom() {
        Vec2 posRoom;
        posRoom = new Vec2(flag.getBody().getPosition().x+18*2, 10);
        
        return posRoom;
    }

    @Override
    public Vec2 getPosTeleportRight() {
        Vec2 posTelRight;
        if(player.getPosition().x < 5){
            posTelRight = new Vec2(3.5f,-11);
        } else if(player.getPosition().x > 340){
            posTelRight = new Vec2(346, -6);
        } else {
             posTelRight = new Vec2(502, -11);
        }
        return posTelRight;
    }

    @Override
    public Vec2 getPositionExitTeleport() {
        Vec2 exitTeleport;
        
        if(player.getPosition().x < 5){
            exitTeleport = new Vec2(23, 8);
        } else if(player.getPosition().x > 340){
            exitTeleport = new Vec2(410, -8);
        } else{
        exitTeleport = new Vec2(248, -7);
        }
        return exitTeleport;
    }

    @Override
    public ArrayList<BasicEnemy> getEnemies() {
        return enemies;
    }

    @Override
    public int getFlagPositionX() {
         return (int) flag.getBody().getPosition().x;
    }

    @Override
    public int getCastelPositionX() {
         return (int) flag.getBody().getPosition().x+18*2;
    }

    @Override
    public int getLenghtLevel() {
        return tokens.length*16;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(timeRemaining <= 0){
            this.stop();
            this.setGameOver();
        } else{
            if(!getSubtractLife()){
                timeRemaining--;
            } else if(timeToRender > 0){
                timeToRender--;
            } else{
                subtractLifeState = false;
                timeToRender = 3;
                this.start();
            }
        }
    }
    
}
