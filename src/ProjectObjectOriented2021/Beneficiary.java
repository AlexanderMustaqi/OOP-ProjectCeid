import java.util.ArrayList;

public class Beneficiary extends User
{
    //Variables
    
    static boolean found;
    private int noPeople;
    private ArrayList<Request> RequestList = new ArrayList<Request>();
    private ArrayList<Request> ReceivedList = new ArrayList<Request>();
    //Con
    public Beneficiary(String Name,int Id,int noPeople) {
        super(Name,Id);
        this.noPeople = noPeople;
        this.RequestList = new ArrayList<Request>();
        this.ReceivedList = new ArrayList<Request>();
    }
    //Methods
    public int getnoPeople() {return this.noPeople;}
    public ArrayList<Request> getRequestList() {return this.RequestList;}
    public ArrayList<Request> getReceivedList() {return this.ReceivedList;}
    public void showcaseReceivedList() {
        for (int i=0;i<ReceivedList.size();i++) {
            System.out.println(ReceivedList.get(i).getEName());
        }
    }
    public void showcaseRequestList() {
        for (int i=0;i<RequestList.size();i++) {
            System.out.println(RequestList.get(i).getEName()+" "+RequestList.get(i).getEId()+" "+RequestList.get(i).getQuantity());
        }
    }
    
    public void clearRequestList() {
        this.RequestList.clear();
    }
    public void clearReceivedList() {
        this.ReceivedList.clear();
    }
    public void addRequest(Request R) {
        found = false;
        for(int i=0;i<RequestList.size();i++) {
            if (RequestList.get(i).getEId()==R.getEId()) {
                this.RequestList.get(i).setQuantity(RequestList.get(i).getQuantity()+R.getQuantity());found=true;
            }
        }
        if (found == false){
            this.RequestList.add(R); //System.out.println("Hello");
        }
        //this.RequestList.add(R);
    }
}
