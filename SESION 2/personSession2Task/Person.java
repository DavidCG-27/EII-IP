
/**
 * Clase para representar personas humanas.
 * 
 * @author David Covián 
 * @version 16/09/2022
 */

public class Person
{
    public final static boolean GENDER_FEMALE = false;
    public final static boolean GENDER_MALE = true;
    
    private String name;//Nombre de la persona
    private String surname;//Apellido de la persona
    private int age;//Edad de la persona
    private boolean gender; //Género de la persona (true -> hombre) (false -> mujer)

    /**
     * Crea una persona con valores por defecto (Carlos Sainz, de 42 años, hombre)
     */
    public Person()
    {
       setName("Carlos");
       setSurname("Sainz");
       setAge(42);
       setGender(GENDER_MALE);
    }
    
    /**
     * Crea una persona por defecto, pero con una edad determinada
     * @param age  Edad de la persona creada
     */
    public Person(int age){
       this();
       setAge(age);
    }
    
    /**
     * Crea una persona concreta, con valores determinados
     * @param name  Nombre de la persona creada
     * @param surname  Apellido de la persona creada
     * @param age  Edad de la persona creada
     * @param gender   Género de la persona creada (true->hombre; false->mujer)
     */
    public Person(String name, String surname, int age, boolean gender){
       this();
       setName(name);
       setSurname(surname);
       setAge(age);
       setGender(gender);
    }
    
    private void setName(String newName){
        name=newName;
    }
    
    private void checkParam(boolean condition){
        if (condition==false) {
            throw new IllegalArgumentException("La edad debe ser >=0"); 
        }
    }
    
    private void setAge(int newAge){
        // if (newAge<0)
         // throw new IllegalArgumentException("La edad debe ser >=0"); 
        checkParam(newAge>=0);
         age=newAge;
    }
    
    public String getName(){
        return name;
    }
    
    /**
     * Devuelve la edad de la persona
     * @return  Edad de la persona en años
     */
    public int getAge(){
        return age;
    }
    
    private void setSurname(String newSurname){
        surname=newSurname;
    }
    
    private void setGender(boolean newGender){
        gender=newGender;
    }
    
    /**
     * Devuelve el apellido de la persona
     * @return  Apellido de la persona
     */
    public String getSurname(){
        return surname;
    }
    
    public boolean getGender(){
        return gender;
    }
    
    public void print(){
        System.out.println(toString()+". Mi edad es " + getAge() +
                        " pero el año que viene tendré " + 
                        (getAge() + 1) + " años.");
    }
    
    public String toString() {
        // if (gender==true) {
          // return getName()+"-"+getSurname()+"-"+getAge()+"-"+"masculino";
        // }
        
        // if (gender==false) {
           // return getName()+"-"+getSurname()+"-"+getAge()+"-"+"femenino";
        // }
        
        // return "Java es tonto";
        
    
        
        // if (gender==true) {
            // return getName()+"-"+getSurname()+"-"+getAge()+"-"+"femenino";
        // }
        
        // else {
            // return getName()+"-"+getSurname()+"-"+getAge()+"-"+"masculino";
        // }
        
        String tmp;
        
        tmp=getName()+"-"+getSurname()+"-"+getAge()+"-";
        
        if (gender==GENDER_MALE) {
            return tmp+"masculino";
        }
        
        else {
            return tmp+"femenino";
        }
        
        // return getName()+"-"+getSurname()+"-"+getAge()+"-"+(gender==true?"masculino":"femenino");
    }

}
    
    

