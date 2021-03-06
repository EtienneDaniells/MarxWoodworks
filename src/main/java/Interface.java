import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Interface extends Application {

    private final Stage showProjectInput = new Stage();
    private final Stage showClientInput = new Stage();
    private Label typeLbl = new Label("Type");
    private ComboBox<String> typeCombo = new ComboBox<>();
    private Button acceptBtn = new Button("Accept");
    private Button cancelBtn = new Button("Cancel");
    private Label heightLbl = new Label("Height (mm)");
    private TextField heightTxt = new TextField();
    private Label lengthLbl = new Label("Length (mm)");
    private TextField lengthTxt = new TextField();
    private Label widthLbl = new Label("Width (mm)");
    private TextField widthTxt = new TextField();
    private Label quantityLbl = new Label("Quantity");
    private TextField quantityTxt = new TextField();
    private Label pricePILbl = new Label("Item Price (R)");
    private TextField pricePITxt = new TextField();
    private Label statusLbl = new Label("Status");
    private ComboBox<String> statusCombo = new ComboBox<>();
    private Label userLbl = new Label("Client");
    private ComboBox<String> userCombo = new ComboBox<>();
    private TableView projectTable = new TableView();
    private DatabaseHandler dbh = new DatabaseHandler();
    private ObservableList<Stock> main;
    private ObservableList<Stock> stockInitial;
    private ObservableList<String> clients;
    private Button newClientBtn = new Button("New Client");
    private TextField clientNameTxt = new TextField();
    private Label clientNameLbl = new Label("Client Name: ");
    private TextField clientSurnameTxt = new TextField();
    private Label clientSurnameLbl = new Label("Client Surname:");
    private TextField clientAddressTxt = new TextField();
    private Label clientAddressLbl = new Label("Client Address:");
    private TextField clientEmailTxt = new TextField();
    private Label clientEmailLbl = new Label("Client e-Mail:");
    private TextField clientPhoneTxt = new TextField();
    private Label clientPhoneLbl = new Label("Client Phone Nr:");
    private Button acceptClientBtn = new Button("Accept");
    private Button cancelClientBtn = new Button("Cancel");
    private Button newStockBtn = new Button("New Item");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        //Layouts
        VBox root = new VBox();
        Scene scene = new Scene(root, 1366, 768);
        VBox projectLayout = new VBox();
        projectLayout.prefHeightProperty().bind(scene.heightProperty());
        HBox stockLayout = new HBox();
        VBox stockLeftLayout = new VBox(10);
        stockLeftLayout.setMinWidth(200);


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

        //New project input pane
        typeCombo.getItems().addAll("Chair", "Table", "Cupboard", "Desk", "Bed");
        typeCombo.prefWidthProperty().bind(projectBox.widthProperty());
        typeCombo.setPromptText("-select-");

        HBox newProjButtons = new HBox(20);
        newProjButtons.setPadding(new Insets(10));
        newProjButtons.getChildren().addAll(acceptBtn, cancelBtn);
        acceptBtn.setPrefWidth(100);
        cancelBtn.setPrefWidth(100);

        clients = dbh.getClients();
        userCombo.getItems().addAll(clients);
        userCombo.prefWidthProperty().bind(projectBox.widthProperty());
        userCombo.setPromptText("-select-");

        statusCombo.setPromptText("-select-");
        statusCombo.getItems().addAll("Not Started", "In Progress", "Postponed", "Completed");
        statusCombo.prefWidthProperty().bind(projectBox.widthProperty());

        projectBox.getChildren().addAll(typeLbl, typeCombo, heightLbl, heightTxt, lengthLbl, lengthTxt, widthLbl, widthTxt, quantityLbl, quantityTxt,
                                        pricePILbl, pricePITxt, statusLbl, statusCombo, userLbl, userCombo, newProjButtons);

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
        GridPane.setConstraints(statusLbl, 0,6);
        GridPane.setConstraints(statusCombo, 1,6);
        GridPane.setConstraints(userLbl, 0,7);
        GridPane.setConstraints(userCombo, 1,7);
        GridPane.setConstraints(newProjButtons, 0,8,2,1);

        //New client input pane
        HBox newClientBtns = new HBox(10);
        newClientBtns.getChildren().addAll(acceptClientBtn, cancelClientBtn);
        newClientBtns.setPadding(new Insets(10));
        acceptClientBtn.setMinWidth(100);
        cancelClientBtn.setMinWidth(100);
        GridPane newClientBox = new GridPane();
        newClientBox.getColumnConstraints().add(new ColumnConstraints(90));
        newClientBox.getStyleClass().add("projectBox");
        newClientBox.setPadding(new Insets(10));
        newClientBox.setVgap(15);
        newClientBox.setHgap(10);
        newClientBox.setMinHeight(290);

        newClientBox.getChildren().addAll(clientNameLbl, clientNameTxt, clientSurnameLbl, clientSurnameTxt, clientAddressLbl, clientAddressTxt,
                clientEmailLbl, clientEmailTxt, clientPhoneLbl, clientPhoneTxt, newClientBtns);
        newClientBox.setConstraints(clientNameLbl, 0,0);
        newClientBox.setConstraints(clientNameTxt, 1,0);
        newClientBox.setConstraints(clientSurnameLbl, 0,1);
        newClientBox.setConstraints(clientSurnameTxt, 1,1);
        newClientBox.setConstraints(clientAddressLbl, 0,2);
        newClientBox.setConstraints(clientAddressTxt, 1,2);
        newClientBox.setConstraints(clientEmailLbl, 0,3);
        newClientBox.setConstraints(clientEmailTxt, 1,3);
        newClientBox.setConstraints(clientPhoneLbl, 0,4);
        newClientBox.setConstraints(clientPhoneTxt, 1,4);
        GridPane.setConstraints(newClientBtns, 0,5,2,1);

        Image logo = new Image(getClass().getResourceAsStream("logomarx.png"));
        ImageView logoDisplay = new ImageView(logo);
        logoDisplay.fitWidthProperty().bind(projectBox.widthProperty());

        //Stock input pane
        ComboBox<String> stockType = new ComboBox();
        stockType.getItems().addAll("Wood", "Paint", "Oil", "Varnish", "Glue", "Polish", "Screws");
        stockType.setPrefWidth(120);
        stockType.setValue("Wood");

        GridPane newStockBox = new GridPane();
        newStockBox.getColumnConstraints().add(new ColumnConstraints(90));
        newStockBox.getStyleClass().add("newStockBox");
        newStockBox.setPadding(new Insets(10));
        newStockBox.setVgap(8);
        newStockBox.setHgap(10);
        newStockBox.setMinHeight(290);

        //Table to display project details

            projectTable.prefHeightProperty().bind(root.heightProperty());
            projectTable.prefWidthProperty().bind(root.widthProperty());
            getProjectDetails();

        //Table to display stock details
        TableView stockTable = new TableView();
        stockTable.prefHeightProperty().bind(stockLayout.heightProperty());
        stockTable.prefWidthProperty().bind(stockLayout.widthProperty());
        stockInitial = dbh.getWood();
        if(!stockInitial.isEmpty()) {
            stockTable.getColumns().addAll(stockInitial.get(0).getColumns(stockTable));
            stockTable.setItems(stockInitial);
        }
        stockType.valueProperty().addListener((ov, t, t1) -> {
            ObservableList<Stock> stock = null;
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
            if(!stock.isEmpty()) {
                stockTable.getColumns().clear();
                stockTable.getColumns().addAll(stock.get(0).getColumns(stockTable));
                stockTable.setItems(stock);
            }
        });

        //Project Layout
        //new Project input
        showProjectInput.initModality(Modality.APPLICATION_MODAL);
        showProjectInput.initOwner(primaryStage);
        showProjectInput.setTitle("Add new Project");
        showProjectInput.setMinWidth(268);
        showProjectInput.setMaxWidth(268);
        showProjectInput.getIcons().add(new Image("logomarx.png"));
        Scene newProjectScene = new Scene(projectBox);
        HBox topView = new HBox(10);
        VBox leftView = new VBox(10);
        leftView.setPadding(new Insets(40, 0, 0, 0));
        leftView.setAlignment(Pos.CENTER);
        VBox imageAllign = new VBox();
        Button newProjectBtn = new Button("New Project");

        newProjectBtn.setOnAction(e ->{
            showProjectInput.setScene(newProjectScene);
            showProjectInput.showAndWait();
        });


        cancelBtn.setOnAction(e -> clear());

        acceptBtn.setOnAction(e -> {
            if(userCombo.getValue() == null) {
                alertError("Please select a user");
            }else if(typeCombo.getValue() == null){
                alertError("Please select item type");
            }else if(statusCombo.getValue() == null) {
                alertError("Please select a project status");
            }else if(heightTxt.getText().equals("") || lengthTxt.getText().equals("")|| widthTxt.getText().equals("") || quantityTxt.getText().equals("") || pricePITxt.getText().equals("")){
                alertError("Please fill in all the textfields");
            }else{
                dbh.addNewRecord(
                        typeCombo.getValue(),
                        Integer.parseInt(heightTxt.getText()),
                        Integer.parseInt(lengthTxt.getText()),
                        Integer.parseInt(widthTxt.getText()),
                        Integer.parseInt(quantityTxt.getText()),
                        Double.parseDouble(pricePITxt.getText()),
                        userCombo.getValue(),
                        statusCombo.getValue());
                clear();
                getProjectDetails();
            }
        });

        //new Client input
        showClientInput.initModality(Modality.APPLICATION_MODAL);
        showClientInput.initOwner(primaryStage);
        showClientInput.setTitle("Add new Client");
        showClientInput.setMinWidth(268);
        showClientInput.setMaxWidth(268);
        showClientInput.getIcons().add(new Image("logomarx.png"));
        Scene newClientScene = new Scene(newClientBox);

        newClientBtn.setOnAction(e -> {
            showClientInput.setScene(newClientScene);
            showClientInput.showAndWait();
        });

        Button editRecordsBtn = new Button("Edit Records");
        newProjectBtn.setMinWidth(120);
        editRecordsBtn.setMinWidth(120);
        newClientBtn.setMinWidth(120);
        imageAllign.getChildren().add(logoDisplay);
        imageAllign.prefHeightProperty().bind(root.heightProperty());
        imageAllign.setAlignment(Pos.BOTTOM_CENTER);
        leftView.getChildren().addAll(newProjectBtn, editRecordsBtn, newClientBtn, imageAllign);
        topView.getChildren().addAll(leftView, projectTable);
        projectLayout.setPadding(new Insets(10));
        projectLayout.getChildren().addAll(topView);

        cancelClientBtn.setOnAction(e -> clearClient());

        acceptClientBtn.setOnAction(e -> {
            if(!clientEmailTxt.getText().contains("@") || !clientEmailTxt.getText().contains(".co")){
                alertError("Please enter a valid e-mail address");
            }else if(clientPhoneTxt.getText().length() != 10 || !clientPhoneTxt.getText().matches("[0-9]+")){
                alertError("Please enter a valid phone number");
            }else{
                dbh.addNewClient(
                        clientNameTxt.getText(),
                        clientSurnameTxt.getText(),
                        clientAddressTxt.getText(),
                        clientEmailTxt.getText(),
                        clientPhoneTxt.getText()
                );
                clearClient();
            }
        });

        //Stock layout
        VBox pane = new VBox();
        HBox stockTypeBox = new HBox(20);
        Label stockTypeLbl = new Label("Type");
        stockTypeBox.getChildren().addAll(stockTypeLbl ,stockType);
        pane.prefHeightProperty().bind(stockLeftLayout.heightProperty());
        newStockBtn.setPrefWidth(120);
        stockLeftLayout.getChildren().addAll(stockType, newStockBtn , pane);
        stockLeftLayout.setAlignment(Pos.CENTER);
        stockLeftLayout.setPadding(new Insets(20, 0,20,0));
        stockLayout.getChildren().addAll(stockLeftLayout, stockTable);
        stockLayout.setPadding(new Insets(10));

        primaryStage.setTitle("Marx Woodworks");
        primaryStage.getIcons().add(new Image("logomarx.png"));
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        root.getChildren().addAll(menuBar,tabPane);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(580);
        primaryStage.show();
    }

    private void clear(){
        showProjectInput.close();
        heightTxt.setText("");
        lengthTxt.setText("");
        widthTxt.setText("");
        pricePITxt.setText("");
        statusCombo.setValue(null);
        quantityTxt.setText("");
        userCombo.setValue(null);
        typeCombo.setValue(null);
    }

    private void clearClient(){
        showClientInput.close();
        clientNameTxt.setText("");
        clientSurnameTxt.setText("");
        clientAddressTxt.setText("");
        clientEmailTxt.setText("");
        clientPhoneTxt.setText("");
    }

    private void getProjectDetails(){
        main = dbh.getProjectDetails();
        if(!main.isEmpty()) {
            projectTable.getColumns().clear();
            projectTable.getColumns().addAll(main.get(0).getColumns(projectTable));
            projectTable.setItems(main);
        }
    }

    private void alertError(String error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText("You entered invalid information");
        alert.setContentText(error);
        alert.showAndWait();
    }

}
