import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class RentalAgreement {
    public String toolCode;
    public String toolType;
    public String toolBrand;
    public int rentalDays;
    public LocalDate checkoutDate;
    public LocalDate dueDate;
    public double dailyRentalCharge;
    public int chargeDays;
    public double preDiscountCharge;
    public int discountPercent;
    public double discountAmount;
    public double finalCharge;

    public RentalAgreement(String toolCode,
                           String toolType,
                           String toolBrand,
                           int rentalDays,
                           LocalDate checkoutDate,
                           double dailyRentalCharge,
                           int chargeDays,
                           double preDiscountCharge,
                           int discountPercent,
                           double discountAmount,
                           double finalCharge) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = checkoutDate.plusDays(rentalDays);
        this.dailyRentalCharge = dailyRentalCharge;
        this.chargeDays = chargeDays;
        this.preDiscountCharge = preDiscountCharge;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }


    public void printAgreement() {
        System.out.println("Tool code: " + toolCode);
        System.out.println("Tool type: " + toolType);
        System.out.println("Brand: " + toolBrand);
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Check out date: " + checkoutDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
        System.out.println("Due date: " + dueDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
        System.out.println("Daily rental charge: $" + String.format("%.2f", dailyRentalCharge)); // 2 decimal points
        System.out.println("Charge days: " + chargeDays);
        System.out.println("Pre-discount charge: $" + String.format("%.2f", preDiscountCharge)); // 2 decimal points
        System.out.println("Discount percent: " + discountPercent + "%");
        System.out.println("Discount amount: $" + String.format("%.2f", discountAmount));
        System.out.println("Final charge: $" + String.format("%.2f", finalCharge));
    }
}