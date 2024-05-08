public class ToolType {
    private String toolType;
    private double dailyRentalCharge;
    private boolean isChargedOnWeekday;
    private boolean isChargedOnWeekend;
    private boolean isChargedOnHoliday;

    public ToolType (String toolType, double dailyRentalCharge, boolean isChargedOnWeekday, boolean isChargedOnWeekend, boolean isChargedOnHoliday) {
        this.toolType = toolType;
        this.dailyRentalCharge = dailyRentalCharge;
        this.isChargedOnWeekday = isChargedOnWeekday;
        this.isChargedOnWeekend = isChargedOnWeekend;
        this.isChargedOnHoliday = isChargedOnHoliday;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public double getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public void setDailyRentalCharge(double dailyRentalCharge) {
        this.dailyRentalCharge = dailyRentalCharge;
    }

    public boolean isChargedOnWeekend() {
        return isChargedOnWeekend;
    }

    public void setWeekend(boolean weekend) {
        isChargedOnWeekend = weekend;
    }

    public boolean isChargedOnWeekday() {
        return isChargedOnWeekday;
    }

    public void setWeekday(boolean weekday) {
        isChargedOnWeekday = weekday;
    }

    public boolean isChargedOnHoliday() {
        return isChargedOnHoliday;
    }

    public void setHoliday(boolean holiday) {
        isChargedOnHoliday = holiday;
    }
}
