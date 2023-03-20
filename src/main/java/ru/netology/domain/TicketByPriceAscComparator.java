package ru.netology.domain;
import ru.netology.domain.Tickets;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<Tickets> {
    @Override
    public int compare(Tickets o1, Tickets o2) {
        if (o1.getTime() < o2.getTime()) {
            return -1;
        } else if (o1.getTime() > o2.getTime()) {
            return 1;
        } else {
            return 0;
        }
    }

}
