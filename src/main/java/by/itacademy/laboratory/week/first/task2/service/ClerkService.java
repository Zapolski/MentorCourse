package by.itacademy.laboratory.week.first.task2.service;

import by.itacademy.laboratory.week.first.task2.model.Buyer;
import by.itacademy.laboratory.week.first.task2.model.Clerk;

import java.util.List;

public class ClerkService {

    public boolean canHandle(Clerk clerk, List<Buyer> buyers) {
        boolean result = true;
        for (Buyer buyer : buyers) {
            if (!clerk.sellTicket(buyer.getNote())) {
                result = false;
                break;
            }
        }

        return result;
    }
}
