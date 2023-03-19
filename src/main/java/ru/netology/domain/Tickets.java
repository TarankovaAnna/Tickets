package ru.netology.domain;

import java.util.Arrays;

public class Tickets implements Comparable<Tickets> {

    protected int id;
    protected int price;
    protected String from;
    protected String to;
    protected int time;
    public Tickets(int id, int price, String from, String to, int time) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.time = time;
    }

    public int compareTo(Tickets o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }



//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }

    public String getFrom() {
        return from;
    }

//    public void setFrom(String departureAirport) {
//        this.from = departureAirport;
//    }

    public String getTo() {
        return to;
    }

//    public void setTo(String arrivalAirport) {
//        this.to = arrivalAirport;
//    }

//    public int getTime() {
//        return time;
//    }
//
//    public void setTime(int time) {
//        this.time = time;
//    }

}
