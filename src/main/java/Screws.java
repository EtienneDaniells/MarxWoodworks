import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class Screws extends Stock {
    int id;
    int size;
    String color;
    int quantity;

    public Screws(int id, int size, String color, int quantity) {
        this.id = id;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
    }

    public ObservableList<TableColumn> getColumns() {
        ObservableList<TableColumn> list = FXCollections.observableArrayList();
        TableColumn<Stock, Integer> idCol = new TableColumn<>("ID");
        TableColumn<Stock, Integer> sizeCol = new TableColumn<>("Size");
        TableColumn<Stock, String> colorCol = new TableColumn<>("Color");
        TableColumn<Stock, Integer> quantityCol = new TableColumn<>("Quantity");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        list.addAll(idCol, sizeCol, colorCol, quantityCol);
        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
