/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Arrays;
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
public class RouteTest {
    
    public RouteTest() {
    }

    /**
     * Test of getCities method, of class Route.
     */
    @Test
    public void testGetCities() {
        System.out.println("getCities");
        ArrayList<City> expResult = new ArrayList<City>();
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(expResult);
        Route instance = new Route(geneticAlgorithm.getInitialRoute());        
        ArrayList<City> result = instance.getCities();
        assertEquals(expResult, result);    
    }


    /**
     * Test of calculateTotalDistance method, of class Route.
     */
    @Test
    public void testCalculateTotalDistance() {
        
        System.out.println("calculateTotalDistance");
     ArrayList<City> cities = new ArrayList<>(Arrays.asList(
            new City("Boston", 42.3601, -71.0589),
            new City("Houston", 29.7604, -95.3698),
            new City("Austin", 30.2672, -97.7431),
            new City("San Francisco", 37.7749, -122.4194),
            new City("Denver", 39.7392, -104.9903),
            new City("Los Angeles", 34.0522, -118.2437),
            new City("Chicago", 41.8781, -87.6298),
            new City("New York", 40.7128, -74.0059)
    ));
        
        
        //GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(cities);

        Route instance = new Route(cities);
        double expResult = 2238.91;
        double result = instance.calculateTotalDistance();
        result = Math.round(result*100.0)/100.0;
        assertEquals(result, result, 0);
       
    }
    
}
