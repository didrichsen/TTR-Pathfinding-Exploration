package main.java.org.ttr.TTRModel;

import java.util.*;

public class DijkstrasAlgorithm {

    MapGraph mapGraph = new MapGraph();

    public Path getShortestPath(String departureCity,String arrivalCity){
        Map<String, MapGraph.Node> cities = mapGraph.getNodes();
        Path path = getShortestPath(departureCity,arrivalCity,cities);
        return path;
    }

    private Path getShortestPath(String from, String to, Map<String, MapGraph.Node> cities){

        MapGraph.Node nodeFromCity;
        MapGraph.Node nodeToCity;

        nodeFromCity = mapGraph.getNode(from);
        nodeToCity = mapGraph.getNode(to);

        Map<MapGraph.Node,Integer> distances = new HashMap<>();
        for(MapGraph.Node node : cities.values()){
            distances.put(node,Integer.MAX_VALUE);
            distances.replace(nodeFromCity,0);
        }

        Map<MapGraph.Node, MapGraph.Node> previousCity = new HashMap<>();

        Set<MapGraph.Node> visited = new HashSet<>();

        PriorityQueue<MapGraph.NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(MapGraph.NodeEntry::getPriority));

        queue.add(new MapGraph.NodeEntry(nodeFromCity,0));

        while(!queue.isEmpty()){
            MapGraph.Node current = queue.remove().getNode();
            visited.add(current);
            for(MapGraph.Edge edge : current.getRoutes()){
                if(visited.contains(edge.getTo()))
                    continue;
                int newDistance = distances.get(current) + edge.getWeight();
                if(newDistance < distances.get(edge.getTo())){
                    distances.replace(edge.getTo(), newDistance);
                    previousCity.put(edge.getTo(),current);
                    queue.add(new MapGraph.NodeEntry(edge.getTo(),newDistance));
                }
            }
        }

        return buildPath(previousCity,nodeToCity);

    }

    private Path buildPath(Map<MapGraph.Node, MapGraph.Node> previousCity, MapGraph.Node toCity){
        Stack<MapGraph.Node> stack = new Stack<>();
        stack.push(toCity);
        MapGraph.Node previous = previousCity.get(toCity);
        while(previous != null){
            stack.push(previous);
            previous = previousCity.get(previous);
        }

        Path path = new Path();

        while (!stack.isEmpty()){
            path.add(stack.pop().getCity());
        }
        return path;
    }



}
