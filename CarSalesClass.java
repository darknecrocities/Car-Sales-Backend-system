
import java.util.Scanner;
import java.util.InputMismatchException;

public class CarSalesClass {
    private Scanner scanner;
    private String[][][] availableCars;
    private int[][][] prices;
    private String[][][] plateNumbers;
    private String[][][] serialNumbers;

    public CarSalesClass(Scanner scanner) {
        this.scanner = scanner;
        initializeData();
    }
    //format brand to availablecars,plate and serial numbers is {{Toyota},{Honda},{Nissan},{Mitsubishi},{Mazda}}
    private void initializeData() {
        availableCars = new String[][][]{
            {{"Innova", "Rush", "Fortuner"}, {"HR-V", "Pilot", "CR-V"}, {"Juke", "Terra", "Patrol"}, {"Montero", "Outlander", "Pajero"}, {"CX-90", "CX-70", "CX-5"}},// for SUV
            {{"Vios", "Camry", "Corrola"}, {"City", "Civic", "Accord"}, {"Versa", "Sentra", "Almera"}, {"Lancer", "Lancer Evolution", "Mirage"}, {"Mazda3", "Mazda6", "Mazda 2"}},//For sedan
            {{"Hilux","Hilux GR-Sport","Hilux Conquest"}, {"Ridgeline", "Black Edition Ridgeline","Ridgeline SportCab"}, {"Navarra", "Frontier", "Titan"}, {"Strada", "Trident", "Mighty Max"}, {"BT-50","B-Series","BT-50(2nd Gen)"}} //for pickup
        };
        prices = new int[][][]{
            {{20000, 25000, 30000}, {22000, 27000, 32000}, {21000, 26000, 31000}, {23000, 28000, 33000}, {24000, 29000, 34000}},// for suv
            {{10000, 15000, 20000}, {12000, 17000, 22000}, {11000, 16000, 21000}, {13000, 18000, 23000}, {14000, 19000, 24000}},// for sedan
            {{60000, 70000, 80000}, {22000, 55000, 66000}, {39000, 78000, 89000}, {13000, 18000, 23000}, {14000, 19000, 24000}}// for pickup
        };
        plateNumbers = new String[][][]{
            {{"ABC123", "DEF456", "GHI789"}, {"JKL012", "MNO345", "PQR678"}, {"STU901", "VWX234", "YZA567"}, {"BCD890", "EFG123", "HIJ456"}, {"KLM789", "NOP012", "QRS345"}},// for suv
            {{"ZYX987", "WVU654", "TSR321"}, {"QPO987", "NML654", "KJI321"}, {"FED987", "CBA654", "GFE321"}, {"JHG987", "MNO654", "PQR321"}, {"WVU987", "XWY654", "VUT321"}},//for sedan
            {{"NGRX987", "NCR567", "NGR123"}, {"ASA2717", "FG7685", "HJK879"}, {"FED987", "CBA654", "GFE321"}, {"JHG987", "MNO654", "PQR321"}, {"WVU987", "XWY654", "VUT321"}}//for pickup
        };
        serialNumbers = new String[][][]{
            {{"T001", "T002", "T003"}, {"H001", "H002", "H003"}, {"N001", "N002", "N003"}, {"M001", "M002", "M003"}, {"Z001", "Z002", "Z003"}},// for suv
            {{"A001", "A002", "A003"}, {"B001", "B002", "B003"}, {"C001", "C002", "C003"}, {"D001", "D002", "D003"}, {"E001", "E002", "E003"}},// for sedan
            {{"A001", "A002", "A003"}, {"B001", "B002", "B003"}, {"C001", "C002", "C003"}, {"D001", "D002", "D003"}, {"E001", "E002", "E003"}}// for pickup
        };
    }

