import java.util.Scanner;
import java.util.ArrayList;

public class Menu
{
    //Variables
    static int DonLoc;
    static int BenLoc;
    static int phoneNum;
    static int answer; 
    private Scanner sc = new Scanner(System.in);
    private Admin ad = new Admin("",0);
    private Organization  Org = new Organization("",ad);
    private ArrayList<RequestDonation> SudoArray = new ArrayList<RequestDonation>();
        
    //Con
    public Menu(Organization Org) {
        this.Org=Org;
        SudoArray = Org.getStock();
    }
    //Methods
   public int Start() {
        System.out.println("Please enter your phone number : ");
        phoneNum = sc.nextInt();
        if (phoneNum == Org.getAdmin().getId()) {answer=1;}
        for(int i=0;i<Org.getDons().size();i++) {if (Org.getDons().get(i).getId()==phoneNum) {answer=2;System.out.println("Donator");};}
        for(int i=0;i<Org.getBens().size();i++) {if (Org.getBens().get(i).getId()==phoneNum) {answer=3;System.out.println("Beneficiary");};}
        if (answer == 1) {AdminMenu();}
        if (answer == 2) {DonMenu();}
        if (answer == 3) {BenMenu();}
        else {System.out.println("Please enter a valid option! ");Start();}
        return 0;
    }
    
    
    public int AdminMenu() {
        System.out.println("1.View\n2.Monitor\n3.Back\n4.Logout\n5.Exit");
        answer = sc.nextInt();
        if (answer == 1) {AdminMenu1();}
        if (answer == 2) {AdminMenu2();}
        if (answer == 3) {Start();}
        if (answer == 4) {Start();}
        if (answer == 5) {System.exit(0);}
        else {System.out.println("Please enter a valid option! ");AdminMenu();}
        return 0;
    }
    
    public int AdminMenu1() {
        Org.ListStock();
        System.out.println("Would you like more details on a certain entity ? (1.Yes/2.No) : ");
        answer = sc.nextInt();
        if (answer == 1) {
            System.out.println("Please enter the entity's ID : ");
            int GivenID = sc.nextInt();
            for (int i=0;i<Org.getStock().size();i++) {
                if (Org.getStock().get(i).getEId()==GivenID) {
                    System.out.println(Org.getStock().get(i).getEn().toString());
                    AdminMenu();
                }
            }
        }
        else if (answer == 2) {AdminMenu();}
        else {System.out.println("Please enter a valid answer!");AdminMenu1();}
        return 0;
    }
   
    public int AdminMenu2() {
        System.out.println("1.List Beneficiaries\n2.List Donators\n3.Reset Beneficiaries ReceivedLists\n4.Back");
        answer = sc.nextInt();
        if (answer==1) {AdminMenu2a();}
        if (answer==2) {AdminMenu2b();}
        if (answer==3) {AdminMenu2c();}
        if (answer==4) {AdminMenu();}
        else {System.out.println("Please enter a valid option! ");AdminMenu2();}
        return 0;
    }
    
    public int AdminMenu2a() {
        Org.ListBens();
        System.out.println("1.See their receivedList\n2.Clear their receivedList\n3.Remove them from the BeneficiariesList\n4.Back ");
        int GivenChoice = sc.nextInt();
        if (GivenChoice == 1) {
            System.out.println("Please enter the Id of the Beneficiary that you would like to manage : ");
            int BenID = sc.nextInt();
            for(int i=0;i<Org.getBens().size();i++) {
                if (Org.getBens().get(i).getId()==BenID) {
                    Org.getBens().get(i).showcaseReceivedList();AdminMenu();
                }
            }
        }
        else if (GivenChoice == 2) {
           System.out.println("Please enter the name of the Beneficiary that you would like to manage : ");
           String BenName = sc.nextLine();
           for(int i=0;i<Org.getBens().size();i++) {
                if (Org.getBens().get(i).getName()==BenName) {
                    Org.getBens().get(i).getReceivedList().clear();AdminMenu();
                }
           }
        }
        else if (GivenChoice == 3) {
            System.out.println("Please enter the name of the Beneficiary that you would like to manage : ");
            String BenName = sc.nextLine();
            for(int i=0;i<Org.getBens().size();i++) {
                if (Org.getBens().get(i).getName()==BenName) {
                    Org.getBens().remove(i);AdminMenu();
                }
            }
        }
        else if (GivenChoice == 4) {AdminMenu2();}
        else {
            System.out.println("Please enter a valid option!");
            AdminMenu2a();
        }
        return 0;
    }
    
