import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseHandler {
    private Connection con;

    DatabaseHandler(){
        System.out.println("System > Started");
        dbConnect();
    }

    private void dbConnect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marxwooddb", "root", "");
            System.out.println("System > Database Connected");
        } catch (Exception dbError) {
            System.out.println("System > Can not connect to database: " + dbError);
            System.out.println("System > Shutting down...");
            System.exit(0);
        }
    }

    public ObservableList<ParentPojo> getProjectDetails(){
        ObservableList<ParentPojo> list = FXCollections.observableArrayList();
        System.out.println("System > Retrieving data from table \"order_details\"...");
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM order_details");
            ResultSet rs = stmt.executeQuery();
            System.out.println("System > Data retrieved successfully from \"order_details\"");
            while(rs.next()){
                ProjectDetails projectDetails = new ProjectDetails(rs.getInt("order_number"),
                        rs.getString("order_type"),
                        rs.getInt("order_length"),
                        rs.getInt("order_width"),
                        rs.getInt("order_height"),
                        rs.getInt("order_amount"),
                        rs.getDouble("order_price")
                );
                list.add(projectDetails);
            }
        }catch (Exception dbError){
            System.out.println("System > Error getting data from table \"order_details\"");
            System.out.println(dbError);
        }
        return list;
    }

    public ObservableList<ParentPojo> getWood(){
        ObservableList<ParentPojo> list = FXCollections.observableArrayList();
        System.out.println("System > Retrieving data from table \"stock_wood\"...");
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM stock_wood");
            System.out.println("System > Data retrieved successfully from \"stock_wood\"");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Wood wood = new Wood(rs.getInt("wood_id"),
                                    rs.getString("wood_type"),
                                    rs.getInt("wood_length"),
                                    rs.getInt("wood_height"),
                                    rs.getInt("wood_width"),
                                    rs.getInt("wood_quantity")
                );
                list.add(wood);
            }
        }catch (Exception dbError){
            System.out.println("System > Error getting data from table \"stock_wood\"");
        }
            return list;
    }

    public ObservableList<ParentPojo> getScrews(){
        ObservableList<ParentPojo> list = FXCollections.observableArrayList();
        System.out.println("System > Retrieving data from table \"stock_screws\"...");
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM stock_screws");
            System.out.println("System > Data retrieved successfully from \"stock_screws\"");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Screws screws = new Screws(rs.getInt("screw_id"),
                        rs.getInt("screw_size"),
                        rs.getString("screw_color"),
                        rs.getInt("screw_quantity")
                );
                list.add(screws);
            }
        }catch (Exception dbError){
            System.out.println("System > Error getting data from table \"stock_screws\"");
        }
        return list;
    }

    public ObservableList<ParentPojo> getGlue(){
        ObservableList<ParentPojo> list = FXCollections.observableArrayList();
        System.out.println("System > Retrieving data from table \"stock_glue\"...");
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM stock_glue");
            System.out.println("System > Data retrieved successfully from \"stock_glue\"");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Glue glue = new Glue(rs.getInt("glue_id"),
                        rs.getString("glue_brand"),
                        rs.getInt("glue_volume"),
                        rs.getInt("glue_quantity")
                );
                list.add(glue);
            }
        }catch (Exception dbError){
            System.out.println("System > Error getting data from table \"stock_glue\"");
        }
        return list;
    }

    public ObservableList<ParentPojo> getPaint(){
        ObservableList<ParentPojo> list = FXCollections.observableArrayList();
        System.out.println("System > Retrieving data from table \"stock_paint\"...");
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM stock_paint");
            System.out.println("System > Data retrieved successfully from \"stock_paint\"");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Paint paint = new Paint(rs.getInt("paint_id"),
                        rs.getString("paint_type"),
                        rs.getString("paint_brand"),
                        rs.getString("paint_color"),
                        rs.getInt("paint_volume"),
                        rs.getInt("paint_quantity")
                );
                list.add(paint);
            }
        }catch (Exception dbError){
            System.out.println("System > Error getting data from table \"stock_paint\"");
        }
        return list;
    }

    public ObservableList<ParentPojo> getOil(){
        ObservableList<ParentPojo> list = FXCollections.observableArrayList();
        System.out.println("System > Retrieving data from table \"stock_oil\"...");
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM stock_oil");
            ResultSet rs = stmt.executeQuery();
            System.out.println("System > Data retrieved successfully from \"stock_oil\"");
            while(rs.next()){
                Oil oil = new Oil(rs.getInt("oil_id"),
                        rs.getString("oil_brand"),
                        rs.getString("oil_color"),
                        rs.getInt("oil_volume"),
                        rs.getInt("oil_quantity")
                );
                list.add(oil);
            }
        }catch (Exception dbError){
            System.out.println("System > Error getting data from table \"stock_oil\"");
        }
        return list;
    }

    public ObservableList<ParentPojo> getVarnish(){
        ObservableList<ParentPojo> list = FXCollections.observableArrayList();
        System.out.println("System > Retrieving data from table \"stock_varnish\"...");
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM stock_varnish");
            System.out.println("System > Data retrieved successfully from \"stock_varnish\"");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Varnish varnish = new Varnish(rs.getInt("varnish_id"),
                        rs.getString("varnish_type"),
                        rs.getString("varnish_brand"),
                        rs.getInt("varnish_volume"),
                        rs.getInt("varnish_quantity")
                );
                list.add(varnish);
            }
        }catch (Exception dbError){
            System.out.println("System > Error getting data from table \"stock_varnish\"");
        }
        return list;
    }

    public ObservableList<ParentPojo> getPolish(){
        ObservableList<ParentPojo> list = FXCollections.observableArrayList();
        System.out.println("System > Retrieving data from table \"stock_polish\"...");
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM stock_polish");
            System.out.println("System > Data retrieved successfully from \"stock_polish\"");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Polish polish = new Polish(rs.getInt("polish_id"),
                        rs.getString("polish_brand"),
                        rs.getInt("polish_volume"),
                        rs.getInt("polish_quantity")
                );
                list.add(polish);
            }
        }catch (Exception dbError){
            System.out.println("System > Error getting data from table \"stock_polish\"");
        }
        return list;
    }
}