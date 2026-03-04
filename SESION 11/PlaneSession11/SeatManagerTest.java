import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Random;

/**
 * The test class SeatManagerTest.
 *
 * @author  David Covián Gómez
 * @version 18/11/2022
 */
public class SeatManagerTest
 {
    /**
     * Default constructor for test class SeatManagerTest
     */
    public SeatManagerTest()
    {
    }

    /**
     * Pruebas del constructor por defecto
     * Caso 1:
     */
    @Test
    public void defConst()
    {
        SeatManager sm=new SeatManager();
        
        assertEquals(sm.MIN_FIRST_ROWS, sm.getFirstRows());
        assertEquals(sm.MIN_STD_ROWS, sm.getStdRows());
        assertEquals(sm.getFirstRows()+sm.getStdRows(),sm.numberOfRows());
        assertEquals(sm.SEATS_PER_ROW,sm.numberOfColumns());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 1: Número de filas std correcto y número de filas first mínimo
     */
    @Test
    public void defConstMinFirstRowsStdOk()
    {
        int first=SeatManager.MIN_FIRST_ROWS;
        int std=SeatManager.MIN_STD_ROWS;
        SeatManager sm=new SeatManager(first,std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStdRows());
        assertEquals(sm.getFirstRows()+sm.getStdRows(),sm.numberOfRows());
        assertEquals(sm.SEATS_PER_ROW,sm.numberOfColumns());
    }
    
   /**
     * Pruebas del constructor con parámetros
     * Caso 2: Número de filas std correcto y número de filas first maximo
     */
    @Test
    public void defConstMaxFirstRowsStdOk()
    {
        int first=SeatManager.MAX_FIRST_ROWS;
        int std=SeatManager.MIN_STD_ROWS;
        SeatManager sm=new SeatManager(first,std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStdRows());
        assertEquals(sm.getFirstRows()+sm.getStdRows(),sm.numberOfRows());
        assertEquals(sm.SEATS_PER_ROW,sm.numberOfColumns());
    }
    
   /**
     * Pruebas del constructor con parámetros
     * Caso 3: Número de filas std correcto y número de filas first intermedio
     */
    @Test
    public void defConstNormalFirstRowsStdOk()
    {
        int first=(SeatManager.MAX_FIRST_ROWS + SeatManager.MIN_FIRST_ROWS)/2;
        int std=SeatManager.MIN_STD_ROWS;
        SeatManager sm=new SeatManager(first,std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStdRows());
        assertEquals(sm.getFirstRows()+sm.getStdRows(),sm.numberOfRows());
        assertEquals(sm.SEATS_PER_ROW,sm.numberOfColumns());
    }
    
   /**
     * Pruebas del constructor con parámetros
     * Caso 4: Número de filas std correcto y número de filas first por debajo del mínimo
     */
    @Test
    public void defConstBelowLimitsFirstRowsStdOk()
    {
        int first=(SeatManager.MIN_FIRST_ROWS)-1;
        int std=SeatManager.MIN_STD_ROWS;
        try
        {
            SeatManager sm=new SeatManager(first,std);
            fail("Debería de haber fallado");
        }
        catch(RuntimeException e)
        {
            assertEquals("Número inválido de filas de primera", e.getMessage());
        }
    } 
    
     /**
     * Pruebas del constructor con parámetros
     * Caso 4: Número de filas std correcto y número de filas first por encima del máximo
     */
    @Test
    public void defConstAboveLimitsFirstRowsStdOk()
    {
        int first=(SeatManager.MAX_FIRST_ROWS)+1;
        int std=SeatManager.MIN_STD_ROWS;
        try
        {
            SeatManager sm=new SeatManager(first,std);
            fail("Debería de haber fallado");
        }
        catch(RuntimeException e)
        {
            assertEquals("Número inválido de filas de primera", e.getMessage());
        }
    } 
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 6: Número de filas first correcto y número de filas std mínimo
     */
    @Test
    public void defConstMinStdRowsFirstOk()
    {
        int first=SeatManager.MIN_FIRST_ROWS;
        int std=SeatManager.MIN_STD_ROWS;
        SeatManager sm=new SeatManager(first,std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStdRows());
        assertEquals(sm.getFirstRows()+sm.getStdRows(),sm.numberOfRows());
        assertEquals(sm.SEATS_PER_ROW,sm.numberOfColumns());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 7: Número de filas first correcto y número de filas std máximo
     */
    @Test
    public void defConstMaxStdRowsFirstOk()
    {
        int first=SeatManager.MIN_FIRST_ROWS;
        int std=SeatManager.MAX_STD_ROWS;
        SeatManager sm=new SeatManager(first,std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStdRows());
        assertEquals(sm.getFirstRows()+sm.getStdRows(),sm.numberOfRows());
        assertEquals(sm.SEATS_PER_ROW,sm.numberOfColumns());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 8: Número de filas first correcto y número de filas std intermedio
     */
    @Test
    public void defConstNormalStdRowsFirstOk()
    {
        int first=SeatManager.MIN_FIRST_ROWS;
        int std=(SeatManager.MAX_STD_ROWS+SeatManager.MIN_STD_ROWS)/2;
        SeatManager sm=new SeatManager(first,std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStdRows());
        assertEquals(sm.getFirstRows()+sm.getStdRows(),sm.numberOfRows());
        assertEquals(sm.SEATS_PER_ROW,sm.numberOfColumns());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 9: Número de filas first correcto y número de filas std por debajo del mínimo
     */
    @Test
    public void defConstBelowLimitsStdRowsFirstOk()
    {
        int first=SeatManager.MIN_FIRST_ROWS;
        int std=SeatManager.MIN_STD_ROWS-1;
        try
        {
            SeatManager sm=new SeatManager(first,std);
            fail("Debería de haber fallado");
        }
        catch(RuntimeException e)
        {
            assertEquals("Número inválido de filas de turista", e.getMessage());
        }
    } 
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 10: Número de filas first correcto y número de filas std por encima del máximo
     */
    @Test
    public void defConstAboveLimitsStdRowsFirstOk()
    {
        int first=SeatManager.MIN_FIRST_ROWS;
        int std=SeatManager.MAX_STD_ROWS+1;
        try
        {
            SeatManager sm=new SeatManager(first,std);
            fail("Debería de haber fallado");
        }
        catch(RuntimeException e)
        {
            assertEquals("Número inválido de filas de turista", e.getMessage());
        }
    } 
    
    /**
     * Pruebas del método bookSeat
     * Caso P1: sentar en asiento libre
     * Caso P2: sentar en un asiento ocupado (sm=new SeatManager(); sm.bookSeat(p1,row,column); sm.bookSeat(p2,row,column)
     * Caso N1: Sentar a una persona null
     * Caso N2: sentar fila < min
     * Caso N3: sentar fila > max
     * Caso N4: sentar columna < min
     * Caso N5: sentar columna > max
     */
    
    /**
     * Pruebas del método bookSeat 
     * Caso P1: Asiento libre
     */
    @Test
    public void bookSeatFreeSeat()
    {
        Person p=new Person();
        SeatManager sm=new SeatManager(SeatManager.MAX_FIRST_ROWS, SeatManager.MAX_STD_ROWS);
        SeatManager x=sm;
        assertEquals(true,sm.bookSeat(p,2,2));
        assertEquals(x,sm);
    }
    
    /**
     * Pruebas del método bookSeat 
     * Caso P2: Asiento ocupado
     */
    @Test
    public void bookSeatOccupiedSeat()
    {
        Person p1=new Person();
        Person p2=new Person();
        SeatManager sm=new SeatManager(SeatManager.MAX_FIRST_ROWS, SeatManager.MAX_STD_ROWS);
        SeatManager x=sm;
        sm.bookSeat(p1,2,2);
        assertEquals(false, sm.bookSeat(p2,2,2));
        assertEquals(x,sm);  
    }
    
     /**
     * Pruebas del método bookSeat 
     * Caso N1: Person=null
     */
    @Test
    public void bookSeatPersonNull()
    {
        Person p=null;
        SeatManager sm=new SeatManager(SeatManager.MAX_FIRST_ROWS, SeatManager.MAX_STD_ROWS);
        try
        {
            sm.bookSeat(p,2,2);
            fail("Debería haber fallado ya que la persona no puede ser null");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("La persona a sentar tiene que existir", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método bookSeat 
     * Caso N2: fila<min
     */
    @Test
    public void bookSeatRowBelowLimits()
    {
        Person p=new Person();
        SeatManager sm=new SeatManager(SeatManager.MAX_FIRST_ROWS, SeatManager.MAX_STD_ROWS);
        try
        {
            sm.bookSeat(p,-1,2);
            fail("Debería haber fallado ya que esta fuera de rango");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Número de fila inexistente", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método bookSeat 
     * Caso N3: fila>max
     */
    @Test
    public void bookSeatRowAboveLimits()
    {
        Person p=new Person();
        SeatManager sm=new SeatManager(SeatManager.MAX_FIRST_ROWS, SeatManager.MAX_STD_ROWS);
        try
        {
            sm.bookSeat(p,sm.numberOfRows()+1,2);
            fail("Debería haber fallado ya que esta fuera de rango");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Número de fila inexistente", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método bookSeat 
     * Caso N4: columna<min
     */
    @Test
    public void bookSeatColumnBelowLimits()
    {
        Person p=new Person();
        SeatManager sm=new SeatManager(SeatManager.MAX_FIRST_ROWS, SeatManager.MAX_STD_ROWS);
        try
        {
            sm.bookSeat(p,2,-2);
            fail("Debería haber fallado ya que esta fuera de rango");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Número de columna inexistente", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método bookSeat 
     * Caso N5: columna>max
     */
    @Test
    public void bookSeatColumnAboveLimits()
    {
        Person p=new Person();
        SeatManager sm=new SeatManager(SeatManager.MAX_FIRST_ROWS, SeatManager.MAX_STD_ROWS);
        try
        {
            sm.bookSeat(p,2,sm.numberOfColumns()+1);
            fail("Debería haber fallado ya que esta fuera de rango");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Número de columna inexistente", e.getMessage());
        }
    }
 
    /**
     * Pruebas del método getYoungestPeople
     * Caso 1: avión vacío (devuelve ArrayList vacío)
     */
    @Test
    public void getYoungestPeoplePlaneEmptyPlane()
    {
        SeatManager sm=new SeatManager();
        ArrayList<Person> output=sm.getYoungestPeople();
        assertNotNull(output);
        assertEquals(0,output.size());
    }
    
    // /**
     // * Pruebas del método getYoungestPeople
     // * Caso 2: varios con edad mínima (1 de ellos en la posiciçon (0,0), otro en la esquina de abajo a la derecha, y otro aleatorio)
     // */
    // @Test
    // public void getYoungestPeoplePlaneNotEmptyPlane()
    // {
        // SeatManager sm=new SeatManager();
        // Random r=new Random();
        // int row, column;
        
        // Person p1=new Person(10);
        // Person p2=new Person(10);
        // Person p3=new Person(10);
        // sm.bookSeat(p1, 0,0);
        // sm.bookSeat(p2, sm.numberOfRows()-1, sm.numberOfColumns()-1);
        // sm.bookSeat(p3, 2,3); //posición cualquiera
        
        // for (int i=0; i<15;i++)
        // {
            // Person p=new Person(i+11);
            // row=r.nextInt(sm.numberOfRows());
            // column=r.nextint(sm.numberOfColumns());
            // sm.bookeSeat()
        // }
        
        
        // ArrayList<Person> output=sm.getYoungestPeople();
        //assertEquals
       
    // }
 }
