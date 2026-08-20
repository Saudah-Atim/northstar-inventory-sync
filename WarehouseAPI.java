public class WarehouseAPI {

    public static int getStock(String productId) {

        if (productId.equals("LAP001")) {
            return 20;
        }

        if (productId.equals("HED001")) {
            return 55;
        }

        if (productId.equals("MAK001")) {
            return 30;
        }

        if (productId.equals("BAR001")) {
            return 45;
        }

        return 0;
    }
}
    
