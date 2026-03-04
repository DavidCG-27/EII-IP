
/**
 * Write a description of class Plane here.
 * 
 * @author David 
 * @version (a version number or a date)
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
    
    private void setIdentifier(char identifier){
       checkParam(identifier>='A' && identifier<='Z', "Identificador tiene que ser una letra mayúscula");
       this.identifier=identifier;
    }
    
    private void setFuel(int fuel){
       checkParam(fuel>=0 && fuel<=5000, "Combustible fuera de rango");
       this.fuel=fuel;
    }
    
    private void setPilot(Person pilot){
       this.pilot=pilot;
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
     * Lanza un error cuando no se cumplen las condiciones.
     */
    private void checkParam(boolean condition, String errorMsg){
        if (condition==false) {
            throw new IllegalArgumentException(errorMsg); 
        }
    }
}
