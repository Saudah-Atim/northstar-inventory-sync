FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY WarehouseAPI.java .
COPY InventoryWebhook.java .

RUN javac InventoryWebhook.java WarehouseAPI.java

EXPOSE 8080

CMD ["java", "InventoryWebhook"]