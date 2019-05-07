package Home.Controllers;


import javafx.application.Application;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ViewList extends Application {
    @Override
    public void start(Stage primaryStage) {

    }

    @FXML
    TextField txtSearch;

    @FXML
    ImageView imgReturn;

    @FXML
    ImageView imgHome;


    @FXML
    public void onbtnEnter(MouseEvent e) {
        Button button = (Button)e.getSource();
        Glow glowfx = new Glow();
        glowfx.setLevel(1);
        switch(button.getId()) {
            case "btnSearch":
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
            case "btnReturn":
                button.setStyle("-fx-background-color: #009999");
                imgReturn.setEffect(glowfx);
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
            case "btnSearch":
                button.setEffect(null);
                break;
            case "btnReturn":
                button.setStyle("-fx-background-color: #33ffcc");
                imgReturn.setEffect(glowfx);
                break;
            case "btnHome":
                button.setStyle("-fx-background-color: #33ffcc");
                imgHome.setEffect(glowfx);
                break;
        }
    }


    @FXML
    public void onbtnClick(MouseEvent e) throws Exception {
        Button button = (Button)e.getSource();
        String srcString = "ViewBorrowedList.fxml";
        switch(button.getId()) {
            case "btnHome":
                srcString = "Mainpage.fxml";
                break;
            case "btnReturn":
                srcString = "BorrowManage.fxml";
                break;
            case "btnSearch":
                txtSearch.setText("");
                break;
            case "btnStatus":
                break;

        }

        Stage stage=(Stage)button.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/"+srcString));/* Exception */
        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

}
