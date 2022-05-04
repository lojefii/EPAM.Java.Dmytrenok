package nau.advanced.practice5.task2;

public class Main {
    public static void main(String[] args) {
        Exchange exchange = new Exchange();

        Broker[] brokers = new Broker[] {
                new Broker(0, 650, exchange),
                new Broker(1, 1300, exchange),
                new Broker(2, 1000, exchange),
                new Broker(3, 900, exchange),
                new Broker(4, 500, exchange),
                new Broker(5, 850, exchange),
                new Broker(6, 700, exchange),
        };

        Request[] requests = new Request[] {
                new Request(RequestType.BUY, "Adobe", 2, 407, brokers[2]),
                new Request(RequestType.BUY, "Tesla", 1, 913, brokers[3]),
                new Request(RequestType.SELL, "Tesla", 1, 913, brokers[0]),
                new Request(RequestType.BUY, "Adobe", 3, 407, brokers[1]),
                new Request(RequestType.SELL, "Activision", 20, 79, brokers[4]),
                new Request(RequestType.SELL, "Adobe", 5, 407, brokers[6]),
                new Request(RequestType.BUY, "Activision", 10, 79, brokers[5]),
        };

        System.out.println("Brokers:");
        for (Broker broker : brokers) {
            System.out.println(broker);
            broker.start();
        }
        exchange.startAuction();
    }
}
