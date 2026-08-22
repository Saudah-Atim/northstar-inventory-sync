import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

class InventoryWebhook {

    public static void main(String[] args) throws IOException {

        int port = Integer.parseInt(
                System.getenv().getOrDefault("PORT", "8080")
        );

        HttpServer server = HttpServer.create(
                new InetSocketAddress("0.0.0.0", port), 0
        );

        // Main page showing all products
        server.createContext("/", (HttpExchange exchange) -> {

            String response =
                    "NORTHSTAR INVENTORY SYNC\n\n" +
                    "LAP001 - Laptops\n" +
                    "Available stock: " + WarehouseAPI.getStock("LAP001") + "\n\n" +
                    "HED001 - Headphones\n" +
                    "Available stock: " + WarehouseAPI.getStock("HED001") + "\n\n" +
                    "MAK001 - Makeup Kits\n" +
                    "Available stock: " + WarehouseAPI.getStock("MAK001") + "\n\n" +
                    "BAR001 - Barbie Dolls\n" +
                    "Available stock: " + WarehouseAPI.getStock("BAR001") + "\n";

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.close();
        });

        // Individual product stock lookup
        server.createContext("/stock", (HttpExchange exchange) -> {

            String path = exchange.getRequestURI().getPath();
            String productId = path.substring("/stock/".length());

            int stock = WarehouseAPI.getStock(productId);

            String productName;

            if (productId.equals("LAP001")) {
                productName = "Laptops";
            } else if (productId.equals("HED001")) {
                productName = "Headphones";
            } else if (productId.equals("MAK001")) {
                productName = "Makeup Kits";
            } else if (productId.equals("BAR001")) {
                productName = "Barbie Dolls";
            } else {
                productName = "Unknown Product";
            }

            String response;

            if (stock > 0) {
                response = productId + " - " + productName
                        + "\nAvailable stock: " + stock
                        + "\nStatus: IN STOCK";
            } else {
                response = productId + " - " + productName
                        + "\nAvailable stock: 0"
                        + "\nStatus: OUT OF STOCK";
            }

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.close();
        });

        server.start();

        System.out.println("Northstar Inventory Sync is LIVE!");
        System.out.println("Open http://localhost:" + port);
    }
}