package UI;

import java.util.Scanner;

public class UserInterface {
    //SCANNER
    private Scanner scanner = new Scanner(System.in);
    //userInput(s)
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
                    displayOrderScreen();
                case 0:
                    running = false;
                    System.out.println("\nThis journey is not for you, safe travels!");
                    break;
                default:
                    System.out.println("You must have had too much ale, try again!");
            }
        }
    }

    public void displayOrderScreen(){
        boolean ordering = true;
        while(ordering){
            //art menu TBD
            Art.displayQuestMenu();

            System.out.println("1. Forge your loadout: (add sandwich)");
            System.out.println("2.) Brew potions (add drinks)");
            System.out.println("3.) Purchase Rations (add chips)");
            System.out.println("4.) Start journey (checkout");
            System.out.println("0. Abandon destiny (cancel order)");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    forgeLoadout();
                    break;
                case 2:
                    brewPotions();
                    break;
                case 3:
                    purchaseRations();
                    break;
                case 4:
                    startJourney();
                    break;
                case 0:
                    System.out.println("\nDestiny has yet to call this one..");
                default:
                    System.out.println("\n.. too much ale again huh?");
            }
        }
    }
    //sandwich
    public void forgeLoadout(){
        System.out.println("\nForge Adventurer Loadout (sandwich)");
        System.out.println("tbd.....");
    }
    //drinks
    public void brewPotions(){
        System.out.println("\nBrew Potions");
        System.out.println("tbd...");
    }
    //chips
    public void purchaseRations(){
        System.out.println("\nPack Rations");
        System.out.println("tbd...");
    }
    public void startJourney(){
        System.out.println("\nBegin Quest");
        System.out.println("tbd...");
    }
}
