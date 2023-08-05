import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("**********Welcome To Student Management App**********");

        while (true){
            System.out.println("PRESS 1 to ADD Student");
            System.out.println("PRESS 2 to Delete Student");
            System.out.println("PRESS 3 to Display Students List");
            System.out.println("PRESS 4 to UPDATE A Student's Data");
            System.out.println("PRESS 5 to Exit App");

            int c = Integer.parseInt(br.readLine());

            if(c==1){
                System.out.println("Enter Student Name : ");
                String name = br.readLine();
                System.out.println("Enter Student Phone No. : ");
                String phone = br.readLine();
                System.out.println("Enter Student City : ");
                String city = br.readLine();

                Student st = new Student(name, phone, city);
                boolean ans = StudentDao.insertStudentToDB(st);
                if(ans){
                    System.out.println("***Student Data Added Successfully***");
                }else{
                    System.out.println("Something Went Wrong! Try Again");
                }
            } else if (c==2) {
                System.out.println("Enter Student ID to Delete : ");
                int userId = Integer.parseInt(br.readLine());
                boolean f = StudentDao.deleteStudent(userId);
                if(f){
                    System.out.println("***Student Data Deleted Successfully***");
                }else{
                    System.out.println("Something Went Wrong! Try Again...");
                }
            } else if (c==3) {
                StudentDao.showAllStudent();
            } else if (c==4) {
                System.out.println("Enter Student ID to Update: ");
                int stuID = Integer.parseInt(br.readLine());

                System.out.println("PRESS 1 to Update Student Name");
                System.out.println("PRESS 2 to Update Student Phone No.");
                System.out.println("PRESS 3 to Update Student City");
                System.out.println("PRESS 4 to Go Back");
                int choice = Integer.parseInt(br.readLine());
                if (choice == 1) {
                    System.out.println("Enter New Name : ");
                    String newName = br.readLine();
                    boolean ans = StudentDao.updateName(stuID, newName);
                    if(ans){
                        System.out.println("***Student Name Updated Successfully***");
                    }else{
                        System.out.println("Something Went Wrong!, Try Again.");
                    }
                }else if(choice == 2){
                    System.out.println("Enter New Phone No. : ");
                    String newPhone = br.readLine();
                    boolean ans = StudentDao.updatePhone(stuID, newPhone);
                    if(ans){
                        System.out.println("***Student Phone No. Updated Successfully***");
                    }else{
                        System.out.println("Something Went Wrong!, Try Again.");
                    }
                }else if(choice == 3){
                    System.out.println("Enter New City : ");
                    String newCity = br.readLine();
                    boolean ans = StudentDao.updateCity(stuID, newCity);
                    if(ans){
                        System.out.println("***Student City Updated Successfully***");
                    }else{
                        System.out.println("Something Went Wrong!, Try Again.");
                    }
                }else if(choice == 4){
                    break;
                }else{

                }
            }else if(c==5){
                break;
            }else{

            }
        }
        System.out.println("Thankyou For Using My Application, See You Soon...");
    }
}
