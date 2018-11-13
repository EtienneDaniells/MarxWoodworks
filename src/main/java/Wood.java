import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class Wood extends Stock {
    int id;
    String type;
    int length;
    int height;
    int width;
    int quantity;

    public Wood(int id, String type, int length, int width, int height, int quantity) {
        this.id = id;
        this.type = type;
        this.length = length;
        this.height = height;
        this.width = width;
        this.quantity = quantity;
    }

    public ObservableList<TableColumn> getColumns() {
        ObservableList<TableColumn> list = FXCollections.observableArrayList();
        TableColumn<Stock, Integer> idCol = new TableColumn<>("ID");
        TableColumn<Stock, String> typeCol = new TableColumn<>("Type");
        TableColumn<Stock, Integer> lengthCol = new TableColumn<>("Length");
        TableColumn<Stock, Integer> widthCol = new TableColumn<>("Width");
        TableColumn<Stock, Integer> heightCol = new TableColumn<>("Height");
        TableColumn<Stock, Integer> quantityCol = new TableColumn<>("Quantity");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        lengthCol.setCellValueFactory(new PropertyValueFactory<>("length"));
        widthCol.setCellValueFactory(new PropertyValueFactory<>("width"));
        heightCol.setCellValueFactory(new PropertyValueFactory<>("height"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        list.addAll(idCol, typeCol, lengthCol, widthCol, heightCol, quantityCol);
        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
