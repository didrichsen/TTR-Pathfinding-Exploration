package main.java.org.ttr.TTRModel;

import main.java.org.ttr.POJOs.City;
import main.java.org.ttr.POJOs.Route;

import java.util.*;

public class BFS extends MapGraph {

    public void traverseBreadthFirst(String cityName) {
        Node city = getNode(cityName);

        if (city == null)
            return;

        Set<Node> visited = new HashSet<>();

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(city);

        while (!queue.isEmpty()) {
            Node current = queue.remove();

            if(visited.contains(current))
                continue;

            System.out.println(current.getCity().getCityName());

            visited.add(current);

            for (Node neighbour : getAdjacencyList().get(current)) {
                if(!visited.contains(neighbour)){
                    queue.add(neighbour);
                }
            }
        }
    }



}

