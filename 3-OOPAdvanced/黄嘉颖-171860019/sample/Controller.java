package sample;

import battle.*;
import creature.*;
import queuepattern.*;
import space.*;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.*;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.canvas.*;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.input.*;
import java.util.Stack;


public class Controller {
    private Battle battle;
    private Image battleBackground;
    private int width;
    private int depth;
    private Creature selectedCreature;
    private Timeline timeline;
    private Timeline timelineHuluSort;
    private boolean startOrEnd;
    private boolean currentHuluwaSortDone;
    private int huluSortNum;
    private int lastRand;
    private Stack<Coordinate> path;
    private boolean isHuluwaOnTheSpace;


    @FXML private Canvas canvas;
    @FXML private ImageView selectedImage;
    @FXML private Label selectedLabel;
    @FXML private Button randomHuluTeam;
    @FXML private Button shexingHuluTeam;
    @FXML private Button heyiDemonTeam;
    @FXML private Button yanxingDemonTeam;
    @FXML private Button chongeDemonTeam;
    @FXML private Button changsheDemonTeam;
    @FXML private Button yulinDemonTeam;
    @FXML private Button fangyuanDemonTeam;
    @FXML private Button yanyueDemonTeam;
    @FXML private Button fengshiDemonTeam;
    @FXML private Button grandpaCheer;
    @FXML private Button snakeCheer;
    @FXML private Button randomChange;



