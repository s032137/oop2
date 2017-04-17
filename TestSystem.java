public class TestSystem {
<<<<<<< HEAD
   public static void main(String args[]){
       
       
       
       
       
=======
   public static void main(String args[]){      
>>>>>>> origin/master
       Employee Man1 = new Manager("M000003", "CHIU Shun Kin", 33, "Male", "95515368", "HR Manager", "Room B,27/F,234 Chu Wing Street,Hung Hom,Kowloon", 115000, 5750, 11500, 11500);

       Employee Gen1 = new GeneralStaff("G000004", "AU Siu Ling", 26, "Female", "NA", "Technician", "Flat D,10/F,185 Kowloon City Road,Hung Hom,Kowloon", 
                                            30000, 1500, 3000);
       
       
       System.out.println("The sample records of the employees are shown below");
       System.out.println("Sample record 1:"+ Man1.toString());
       System.out.println("Sample record 2:"+ Gen1.toString());
       
       Gui basicUI = new Gui();
       basicUI.contentObjects();
       
       
       
       
       
       
   }
}


