
public class Service extends Entity
{
    //Variable
    //Con
    public Service(String Name,int Id,String Description) {super(Name,Id,Description);}
    //Methods
    public double getlevel1() {System.out.println("This is service! It doesnt contain any levels!" );return 0;}
    public double getlevel2() {System.out.println("This is service! It doesnt contain any levels!" );return 0;}
    public double getlevel3() {System.out.println("This is service! It doesnt contain any levels!" );return 0;}
    public String getDetails() {return "Service";}
}
