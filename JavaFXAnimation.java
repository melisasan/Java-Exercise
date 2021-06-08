

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_700KB.mp3
 */


import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXAnimation extends Application {
    private static final String MEDIA_URL =
            "https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_700KB.mp3";

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnimationPane pane = new AnimationPane();


        primaryStage.setScene(new Scene(pane, 660, 600));
        primaryStage.setTitle("Slide Animation");
        primaryStage.show();
    }

    private class AnimationPane extends BorderPane {

        Button btStart = new Button("START");

        int animationSpeed;
        int numOfImages;
        int currentImgNum = 1;
        String url;
        String prefix;
        String imgDir = "file:///C:/Users/oguzh/IdeaProjects/javafx/L/";
        String imgExtension = ".gif";

        Timeline timeline = null;

        StackPane centerPane = new StackPane();

        AnimationPane() {

            //centerPane is placed in the center of the outside BorderPane
            setCenter(centerPane);

            /************************************PART I************************************************
             * 1. Create a HBox named topPane and place START button with center allignment into it.
             * 2. Place the topPane on top of the outside BorderPane
             ******************************************************************************************/
            HBox topPane = new HBox();
            topPane.getChildren().add(btStart);
            topPane.setAlignment(Pos.CENTER);
            setTop(topPane);

            //***********************************END OF PART I*******************************************

            //bottomPane is created
            GridPane bottomPane = new GridPane();
            bottomPane.setPadding(new Insets(5));
            bottomPane.setHgap(5);

            //lblInfo  is created and placed to the appropriate places inside the bottomPane as given on the shape
            Label lblInfo = new Label("Animation Preferences");
            bottomPane.add(lblInfo, 0, 0);

            /*************************************PART II************************************************
             * 3. Create a ComboBox named cboSpeed which holds integers 1000,1500,2000,2500,3000,3500,4000
             *   3.1. ComboBox width will be 100
             *   3.2. Default value will be 1000
             *   3.3. At most 3 rows will be seen
             * 4. Create a label named lblSpeed with a text "Animation Speed"
             * 5. Place the cboSpeed and the label to the appropriate places inside the bottomPane as given on the shape
             ******************************************************************************************/

            ComboBox<Integer> cboSpeed = new ComboBox<>();

            cboSpeed.getItems().addAll(1000,1500,2000,2500,3000,3500,4000);
            cboSpeed.setValue(1000);
            cboSpeed.setPrefWidth(100);
            cboSpeed.setVisibleRowCount(3);
            Label lblSpeed = new Label("Animation Speed");
            bottomPane.add(lblSpeed,0,1);
            bottomPane.add(cboSpeed,1,1);

            //*************************************END OF PART II******************************************

            /*************************************PART III************************************************
             * 6. Create a label named lblImagePrefix with a text "Image file prefix"
             * 7. Create a TextField named tfImagePrefix
             * 8. Place them to the appropriate places inside the bottomPane as given on the shape
             *******************************************************************************************/
            Label lblImagePrefix = new Label("Image file prefix");
            TextField tfImagePrefix = new TextField();
            bottomPane.add(lblImagePrefix,0,2);
            bottomPane.add(tfImagePrefix,1,2);

            //***********************************END OF PART III******************************************

            /*************************************PART IV**************************************************
             * 9. Create a label named lblNumberOfImages with a text "Number of Images"
             * 10. Create 2 RadioButtons named as rb1, rb2 and rb3, with values 4, 6 and 9, respectively.
             *    10.1. Place the RadioButtons inside a HBox named rbPanel
             *    10.2. Create a ToogleGroup named group from these RadioButtons
             * 11. Place the rbPanel and the label to the appropriate places inside the bottomPane as given on the shape
             *******************************************************************************************/
            Label lblNumberOfImages = new Label("Number of Images");
            RadioButton rb1 = new RadioButton("4");
            RadioButton rb2 = new RadioButton("6");
            RadioButton rb3 = new RadioButton("9");

            HBox rbPanel = new HBox();
            rbPanel.getChildren().addAll(rb1,rb2,rb3);

            ToggleGroup group = new ToggleGroup();
            rb1.setToggleGroup(group);
            rb2.setToggleGroup(group);
            rb3.setToggleGroup(group);



            bottomPane.add(lblNumberOfImages,0,4);
            bottomPane.add(rbPanel,1,4);


            //***********************************END OF PART IV******************************************

            //A text field and a label is created for the audio file and they are placed to the appropriate places inside the bottomPane
            TextField tfAudioFileUrl = new TextField();
            tfAudioFileUrl.setPrefColumnCount(45);
            Label lblAudioFileUrl = new Label("Audio file URL");
            bottomPane.add(lblAudioFileUrl, 0, 5);
            bottomPane.add(tfAudioFileUrl, 1, 5);

            //bottomPane is placed in the bottom of the outside BorderPane
            setBottom(bottomPane);

            /*************************************PART V**************************************************
             * 12.When the START button is pressed:
             *    12.2. animationSpeed value will be taken from cboSpeed
             *    12.3. prefix value will be taken from tfImagePrefix
             *    12.4. url value will be taken from tfAudioFileUrl
             *    12.5. numOfImages will be taken from rb1, rb2 or rb3 according to which one is selected
             *    12.6. And at last call the initTimeline() method.
             *********************************************************************************************/
            btStart.setOnMouseClicked(e -> {

                //12.2
                animationSpeed = cboSpeed.getValue();
                //12.3
                prefix = tfImagePrefix.getText();

                //12.4
                url = tfAudioFileUrl.getText();

                //12.5

                rb1.setOnAction( h -> {
                    if (rb1.isSelected()) {
                        numOfImages = 4;
                    }
                });
                rb2.setOnAction(h -> {
                    if (rb1.isSelected()) {
                        numOfImages = 6;
                    }
                });
                rb3.setOnAction(h -> {
                    if (rb1.isSelected()) {
                        numOfImages = 9;
                    }
                });

                //12.6
                initTimeline();




                //***********************************END OF PART V******************************************

            });
        }

        private void initTimeline(){
            if (timeline != null) {
                timeline.stop();
                timeline = null;
                currentImgNum = 1;
            }

            /*************************************PART VI**************************************************
             * 13. Create a TimeLine with duration animationSpeed and eventHandler will call nextImage() method
             *********************************************************************************************/
            EventHandler<ActionEvent> eventHandler = e -> {
                nextImage();
            };

            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(animationSpeed), eventHandler));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play(); // Start animation



            //***********************************END OF PART VI********************************************

            /*************************************PART VII**************************************************
             * 14. Create a MediaPlayer named mp which runs a Media with a given url
             *   14.1. Play the MediaPlayer
             *   14.2. Set MediaPlayer.INDEFINITE for the CycleCount
             *********************************************************************************************/
            Media media = new Media(MEDIA_URL);
            MediaPlayer mp = new MediaPlayer(media);
            mp.play();
            mp.setCycleCount(MediaPlayer.INDEFINITE);




            //***********************************END OF PART VII********************************************

            //Stops the MediaPlayer when the animation ends
            timeline.setOnFinished(event -> mp.stop());

            //Animation continues until numOfImages are shown 
            timeline.setCycleCount(numOfImages);

            //Play the animation
            timeline.play();


        }


        private void nextImage(){
            centerPane.getChildren().clear();
            centerPane.getChildren().add(new ImageView(new Image(imgDir + prefix + currentImgNum++ + imgExtension)));
        }


    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
