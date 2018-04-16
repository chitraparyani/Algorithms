import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

public class Route {

    private boolean isFitnessChanged = true;
    private double fitness = 0;
    private ArrayList<City> cities = new ArrayList<City>();

    public Route(GeneticAlgorithm geneticAlgorithm){
        geneticAlgorithm.getInitialRoute().forEach(new Consumer<City>() {

            public void accept(City x) {
                cities.add(null);
            }
        });
    }

    public Route(ArrayList<City> cities){
        this.cities = cities;
        Collections.shuffle(this.cities);
    }

    public ArrayList<City> getCities() {
        isFitnessChanged = true;
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public double getFitness(){
        if(isFitnessChanged == true){
            fitness = (1/calculateTotalDistance())*10000;
            isFitnessChanged = false;
        }
        return fitness;
    }

    public double calculateTotalDistance(){
        int size = this.cities.size();
        return (this.cities.stream().mapToDouble(x -> {
            int cityIndex = this.cities.indexOf(x);
            double returnValue = 0;
            if(cityIndex < size - 1) returnValue = x.measureDistance(this.cities.get(cityIndex + 1));
            return returnValue;
        }).sum() + this.cities.get(0).measureDistance(this.cities.get(size - 1)));
    }

    public String toString(){
        return Arrays.toString(cities.toArray());
    }


}
