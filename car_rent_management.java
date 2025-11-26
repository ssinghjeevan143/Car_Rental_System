package car_rental_system;
import java.util.*;
import java.util.ArrayList;

public class car_rent_management {
    //stores list of cars
    private ArrayList <cars> car_list;
    //stores list of customers
    private ArrayList<customer> customer_list;
    //stores list of cars which are on rent
    private ArrayList<rental> rental_car_list;
    private Scanner Sc;

    public car_rent_management(){
        car_list = new ArrayList<>();
        customer_list = new ArrayList<>();
        rental_car_list = new ArrayList<>();

    }

    // ADDING CAR INTO THE CAR LIST

    public void addCar(cars car){
        car_list.add(car);
    }

    //ADDING CUSTOMER INTO THE CUSTOMER_LIST
    public void addCustomer(customer customer){
        customer_list.add(customer);
    }

    public void rentCar(cars car, customer customer, int days){
        if(car.isAvailable()){
            car.rent();
            rental_car_list.add(new rental(car,customer,days));
        }
        else{
            System.out.println("car is not available for rent. ");
        }
    }

    public void returnCar(cars car){
        //car.return_car();
        rental rental_to_remove = null;
        for(rental rental : rental_car_list){
            if(rental.getCar() == car){
                rental_to_remove = rental;
                break;
            }
        }
        if(rental_to_remove != null){
            rental_car_list.remove(rental_to_remove);
            System.out.println("car returned successfully");
        }else{
            System.out.println("car was not on rented");
        }
        car.return_car();
    }
    public void menu(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("====================  WELCOME TO CAR RENTAL SYSTEM  ====================");
            System.out.println("1. Rent a car ");
            System.out.println("2. Return a car ");
            System.out.println("3. Exit ");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1) {
                System.out.println("\n== Rent a car ==\n");
                System.out.println("Enter your name : ");
                String Name = sc.nextLine();

                System.out.println("\n Available Cars : ");
                for (cars car : car_list) {
                    if (car.isAvailable()) {
                        System.out.println(car.getCar_id() + " - " + car.getCar_brand() + "," + car.getCar_model());
                    }
                }
            
                System.out.println("\n Enter the car id you want to rent : ");
                String car_id = sc.nextLine();
    
                System.out.print("Enter the no of days you want to rent : ");
                int rentaldays = sc.nextInt();
                sc.nextLine();
    
                customer new_customer = new customer(Name, "C101"+(customer_list.size()+1),957267966);
                addCustomer(new_customer);

                cars selectedCar = null;
                for(cars car : car_list){
                    if(car.getCar_id().equals(car_id) && car.isAvailable()){
                        selectedCar = car;
                        break;
                    }
                }

                if(selectedCar != null){
                    double totalprice = selectedCar.calculate_price(rentaldays);
                    System.out.println("\n==========rental information==========\n");
                    System.out.println("customer id : "+ new_customer.get_customer_id());
                    System.out.println("customer name : "+ new_customer.get_Customer_name());
                    System.out.println("customer phone_no : "+ new_customer.get_Phone_no());
                    System.out.println("car : "+ selectedCar.getCar_brand() + " "+ selectedCar.getCar_model());
                    System.out.println("rental days : "+ rentaldays);
                    System.out.println("Total price : "+ totalprice);
    
                    System.out.println("\nconform rental (Y / N ) : ");
                    String conform = sc.nextLine();

                    if(conform.equalsIgnoreCase("Y")){
                        rentCar(selectedCar,new_customer,rentaldays);
                        System.out.println(" car rented successfully.");
                    }else{
                        System.out.println("\n rental canceled.");
                    }
                }else {
                    System.out.println(" Invalid car selection or car not available for rent. ");
                }
            } else if (choice == 2) {
                System.out.println(" === Return a car===");
                System.out.print("Enter the car Id you want to return : ");
                String car_id = sc.nextLine();

                cars car_to_return = null;
                for(cars car : car_list){
                    if(car.getCar_id().equals(car_id) && !car.isAvailable()){
                        car_to_return = car;
                        break;
                    }
                }
                if(car_to_return != null){
                   customer customer = null;
                   for(rental rental : rental_car_list){
                       if(rental.getCar()== car_to_return){
                           customer = rental.getCustomer();
                           break;
                       }
                   }
                   if(customer != null){
                       returnCar(car_to_return);
                       System.out.println("car returned successfully "+ customer.get_Customer_name());
                   }else{
                       System.out.println("car was not rented or rental information is missing");
                   }
                }else{
                    System.out.println("Invalid car id or car is not rented");
                }
            } else if (choice == 3) {
                break;
            }else{
                System.out.println("Invalid choice. Please enter a valid option");
            }

        }
        System.out.println("\nThank you for using the Car Rental System!");
    }
}
