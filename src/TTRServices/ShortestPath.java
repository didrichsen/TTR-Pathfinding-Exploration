package TTRServices;

import POJOs.City;
import POJOs.Route;
import TTRDao.*;
import TTRModel.*;

import java.util.List;
import java.util.Scanner;

public class ShortestPath {

    MapGraph cityGraph = new MapGraph();
    List<City> cities;
    List<Route> routes;

    public ShortestPath(){
        GameRepository gameRepository = new GameRepository();
        cities = gameRepository.getCities();
        routes = gameRepository.getRoutes();

    }

    public void loadRepository(Scanner sc, String name){

        for (City city : cities) {
            cityGraph.addNode(city);
        }

        for(Route route : routes){
            cityGraph.addEdge(route.getFromCity(),route.getToCity(),route.getTicketPriceInCards());
        }


        System.out.println("\nEnter your station of departure: \n");
        String departureStation = sc.nextLine();
        boolean foundDepartureStation = validateInput(departureStation,cities);
        while (!foundDepartureStation){
            System.out.println("Hmm! Think you misspelled that one, " + name + ". Try again.");
            departureStation = sc.nextLine();
            foundDepartureStation = validateInput(departureStation,cities);
        }


        System.out.println("\nAwesome! Now, enter your station of arrival: \n");

        String arrivalStation = sc.nextLine();

        boolean foundArrivalStation = validateInput(arrivalStation,cities);
        while (!foundArrivalStation){
            System.out.println("Hmm! I don't know that city, " + name + ". Try again.");
            arrivalStation = sc.nextLine();
            foundArrivalStation = validateInput(arrivalStation,cities);
        }

        Path path = cityGraph.getShortestPath(departureStation,arrivalStation);

        System.out.println(path);
        System.out.println("\n So, above can you see the suggested route!\n");
    }

    boolean validateInput(String cityName, List<City> cities){
        for(City city : cities){
            if(city.getCityName().equalsIgnoreCase(cityName)){
                return true;
            }

        }

        return false;
    }

}
