package main.java.org.ttr.TTRServices;

import main.java.org.ttr.POJOs.City;
import main.java.org.ttr.TTRModel.BinarySearch;
import main.java.org.ttr.TTRRepository.GameRepository;

import java.util.Comparator;
import java.util.List;

public class CityDetails {

    GameRepository gameRepository = new GameRepository();
    BinarySearch binarySearch = new BinarySearch();

    List<City> cities = gameRepository.getCities();


    public City getCity(String cityName){
        cities.sort(Comparator.comparing(City::getCityName));
        int index = binarySearch.binarySearch(cities,cityName,0,cities.size()-1);
        if(index == -1){
            System.out.println("No city found.");
            return null;
        }
        return cities.get(index);
    }

}
