package vn.edu.iuh.fit.week04.enums;

public enum SkillLevel {
    JUNIOR(0), MIDDLE(1), SENIOR(2);
    private int value;
    private SkillLevel(int value){
        this.value = value;
    }

    public int getLevel() {
        return value;
    }

    public int getValue() {
        return value;
    }
}
