
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TicketDeliveryController {
	
	// arraylist of ticket delivery
	 private ArrayList<TicketDelivery> deliveries;
	 
	 public TicketDeliveryController() {
		 
		   //initialise the ArrayList
	        deliveries = new ArrayList<>();
	    }
	 
	 public void addDelivery() {
		
		 int num = 0;
		 
		 do {
			 String deliveryType = JOptionPane.showInputDialog("Please enter the delivery type: 1. Standard 2. Next Day 3. Exit");
				try {
				   num = Integer.parseInt(deliveryType);
				   if (num < 1 || num > 3) 
					  JOptionPane.showMessageDialog(null, "Invalid input. Enter option 1, 2 or 3.");
				}catch(NumberFormatException e) { //InputMismatchException is specific for the Scanner. 
					JOptionPane.showMessageDialog(null, "Invalid input. Enter option 1, 2 or 3.");
					num = -1; // ensure we can try again
				}
			} while (num < 1 || num > 3);
		 	
		 // exit if 3
		 if(num == 3) {
			 return;
		 }
	
		 	// enter in information for delivery constructor
		    String custName = JOptionPane.showInputDialog("Enter your name: ");
	        String custAddress = JOptionPane.showInputDialog("Enter address: ");
	        String city = JOptionPane.showInputDialog("Enter city: ");
	        String country = JOptionPane.showInputDialog("Enter country: ");
	        String postcode = JOptionPane.showInputDialog("Enter postcode/zipcode: ");
	        boolean flag = true; // error handle
	        double ticketWeight = 0; // must set to handle
	        while(flag){
	    
			try {
				ticketWeight = Double.parseDouble(JOptionPane.showInputDialog("Enter ticket weight in grams: "));
				flag = false; // if no catch break out
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				 JOptionPane.showMessageDialog(null, "Invalid input: Enter numeric value");	
			}
	        }// while
	        double costPerKg = 0; // must set to handle
	        flag = true; // reset to true
	        while(flag){
	       
			try {
				costPerKg = Double.parseDouble(JOptionPane.showInputDialog("Enter cost per kg: "));
				flag = false;
			} catch (NumberFormatException e) {
				
				 JOptionPane.showMessageDialog(null, "Invalid input: Enter numeric value");
				//e.printStackTrace();
			} 
			}// while
	        String trackingNumber = JOptionPane.showInputDialog("Enter tracking number: ");
			
		 
	      //IDE set to null
		 TicketDelivery delivery = null;
		 // if 1 standard deliver, if 2 next day delivery
		  if (num == 1) {
	            delivery = new StandardTicketDelivery(custName, custAddress, city, country, postcode, ticketWeight, costPerKg, trackingNumber);
	        } else if (num == 2) {
	            delivery = new NextDayTicketDelivery(custName, custAddress, city, country, postcode, ticketWeight, costPerKg, trackingNumber);
	        }
		 
		
		 // add to array
		 deliveries.add(delivery);
		 
		 //call to method
	     displayDeliveryDetails(delivery);
	 }
	 
	 private void displayDeliveryDetails(TicketDelivery myDelivery) {
	        JOptionPane.showMessageDialog(null, myDelivery.toString());
	    }
	 		
	
	 private int getIndex(String myDeliveryTrackingNumber) {
		 		//loop through list
	           for (int index = 0; index < deliveries.size(); index++) {
	        	// if delivery tracking number at index == myDeliveryTracking number  
	            if (deliveries.get(index).getTrackingNumber().equals(myDeliveryTrackingNumber)) {
	            	// return the index
	                return index;
	            }
	        }
	        return -1;
	    }
	 
	 public void searchDelivery() {
		 // ask user for tracking no.
		 String DeliveryTrackingNumber = JOptionPane.showInputDialog("Please enter your delivery tracking number: ");
	        
	        // call to getIndex method
	        int index = getIndex(DeliveryTrackingNumber);
	       
	        	// if found
	        if (index != -1) {
	        	 // call to displayDetails method with the index
	           displayDeliveryDetails(deliveries.get(index));
	        } else {
	            JOptionPane.showMessageDialog(null, "Tracking number not found.");
	        }
	             
	 }
	  
	 public void costPerDeliveryReport() {
		   		
			    String report = "***Cost per Delivery Report***\n";
			    //iterate through array
			    for (TicketDelivery delivery : deliveries) {
			    	// print the calculate cost method and tracking number for each delivery in array
			        report += "Delivery Tracking Number: " + delivery.getTrackingNumber()
			                + "\nCost: $" + delivery.calculateDeliveryCost() + "\n\n";
			    }
			    // print report
			    JOptionPane.showMessageDialog(null, report);
			}
	 
}//class
