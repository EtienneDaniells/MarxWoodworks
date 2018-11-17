import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Oil extends Stock {
    int id;
    String brand;
    String color;
    int volume;
    int quantity;

    public Oil(int id, String brand, String color, int volume, int quantity) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.volume = volume;
        this.quantity = quantity;
    }

    public ObservableList<TableColumn> getColumns(TableView table) {
        ObservableList<TableColumn> list = FXCollections.observableArrayList();
        TableColumn<Stock, Integer> idCol = new TableColumn<>("ID");
        TableColumn<Stock, String> brandCol = new TableColumn<>("Brand");
        TableColumn<Stock, String> colorCol = new TableColumn<>("Color");
        TableColumn<Stock, Integer> volumeCol = new TableColumn<>("Volume");
        TableColumn<Stock, Integer> quantityCol = new TableColumn<>("Quantity");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        volumeCol.setCellValueFactory(new PropertyValueFactory<>("volume"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        idCol.prefWidthProperty().bind(table.widthProperty().multiply(0.12));
        brandCol.prefWidthProperty().bind(table.widthProperty().multiply(0.22));
        colorCol.prefWidthProperty().bind(table.widthProperty().multiply(0.22));
        volumeCol.prefWidthProperty().bind(table.widthProperty().multiply(0.22));
        quantityCol.prefWidthProperty().bind(table.widthProperty().multiply(0.22));
        list.addAll(idCol, brandCol, colorCol, volumeCol, quantityCol);
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
