package UI;

import enums.*;
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
            System.out.println("1.) Assemble a New Adventurer");
            System.out.println("0.) Leave Hall");
            System.out.println("\nWhat will it be⚔\uFE0F?");
            int choice = getIntInput();
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
            System.out.println("5.) Signature Builds");
            System.out.println("0.) Abandon Journey");
            int choice = getIntInput();
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
                    return;
                case 5:
                    //custom-builds
                    displayCustomBuilds();
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
                "\n1.) Minor" +
                "\n2.) Greater" +
                "\n3.) Legendary");
        System.out.println("Choose size: ");
        int choice = getIntInput();
        DrinkSize size;
        switch (choice) {
            case 1:
                size = DrinkSize.Minor;
                break;
            case 2:
                size = DrinkSize.Greater;
                break;
            case 3:
                size = DrinkSize.Legendary;
                break;
            default:
                System.out.println("\nInvalid size choice");
                return;
        }
        //affinity
        System.out.println("1.) Mana");
        System.out.println("2.) Health");
        System.out.println("3.) Stamina");
        System.out.println("4.) Poison");
        System.out.println("5.) Frost");
        System.out.println("6.) Lightning");
        System.out.println("\nChoose potion affinity: ");
        int affinityChoice = getIntInput();
        Affinity affinity;
        switch (affinityChoice) {
            case 1:
                affinity = Affinity.Mana;
                break;
            case 2:
                affinity = Affinity.Health;
                break;
            case 3:
                affinity = Affinity.Stamina;
                break;
            case 4:
                affinity = Affinity.Poison;
                break;
            case 5:
                affinity = Affinity.Frost;
                break;
            case 6:
                affinity = Affinity.Lightning;
                break;
            default:
                System.out.println("\nInvalid affinity choice");
                return;
        }
        Drink drink = new Drink(affinity, size);
        currentOrder.addItem(drink);
        System.out.println("\nPotion added!");
    }
    //chips
    public void purchaseRations() {
        System.out.println("\nChoose ration type " +
                "\n1.) Rumble Ball" +
                "\n2.) Devil Fruit(Random)" +
                "\n3.) Sukana's Fingers(3)");
        int choice = getIntInput();
        String type;
        switch (choice) {
            case 1:
                type = "Rumble Ball";
                break;
            case 2:
                type = "Devil Fruit";
                break;
            case 3:
                type = "Sukana's Fingers(3)";
                break;
            default:
                System.out.println("\nInvalid Ration choice");
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
        int choice = getIntInput();
        switch (choice) {
            case 1:
                receiptManager.saveReceipt(currentOrder);
                currentOrder = new Order();
                System.out.println("Quest Confirmed!");
                System.out.println("Returning to Tavern...");
                return;
            case 2:
                currentOrder.clearOrder();
                currentOrder = new Order();
                System.out.println("Quest Cancelled..");
                System.out.println("Returning to Tavern...");
                return;
            default:
                System.out.println("Maybe you're confused, try again!");
        }
    }
    //return breadType
    private BreadType selectBread(){
        System.out.println("\n\uD83E\uDEB6Choose your class build!\uD83E\uDEB6");
        BreadType[] archetypes = BreadType.values();
        for (int i = 0; i < archetypes.length; i++){
            System.out.println((i+1) + ". " + archetypes[i]);
        }
        System.out.println("\nChoice: ");
        int choice = getIntInput();
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
        int choice = getIntInput();
        return rank[choice -1];
    }
    //Forged in flame
    private boolean selectToasted(){
        while(true) {
            System.out.println("\n\uD83D\uDD25Would you like to be FORGED in flame? (Y/N)\uD83D\uDD25");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("\nInvalid Choice, please enter Y or N.");
            }
        }
    }
    private void selectToppings(Sandwich sandwich){
        boolean addToppings = true;

        while(addToppings){
            Art.selectToppingsDisplay();
            System.out.println(
                    "\n1.) Weapons Cache\uD83D\uDD31" +
                    "\n2.) Spells✨" +
                    "\n3.) Abilities⚗\uFE0F" +
                    "\n4.) Traits\uD83D\uDD2E"+
                    "\n0.) Back");
            System.out.println("Where would you like to begin: ");
            int choice = getIntInput();
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
                    return;
            }
        }
    }

    private void addMeats(Sandwich sandwich) {
            System.out.println("===WEAPONS" +
                    "\n1.) Dragon's Slayer\uD83D\uDC09" +
                    "\n2.) Iron Longsword⚔\uFE0F" +
                    "\n3.) Twin Daggers\uD83D\uDDE1\uFE0F" +
                    "\n4.) Elven Bow\uD83C\uDFF9" +
                    "\n5.) Beserker Axe\uD83E\uDE93" +
                    "\n6.) Omnitrix\uD83D\uDC41\uFE0F" +
                    "\n0. Back");
            System.out.println("Choose your primary weapon: ");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    sandwich.addToppings(new Toppings("Dragon's Slayer\uD83D\uDC09",
                            ToppingType.MEAT, false
                    ));
                    System.out.println("\nWeapon added!");
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Iron Longsword⚔\uFE0F",
                            ToppingType.MEAT, false));
                    System.out.println("\nWeapon added!");

                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Twin Daggers\uD83D\uDDE1\uFE0F",
                            ToppingType.MEAT, false));
                    System.out.println("\nWeapon added!");

                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Elven Bow\uD83C\uDFF9",
                            ToppingType.MEAT, false));
                    System.out.println("\nWeapon added!");
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("Beserker Axe\uD83E\uDE93",
                            ToppingType.MEAT, false));
                    System.out.println("\nWeapon added!");

                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Omnitrix\uD83D\uDC41\uFE0F",
                            ToppingType.MEAT, false));
                    System.out.println("\nWeapon added!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid Weapon choice");;
            }
        }

    private void addCheese(Sandwich sandwich){
        System.out.println("\n===Blessings==" +
                "\n1.) Flame, Grant Me Strength\uD83D\uDD25" +
                "\n2.) Golden Vow\uD83C\uDF19" +
                "\n3.) Blessings of the Erdtree\uD83C\uDF11" +
                "\n4.) Black Flame's Protection\uD83D\uDD2E");
        System.out.println("Choose your incantation carefully. As this will be your main source " +
                "of magic protection");
        int choice = getIntInput();
        switch (choice){
            case 1:
                sandwich.addToppings(new Toppings("Flame, Grant Me Strength\uD83D\uDD25",
                        ToppingType.CHEESE, false));
                System.out.println("\nBlessing added!");
                break;
            case 2:
                sandwich.addToppings(new Toppings("Golden Vow\uD83C\uDF19",
                        ToppingType.CHEESE, false));
                System.out.println("\nBlessing added!");
                break;
            case 3:
                sandwich.addToppings(new Toppings("Blessing of the Erdtree\uD83C\uDF11",
                        ToppingType.CHEESE, false));
                System.out.println("\nBlessing added!");
                break;
            case 4:
                sandwich.addToppings(new Toppings("Black Flame's Protection\uD83D\uDD2E",
                        ToppingType.CHEESE, false));
                System.out.println("\nBlessing added!");
                break;
            default:
                System.out.println("Invalid Blessing choice");
        }
    }
    public void addRegularToppings(Sandwich sandwich){
        boolean moreToppings = true;
        while (moreToppings) {
            System.out.println("\n==== Abilities ====" +
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
            System.out.println("Choose your key abilities, you are welcome to choose many!");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    sandwich.addToppings(new Toppings("Black Flash",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nAbility added");
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Titan Shifting",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nAbility added");
                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Flight",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nAbility added");
                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Fire Affinity",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nAbility added");
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("10 Shadows Technique",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nAbility added");

                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Instant Regeneration",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nAbility added");
                    break;
                case 7:
                    sandwich.addToppings(new Toppings("Shadow Clones",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nAbility added");
                    break;
                case 8:
                    sandwich.addToppings(new Toppings("Infinity",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nAbility added");
                    break;
                case 9:
                    sandwich.addToppings(new Toppings("Amateratsu",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\nAbility added");
                    break;
                case 0:
                    moreToppings=false;
                    return;
                default:
                    System.out.println("Invalid Ability choice!");
            }
        }
    }
    //
    public void addSauces(Sandwich sandwich) {
        boolean moreSauce=true;
        while(moreSauce) {
            System.out.println("\n===TRAITS" +
                    "\n1.) Healing Aura" +
                    "\n2.) Beserker's Rage" +
                    "\n3.) Blood Pact" +
                    "\n4.) Divine Protection" +
                    "\n5.) Phantom Step" +
                    "\n6.) Future Sight" +
                    "\n0.) Back");
            System.out.println("\nChoose your traits, you are welcome to choose many! ");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    sandwich.addToppings(new Toppings("Healing Aura",
                            ToppingType.SAUCE, false));
                    System.out.println("\nTrait added");
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Beserker's Rage",
                            ToppingType.SAUCE, false));
                    System.out.println("\nTrait added");
                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Blood Pact",
                            ToppingType.SAUCE, false));
                    System.out.println("\nTrait added");
                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Divine Protection",
                            ToppingType.SAUCE, false));
                    System.out.println("\nTrait added");
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("Phantom Step",
                            ToppingType.SAUCE, false));
                    System.out.println("\nTrait added");
                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Future Sight",
                            ToppingType.SAUCE, false));
                    System.out.println("\nTrait added");
                    break;
                case 0:
                    moreSauce=false;
                    break;
                default:
                    System.out.println("\nInvalid Traits Choice");
            }
        }
    }
    //method for int input handling
    private int getIntInput(){
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("The Guild cannot make that request... try again");
            }
        }
    }
    public void displayCustomBuilds(){
        System.out.println("====Custom Builds====" +
                "\n1.) Beserker" +
                "\n2.) Shadow Monk" +
                "\n3.) Storm Archer" +
                "\n4.) Back");
        int choice = getIntInput();
        switch (choice){
            case 1:
                Sandwich beserker = new Beserker();
                currentOrder.addItem(beserker);
                System.out.println("\nBeserker Added to Quest!");
                break;
            case 2:
                Sandwich shadowMonk = new ShadowMonk();
                currentOrder.addItem(shadowMonk);
                System.out.println("\nShadow Monk Added to Quest");
                break;
            case 3:
                Sandwich stormArcher = new StormArcher();
                currentOrder.addItem(stormArcher);
                System.out.println("\nStorm Archer Added to Quest" +
                        "\nContniue preparing your adventure");
                break;
            case  4:
                return;
            default:
                System.out.println("\nInvalid Choice!");
        }
    }
}
