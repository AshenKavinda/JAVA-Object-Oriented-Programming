import java.util.ArrayList;
import java.util.Scanner;

public class CoustomerCollection{
    private int coustomerCount ;
    ArrayList<Coustomer> coustomerArr = new ArrayList<Coustomer>();

    CoustomerCollection()
    {
        coustomerCount = 0 ;
    }
    CoustomerCollection(int coustomerCountStart)
    {
        coustomerCount = coustomerCountStart ; 
    }

    public void addCoustomer(String nic,int phoneNo,String name,String email)
    {
        Coustomer coustomer = new Coustomer(coustomerCount , nic, phoneNo, name, email, 0f);
        coustomerArr.add(coustomer);
        coustomerCount++;

    }

    public void getUserInputAddCoustomer(Scanner scanner)
    {
        int  phoneNo ;
        String name ,email,nic ;
        scanner.nextLine();
        System.out.print("Enter Full Name    : ");
        name = scanner.nextLine();
        System.out.print("Enter NIC          : ");
        nic = scanner.nextLine();
        System.out.print("Enter Phone Number : ");
        phoneNo = scanner.nextInt();
        System.out.print("Enter Email        : ");
        email = scanner.next();
        
        addCoustomer(nic, phoneNo, name, email);

    }

    public int getArrLocation(int phoneNo)
    {
        int ArrLocation = 0 ;
        boolean notFound = true ;
        for (Coustomer coustomerDetails : coustomerArr) {
            if (coustomerDetails.phoneNo==phoneNo) {
                notFound = false ;
                break;
            }
            ArrLocation++ ;
        }
        if (notFound==true) {
            ArrLocation=-1 ;
        }
        return ArrLocation;
        
    }


    public float getPointByNumber(int phoneNo)
    {
        float point = -1 ;
        int ArrLocation = getArrLocation(phoneNo);
        if (ArrLocation>=0) {
            point = coustomerArr.get(ArrLocation).point ;
        }
        return point ;
    }

    public void setPointByNumber(int phoneNo,float addpoint)
    {
       int ArrLocation = getArrLocation(phoneNo) ;
       if (ArrLocation>=0) {
        coustomerArr.get(ArrLocation).point = coustomerArr.get(ArrLocation).point + addpoint ;
       }
       
    }

    public void getUserByNumber(int phoneNo)
    {
        int ArrLocation = getArrLocation(phoneNo); 
        System.out.println("Coustomer ID : "+coustomerArr.get(ArrLocation).cId);
        System.out.println("Name         : "+coustomerArr.get(ArrLocation).name);
        System.out.println("NIC          : "+coustomerArr.get(ArrLocation).nic);
        System.out.println("Email        : "+coustomerArr.get(ArrLocation).email);
        System.out.println("PhoneNo      : "+coustomerArr.get(ArrLocation).phoneNo);
        System.out.println("Point        : "+coustomerArr.get(ArrLocation).point);
    }

    public void getAllUser()
    {
        for (Coustomer coustomerDetails : coustomerArr) {
            System.out.println("----------------------------------------------------");
            System.out.println("Coustomer ID : "+coustomerDetails.cId);
            System.out.println("Name         : "+coustomerDetails.name);
            System.out.println("NIC          : "+coustomerDetails.nic);
            System.out.println("Email        : "+coustomerDetails.email);
            System.out.println("PhoneNo      : "+coustomerDetails.phoneNo);
            System.out.println("Point        : "+coustomerDetails.point);
        }
    }

    

}
