package Home.MapProject.HomePage.Mappage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Home.MapProject.HomePage.SideBar.HomePageController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class MapController implements Initializable{
	
	    @FXML
	    private ImageView LocaC;
	
	    @FXML
	    private ImageView LocaD;
	
	    @FXML
	    private ImageView LocaA;
	
	    @FXML
	    private ImageView LocaB;
	
	    @FXML
	    private ImageView LocaE;
    
	    @FXML
	    private ImageView LocaF;
	    
	    @FXML
	    private TextField textSearch;
	    
	    @FXML
	    private JFXButton btnSearch;
	    
	    @FXML
	    private AnchorPane Parent;
	    
	    @FXML
	    private JFXButton homebtn;
	    
	    @FXML
	    private AnchorPane backHome;
	    
	    @FXML
	    private Slider zoom_slider;
	    
	    @FXML
	    private Button zoomIn;

	    @FXML
	    private Button zoomOut;
	    
	    @FXML
	    private ScrollPane map_scrollpane;
	    
	    Group zoomGroup;
	    	    
	    int count=0;
	    
	    private void zoom(double scaleValue) {
		          double scrollH = map_scrollpane.getHvalue();
		          double scrollV = map_scrollpane.getVvalue();
		          zoomGroup.setScaleX(scaleValue);
		          zoomGroup.setScaleY(scaleValue);
		          map_scrollpane.setHvalue(scrollH);
		          map_scrollpane.setVvalue(scrollV);
		      }
	    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	  	
    	 zoom_slider.setMin(0.5);
         zoom_slider.setMax(1.5);
         zoom_slider.setValue(1.0);
         zoom_slider.valueProperty().addListener((o, oldVal, newVal) -> zoom((Double) newVal));
         
         Group contentGroup = new Group();
         zoomGroup = new Group();
         contentGroup.getChildren().add(zoomGroup);
         zoomGroup.getChildren().add(map_scrollpane.getContent());
         map_scrollpane.setContent(contentGroup);
          	
         
        zoomIn.setOnAction(e->{
        	  double sliderVal = zoom_slider.getValue();
              zoom_slider.setValue(sliderVal += 0.1);
        });
        
        zoomOut.setOnAction(e->{
        	  double sliderVal = zoom_slider.getValue();
              zoom_slider.setValue(sliderVal + -0.1);
        });
        
    	//Hieu ung
        btnSearch.setOnMouseEntered(e->{
    		Glow glowfx = new Glow();
	        glowfx.setLevel(1);
	        	  DropShadow dropShadow = new DropShadow();
	                dropShadow.setColor(Color.SKYBLUE);
	                dropShadow.setHeight(20);
	                dropShadow.setWidth(20);
	                dropShadow.setRadius(5);
	                dropShadow.setSpread(10);
	                btnSearch.setEffect(dropShadow);
    	});
    	btnSearch.setOnMouseExited(e->{
    		 Glow glowfx = new Glow();
 	         glowfx.setLevel(1);
 	       btnSearch.setEffect(null);
    	});
    	
    	/*________________________________________________________________*/
    	
    	 ObservableList<User> users = FXCollections.observableArrayList();

        users.add(new User("1","A"));
        users.add(new User("2","B"));
        users.add(new User("3","C"));
        users.add(new User("4","D"));
        users.add(new User("5","E"));
        users.add(new User("6","F"));
        
        for(Node Item: Parent.getChildren()) {
        	if(Item instanceof ImageView) {
        		((ImageView)Item).setVisible(false);
        	}
        }
              
        homebtn.setOnAction(e->{
        	Parent root1= null;
        	try {
        	root1= FXMLLoader.load(getClass().getResource("../../Select/Select.fxml"));
        	}catch(IOException ex) {
        		Logger.getLogger(MapController.class.getName()).log(Level.SEVERE, null,ex);
        	}
        	backHome.getChildren().setAll(root1);
        	backHome.setTopAnchor(root1, 0.0);
        	backHome.setBottomAnchor(root1, 0.0);
        	backHome.setLeftAnchor(root1, 0.0);
        	backHome.setRightAnchor(root1, 0.0);
        });
        
        btnSearch.setOnAction(action -> 
        {
        	count=0;
	        	System.out.println("In");
	        	if(textSearch.getText() != null) {
	        	   	System.out.println(textSearch.getText());
	        	   	
	        	  users.forEach(Item->
	      		  {	      	      			
	      			if((Item.ID).equals(textSearch.getText())) {
	      				System.out.println("In");
	      				for(Node Image: Parent.getChildren()) {
	      					if(Image instanceof ImageView) {
	      						if(Image.getId().equals( "Loca" + Item.Location)) {
	      							((ImageView)Image).setVisible(true);
	      							System.out.println(((ImageView)Image).isVisible());
	      						}
	      						else System.out.println("fail");
	      					}
	      				}
	      			}		
	      			else {
	      				count=count+1;
	      			}
	      			
	      		  });
	        	  if(count==users.size() && textSearch.getText()!=null) {
	        		  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	                  alert.setTitle("Alert");
	                  alert.setHeaderText("The book you are finding is not avalable now!");
	                  alert.setContentText("Sorry!");
	                  Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
	                  alert1.setTitle("Information");
	                  alert1.setHeaderText("Notification");          
	                  alert.show();
	        	  }
	        	}
        });
    }
      class User extends RecursiveTreeObject<User> {
        String Location;
        String ID;

        public User(String ID, String Location) {
            this.ID = (ID);
            this.Location =  (Location);
        }
    }
}
