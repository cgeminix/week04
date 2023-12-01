package vn.edu.iuh.fit.week04.enums;

public enum SkillType {
    BEGINNER(0), INTERMEDIATE(1), MASTER(2);

    private int value;

    public int getValue() {
        return value;
    }

    SkillType(int value){
        this.value = value;
    }
}
