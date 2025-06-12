
public class Material extends Entity
{
    //Variables
     double level1;
     double level2;
     double level3;
    //Con
    public Material(String Name,int Id,String Description,double level1,double level2,double level3) {
        super(Name,Id,Description);
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
    }
    //Methods
    public double getlevel1() {return this.level1;}
    public double getlevel2() {return this.level2;}
    public double getlevel3() {return this.level3;}
    public String getDetails() {return "Material";}
}
