/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candy.crush;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author PCPV
 */
public class CandyCrush extends Application {
    private static final int W =6;
    private static final int H =6;
    private static final int SIZE = 100;
    
    private Color[] colors = new Color[] {
            Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW
    };
    
    private Parent createContent() {
        Pane root = new Pane ();
        root.setPrefSize(W*SIZE, H*SIZE);
        
        List<Jewel> jewels = IntStream.range(0,W * H)
                .mapToObj(i -> new Point2D(i % W, i / H))
                .map(point -> new Jewel(point))
                .collect(Collectors.toList());
        
        root.getChildren().addAll(jewels);
        
        return root;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setScene(new Scene(createContent()));
       primaryStage.show(); 
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private class Jewel extends Parent {
        public Jewel(Point2D point) {
            Circle circle = new Circle(SIZE / 2);
            circle.setCenterX(SIZE / 2);
            circle.setCenterY(SIZE / 2);
            circle.setFill(colors[new Random().nextInt(colors.length)]);
            
            setTranslateX(point.getX() * SIZE);
            setTranslateY(point.getY() * SIZE);
            getChildren().add(circle);
        }
    }
    public static void main(String[] args){
        launch();
    }
    public void PlayGame(){launch();
}}
