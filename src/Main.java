import main.java.org.ttr.TTRModel.Path;
import main.java.org.ttr.TTRServices.PathExploration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PathExploration pathExploration = new PathExploration();

        Path path = pathExploration.getShortestPath("New York","San Francisco");

        System.out.println(path);

    }
}
