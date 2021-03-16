import java.util.ArrayList;

public class CabInvoiceGenerator {

    RideRepository rideRepository = null;

    CabInvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

    //CONSTANTS
    private double COST_PER_KILOMETER;
    private int COST_PER_MINUTE;
    private int MINIMUM_FARE;

    //VARIABLE
    double totalFare = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to cab invoice generator");
    }

    public InvoiceDetails getInvoiceDetails(String userId) {
        ArrayList userRides = rideRepository.getRideDetails(userId);
        Ride[] rides = new Ride[userRides.size()];
        userRides.toArray(rides);
        for (Ride ride : rides) {
            totalFare += this.getTotalFare(ride.distanceInKiloMeter, ride.travelPerMinute, ride.type);
        }
        return new InvoiceDetails(rides.length, totalFare);
    }

    //METHOD TO GET TOTAL FARE FOR JOURNEY
    public double getTotalFare(double distanceInKiloMeter, int travelPerMinute, RideType type) {
        setValue(type);
        totalFare = distanceInKiloMeter * COST_PER_KILOMETER + travelPerMinute * COST_PER_MINUTE;
        return Math.max(MINIMUM_FARE, totalFare);
    }

    private void setValue(RideType type) {
        this.COST_PER_KILOMETER = type.costPerKilometer;
        this.COST_PER_MINUTE = type.timePerMinute;
        this.MINIMUM_FARE = type.minimumFare;
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRide(userId, rides);
    }
}