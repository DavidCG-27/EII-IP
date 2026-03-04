
/**
 * Write a description of class ControlPanel here.
 * 
 * @author David Covián Gómez 
 * @version 21/10/2022
 */
public class ControlPanel
{
   private Lamp control_status; //Atributo de la clase Lamp que indica el estado de la lámpara.
   private Switch control_button; //Atributo de la clase Switch que indica el botón de la lámpara
   private Heater control_temp; //Atributo de la clase Heater que indica la temperatura en ºC
   private Potentiometer control_pot; //Atributo de la clase Potentiometer que indica la posición del potenciómetro
   /**
    * Constructor por defecto de la clase ControlPanel
    */
   public ControlPanel()
   {
    control_status=new Lamp();
    control_button=new Switch();
    control_temp=new Heater();
    control_pot=new Potentiometer();
   }
   
   /**
    * Método que devuelve el atributo control_status
    * @return Atributo control_status
    */
   public Lamp getControl_Status()
   {
     return control_status;
    }
    
    /**
    * Método que devuelve el atributo control_button
    * @return Atributo control_button
    */
   public Switch getControl_Button()
   {
     return control_button;
    }
   
    /**
    * Método que devuelve control_temp
    * @return control_temp
    */
   public Heater getControl_Temp()
    {
        return control_temp;
    }
    
    /**
    * Método que devuelve control_pot
    * @return control_pot
    */
   public Potentiometer getControl_Pot()
    {
        return control_pot;
    }
    
   /**
    * Método que muestra en pantalla el estado de la lámpara.
    */
   public void print()
   {
    System.out.println("=========== Estado del PANEL ============");
    System.out.println("Interruptor: " + control_button);
    System.out.println("Bombilla: " + control_status);
    System.out.println("Potenciómetro: " + control_pot);
    System.out.println("Radiador: " + control_temp);
    System.out.println();
    }
    
   /**
    * Método que enciende o apaga la lámpara.
    */
   public void press()
   {
        if(control_status.toString()=="ENCENDIDA" && control_button.toString()=="ON")
        {
            control_status.turnOff();
            control_button.press();
        }
        else if(control_status.toString()=="APAGADA" && control_button.toString()=="OFF")
        {
            control_status.turnOn();
            control_button.press();
        }
        else if(control_status.toString()=="APAGADA" && control_button.toString()=="ON")
        {
            control_status.turnOn();
            control_button.press();
        }
        else if(control_status.toString()=="ENCENDIDA" && control_button.toString()=="OFF")
        {
            control_status.turnOff();
            control_button.press();
        }
    }
    
   /**
     * Lanza un error cuando no se cumple.
     */
    private void checkParam(boolean condition, String errorMsg){
        if (condition==false) {
            throw new IllegalArgumentException(errorMsg); 
        }
    }
   /**
    * Método que cambia la temperatura según la posición indicada.
    * @param position Posición introducida
    */
   public void movePotentiometer(int position)
    {
        checkParam(position>=0 && position<=10, "Posición incorrecta");
        if (position==0)
        {
            control_pot.movePosition(0);
            control_temp.changeTemperature(10);
        }
        else if (position==1)
        {
            control_pot.movePosition(1);
            control_temp.changeTemperature(11.7);
        }
        else if (position==2)
        {
            control_pot.movePosition(2);
            control_temp.changeTemperature(13.4);
        }
        else if (position==3)
        {
            control_pot.movePosition(3);
            control_temp.changeTemperature(15.1);
        }
        else if (position==4)
        {
            control_pot.movePosition(4);
            control_temp.changeTemperature(16.8);
        }
        else if (position==5)
        {
            control_pot.movePosition(5);
            control_temp.changeTemperature(18.5);
        }
        else if (position==6)
        {
            control_pot.movePosition(6);
            control_temp.changeTemperature(20.2);
        }
        else if (position==7)
        {
            control_pot.movePosition(7);
            control_temp.changeTemperature(21.9);
        }
        else if (position==8)
        {
            control_pot.movePosition(8);
            control_temp.changeTemperature(23.6);
        }
        else if (position==9)
        {
            control_pot.movePosition(9);
            control_temp.changeTemperature(25.3);
        }
        else if (position==10)
        {
            control_pot.movePosition(10);
            control_temp.changeTemperature(27);
        }
        
    }
}
