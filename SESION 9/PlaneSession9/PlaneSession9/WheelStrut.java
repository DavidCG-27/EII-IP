import java.util.ArrayList;

/**
 * Clase para describir el puntal de un avión.
 * El puntal es parte del tren de aterrizaje y está compuesto por un soporte y dos ruedas. Puede estar desplegado o no.
 * 
 * @author David Covián Gómez
 * @version 28/10/2022
 */
public class WheelStrut{
    /**
     * Valor para indicar que el puntal está desplegado
     */
    public static final boolean IS_DEPLOYED = true;
    /**
     * Presión por defecto del BOING-727, en Milibares
     */
    public static final double BOEING_737_PRESSURE = 1739; // en Mb
    
    
    private ArrayList<Wheel> wheels;
    private boolean deployed; // true si el puntal está desplegado
   
    /**
     * Constructor cuyas ruedas tienen la presión del BOEING-737
     * @param numberOfWheels Número de ruedas del puntal
     */
    public WheelStrut(int numberOfWheels)     
    {
        checkParam(numberOfWheels>0, "El puntal debe de tener un número de ruedas >0");
        ArrayList wheels=new ArrayList<Wheel>();
        for (int i=0;i<numberOfWheels; i++)
        {
            wheels.add(new Wheel(BOEING_737_PRESSURE,BOEING_737_PRESSURE));
        }
        this.setWheels(wheels);
        this.setDeployed(IS_DEPLOYED);
    }
    
    /**
     * Lanza un error cuando no se cumple.
     */
    private void checkParam(boolean condition, String errorMsg)
    {
        if (condition==false) 
        {
            throw new IllegalArgumentException(errorMsg); 
        }
        else{}
    }
    
      /**
     * Modifica el valor del atributo deployed
     * @param deployed, valor verdadero si el puntal está desplegado
     */
    private void setDeployed(boolean deployed)  
    {
       this.deployed=deployed;
    }
    
    private void setWheels(ArrayList wheels)
    {
        this.wheels=wheels;
    }
    
    /**
     * Devuelve la rueda indicada del puntal
     * @param número de rueda a devolver
     * @return rueda indicada
     */
    public Wheel getWheel(int n)
    {
        checkParam(n>=0 && n<numberOfWheels(), "Número de rueda inválido");
        return this.wheels.get(n);
    }
    
    /**
     * Devuelve el nº de ruedas del puntal
     * @return número de ruedas del puntal
     */
    public int numberOfWheels()
    {
        return this.wheels.size();
    }
    
    /**
     * Devuelve el valor del atributo deployed
     * @return true o false si está o no desplegado el puntal
     */
    public boolean isDeployed()
    { 
        return this.deployed;
    }
    
    /**
     * Método que devuelve true si todas las ruedas del puntal tienen suficiente presión
     * @return true si presión de las ruedas adecuada
     * 
     */
    public boolean test()   
    {
        for (int i=0; i<this.numberOfWheels(); i++)
        {
            if (this.getWheel(i).test()==false)
            {
                return false;
            }        
        }
        return true;  
    }
     
    /**
      * @return estado del puntal con el siguiente formato, en tipo String
      * Deployed: true - Test: true [0:true] [1: true] ... [n-1: true]
      */
     public String toString() 
     {
        String p1 = String.format("Deployed: %b - Test: %b",
                                this.isDeployed(),
                                this.test());
        String p2 = "";
        for (int i=0; i<numberOfWheels(); i++)
        {
            p2=p2+String.format("[%d: %b] ",i, this.getWheel(i));
        }
        
        return p1+p2;
     }
     
     /**
      * Método print que imprime los datos del puntal con el siguiente formato
      * Valor de deployed
      * Valor de test
      * resultado de ejecutar print sobre cada rueda
      * Ejemplo:
      * 
      * RETRACTED (o DEPLOYED)
      * Test............... FAIL (o OK)
      * LEFT Wheel
      * Presión máxima....... 34500 Mb.
      * Presión actual... 32000 Mb (92.75%)
      * Test.............  OK 
      * RIGHT Wheel
      * Presión máxima....... 34500 Mb.
      * Presión actual ........ 5205 Mb (15.08%)
      * Test....................FAIL
      */
    public void print() 
    {
        System.out.println("-----------------------------------");   
        if (deployed==true)
        {
          System.out.println("DEPLOYED");
        }
        else
        {
            System.out.println("RETRACTED");
        }
        System.out.println(String.format("Test...............   %s",this.test()?"OK":"FAIL"));
        System.out.println();
        for (int i=0; i<this.numberOfWheels();i++)
        {
            System.out.println("Wheel#"+i); 
            this.getWheel(i).print();
        }
        System.out.println("-----------------------------------");  
    }
    
    /**
     * Despliega el puntal
     */
    public void deploy()   
    {
        this.setDeployed(IS_DEPLOYED);
    }
    
    /**
     * Repliega el puntal
     */
    public void retract()  
    {
        this.setDeployed(! IS_DEPLOYED);
    }
    


}