
public class StandardTicketDelivery extends TicketDelivery {
	
	
	private static double flatFee; // ensure can be used by other class
	
	public StandardTicketDelivery(String custName, String custAddress, String city, String country, String postcode,
			double ticketWeight, double costPerKg, String trackingNumber) {
		super(custName, custAddress, city, country, postcode, ticketWeight, costPerKg, trackingNumber);
		
	}
	
	// cost of delivery
	@Override
    public double calculateDeliveryCost() {
        return super.calculateDeliveryCost() + flatFee;
    }
	
	// get & set
	public static double getFlatFee() {
		return flatFee;
	}

	public static void setFlatFee(double flatFee) {
		
		StandardTicketDelivery.flatFee = flatFee < 0 ? 0.0 : flatFee;
	}
	
	@Override
	public String toString(){
	      return String.format( "Flat Fee: $%,.2f\n\n%s", 
	    		   getFlatFee(), super.toString());
	   } // end method toString

	} // end class


