import java.util.ArrayList;

public class Donator extends User
{
    //Variable
    static boolean found;
    private ArrayList<Offer> Offers = new ArrayList<Offer>();
    //Con
    public Donator(String Name,int Id) {
        super(Name,Id);
        this.Offers = new ArrayList<Offer>();
    }
    //Methods
    public ArrayList<Offer> getOffers() {
        return this.Offers;
    }
    public void showcaseOffers() {
        for(int i=0;i<Offers.size();i++) {
            System.out.println(Offers.get(i).getEName());
        }
    }
    public void addtoOffer(Offer Of) {
        found = false;
        //System.out.println("Hello");
        for(int i=0;i<Offers.size();i++) {
            if (Offers.get(i).getEId()==Of.getEId()) {
                this.Offers.get(i).setQuantity(Offers.get(i).getQuantity()+Of.getQuantity());found=true;//System.out.println("Hello");
            }
        }
        if (found == false){
            this.Offers.add(Of);
        }
    }
    public void clearOffers() {
        this.Offers.clear();
    }
    public void deleteOffer(Offer f) {
        this.Offers.remove(f);
    }
    
}
