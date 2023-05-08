package TTRModel;

import POJOs.City;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private List<City> cities = new ArrayList<>();

    public void add(City city){
        cities.add(city);
    }

    @Override
    public String toString() {
        return cities.toString();
    }
}
