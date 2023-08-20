
public class NextDayTicketDelivery extends TicketDelivery{
	
	private static double additionalFeePerKg; // ensure can be used by other class
	

	public NextDayTicketDelivery(String custName, String custAddress, String city, String country, String postcode,
			double ticketWeight, double costPerKg, String trackingNumber) {
		super(custName, custAddress, city, country, postcode, ticketWeight, costPerKg, trackingNumber);
		// TODO Auto-generated constructor stub
	}

	// cost of delivery
		@Override
	    public double calculateDeliveryCost() {
			// come back to this logic - 1000 grams is a KG. 
			return super.calculateDeliveryCost() + (getTicketWeight() * getAdditionalFeePerKg());
	    }
		
		
		// get & set
		public static double getAdditionalFeePerKg() {
			return additionalFeePerKg;
		}

		public static void setAdditionalFeePerKg(double additionalFeePerKg) {
			NextDayTicketDelivery.additionalFeePerKg = additionalFeePerKg < 0 ? 0.0 : additionalFeePerKg;
		
		}
	
		
		@Override
		public String toString(){
		      return String.format( "Additional Fee per Kg: $%,.2f\n\n%s", 
		    		  getAdditionalFeePerKg(),super.toString());
		   } // end method toString
}// end main
