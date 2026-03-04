
/**
 * Clase para representar personas humanas.
 * 
 * @author David Covián 
 * @version 16/09/2022
 */

public class Person
{
    /**
     * Representa a las personas de género femenino.
     */
    public final static boolean GENDER_FEMALE = false;
     /**
     * Representa a las personas de género masculino.
     */
    public final static boolean GENDER_MALE = true;
    public final static int ADULTHOOD_AGE = 18;
    public final static int RETIREMENT_AGE = 65;
    /**
     * Representa la edad mínima que puede tener una persona de esta clase.
     */
    public final static int MIN_AGE=0;
    /**
     * Representa la edad máxima que puede tener una persona de esta clase.
     */
    public final static int MAX_AGE=120;
    private String name;//Nombre de la persona
    private String surname;//Apellido de la persona
    private int age;//Edad de la persona
    private boolean gender; //Género de la persona (true -> hombre) (false -> mujer)
    private int CriticalAge; //Edad adulta o edad de jubilación
    
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
    
    /**
     * Permite modificar el nombre de la persona
     * @param name Nombre de la persona creada
     */
    private void setName(String name){
        this.name=name;
    }
    
    /**
     * Lanza un error cuando la edad de la persona es menor que 0.
     */
    private void checkParam(boolean condition){
        if (condition==false) {
            throw new IllegalArgumentException("La edad debe ser >=0 y <120"); 
        }
    }
    
    /**
     * Permite modificar la edad de la persona, atendiendo a la condición expuesta por la cual no puede ser menor que 0.
     * @param age Edad de la persona
     */
    public void setAge(int age){
        // if (newAge<0)
         // throw new IllegalArgumentException("La edad debe ser >=0"); 
        checkParam(age>=Person.MIN_AGE && age<Person.MAX_AGE);
        this.age = age;
    }
    
    /**
     * Devuelve el nombre de la persona
     * @return Nombre de la persona
     */
    public String getName(){
        return name;
    }
    
    /**
     * Devuelve la edad de la persona
     * @return  Edad de la persona en años
     */
    public int getAge(){
        return this.age;
    }
    
    /**
     * Permite modificar el apellido de la persona
     * @param surname Apellido de la persona
     */
    private void setSurname(String newSurname){
        surname=newSurname;
    }
    
    /**
     * Permite modificar el género de la persona (true->hombre;false->mujer)
     * @param gender Género de la persona
     */
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
    
    /**
     * Devuelve el género de la persona (true->hombre;false->mujer)
     * @return Género de la persona
     */
    public boolean getGender(){
        return gender;
    }
    
    /**
     * Lanza un mensaje sobre la edad de la persona
     * @return Mensaje sobre edad
     */
    public void print(){
        System.out.println(toString()+". Mi edad es " + getAge() +
                        " pero el año que viene tendré " + 
                        (getAge() + 1) + " años.");
    }
    
    /**
     * Devuelve el número de años que le quedan a una persona para llegar a la mayoría de edad (18). Si la persona ha llegado a la edad adulta y menor de 65 años, el 
    número de años que le faltan para llegar a la edad de jubilación (65 años) y si la persona ha llegado a la jubilación, el número de años que han 
    trascurrido desde la jubilación.
    * @return Años según la condición expuesta
     */
    public int getCriticalAge(){ 
        if (age < ADULTHOOD_AGE){
            return (ADULTHOOD_AGE - age);
        }
        
        if (age >= ADULTHOOD_AGE && age<=RETIREMENT_AGE){
            return (RETIREMENT_AGE - age);
        }
        
        if (age>RETIREMENT_AGE){
            return (age - RETIREMENT_AGE);
        }
        
        else return (age);
    }

    /**
     * Devuelve el nombre, el apellido, la edad y el género de la persona.
     * @return Nombre de la persona - apellid - edad - género.
     */
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
        
        tmp=this.getName().toUpperCase()+"-"+this.getSurname()+"-"+this.getAge()+"-";
        
        if (gender==GENDER_MALE) {
            tmp=tmp+"masculino";
        }
        
        else {
            tmp=tmp+"femenino";
        }
        return tmp.toUpperCase();
        
        // return getName()+"-"+getSurname()+"-"+getAge()+"-"+(gender==true?"masculino":"femenino");
    }

}
    
    

