

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class FigureTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FigureTest
{
    /**
     * Default constructor for test class FigureTest
     */
    public FigureTest()
    {
    }
    
    /**
     * Pruebas del constructor sin parámetros
     * Caso único:
     */
    @Test
    public void constWithoutParams()
    {
        Figure f=new Figure();
        
        assertEquals("Monstruo", f.getName());
        assertEquals(0,f.getXPos());
        assertEquals(0,f.getYPos());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 1: Parámetros correctos
     */
    @Test
    public void constWithParams()
    {
        Figure f=new Figure("Jugador",23,78);
        
        assertEquals("Jugador", f.getName());
        assertEquals(23,f.getXPos());
        assertEquals(78,f.getYPos());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 2: xPos fuera de rango
     */
    @Test
    public void constWithParamXPosAboveLimitsDown()
    {
        try
        {
            Figure f=new Figure("Monstruo",Figure.X_LOWER_EDGE-1,0);
            fail("Coordenadas fuera de rango");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Coordenada fuera de rango", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 3: xPos fuera de rango
     */
    @Test
    public void constWithParamXPosAboveLimitsUp()
    {
        try
        {
            Figure f=new Figure("Monstruo",Figure.X_UPPER_EDGE+1,0);
            fail("Coordenadas fuera de rango");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Coordenada fuera de rango", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 4: yPos fuera de rango
     */
    @Test
    public void constWithParamYPosBelowLimits()
    {
        try
        {
            Figure f=new Figure("Monstruo",0,Figure.Y_LOWER_EDGE-1);
            fail("Coordenadas fuera de rango");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Coordenada fuera de rango", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 5: yPos fuera de rango
     */
    @Test
    public void constWithParamYPosUnderLimits()
    {
        try
        {
            Figure f=new Figure("Monstruo",0,Figure.Y_UPPER_EDGE+1);
            fail("Coordenadas fuera de rango");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Coordenada fuera de rango", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 6: name igual a null
     */
    @Test
    public void constWithParamsNameEqualNull()
    {
        Figure f=new Figure(null,0,0);
        
        assertEquals(null, f.getName());
        assertEquals(0,f.getXPos());
        assertEquals(0,f.getYPos());
    }
    
    /**
     * Pruebas del método move()
     * Caso P1: LEFT
     */
    @Test
    public void moveLeft()
    {
        Figure f=new Figure("Monstruo",10,10);
        
        f.move('L');
        assertEquals(9,f.getXPos());
        assertEquals(10, f.getYPos());
    }
    
    /**
     * Pruebas del método move()
     * Caso P2: RIGHT
     */
    @Test
    public void moveRight()
    {
        Figure f=new Figure("Monstruo",10,10);
        
        f.move('R');
        assertEquals(11,f.getXPos());
        assertEquals(10, f.getYPos());
    }
    
    /**
     * Pruebas del método move()
     * Caso P3: UP
     */
    @Test
    public void moveUP()
    {
        Figure f=new Figure("Monstruo",10,10);
        
        f.move('U');
        assertEquals(11,f.getYPos());
        assertEquals(10, f.getXPos());
    }
    
    /**
     * Pruebas del método move()
     * Caso P4: DOWN
     */
    @Test
    public void moveDown()
    {
        Figure f=new Figure("Monstruo",10,10);
        
        f.move('D');
        assertEquals(9,f.getYPos());
        assertEquals(10, f.getXPos());
    }
    
    /**
     * Pruebas del método move()
     * Caso N1: LEFT con xPos=0
     */
    @Test
    public void moveLeftN1()
    {
        Figure f=new Figure();
        try{
            f.move('L');
            fail("Coordenada fuera de rango");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Coordenada fuera de rango", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método move()
     * Caso N2: RIGHT con xPos=MAX.
     */
    @Test
    public void moveRightN1()
    {
        Figure f=new Figure("Monstruo",Figure.X_UPPER_EDGE,Figure.Y_UPPER_EDGE);
        try{
            f.move('R');
            fail("Coordenada fuera de rango");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Coordenada fuera de rango", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método move()
     * Caso N3: DOWN con yPos=0
     */
    @Test
    public void moveDownN1()
    {
        Figure f=new Figure();
        try{
            f.move('D');
            fail("Coordenada fuera de rango");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Coordenada fuera de rango", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método move()
     * Caso N4: UP con yPos=MAX.
     */
    @Test
    public void moveUpN1()
    {
        Figure f=new Figure("Monstruo",Figure.X_UPPER_EDGE,Figure.Y_UPPER_EDGE);
        try{
            f.move('U');
            fail("Coordenada fuera de rango");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Coordenada fuera de rango", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método move()
     * Caso N5: Letra incorrecta
     */
    @Test
    public void moveN5()
    {
         Figure f=new Figure("Monstruo",10,10);
        
        f.move('X');
        assertEquals(10,f.getYPos());
        assertEquals(10, f.getYPos());
    }
    
    /**
     * Pruebas del método toString()
     * Caso 1:
     */
    @Test
    public void toStringCorrect()
    {
        Figure f=new Figure();
        assertEquals(f.getName() + "-" + f.getXPos() + "-" + f.getYPos(),f.toString());
    }
}
