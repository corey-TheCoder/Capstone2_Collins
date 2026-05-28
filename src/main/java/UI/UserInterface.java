package UI;

import enums.BreadType;
import enums.DrinkSize;
import enums.SandwichSize;
import enums.ToppingType;
import org.example.*;


import java.util.Scanner;

public class UserInterface {
    //SCANNER
    private Scanner scanner = new Scanner(System.in);
    private Order currentOrder;
    private ReceiptManager receiptManager;

    public UserInterface() {
        receiptManager = new ReceiptManager();
    }

    //menus
    public void displayHomeScreen() {
        boolean running = true;
        while (running) {
            //show menu
            System.out.println("\nGuild Hall");
            System.out.println("1.) Assemble New Adventurer");
            System.out.println("0.) Leave Hall");
            System.out.println("\nWhat will it be?");
            int choice = scanner.nextInt();
            //int be acting up
            scanner.nextLine();
            switch (choice) {
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

    public void displayOrderScreen() {
        boolean ordering = true;
        while (ordering) {
            //art menu TBD
            Art.displayQuestMenu();

            System.out.println("1.) Forge Character");
            System.out.println("2.) Brew potions");
            System.out.println("3.) Pack Rations");
            System.out.println("4.) Begin Journey");
            System.out.println("0.) Abandon Journey");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
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
                    return;
                default:
                    //input error
                    System.out.println("\n.. too much ale again huh?");
            }
        }
    }

    //sandwich
    public void forgeLoadout() {
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
    public void brewPotions() {
        System.out.println("===Brew Potion==" +
                "\n1.) Small" +
                "\n2.) Medium" +
                "\n3.) Large");
        System.out.println("Choose size: ...");
        int choice = scanner.nextInt();
        scanner.nextLine();
        DrinkSize size;
        switch (choice) {
            case 1:
                size = DrinkSize.SMALL;
                break;
            case 2:
                size = DrinkSize.MEDIUM;
                break;
            case 3:
                size = DrinkSize.LARGE;
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        System.out.println("Choose potion affinity: ");
        String flavor = scanner.nextLine();
        Drink drink = new Drink(flavor, size);
        currentOrder.addItem(drink);
        System.out.println("\nPotion added!");
    }
    //chips
    public void purchaseRations() {
        System.out.println("\nChoose ration type " +
                "\n1.) Chips" +
                "\n2.) Pretzels" +
                "\n3.) Nachos");
        int choice = scanner.nextInt();
        scanner.nextLine();
        String type;
        switch (choice) {
            case 1:
                type = "Chips";
                break;
            case 2:
                type = "Pretzel";
                break;
            case 3:
                type = "Nachos";
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        Chips chips = new Chips(type);
        currentOrder.addItem(chips);
        System.out.println("\nRations successfully added!");
    }
    public void startJourney() {
        System.out.println("\n=== Order Summary ===\n");
        //every item in current order
        for (MenuItems item : currentOrder.getItems()) {
            System.out.println(item);
            System.out.println("===================");
        }
        double total = currentOrder.getOrderTotal();
        System.out.println("\nTotal: $" + total);

        System.out.println("\n1.) Confirm Quest");
        System.out.println("2.) Cancel");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                receiptManager.saveReceipt(currentOrder);
                currentOrder = new Order();
                System.out.println("Quest Confirmed!");
                System.out.println("Returning to Tavern...");
                return;
            case 2:
                currentOrder.clearOrder();
                System.out.println("Quest Cancelled..");
                System.out.println("Returning to Tavern...");
                return;
            default:
                System.out.println("Invalid choice");
        }
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
            System.out.println("===WEAPONS" +
                    "\n1.) Dragon's Slayer" +
                    "\n2.) Iron Longsword" +
                    "\n3.) Twin Daggers" +
                    "\n4.) Elven Bow" +
                    "\n5.) Beserker Axe" +
                    "\n6.) Omnitrix" +
                    "\n0. Back");
            System.out.println("Choose your primary weapon: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    sandwich.addToppings(new Toppings("Dragon's Slayer",
                            ToppingType.MEAT, false
                    ));
                    System.out.println("\nWeapon added!");
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Iron Longsword",
                            ToppingType.MEAT, false));
                    System.out.println("\nWeapon added!");

                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Twin Daggers",
                            ToppingType.MEAT, false));
                    System.out.println("\nWeapon added!");

                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Elven Bow",
                            ToppingType.MEAT, false));
                    System.out.println("\nWeapon added!");
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("Beserker Axe",
                            ToppingType.MEAT, false));
                    System.out.println("\nWeapon added!");

                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Great Hammer",
                            ToppingType.MEAT, false));
                    System.out.println("\nWeapon added!");
                    break;
                default:
                    System.out.println("Returning to Toppings Menu");;
            }
        }

    private void addCheese(Sandwich sandwich){
        System.out.println("\n===SPELLS==" +
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
            System.out.println("\n==== TRAITS ====" +
                    "\n1.) Black Flash" +
                    "\n2.) Titan Shifting" +
                    "\n3.) Flight" +
                    "\n4.) Fire Affinity" +
                    "\n5.) 10 Shadows Technique" +
                    "\n6.) Instant Regeneration" +
                    "\n7.) Shadow Clones" +
                    "\n8.) Infinity" +
                    "\n9.) Amateratsu" +
                    "\n0.) Back");
            System.out.println("Choose your ....");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    sandwich.addToppings(new Toppings("Black Flash",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nTrait added");
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Titan Shifting",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nTrait added");
                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Flight",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nTrait added");
                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Fire Affinity",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nTrait added");
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("10 Shadows Technique",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nTrait added");

                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Instant Regeneration",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nTrait added");
                    break;
                case 7:
                    sandwich.addToppings(new Toppings("Shadow Clones",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nTrait added");
                    break;
                case 8:
                    sandwich.addToppings(new Toppings("Infinity",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nTrait added");
                    break;
                case 9:
                    sandwich.addToppings(new Toppings("Amateratsu",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nTrait added");
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
            System.out.println("\n===Sauces" +
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
                    System.out.println("\n Sauce added");
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Mustard",
                            ToppingType.SAUCE, false));
                    System.out.println("\n Sauce added");
                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Ketchup",
                            ToppingType.SAUCE, false));
                    System.out.println("\n Sauce added");
                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Ranch",
                            ToppingType.SAUCE, false));
                    System.out.println("\n Sauce added");
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("Thousand Island",
                            ToppingType.SAUCE, false));
                    System.out.println("\n Sauce added");
                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Vinaigrette",
                            ToppingType.SAUCE, false));
                    System.out.println("\n Sauce added");
                    break;
                case 0:
                    moreSauce=false;
                    break;
                default:
                    System.out.println("\nInvalid Choice");
            }
        }
    }

}
