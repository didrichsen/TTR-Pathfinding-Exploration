import main.java.org.ttr.POJOs.City;
import main.java.org.ttr.TTRModel.Path;
import main.java.org.ttr.TTRServices.CityDetails;
import main.java.org.ttr.TTRServices.PathExploration;

public class Main {

    public static void main(String[] args) {

        CityDetails cityDetails = new CityDetails();

        City city =  cityDetails.getCity("New York");
        System.out.println(city.getRoutes());

        PathExploration pathExploration = new PathExploration();
        Path path = pathExploration.getShortestPath("New York","San Francisco");

        System.out.println(path);

    }
}
