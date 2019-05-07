package Home.Controllers;


import javafx.application.Application;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Controller extends Application {

    @FXML
    ImageView img1;

    @Override
    public void start(Stage primaryStage) {
        img1.setVisible(false);

    }

    @FXML
    ImageView imgImport;

    @FXML
    Rectangle btnL_Import;

    @FXML
    ImageView imgRequest;

    @FXML
    Rectangle btnL_Request;

    @FXML
    ImageView imgSearch;

    @FXML
    Rectangle btnL_Search;

    @FXML
    ImageView imgLocation;

    @FXML
    Rectangle btnL_Location;

    @FXML
    ImageView imgBorrow;

    @FXML
    Rectangle btnL_Borrow;

    @FXML
    ImageView imgHome;

    @FXML
    Rectangle btnL_Home;


    @FXML
    public void onSideMenubtnEnter(MouseEvent e) {
        Button button = (Button)e.getSource();
        Glow glowfx = new Glow();
        glowfx.setLevel(1);
        switch(button.getId()) {
            case "btnImport":
                button.setStyle("-fx-background-color: #004d99");
                btnL_Import.setFill(Color.rgb(255,255,255));
                btnL_Import.setEffect(glowfx);
                imgImport.setEffect(glowfx);
                break;
            case "btnRequest":
                button.setStyle("-fx-background-color: #004d99");
                btnL_Request.setFill(Color.rgb(255,255,255));
                btnL_Request.setEffect(glowfx);
                imgRequest.setEffect(glowfx);
                break;
            case "btnSearch":
                button.setStyle("-fx-background-color: #004d99");
                btnL_Search.setFill(Color.rgb(255,255,255));
                btnL_Search.setEffect(glowfx);
                imgSearch.setEffect(glowfx);
                break;
            case "btnLocation":
                button.setStyle("-fx-background-color: #004d99");
                btnL_Location.setFill(Color.rgb(255,255,255));
                btnL_Location.setEffect(glowfx);
                imgLocation.setEffect(glowfx);
                break;
            case "btnBorrow":
                button.setStyle("-fx-background-color: #004d99");
                btnL_Borrow.setFill(Color.rgb(255,255,255));
                btnL_Borrow.setEffect(glowfx);
                imgBorrow.setEffect(glowfx);
                break;
            default:
                button.setStyle("-fx-background-color: #004d99");
                btnL_Home.setFill(Color.rgb(255,255,255));
                btnL_Home.setEffect(glowfx);
                imgHome.setEffect(glowfx);
        }
    }

    @FXML
    public void onSideMenubtnLeave(MouseEvent e) {
        Button button = (Button)e.getSource();
        Glow glowfx = new Glow();
        glowfx.setLevel(0);
        switch(button.getId()) {
            case "btnImport":
                button.setStyle("-fx-background-color: #0373BD");
                btnL_Import.setFill(Color.rgb(3,115,189));
                btnL_Import.setEffect(glowfx);
                imgImport.setEffect(glowfx);
                break;
            case "btnRequest":
                button.setStyle("-fx-background-color: #0373BD");
                btnL_Request.setFill(Color.rgb(3,115,189));
                btnL_Request.setEffect(glowfx);
                imgRequest.setEffect(glowfx);
                break;
            case "btnSearch":
                button.setStyle("-fx-background-color: #0373BD");
                btnL_Search.setFill(Color.rgb(3,115,189));
                btnL_Search.setEffect(glowfx);
                imgSearch.setEffect(glowfx);
                break;
            case "btnLocation":
                button.setStyle("-fx-background-color: #0373BD");
                btnL_Location.setFill(Color.rgb(3,115,189));
                btnL_Location.setEffect(glowfx);
                imgLocation.setEffect(glowfx);
                break;
            case "btnBorrow":
                button.setStyle("-fx-background-color: #0373BD");
                btnL_Borrow.setFill(Color.rgb(3,115,189));
                btnL_Borrow.setEffect(glowfx);
                imgBorrow.setEffect(glowfx);
                break;
            default:
                button.setStyle("-fx-background-color: #0373BD");
                btnL_Home.setFill(Color.rgb(3,115,189));
                btnL_Home.setEffect(glowfx);
                imgHome.setEffect(glowfx);
        }
    }



    @FXML
    public void onSideMenubtnClick(MouseEvent e) throws Exception {
        Button button = (Button)e.getSource();
        switch(button.getId()) {
            case "btnImport":
                Stage stage=(Stage) button.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("../fxml/Import.fxml"));/* Exception */
                Scene scene = new Scene(root, 900,600);
                stage.setScene(scene);
                stage.show();
                break;
            case "btnRequest":
                stage=(Stage) button.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../fxml/applicationReport.fxml"));

                scene = new Scene(root);
                stage.setScene(scene);

                stage.show();
                break;
            case "btnSearch":
                stage=(Stage) button.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../fxml/demoSearchTool.fxml"));

                scene = new Scene(root);
                stage.setScene(scene);

                stage.show();
                break;
            case "btnLocation":
                stage=(Stage) button.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../MapProject/Select/Select.fxml"));
                root = loader.load();

                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("MapGenerator");
                stage.show();

                break;
            case "btnBorrow":
                stage=(Stage) button.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../fxml/BorrowManage.fxml"));/* Exception */
                scene = new Scene(root, 900,600);
                stage.setScene(scene);
                stage.show();
                break;

        }
    }

}
