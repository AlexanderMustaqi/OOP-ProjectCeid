
abstract class Entity
{
    //Variables
    private String Name;
    private int Id;
    private String Description;
    //Con
    public Entity(String Name,int Id,String Desc) {
        this.Name = new String(Name);
        this.Id = Id;
        this.Description = new String(Desc);
    }
    //Methods
    public String getName() {return this.Name;}
    public String getDesc() {return this.Description;}
    public int getId() {return this.Id;}
    public String getInfo() {return this.Name +" "+this.Description+" "+this.Id;}
    abstract String getDetails();
    abstract double getlevel1();
    abstract double getlevel2();
    abstract double getlevel3();
    public String toString() {return getInfo()+" "+getDetails();}
}
