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
            Art.displayTavernBanner();
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
                    System.out.println("\n❌ This journey is not for you, safe travels!");
                    break;
                default:
                    System.out.println("⚠\uFE0FYou must have had too much ale, try again!");

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
                    System.out.println("\n❌ Destiny has yet to call this one..");
                    return;
                default:
                    //input error
                    System.out.println("\n⚠\uFE0F  .. too much ale again huh?");
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
        System.out.println("\n\uD83D\uDCDC Loadout added to Quest!!");
    }
    //drinks
    public void brewPotions() {
        Art.brewBanner();
        System.out.println(
                "\n1.) ◈ Minor" +
                "\n2.) ◆ Greater" +
                "\n3.) ★ Legendary");
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
                System.out.println("\n⚠\uFE0F Invalid size choice");
                return;
        }
        //affinity
        Art.affBanner();
        System.out.println("1.) Mana\uD83D\uDD35");
        System.out.println("2.) Health ❤\uFE0F");
        System.out.println("3.) Stamina \uD83D\uDCA8");
        System.out.println("4.) Poison \uD83E\uDDEA");
        System.out.println("5.) Frost❄\uFE0F");
        System.out.println("6.) Lightning⚡");
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
                System.out.println("\n⚠\uFE0F Invalid affinity choice");
                return;
        }
        Drink drink = new Drink(affinity, size);
        currentOrder.addItem(drink);
        System.out.println("\n\uD83D\uDCDC Potion added!");
    }
    //chips
    public void purchaseRations() {
        Art.rationsBanner();
        System.out.println("\nChoose ration type " +
                "\n1.) Rumble Ball \uD83D\uDC8E" +
                "\n2.) Devil Fruit(Random) \uD83C\uDF4E" +
                "\n3.) Sukana's Fingers(3)☠ \uFE0F");
        int choice = getIntInput();
        String type;
        switch (choice) {
            case 1:
                type = "Rumble Ball \uD83D\uDC8E";
                break;
            case 2:
                type = "Devil Fruit \uD83C\uDF4E";
                break;
            case 3:
                type = "Sukana's Fingers(3)☠ \uFE0F";
                break;
            default:
                System.out.println("\n❌ Invalid Ration choice");
                return;
        }
        Chips chips = new Chips(type);
        currentOrder.addItem(chips);
        System.out.println("\n\uD83D\uDCDC Rations successfully added!");
    }
    public void startJourney() {
        Art.questBanner();
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
                System.out.println("\uD83D\uDCDC Quest Confirmed!");
                System.out.println("✨Returning to Tavern...");
                return;
            case 2:
                currentOrder.clearOrder();
                currentOrder = new Order();
                System.out.println("❌ Quest Cancelled..");
                System.out.println("❌ Returning to Tavern...");
                return;
            default:
                System.out.println("⚠\uFE0FMaybe you're confused, try again!");
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
                System.out.println("\n❌ Invalid Choice, please enter Y or N.");
            }
        }
    }
    private void selectToppings(Sandwich sandwich){
        boolean addToppings = true;

        while(addToppings){
            Art.selectToppingsBanner();
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
                    System.out.println("⚠\uFE0F Invalid choice");
                    return;
            }
        }
    }

    private void addMeats(Sandwich sandwich) {
        Art.weaponsBanner();
        boolean moreWeapons = true;

        while (moreWeapons) {
            System.out.println(
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
                    System.out.println("\n✔\uFE0F Weapon added!");
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Iron Longsword⚔\uFE0F",
                            ToppingType.MEAT, false));
                    System.out.println("\n✔\uFE0F Weapon added!");

                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Twin Daggers\uD83D\uDDE1\uFE0F",
                            ToppingType.MEAT, false));
                    System.out.println("\n✔\uFE0F Weapon added!");

                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Elven Bow\uD83C\uDFF9",
                            ToppingType.MEAT, false));
                    System.out.println("\n✔\uFE0F Weapon added!");
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("Beserker Axe\uD83E\uDE93",
                            ToppingType.MEAT, false));
                    System.out.println("\n✔\uFE0F Weapon added!");

                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Omnitrix\uD83D\uDC41\uFE0F",
                            ToppingType.MEAT, false));
                    System.out.println("\n✔\uFE0F Weapon added!");
                    break;
                case 0:
                    moreWeapons=false;
                    return;
                default:
                    System.out.println("❌ Invalid Weapon choice");
                    ;
            }
        }
    }

    private void addCheese(Sandwich sandwich){
        Art.blessingsBanner();
        System.out.println("\n1.) Flame, Grant Me Strength\uD83D\uDD25" +
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
                System.out.println("\n✔\uFE0F Blessing added!");
                break;
            case 2:
                sandwich.addToppings(new Toppings("Golden Vow\uD83C\uDF19",
                        ToppingType.CHEESE, false));
                System.out.println("\n✔\uFE0F Blessing added!");
                break;
            case 3:
                sandwich.addToppings(new Toppings("Blessing of the Erdtree\uD83C\uDF11",
                        ToppingType.CHEESE, false));
                System.out.println("\n✔\uFE0F Blessing added!");
                break;
            case 4:
                sandwich.addToppings(new Toppings("Black Flame's Protection\uD83D\uDD2E",
                        ToppingType.CHEESE, false));
                System.out.println("\n✔\uFE0F Blessing added!");
                break;
            default:
                System.out.println("❌ Invalid Blessing choice");
        }
    }
    public void addRegularToppings(Sandwich sandwich){
        boolean moreToppings = true;
        while (moreToppings) {
            Art.abilitiesBanner();
            System.out.println("\n1.) Black Flash\uD83D\uDCA5" +
                    "\n2.) Titan Shifting⚡" +
                    "\n3.) Flight\uD83D\uDCA8" +
                    "\n4.) Fire Affinity\uD83D\uDD25" +
                    "\n5.) 10 Shadows Technique" +
                    "\n6.) Instant Regeneration\uD83E\uDE78" +
                    "\n7.) Shadow Clones\uD83D\uDD2E" +
                    "\n8.) Infinity\uD83C\uDF19" +
                    "\n9.) Amateratsu\uD83C\uDF11" +
                    "\n0.) Back");
            System.out.println("Choose your key abilities, you are welcome to choose many!");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    sandwich.addToppings(new Toppings("Black Flash\uD83D\uDCA5",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\n✔\uFE0F Ability added");
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Titan Shifting⚡",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\n✔\uFE0F Ability added");
                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Flight\uD83D\uDCA8",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\n✔\uFE0F Ability added");
                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Fire Affinity",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\n✔\uFE0F Ability added");
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("10 Shadows Technique",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\n✔\uFE0F Ability added");

                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Instant Regeneration\uD83E\uDE78",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\n✔\uFE0F Ability added");
                    break;
                case 7:
                    sandwich.addToppings(new Toppings("Shadow Clones\uD83D\uDD2E",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\n✔\uFE0F Ability added");
                    break;
                case 8:
                    sandwich.addToppings(new Toppings("Infinity\uD83C\uDF19",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\n✔\uFE0F Ability added");
                    break;
                case 9:
                    sandwich.addToppings(new Toppings("Amateratsu\uD83C\uDF11",
                            ToppingType.OTHER_TOPPINGS, false));
                    System.out.println("\n✔\uFE0F Ability added");
                    break;
                case 0:
                    System.out.println("\n\uD83E\uDEB6 Back to THE FORGE!");
                    moreToppings=false;
                    return;
                default:
                    System.out.println("❌ Invalid Ability choice!");
            }
        }
    }
    //
    public void addSauces(Sandwich sandwich) {
        boolean moreSauce=true;
        while(moreSauce) {
            Art.traitsBanner();
            System.out.println("\n1.) Healing Aura\uD83D\uDCAB" +
                    "\n2.) Beserker's Rage\uD83D\uDD25" +
                    "\n3.) Blood Pact\uD83E\uDE78" +
                    "\n4.) Divine Protection☀\uFE0F" +
                    "\n5.) Phantom Step\uD83C\uDF19" +
                    "\n6.) Future Sight\uD83D\uDC41\uFE0F" +
                    "\n0.) Back");
            System.out.println("\nChoose your traits, you are welcome to choose many! ");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    sandwich.addToppings(new Toppings("Healing Aura\uD83D\uDCAB",
                            ToppingType.SAUCE, false));
                    System.out.println("\n✔\uFE0F Trait added");
                    break;
                case 2:
                    sandwich.addToppings(new Toppings("Beserker's Rage\uD83D\uDD25",
                            ToppingType.SAUCE, false));
                    System.out.println("\n✔\uFE0F Trait added");
                    break;
                case 3:
                    sandwich.addToppings(new Toppings("Blood Pact\uD83E\uDE78",
                            ToppingType.SAUCE, false));
                    System.out.println("\n✔\uFE0F Trait added");
                    break;
                case 4:
                    sandwich.addToppings(new Toppings("Divine Protection☀\uFE0F",
                            ToppingType.SAUCE, false));
                    System.out.println("\n✔\uFE0F Trait added");
                    break;
                case 5:
                    sandwich.addToppings(new Toppings("Phantom Step\uD83C\uDF19",
                            ToppingType.SAUCE, false));
                    System.out.println("\n✔\uFE0F Trait added");
                    break;
                case 6:
                    sandwich.addToppings(new Toppings("Future Sight\uD83D\uDC41\uFE0F",
                            ToppingType.SAUCE, false));
                    System.out.println("\n✔\uFE0F Trait added");
                    break;
                case 0:
                    System.out.println("\n\uD83E\uDEB6 Back to THE FORGE!");
                    moreSauce=false;
                    break;
                default:
                    System.out.println("\n❌ Invalid Traits Choice");
            }
        }
    }
    //method for int input handling
    private int getIntInput(){
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠\uFE0FThe Guild cannot make that request... try again⚠\uFE0F");
            }
        }
    }
    public void displayCustomBuilds(){
        Art.presetsBanner();
        System.out.println("\n1.) Beserker" +
                "\n2.) Shadow Monk" +
                "\n3.) Storm Archer" +
                "\n4.) Back");
        int choice = getIntInput();
        switch (choice){
            case 1:
                Sandwich beserker = new Beserker();
                currentOrder.addItem(beserker);
                Art.beserkerBanner();
                System.out.println("\n⚔\uFE0F\uD83D\uDD25 Beserker Added to Quest!" +
                        "\nContinue preparing your adventure");

                break;
            case 2:
                Sandwich shadowMonk = new ShadowMonk();
                currentOrder.addItem(shadowMonk);
                Art.monkBanner();
                System.out.println("\n\uD83C\uDF11\uD83D\uDD2EShadow Monk Added to Quest" +
                        "\nContinue preparing your adventure");
                break;
            case 3:
                Sandwich stormArcher = new StormArcher();
                currentOrder.addItem(stormArcher);
                Art.archerBanner();
                System.out.println("\n\uD83C\uDFF9❄\uFE0F Storm Archer Added to Quest" +
                        "\nContinue preparing your adventure");
                break;
            case  4:
                return;
            default:
                System.out.println("\n❌ Invalid Choice!");
        }
    }
}
