package com.example.snakeladder;


import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
     private Circle coin;
    private int currentPosition;
    private String name;
    private static Board gameBoard = new Board();
    public Player(int titelSize, Color coinColor,String PlayerName){
        coin = new Circle(titelSize/2);
        coin.setFill(coinColor);
        currentPosition = 0; // you can set 0out of board
        movePlayer(1);
        name = PlayerName;

    }
    public  void movePlayer(int diceValue){
        if(currentPosition + diceValue<=100){
            currentPosition += diceValue;
            TranslateTransition secondMove = null, firstMove = translateAnimation(diceValue);


            int newPosition = gameBoard.getNewPosition(currentPosition);
            if(newPosition != currentPosition && newPosition != -1){
                currentPosition = newPosition;
                secondMove = translateAnimation(6);
            }
            if(secondMove ==  null){
                firstMove.play();
            }else{
                SequentialTransition sequentialTransition = new SequentialTransition(firstMove,new PauseTransition(Duration.millis(1000)),secondMove);
                sequentialTransition.play();
            }
        }

//        int x = gameBoard.getXCoordinate(currentPosition);
//        int y = gameBoard.getYCoordinate(currentPosition);
//        coin.setTranslateX(x);
//        coin.setTranslateY(y);


    }



    private TranslateTransition translateAnimation(int diceValue){
        TranslateTransition animate = new TranslateTransition(Duration.millis(200*diceValue),coin);
        animate.setToX(gameBoard.getXCoordinate(currentPosition));
        animate.setToY(gameBoard.getYCoordinate(currentPosition)); // use the correct function to get the y-coordinate
        animate.setAutoReverse(false);
        animate.play();
        return animate;
    }





    public Circle getCoin() {
        return coin;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }
}
