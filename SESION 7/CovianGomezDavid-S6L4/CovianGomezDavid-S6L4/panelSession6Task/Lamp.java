
/**
 * Clase Lamp
 * 
 * @author David Covián Gómez
 * @version 21/10/2022
 */
public class Lamp
{
   private boolean status; //Atributo que representa el estado de la lámpara (true-->encendido, false-->apagado)
   
   /**
    * Constante que representa que la bombilla está encendida.
    */
   public static final boolean LAMP_ON = true;
   /**
    * Constante que representa que la bombilla está apagada.
    */
   public static final boolean LAMP_OFF = false;
   
   /**
    * Constructor por defecto de la clase Lamp
    */
   public Lamp()
   {
   
   }
   
   /**
    * Método que devuelve el valor booleano del atributo
    * @return Valor booleano de status.
    */
   public boolean getStatus()
   {
     return status;
    }
    
   /**
    * Método para encender la lámpara
    * @param status Estado de la lámpara
    */
   public void turnOn()
    {
        this.status=LAMP_ON;
    }
   
   /**
    * Método para apagar la lámpara
    * @param status Estado de la lámpara
    */
   public void turnOff()
    {
        this.status=LAMP_OFF;
    }
   
   /**
    * Método que devuelve un String diciendo si esta apagada o encendida
    * @return Estado de la lámpara
    */
   public String toString()
   {
       if(status==true)
       {
            return "ENCENDIDA";
       }
        else
       {
            return "APAGADA";
       }
    }
    
   
}
