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

        private List<Edge> routes = new ArrayList<>();

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
            routes.add(new Edge(this,to, weight ));
        }

        public List<Edge> getRoutes() {
            return routes;
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
    private Map<Node,List<Node>> adjacencyList = new HashMap<>();

    public Map<Node, List<Node>> getAdjacencyList() {
        return adjacencyList;
    }

    public Map<String, Node> getNodes() {
        return nodes;
    }

    public void setNodes(Map<String, Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(City city){
        Node newNode = new Node(city);
        nodes.putIfAbsent(city.getCityName(), newNode);
        adjacencyList.putIfAbsent(newNode,new ArrayList<>());
    }


    public void addEdge(City depatureCity, City arrivalCity, int numberOfCardsToTravel){
            Node fromCity = nodes.get(depatureCity.getCityName());
            if(fromCity == null)
                throw new IllegalArgumentException();

            Node toCity = nodes.get(arrivalCity.getCityName());
            if(toCity == null)
                throw new IllegalArgumentException();

            adjacencyList.get(fromCity).add(toCity);
            adjacencyList.get(toCity).add(fromCity);

            fromCity.addEdge(toCity,numberOfCardsToTravel);
            toCity.addEdge(fromCity,numberOfCardsToTravel);
    }



    public void print(){
        for(Node city : nodes.values()){
            List<Edge> edges = city.getRoutes();
            if(!edges.isEmpty()){
                System.out.println(city + " is connected to: " + edges);
            }
        }

    }

    public Node getNode(String cityName){
        Node city = nodes.get(cityName);
        return city;
    }

    public void populateGraph(List<City> cities,List<Route> routes) {
        for (City city : cities) {
            addNode(city);

        }
        for(Route route : routes){
            addEdge(route.getFromCity(),route.getToCity(),route.getTicketPriceInCards());
        }

    }

}