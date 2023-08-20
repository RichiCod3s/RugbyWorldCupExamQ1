
public abstract class TicketDelivery {
	
	private String custName;
	private String custAddress;
	private String city;
	private String country;
	private String postcode;
	private double ticketWeight; // grams - 1000 grams = kg
	private double costPerKg;
	private String trackingNumber;
	
	
	public TicketDelivery(String custName, String custAddress, String city, String country, String postcode,
			double ticketWeight, double costPerKg, String trackingNumber) {
		this.custName = custName;
		this.custAddress = custAddress;
		this.city = city;
		this.country = country;
		this.postcode = postcode;
		setTicketWeight(ticketWeight);
		setCostPerKg(costPerKg);
		this.trackingNumber = trackingNumber;
	}
	// cost of delivery
    public double calculateDeliveryCost() {
    	
        return ticketWeight * costPerKg;
    }
    
    // get and set

	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getCustAddress() {
		return custAddress;
	}


	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	public double getTicketWeight() {
		return ticketWeight;
	}


	public void setTicketWeight(double tWeight) {
		// if weight is less than 0, set weight to 0
		// //convert to kg - 1000 grams = kg
		this.ticketWeight = tWeight < 0.0 ? 0.0: tWeight/1000;
	}


	public double getCostPerKg() {
		return costPerKg;
	}


	public void setCostPerKg(double cost) { 
	 // if cost is less than 0, set weight to 0
		this.costPerKg = cost < 0 ? 0.0 : cost;
	}


	public String getTrackingNumber() {
		return trackingNumber;
	}


	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	 public String toString()
	   {
	      return String.format( "Name: %s\nAddress: %s\nCity: %s\nCountry: %s\nPostcode: %s\nTicket Weight: %.2f grams\nCost per Kg: $%,.2f\nTracking No: %s\nDelivery Cost: $%,.2f", 
	         getCustName(), getCustAddress(), getCity(),  getCountry(), getPostcode(), getTicketWeight(), getCostPerKg(), getTrackingNumber(), calculateDeliveryCost());
	   } // end method toString
}// class


