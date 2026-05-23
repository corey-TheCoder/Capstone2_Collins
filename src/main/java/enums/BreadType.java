package enums;

public enum BreadType {
    //constants for bread type
    //constants for archetypes
    WHITE("Knight"),
    WHEAT("Ranger"),
    RYE("Warlock"),
    WRAP("Cleric");

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
