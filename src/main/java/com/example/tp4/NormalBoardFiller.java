package com.example.tp4;

import javafx.scene.paint.Color;

public class NormalBoardFiller {

    public void fill(Board board, int rows) {
        if(2 * rows > board.getHeight() || rows < 0) throw new RuntimeException("Zla wartosc rzedow");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < board.getWidth(); j++) {
                if((i + j) % 2 == 0) {
                    board.getNodeArray()[i][j].newPawn(Color.WHITE);
                }
            }
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < board.getWidth(); j++) {
                if((i + j - 1) % 2 == 0)
                    board.getNodeArray()[board.getHeight() - i - 1][j].newPawn(Color.BLACK);
            }
        }
    }
}
