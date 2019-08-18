/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DataAccessor;
import data.DataException;
import data.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dennis
 */
public class Controller_Impl implements Controller {

    private DataAccessor data;
    private PriceCalculator logic;

    public Controller_Impl(DataAccessor data, PriceCalculator logic) {

        this.data = data;
        this.logic = logic;
    }

    @Override
    public List<String> getFrameNames() {
        try {
            List<Frame> frames = data.getFrames();
            ArrayList<String> frameNames = new ArrayList();
            
            for (Frame frame : frames) {
                frameNames.add(frame.getName());
                
            }
            return frameNames;
            
            
        } catch (DataException ex) {
            ex.printStackTrace();
        }
        return new ArrayList();
    }

    @Override
    public double getTotalPrice(int height_cm, int width_cm, String frameName) {
        try {
            double height_m = height_cm / 100.0;
            double width_m = width_cm / 100.0;
            double framePrice = data.getFrame(frameName).getPrice();
            double glassPrice = data.getGlassPrice();
   
            double totalPrice = logic.calculatePrice(height_m, width_m, framePrice, glassPrice);
            return totalPrice;
        } catch (DataException | CalculatorException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
     

}
