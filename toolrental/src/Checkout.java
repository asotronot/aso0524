import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class Checkout {
    private Tool tool;
    private int numberOfRentalDays;
    private int discountPercent;
    private LocalDate checkoutDate;

    private final int HUNDRED = 100;

    public Checkout(Tool tool, int numberOfRentalDays, int discountPercent, LocalDate checkoutDate) {
        if (numberOfRentalDays < 1) {
            throw new IllegalArgumentException("Invalid rental day. At least 1 day is required of rental process");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Invalid discount rate, specified value must be between 0 and 100 percent");
        }
        this.tool = tool;
        this.numberOfRentalDays = numberOfRentalDays;
        this.discountPercent = discountPercent;
        this.checkoutDate = checkoutDate;
    }

    public RentalAgreement processCheckout() {
        int chargeDays = countDaysOfRentalCharge(checkoutDate, numberOfRentalDays, tool);
        double preDiscountCharge = chargeDays * tool.getDailyRentalCharge();
        double discountAmount = preDiscountCharge * discountPercent / HUNDRED;
        double finalCharge = preDiscountCharge - discountAmount;

        return new RentalAgreement(
                tool.getToolCode(),
                tool.getToolType(),
                tool.getToolBrand(),
                numberOfRentalDays,
                checkoutDate,
                tool.getDailyRentalCharge(),
                chargeDays,
                preDiscountCharge,
                discountPercent,
                discountAmount,
                finalCharge
        );
    }

    private int countDaysOfRentalCharge(LocalDate startDate, int rentalDays, Tool tool) {
        int days = 0;
        LocalDate date = startDate;
        for (int i = 0; i < rentalDays; i++) {
            if (isChargeableDay(date, tool)) {
                days++;
            }
            date = date.plusDays(1);
        }
        return days;
    }

    private boolean isChargeableDay(LocalDate date, Tool tool) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        boolean isWeekend = dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        boolean isHoliday = isHoliday(date);

        if (!tool.isHoliday() && isHoliday && isWeekend) {
            return false;
        }
        else if (!tool.isWeekend() && isWeekend && isHoliday) {
            return false;
        }
        else {
            return (tool.isWeekday() && !isWeekend) ||
                    (tool.isWeekend() && isWeekend) ||
                    (tool.isHoliday() && isHoliday);
        }
    }


    private boolean isHoliday(LocalDate date) {
        if (isIndependenceDayOrObservedIndependenceDay(date)) {
            return true;
        }
        // labor day.
        else return date.getMonth() == Month.SEPTEMBER && date.getDayOfWeek() == DayOfWeek.MONDAY &&
                    date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)).equals(date);
    }

    private boolean isIndependenceDayOrObservedIndependenceDay(LocalDate date) {
        return date.getMonth() == Month.JULY && date.getDayOfMonth() == 4
                ||
                date.getMonth() == Month.JULY &&
                        (date.getDayOfWeek() == DayOfWeek.MONDAY
                                || date.getDayOfWeek() == DayOfWeek.FRIDAY) &&
                        date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)).equals(date);
    }
}