package com.example.snakeladder;

import javafx.util.Pair;

import java.net.PortUnreachableException;
import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer, Integer>> positionCoordinates;
    ArrayList<Integer> snaeLadderPosition;

    public Board(){
        positionCoordinates = new ArrayList<>();
        populatesPositionCordinates();
        populateSnakeLadder();
    }
    private void  populatesPositionCordinates(){
        positionCoordinates.add(new Pair<>(0, 0));
        for (int i = 0; i < SnakeLadder.height; i++) {
            for (int j = 0; j < SnakeLadder.width; j++) {


                // X coordinates
                int xCore = 0;
                if(i % 2 == 0){
                    xCore = j*SnakeLadder.titelSize + SnakeLadder.titelSize/2;

                }else{
                    xCore = SnakeLadder.titelSize*SnakeLadder.height - (j*SnakeLadder.titelSize) - SnakeLadder.titelSize/2;
                }
                // y coordinates
                int yCord = SnakeLadder.titelSize*SnakeLadder.height - (i*SnakeLadder.titelSize) - SnakeLadder.titelSize/2;
                positionCoordinates.add(new Pair<>(xCore,yCord));

            }
        }

    }
    private void populateSnakeLadder(){
        snaeLadderPosition = new ArrayList<>();
        for(int i = 0; i < 101; i++){
            snaeLadderPosition.add(i);
        }
        snaeLadderPosition.set(4,25);
        snaeLadderPosition.set(13,46);
        snaeLadderPosition.set(27,5);
        snaeLadderPosition.set(33,49);
        snaeLadderPosition.set(40,3);
        snaeLadderPosition.set(42,63);
        snaeLadderPosition.set(43,18);
        snaeLadderPosition.set(50,69);
        snaeLadderPosition.set(54,31);
        snaeLadderPosition.set(62,81);
        snaeLadderPosition.set(66,45);
        snaeLadderPosition.set(76,58);
        snaeLadderPosition.set(74,92);
        snaeLadderPosition.set(89,53);
        snaeLadderPosition.set(99,41);


    }
    public int getNewPosition(int currentPosition){
        if(currentPosition > 0 && currentPosition <= 100){
            return snaeLadderPosition.get(currentPosition);
        }
        return -1;
    }
    int getXCoordinate(int position){
        if(position>=1 && position <= 100)
            return positionCoordinates.get(position).getKey();
        return -1;


    }
    int getYCoordinate(int position){
        if(position >= 1 && position <= 100)
            return positionCoordinates.get(position).getValue();
        return -1;


    }

//    public static void main(String[] args) {
//        Board board = new Board();
//        for(int i = 0; i < board.positionCoordinates.size(); i++){
//            System.out.println(i +" $ X :"+board.positionCoordinates.get(i).getKey() + " y : "+ board.positionCoordinates.get(i).getValue());
//        }
//
//    }
}
