package car_rental_system;

public class main {
    public static void main(String[] args) {
        car_rent_management rentalSystem = new car_rent_management();

        cars car1 = new cars("C001", "CAMRY", "TOYOTA", 60);
        cars car2 = new cars("C002", "ACCORD", "HONDA", 70);
        cars car3 = new cars("C003", "THAR", "MAHINDRA", 80);
        cars car4 = new cars("C004", "SCORPIO", "MAHINDRA", 90);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.menu();



    }

}
