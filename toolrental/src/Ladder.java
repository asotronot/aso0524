public class Ladder extends Tool{

    public Ladder(String toolCode, String toolBrand) {
        super(toolCode, new ToolType("Ladder", 1.99, true, true, false), toolBrand);
    }
}
