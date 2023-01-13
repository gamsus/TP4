package com.example.tp4;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Color color;
    private List<Pawn> pawns = new ArrayList<>();

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Pawn> getPawns() {
        return pawns;
    }

    public void setPawns(List<Pawn> pawns) {
        this.pawns = pawns;
    }
}