    public void startSales() {
        boolean continueTransaction = true;

        while (continueTransaction) {
            int carTypeChoice = 0;

            System.out.println("[---Welcome to District Wheels!---]");
            System.out.println("Are you interested in a new car or a used car?");
            System.out.println("1. New car");
            System.out.println("2. Used car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                carTypeChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume invalid input
                continue;
            }

            switch (carTypeChoice) {
                case 1:
                case 2:
                    chooseCarType(carTypeChoice);
                    break;
                case 3:
                    continueTransaction = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        System.out.println("Thank you for using District Wheels!");
    }

    private void chooseCarType(int carTypeChoice) {
        boolean back = false;

        while (!back) {
            System.out.println("\nWhat type of car are you looking for?");
            System.out.println("[1]\tSUV");
            System.out.println("[2]\tSedan");
            System.out.println("[3]\tPickup");
            System.out.println("[4]\tBack");
            System.out.print("Enter your choice: ");
            int carType = 0;

            try {
                carType = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume invalid input
                continue;
            }

            switch (carType) {
                case 1:
                case 2:
                case 3:
                    chooseBrand(carTypeChoice, carType);
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void chooseBrand(int carTypeChoice, int carType) {
        boolean back = false;

        while (!back) {
            System.out.println("\nSelect the brand of car:");
            System.out.println("[1]\tToyota");
            System.out.println("[2]\tHonda");
            System.out.println("[3]\tNissan");
            System.out.println("[4]\tMitsubishi");
            System.out.println("[5]\tMazda");
            System.out.println("[6]\tBack");
            System.out.print("Enter your choice: ");
            int brandChoice = 0;

            try {
                brandChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume invalid input
                continue;
            }

            switch (brandChoice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    displayCars(carTypeChoice, carType, brandChoice);
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void displayCars(int carTypeChoice, int carType, int brandChoice) {
        String[] brandAvailableCars = availableCars[carType - 1][brandChoice - 1];
        int[] brandPrices = prices[carType - 1][brandChoice - 1];
        String[] brandPlateNumbers = plateNumbers[carType - 1][brandChoice - 1];
        String[] brandSerialNumbers = serialNumbers[carType - 1][brandChoice - 1];

        System.out.println("\nAvailable cars for the selected brand:");
        for (int i = 0; i < brandAvailableCars.length; i++) {
            System.out.println((i + 1) + ". " + brandAvailableCars[i] + " - $" + brandPrices[i] + " - Plate: " + brandPlateNumbers[i] + " - Serial: " + brandSerialNumbers[i]);
        }
        chooseCar(carTypeChoice, carType, brandAvailableCars, brandPrices, brandPlateNumbers, brandSerialNumbers, brandChoice);
    }
    
    private void chooseCar(int carTypeChoice, int carType, String[] availableCars, int[] prices, String[] plateNumbers, String[] serialNumbers, int brandChoice) {
        int carChoice = 0;
        boolean validPayment = false;
    
        while (!validPayment) {
            System.out.println("\n[CAR PRICE]");
            System.out.println("Choose a car (enter the corresponding number): ");
            for (int i = 0; i < availableCars.length; i++) {
                System.out.println("[" + (i + 1) + "] " + availableCars[i] + " - $" + prices[i] + " - Plate: " + plateNumbers[i] + " - Serial: " + serialNumbers[i]);
            }
    
            System.out.print("Enter your choice: ");
            try {
                carChoice = scanner.nextInt();
                if (carChoice < 1 || carChoice > availableCars.length) {
                    throw new IllegalArgumentException("Invalid choice. Please enter a number between 1 and " + availableCars.length);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume invalid input
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
    
            System.out.println("\n[MODE OF PAYMENT]");
            System.out.println("How would you like to pay?");
            System.out.println("1. Cash");
            System.out.println("2. Credit");
            System.out.print("Enter your choice: ");
            int paymentMethodChoice = 0;
    
            try {
                paymentMethodChoice = scanner.nextInt();
                if (paymentMethodChoice != 1 && paymentMethodChoice != 2) {
                    throw new IllegalArgumentException("Invalid choice. Please select either 1 for cash or 2 for credit.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume invalid input
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
    
            if (paymentMethodChoice == 1) {
                try {
                    System.out.print("Enter your payment amount: ₱");
                    int paymentAmount = scanner.nextInt();
    
                    if (paymentAmount < prices[carChoice - 1]) {
                        throw new IllegalArgumentException("Insufficient payment. Please enter an amount equal to or greater than the car price.");
                    }
                    validPayment = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Consume invalid input
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (paymentMethodChoice == 2) {
                System.out.println("You've chosen to pay by credit.");
    
                try {
                    System.out.println("\nChoose a payment plan:");
                    System.out.println("1. 12 months");
                    System.out.println("2. 24 months");
                    System.out.println("3. 36 months");
                    System.out.print("Enter your choice: ");
                    int paymentPlanChoice = scanner.nextInt();
    
                    if (paymentPlanChoice < 1 || paymentPlanChoice > 3) {
                        throw new IllegalArgumentException("Invalid choice. Please select a valid payment plan.");
                    }
    
                    int months = (paymentPlanChoice == 1) ? 12 : (paymentPlanChoice == 2) ? 24 : 36;
                    double annualInterestRate = 0.08; // 8% annual interest rate
                    double monthlyInterestRate = annualInterestRate / 12;
                    double totalAmount = prices[carChoice - 1];
                    double installment = (totalAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -months));
    
                    System.out.printf("Your monthly installment for %d months will be: $%.2f%n", months, installment);
                    validPayment = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Consume invalid input
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    
        scanner.nextLine(); // Consume newline left-over
    
        System.out.println("\n[------APPLICATION FORM------]");
        String name = "";
        String phoneNumber = "";
        String email = "";
    
        try { // Exception Handling for possible input errors
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
    
            do {
                System.out.print("Enter your phone number (11 digits): ");
                phoneNumber = scanner.nextLine();
            } while (phoneNumber.length() != 11); // validating for 11 digits cp number
    
            boolean validEmail = false;
            do {
                System.out.print("Enter your email (email address): ");
                email = scanner.nextLine();
                if (email.contains("@") && email.contains(".com")) { // decision statement if the email has @ and .com to ensure user has input email
                    validEmail = true;
                } else {
                    System.out.println("Invalid email format. Please enter a valid Gmail address.");
                }
            } while (!validEmail);
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    
        System.out.println("\n[------RECEIPT------]");
        System.out.println("\nThank you for your purchase!");
        System.out.println("Customer Information:");
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Car Details:");
        System.out.println("Type: " + (carType == 1 ? "SUV" : (carType == 2 ? "Sedan" : "Pickup")));
        System.out.println("Brand: " + getBrandName(carTypeChoice));
        System.out.println("Car Model: " + availableCars[carChoice - 1]);
        System.out.println("Price: ₱" + prices[carChoice - 1]);
        System.out.println("Plate Number: " + plateNumbers[carChoice - 1]); // Include plate number
        System.out.println("Serial Number: " + serialNumbers[carChoice - 1]); // Include serial number
    
        System.out.print("\nWould you like another transaction? (y/n): ");// go backj to main menyu
        String anotherTransaction = scanner.next();
        if (!anotherTransaction.equalsIgnoreCase("n")) {
            startSales(); // Return from the method, effectively ending the current transaction
        } else {
            System.out.println("Thanks for using our program!");
            System.exit(0); // end program
        }
    }
    
    private String getBrandName(int choice) {
        switch (choice) {
            case 1:
                return "New Car";
            case 2:
                return "Used Car";
            default:
                return "Unknown";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarSalesClass carSales = new CarSalesClass(scanner);
        carSales.startSales();
    }
}
