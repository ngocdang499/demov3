package Home.MapProject.HomePage.SideBar;


import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SidePanelController implements Initializable {

    @FXML
    private JFXButton b1;
    
    @FXML
    private JFXButton b2;
    
    @FXML
    private JFXButton b3;
    
    @FXML
    private JFXButton home;   
    
    private HomePageController callback;
    
    public void setCallback(HomePageController callback) {
        this.callback = callback;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	home.setOnAction(e->{
    		callback.anchorPane.getChildren().clear();
    		callback.btnLogout.setVisible(true);
    		callback.btnmap.setVisible(true);
    		callback.btnedit.setVisible(true);
    		callback.btndash.setVisible(true);
    		callback.grid.setDisable(false);
    	}
    	);
    }

    @FXML
    Button btnHome;

    public void onbtnHomeClick(MouseEvent e) throws Exception {
        String srcString = "Mainpage.fxml";
        Stage stage = (Stage) btnHome.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../../../fxml/" + srcString));/* Exception */
        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void switchPage(ActionEvent event) {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        switch (btn.getText()) {
            case "Map":
                callback.LoadUi("../Mappage/Map.fxml", callback.anchorPane);
                break;
            case "Dash board":
                callback.LoadUi("../DashBoardPage/DashBoard.fxml",callback.anchorPane);
                break;
            case "Edit":
                callback.LoadUi("../EditPage/Edit.fxml",callback.anchorPane);
                break;
        }
    }
}
