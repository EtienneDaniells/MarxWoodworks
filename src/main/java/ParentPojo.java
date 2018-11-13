import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

public abstract class ParentPojo {
    public abstract ObservableList<TableColumn> getColumns();
}
