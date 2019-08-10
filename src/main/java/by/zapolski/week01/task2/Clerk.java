package by.zapolski.week01.task2;

import java.util.ArrayList;
import java.util.List;

public class Clerk {

    private static final int TICKET_PRICE = 25;

    private List<MoneyCell> cashbox;

    public Clerk() {
        cashbox = new ArrayList<>();
        cashbox.add(new MoneyCell(NominalBancnoteType.TWENTY_FIFE,Integer.MAX_VALUE));
        cashbox.add(new MoneyCell(NominalBancnoteType.FIFTY,Integer.MAX_VALUE));
        cashbox.add(new MoneyCell(NominalBancnoteType.HUNDRED,Integer.MAX_VALUE));
    }

    public boolean processQueue(List<Customer> customers){
        for (Customer customer: customers){
            int change = customer.getBanknote().getValue()-TICKET_PRICE;
            if (change>0 && giveChange(change)!=change){
                return false;
            }
            addBanknotesInCell(customer.getBanknote(),1);
        }
        return true;
    }

    private int addBanknotesInCell(final NominalBancnoteType nominal, final int countBanknotes) {
        for (MoneyCell moneyCell: cashbox){
            if (moneyCell.getNominal() == nominal){
                return moneyCell.addBancnotes(countBanknotes);
            }
        }
        return 0;
    }

    private int giveChange(final int requestedSum) {
        if (!canTakeMoneyBySum(requestedSum)) {
            return 0;
        }
        if (!canTakeMoneyByNominal(requestedSum)) {
            return -1;
        }
        removeBanknotes(requestedSum);
        return requestedSum;
    }

    private void removeBanknotes(final int requestedSum) {
        int currentSum = requestedSum;
        for (int i = cashbox.size() - 1; i >= 0; i--) {
            int currentNominalValue = cashbox.get(i).getNominal().getValue();
            int needBancnotes = currentSum / currentNominalValue;
            currentSum = currentSum - currentNominalValue * cashbox.get(i).takeBancnotes(needBancnotes);
            if (currentSum == 0) {
                break;
            }
        }
    }

    private boolean canTakeMoneyByNominal(final int requestedSum) {
        for (MoneyCell cell : cashbox){
            if (cell.getAmountOfBanknotes()>0){
                return requestedSum % cell.getNominal().getValue() == 0;
            }
        }
        return false;
    }

    private boolean canTakeMoneyBySum(final int requestedSum) {
        return !(requestedSum > getAvailableSum());
    }

    private int getAvailableSum() {
        int sum = 0;
        for (MoneyCell moneyCell : cashbox) {
            sum = sum + moneyCell.getTotalSum();
        }
        return sum;
    }
}
