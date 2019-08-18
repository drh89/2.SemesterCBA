/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.Controller_Impl;
import logic.PriceCalculator;

/**
 *
 * @author Dennis
 */
public class DataAccessorDB implements DataAccessor {

    private DBConnector con;

    public static void main(String[] args) throws SQLException, DataException, Exception {
        DataAccessorDB data = new DataAccessorDB();
        PriceCalculator logic = new PriceCalculator();
        Controller_Impl con = new Controller_Impl(data, logic);
        
        
        
//        data.addFrameToDB("DyrTest", 5000);
        
        

        System.out.println(data.getFrames().toString());
//        System.out.println(data.getFrame("Plain"));
//        System.out.println(data.getGlassPrice());
//        System.out.println(con.getTotalPrice(200, 200, "Plain"));
        
        
                
    }
    

    public DataAccessorDB() throws SQLException, Exception {
        con = new DBConnector();
    }

    @Override
    public List<Frame> getFrames() throws DataException {

        ArrayList<Frame> frames = new ArrayList<>();
        try {

            String query = "SELECT * FROM Frames;";
            Connection connection = con.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String frameName = rs.getString("frame_Name");
                int framePrice = rs.getInt("frame_Price_Pr_Meter");

                Frame frame = new Frame(frameName, framePrice);
                frames.add(frame);

            }

        } catch (SQLException ex) {
            ex.getMessage();
        }

        return frames;

    }

    @Override
    public Frame getFrame(String name) throws DataException {
        Frame finalFrame = new Frame("", 0);

        try {

            String query = "SELECT * FROM Frames WHERE frame_Name = '" + name + "';";
            Connection connection = con.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String frameName = rs.getString("frame_Name");
                double framePrice = rs.getInt("frame_Price_Pr_Meter");

                Frame frame = new Frame(frameName, framePrice);
                finalFrame = frame;

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return finalFrame;
    }

    @Override
    public double getGlassPrice() throws DataException {
        double price = 0;

        try {

            String query = "SELECT * FROM Glass";
            Connection connection = con.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                price = rs.getInt("glass_Price_Pr_Square");
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
        return price;

    }
    public void addFrameToDB(String frame_Name, int price_Pr_Meter) throws SQLException{
        
        String query =  "INSERT INTO Frames (frame_Name, frame_Price_Pr_Meter) "
                + "VALUES ('" + frame_Name + "', " + price_Pr_Meter + ");";
        
        Connection connection = con.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.execute();
    }

}
