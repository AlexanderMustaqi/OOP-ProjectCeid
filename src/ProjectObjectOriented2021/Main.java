import java.util.ArrayList;


public class Main
{
    public static void main(String[] args) {
        Admin Admin = new Admin("Alexander",694666420);
        Organization Org = new Organization("jerw gw bale ena onoma edw",Admin);
        //Service test = new Service("",0,"");
        //Offer f = new Offer(test,0);
        //Org.AddOffer(f);
        Material milk = new Material("Milk",001,"It comes in a carton",1.5,4,7);
        Material sugar = new Material("Sugar",002,"It comes in bags",1,3,4);
        Material rice = new Material("Rice",003,"It comes in bags",3,12,15);
        Service MedSup = new Service("MedicalSupport",004,"It not mental support!");
        Service NursSup = new Service("NurserySupport",005,"Its not medical support!");
        Service BabySit = new Service("BabySitting",006,"They come to take care of your babyyy!:DDD");
        Donator D1 = new Donator("D1",691);
        Beneficiary B1 = new Beneficiary("Bobby",692,1);
        Beneficiary B2 = new Beneficiary("B2",693,3);
        Org.addDon(D1);
        Org.addBen(B1);
        Org.addBen(B2);
        Org.addEn(milk);
        Org.addEn(sugar);
        Org.addEn(rice);
        Org.addEn(MedSup);
        Org.addEn(NursSup);
        Org.addEn(BabySit);
        
        Menu m = new Menu(Org);
        m.Start();
    }
}
