package model;

import database.DBManager;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Model {
    protected Connection conn;
    protected void init() {
        DBManager db = DBManager.getInstance();
        try {
            this.conn = db.makeConnection();
        } catch (SQLException e) {
            System.out.println("Error: could not establish connection");
        }
    }

    public abstract boolean create();
}
