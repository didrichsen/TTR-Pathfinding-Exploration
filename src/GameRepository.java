import java.util.*;

public class GameRepository {


/*
    public GameRepository() {
        cities = Arrays.asList(
                createCity("New York", "Boston", "Montreal", "Pittsburgh","Washington"),

                createCity("Montreal", "New York", "Boston", "Toronto","Sault St. Marie"),

                createCity("Toronto", "Montreal", "Pittsburgh", "Chicago","Sault St. Marie","Duluth"),

                createCity("Pittsburgh", "New York", "Toronto", "Chicago", "Washington","Raleigh","Nashville","Saint Louis"),

                createCity("Boston", "New York", "Montreal"),

                createCity("Chicago", "Pittsburgh", "Toronto", "Saint Louis", "Omaha","Duluth"),

                createCity("Saint Louis", "Chicago", "Nashville", "Little Rock", "Kansas City","Pittsburgh"),

                createCity("Little Rock", "Saint Louis", "Nashville", "Dallas", "Oklahoma City","New Orleans"),

                createCity("Nashville", "Saint Louis", "Little Rock", "Atlanta", "Raleigh","Pittsburgh"),

                createCity("Raleigh", "Nashville", "Atlanta", "Charleston", "Washington","Pittsburgh"),

                createCity("Washington", "Pittsburgh", "Raleigh", "New York"),

                createCity("Charleston", "Raleigh", "Atlanta", "Miami"),

                createCity("Miami", "Charleston", "Atlanta", "New Orleans"),

                createCity("Atlanta", "Nashville", "Miami", "New Orleans", "Raleigh","Charleston"),

                createCity("Houston", "Dallas", "El Paso", "New Orleans"),

                createCity("Dallas", "Houston", "El Paso", "Oklahoma City"),

                createCity("El Paso", "Los Angeles", "Phoenix", "Santa Fe", "Dallas", "Houston","Oklahoma City"),

                createCity("Oklahoma City", "Denver", "Kansas City", "Dallas", "Little Rock","Santa Fe"),

                createCity("Denver", "Salt Lake City", "Kansas City", "Oklahoma City", "Helena","Phoenix","Santa Fe","Omaha"),

                createCity("Kansas City", "Omaha", "Denver", "Oklahoma City", "Saint Louis"),

                createCity("Omaha", "Chicago", "Saint Louis", "Kansas City", "Denver","Helena","Duluth"),

                createCity("Helena", "Seattle", "Calgary", "Winnipeg", "Denver","Omaha","Duluth"),

                createCity("Seattle", "Vancouver", "Calgary", "Helena", "Portland"),

                createCity("Vancouver", "Seattle", "Calgary"),

                createCity("Calgary", "Vancouver", "Seattle", "Helena", "Winnipeg"),

                createCity("Winnipeg", "Helena", "Calgary", "Sault St. Marie", "Duluth"),

                createCity("Sault St. Marie", "Winnipeg", "Toronto", "Montreal","Duluth"),

                createCity("Portland", "Seattle", "San Francisco", "Salt Lake City"),

                createCity("San Francisco", "Portland", "Los Angeles", "Salt Lake City"),

                createCity("Los Angeles", "San Francisco", "Las Vegas", "Phoenix", "El Paso"),

                createCity("Las Vegas", "Los Angeles", "Salt Lake City"),

                createCity("Phoenix", "Los Angeles","Denver", "Santa Fe", "El Paso"),

                createCity("Santa Fe", "Phoenix","El Paso", "Denver", "Oklahoma City"),
                createCity("Salt Lake City", "Phoenix","El Paso", "Denver", "Oklahoma City"),
                createCity("Duluth", "Winnipeg","Sault St. Marie", "Toronto", "Chicago","Omaha","Helena"));
    }


/*
    public GameRepository() {
        cities = Arrays.asList(
                createCity("New York", "Montreal"),
                createCity("Montreal", "New York"));
    }

 */


        private City createCity(String name, String... neighborNames) {
            List<City> neighbors = new ArrayList<>();
            for (String neighborName : neighborNames) {
                neighbors.add(new City(neighborName));
            }
            return new City(name, neighbors);
        }


