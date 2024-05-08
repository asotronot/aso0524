public class Jackhammer extends Tool{

    public Jackhammer(String toolCode, String toolBrand) {
        super(toolCode, new ToolType("Jackhammer", 2.99, true, false, false), toolBrand);
    }
}
