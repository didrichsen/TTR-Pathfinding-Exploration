package main.java.org.ttr.TTRModel;

import main.java.org.ttr.POJOs.City;
import java.util.List;

public class BinarySearch {


    public int binarySearch(List<City> cities, String cityName, int low, int high){

        if(low > high) return -1;

        int mid = (low + high) / 2;

        int indexToCompare = cityName.compareTo(cities.get(mid).getCityName());

        if(indexToCompare == 0){
            return mid;
        } else if(indexToCompare < 0){
            return binarySearch(cities,cityName,0,mid-1);
        } else {
            return binarySearch(cities,cityName,mid+1,high);
        }
    }
}
