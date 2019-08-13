package by.itacademy.laboratory.week.first.task2.service;

import by.itacademy.laboratory.week.first.task2.model.Buyer;
import by.itacademy.laboratory.week.first.task2.model.Clerk;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static by.itacademy.laboratory.week.first.task2.model.Note.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClerkServiceTest {

    private ClerkService clerkService = new ClerkService();

    @Test
    public void shouldSellAllTickets() {
        List<Buyer> buyers = Arrays.asList(
                new Buyer(NOTE_25), new Buyer(NOTE_25),
                new Buyer(NOTE_50),
                new Buyer(NOTE_100)
        );
        boolean actualResult = clerkService.canHandle(new Clerk(), buyers);
        assertTrue(actualResult);
    }

    @Test
    public void shouldNotSellAllTicketsForTwo25NotesAndOne100Note() {
        List<Buyer> buyers = Arrays.asList(
                new Buyer(NOTE_25), new Buyer(NOTE_25),
                new Buyer(NOTE_100)
        );
        boolean actualResult = clerkService.canHandle(new Clerk(), buyers);
        assertFalse(actualResult);
    }

    @Test
    public void shouldNotSellAllTicketsForTwo25NotesAndTwo50NotesAndOne100Note() {
        List<Buyer> buyers = Arrays.asList(
                new Buyer(NOTE_25), new Buyer(NOTE_25),
                new Buyer(NOTE_50), new Buyer(NOTE_50),
                new Buyer(NOTE_100)
        );
        boolean actualResult = clerkService.canHandle(new Clerk(), buyers);
        assertFalse(actualResult);
    }
}
