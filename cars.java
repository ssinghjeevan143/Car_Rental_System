package car_rental_system;

public class cars {
    private String car_id;

    private String car_model;

    private String car_brand;

    private int per_day_price;

    private boolean isAvailable;

    //creating a constructor
    public cars(String car_id, String car_model, String car_brand, int per_day_price ){
        this.car_id = car_id;
        this.car_model = car_model;
        this.car_brand = car_brand;
        this.per_day_price = per_day_price;
        this.isAvailable = true;

    }

    public String getCar_id() {
        return car_id;
    }


    public String getCar_model() {
        return car_model;
    }


    public String getCar_brand() {
        return car_brand;
    }


//    public int getPer_day_price() {
//        return per_day_price;
//    }

    public boolean isAvailable() {
        return isAvailable;
    }

// to rent a car
    public void rent(){
        isAvailable = false;
    }

    // to return a car
    public void return_car(){
        isAvailable = true;
    }

    // to calculate the price
    public double calculate_price(int rentaldays){
        return per_day_price * rentaldays;
    }

}
