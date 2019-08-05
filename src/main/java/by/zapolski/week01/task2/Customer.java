package by.zapolski.week01.task2;

public class Customer {
    private NominalBancnoteType banknote;

    public Customer(NominalBancnoteType banknote) {
        this.banknote = banknote;
    }

    public NominalBancnoteType getBanknote() {
        return banknote;
    }
}
