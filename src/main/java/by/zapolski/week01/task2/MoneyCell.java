package by.zapolski.week01.task2;

public class MoneyCell {

    private int amountOfBanknotes;
    private NominalBancnoteType nominal;
    private int capacityInBanknotes;

    public MoneyCell(final NominalBancnoteType nominal, final int capacityInBanknotes) {
        this.nominal = nominal;
        this.capacityInBanknotes = capacityInBanknotes;
    }

    public int getAmountOfBanknotes() {
        return amountOfBanknotes;
    }

    public void setAmountOfBanknotes(final int amountOfBanknotes) {
        this.amountOfBanknotes = amountOfBanknotes;
    }

    public NominalBancnoteType getNominal() {
        return nominal;
    }

    public int getCapacityInBanknotes() {
        return capacityInBanknotes;
    }

    public int getTotalSum() {
        return nominal.getValue() * amountOfBanknotes;
    }

    public int addBancnotes(final int countBancnotesToAdd) {
        int avalaivbleToAdd = capacityInBanknotes - amountOfBanknotes;
        if (avalaivbleToAdd > countBancnotesToAdd) {
            amountOfBanknotes += countBancnotesToAdd;
            return countBancnotesToAdd;
        } else {
            amountOfBanknotes += avalaivbleToAdd;
            return avalaivbleToAdd;
        }
    }

    public int takeBancnotes(final int countBancnotesToTake) {
        int currentToTake;
        currentToTake = countBancnotesToTake > amountOfBanknotes ? amountOfBanknotes : countBancnotesToTake;
        amountOfBanknotes = amountOfBanknotes - currentToTake;
        return currentToTake;
    }
}