package nau.advanced.practice5.task3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Plane[] planes = new Plane[]{
                new Plane(350, RangeType.FAR),
                new Plane(240, RangeType.AVERAGE),
                new Plane(280, RangeType.FAR),
                new Plane(320, RangeType.CLOSE),
        };
        Airport[] airports = new Airport[]{
                new Airport(0, 2, 700),
                new Airport(1, 2, 800),
                new Airport(2, 2, 600),
                new Airport(3, 2, 900),
        };
        planes[0].setLendingAirport(airports[2]);
        planes[0].setDestinationAirport(airports[3]);

        planes[1].setLendingAirport(airports[1]);
        planes[1].setDestinationAirport(airports[0]);

        planes[2].setLendingAirport(airports[0]);
        planes[2].setDestinationAirport(airports[2]);

        planes[3].setLendingAirport(airports[3]);
        planes[3].setDestinationAirport(airports[1]);

        System.out.println("\n\t\t\t\tAirports: \n");
        for (var airport : airports) {
            System.out.println(airport);
        }
        System.out.println();

        for (var plane : planes) {
            plane.start();
        }
        Thread.currentThread().join(3000);

        System.out.println("\n\t\t\t\tAirports: \n");
        for (var airport : airports) {
            System.out.println(airport);
        }
        System.out.println();
    }
}