    public void initialize(){
        width=1080;
        depth=810;
        battle=new Battle();
        battleBackground=new Image("image/round4.jpg");
        GraphicsContext gc=canvas.getGraphicsContext2D();
        gc.drawImage(battleBackground,100,0,width,depth);
        startOrEnd=false;
        huluSortNum=0;
        lastRand=-1;
        currentHuluwaSortDone=false;
        isHuluwaOnTheSpace=false;

        timeline=new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int rand = (int) Math.round(Math.random() * 7 + 1);
                while(true){
                    if (rand!=lastRand){
                        break;
                    }
                    else {
                        rand = (int) Math.round(Math.random() * 7 + 1);
                    }
                }
                switch (rand) {
                    case 1:
                        battle.snakeTeam.generateTheSpecificPattern(new HeyiPattern(), battle.battleField, 8, 4);
                        display();
                        break;
                    case 2:
                        battle.snakeTeam.generateTheSpecificPattern(new YanxingPattern(), battle.battleField, 14, 3);
                        display();
                        break;
                    case 3:
                        battle.snakeTeam.generateTheSpecificPattern(new ChongePattern(), battle.battleField, 14, 3);
                        display();
                        break;
                    case 4:
                        battle.snakeTeam.generateTheSpecificPattern(new ChangshePattern(), battle.battleField, 14, 3);
                        display();
                        break;
                    case 5:
                        battle.snakeTeam.generateTheSpecificPattern(new YulinPattern(), battle.battleField, 11, 3);
                        display();
                        break;
                    case 6:
                        battle.snakeTeam.generateTheSpecificPattern(new FangyuanPattern(), battle.battleField, 12, 3);
                        display();
                        break;
                    case 7:
                        battle.snakeTeam.generateTheSpecificPattern(new YanyuePattern(), battle.battleField, 14, 2);
                        display();
                        break;
                    case 8:
                        battle.snakeTeam.generateTheSpecificPattern(new FengshiPattern(), battle.battleField, 11, 3);
                        display();
                        break;
                    default:
                        System.out.println("wrong in random!!!");
                }
                lastRand=rand;
            }
        });
        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(keyFrame);

        timelineHuluSort=new Timeline();
        timelineHuluSort.setCycleCount(Timeline.INDEFINITE);
        timelineHuluSort.setAutoReverse(false);
        KeyFrame keyFrameHuluSort=new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (huluSortNum<7) {
                    if (!path.empty()){
                        Coordinate coordinate = new Coordinate();
                        coordinate = path.pop();
                        battle.huluwaTeam.getTheSpecificHuluwa(huluSortNum).moveFrom(battle.battleField);
                        display();
                        battle.huluwaTeam.getTheSpecificHuluwa(huluSortNum).moveTo(battle.battleField, coordinate.getX(), coordinate.getY());
                        display();
                    }
                    else {
                        huluSortNum += 1;
                        if (huluSortNum < 7) {
                            Huluwa currentHuluwa = battle.huluwaTeam.getTheSpecificHuluwa(huluSortNum);
                            int destX = 0;
                            int destY = currentHuluwa.getRank() - 1 + 3;
                            while(true) {
                                if (currentHuluwa.getCoordinateX()==destX&&currentHuluwa.getCoordinateY()==destY){
                                    huluSortNum+=1;
                                    currentHuluwa = battle.huluwaTeam.getTheSpecificHuluwa(huluSortNum);
                                    destX=0;
                                    destY=currentHuluwa.getRank() - 1 + 3;
                                }
                                else{
                                    break;
                                }
                            }
                            if (huluSortNum<7)
                                path = currentHuluwa.moveFromTo(battle.battleField, destX, destY);
                        }
                    }
                }
                else{
                    currentHuluwaSortDone=true;
                    timelineHuluSort.stop();
                }
            }
        });
        timelineHuluSort.getKeyFrames().clear();
        timelineHuluSort.getKeyFrames().add(keyFrameHuluSort);
    }
    public void display(){

        GraphicsContext gc=canvas.getGraphicsContext2D();
        gc.drawImage(battleBackground,100,0,width,depth);
        for (int i=0;i<15;i++)
            for (int j=0;j<15;j++)
                if (battle.battleField.getTheCreatureOnTheCell(i,j)!=null){
                    gc.drawImage(battle.battleField.getTheCreatureOnTheCell(i,j).getPicture(),280+60*i,60*j,60,60);
                }
    }
    @FXML private void randomHuluTeamOnAction(ActionEvent event) {
        //battle.huluwaTeam.randomQueue();
        currentHuluwaSortDone=false;
        huluSortNum=0;
        battle.huluwaTeam.generateTheSpecificPattern(new ChangshePattern(), battle.battleField,3,3);
        display();
        isHuluwaOnTheSpace=true;
    }

    @FXML private void shexingHuluTeamOnAction(ActionEvent event){
        if (isHuluwaOnTheSpace==true) {
            battle.huluwaTeam.bubbleSort();
            Huluwa currentHuluwa = battle.huluwaTeam.getTheSpecificHuluwa(huluSortNum);
            int destX = 0;
            int destY = currentHuluwa.getRank() - 1 + 3;
            while(true) {
                if (currentHuluwa.getCoordinateX()==destX&&currentHuluwa.getCoordinateY()==destY){
                    huluSortNum+=1;
                    currentHuluwa = battle.huluwaTeam.getTheSpecificHuluwa(huluSortNum);
                    destX=0;
                    destY=currentHuluwa.getRank() - 1 + 3;
                }
                else{
                    break;
                }
            }
            path = currentHuluwa.moveFromTo(battle.battleField, destX, destY);
            if (currentHuluwaSortDone == false) {
                timelineHuluSort.play();
            } else {
                timelineHuluSort.stop();
            }
        }
        else{
            //battle.huluwaTeam.bubbleSort();
            battle.huluwaTeam.generateTheSpecificPattern(new ChangshePattern(), battle.battleField,0,3);
            display();
            isHuluwaOnTheSpace=true;
        }
    }

    @FXML private void heyiDemonTeamOnAction(ActionEvent event) {
        battle.snakeTeam.generateTheSpecificPattern(new HeyiPattern(), battle.battleField,8,4);
        display();
    }

    @FXML private void yanxingDemonTeamOnAction(ActionEvent event) {
        battle.snakeTeam.generateTheSpecificPattern(new YanxingPattern(), battle.battleField,14,3);
        display();
    }

    @FXML private void chongeDemonTeamOnAction(ActionEvent event) {
        battle.snakeTeam.generateTheSpecificPattern(new ChongePattern(), battle.battleField,14,3);
        display();
    }

    @FXML private void changsheDemonTeamOnAction(ActionEvent event) {
        battle.snakeTeam.generateTheSpecificPattern(new ChangshePattern(), battle.battleField,14,3);
        display();
    }

    @FXML private void yulinDemonTeamOnAction(ActionEvent event) {
        battle.snakeTeam.generateTheSpecificPattern(new YulinPattern(), battle.battleField,11,3);
        display();
    }

    @FXML private void fangyuanDemonTeamOnAction(ActionEvent event) {
        battle.snakeTeam.generateTheSpecificPattern(new FangyuanPattern(), battle.battleField,12,3);
        display();
    }

    @FXML private void yanyueDemonTeamOnAction(ActionEvent event) {
        battle.snakeTeam.generateTheSpecificPattern(new YanyuePattern(), battle.battleField,14,2);
        display();
    }

    @FXML private void fengshiDemonTeamOnAction(ActionEvent event) {
        battle.snakeTeam.generateTheSpecificPattern(new FengshiPattern(), battle.battleField,11,3);
        display();
    }

    @FXML private void grandpaCheerOnAction(ActionEvent event) {
        battle.huluwaTeam.generateTheCheerPattern(battle.battleField,0,10);
        display();
    }

    @FXML private void snakeCheerOnAction(ActionEvent event) {
        battle.snakeTeam.generateTheCheerPattern(battle.battleField,14,9);
        display();
    }

    @FXML private void randomChangeOnAction(ActionEvent event) {
        startOrEnd=!startOrEnd;
        if (startOrEnd==true)
            timeline.play();
        else timeline.pause();
    }

    @FXML private void canvasOnMouseClicked(MouseEvent event) {
        canvas.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int x=(int)event.getX()-280;
                int y=(int)event.getY();
                //System.out.println("x:"+x+"y:"+y);
                if (x>0&&y>0)
                {
                    x=x/60;
                    y=y/60;
                    if (battle.battleField.getTheCreatureOnTheCell(x,y)!=null){
                        selectedCreature=battle.battleField.getTheCreatureOnTheCell(x,y);
                        selectedImage.setImage(selectedCreature.getPicture());
                        selectedLabel.setText(selectedCreature.getName());
                    }
                }
            }
        });
    }

    @FXML private void canvasOnMouseDragged(MouseEvent event) {
        canvas.setOnMouseDragged(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int x=(int)event.getX()-280;
                int y=(int)event.getY();
                //System.out.println("x:"+x+"y:"+y);
                if (x>0&&y>0)
                {
                    x=x/60;
                    y=y/60;
                    if (selectedCreature!=null&&battle.battleField.isTheCellEmpty(x,y)) {
                        selectedCreature.moveFrom(battle.battleField);
                        selectedCreature.moveTo(battle.battleField,x,y);
                        display();
                    }
                }
            }
        });
    }
}
