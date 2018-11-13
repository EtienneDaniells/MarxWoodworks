import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class Varnish extends ParentPojo {
    int id;
    String brand;
    String type;
    int volume;
    int quantity;

    public Varnish(int id, String brand, String type, int volume, int quantity) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.volume = volume;
        this.quantity = quantity;
    }

    public ObservableList<TableColumn> getColumns() {
        ObservableList<TableColumn> list = FXCollections.observableArrayList();
        TableColumn<ParentPojo, Integer> idCol = new TableColumn<>("ID");
        TableColumn<ParentPojo, String> brandCol = new TableColumn<>("Brand");
        TableColumn<ParentPojo, String> typeCol = new TableColumn<>("Type");
        TableColumn<ParentPojo, Integer> volumeCol = new TableColumn<>("Volume");
        TableColumn<ParentPojo, Integer> quantityCol = new TableColumn<>("Quantity");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        volumeCol.setCellValueFactory(new PropertyValueFactory<>("volume"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        list.addAll(idCol, brandCol, typeCol, volumeCol, quantityCol);
        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
