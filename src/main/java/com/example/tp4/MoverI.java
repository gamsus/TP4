package com.example.tp4;

import javafx.scene.paint.Color;

public abstract class MoverI {
    private Node[][] nodes;
    private Game game;
    public abstract void giveNode(int i, int j);

    public Node[][] getNodes() {
        return nodes;
    }

    public void setNodes(Node[][] nodes) {
        this.nodes = nodes;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
