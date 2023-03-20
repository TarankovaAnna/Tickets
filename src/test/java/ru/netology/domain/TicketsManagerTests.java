package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class TicketsManagerTests {
    TicketsRepository repo = new TicketsRepository();
    TicketsManager manager = new TicketsManager(repo);

    Tickets ticket1 = new Tickets(1, 12_000, "DME", "VOG", 210);
    Tickets ticket2 = new Tickets(2, 36_000, "VOG", "SVO", 220);
    Tickets ticket3 = new Tickets(3, 5_000, "DME", "VOG", 60);
    Tickets ticket4 = new Tickets(4, 27_400, "VOG", "SVO", 280);
    Tickets ticket5 = new Tickets(5, 5_800, "VOG", "AER", 80);
    Tickets ticket6 = new Tickets(6, 27_900, "DME", "AER", 240);
    Tickets ticket7 = new Tickets(7, 15_890, "DME", "VOG", 280);
    Tickets ticket8 = new Tickets(8, 14_890, "VOG", "AER", 80);
    Tickets ticket9 = new Tickets(5, 5_800, "VOG", "ROV", 90);
    Tickets ticket10 = new Tickets(6, 27_400, "VOG", "SVO", 300);
    Tickets ticket11 = new Tickets(7, 890, "DME", "VOG", 280);
    Tickets ticket12 = new Tickets(8, 14_800, "VOG", "AER", 80);




    @BeforeEach

    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);


    }


    @Test
    public void shouldFindAll() {


        Tickets[] expected = {ticket11, ticket3, ticket1, ticket7};

        Tickets[] actual = manager.findAll("DME", "VOG");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindIfFromDoNotExist() {


        Tickets[] expected = {};

        Tickets[] actual = manager.findAll("LED", "VOG");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindIfToDoNotExist() {


        Tickets[] expected = {};

        Tickets[] actual = manager.findAll("VOG", "LED");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindAndSortIfPriceTheSame() {


        Tickets[] expected = {ticket4, ticket10, ticket2};

        Tickets[] actual = manager.findAll("VOG", "SVO");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindAndSortByTime() {
        Comparator<Tickets> comparator = new TicketByPriceAscComparator();

        Tickets[] expected = {ticket3, ticket1, ticket7, ticket11};
        Tickets[] actual = manager.findAll("DME", "VOG", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAndSortIfTimeTheSame() {
        Comparator<Tickets> comparator = new TicketByPriceAscComparator();


        Tickets[] expected = {ticket5, ticket8, ticket12};
        Tickets[] actual = manager.findAll("VOG", "AER", comparator);
    }
}