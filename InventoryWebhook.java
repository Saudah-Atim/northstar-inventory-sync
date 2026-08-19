class InventoryWebhook {
  public void handleInventoryUpdate(String productId, String productName, int newQuantity) {
    System.out.println("Inventory update received for product: " + productId
        + " (" + productName + ") with new quantity: " + newQuantity);
  }

  public static void main(String[] args) {
    InventoryWebhook inventory = new InventoryWebhook();

    inventory.handleInventoryUpdate("LAP001", "Laptops", 15);
    inventory.handleInventoryUpdate("HED001", "Headphones", 40);
    inventory.handleInventoryUpdate("MAK001", "Makeup Kits", 25);
    inventory.handleInventoryUpdate("BAR001", "Barbie Dolls", 30);
  }
}