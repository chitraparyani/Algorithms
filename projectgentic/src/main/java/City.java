public class City {

    private static final double EARTH_EQUATORIAL_RADIUS = 6378.1370D;
    private static final double CONVERT_DEGREE_TO_RADIANS = Math.PI/180D;
    private static final double CONVERT_KM_TO_MILES = 0.621371;
    private String name;
    private double longitude;
    private double latitude;

    public City(String name, double latitude, double longitude){
        this.name = name;
        this.longitude = longitude * CONVERT_DEGREE_TO_RADIANS;
        this.latitude = latitude * CONVERT_DEGREE_TO_RADIANS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String toString(){
        return getName();
    }

    public double measureDistance(City city){

        double deltaLongitude = city.getLongitude() - this.getLongitude();
        double deltaLatitude = city.getLatitude() - this.getLatitude();

        double dist = Math.pow(Math.sin(deltaLatitude/2D), 2D) +
                Math.cos(this.getLatitude()) * Math.cos(city.getLatitude()) *
                        Math.pow(Math.sin(deltaLatitude/2D),2D);

        return CONVERT_KM_TO_MILES * EARTH_EQUATORIAL_RADIUS * 2D * Math.atan2(Math.sqrt(dist),Math.sqrt(1D-dist));

    }
}
