import java.util.*;

public class MapGraph {

    private class Node{
        private City city;

        private List<Edge> edges = new ArrayList<>();

        public Node(City city) {
            this.city = city;
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

    private class NodeEntry{
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    private class Edge{
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    private Map<String,Node> cities = new HashMap<>();
    private Map<Node,List<Node>> adjacencyList = new HashMap<>();

    public void addNode(City city){
        cities.putIfAbsent(city.getCityName(), new Node(city));
    }

    public void traverseBreadthFirst(String cityName){
        Node city = cities.get(cityName);
        if(city == null) return;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(city);

        Set<Node> visited = new HashSet<>();


        while (!queue.isEmpty()){

            Node current = queue.remove();

            if(visited.contains(current)){
                continue;
            }
            System.out.println(current.city.getCityName());
            visited.add(current);

            for(Node node : adjacencyList.get(current)){
                for(City neighbour : node.city.getNeighbours()){
                    Node newNode = cities.get(neighbour.getCityName());
                    if(newNode == null){
                        continue;
                    }
                    queue.add(newNode);
                }
            }
        }
    }





    public void addEdge(City fromCityName, City toCityName, int weight){
        Node fromCity = cities.get(fromCityName.getCityName());
        Node toCity = cities.get(toCityName.getCityName());
        fromCity.addEdge(toCity,weight);
        toCity.addEdge(fromCity,weight);
    }



    public void print(){
        for(Node city : cities.values()){
            List<Edge> edges = city.getEdges();
            if(!edges.isEmpty()){
                System.out.println(city + " is connected to: " + edges);
            }
        }

    }

//Dijkstra's algorithm

    public Path getShortestPath(String from, String to){

        Node fromCity = cities.get(from);
        Node toCity = cities.get(to);

        Map<Node,Integer> distances = new HashMap<>();
        for(Node node : cities.values()){
            distances.put(node,Integer.MAX_VALUE);
            distances.replace(fromCity,0);
        }

        Map<Node,Node> previousCity = new HashMap<>();

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));

        queue.add(new NodeEntry(fromCity,0));

        while(!queue.isEmpty()){
            Node current = queue.remove().node;
            visited.add(current);
            for(Edge edge : current.getEdges()){
                if(visited.contains(edge.to))
                    continue;
                int newDistance = distances.get(current) + edge.weight;
                if(newDistance < distances.get(edge.to)){
                    distances.replace(edge.to, newDistance);
                    previousCity.put(edge.to,current);
                    queue.add(new NodeEntry(edge.to,newDistance));
                }
            }
        }



        return buildPath(previousCity,toCity);

    }

    private Path buildPath(Map<Node,Node> previousCity,Node toCity){
        Stack<Node> stack = new Stack<>();
        stack.push(toCity);
        Node previous = previousCity.get(toCity);
        while(previous != null){
            stack.push(previous);
            previous = previousCity.get(previous);
        }

        Path path = new Path();

        while (!stack.isEmpty()){
            path.add(stack.pop().city);
        }
        return path;
    }

}