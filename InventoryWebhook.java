class InventoryWebhook {

    InventoryWebhook() {
    }

    public void handleInventoryUpdate(String var1, String var2, int var3) {
        System.out.println("Inventory update received for product: " + var1 + " (" + var2 + ") with new quantity: " + var3);
    }

    public static void main(String[] var0) {

        InventoryWebhook var1 = new InventoryWebhook();

        var1.handleInventoryUpdate("LAP001", "Laptops", 15);
        var1.handleInventoryUpdate("HED001", "Headphones", 40);
        var1.handleInventoryUpdate("MAK001", "Makeup Kits", 25);
        var1.handleInventoryUpdate("BAR001", "Barbie Dolls", 30);

        System.out.println("Warehouse stock:");
        System.out.println("Laptops: " + WarehouseAPI.getStock("LAP001"));
        System.out.println("Headphones: " + WarehouseAPI.getStock("HED001"));
        System.out.println("Makeup Kits: " + WarehouseAPI.getStock("MAK001"));
        System.out.println("Barbie Dolls: " + WarehouseAPI.getStock("BAR001"));
    }
}