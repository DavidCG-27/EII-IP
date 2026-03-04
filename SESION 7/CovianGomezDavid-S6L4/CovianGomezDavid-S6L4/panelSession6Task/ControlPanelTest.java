import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ControlPanelTest.
 *
 * @author  David Covián Gómez
 * @version 21-10-2022
 */
public class ControlPanelTest
{
   /**
    * Pruebas del método press()
    * Caso 1: Lámpara y bombilla encendidas
    */
   @Test
   public void pressLampOnSwitchOn()
   {
       ControlPanel c=new ControlPanel();
       c.getControl_Status().turnOn();
       c.getControl_Button().press();
       c.press();
       assertEquals(false, c.getControl_Status().getStatus());
       assertEquals(false, c.getControl_Button().getButton());
   }
   
   /**
    * Pruebas del método press()
    * Caso 2: Lámpara y bombilla apagadas
    */
   @Test
   public void pressLampOffSwitchOff()
   {
       ControlPanel c=new ControlPanel();
       c.press();
       assertEquals(true, c.getControl_Status().getStatus());
       assertEquals(true, c.getControl_Button().getButton());
   }
   
    /**
    * Pruebas del método press()
    * Caso 3: Lámpara encendida y bombilla apagada
    */
   @Test
   public void pressLampOnSwitchOff()
   {
       ControlPanel c=new ControlPanel();
       c.getControl_Status().turnOn();
       c.press();
       assertEquals(false, c.getControl_Status().getStatus());
       assertEquals(true, c.getControl_Button().getButton());
   }
   
   /**
    * Pruebas del método press()
    * Caso 4: Lámpara apagada y bombilla encendida
    */
   @Test
   public void pressLampOffSwitchOn()
   {
       ControlPanel c=new ControlPanel();
       c.getControl_Button().press();
       c.press();
       assertEquals(true, c.getControl_Status().getStatus());
       assertEquals(false, c.getControl_Button().getButton());
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 1: Posición 0
    */
   @Test
   public void movePotentiometerPosition0()
   {
       ControlPanel c=new ControlPanel();
       c.movePotentiometer(0);
       assertEquals(10, c.getControl_Temp().getTemperature());
       assertEquals(0, c.getControl_Pot().getPosition());
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 2: Posición 1
    */
   @Test
   public void movePotentiometerPosition1()
   {
       ControlPanel c=new ControlPanel();
       c.movePotentiometer(1);
       assertEquals(11.7, c.getControl_Temp().getTemperature());
       assertEquals(1, c.getControl_Pot().getPosition());
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 3: Posición 2
    */
   @Test
   public void movePotentiometerPosition2()
   {
       ControlPanel c=new ControlPanel();
       c.movePotentiometer(2);
       assertEquals(13.4, c.getControl_Temp().getTemperature());
       assertEquals(2, c.getControl_Pot().getPosition());
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 4: Posición 3
    */
   @Test
   public void movePotentiometerPosition3()
   {
       ControlPanel c=new ControlPanel();
       c.movePotentiometer(3);
       assertEquals(15.1, c.getControl_Temp().getTemperature());
       assertEquals(3, c.getControl_Pot().getPosition());
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 5: Posición 4
    */
   @Test
   public void movePotentiometerPosition4()
   {
       ControlPanel c=new ControlPanel();
       c.movePotentiometer(4);
       assertEquals(16.8, c.getControl_Temp().getTemperature());
       assertEquals(4, c.getControl_Pot().getPosition());
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 6: Posición 5
    */
   @Test
   public void movePotentiometerPosition5()
   {
       ControlPanel c=new ControlPanel();
       c.movePotentiometer(5);
       assertEquals(18.5, c.getControl_Temp().getTemperature());
       assertEquals(5, c.getControl_Pot().getPosition());
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 7: Posición 6
    */
   @Test
   public void movePotentiometerPosition6()
   {
       ControlPanel c=new ControlPanel();
       c.movePotentiometer(6);
       assertEquals(20.2, c.getControl_Temp().getTemperature());
       assertEquals(6, c.getControl_Pot().getPosition());
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 8: Posición 7
    */
   @Test
   public void movePotentiometerPosition7()
   {
       ControlPanel c=new ControlPanel();
       c.movePotentiometer(7);
       assertEquals(21.9, c.getControl_Temp().getTemperature());
       assertEquals(7, c.getControl_Pot().getPosition());
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 9: Posición 8
    */
   @Test
   public void movePotentiometerPosition8()
   {
       ControlPanel c=new ControlPanel();
       c.movePotentiometer(8);
       assertEquals(23.6, c.getControl_Temp().getTemperature());
       assertEquals(8, c.getControl_Pot().getPosition());
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 10: Posición 9
    */
   @Test
   public void movePotentiometerPosition9()
   {
       ControlPanel c=new ControlPanel();
       c.movePotentiometer(9);
       assertEquals(25.3, c.getControl_Temp().getTemperature());
       assertEquals(9, c.getControl_Pot().getPosition());
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 11: Posición 10
    */
   @Test
   public void movePotentiometerPosition10()
   {
       ControlPanel c=new ControlPanel();
       c.movePotentiometer(10);
       assertEquals(27, c.getControl_Temp().getTemperature());
       assertEquals(10, c.getControl_Pot().getPosition());
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 12: Posición menor que 0
    */
   @Test
   public void movePotentiometerPositionBelowLimits()
   {
       ControlPanel c=new ControlPanel();
       try{
           c.movePotentiometer(Potentiometer.MIN_VALUE-1);
           fail("Valor inválido");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Posición incorrecta", e.getMessage());
        }
   }
   
   /**
    * Pruebas del método movePotentiometer()
    * Caso 12: Posición mayor que 10
    */
   @Test
   public void movePotentiometerPositionAboveLimits()
   {
       ControlPanel c=new ControlPanel();
       try{
           c.movePotentiometer(Potentiometer.MAX_VALUE+1);
           fail("Valor inválido");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Posición incorrecta", e.getMessage());
        }
   }
}
