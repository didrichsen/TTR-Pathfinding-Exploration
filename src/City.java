import java.util.Arrays;
import java.util.List;

public class City {

    private String cityName;
    private List<City> neighbours;


    public City(String cityName, List<City> neighbour) {
        this.cityName = cityName;
        this.neighbours = neighbour;
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

    public List<City> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<City> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public String toString() {
        return cityName;
    }
}
