package Home.MapProject.Select;

import java.io.IOException;
import javafx.beans.value.ObservableValue;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class SelectController  implements Initializable{

    @FXML
    private JFXButton btnReader;

    @FXML
    private JFXButton btnlibrarian;

    @FXML
    private AnchorPane mainSelect;
    
    @Override   
    public void initialize(URL url, ResourceBundle rb) {
    	btnlibrarian.setOnAction(e->{
    		Load("../HomePage/SideBar/LoginPage.fxml");
    	});
    	btnReader.setOnAction(e->{
    		Load("../HomePage/Mappage/Map.fxml");
    	});
    }  
    public void Load(String UI) {
    	Parent root1= null;
    	try {
    	root1= FXMLLoader.load(getClass().getResource(UI));
    	}catch(IOException ex) {
    		Logger.getLogger(SelectController.class.getName()).log(Level.SEVERE, null,ex);
    	}
    	mainSelect.getChildren().setAll(root1);
    	mainSelect.setTopAnchor(root1, 0.0);
    	mainSelect.setBottomAnchor(root1, 0.0);
    	mainSelect.setLeftAnchor(root1, 0.0);
    	mainSelect.setRightAnchor(root1, 0.0);
    }
 
}
