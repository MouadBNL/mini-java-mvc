package database;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBManager {

    public static DBManager dbManagerInstance = null;

    public static DBManager getInstance() {
        if(dbManagerInstance == null) {
            dbManagerInstance = new DBManager();
        }
        return dbManagerInstance;
    }

    public Connection makeConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(this.connectionUrl, this.dbUsername, this.dbPassword);
        return conn;
    }

    protected String configFilePath;
    protected String dbName;
    protected String dbUsername;
    protected String dbPassword;
    protected String dbHost;
    protected String dbPort;
    protected String connectionUrl;
    private DBManager() {
        this.dbName = "mvc_test";
        this.dbUsername = "root";
        this.dbPassword = "root";
        this.dbHost = "localhost";
        this.dbPort = "3306";
//        this.configFilePath = ".dbconf";
//        this.loadDatabaseConfig();
        this.connectionUrl = "jdbc:mysql://"+this.dbHost+":"+this.dbPort+"/" + this.dbName;
        // jdbc:mysql://localhost:3306/basedd
        try {
            this.makeConnection();
            System.out.println("Connected successfully");
        } catch (SQLException e) {
            System.out.println("Database connection Error: " + e.getMessage());
        }
    }

    protected void loadDatabaseConfig() {
        try {
            File config = new File(this.configFilePath);
            System.out.println(config.getAbsolutePath());
            Scanner reader = new Scanner(config);
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                if(line.contains("db_name")) {
                    line = line.replace("db_name=", "").replace("\"", "").trim();
                    this.dbName = line;
                } else if(line.contains("db_username")) {
                    line =line.replace("db_username=", "").replace("\"", "").trim();
                    this.dbUsername = line;
                } else if(line.contains("db_password")) {
                    line =line.replace("db_password=", "").replace("\"", "").trim();
                    this.dbPassword = line;
                } else if(line.contains("db_host")) {
                    line =line.replace("db_host=", "").replace("\"", "").trim();
                    this.dbHost = line;
                } else if(line.contains("db_port")) {
                    line =line.replace("db_port=", "").replace("\"", "").trim();
                    this.dbPort = line;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}