package Home.MapProject.HomePage.DashBoardPage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
public class DashBoardController implements Initializable{
	@FXML
	ComboBox<String> comboBox1;
	
	@FXML 
	ComboBox<String> comboBox;
	
	@FXML
	private AnchorPane anchorpane;

    @FXML
    private JFXTreeTableView<User> treeView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXTreeTableColumn<User, String> bookName = new JFXTreeTableColumn<>("Book's Name");
        bookName.setPrefWidth(150);
        bookName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().name;
            }
        });

        JFXTreeTableColumn<User, String> searchTime = new JFXTreeTableColumn<>("Number of searches");
        searchTime.setPrefWidth(150);
        searchTime.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().number;
            }
        });

        JFXTreeTableColumn<User, String> LocateCol = new JFXTreeTableColumn<>("Locate");
        LocateCol.setPrefWidth(150);
        LocateCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().Location;
            }
        });

        ObservableList<User> users = FXCollections.observableArrayList();
        users.add(new User("Toan roi rac", "23", "Kệ A"));
        users.add(new User("Mô hình hóa", "22", "Kệ B"));
        users.add(new User("Cơ sở dữ liệu", "22", "Kệ C"));
        users.add(new User("Machine Learning Cơ bản", "25", "Kệ D"));
        users.add(new User("Công nghệ phần mềm", "25", "Kệ B"));
        users.add(new User("DeepLearning", "42", "Kệ D"));
        users.add(new User("Hệ điều hành", "22", "Kệ E"));
        users.add(new User("Lập trình web", "22", "Kệ F"));

        final TreeItem<User> root = new RecursiveTreeItem<User>(users, RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(bookName, searchTime, LocateCol);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
        	
        comboBox.getItems().add("View Chart");
        comboBox.getItems().add("Sorting");
        comboBox1.getItems().add("1 day");
        comboBox1.getItems().add("1 week");
        comboBox1.getItems().add("1 month");
    }
    
    class User extends RecursiveTreeObject<User> {

        StringProperty Location;
        StringProperty number;
        StringProperty name;

        public User(String name, String number, String Location) {
            this.name = new SimpleStringProperty(name);
            this.number = new SimpleStringProperty(number);
            this.Location = new SimpleStringProperty(Location);
        }

    }
}
