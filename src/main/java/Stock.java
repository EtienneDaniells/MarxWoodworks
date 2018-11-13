import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

public abstract class Stock {
    public abstract ObservableList<TableColumn> getColumns();
}
