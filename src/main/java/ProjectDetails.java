import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProjectDetails extends ParentPojo{
    int id;
    String type;
    int height;
    int length;
    int width;
    int quantity;
    double price;

    public ProjectDetails(int id, String type, int length, int width, int height, int quantity, double price) {
        this.id = id;
        this.type = type;
        this.length = length;
        this.width = width;
        this.height = height;
        this.quantity = quantity;
        this.price = price;
    }

    public ObservableList<TableColumn> getColumns(){
        ObservableList<TableColumn> list = FXCollections.observableArrayList();
        TableColumn<ParentPojo, Integer> idCol = new TableColumn<>("ID");
        TableColumn<ParentPojo, String> typeCol = new TableColumn<>("Type");
        TableColumn<ParentPojo, Integer> lengthCol = new TableColumn<>("Length");
        TableColumn<ParentPojo, Integer> widthCol = new TableColumn<>("Width");
        TableColumn<ParentPojo, Integer> heightCol = new TableColumn<>("Height");
        TableColumn<ParentPojo, Integer> quantityCol = new TableColumn<>("Quantity");
        TableColumn<ParentPojo, Double> priceCol = new TableColumn<>("Price");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        lengthCol.setCellValueFactory(new PropertyValueFactory<>("length"));
        widthCol.setCellValueFactory(new PropertyValueFactory<>("width"));
        heightCol.setCellValueFactory(new PropertyValueFactory<>("height"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        list.addAll(idCol, typeCol, lengthCol, widthCol, heightCol, quantityCol, priceCol);
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
}
