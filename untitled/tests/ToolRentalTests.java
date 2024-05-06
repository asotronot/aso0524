import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class ToolRentalTests {

    @Test(expected = IllegalArgumentException.class)
    // test 1 (should throw illegal argument)
    public void testDiscountGreaterThanHundredPercentInvalid() {
        Tool tool = new Jackhammer("JAKR", "Ridgit");
        LocalDate checkoutDate = LocalDate.of(2015, Month.SEPTEMBER, 3);
        Checkout checkout = new Checkout(tool, 5, 101, checkoutDate);

        RentalAgreement agreement = checkout.processCheckout();
        System.out.println("Rental Agreement:");
        agreement.printAgreement();
    }

    @Test
    // test 2
    public void testLadderWithHoliday() {
        // 3 days of charge for ladder, charged on weekends and not charged on holidays
        // July 2, July 3, and July 4 (which is holiday, no charge)
        // $1.99*2 = $3.98
        // 10 percent discount = 0.398
        // final amount should be 3.98 - 0.398 = 3.582
        Tool tool = new Ladder("LADW", "Werner");
        LocalDate checkoutDate = LocalDate.of(2020, Month.JULY, 2);
        Checkout checkout = new Checkout(tool, 3, 10, checkoutDate);

        RentalAgreement agreement = checkout.processCheckout();

        assertEquals(1.99*2 - (1.99*2*0.1), agreement.finalCharge, 0.01);
        System.out.println("Rental Agreement:");
        agreement.printAgreement();
    }

    @Test
    // test 3
    public void testChainsawWithHoliday() {
        Tool tool = new Chainsaw("CHNS", "Stihl");
        LocalDate checkoutDate = LocalDate.of(2015, Month.JULY, 2);
        Checkout checkout = new Checkout(tool, 5, 25, checkoutDate);

        RentalAgreement agreement = checkout.processCheckout();

        assertEquals(1.49*3 - (1.49*3*0.25), agreement.finalCharge, 0.01);
        System.out.println("Rental Agreement:");
        agreement.printAgreement();
    }


    @Test
    // test 4
    public void testJackHammer() {
        // 6 days of charge for jackhammer, not charged on weekends or holidays
        // September 3 to September 8, minus 2 days of holidays. 4 days of charge
        // $2.99*4 = $11.96
        // 0 percent discount = 0
        // final amount should be 11.96-0 = 40
        Tool tool = new Jackhammer("JAKD", "DeWalt");
        LocalDate checkoutDate = LocalDate.of(2015, Month.SEPTEMBER, 3);
        Checkout checkout = new Checkout(tool, 6, 0, checkoutDate);

        RentalAgreement agreement = checkout.processCheckout();

        assertEquals(2.99*4, agreement.finalCharge, 0.01);
        System.out.println("Rental Agreement:");
        agreement.printAgreement();
    }

    @Test
    // test 5
    public void testJackHammer2() {
        // 9 days of charge for jackhammer, not charged on weekends or holidays
        // July 2-July 10, minus 2 days of holidays. 7 days of charge
        // $2.99*7 = $20.93
        // 0 percent discount = 0
        // final amount should be 40-0 = 40
        Tool tool = new Jackhammer("JAKD", "DeWalt");
        LocalDate checkoutDate = LocalDate.of(2015, Month.JULY, 2);
        Checkout checkout = new Checkout(tool, 9, 0, checkoutDate);

        RentalAgreement agreement = checkout.processCheckout();

        assertEquals(2.99*7, agreement.finalCharge, 0.01);
        System.out.println("Rental Agreement:");
        agreement.printAgreement();
    }

    @Test
    // test 6
    public void testJackHammer3() {
        // 4 days of charge for jackhammer, not charged on weekends or holidays
        // July 2-July 6, minus 2 days of holidays. 2 days of charge
        // $2.99*2 = $5,98
        // 0 percent discount = 0
        // final amount should be 5.98-0 = 5.98
        Tool tool = new Jackhammer("JAKR", "Ridgit");
        LocalDate checkoutDate = LocalDate.of(2020, Month.JULY, 2); // Independence Day observed
        Checkout checkout = new Checkout(tool, 4, 50, checkoutDate);
        RentalAgreement agreement = checkout.processCheckout();

        assertEquals("JAKR", agreement.toolCode);
        assertEquals(3 * 2 * 0.5, agreement.finalCharge, 0.01); // Only 2 charge days because of holiday
        System.out.println("Holiday Rental Agreement:");
        agreement.printAgreement();
    }

    // Test for invalid rental days (less than 1)
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRentalDays() {
        Tool tool = new Ladder("LADW", "Werner");
        LocalDate checkoutDate = LocalDate.of(2020, Month.JULY, 2);
        // This should throw an IllegalArgumentException because rental days are less than 1
        new Checkout(tool, 0, 10, checkoutDate);
    }
}