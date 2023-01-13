package com.example.tp4;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Game extends BorderPane {
    private Player white, black;
    private Color turn;
    private Board board;
    private Text text;
    MoverI mover;

    public Game() {
        this.white = new Player(Color.WHITE);
        this.black = new Player(Color.BLACK);
        this.turn = Color.WHITE;
        this.mover = new MoverClassic(this);
        board = new Board(8, 8, this, mover);
        for(Node[] node : board.getNodeArray()) {
            for(Node nodePrim : node) {
                this.getChildren().add(nodePrim);
            }
        }
        NormalBoardFiller normalBoardFiller = new NormalBoardFiller();
        normalBoardFiller.fill(board, 2);
        for(Node[] node : board.getNodeArray()) {
            for(Node nodePrim : node) {
                if(nodePrim.getPawn() != null) {
                    if(((Color)nodePrim.getPawn().getFill()).equals(Color.WHITE)) white.getPawns().add(nodePrim.getPawn());
                    else black.getPawns().add(nodePrim.getPawn());
                    nodePrim.getPawn().setNode(nodePrim);
                    this.getChildren().add(nodePrim.getPawn());
                    nodePrim.getPawn().setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Pawn pawn = (Pawn) event.getSource();
                            mover.giveNode(pawn.getNode().i, pawn.getNode().j);
                        }
                    });
                }
            }
        }
        this.text = new Text(700, 300, "white's move");
        getChildren().add(text);
    }

    public void nextMove() {
        if(turn.equals(Color.BLACK)) {
            turn = Color.WHITE;
            text.setText("white's move");
        }
        else {
            turn = Color.BLACK;
            text.setText("black's move");
        }
    }

    public Player getWhite() {
        return white;
    }

    public void setWhite(Player white) {
        this.white = white;
    }

    public Player getBlack() {
        return black;
    }

    public void setBlack(Player black) {
        this.black = black;
    }

    public Color getTurn() {
        return turn;
    }

    public void setTurn(Color turn) {
        this.turn = turn;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public void gameOver(Player winner) {
        text.setText(winner.getColor().equals(Color.WHITE) ? "white wins!" : "black wins!");
    }
}
