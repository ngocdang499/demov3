package Home.MapProject.HomePage.SideBar;




import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class HomePageController implements Initializable {

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    public AnchorPane root;
    
    @FXML
    public AnchorPane anchorPane;
    
    @FXML
    public JFXButton btnLogout;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SidePanel.fxml"));
            VBox box = loader.load();
            SidePanelController controller = loader.getController();
            controller.setCallback(this);
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isOpened()) {
                drawer.close();
            } else {
                drawer.open();
            }
        });
        
        btnLogout.setVisible(true);
        btnLogout.setOnAction(e->{
        	LoadUi("../../Select/Select.fxml", root);
        });
    }
    public void LoadUi(String UI, AnchorPane ref) {
    	Parent root1= null;
    	try {
    	root1= FXMLLoader.load(getClass().getResource(UI));
    	}catch(IOException ex) {
    		Logger.getLogger(SidePanelController.class.getName()).log(Level.SEVERE, null,ex);
    	}
    	ref.getChildren().setAll(root1);
    	ref.setTopAnchor(root1, 0.0);
    	ref.setBottomAnchor(root1, 0.0);
    	ref.setLeftAnchor(root1, 0.0);
    	ref.setRightAnchor(root1, 0.0);
    	btnLogout.setVisible(false);
    }
 
}
