package nau.advanced.practice5.task2;

public class Request {
    private RequestType type;
    private String currency;
    private double amount;
    private double exchangeRate;
    private Broker broker;

    public Request(RequestType type, String currency, double amount, double exchangeRate, Broker broker) {
        this.type = type;
        this.currency = currency;
        this.amount = amount;
        this.exchangeRate = exchangeRate;
        this.broker = broker;
        this.broker.setRequest(this);
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public RequestType getType() {
        return type;
    }

    public Broker getBroker() {
        return broker;
    }

    @Override
    public String toString() {
        return "Request{type - " + type + ", currency - " + currency  + ", amount = " + amount +
                ", exchange rate = " + exchangeRate + ", broker - " + broker.getBrokerId() + "}";
    }
}
