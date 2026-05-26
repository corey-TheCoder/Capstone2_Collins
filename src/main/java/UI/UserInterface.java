package UI;

import enums.BreadType;
import enums.SandwichSize;
import enums.ToppingType;
import org.example.Order;
import org.example.Sandwich;
import org.example.Toppings;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class UserInterface {
    //SCANNER
    private Scanner scanner = new Scanner(System.in);
    private Order currentOrder;
    //userInput(s)
    //menus
    public void displayHomeScreen(){
        boolean running = true;
        while(running){
            //show menu
            System.out.println("Character builder");
            System.out.println("1.) Start a new Quest!");
            System.out.println("0.) Leave Tavern (Exit)");
            System.out.println("\nWhat will it be?");
            int choice = scanner.nextInt();
            //int be acting up
            scanner.nextLine();
            switch(choice){
                case 1:
                    currentOrder = new Order();
                    displayOrderScreen();
                    break;
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
            System.out.println("What will it be?");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    //add sandwich
                    forgeLoadout();
                    break;
                case 2:
                    //add drink
                    brewPotions();
                    break;
                case 3:
                    //add chips
                    purchaseRations();
                    break;
                case 4:
                    //checkout
                    startJourney();
                    break;
                case 0:
                    System.out.println("\nDestiny has yet to call this one..");
                default:
                    //input error
                    System.out.println("\n.. too much ale again huh?");
            }
        }
    }
    //sandwich
    public void forgeLoadout(){
        System.out.println("\nForge Adventurer Loadout (sandwich)");
        System.out.println("tbd.....");
        BreadType bread = selectBread();
        SandwichSize size = selectSize();
        boolean toasted = selectToasted();
        Sandwich sandwich = new Sandwich(bread, size, toasted);
        currentOrder.addItem(sandwich);
        System.out.println("\nLoadout added to Quest!!");
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

    //return breadType
    private BreadType selectBread(){
        System.out.println("\nChoose your class build!");
        BreadType[] archetypes = BreadType.values();
        for (int i = 0; i < archetypes.length; i++){
            System.out.println((i+1) + ". " + archetypes[i]);
        }
        System.out.println("\nChoice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        return archetypes[choice - 1];
    }
    //return difficulty
    private SandwichSize selectSize(){
        System.out.println("\nChoose your rank!");
        SandwichSize[] rank = SandwichSize.values();
        for (int i = 0; i < rank.length;i++){
            System.out.println((i + 1) + ". " + rank[i]);
        }
        System.out.println("\nChoice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        return rank[choice -1];
    }
    //Forged in flame
    private boolean selectToasted(){
        System.out.println("\nWould you like to be FORGED in flame? (Y/N");
        String input = scanner.nextLine();

        return input.equalsIgnoreCase("Y");
    }
    private void selectToppings(Sandwich sandwich){
        boolean addToppings = true;

        while(addToppings){
            System.out.println("Rare Enhancements" +
                    "\n1.) Dragon's Heart" +
                    "\n2.) Smoked Boar" +
                    "\n3.) Phoenix Beak" +
                    "\n4.) Rabbit's Tail"+
                    "\n5.) Griffin Claw"+
                    "\n6.) Raven Feathers");
            System.out.println("Choose your rare enhancements: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    sandwich.addToppings(new Toppings("Dragon's Heart",
                            ToppingType.MEAT,false
                    ));
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Smoked Boar",
                            ToppingType.MEAT,false));
                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Phoenix Beak",
                            ToppingType.MEAT,false));
                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Rabbit's Tail",
                            ToppingType.MEAT,false));
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("Griffin Claw",
                            ToppingType.MEAT,false));
                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Raven Feathers",
                            ToppingType.MEAT,false));
                    break;
                case 0:
                    addToppings=false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}
