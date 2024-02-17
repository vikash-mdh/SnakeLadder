package com.example.snakeladder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.IOException;

public class SnakeLadder extends Application {
    public static final int titelSize=40, width=10, height=10;
    public static final int  buttonLine = height*titelSize+50, infoLine = buttonLine-30;
    private static Dice dice = new Dice();
    private  Player playerOne, playerTwo;
    private boolean gameStated = false, playerOneTurn = false, playerTwoTurn = false;
    private Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*titelSize,height*titelSize + 100);
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                Tile tile = new Tile(titelSize);
                tile.setTranslateX(j*titelSize);
                tile.setTranslateY(i*titelSize);
                root.getChildren().add(tile);

            }
        }
        String imagePath = "/Users/vikashkumar/Desktop/SnakeLadder/src/main/java/SnakeIMG.jpeg";
        File file = new File(imagePath);
        Image img = new Image(file.toURI().toString());
        ImageView board = new ImageView(img);
        board.setFitHeight(height*titelSize);
        board.setFitWidth(width*titelSize);
        // button
        Button playerOneButton = new Button("Player One");
        Button playerTwoButton = new Button("Player Two");
        Button startButton = new Button("Start");




        playerOneButton.setTranslateY(buttonLine);
        playerOneButton.setTranslateX(20);
        playerTwoButton.setTranslateY(buttonLine);
        playerTwoButton.setTranslateX(300);
        startButton.setTranslateY(buttonLine);
        startButton.setTranslateX(170);

        // infoLine Display
        Label playerOnelavel =  new Label("You Turn! P1");
        Label playerTwolavel =  new Label("You Turn! P2");
        Label Dicelavel =  new Label("Start the Game");

        playerOnelavel.setTranslateY(infoLine);
        playerOnelavel.setTranslateX(20);
        playerTwolavel.setTranslateY(infoLine);
        playerTwolavel.setTranslateX(300);
        Dicelavel.setTranslateY(infoLine);
        Dicelavel.setTranslateX(150);



        playerOne = new Player(titelSize, Color.BLACK," Rahul");
        playerTwo = new Player(titelSize-5, Color.WHITE," Ratan");

        // player Action
      playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
              if(gameStated){
                  if(playerOneTurn){
                      int diceValue = dice.getRolledDiceValue();
                      Dicelavel.setText("Dice Value : "+ diceValue);
                      playerOne.movePlayer(diceValue);

                      playerOneTurn = false;
                      playerOneButton.setDisable(true);
                      playerOnelavel.setText("");

                      playerTwoTurn = true;
                      playerTwoButton.setDisable(false);
                      playerTwolavel.setText("Your Turn"+ playerTwo.getName());

                  }
              }

          }
      });
      startButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
              gameStated = true;
              Dicelavel.setText("Game Started");
              startButton.setDisable(true);
              playerOneTurn = true;
              playerOnelavel.setText("you turn"+ playerOne.getName());
              playerTwoTurn = false;
              playerTwolavel.setText("");
              playerTwoButton.setDisable(true);
          }
      });

   playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
       @Override
       public void handle(ActionEvent actionEvent) {
           if(gameStated){
               if(playerTwoTurn){
                   int diceValue = dice.getRolledDiceValue();
                   Dicelavel.setText("Dice Value : "+ diceValue);
                   playerTwo.movePlayer(diceValue);

                   playerOneTurn = true;
                   playerOneButton.setDisable(false);
                   playerOnelavel.setText("Your Turn"+ playerOne.getName());

                   playerTwoTurn = true;
                   playerTwoButton.setDisable(false);
                   playerTwolavel.setText("");

               }
           }

       }
   });


        root.getChildren().addAll(board,playerOneButton,
                playerTwoButton,startButton,playerOnelavel,
                playerTwolavel,Dicelavel,playerOne.getCoin(),
                playerTwo.getCoin()
        );
        return root;
    }



    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder !");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}