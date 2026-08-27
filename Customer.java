public class Customer{
    private int customerId;
    private String name;
    private int phone;
    private String address;


    Customer(int customerId,String name, int phone, String address){
        this.customerId=customerId;
        this.name=name;
        this.phone=phone;
        this.address=address;
    }

    @Override
    public String toString(){
        return "Customer_Id:"+customerId+" "+"Name:"+name+" "+"Phone_No:"+phone+" "
        +"Address:"+address;
      
    }

    public int getCustomerId(){
        return customerId;
    }

    public String getName(){
        return name;
    }

    public int getPhone(){
        return phone;
    }

    public String getAddress(){
        return address;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setPhone(int phone){
        this.phone=phone;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public void displayDetails(){
        System.out.println("CustomerId:"+" "+customerId);
        System.out.println("Name:"+" "+name);
        System.out.println("Phone:"+" "+phone);
        System.out.println("Address:"+" "+address);


    }


}
