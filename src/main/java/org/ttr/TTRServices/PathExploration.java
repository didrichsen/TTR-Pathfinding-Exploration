package main.java.org.ttr.TTRServices;

import main.java.org.ttr.TTRModel.DijkstrasAlgorithm;
import main.java.org.ttr.TTRModel.Path;

public class PathExploration {

    /*
    public void outputPathInformation(Scanner sc) {

        String[] cityPair;

        cityPair = Utility.promptDepartureAndArrivalCity(sc,cities);

        Path path = getPath(cityPair[0], cityPair[1]);

        System.out.println(path);
        System.out.println("\n So, above can you see the suggested route!\n");

    }

     */


    public Path getShortestPath(String departureStation, String arrivalStation) {
        DijkstrasAlgorithm dijkstrasAlgorithm = new DijkstrasAlgorithm();
        Path path = dijkstrasAlgorithm.getShortestPath(departureStation, arrivalStation);
        return path;
    }





}