    public void loadRepository(Scanner sc, String name){
        City newYork = new City("New York");
        City boston = new City("Boston");
        City montreal = new City("Montreal");
        City toronto = new City("Toronto");
        City pittsburgh = new City("Pittsburgh");
        City washington = new City("Washington");
        City raleigh = new City("Raleigh");
        City charleston = new City("Charleston");
        City miami = new City("Miami");
        City atlanta = new City("Atlanta");
        City newOrleans = new City("New Orleans");
        City nashville = new City("Nashville");
        City saintLouis = new City("Saint Louis");
        City chicago = new City("Chicago");
        City saultStMarie = new City("Sault St. Marie");
        City duluth = new City("Duluth");
        City omaha = new City("Omaha");
        City kansasCity = new City("Kansas City");
        City oklahomaCity = new City("Oklahoma City");
        City dallas = new City("Dallas");
        City houston = new City("Houston");
        City elPaso = new City("El Paso");
        City santaFe = new City("Santa Fe");
        City denver = new City("Denver");
        City helena = new City("Helena");
        City winnipeg = new City("Winnipeg");
        City calGary = new City("Calgary");
        City vancouver = new City("Vancouver");
        City seattle = new City("Seattle");
        City portland = new City("Portland");
        City saltLakeCity = new City("Salt Lake City");
        City lasVegas = new City("Las Vegas");
        City losAngeles = new City("Los Angeles");
        City phoenix = new City("Phoenix");
        City sanFrancisco = new City("San Francisco");
        City littleRock = new City("Little Rock");



        City[] cities = {
                new City("New York"),
                new City("Boston"),
                new City("Montreal"),
                new City("Toronto"),
                new City("Pittsburgh"),
                new City("Washington"),
                new City("Raleigh"),
                new City("Charleston"),
                new City("Miami"),
                new City("Atlanta"),
                new City("New Orleans"),
                new City("Nashville"),
                new City("Saint Louis"),
                new City("Chicago"),
                new City("Sault St. Marie"),
                new City("Duluth"),
                new City("Omaha"),
                new City("Kansas City"),
                new City("Oklahoma City"),
                new City("Dallas"),
                new City("Houston"),
                new City("El Paso"),
                new City("Santa Fe"),
                new City("Denver"),
                new City("Helena"),
                new City("Winnipeg"),
                new City("Calgary"),
                new City("Vancouver"),
                new City("Seattle"),
                new City("Portland"),
                new City("Salt Lake City"),
                new City("Las Vegas"),
                new City("Los Angeles"),
                new City("Phoenix"),
                new City("San Francisco"),
                new City("Little Rock")
        };



        Graph cityGraph = new Graph();

        for (City city : cities) {
            cityGraph.addNode(city);
        }



        cityGraph.addEdgeWithWeight(newYork,boston,2);
        cityGraph.addEdgeWithWeight(newYork,pittsburgh,2);
        cityGraph.addEdgeWithWeight(pittsburgh,toronto,2);
        cityGraph.addEdgeWithWeight(toronto,montreal,3);
        cityGraph.addEdgeWithWeight(montreal,newYork,3);
        cityGraph.addEdgeWithWeight(boston,montreal,2);
        cityGraph.addEdgeWithWeight(newYork,washington,2);
        cityGraph.addEdgeWithWeight(pittsburgh,washington,2);
        cityGraph.addEdgeWithWeight(washington,raleigh,2);
        cityGraph.addEdgeWithWeight(pittsburgh,raleigh,2);
        cityGraph.addEdgeWithWeight(raleigh,charleston,2);
        cityGraph.addEdgeWithWeight(charleston,miami,4);
        cityGraph.addEdgeWithWeight(raleigh,atlanta,2);
        cityGraph.addEdgeWithWeight(atlanta,charleston,2);
        cityGraph.addEdgeWithWeight(miami,atlanta,5);
        cityGraph.addEdgeWithWeight(atlanta,nashville,1);
        cityGraph.addEdgeWithWeight(nashville,raleigh,3);
        cityGraph.addEdgeWithWeight(nashville,pittsburgh,4);
        cityGraph.addEdgeWithWeight(montreal,saultStMarie,5);
        cityGraph.addEdgeWithWeight(toronto,saultStMarie,2);
        cityGraph.addEdgeWithWeight(toronto,duluth,6);
        cityGraph.addEdgeWithWeight(toronto,chicago,4);
        cityGraph.addEdgeWithWeight(pittsburgh,chicago,3);
        cityGraph.addEdgeWithWeight(pittsburgh,saintLouis,5);
        cityGraph.addEdgeWithWeight(miami,newOrleans,6);
        cityGraph.addEdgeWithWeight(atlanta,newOrleans,4);
        cityGraph.addEdgeWithWeight(nashville,saintLouis,2);
        cityGraph.addEdgeWithWeight(saintLouis,chicago,2);
        cityGraph.addEdgeWithWeight(nashville,littleRock,3);
        cityGraph.addEdgeWithWeight(newOrleans,houston,2);
        cityGraph.addEdgeWithWeight(newOrleans,littleRock,3);
        cityGraph.addEdgeWithWeight(littleRock,saintLouis,2);
        cityGraph.addEdgeWithWeight(houston,dallas,1);
        cityGraph.addEdgeWithWeight(dallas,littleRock,2);
        cityGraph.addEdgeWithWeight(dallas,oklahomaCity,2);
        cityGraph.addEdgeWithWeight(oklahomaCity,kansasCity,2);
        cityGraph.addEdgeWithWeight(oklahomaCity,littleRock,2);
        cityGraph.addEdgeWithWeight(kansasCity,saintLouis,2);
        cityGraph.addEdgeWithWeight(kansasCity,omaha,1);
        cityGraph.addEdgeWithWeight(omaha,chicago,4);
        cityGraph.addEdgeWithWeight(chicago,duluth,3);
        cityGraph.addEdgeWithWeight(duluth,saultStMarie,3);
        cityGraph.addEdgeWithWeight(omaha,duluth,2);
        cityGraph.addEdgeWithWeight(saultStMarie,winnipeg,6);
        cityGraph.addEdgeWithWeight(duluth,winnipeg,4);
        cityGraph.addEdgeWithWeight(duluth,helena,6);
        cityGraph.addEdgeWithWeight(omaha,helena,5);
        cityGraph.addEdgeWithWeight(omaha,denver,4);
        cityGraph.addEdgeWithWeight(kansasCity,denver,4);
        cityGraph.addEdgeWithWeight(oklahomaCity,denver,4);
        cityGraph.addEdgeWithWeight(oklahomaCity,santaFe,3);
        cityGraph.addEdgeWithWeight(oklahomaCity,elPaso,5);
        cityGraph.addEdgeWithWeight(dallas,elPaso,4);
        cityGraph.addEdgeWithWeight(houston,elPaso,6);
        cityGraph.addEdgeWithWeight(elPaso,santaFe,2);
        cityGraph.addEdgeWithWeight(santaFe,denver,2);
        cityGraph.addEdgeWithWeight(denver,helena,4);
        cityGraph.addEdgeWithWeight(helena,calGary,4);
        cityGraph.addEdgeWithWeight(winnipeg,calGary,6);
        cityGraph.addEdgeWithWeight(winnipeg,helena,4);
        cityGraph.addEdgeWithWeight(calGary,vancouver,3);
        cityGraph.addEdgeWithWeight(calGary,seattle,4);
        cityGraph.addEdgeWithWeight(helena,seattle,6);
        cityGraph.addEdgeWithWeight(seattle,portland,1);
        cityGraph.addEdgeWithWeight(seattle,vancouver,1);
        cityGraph.addEdgeWithWeight(portland,saltLakeCity,6);
        cityGraph.addEdgeWithWeight(saltLakeCity,lasVegas,3);
        cityGraph.addEdgeWithWeight(lasVegas,losAngeles,2);
        cityGraph.addEdgeWithWeight(denver,saltLakeCity,3);
        cityGraph.addEdgeWithWeight(saltLakeCity,helena,3);
        cityGraph.addEdgeWithWeight(saltLakeCity,sanFrancisco,5);
        cityGraph.addEdgeWithWeight(sanFrancisco,losAngeles,3);
        cityGraph.addEdgeWithWeight(losAngeles,phoenix,3);
        cityGraph.addEdgeWithWeight(phoenix,denver,5);
        cityGraph.addEdgeWithWeight(phoenix,santaFe,3);
        cityGraph.addEdgeWithWeight(phoenix,elPaso,3);
        cityGraph.addEdgeWithWeight(elPaso,losAngeles,6);
        cityGraph.addEdgeWithWeight(sanFrancisco,portland,5);

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

    boolean validateInput(String cityName,City[] cities){
            for(City city : cities){
                if(city.getCityName().equalsIgnoreCase(cityName)){
                    return true;
                }

            }

            return false;
    }

}