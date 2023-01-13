package com.example.tp4;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pawn extends Circle {
    Node node;
    public Pawn(double v, double v1, double v2, Color color) {
        super(v, v1, v2, color);
        this.setOnMouseEntered(new PawnHoverEventHandler());
        this.setOnMouseExited(new PawnHoverEventHandler());
    }

    public void moveTo(double x, double y) {
        setCenterX(x);
        setCenterY(y);
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    class PawnHoverEventHandler implements EventHandler<MouseEvent> {
        Pawn pawn;

        @Override
        public void handle(MouseEvent event) {
            pawn = (Pawn) event.getSource();
            if(event.getEventType()==MouseEvent.MOUSE_EXITED) {
                pawn.getNode().setStrokeWidth(0);
            }else if(event.getEventType()==MouseEvent.MOUSE_ENTERED) {
                pawn.getNode().setStrokeWidth(10);
            }
        }
    }
}
