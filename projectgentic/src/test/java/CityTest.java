/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chitr
 */
public class CityTest {
    
    public CityTest() {
    }

    /**
     * Test of getName method, of class City.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        City instance = new City("Boston", 42.3601, -71.0589);
        String expResult = "Boston";
        String result = instance.getName();
        assertEquals(expResult, result);
      
    }

   
    /**
     * Test of measureDistance method, of class City.
     */
    @Test
    public void testMeasureDistance() {
        System.out.println("measureDistance");
        City city = new City("Boston", 42.3601, -71.0589);;
        City instance = new City("Houston", 29.7604, -95.3698);
        double expResult = 1118.057558547373;
        double result = instance.measureDistance(city);
        assertEquals(expResult, result, 0.0);
        
    }
    
}
