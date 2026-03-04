import java.util.Random;
import java.util.ArrayList;

/**
 * Write a description of class SeatManager here.
 * 
 * @author David Covián Gómez
 * @version 18/11/2022
 */
public class SeatManager
{
    public static final int SEATS_PER_ROW=6;
    public static final int MIN_FIRST_ROWS=3;
    public static final int MAX_FIRST_ROWS=10;
    public static final int MIN_STD_ROWS=4;
    public static final int MAX_STD_ROWS=40;
    
    private Person[][] seats;
    private int firstRows;
    private int stdRows;
    
    /**
     * Crea un gestor del pasaje estándar (con 3 filas de primera y 4 de turista)
     */
    public SeatManager()
    {
        setFirstRows(MIN_FIRST_ROWS);
        setStdRows(MIN_STD_ROWS);
        seats=new Person[getFirstRows()+getStdRows()] [SEATS_PER_ROW];
    }
    /**
     * Crea un gestor del pasaje estándar (con 3 filas de primera y 4 de turista), con un número determinado de personas abordo
     * @param n Número de pasajeros en el avión
     */
    public SeatManager(int n)
    {
        this();
        Random r=new Random();
        int row;
        int column;
        for(int i=0;i<n;i++)
        {
            Person p=new Person();
            do
            {
            row=r.nextInt(numberOfRows());
            column=r.nextInt(numberOfColumns());
            bookSeat(p,row,column);
            }while(bookSeat(p,row,column)==true);
        }
    }
    
