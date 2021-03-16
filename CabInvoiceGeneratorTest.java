import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    //CREATE OBJECT OF MAIN CLASS
    CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

    @Test
    public void givenDistanceAndTime_InvoiceGeneratorGenerateFare_ShouldReturnTotalFareForJourney() {
        int time = 5;
        double distance = 2.0;
        String userId = "user";
        Ride[] rides = {new Ride(distance, time, RideType.NORMAL)};
        cabInvoiceGenerator.addRides(userId, rides);
        InvoiceDetails invoiceDetails = cabInvoiceGenerator.getInvoiceDetails(userId);
        Assert.assertEquals(25, invoiceDetails.totalFare, 0);
    }

    @Test
    public void givenDistanceAndTime_InvoiceGeneratorGenerateFare_ShouldReturnMinimumFareForJourney() {
        int time = 3;
        double distance = 0.1;
        String userId = "user";
        Ride[] rides = {new Ride(distance, time, RideType.NORMAL)};
        cabInvoiceGenerator.addRides(userId, rides);
        InvoiceDetails invoiceDetails = cabInvoiceGenerator.getInvoiceDetails(userId);
        Assert.assertEquals(5, invoiceDetails.totalFare, 0);
    }

    @Test
    public void givenDistanceAndTime_InvoiceGeneratorGenerateFareForMultipleRides_ShouldReturnTotalFareForJourney() {
        String userId = "user";
        Ride[] rides = {new Ride(2.0, 5, RideType.NORMAL), new Ride(0.1, 1, RideType.NORMAL)};
        cabInvoiceGenerator.addRides(userId, rides);
        InvoiceDetails invoiceDetails = cabInvoiceGenerator.getInvoiceDetails(userId);
        Assert.assertEquals(30, invoiceDetails.totalFare, 0);
    }

    @Test
    public void givenDistanceAndTime_InvoiceGeneratorGenerateFareForMultipleRides_ShouldReturnInvoiceDetails() {
        String userId = "user";
        Ride[] rides = {new Ride(2.0, 5, RideType.NORMAL), new Ride(0.1, 1, RideType.NORMAL)};
        cabInvoiceGenerator.addRides(userId, rides);
        InvoiceDetails invoiceDetails = cabInvoiceGenerator.getInvoiceDetails(userId);
        InvoiceDetails expectedDetails = new InvoiceDetails(2, 30);
        Assert.assertEquals(invoiceDetails, expectedDetails);
    }

    @Test
    public void givenUserId_InvoiceGeneratorGenerateFareForMultipleRides_ShouldReturnInvoiceDetails() {
        String userId = "user";
        Ride[] rides = {new Ride(2.0, 5, RideType.NORMAL), new Ride(0.1, 1, RideType.NORMAL)};
        cabInvoiceGenerator.addRides(userId, rides);
        InvoiceDetails invoiceDetails = cabInvoiceGenerator.getInvoiceDetails(userId);
        InvoiceDetails expectedDetails = new InvoiceDetails(2, 30);
        Assert.assertEquals(invoiceDetails, expectedDetails);
    }

    @Test
    public void givenDistanceTimeRideType_InvoiceGeneratorGenerateFareForRide_ShouldReturnInvoiceDetails() {
        String userId = "user";
        Ride[] rides = {new Ride(2.0, 5, RideType.NORMAL), new Ride(2.0, 5, RideType.PREMIUM)};
        cabInvoiceGenerator.addRides(userId, rides);
        InvoiceDetails invoiceDetails = cabInvoiceGenerator.getInvoiceDetails(userId);
        InvoiceDetails expectedDetails = new InvoiceDetails(2, 65);
        Assert.assertEquals(invoiceDetails, expectedDetails);
    }
}