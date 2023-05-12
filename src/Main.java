import main.java.org.ttr.POJOs.City;
import main.java.org.ttr.TTRModel.BFS;
import main.java.org.ttr.TTRModel.Path;
import main.java.org.ttr.TTRServices.CityDetails;
import main.java.org.ttr.TTRServices.PathExploration;

public class Main {

    public static void main(String[] args) {

        System.out.println("---Find City Using Binary Search---");
        CityDetails cityDetails = new CityDetails();
        City city =  cityDetails.getCityUsingBinarySearch("New York");
        System.out.println(city.getRoutes() + "\n");

        System.out.println("---Find Shortest Path Using Dijkstra's Algorithm---");
        PathExploration pathExploration = new PathExploration();
        Path path = pathExploration.getShortestPath("New York","San Francisco");
        System.out.println(path + "\n");

        System.out.println("---Explore Breadth First Search---");
        BFS bfs = new BFS();
        bfs.traverseBreadthFirst("New York");




    }
}
