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

public class BorrowBook extends Application {
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
            case "btnStatus":
                button.setStyle("-fx-background-color: #004d99");
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
            case "btnStatus":
                button.setStyle("-fx-background-color: #0373BD");
                break;
        }
    }

    @FXML
    TextField txtTittle;

    @FXML
    TextField txtAuthor;

    @FXML
    TextField txtVersion;

    @FXML
    TextField txtLanguage;

    @FXML
    TextField txtGenre;

    @FXML
    TextField txtPYear;

    @FXML
    Button btnStatus;

    boolean t = false;

    @FXML
    public void onbtnClick(MouseEvent e) throws Exception {
        Button button = (Button)e.getSource();
        String srcString;
        switch(button.getId()) {
            case "btnHome":
                srcString = "Mainpage.fxml";
                Stage stage=(Stage) button.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("../fxml/"+srcString));/* Exception */
                Scene scene = new Scene(root, 900,600);
                stage.setScene(scene);
                stage.show();
                break;
            case "btnReturn":
                srcString = "BorrowManage.fxml";
                stage=(Stage) button.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../fxml/"+srcString));/* Exception */
                scene = new Scene(root, 900,600);
                stage.setScene(scene);
                stage.show();
                break;
            case "btnSearch":
                if(txtSearch.getText().matches("CS12345")) {

                    txtTittle.setText("Software Engineer");
                    txtAuthor.setText("Ian Sommervile");
                    txtGenre.setText("Computer Science");
                    txtVersion.setText("10th Eddition");
                    txtLanguage.setText("English");
                    txtPYear.setText("2016");
                    btnStatus.setDisable(t);
                }

                else {
                    txtTittle.setText("");
                    txtAuthor.setText("");
                    txtGenre.setText("");
                    txtVersion.setText("");
                    txtLanguage.setText("");
                    txtPYear.setText("");
                    btnStatus.setDisable(true);
                }
                break;
            case "btnStatus":
                t = true;
                srcString = "InputInfo.fxml";
                stage=(Stage) button.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../fxml/"+srcString));/* Exception */
                scene = new Scene(root, 900,600);
                stage.setScene(scene);
                stage.show();
                break;

        }

    }

}
