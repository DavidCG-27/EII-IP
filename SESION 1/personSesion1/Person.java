
/**
 * Clase para representar personas humanas.
 * 
 * @author David Covián 
 * @version 16/09/2022
 */
public class Person
{
    private String name;
    private int age;

    /**
     * Constructor for objects of class Person
     */
    public Person()
    {
        // initialise instance variables
      
    }
    
    public void setName(String newName){
        name=newName;
    }
    
    public void setAge(int newAge){
        age=newAge;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
   
    
}
