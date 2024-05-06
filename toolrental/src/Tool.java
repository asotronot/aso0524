public class Tool {
    private String toolCode;
    private String toolType;
    private String toolBrand;
    private double dailyRentalCharge;
    private boolean isWeekday;
    private boolean isWeekend;
    private boolean isHoliday;

    public Tool(String toolCode, String toolType, String toolBrand, double dailyRentalCharge, boolean isWeekday, boolean isWeekend, boolean isHoliday) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
        this.dailyRentalCharge = dailyRentalCharge;
        this.isWeekday = isWeekday;
        this.isWeekend = isWeekend;
        this.isHoliday = isHoliday;
    }

    public String getToolCode() {
        return toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public double getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public boolean isWeekday() {
        return isWeekday;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public boolean isHoliday() {
        return isHoliday;
    }
}