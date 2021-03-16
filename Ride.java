public class Ride {
    public final double distanceInKiloMeter;
    public final int travelPerMinute;
    public final RideType type;


    public Ride(double distance, int time, RideType type) {
        this.distanceInKiloMeter = distance;
        this.travelPerMinute = time;
        this.type = type;

    }
}