package enums;

public enum SandwichSize {
    //constants for sandwich size
    //constants for rank
    FOUR_INCH("◈ Novice"),
    EIGHT_INCH("◆ Veteran"),
    FOOT_LONG("★ Legendary");

    private final String displayName;

    SandwichSize(String displayName) {
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
