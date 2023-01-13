package com.example.tp4;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MoverClassic extends MoverI {
    Node node1;
    Color temp;

    MoverClassic(Game game) {
        setGame(game);
    }

    private void reset() {
        node1.setFill(temp);
        node1 = null;
    }
    public void giveNode(int i, int j) {
        Node node = getNodes()[i][j];
        if(node1 != null) {
            if(node1.equals(node)) {
                System.out.println("Ta sama");
                reset();
            }
            else if(node.getPawn() != null) {
                System.out.println("Zajete!");
                reset();
            }
            else {
                int xj = j - node1.j;
                int xi = i - node1.i;
                System.out.println(xi);
                if(Math.abs(xi) != Math.abs(xj)) {
                    System.out.println("Musisz poruszac sie po skosie!");
                    return;
                }
                if((((Color) node1.getPawn().getFill()).equals(Color.WHITE)) && xi < 0 && !(node1.getPawn() instanceof Queen)) {
                    System.out.println("Biale musza ruszac sie w dol!");
                    reset();
                    return;
                }
                if(((Color) node1.getPawn().getFill()).equals(Color.BLACK) && xi > 0 && !(node1.getPawn() instanceof Queen)) {
                    System.out.println("Czarne musza ruszac sie w gorel!");
                    reset();
                    return;
                }
                if(Math.abs(xi) == 1) {
                    System.out.println("Ruszam z a do b!");
                    node1.getPawn().moveTo(node.getX() + node.getWidth() / 2.0d, node.getY() + node.getHeight() / 2.0d);
                    node.setPawn(node1.getPawn());
                    node1.setPawn(null);
                    node.getPawn().setNode(node);
                    if((Color.WHITE.equals(node.getPawn().getFill()) && i == 7) || (Color.BLACK.equals(node.getPawn().getFill()) && i == 0)) {
                        Queen queen = new Queen(node.getPawn());
                        getGame().getChildren().remove(node.getPawn());
                        getGame().getChildren().add(queen);
                        queen.setNode(node);
                        queen.setOnMouseClicked(node.getPawn().getOnMouseClicked());
                        node.setPawn(queen);
                    }
                    getGame().nextMove();
                    reset();
                }
                else if(Math.abs(xi) == 2 && getNodes()[node1.i+xi/2][node1.j+xj/2].getPawn() != null) {
                    if(getNodes()[node1.i+xi/2][node1.j+xj/2].getPawn().getFill().equals(node1.getPawn().getFill())) {
                        System.out.println("Nie mozna bic swoich!");
                        return;
                    }
                    System.out.println("Bicie");
                    node1.getPawn().moveTo(node.getX() + node.getWidth() / 2.0d, node.getY() + node.getHeight() / 2.0d);
                    getGame().getChildren().remove(getNodes()[node1.i+xi/2][node1.j+xj/2].getPawn());
                    if(getGame().getTurn().equals(Color.WHITE)) {
                        getGame().getBlack().getPawns().remove(getNodes()[node1.i+xi/2][node1.j+xj/2].getPawn());
                        if(getGame().getBlack().getPawns().size() == 0) {
                            getGame().gameOver(getGame().getWhite());
                            return;
                        }
                    }
                    else {
                        getGame().getWhite().getPawns().remove(getNodes()[node1.i+xi/2][node1.j+xj/2].getPawn());
                        if(getGame().getWhite().getPawns().size() == 0) {
                            getGame().gameOver(getGame().getBlack());
                            return;
                        }
                    }
                    getNodes()[node1.i+xi/2][node1.j+xj/2].setPawn(null);
                    node.setPawn(node1.getPawn());
                    node1.setPawn(null);
                    node.getPawn().setNode(node);
                    if((Color.WHITE.equals(node.getPawn().getFill()) && i == 7) || (Color.BLACK.equals(node.getPawn().getFill()) && i == 0)) {
                        Queen queen = new Queen(node.getPawn());
                        Player player = getGame().getTurn().equals(Color.WHITE) ? getGame().getWhite() : getGame().getBlack();
                        player.getPawns().add(queen);
                        player.getPawns().remove(node.getPawn());
                        getGame().getChildren().remove(node.getPawn());
                        getGame().getChildren().add(queen);
                        queen.setNode(node);
                        queen.setOnMouseClicked(node.getPawn().getOnMouseClicked());
                        node.setPawn(queen);
                    }
                    getGame().nextMove();
                    reset();
                }
            }
        }
        else if (node.getPawn() != null && node.getPawn().getFill().equals(getGame().getTurn())){
            System.out.println("Ustawiam!");
            node1 = node;
            temp = (Color) node1.getFill();
            node1.setFill(Color.RED);
        }
        else System.out.println("Nie ma co tu robic");
    }
}
