import TTRDao.GameRepository;
import TTRServices.ShortestPath;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Program {

    public void startApplication() {
        Scanner sc = new Scanner(System.in);
        String name = getName(sc);
        menuOptions(name);
        int choice = userinput(sc);
        boolean keepRunningchoices = true;


        while (keepRunningchoices){

            switch (choice){
                case 1 :
                    findShortestRouteMenu(sc,name);
                    menuOptions(name,true);
                    choice = userinput(sc);
                    break;
                case 2:
                    choice = errorMessage(sc,name,true);
                    break;
                case 3:
                    choice = errorMessage(sc,name,true);
                    break;
                case 4:
                    keepRunningchoices = false;
                    break;

            }

        }



    }


    private void menuOptions(String name) {
        // Define the menu options
        System.out.println("Welcome, " + name);
        System.out.println("1. Find shortest route\n");
        System.out.println("2. Calculate routes\n");
        System.out.println("3. View best route options\n");
        System.out.println("4. Exit\n");

    }

    private void menuOptions(String name,Boolean loggedIn) {
        // Define the menu options
        System.out.println("Choose again, " + name);
        System.out.println("1. Find shortest route\n");
        System.out.println("2. Calculate routes\n");
        System.out.println("3. View best route options\n");
        System.out.println("4. Exit\n");

    }

    private void findShortestRouteMenu(Scanner sc,String name) {
        ShortestPath shortestPath = new ShortestPath();
        shortestPath.loadRepository(sc,name);
    }

    private void printErrorMessage(){
            System.out.println("\nThooo thooo! Looks like we've hit a bump on the railway!");
            System.out.println("Building an application is a lot like building a railway.");
            System.out.println("We gotta lay the foundation before we can let the train pass.");
            System.out.println("And right now, it looks like you're stuck in out tracks!");
            System.out.println("But don't you worry, we'll get you back on track in no time!");
            System.out.println("For know, make another choice.");
            System.out.println("Oh well. I'll better put on my conductor's hat and get back to work!\n");

        }



    private int userinput(Scanner sc) {
        int input = -1;
        System.out.println("Enter option: ");
        boolean validInput = false;
        do {
            try {
                input = Integer.parseInt(sc.nextLine());
                if (input >= 1 || input <= 4) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
            }
        } while (!validInput);
        return input;
    }


    public String getName(Scanner sc) {
        printTrainHeadingToConsole();
        String name = "";
        System.out.println("Hello Conductor! Nice to see you again.\n" + "I didn't catch your name last time, what was it again?");

        boolean validInput = false;
        do {
            try {
                name = sc.nextLine();
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
            }
        } while (!validInput);

        return name;
    }

    private int errorMessage(Scanner sc, String name, boolean loggedIn){
        printErrorMessage();
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            System.out.println("\n Oh, so you are in a hurry. Very well!\n");
        }
        menuOptions(name, loggedIn);
        int choice = userinput(sc);
        return choice;
    }


    public void printTrainHeadingToConsole(){
        System.out.println(" ___________________________ ");
        System.out.println("|                           |");
        System.out.println("|        Ticket to Ride     |");
        System.out.println("|___________________________|\n");

    }

}
