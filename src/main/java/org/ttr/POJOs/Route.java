package main.java.org.ttr.POJOs;

public class Route {

    private City fromCity;
    private City toCity;
    private int ticketPriceInCards;

    public City getFromCity() {
        return fromCity;
    }

    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public void setToCity(City toCity) {
        this.toCity = toCity;
    }

    public int getTicketPriceInCards() {
        return ticketPriceInCards;
    }

    public void setTicketPriceInCards(int ticketPriceInCards) {
        this.ticketPriceInCards = ticketPriceInCards;
    }

    public Route(City fromCity, City toCity, int ticketPriceInCards) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.ticketPriceInCards = ticketPriceInCards;
    }

    @Override
    public String toString() {
        return fromCity + "->" + toCity + " :" + ticketPriceInCards;
    }
}
