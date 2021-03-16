import java.util.Objects;

public class InvoiceDetails {
    public final double numberOfRides;
    public final double totalFare;
    public final double aggregateFarePerRide;

    public InvoiceDetails(double numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.aggregateFarePerRide = totalFare / numberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceDetails that = (InvoiceDetails) o;
        return Double.compare(that.numberOfRides, numberOfRides) == 0 &&
                Double.compare(that.totalFare, totalFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfRides, totalFare);
    }
}