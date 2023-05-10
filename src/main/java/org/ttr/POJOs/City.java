package main.java.org.ttr.POJOs;

import java.util.List;

public class City {

    private String cityName;
    private List<Route> routes;


    public City(String cityName, List<Route> routes) {
        this.cityName = cityName;
        this.routes = routes;
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Route> getNeighbours() {
        return routes;
    }

    public void setNeighbours(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return cityName;
    }
}
