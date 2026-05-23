package UI;

import java.util.Scanner;

public class UserInterface {
    //SCANNER
    private Scanner scanner = new Scanner(System.in);
    //userInput
    //menus
    public void displayHomeScreen(){
        boolean running = true;
        while(running){
            //show menu
            System.out.println("Character builder");
            System.out.println("1.) Start a new adventure!");
            System.out.println("0.) Leave Tavern");
            System.out.println("\nWhat will it be?");
            int choice = scanner.nextInt();
            //int be acting up
            scanner.nextLine();
            switch(choice){
                case 1:
                    displayHomeScreen();
                case 0:
                    running = false;
                    System.out.println("\nThis journey is not for you, safe travels!");
                    break;
                default:
                    System.out.println("You must have had too much ale, try again!");
            }
        }
    }
}
