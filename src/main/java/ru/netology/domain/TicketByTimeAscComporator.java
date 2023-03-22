package ru.netology.domain;

import java.util.Comparator;

public class TicketByTimeAscComporator implements Comparator<Tickets> {

    @Override
    public int compare(Tickets o1, Tickets o2) {
        return o1.getTime() - o2.getTime();
    }
}
