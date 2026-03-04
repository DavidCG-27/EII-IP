
/**
 * Clase para representar aviones. 
 * 
 * @author David 
 * @version 7/10/2022
 */
public class Plane
{
    private Person pilot; //Piloto (definido en la clase person)
    private char identifier; // Identificador (de tipo char)
    private int fuel; //Combustible (de tipo int)
    
    /**
     * Constructor por defecto de la clase plane. Crea un avión sin piloto, con id=A y fuel a 0
     */
    public Plane()
    {
        this.setPilot(null);
        this.setIdentifier('A');
        this.setFuel(0);
    }
    
    /**
     * Constructor con un parámetro de tipo Person. Crea un avión con un piloto, los demás atributos por defecto.
     * @param pilot Piloto del avión
     */
    public Plane(Person pilot){
        this();
        this.setPilot(pilot);
    }
    
     /**
     * Constructor con un parámetro de tipo Person. Crea un avión con un identificador, los demás atributos por defecto.
     * @param identifier Identificador
     */
    public Plane(char identifier){
        this();
        this.setIdentifier(identifier);
    }
    
     /**
     * Constructor con un parámetro de tipo Person. Crea un avión con un combustible, los demás atributos por defecto.
     * @param fuel Combustible
     */
    public Plane(int fuel){
        this();
        this.setFuel(fuel);
    }
    
    /**
     * Constructor con tres parámetros. Crea un avión con los valores pasados como parámetro.
     * @param pilot Piloto del avión.
     * @param fuel Combustible del avión (en litros).
     * @param identifier Identificador del avión
     */
    public Plane(Person pilot, char identifier, int fuel){
        this();
        this.setPilot(pilot);
        this.setIdentifier(identifier);
        this.setFuel(fuel);
    }
    
    /**
     * Permite modificar el identificador del piloto
     * @param identifier Identificador
     */
    private void setIdentifier(char identifier){
       checkParam(identifier>='A' && identifier<='Z', "Identificador tiene que ser una letra mayúscula");
       this.identifier=identifier;
    }
    /**
     * Permite modificar el combustible
     * @param fuel Combustible
     */
    private void setFuel(int fuel){
       checkParam(fuel>=0 && fuel<=5000, "Combustible fuera de rango");
       this.fuel=fuel;
    }
    /**
     * Permite modificar el piloto
     * @param pilot Piloto
     */
    private void setPilot(Person pilot){
        Person p=new Person(); //# No tienes que crear un nuevo piloto, sino asignar el que se pasa como parámetro
        checkParam(p.canBePilot()==true, p.getName() + "no puede ser piloto");
        this.pilot=pilot;
    }
    
     /**
     * Lanza un error cuando no se cumplen las condiciones.
     */
    private void checkParam(boolean condition, String errorMsg){
        if (condition==false) {
            throw new IllegalArgumentException(errorMsg); 
        }
    }
    
    /**
     * Devuelve el Identificador
     * @return nos devuelve el identificador, de tipo char
     */
    public char getIdentifier(){
        return this.identifier;
    }
    
    /**
     * Devuelve el combustible
     * @return nos devuelve el valor del combustible, de tipo int
     */
    public int getFuel(){
        return this.fuel;
    }

    /**
     * Devuelve el piloto
     * @return nos devuelve el piloto, de la clase Person
     */
    public Person getPilot(){
        return this.pilot;
    }
    /**
     * Método que devuelve un String concatenado con el piloto, el identificador y el combustible.
     * @return String concatenado
     */
    public String toString(){
        return this.getPilot() + "-" + this.getIdentifier() + "-" + this.getFuel() + ".";
    }
    /**
     * Método que devuelve si el avión puede o no despegar según su combustible
     * @return Puede o no despegar
     */
    public boolean fly(){
    if (fuel==0){
        return false;
    }
    else{
        fuel=--fuel;
        return true;
    }
    }
}
