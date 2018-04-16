


import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.Arrays;



public class INFO6205_510 {

    private static Logger LOGGER = Logger.getLogger(INFO6205_510.class.getName());

    public ArrayList<City> initialRoute = new ArrayList<City>(Arrays.asList(
            new City("Boston", 42.3601, -71.0589),
            new City("Houston", 29.7604, -95.3698),
            new City("Austin", 30.2672, -97.7431),
            new City("San Francisco", 37.7749, -122.4194),
            new City("Denver", 39.7392, -104.9903),
            new City("Los Angeles", 34.0522, -118.2437),
            new City("Chicago", 41.8781, -87.6298),
            new City("New York", 40.7128, -74.0059),
            new City("Dallas", 32.7767, -96.7970),
            new City("Seattle", 47.6062, -122.3321)
//            new City("Sydney", -33.8675, 151.2070)
//            new City("Tokyo", 35.6895, 139.6917),
//            new City("Cape Town", -33.9249, 18.4241)

    ));


    public static void main(String[] args) {
        INFO6205_510 i = new INFO6205_510();
        Population pop = new Population(GeneticAlgorithm.POPULATION_SIZE, i.initialRoute);
        pop.sortRoutesByFitness();
        int generationNumber = 0;
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(i.initialRoute);
        i.printGeneration(generationNumber);
        i.printPopulation(pop);
        while(generationNumber < GeneticAlgorithm.GENERATIONS){
            i.printGeneration(generationNumber++);
            pop = geneticAlgorithm.evolve(pop);
            pop.sortRoutesByFitness();
            i.printPopulation(pop);
        }
        LOGGER.info("Best Route so far:" +pop.getRoutes().get(0));
        LOGGER.info("w/ a distance of:" +String.format("%.2f", pop.getRoutes().get(0).calculateTotalDistance()) + "miles");
    }

    public void printPopulation(Population population){
        population.getRoutes().forEach(x -> {
            LOGGER.info(Arrays.toString(x.getCities().toArray()) + " | " +
                    String.format("%.4f", x.getFitness()) + " | " +
                    String.format("%.2f", x.calculateTotalDistance()));
        });
        LOGGER.info("");
    }

    public void printGeneration(int generationNumber){
        LOGGER.info("> Generation #" +generationNumber);
        String headingColumn = "Route";
        String remainHeadingCols = "Fitness | Distance (in miles)";
        int cityNamesLength = 0;
        for(int x = 0; x < initialRoute.size(); x++)
            cityNamesLength += initialRoute.get(x).getName().length();
        int arrayLength = cityNamesLength + initialRoute.size()*2;
        int partialLength = (arrayLength - headingColumn.length())/2;
        for(int x =0; x < partialLength; x++)
            LOGGER.info(" ");
            LOGGER.info(headingColumn);
        for(int x2 =0; x2 < partialLength; x2++)
            LOGGER.info(" ");
        if((arrayLength%2)==0)
            LOGGER.info(" ");
            LOGGER.info(" | " +remainHeadingCols);
        cityNamesLength += remainHeadingCols.length() + 3;
        for(int x2 = 0; x2 < cityNamesLength+initialRoute.size()*2;x2++)
            LOGGER.info("-");
            LOGGER.info(" ");
    }
}
