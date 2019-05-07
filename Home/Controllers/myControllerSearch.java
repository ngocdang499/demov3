package Home.Controllers;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.ResourceBundle;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class myControllerSearch implements Initializable {
 
   @FXML
   private Button searchButton;
   private String input = "";
   private ScrollPane ResultField;
   @FXML
   private TextField textInput;
  
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).

   }
 
   // When user click on myButton
   // this method will be called.
   // Khi người dùng nhấn vào Button myButton
   // phương thức này sẽ được gọi
   public void onClicked(ActionEvent event) {
       System.out.println("Button Clicked!");
      	input = textInput.getText().toString();
   	System.out.println(input);
   	Label label = new Label("My Label");
   	
   }

   @FXML
   ImageView imgHome;

   @FXML
   Button btnHome;


   @FXML
   public void onbtnEnter(MouseEvent e) {
      Button button = (Button)e.getSource();
      Glow glowfx = new Glow();
      glowfx.setLevel(1);
      switch(button.getId()) {
         case "btnSearch2":
            //Instantiating the Shadow class
            DropShadow dropShadow = new DropShadow();
            //dropShadow.setBlurType(BlurType.GAUSSIAN);
            dropShadow.setColor(Color.LIGHTGRAY);
            dropShadow.setHeight(20);
            dropShadow.setWidth(20);
            dropShadow.setRadius(5);
            dropShadow.setSpread(10);
            button.setEffect(dropShadow);
            break;
         case "btnHome":
            button.setStyle("-fx-background-color: #009999");
            imgHome.setEffect(glowfx);
            break;

      }
   }


   @FXML
   public void onbtnLeave(MouseEvent e) {
      Button button = (Button)e.getSource();
      Glow glowfx = new Glow();
      glowfx.setLevel(0);
      switch(button.getId()) {
         case "btnHome":
            button.setStyle("-fx-background-color: #33ffcc");
            imgHome.setEffect(glowfx);
            break;
         case "btnSearch2":
            button.setEffect(null);
            break;
      }
   }

   public void onbtnClick(MouseEvent e) throws Exception {
      String srcString;
      srcString = "Mainpage.fxml";
      Stage stage = (Stage) btnHome.getScene().getWindow();
      Parent root = FXMLLoader.load(getClass().getResource("../fxml/" + srcString));/* Exception */
      Scene scene = new Scene(root, 900, 600);
      stage.setScene(scene);
      stage.show();
   }



}