package main.java.org.ttr.TTRServices;

import main.java.org.ttr.POJOs.City;
import main.java.org.ttr.POJOs.Route;
import main.java.org.ttr.TTRModel.MapGraph;
import main.java.org.ttr.TTRModel.Path;
import main.java.org.ttr.TTRRepository.GameRepository;

import java.util.List;
import java.util.Scanner;

public class ShortestPath {

    MapGraph mapGraph = new MapGraph();
    List<City> cities;
    List<Route> routes;

    public ShortestPath(){
        GameRepository gameRepository = new GameRepository();
        cities = gameRepository.getCities();
        routes = gameRepository.getRoutes();
        this.mapGraph.populateGraph(mapGraph,cities,routes);

    }


    public void outputPathInformation(Scanner sc) {

        String[] cityPair;

        cityPair = Utility.promptDepartureAndArrivalCity(sc,cities);

        Path path = getPath(cityPair[0], cityPair[1]);

        System.out.println(path);
        System.out.println("\n So, above can you see the suggested route!\n");

    }


    private Path getPath(String departureStation, String arrivalStation) {
        Path path = mapGraph.getShortestPath(departureStation, arrivalStation);
        return path;
    }



}