    /**
     * Crea un gestor del pasaje estándar (con tantas filas de primera y de turista como se nos especifique)
     * @param firstRows Número de filas de primera clase
     * @param stdRows Número de filas de la clase turista
     */
    public SeatManager(int firstRows, int stdRows)
    {
        setFirstRows(firstRows);
        setStdRows(stdRows);
        seats=new Person[getFirstRows()+getStdRows()] [SEATS_PER_ROW];
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
     * Permite modificar el número de filas de primera
     * @param firstRows Número de filas de primera     
     */
    private void setFirstRows(int firstRows)
    {
        checkParam(firstRows>=MIN_FIRST_ROWS && firstRows<=MAX_FIRST_ROWS, "Número inválido de filas de primera");
        this.firstRows=firstRows;
    }
    
    /**
     * Permite modificar el número de filas de turista
     * @param stdRows Número de filas     
     */
    private void setStdRows(int stdRows)
    {
        checkParam(stdRows>=MIN_STD_ROWS && stdRows<=MAX_STD_ROWS, "Número inválido de filas de turista");
        this.stdRows=stdRows;
    }
    
    /**
     * Devuelve el númerto de filas que hay en primera
     * @return Filas de primera
     */
    public int getFirstRows()
    {
        return firstRows;
    }
    
    /**
     * Devuelve el númerto de filas que hay en turista
     * @return Filas de turista
     */
    public int getStdRows()
    {
        return stdRows;
    }
    
    /**
     * Devuelve una posición determinada del pasaje
     * @param row fila
     * @param column columna (número de asiento dentro de la fila)
     * @return Pasajero sentado en una posición del avión; null si está vacío
     */
    public Person getSeat(int row, int column)
    {
        checkParam(row>=0 && row<=numberOfRows(),"Número de fila inexistente");
        checkParam(column>=0 && column<=numberOfColumns(),"Número de columna inexistente");
        return seats[row][column];
    }
    
    /**
     * Modifica una posición determinada del pasaje
     * @param row fila
     * @param column columna (número de asiento dentro de la fila)
     * @return Pasajero sentado en una posición del avión; null si está vacío
     */
    private void setSeat(Person p, int row, int column)
    {
        checkParam(row>=0 && row<=numberOfRows(),"Número de fila inexistente");
        checkParam(column>=0 && column<=numberOfColumns(),"Número de columna inexistente");
        seats[row][column]=p;
    }
    
    /**
     * Devuelve el número de filas totales
     * @return Número de filas
     */
    public int numberOfRows()
    {
        return getFirstRows()+getStdRows();
        //return seats.length;
    }
    
     /**
     * Devuelve el número de asientos por fila del avión
     * @return Número de asientos por fila del avión
     */
    public int numberOfColumns()
    {
        return SEATS_PER_ROW;
        //return seats[0].length;
    }
    
    /**
     * Permite reservar un asiento para la`persona indicada
     * @param p Persona a sentar
     * @param row Fila en la que se reserva el asiento
     * @param column Columna en la que se reserva el asiento
     * @return true si se ha sentado a la persona; false si no se ha podido sentar
     */
    public boolean bookSeat(Person p, int row, int column)
    {
        checkParam(p!=null, "La persona a sentar tiene que existir");
        if(getSeat(row, column)!=null)
        {
            // el asiento esta ocupado
            return false;
        }
        else
        {
            setSeat(p,row,column);
            return true;
        }
    }
    
    /**
     * Libera el asiento indicado, devolviendo la persona que estaba sentada ahí (o null si estaba vacío)
     * @param row fila en la que se libera el asiento
     * @return Persona que ocupaba el asiento o null si estaba libre
     */
    public Person releaseSeat(int row, int column)
    {
        Person p=getSeat(row, column);
        if (p==null)
        {
            // el asiento estaba libre
            return null;
        }
        else
        {
            // el asiento estaba ocupado
            setSeat(null, row, column);
            return p;
        }
    }
    
    /**
     * Devuelve la edad de la persona más jóven
     * @return Edad más pequeña
     */
    private int getMinAge()
    {
        int min=Person.MAX_AGE;
        for(int r=0;r<numberOfRows();r++)
        {
            for(int c=0;r<numberOfColumns();c++)
            {
                Person p=getSeat(r,c);
                if(p!=null && p.getAge()<min)
                    min=p.getAge();
            }
        }
        return min;
    }
    
    /**
     * Devuelve un ArrayList de personas con las personas de menor edad del avión
     * @return ArrayList más jóvenes
     */
    public ArrayList<Person> getYoungestPeople()
    {
        ArrayList<Person> alp=new ArrayList<Person>();
        int minAge=getMinAge();
        if (minAge==Person.MAX_AGE)
            return alp;
        for (int i=0; i<numberOfRows();i++)
        {
            for (int j=0; j<numberOfColumns();j++)
            {
                Person p=getSeat(i,j);
                if (p!=null && p.getAge()<minAge)
                {
                    alp.add(p);
                }
            }
        }
        return alp;
    }
    
    /**
     * Imprime en pantalla los sitios libres (?), los asientos ocupados por adultos (X) y los ocupados por niños (C)
     */
    public void print()
    {
        int x=0;
        Person p=new Person();
        System.out.print(" ");
        for (int i=0; i<numberOfRows()-1;i++)
            System.out.print("  "+i);
            
        System.out.println();    
        for (int i=0; i<numberOfRows(); i++)
        {
            System.out.print(x);
            System.out.print("  ");
            for (int j=0; j<numberOfColumns();j++)
            {   
                System.out.print(bookSeat(p,i,j)?(releaseSeat(i,j).getAge()<p.ADULTHOOD_AGE?("C"):("X")):("?"));
                System.out.print("  ");
            }
            System.out.println();
            x+=1;
        }
    
    }
    
    /**
     *  Devuelve un ArrayList de personas con las personas menores de edad del avión
     *  @return ArrayList de menores de edad
     */
    public ArrayList<Person> childrenPassengers()
    {
         ArrayList<Person> alp=new ArrayList<Person>();
        for (int i=0; i<numberOfRows();i++)
        {
            for (int j=0; j<numberOfColumns();j++)
            {
                Person p=getSeat(i,j);
                if (p!=null && p.getAge()<Person.ADULTHOOD_AGE)
                {
                    alp.add(p);
                }
            }
        }
        return alp;
    }
    
    
}
