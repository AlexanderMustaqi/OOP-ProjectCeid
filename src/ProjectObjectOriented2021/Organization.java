import java.util.ArrayList;
import java.util.Scanner;

public class Organization
{
    //Variable
    static int foundAt;
    private String name;
    private Admin ad = new Admin("",0);
    private ArrayList<RequestDonation> Stock = new ArrayList<RequestDonation>();
    private ArrayList<Donator> DonList = new ArrayList<Donator>();
    private ArrayList<Beneficiary> BenList = new ArrayList<Beneficiary>();
    private ArrayList<Entity> EnList = new ArrayList<Entity>();
    Scanner sc = new Scanner(System.in);
    //Con
    public Organization(String Name ,Admin ad) {
        this.name = Name;
        this.ad = ad;
        this.Stock = new ArrayList<RequestDonation>();
        this.DonList = new ArrayList<Donator>();
        this.BenList = new ArrayList<Beneficiary>();
        this.EnList = new ArrayList<Entity>();
    }
    //Methods
    //Methods to access the 3 lists we have and methods so we have get an orderly list of each of them
    public Admin getAdmin() {return this.ad;}
    public void addDon(Donator D) {this.DonList.add(D);}
    public void addBen(Beneficiary B) {this.BenList.add(B);}
    
    public ArrayList<Entity> getEnList() {return this.EnList;}
    public void addEn(Entity E) {
        EnList.add(E);
    }
    public void showcaseEnList() {
        for(int i=0;i<this.EnList.size();i++) {
            System.out.println((i+1)+"."+EnList.get(i).getName()+" "+EnList.get(i).getId()+" "+EnList.get(i).getDetails());
        }
    }
    public ArrayList<RequestDonation> getStock() {return this.Stock;}
    public void ListStock() {
        for(int i=0;i<Stock.size();i++) {
            System.out.println((i+1)+" "+Stock.get(i).getEName()+" "+Stock.get(i).getEId()+" "+Stock.get(i).getEn().getDetails()+" "+Stock.get(i).getQuantity());
        }
    }
    
    public ArrayList<Donator> getDons() {return this.DonList;}
    public void ListDons() {
        for(int i=0;i<DonList.size();i++) {System.out.println((i+1)+" "+DonList.get(i).getName()+" "+DonList.get(i).getId());}
    }
    
    public ArrayList<Beneficiary> getBens() {return this.BenList;}
    public void ListBens() {
        for(int i=0;i<BenList.size();i++) {System.out.println((i+1)+" "+BenList.get(i).getName()+" "+BenList.get(i).getId());}
    }
    //Method for adding a Donator's Offer
    public void AddOffer(Offer Of) {
        boolean found=false;
        for (int i=0;i<this.Stock.size();i++) {
            if (Stock.get(i).getEId()==Of.getEId()) {
                found =true;foundAt=i;
            }
        }
        if (found==true) {
            Stock.get(foundAt).setQuantity(Stock.get(foundAt).getQuantity()+Of.getQuantity());
        }
        else {Stock.add(Of);}
    }
    //Method to commit a beneficiary's Request
    public void CommitRequest(Request R) {
        for (int i=0;i<Stock.size();i++) {
            if (Stock.get(i).getEId()==R.getEId()) {
                if (Stock.get(i).getQuantity() > R.getQuantity()) {
                    Stock.get(i).setQuantity(Stock.get(i).getQuantity()-R.getQuantity());
                }
                else if (Stock.get(i).getQuantity() == R.getQuantity()) {
                    Stock.remove(i);
                }
                else {
                    System.out.println("Sorry sir , but the requested amount is not available to the organization ");
                }
            }
        }
    }
    //Method to change an entity's quantity in stock
    public void modifyQuantity(int Id,double q) {
        for(int i=0;i<Stock.size();i++) {
            if (Stock.get(i).getEId()==Id) {
                Stock.get(i).setQuantity(q);
            }
        }
    }
    //Method to remove Beneficiary
    public void removeBen(int Id) {
        for(int i=0;i<BenList.size();i++) {
            if (BenList.get(i).getId()==Id) {
                BenList.remove(i);
            }
        }
    }
    //Method to remove Donator
    public void removeDon(int Id) {
        for (int i=0;i<DonList.size();i++) {
            if (DonList.get(i).getId()==Id) {
                DonList.remove(i);
            }
        }
    }
}

