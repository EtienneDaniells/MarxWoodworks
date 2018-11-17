import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public abstract class Stock {
    public abstract ObservableList<TableColumn> getColumns(TableView table);
}
