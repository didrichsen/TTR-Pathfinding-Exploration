package main.java.org.ttr.TTRModel;

import main.java.org.ttr.POJOs.City;
import main.java.org.ttr.POJOs.Route;
import main.java.org.ttr.TTRRepository.GameRepository;

import java.util.*;

public class MapGraph {

    public MapGraph() {
        GameRepository gameRepository = new GameRepository();
        List<City>cities = gameRepository.getCities();
        List<Route> routes = gameRepository.getRoutes();
        populateGraph(cities,routes);
    }

    public class Node{
        private City city;

        private List<Edge> edges = new ArrayList<>();

        public Node(City city) {
            this.city = city;
        }

        public City getCity() {
            return city;
        }

        @Override
        public String toString() {
            return city.getCityName();
        }

        public void addEdge(Node to, int weight){
            edges.add(new Edge(this,to, weight ));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

        static class NodeEntry{
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

            public Node getNode() {
                return node;
            }

            public void setNode(Node node) {
                this.node = node;
            }
        }

    public class Edge{
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public Node getFrom() {
            return from;
        }

        public void setFrom(Node from) {
            this.from = from;
        }

        public Node getTo() {
            return to;
        }

        public void setTo(Node to) {
            this.to = to;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    private Map<String,Node> nodes = new HashMap<>();

    public Map<String, Node> getNodes() {
        return nodes;
    }

    public void setNodes(Map<String, Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(City city){
        nodes.putIfAbsent(city.getCityName(), new Node(city));
    }


    public void addEdge(City fromCityName, City toCityName, int weight){
        Node fromCity = nodes.get(fromCityName.getCityName());
        Node toCity = nodes.get(toCityName.getCityName());
        fromCity.addEdge(toCity,weight);
        toCity.addEdge(fromCity,weight);
    }



    public void print(){
        for(Node city : nodes.values()){
            List<Edge> edges = city.getEdges();
            if(!edges.isEmpty()){
                System.out.println(city + " is connected to: " + edges);
            }
        }

    }

    public Node getNode(String cityName){
        Node city = nodes.get(cityName);
        return city;
    }

    public void populateGraph(List<City> cities, List<Route> routes) {
        for (City city : cities) {
            addNode(city);
        }

        for(Route route : routes){
            addEdge(route.getFromCity(),route.getToCity(),route.getTicketPriceInCards());
        }
    }

}