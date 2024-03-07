import java.util.ArrayList;
import java.util.Scanner;

public class Bill {
    ItemCollection itemcollection ;
    
    float total ;
    public ArrayList<String> itemName = new ArrayList<String>() ;
    public ArrayList<String> unit = new ArrayList<String>() ;
    public ArrayList<Float> unitPrice = new ArrayList<Float>() ;
    public ArrayList<Float> quntity = new ArrayList<Float>() ;
    public ArrayList<Float> itemSum = new ArrayList<Float>() ;

    Bill(ItemCollection itemcollection)
    {
        this.itemcollection = itemcollection ;
        this.total = 0f ;
    }

    public float addToBill(String itemGroupCode,float quntity)
    {
        itemName.add(itemcollection.getItemNameById(itemGroupCode));
        unitPrice.add(itemcollection.getItemPriceById(itemGroupCode));
        unit.add(itemcollection.getItemUnit(itemGroupCode));
        this.quntity.add(quntity);
        float total = itemcollection.getItemPriceById(itemGroupCode)*quntity ;
        itemSum.add(total);
        this.total += total ; 
        return total ;
    }

    public void getUserInputAddToBill(Scanner scanner)
    {
        String itemGroupCode ;
        float quntity ;
        while (true) {
            System.out.print("Item Code : ");
            itemGroupCode = scanner.nextLine();
            if (itemGroupCode.equals("99")) {
                break ;
            }
            System.out.print("Quntity : ");
            quntity = scanner.nextFloat();
        
            addToBill(itemGroupCode, quntity);
            printTotal();
            scanner.nextLine();
            
        }
    }

    public void printTotal()
    {
        System.out.println("Total : "+this.total);  
    }

    public float printFinalBill(float balance)
    {
        for (int i = 0; i < itemName.size(); i++) {
            if (unit.get(i)==null) {
                System.out.println(itemName.get(i)+"\t\t"+unitPrice.get(i)+"\t"+quntity.get(i)+"   "+ "\t"+"Rs."+itemSum.get(i));
            }
            else {
                System.out.println(itemName.get(i)+"\t\t"+unitPrice.get(i)+"\t"+quntity.get(i)+" "+unit.get(i)+ "\t"+"Rs."+itemSum.get(i));
            }
            
           
        }
        System.out.println();
        System.out.println("TOTAL PRICE : "+total); 
        return pointThatBill(balance);
    }

    public void resetBill()
    {
        itemName.clear();
        unitPrice.clear();
        quntity.clear();
        itemSum.clear();
        total = 0 ;
    }

    public void displayPoint(float point)
    {
        if (point>=0) {
            System.out.println("Avilable point : "+point);
        }
        else {
            System.out.println("User Not Found");
        }
        
    }

    private float pointThatBill(float balance)
    {
        float point = balance ;
        if (total>=10000) {
            point += 300 ;
        }
        else if (total >= 8000) {
            point += 200 ;
        } else if (total >= 5000) {
            point += 100 ;
        } else if (total > 4000) {
            point += 50 ;
        } 
        return point ;
    }

}
