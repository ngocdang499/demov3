package Home.Controllers;


import Home.AlertBox;
import javafx.application.Application;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class InputInfo extends Application {
    @Override
    public void start(Stage primaryStage) {

    }

    @FXML
    ImageView imgCancel;

    @FXML
    ImageView imgOkay;

    @FXML
    ImageView imgHome;


    @FXML
    public void onbtnEnter(MouseEvent e) {
        Button button = (Button)e.getSource();
        Glow glowfx = new Glow();
        glowfx.setLevel(1);
        switch(button.getId()) {
            case "btnOkay":
                button.setStyle("-fx-background-color: #009999");
                imgOkay.setEffect(glowfx);
                break;
            case "btnCancel":
                button.setStyle("-fx-background-color: #009999");
                imgCancel.setEffect(glowfx);
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
            case "btnOkay":
                button.setStyle("-fx-background-color: #33ffcc");
                imgOkay.setEffect(glowfx);
                break;
            case "btnCancel":
                button.setStyle("-fx-background-color: #33ffcc");
                imgCancel.setEffect(glowfx);
                break;
            case "btnHome":
                button.setStyle("-fx-background-color: #33ffcc");
                imgHome.setEffect(glowfx);
                break;
        }
    }

    @FXML
    TextField txtName;

    @FXML
    TextField txtID;

    @FXML
    TextField txtAddress;

    @FXML
    TextField txtPhone;

    @FXML
    TextField txtEmail;

    @FXML
    DatePicker dateBorrow;

    @FXML
    DatePicker dateReturn;

    @FXML
    public void onbtnClick(MouseEvent e) throws Exception {
        Button button = (Button)e.getSource();
        String srcString = "InputInfo.fxml";
        switch(button.getId()) {
            case "btnHome":
                srcString = "BorrowBook.fxml";
                break;
            case "btnOkay":
                AlertBox alertbox = new AlertBox();
                alertbox.display("Successful", "Borrower Infomation has been Updated!");
                break;
            case "btnCancel":
                txtName.setText("");
                txtAddress.setText("");
                txtEmail.setText("");
                txtID.setText("");
                txtPhone.setText("");
                break;

        }

        Stage stage=(Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/"+srcString));/* Exception */
        Scene scene = new Scene(root, 900,600);
        stage.setScene(scene);
        stage.show();
    }

}
