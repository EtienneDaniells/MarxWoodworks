import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Interface extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        DatabaseHandler dbh = new DatabaseHandler();
        ObservableList<Stock> main;
        ObservableList<Stock> stockInitial;


        //Layouts
        VBox root = new VBox();
        VBox projectLayout = new VBox();
        HBox stockLayout = new HBox();

        //Menu
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        MenuItem menuExit = new MenuItem("Exit...");
        MenuItem placeHolder1 = new MenuItem("Placeholder");
        MenuItem placeHolder2 = new MenuItem("Placeholder");
        MenuItem placeHolder3 = new MenuItem("Placeholder");
        MenuItem placeHolder4 = new MenuItem("Placeholder");
        MenuItem placeHolder5 = new MenuItem("Placeholder");
        fileMenu.getItems().addAll(placeHolder1, placeHolder2 ,menuExit);
        editMenu.getItems().addAll(placeHolder3, placeHolder4, placeHolder5);
        menuBar.getMenus().addAll(fileMenu, editMenu);

        //Menu Functionality
        menuExit.setOnAction(e -> {
            System.out.println("System > Shutting down...");
            System.exit(0);
        });

        //Adding Tabs
        TabPane tabPane = new TabPane();
        Tab projectsTab = new Tab("Projects");
        Tab stockTab = new Tab("Stock");
        tabPane.getTabs().addAll(projectsTab, stockTab);
        projectsTab.setContent(projectLayout);
        stockTab.setContent(stockLayout);

        //Project input pane
        GridPane projectBox = new GridPane();
        projectBox.getColumnConstraints().add(new ColumnConstraints(90));
        projectBox.getStyleClass().add("projectBox");
        projectBox.setPadding(new Insets(10));
        projectBox.setVgap(8);
        projectBox.setHgap(10);
        projectBox.setMinHeight(290);

        Label typeLbl = new Label("Type");
        ComboBox<String> typeCombo = new ComboBox<>();
        typeCombo.getItems().addAll("Chair", "Table", "Cupboard", "Desk", "Bed");
        typeCombo.prefWidthProperty().bind(projectBox.widthProperty());
        typeCombo.setPromptText("-select-");


        Label heightLbl = new Label("Height (mm)");
        TextField heightTxt = new TextField();

        Label lengthLbl = new Label("Length (mm)");
        TextField lengthTxt = new TextField();

        Label widthLbl = new Label("Width (mm)");
        TextField widthTxt = new TextField();

        Label quantityLbl = new Label("Quantity");
        TextField quantityTxt = new TextField();

        Label pricePILbl = new Label("Item Price (R)");
        TextField pricePITxt = new TextField();

        Label priceTotLbl = new Label("Total Price (R)");
        TextField priceTotTxt = new TextField();

        Label userLbl = new Label("Client");
        ComboBox<String> userCombo = new ComboBox<>();
        //0userCombo.getItems().addAll();
        userCombo.prefWidthProperty().bind(projectBox.widthProperty());
        userCombo.setPromptText("-select-");

        projectBox.getChildren().addAll(typeLbl, typeCombo, heightLbl, heightTxt, lengthLbl, lengthTxt, widthLbl, widthTxt, quantityLbl, quantityTxt,
                                        pricePILbl, pricePITxt, priceTotLbl, priceTotTxt, userLbl, userCombo);

        GridPane.setConstraints(typeLbl, 0,0);
        GridPane.setConstraints(typeCombo, 1,0);
        GridPane.setConstraints(heightLbl, 0,1);
        GridPane.setConstraints(heightTxt, 1,1);
        GridPane.setConstraints(lengthLbl, 0,2);
        GridPane.setConstraints(lengthTxt, 1,2);
        GridPane.setConstraints(widthLbl, 0,3);
        GridPane.setConstraints(widthTxt, 1,3);
        GridPane.setConstraints(quantityLbl, 0,4);
        GridPane.setConstraints(quantityTxt, 1,4);
        GridPane.setConstraints(pricePILbl, 0,5);
        GridPane.setConstraints(pricePITxt, 1,5);
        GridPane.setConstraints(priceTotLbl, 0,6);
        GridPane.setConstraints(priceTotTxt, 1,6);
        GridPane.setConstraints(userLbl, 0,7);
        GridPane.setConstraints(userCombo, 1,7);
        Image logo = new Image(getClass().getResourceAsStream("logomarx.png"));
        ImageView logoDisplay = new ImageView(logo);
        logoDisplay.fitWidthProperty().bind(projectBox.widthProperty());

        //Stock input pane
        ComboBox<String> stockType = new ComboBox();
        stockType.getItems().addAll("Wood", "Paint", "Oil", "Varnish", "Glue", "Polish", "Screws");
        stockType.prefWidthProperty().bind(stockLayout.widthProperty());
        stockType.setValue("Wood");

        //Table to display project details
            TableView projectTable = new TableView();
            projectTable.prefHeightProperty().bind(projectLayout.heightProperty());
            projectTable.prefWidthProperty().bind(projectLayout.widthProperty());
            main = dbh.getProjectDetails();
                if(!main.isEmpty()) {
                    projectTable.getColumns().addAll(main.get(0).getColumns());
                    projectTable.setItems(main);
                }

        //Table to display stock details
            TableView stockTable = new TableView();
        stockTable.prefHeightProperty().bind(stockLayout.heightProperty());
        stockTable.prefWidthProperty().bind(stockLayout.widthProperty());
        stockInitial = dbh.getWood();
        stockTable.getColumns().addAll(stockInitial.get(0).getColumns());
        stockTable.setItems(stockInitial);
        stockType.valueProperty().addListener((ov, t, t1) -> {
            ObservableList<Stock> stock = dbh.getWood();
            switch (t1){
                case "Wood":
                    stock = dbh.getWood();
                    break;
                case "Screws":
                    stock = dbh.getScrews();
                    break;
                case "Paint":
                    stock = dbh.getPaint();
                    break;
                case "Oil":
                    stock = dbh.getOil();
                    break;
                case "Polish":
                    stock = dbh.getPolish();
                    break;
                case "Varnish":
                    stock = dbh.getVarnish();
                    break;
                case "Glue":
                    stock = dbh.getGlue();
                    break;
            }
            stockTable.getColumns().addAll(stock.get(0).getColumns());
            stockTable.setItems(stock);
        });

        /*if() {
            main = dbh.getProjectDetails();
            projectTable.getColumns().addAll(main.get(0).getColumns());
            projectTable.setItems(main);
        }*/


        //Project Layout
        HBox topView = new HBox(10);
        VBox leftView = new VBox(10);
        VBox imageAllign = new VBox();
        imageAllign.getChildren().add(logoDisplay);
        imageAllign.prefHeightProperty().bind(projectLayout.heightProperty());
        imageAllign.setAlignment(Pos.BOTTOM_CENTER);
        leftView.getChildren().addAll(projectBox, imageAllign);
        topView.getChildren().addAll(leftView, projectTable);
        projectLayout.setPadding(new Insets(10));
        projectLayout.getChildren().addAll(topView);

        //Stock layout
        VBox stockLeftLayout = new VBox(10);
        stockLeftLayout.getChildren().add(stockType);
        stockLayout.getChildren().addAll(stockLeftLayout, stockTable);

        primaryStage.setTitle("Marx Woodworks");
        primaryStage.getIcons().add(new Image("logomarx.png"));
        Scene scene = new Scene(root, 800, 580);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        root.getChildren().addAll(menuBar,tabPane);
        primaryStage.show();
    }
}