    public int AdminMenu2b() {
        Org.ListDons();
        System.out.println("Please enter the name of the Donator that you would like to manage : ");
        String DonName = sc.nextLine();
        System.out.println("1.Show Donator's OfferList\n2.Remove Donator from DonatorList\n3.Back");
        int GivenChoice = sc.nextInt();
        if (GivenChoice == 1) {
            for(int i=0;i<Org.getDons().size();i++) {
                if (Org.getDons().get(i).getName()==DonName) {
                    Org.getDons().get(i).showcaseOffers();AdminMenu();
                }
            }
        }
        if (GivenChoice == 2) {
            for(int i=0;i<Org.getDons().size();i++) {
                if (Org.getDons().get(i).getName()==DonName) {
                    Org.getDons().remove(i);AdminMenu();
                }
            }
        }
        if (GivenChoice == 3) {AdminMenu2();}
        else {System.out.println("Please enter a valid option!");AdminMenu2b();}
        return 0;
    }
    
    public int AdminMenu2c() {
        for (int i=0;i<Org.getBens().size();i++) {
            Org.getBens().get(i).clearReceivedList();
        }
        return 0;
    }
    
    
    public int DonMenu() {
        System.out.println("1.Add Offer\n2.Show Offers\n3.Commit\n4.Back\n5.Exit");
        answer = sc.nextInt();
        for (int i=0;i<Org.getDons().size();i++) {
            if (Org.getDons().get(i).getId()==phoneNum) {
                DonLoc = i;
                //System.out.println("Hi");
            }
        }
        if (answer == 1) {DonMenu1();}
        else if (answer == 2) {DonMenu2();}
        else if (answer == 3) {DonMenu3();}
        else if (answer == 4) {Start();}
        else if (answer == 5) {System.exit(0);}
        else {System.out.println("Please enter a valid option");DonMenu();}
        return 0;
    }
    
    public int DonMenu1() {
        Org.showcaseEnList();
        System.out.println("Would you like to add an offer? (1.Yes/2.No) ");
        answer = sc.nextInt();
        if (answer==1) {
            System.out.println("What would you like to add ? (Enter Id And Quantity) ");
            answer = sc.nextInt();
            double newQ = sc.nextDouble();
            for (int i=0;i<Org.getEnList().size();i++) {
                if (Org.getEnList().get(i).getId()==answer) {
                    System.out.println("Is the entity a Material or a Service ? (1.Material/2.Service)");
                    answer = sc.nextInt();
                    if (answer ==1){
                        String Name = Org.getEnList().get(i).getName();
                        int Id = Org.getEnList().get(i).getId();
                        String Desc = Org.getEnList().get(i).getDesc();;
                        double lvl1=Org.getEnList().get(i).getlevel1();
                        double lvl2=Org.getEnList().get(i).getlevel2();
                        double lvl3=Org.getEnList().get(i).getlevel3();
                        Material M = new Material(Name,Id,Desc,lvl1,lvl2,lvl3);
                        Offer f = new Offer(M,newQ);
                        Org.getDons().get(DonLoc).addtoOffer(f);
                        DonMenu();
                    }
                    else if (answer ==2) {
                        String Name = Org.getEnList().get(i).getName();
                        int Id = Org.getEnList().get(i).getId();
                        String Desc = Org.getEnList().get(i).getDesc();
                        Service Ser = new Service(Name,Id,Desc);
                        Offer f = new Offer(Ser,newQ);
                        Org.getDons().get(DonLoc).addtoOffer(f);
                        //System.out.println(Org.getDons().get(DonLoc).getOffers().get(0));
                        DonMenu();
                    }
                    else {
                        System.out.println("Please enter a valid option! ");DonMenu1();
                    }
                }
            }
        }
        if (answer==2) {DonMenu();}
        else {System.out.println("Please enter a valid option");DonMenu1();}
        return 0;
    }
    
