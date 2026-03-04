
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
    
    private int xPos; //Coordenada x que ocupa el avión en el plano.
    private int yPos; //Coordenada y que ocupa el avión en el plano
    private int xSpeed;//Velocidad de la coordenada x en el plano.
    private int ySpeed;//Velocidad de la coordenada y en el plano.
    
    /**
     * Constante que indica la coordenada X máxima
     */
    public final static int MAX_X = 10;
    /**
     * Constante que indica la coordenada Y máxima
     */
    public final static int MAX_Y = 10;
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
     * Permite modificar la coordenada X del avión.
     * @param xPos Coordenada X
     */
    private void setXPos(int xPos){
       checkParam(xPos>=0 && xPos<=MAX_X, "Coordenada fuera de rango");
       this.xPos=xPos;
    }
    
    /**
     * Permite modificar la coordenada Y del avión.
     * @param yPos Coordenada Y
     */
    private void setYPos(int yPos){
       checkParam(yPos>=0 && yPos<=MAX_X, "Coordenada fuera de rango");
       this.yPos=yPos;
    }
    
    /**
     * Permite modificar la velocidad de la coordenada X del avión.
     * @param xSpeed Velocidad de la coordenada X
     */
    private void setXSpeed(int xSpeed){
       checkParam(xSpeed==-1 || xSpeed==0 || xSpeed==1, "Velocidad de coordenada fuera de rango");
       this.xSpeed=xSpeed;
    }
    
    /**
     * Permite modificar la velocidad de la coordenada Y del avión.
     * @param ySpeed Velocidad de la coordenada Y
     */
    private void setYSpeed(int ySpeed){
       checkParam(ySpeed==-1 || ySpeed==0 || ySpeed==1, "Velocidad de coordenada fuera de rango");
       this.ySpeed=ySpeed;
    }
    
    /**
     * Devuelve la coordenada X
     * @return xPos Coordenada X
     */
    public int getXPos(){
        return this.xPos;
    }
    
    /**
     * Devuelve la coordenada Y
     * @return yPos Coordenada Y
     */
    public int getYPos(){
        return this.yPos;
    }
    
    /**
     * Devuelve la velocidad de la coordenada X
     * @return xSpeed Velocidad de la coordenada X
     */
    public int getXSpeed(){
        return this.xSpeed;
    }
    
    /**
     * Devuelve la velocidad de la coordenada Y
     * @return ySpeed Velocidad de la coordenada Y
     */
    public int getYSpeed(){
        return this.ySpeed;
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
    
    public String toString(){
        if (pilot==null)
    {
        return this.getIdentifier() + "-" + this.getFuel() + "NOT PILOT";
    }
        else
    {
        Person Person=new Person();
        return this.getIdentifier() + "-" + this.getFuel() + "-" + Person.getAge() + "-" + Person.getHashCode();

    }
    
    }
    
    public boolean fly()
    {
        if (fuel==0){
        return false;
        }
        else{
        fuel=--fuel;
        return true;
        }
    }
    
    public void accelerate(int xSpeed, int ySpeed)
    {
       checkParam(xSpeed==-1 || xSpeed==0 || xSpeed==1, "Velocidad de coordenada fuera de rango");
       this.xSpeed=xSpeed;
       
       checkParam(ySpeed==-1 || ySpeed==0 || ySpeed==1, "Velocidad de coordenada fuera de rango");
       this.ySpeed=ySpeed;
    }
    }
