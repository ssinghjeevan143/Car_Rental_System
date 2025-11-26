package car_rental_system;

public class customer {
    private String customer_name;

    private String customer_id;

    private int phone_no;

    public customer(String customer_name, String customer_id,int phone_no){
        this.customer_name = customer_name;
        this.customer_id = customer_id;
        this.phone_no = phone_no;
    }

    public String get_Customer_name(){
        return customer_name;
    }
    public String get_customer_id(){
        return customer_id;
    }
    public int get_Phone_no(){
        return phone_no;
    }
}
