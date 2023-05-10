package main.java.org.ttr.TTRRepository;

import main.java.org.ttr.POJOs.City;
import main.java.org.ttr.POJOs.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class GameRepository extends JDBCops {

    public List<City> getCities(){

        List<City> result = new ArrayList<>();

        String preparedSelect = "SELECT * FROM city";

        try (Connection con = getConnection()) {

            con.setAutoCommit(false);

            PreparedStatement prep = con.prepareStatement(preparedSelect);

            ResultSet resultSet = prep.executeQuery();

            while(resultSet.next()){
                String cityName = resultSet.getString("city_name");

                City newCity = new City(cityName);

                result.add(newCity);
            }

            con.commit();


        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return result;
    }
    public List<Route> getRoutes(){
        List<Route> result = new ArrayList<>();

        String preparedSelect = "" +
                "SELECT c1.city_name AS departure_city, c2.city_name AS arrival_city,r.cards_needed AS price FROM city c1 " +
                "JOIN route r ON c1.id = r.departure_city " +
                "JOIN city c2 ON r.arrival_city = c2.id";

        try (Connection con = getConnection()) {

            con.setAutoCommit(false);

            PreparedStatement prep = con.prepareStatement(preparedSelect);

            ResultSet resultSet = prep.executeQuery();

            while(resultSet.next()){
                String cityDeparture = resultSet.getString("departure_city");
                String cityArrival = resultSet.getString("arrival_city");
                int price = resultSet.getInt("price");

                City newDepartureCity = new City(cityDeparture);
                City newArrivalCity = new City(cityArrival);

                Route newRoute = new Route(newDepartureCity,newArrivalCity,price);

                result.add(newRoute);
            }

            con.commit();


        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return result;
    }




}
