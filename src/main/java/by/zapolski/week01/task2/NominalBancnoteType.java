package by.zapolski.week01.task2;

public enum NominalBancnoteType {
    TWENTY_FIFE(25), FIFTY(50), HUNDRED(100),;

    private int value;

    NominalBancnoteType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}