
package employee;

abstract class Employee{
    private String StaffID;
    private String name;
    private int age;
    private String gender;
    private String mobileNo;
    private String post;
    private String address;
    private int salary;
    private int mpf;
    
    public Employee(String staffID, String name, int age, String gender, String mobileNo, String post, String address, int salary, int mpf ) {
        this.StaffID = staffID;
        this.name    = name;
        this.age     = age;
        this.gender  = gender;
        this.mobileNo = mobileNo;
        this.post     = post;
        this.address  = address;
        this.mpf      = mpf;
        setSalary(salary);
        
    
    }
    
    public String getStaffID() {return StaffID;}
    public String getName() {return name;}
    public String getGender() {return gender;}
    public int getAge() {return age;}
    public String getMobileNo() {return mobileNo;}
    public String getPost() {return post;}
    public String getAddress() {return address;}
    public int getSalary() {return salary;}
    public int getMPF() {return mpf;}
    
    public void setSalary(int salary) {this.salary = salary;}
    
    public boolean isName(String check, char ch) {

        for (int i=0; i<name.length(); i++) {
            if (name.charAt(i) != check.charAt(i) && ch != check.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public String getDistrict () {return address;}
    
    public boolean isDistrict (String districtCheck) {
        
    }
    
    public abstract void increaseSalary(double percentage){
    
    
    }
}

