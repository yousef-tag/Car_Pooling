/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpooling_package;
import java.util.Scanner;
/**
 *
 * @author Abdel Aziz
 */
public class CarPooling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
         Scanner input=new Scanner(System.in);
         boolean Done=true;
         System.out.println("Welcome To Car pooling Mini System");
         cars ncar[]=new cars[6];
         ncar[0]=new cars("A","B","Red",90.5,"12345",4,5,"hassan");
         ncar[1]=new cars("B","C","black",74.25,"5432",4,4,"ahmed");
         ncar[2]=new cars("C","D","Orange",100.0,"99977",8,4,"muhamed");
         ncar[3]=new cars("D","E","Blue",125.5,"45832",3,3,"Yousef");
         ncar[4]=new cars("E","F","Green",80.0,"675843",2,5,"sameh");
         ncar[5]=new cars("E","F","Green",97.0,"675843",4,5,"sameh");
         Passanger pass[]=new Passanger[6];
         pass[0]=new passenger_sub("yousef",30,"male",1);
         pass[1]=new passenger_sub("Nade",25,"female",2);
         pass[2]=new passenger_sub("ziad",25,"male",3);
         pass[3]=new passanger_non_sub("saga",32,"female",4);
         pass[4]=new passanger_non_sub("Ahmed",19,"male",5);
         pass[5]=new passanger_non_sub("Sayed",29,"male",6);
      try
      {
         label:while(Done)
        {        
          System.out.println("please enter your code :");
          int code=input.nextInt();
          if(code<0)
          {
          throw new Error("the code of passanger cannot be negative");    
          }
          for(int i=0;i<6;i++)
          {
              if(code==pass[i].getCode())
              {
                  System.out.println("Welcome "+pass[i].getName());
                  pass[i].search(ncar);                                 
              break;
              }  
              }
       System.out.println("if you need to try again press (y) ");
        String choice=input.next();
              if(choice.equalsIgnoreCase("y"))
              {
                  continue label;
              }       
        else
              {
             Done=false;     
              }
      }
      }
      catch(Error o)
      {
          System.out.println(o.getMessage());
      }
      }
}


class cars
{
private String driver_name;
private final int no_of_trip;
static String code;
private int capacity;
private String Start_point;
private String End_point;
private String color;
private double Price;

    public cars(int no_of_trip) 
    {
        this.no_of_trip = no_of_trip;
    }

    public cars( String Start_point, String End_point,String color,double Price,String code,int capacity,int no_of_trip,String driver_name) 
    {
        this.Start_point = Start_point;
        this.End_point = End_point;
        this.color=color;
        this.Price = Price;
        this.code=code;
        this.capacity=capacity;
        this.no_of_trip=no_of_trip;
        this.driver_name=driver_name;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void setPrice(double Price) 
    {
        this.Price = Price;
    }

    public void setStart_point(String Start_point) 
    {
        this.Start_point = Start_point;
    }

    public void setEnd_point(String End_point) 
    {
        this.End_point = End_point;
    }

    public String getColor() {
        return color;
    }

    public String getCode() {
        return code;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public int getNo_of_trip() {
        return no_of_trip;
    }
    
    public double getPrice() 
    {
        return Price;
    }

    public String getStart_point() 
    {
        return Start_point;
    }

    public String getEnd_point() 
    {
        return End_point;
    }
}
interface person
{
public void search(cars ncar[]);
public boolean sub_or_not();
}
abstract class Passanger implements person
{
   private String Name;
   private  int Age;
   private  String Gender;
   private final int code; 
    public Passanger(int code)
    {
        this.code = code;
    }   
    public Passanger(String Name, int Age, String Gender, int code) 
    {
        this.Name = Name;
        this.Age = Age;
        this.Gender = Gender;
        this.code=code;
    }
    @Override
    public final void search(cars ncar[])/**Search for a suitable car */
{  
    
     System.out.println("Please Enter your start point :");
     Scanner input=new Scanner(System.in);
     String start=input.next();
     System.out.println("Enter your End point :");
     String End=input.next();

     for(int i=0;i<5;i++)
{
    if(start.equalsIgnoreCase(ncar[i].getStart_point())&&End.equalsIgnoreCase(ncar[i].getEnd_point()))
    {
     System.out.println("the car that you need is ready and its color is "+ncar[i].getColor()
             +" and your driver name is  "+ ncar[i].getDriver_name()+" this code of this car = "
             + ncar[i].getCode()+" and the maximum capacity  = "+ncar[i].getCapacity());
    if(sub_or_not())
    {
        System.out.println("your price"+ncar[i].getPrice()/2);
    }
    else
    {
        System.out.println("your price"+ncar[i].getPrice());
    }
    break;
    }
    else
    {
        System.out.println("car Not found");
    break;
            
    }
}
}
  @Override
public boolean sub_or_not()/** identify subscribe or not subscribe */
{
    Scanner input=new Scanner(System.in);
    System.out.println("Do you have an E_mail       (y) :");
    String answer=input.next();
    if(answer.equalsIgnoreCase("y"))
        return true;
    else    
    return false;    
}
    
    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCode() {
        return code;
    }
    
}
class Error extends Exception
{
public Error(String msg)
{
    super(msg);
}    
}
class passenger_sub extends Passanger
{

    public passenger_sub(String Name, int Age, String Gender,int code)
    {
        super(Name, Age, Gender,code);
    }
}
class passanger_non_sub extends Passanger
{
    String e_mail;
    String password;
    public passanger_non_sub(String Name, int Age, String Gender,int code) 
    {
        super(Name, Age, Gender,code);
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }



    public String getE_mail() {
        return e_mail;
    }


    public void creating_account()/** creating an account */
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter your name :");
        setName(input.next());
        System.out.println("Enter your Age :");
        setAge(input.nextInt());
        System.out.println("Enter your Gender :");
        setGender(input.next());
        System.out.println("Enter your E_mail :");
        setE_mail(input.next());
         System.out.println("Enter your password :");
        setPassword(input.next());
        System.out.println("Now, you are subscribed");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    }
