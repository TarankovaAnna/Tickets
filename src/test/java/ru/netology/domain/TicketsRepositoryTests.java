package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketsRepositoryTests {
    TicketsRepository repo = new TicketsRepository();

    Tickets ticket1 = new Tickets(1, 12_000, "DME", "VOG", 210);
    Tickets ticket2 = new Tickets(2, 36_000, "VOG", "SVO", 220);
    Tickets ticket3 = new Tickets(3, 5_000, "DME", "VOG", 60);
    Tickets ticket4 = new Tickets(4, 27_400, "VOG", "SVO", 280);
    Tickets ticket5 = new Tickets(5, 5_800, "VOG", "ROV", 90);
    Tickets ticket6 = new Tickets(6, 27_900, "DME", "AER", 240);
    Tickets ticket7 = new Tickets(7, 15_890, "DME", "VOG", 280);
    Tickets ticket8 = new Tickets(8, 14_890, "VOG", "AER", 80);
    Tickets ticket9 = new Tickets(5, 5_800, "VOG", "ROV", 90);
    Tickets ticket10 = new Tickets(6, 27_400, "VOG", "SVO", 300);
    Tickets ticket11 = new Tickets(7, 890, "DME", "VOG", 280);
    Tickets ticket12 = new Tickets(8, 14_800, "VOG", "AER", 80);

    @Test
    public void shouldSaveAll() {

        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        repo.save(ticket9);
        repo.save(ticket10);
        repo.save(ticket11);
        repo.save(ticket12);

        Tickets[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10, ticket11, ticket12};
        Tickets[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSaveOneTicket() {
        repo.save(ticket2);

        Tickets[] expected = {ticket2};
        Tickets[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSaveMaxMinusOneTickets() {

        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        repo.save(ticket9);
        repo.save(ticket10);
        repo.save(ticket11);
        repo.save(ticket12);

        Tickets[] expected = {ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10, ticket11, ticket12};
        Tickets[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSaveTheSameTickets() {

        repo.save(ticket1);
        repo.save(ticket1);

        Tickets[] expected = {ticket1, ticket1};
        Tickets[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveZeroTickets() {

        Tickets[] expected = {};
        Tickets[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
