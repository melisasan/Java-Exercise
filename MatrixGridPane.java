/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixgridpane;


import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author MELİSA
 */
public class MatrixGridPane extends Application{

    
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

         for (int y = 0; y < 10; y++) {
           
             for (int x = 0; x < 10; x++) {
                 
                  pane.add(new CustomPane(),y,x);
     
             }
         }
        
    Scene scene = new Scene(pane,300,300);
    
    primaryStage.setTitle("10 by 10 matrix");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    }
    
    public static void main(String[] args) {
       launch(args);
    }

    class CustomPane extends StackPane{
        
        public CustomPane(){
            
           
              
                Rectangle rectangle = new Rectangle(0,0,30,30);
                rectangle.setFill(Color.rgb((int) (Math.random() * 255) ,(int) (Math.random()* 255),(int) (Math.random()* 255),0.5));
                getChildren().add(rectangle);
                
                Random rand = new Random();
                int value = 1+rand.nextInt(100);
                Text text1 = new Text();
                text1.setFont(Font.font("Calibri",FontWeight.BOLD,FontPosture.REGULAR,12));
                text1.setText(String.valueOf(value));
                
                getChildren().add(text1);
      
          
            }
           
        }
        }
        
    
            
