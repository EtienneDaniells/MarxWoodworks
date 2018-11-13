import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class Glue extends Stock {
    int id;
    String brand;
    int volume;
    int quantity;

    public Glue(int id, String brand, int volume, int quantity) {
        this.id = id;
        this.brand = brand;
        this.volume = volume;
        this.quantity = quantity;
    }

    public ObservableList<TableColumn> getColumns() {
        ObservableList<TableColumn> list = FXCollections.observableArrayList();
        TableColumn<Stock, Integer> idCol = new TableColumn<>("ID");
        TableColumn<Stock, String> brandCol = new TableColumn<>("Brand");
        TableColumn<Stock, Integer> volumeCol = new TableColumn<>("Volume");
        TableColumn<Stock, Integer> quantityCol = new TableColumn<>("Quantity");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        volumeCol.setCellValueFactory(new PropertyValueFactory<>("volume)"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        list.addAll(idCol, brandCol, volumeCol, quantityCol);
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
