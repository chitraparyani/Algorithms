import java.util.ArrayList;
import java.util.stream.IntStream;

public class GeneticAlgorithm {

    public static final double MUTATION = 0.25;
    public static final int CROSSOVER = 3;
    public static final int POPULATION_SIZE = 8;
    public static final int ELITE_ROUTES = 1;
    public static final int GENERATIONS =30;

    private ArrayList<City> initialRoute = null;

    public GeneticAlgorithm(ArrayList<City> initialRoute){
        this.initialRoute = initialRoute;
    }

    public ArrayList<City> getInitialRoute(){
        return initialRoute;
    }

    public Population evolve(Population populate){
        return mutatePopulation(crossoverPopulation(populate));
    }

    Population crossoverPopulation(Population population){
        Population crossoverPopulation = new Population(population.getRoutes().size(), this);
        IntStream.range(0, ELITE_ROUTES)
                .forEach(x -> crossoverPopulation.getRoutes().set(x, population.getRoutes().get(x)));
        IntStream.range(ELITE_ROUTES, crossoverPopulation.getRoutes().size()).forEach(x -> {
            Route route1 = selectPopulation(population).getRoutes().get(0);
            Route route2 = selectPopulation(population).getRoutes().get(0);
            crossoverPopulation.getRoutes().set(x, crossoverRoute(route1, route2));
        });
        return crossoverPopulation;
    }

    Population mutatePopulation(Population population){
        population.getRoutes().stream().filter(x -> population.getRoutes().indexOf(x) >= ELITE_ROUTES)
                .forEach(x -> mutateRoute(x));
        return population;
    }

    Route crossoverRoute(Route route1, Route route2){
        Route crossoverRoute = new Route(this);
        Route tempRoute1 = route1;
        Route tempRoute2 = route2;
        if(Math.random() < 0.5){
            tempRoute1 = route2;
            tempRoute2 = route1;
        }
        for(int x = 0; x < crossoverRoute.getCities().size()/2; x++)
            crossoverRoute.getCities().set(x, tempRoute1.getCities().get(x));
        return fillNullsInCrossoverRoute(crossoverRoute, route2);
    }

    private Route fillNullsInCrossoverRoute(Route crossoverRoute, Route route){
        route.getCities().stream().filter(x -> !crossoverRoute.getCities().contains(x)).forEach(cityX ->{
            for(int y =0; y < route.getCities().size(); y++){
                if(crossoverRoute.getCities().get(y) == null){
                    crossoverRoute.getCities().set(y, cityX);
                    break;
                }
            }
        });
        return crossoverRoute;
    }

    Route mutateRoute(Route route){
        route.getCities().stream().filter(x -> Math.random() < MUTATION).forEach(cityX -> {
            int y = (int) (route.getCities().size() * Math.random());
            City cityY = route.getCities().get(y);
            route.getCities().set(route.getCities().indexOf(cityX), cityY);
            route.getCities().set(y, cityX);
        });
        return route;
    }

    Population selectPopulation(Population population){
        Population pop = new Population(CROSSOVER, this);
        IntStream.range(0, CROSSOVER).forEach(x -> pop.getRoutes().set(x,population.getRoutes()
                .get((int)(Math.random() * pop.getRoutes().size()))));
        pop.sortRoutesByFitness();
        return pop;
    }
}
