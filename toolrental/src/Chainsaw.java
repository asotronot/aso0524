public class Chainsaw extends Tool{

    public Chainsaw(String toolCode, String toolBrand) {
        super(toolCode, new ToolType("Chainsaw", 1.49, true, false, true), toolBrand);
    }
}
