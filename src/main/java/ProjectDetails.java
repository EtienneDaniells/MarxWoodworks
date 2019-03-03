import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProjectDetails extends Stock {
    int id;
    String type;
    int height;
    int length;
    int width;
    int quantity;
    double price;
    String status;

    public ProjectDetails(int id, String type, int length, int width, int height, int quantity, double price, String status) {
        this.id = id;
        this.type = type;
        this.length = length;
        this.width = width;
        this.height = height;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public ObservableList<TableColumn> getColumns(TableView table){
        ObservableList<TableColumn> list = FXCollections.observableArrayList();
        TableColumn<Stock, Integer> idCol = new TableColumn<>("ID");
        TableColumn<Stock, String> typeCol = new TableColumn<>("Type");
        TableColumn<Stock, Integer> lengthCol = new TableColumn<>("Length");
        TableColumn<Stock, Integer> widthCol = new TableColumn<>("Width");
        TableColumn<Stock, Integer> heightCol = new TableColumn<>("Height");
        TableColumn<Stock, Integer> quantityCol = new TableColumn<>("Quantity");
        TableColumn<Stock, Double> priceCol = new TableColumn<>("Price");
        TableColumn<Stock, String> statusCol = new TableColumn<>("Status");

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        lengthCol.setCellValueFactory(new PropertyValueFactory<>("length"));
        widthCol.setCellValueFactory(new PropertyValueFactory<>("width"));
        heightCol.setCellValueFactory(new PropertyValueFactory<>("height"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        idCol.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
        typeCol.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        lengthCol.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        widthCol.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        heightCol.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        quantityCol.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
        priceCol.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
        statusCol.prefWidthProperty().bind(table.widthProperty().multiply(0.1));

        list.addAll(idCol, typeCol, lengthCol, widthCol, heightCol, quantityCol, priceCol, statusCol);
        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
