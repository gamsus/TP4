package com.example.tp4;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Queen extends Pawn {
    public Queen(Pawn pawn) {
        super(pawn.getCenterX(), pawn.getCenterY(), pawn.getRadius(), (Color) pawn.getFill());
        this.setStroke(Color.YELLOW);
        this.setStrokeWidth(10);
    }
}
