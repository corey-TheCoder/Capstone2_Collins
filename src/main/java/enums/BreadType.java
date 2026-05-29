package enums;

public enum BreadType {
    //constants for bread type
    //constants for archetypes
    WHITE("Knight⚔\uFE0F"),
    WHEAT("Ranger\uD83C\uDFF9"),
    RYE("Warlock\uD83D\uDC80"),
    WRAP("Cleric✨");

    private final String displayName;

    BreadType(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }
    @Override
    public String toString(){
        return displayName;
    }
}