    public int DonMenu2() {
        Org.getDons().get(DonLoc).showcaseOffers();
        System.out.println("1.Delete offer/Change Quantity of offer\n2.Clear OfferList\n3.Back");
        answer = sc.nextInt();
        if (answer ==1) {
            System.out.println("Please enter the entity's ID :");
            int entityID = sc.nextInt();
            System.out.println("1.Delete this offer\n2.Change quantity ");
            answer = sc.nextInt();
            if (answer == 1) {
                for (int i=0;i<Org.getDons().get(DonLoc).getOffers().size();i++) {
                    if (Org.getDons().get(DonLoc).getOffers().get(i).getEId()==entityID) {
                        Org.getDons().get(DonLoc).deleteOffer(Org.getDons().get(DonLoc).getOffers().get(i));DonMenu();
                    }
                }
            }
            if (answer == 2) {
                System.out.println("What is the entity's new quantity ? ");
                double newQ = sc.nextDouble();
                for (int i=0;i<Org.getDons().get(DonLoc).getOffers().size();i++) {
                    if (Org.getDons().get(DonLoc).getOffers().get(i).getEId()==entityID) {
                        Org.getDons().get(DonLoc).getOffers().get(i).setQuantity(newQ);DonMenu();
                    }
                }
            }
        } 
        if (answer ==2) {Org.getDons().get(DonLoc).clearOffers();DonMenu();} 
        if (answer ==3) {DonMenu();} 
        return 0;
    }
    
    public int DonMenu3() {
        for (int i=0;i<Org.getDons().get(DonLoc).getOffers().size();i++) {
            Org.AddOffer(Org.getDons().get(DonLoc).getOffers().get(i));
        }
        Org.getDons().get(DonLoc).clearOffers();
        DonMenu();
        return 0;
    }
    
    
    public int BenMenu() {
        System.out.println("1.Add Request\n2.Show Requests\n3.Commit\n4.Back\n5.Exit");
        answer = sc.nextInt();
        for (int i=0;i<Org.getBens().size();i++) {
            if (Org.getBens().get(i).getId()==phoneNum) {
                BenLoc = i;
            }
        }
        if (answer == 1) {BenMenu1();}
        if (answer == 2) {BenMenu2();}
        if (answer == 3) {BenMenu3();}
        if (answer == 4) {Start();}
        if (answer == 5) {System.exit(0);}
        else {System.out.println("Please enter a valid option");DonMenu();}
        return 0;
    }
    
