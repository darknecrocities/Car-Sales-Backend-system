import java.util.Scanner;

public class CarSalesProgram {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CarSalesClass carSales = new CarSalesClass(scanner);
            carSales.startSales();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}