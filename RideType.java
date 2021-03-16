public enum RideType {
    NORMAL(10, 1, 5), PREMIUM(15, 2, 20);

    public final int costPerKilometer;
    public final int timePerMinute;
    public final int minimumFare;

    RideType(int costPerKilometer, int timePerMinute, int minimumFare) {
        this.costPerKilometer = costPerKilometer;
        this.timePerMinute = timePerMinute;
        this.minimumFare = minimumFare;
    }
}