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
 * @author chitra
 */
public class PopulationTest {
    
    /**
     * Test of getRoutes method, of class Population.
     */
    @Test
    public void testGetRoutes() {
        System.out.println("getRoutes");
             ArrayList<City> cities = new ArrayList<>(Arrays.asList(
            new City("Boston", 42.3601, -71.0589),
            new City("Houston", 29.7604, -95.3698)//,
    ));
        Population instance = new Population(2,cities);
        ArrayList<City> expResult = cities;
        ArrayList<Route> result = instance.getRoutes();
        ArrayList<City> resList = result.get(0).getCities();
        assertEquals(expResult, resList);
    }

    /**
     * Test of sortRoutesByFitness method, of class Population.
     */
    @Test
    public void testSortRoutesByFitness() {
        System.out.println("sortRoutesByFitness");
                     ArrayList<City> cities = new ArrayList<>(Arrays.asList(
            new City("Boston", 42.3601, -71.0589),
            new City("Houston", 29.7604, -95.3698)//,
    ));
        Population instance = new Population(2, cities);
        ArrayList<Route> routeList = instance.getRoutes();
        
//        routeList.get(0).set(0.6);
//        routeList.get(1).setFitness(0.3);
        
        instance.sortRoutesByFitness();
        ArrayList<Route> sortedRoutes = instance.getRoutes();   
        assertTrue(sortedRoutes.get(0).getFitness() <= sortedRoutes.get(1).getFitness());
        
       
    }
    
}
