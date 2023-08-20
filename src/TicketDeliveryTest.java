import javax.swing.JOptionPane;

public class TicketDeliveryTest {
	
	
    public static void main(String[] args) {
    	
    	
        TicketDeliveryController controller = new TicketDeliveryController();
        
        // set the flat & additional fee prices
        StandardTicketDelivery.setFlatFee(10.0);
    	NextDayTicketDelivery.setAdditionalFeePerKg(5.0);
    	
        // Add ticket delivery for test
    	 JOptionPane.showMessageDialog(null, "***Testing First Ticket Delivery***");	
        controller.addDelivery();
        
        
       // Add ticket delivery for test
        JOptionPane.showMessageDialog(null, "***Testing Second Ticket Delivery***");	
        controller.addDelivery();
     
        // Displaying cost per delivery report
        JOptionPane.showMessageDialog(null, "***Cost per Delivery Report***");	
        controller.costPerDeliveryReport();

        // Search for a delivery
        JOptionPane.showMessageDialog(null, "***Searching for Delivery***");	
        controller.searchDelivery();
        //controller.searchDelivery();  // add more if you wish
    }
}
