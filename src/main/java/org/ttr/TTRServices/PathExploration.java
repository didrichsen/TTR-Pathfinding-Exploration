package main.java.org.ttr.TTRServices;

import main.java.org.ttr.TTRModel.DijkstrasAlgorithm;
import main.java.org.ttr.TTRModel.Path;

public class PathExploration {

    public Path getShortestPath(String departureStation, String arrivalStation) {
        DijkstrasAlgorithm dijkstrasAlgorithm = new DijkstrasAlgorithm();
        Path path = dijkstrasAlgorithm.getShortestPath(departureStation, arrivalStation);
        return path;
    }





}
