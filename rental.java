package car_rental_system;

public class rental {
    private cars car;
    private customer customer;
    private int days;

    public rental(cars car, customer customer, int days){
        this.car = car;
        this.customer = customer;
        this.days = days;
    }


    public cars getCar(){
        return car;
    }
    public customer getCustomer(){
        return customer;
    }
    public int get_Days(){
        return days;
    }
}
