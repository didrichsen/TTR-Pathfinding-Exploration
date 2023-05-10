package main.java.org.ttr.TTRModel;

import main.java.org.ttr.POJOs.City;
import main.java.org.ttr.POJOs.Route;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BFS {
/*
    private MapGraph graph;

    public BFS(MapGraph graph) {
        this.graph = graph;
    }

    public void traverseBreadthFirst(String cityName){
        MapGraph.Node city = cities.get(cityName);
        if(city == null) return;

        Queue<MapGraph.Node> queue = new ArrayDeque<>();
        queue.add(city);

        Set<MapGraph.Node> visited = new HashSet<>();


        while (!queue.isEmpty()){

            MapGraph.Node current = queue.remove();

            if(visited.contains(current)){
                continue;
            }
            System.out.println(current.city.getCityName());
            visited.add(current);

            for(MapGraph.Node node : adjacencyList.get(current)){
                for(Route route : node.city.getNeighbours()){
                    MapGraph.Node newNode = cities.get(route.getFromCity().getCityName());
                    if(newNode == null){
                        continue;
                    }
                    queue.add(newNode);
                }
            }
        }
    }

 */

}
