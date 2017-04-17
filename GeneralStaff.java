package employee;

public class GeneralStaff extends Employee {
    private int bonus;
    
    public GeneralStaff(String staffID, String name, int age, String gender, String mobileNo, String post, String address, int salary, int mpf, int bonus) {
        super(staffID, name, age, gender, mobileNo, post, address, salary, mpf);
        this.bonus = bonus;
    }
    
    public int getBonus() {return bonus;}
    
    public void increaseSalary(double percentage{
        
    }
    
    public String toString(){
       return super.toString() + bonus;
    }
}
