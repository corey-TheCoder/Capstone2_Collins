package UI;

import enums.BreadType;
import enums.SandwichSize;
import enums.ToppingType;
import org.example.*;


import java.util.Scanner;

public class UserInterface {
    //SCANNER
    private Scanner scanner = new Scanner(System.in);
    private Order currentOrder;
    private ReceiptManager receiptManager;

    public UserInterface(){
        receiptManager = new ReceiptManager();
    }
    //menus
    public void displayHomeScreen(){
        boolean running = true;
        while(running){
            //show menu
            System.out.println("\nCharacter builder");
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

            System.out.println("1.) Forge your loadout: (add sandwich)");
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
                    break;
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
        //sandwich characteristics
        BreadType bread = selectBread();
        SandwichSize size = selectSize();
        boolean toasted = selectToasted();
        //creating sandwich
        Sandwich sandwich = new Sandwich(bread, size, toasted);
        //customizing
        selectToppings(sandwich);
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
        System.out.println("\nWould you like to be FORGED in flame? (Y/N)");
        String input = scanner.nextLine();

        return input.equalsIgnoreCase("Y");
    }
    private void selectToppings(Sandwich sandwich){
        boolean addToppings = true;

        while(addToppings){
            System.out.println("\n===Main Menu===" +
                    "\n1.) Rare Enhancements(Meat)" +
                    "\n2.) Arcane Infusions(Cheese) " +
                    "\n3.) Traits(Regular Toppings)" +
                    "\n4.) Enhancements(Sauces)"+
                    "\n0.) Back");
            System.out.println("Where would you like to begin: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    addMeats(sandwich);
                    break;
                case 2:
                    addCheese(sandwich);
                    break;
                case 3:
                    addRegularToppings(sandwich);
                    break;
                case 4:
                    addSauces(sandwich);
                    break;
                case 0:
                    addToppings=false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void addMeats(Sandwich sandwich) {
            System.out.println("===Meat Menu" +
                    "\n1.) Dragon's Heart (Steak)" +
                    "\n2.) Smoked Boar (Ham)" +
                    "\n3.) Phoenix Beak(Salami)" +
                    "\n4.) Rabbit's Tail(Roast Beef" +
                    "\n5.) Griffin Claw(Chicken)" +
                    "\n6.) Raven Feathers(Bacon)" +
                    "\n0. Back");
            System.out.println("Choose your rare enhancements: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    sandwich.addToppings(new Toppings("Dragon's Heart",
                            ToppingType.MEAT, false
                    ));
                    System.out.println("Rare Enhancement received");
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Smoked Boar",
                            ToppingType.MEAT, false));
                    System.out.println("Rare Enhancement received");

                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Phoenix Beak",
                            ToppingType.MEAT, false));
                    System.out.println("Rare Enhancement received");

                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Rabbit's Tail",
                            ToppingType.MEAT, false));
                    System.out.println("Rare Enhancement received");
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("Griffin Claw",
                            ToppingType.MEAT, false));
                    System.out.println("Rare Enhancement received");

                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Raven Feathers",
                            ToppingType.MEAT, false));
                    System.out.println("\nRare Enhancement received");
                    break;
                default:
                    System.out.println("Returning to Toppings Menu");;
            }
        }

    private void addCheese(Sandwich sandwich){
        System.out.println("===Cheese Menu==" +
                "\n1.) Flame, Grant Me Strength" +
                "\n2.) Golden Vow" +
                "\n3.) Blessings of the Erdtree" +
                "\n4.) Black Flame's Protection");
        System.out.println("Choose your incantation carefully. As this will be your main source " +
                "of magic protection");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:
                sandwich.addToppings(new Toppings("Flame, Grant Me Strength",
                        ToppingType.CHEESE, false));
                System.out.println("\nBlessing added!");
                break;
            case 2:
                sandwich.addToppings(new Toppings("Golden Vow",
                        ToppingType.CHEESE, false));
                System.out.println("\nBlessing added!");
                break;
            case 3:
                sandwich.addToppings(new Toppings("Blessing of the Erdtree",
                        ToppingType.CHEESE, false));
                System.out.println("\nBlessing added!");
                break;
            case 4:
                sandwich.addToppings(new Toppings("Black Flame's Protection",
                        ToppingType.CHEESE, false));
                System.out.println("\nBlessing added!");
                break;
            default:
                return;
        }
    }
    public void addRegularToppings(Sandwich sandwich){
        boolean moreToppings = true;
        while (moreToppings) {
            System.out.println("==== Reg Toppings ====" +
                    "\n1.) Lettuce" +
                    "\n2.) Peppers" +
                    "\n3.) Onions" +
                    "\n4.) Tomatoes" +
                    "\n5.) Jalapenos" +
                    "\n6.) Cucumbers" +
                    "\n7.) Pickles" +
                    "\n8.) Guacamole" +
                    "\n9.) Mushrooms" +
                    "\n0.) Back");
            System.out.println("Choose your ....");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    sandwich.addToppings(new Toppings("Lettuce",
                            ToppingType.OTHER_TOPPINGS, false));
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Peppers",
                            ToppingType.OTHER_TOPPINGS, false));
                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Onions",
                            ToppingType.OTHER_TOPPINGS, false));
                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Tomatoes",
                            ToppingType.OTHER_TOPPINGS, false));
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("Jalapenos",
                            ToppingType.OTHER_TOPPINGS, false));
                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Cucumbers",
                            ToppingType.OTHER_TOPPINGS, false));
                    break;
                case 7:
                    sandwich.addToppings(new Toppings("Pickles",
                            ToppingType.OTHER_TOPPINGS, false));
                    break;
                case 8:
                    sandwich.addToppings(new Toppings("Guacamole",
                            ToppingType.OTHER_TOPPINGS, false));
                    break;
                case 9:
                    sandwich.addToppings(new Toppings("Mushrooms",
                            ToppingType.OTHER_TOPPINGS, false));
                    break;
                case 0:
                    moreToppings=false;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    //
    public void addSauces(Sandwich sandwich) {
        boolean moreSauce=true;
        while(moreSauce) {
            System.out.println("===Sauces" +
                    "\n1.) Mayo" +
                    "\n2.) Mustard" +
                    "\n3.) Ketchup" +
                    "\n4.) Ranch" +
                    "\n5.) Thousand Island" +
                    "\n6.) Vinaigrette" +
                    "\n0.) Back");
            System.out.println("\nChoose your....");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    sandwich.addToppings(new Toppings("Mayo",
                            ToppingType.SAUCE, false));
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Mustard",
                            ToppingType.SAUCE, false));
                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Ketchup",
                            ToppingType.SAUCE, false));
                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Ranch",
                            ToppingType.SAUCE, false));
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("Thousand Island",
                            ToppingType.SAUCE, false));
                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Vinaigrette",
                            ToppingType.SAUCE, false));
                    break;
                case 0:
                    moreSauce=false;
                    break;
                default:
                    System.out.println("\nSauce added!");
            }
        }
    }
    //potions
    public void addDrink(){
        System.out.println("===Brew Potion==" +
                "\n1.) Small" +
                "\n2.) Medium" +
                "\n3.) Large");
        System.out.println("Choose size: ...");
        int choice = scanner.nextInt();
        scanner.nextLine();
        String size = "";
        switch (choice){
            case 1:
                size ="small";
                break;
            case 2:
                size = "medium";
                break;
            case 3:
                size = "large";
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        System.out.println("Choose potion affinity: ");
        String affinity = scanner.nextLine();
        Drink drink = new Drink(affinity, size);
        currentOrder.addItem(drink);
        System.out.println("Potion added!");
    }
    //rations
    public void addChips(){
        System.out.println("\nChoose ration type");
        String rationType = scanner.nextLine();
        Chips chip = new Chips(rationType);
        currentOrder.addItem(chip);
        System.out.println("Rations successfully added");
    }

}
