package com.example.tp4;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

public class Board {
    private int width;
    private int height;
    private Node[][] nodeArray;
    Pane pane;

    public Board(int width, int height, Pane pane, MoverI mover) {
        this.width = width;
        this.height = height;
        nodeArray = new Node[width][height];
        mover.setNodes(nodeArray);
        this.pane = pane;

        for(int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color color;
                if ((i + j) % 2 == 0) color = Color.GREEN;
                else color = Color.BEIGE;
                nodeArray[i][j] = new Node(75.0d * j, 75.0d * i, 75.0d, 75.0d, color, i, j);
                nodeArray[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Node node = (Node) event.getSource();
                        mover.giveNode(node.i, node.j);
                    }
                });
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node[][] getNodeArray() {
        return nodeArray;
    }

    public void setNodeArray(Node[][] nodeArray) {
        this.nodeArray = nodeArray;
    }
}