    public int BenMenu1() {
        Org.ListStock();
        System.out.println("Would you like to add a request ? (1.Yes/2.No) ");
        answer = sc.nextInt();
        if (answer==1) {
            System.out.println("What would you like to add ? (1.Material/2.Service) ");
            answer = sc.nextInt();
            if (answer == 1) {
                System.out.println("What is the ID of the desired material? ");
                int entityID = sc.nextInt();
                for (int i=0;i<Org.getStock().size();i++) {
                    if (Org.getStock().get(i).getEId()==entityID) {
                        int noPeople = Org.getBens().get(BenLoc).getnoPeople();
                        if (noPeople == 1) {
                            double level1 = Org.getStock().get(i).getEn().getlevel1();
                            if(level1>Org.getStock().get(i).getQuantity()) {
                                System.out.println("Sorry but this amount isnt available!");
                                BenMenu1();
                            }
                            else {
                                String Name = Org.getStock().get(i).getEName();
                                String Desc =Org.getStock().get(i).getEn().getDesc();
                                Service s = new Service(Name,entityID,Desc);
                                Request R = new Request(s,level1);
                                Org.getBens().get(BenLoc).addRequest(R);
                                BenMenu1();
                            }
                        }
                        else if (noPeople<=4 && noPeople>1) {
                            double level2 = Org.getStock().get(i).getEn().getlevel2();
                            if(level2>Org.getStock().get(i).getQuantity()) {
                                System.out.println("Sorry but this amount isnt available!");
                                BenMenu1();
                            }
                            else {
                                String Name = Org.getStock().get(i).getEName();
                                String Desc =Org.getStock().get(i).getEn().getDesc();
                                Service s = new Service(Name,entityID,Desc);
                                Request R = new Request(s,level2);
                                Org.getBens().get(BenLoc).addRequest(R);
                                BenMenu1();
                            }
                        }
                        else {
                            double level3 = Org.getStock().get(i).getEn().getlevel3();
                            if(level3>Org.getStock().get(i).getQuantity()) {
                                System.out.println("Sorry but this amount isnt available!");BenMenu1();
                            }
                            else {
                                String Name = Org.getStock().get(i).getEName();
                                String Desc =Org.getStock().get(i).getEn().getDesc();
                                Service s = new Service(Name,entityID,Desc);
                                Request R = new Request(s,level3);
                                Org.getBens().get(BenLoc).addRequest(R);
                                BenMenu1();
                            }
                        }
                    }
                }
            }
            if (answer == 2) {
                System.out.println("Please enter the Service's ID and the requested quantity ");
                int entityID = sc.nextInt();
                double reQ = sc.nextDouble();
                for (int i=0;i<Org.getStock().size();i++) {
                    if (Org.getStock().get(i).getEId()==entityID) {
                        if(reQ>Org.getStock().get(i).getQuantity()) {
                            System.out.println("Sorry but this amount isnt available!");
                            BenMenu1();
                        }
                        else {
                            String Name = Org.getStock().get(i).getEName();
                            String Desc =Org.getStock().get(i).getEn().getDesc();
                            Service s = new Service(Name,entityID,Desc);
                            Request R = new Request(s,reQ);
                            Org.getBens().get(BenLoc).addRequest(R);
                        }
                    }
                }
            }
            else {System.out.println("Please enter a valid option! ");BenMenu1();}
        }
        if (answer==2) {BenMenu();}
        else {System.out.println("Please enter a valid option");BenMenu1();}
        return 0;
    }
   
    public int BenMenu2() {
        Org.getBens().get(BenLoc).showcaseRequestList();
        System.out.println("1.Delete Request/Change Quantity\n2.Clear Requests\n3.Back ");
        answer = sc.nextInt();
        if (answer ==1) {
            System.out.println("Which Request would you like to modify ? (enter ID) ");
            int entityID=sc.nextInt();
            System.out.println("1.Delete Request\n2.Change Quantity ");
            answer=sc.nextInt(); 
            if (answer==1) {
                for(int i=0;i<Org.getBens().get(BenLoc).getRequestList().size();i++) {
                    if (Org.getBens().get(BenLoc).getRequestList().get(i).getEId()==entityID) {
                        Org.getBens().get(BenLoc).getRequestList().remove(i);
                        BenMenu();
                    }
                }
            }
            if (answer==2) {
                System.out.println("Please enter a new quantity ");
                double newQ = sc.nextDouble();
                for(int i=0;i<Org.getBens().get(BenLoc).getRequestList().size();i++) {
                    if (Org.getBens().get(BenLoc).getRequestList().get(i).getEId()==entityID) {
                        Org.getBens().get(BenLoc).getRequestList().get(i).setQuantity(newQ);
                        BenMenu();
                    }
                }
            }
            else {
                System.out.println("Please enter a valid option ");
                BenMenu2();
            }
        }
        if (answer ==2) {
            Org.getBens().get(BenLoc).clearRequestList();
            BenMenu();
        }
        if (answer ==3) {BenMenu();}
        return 0;
    }
    
    public int BenMenu3() {
           for (int i=0;i<Org.getBens().get(BenLoc).getRequestList().size();i++) {
            Org.CommitRequest(Org.getBens().get(BenLoc).getRequestList().get(i));
        }
        Org.getBens().get(BenLoc).clearRequestList();
        BenMenu(); 
        return 0;
    }
}
