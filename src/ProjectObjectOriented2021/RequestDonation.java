
public class RequestDonation
{
    //Variables
    private Entity e;
    private double Quantity;
    //Con
    public RequestDonation(Entity e,double Quantity) {this.e = e;this.Quantity = Quantity;}
    //Methods
    public String getEName() {return this.e.getName();}
    public int getEId() {return this.e.getId();}
    public Entity getEn() {return this.e;}
    public double getQuantity() {return this.Quantity;}
    public void setQuantity(double q) {this.Quantity = q;}
}
