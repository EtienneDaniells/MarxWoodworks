import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Varnish extends Stock {
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

    public ObservableList<TableColumn> getColumns(TableView table) {
        ObservableList<TableColumn> list = FXCollections.observableArrayList();
        TableColumn<Stock, Integer> idCol = new TableColumn<>("ID");
        TableColumn<Stock, String> brandCol = new TableColumn<>("Brand");
        TableColumn<Stock, String> typeCol = new TableColumn<>("Type");
        TableColumn<Stock, Integer> volumeCol = new TableColumn<>("Volume");
        TableColumn<Stock, Integer> quantityCol = new TableColumn<>("Quantity");

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        volumeCol.setCellValueFactory(new PropertyValueFactory<>("volume"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        idCol.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
        brandCol.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
        typeCol.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
        volumeCol.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        quantityCol.prefWidthProperty().bind(table.widthProperty().multiply(0.15));

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
