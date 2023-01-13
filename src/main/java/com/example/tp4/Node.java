package com.example.tp4;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Node extends Rectangle {
    Pawn pawn;
    int i, j;
    public Node(double x, double y, double width, double height, Color color, int i, int j) {
        super(x, y, width, height);
        this.i = i;
        this.j = j;
        setFill(color);
        setStroke(Color.BLUE);
        setStrokeWidth(0);
        setStrokeType(StrokeType.INSIDE);
        setOnMouseEntered(new NodeHoverEventHandler());
        setOnMouseExited(new NodeHoverEventHandler());
    }

    public Pawn getPawn() {
        return pawn;
    }

    public void newPawn(Color color) {
        this.pawn = new Pawn(getX()+getWidth()/2.0d, getY()+getHeight()/2.0d, 20.0d, color);
    }

    public void setPawn(Pawn pawn) {

        this.pawn = pawn;
    }

    class NodeHoverEventHandler implements EventHandler<MouseEvent> {
        Node node;

        @Override
        public void handle(MouseEvent event) {
            node = (Node) event.getSource();
            if(event.getEventType()==MouseEvent.MOUSE_EXITED) {
                node.setStrokeWidth(0);
            }else if(event.getEventType()==MouseEvent.MOUSE_ENTERED) {
                node.setStrokeWidth(10);
            }
        }
    }
}
