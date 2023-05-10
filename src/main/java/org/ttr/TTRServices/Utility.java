package main.java.org.ttr.TTRServices;

import main.java.org.ttr.POJOs.City;

import java.util.List;
import java.util.Scanner;
public class Utility {

    /**
     * @return An array of two Strings, where the first String is the departure city and the second String is the arrival city.
     */

    public static String[] promptDepartureAndArrivalCity(Scanner sc,List<City> cities){

        String[] cityNames = new String[2];

        String departureStation = "";
        String arrivalStation = "";
        boolean foundDepartureStation = false;
        boolean foundArrivalStation = false;

        while (!foundDepartureStation) {
                System.out.println("\nEnter your station of departure: \n");
                departureStation = sc.nextLine();
                departureStation = capitalizeString(departureStation);
                foundDepartureStation = validateInput(departureStation,cities);
            if(!foundDepartureStation){
                System.out.println("Found no such city. Try again.");
            }
        }

        while (!foundArrivalStation) {
            System.out.println("\nEnter your station of arrival: \n");
            arrivalStation = sc.nextLine();
            arrivalStation = capitalizeString(arrivalStation);
            foundArrivalStation = validateInput(arrivalStation,cities);
            if(!foundArrivalStation){
                System.out.println("Found no such city. Try again.");
            }
        }

        cityNames[0] = departureStation;
        cityNames[1] = arrivalStation;

        return cityNames;


    }

    /**
     * @return true/false based on if a city Object is found with the provided City Name
     */
    public static boolean validateInput(String cityName, List<City> cities){
        for(City city : cities){
            if(city.getCityName().equals(cityName)){
                return true;
            }

        }
        return false;
    }

    /**
     * @return a capitalizedString. new york -> New York
     */
    private static String capitalizeString(String stringToBeCapitalized){
        String words[]=stringToBeCapitalized.split("\\s");
        String capitalizeWord="";
        for(String word : words){
            String first = word.substring(0,1);
            String afterfirst=word.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";
        }
        return capitalizeWord.trim();
    }

}
