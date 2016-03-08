package rennfahrer;

/**
 * The Class Fahrer.
 *
 * @author Ingrid
 */
public class Fahrer 
{
    
    /** The fahrerid. */
    private int    fahrerid;
    
    /** The vorname. */
    private String vorname;
    
    /** The name. */
    private String name;
    
    /** The alter. */
    private int    alter;
    
    /** The gehalt. */
    private double gehalt;
    
    /**
     * Instantiates a new fahrer.
     *
     * @param fahrerid the fahrerid
     * @param vorname the vorname
     * @param nachname the nachname
     * @param alter the alter
     * @param gehalt the gehalt
     */
    public Fahrer(int    fahrerid, 
                  String vorname, 
                  String nachname, 
                  int    alter, 
                  double gehalt)
    {
        this.fahrerid = fahrerid;
        this.vorname  = vorname;
        this.name     = nachname;
        this.alter    = alter;
        this.gehalt   = gehalt;
    }
    
    /**
     * Instantiates a new fahrer.
     *
     * @param fahrerid the fahrerid
     * @param vorname the vorname
     * @param nachname the nachname
     */
    public Fahrer(int    fahrerid, 
                  String vorname, 
                  String nachname)
    {
        this.fahrerid = fahrerid;
        this.vorname  = vorname;
        this.name     = nachname;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId()
    {
        return this.fahrerid;
    }

    /**
     * Gets the vorname.
     *
     * @return the vorname
     */
    public String getVorname()
    {
        return this.vorname;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Gets the alter.
     *
     * @return the alter
     */
    public int getAlter()
    {
        return this.alter;
    }

    /**
     * Gets the gehalt.
     *
     * @return the gehalt
     */
    public double getGehalt()
    {
        return this.gehalt;
    }

    /**
     * Sets the vorname.
     *
     * @param vorname the new vorname
     */
    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Sets the alter.
     *
     * @param alter the new alter
     */
    public void setAlter(int alter)
    {
        this.alter = alter;
    }
    
    /**
     * Sets the gehalt.
     *
     * @param gehalt the new gehalt
     */
    public void setGehalt(int gehalt)
    {
        this.gehalt = gehalt;
    }
     
    /**
     * Gets the info.
     *
     * @return the info
     */
    public void getInfo()
    {
        /**
         * Die Methode getInfo() protokolliert 
         * alle wichtigen Merkmale eines Fahrerobjekts. 
         */
        System.out.println("Fahrerid: " + 
                           this.getId());
        
        System.out.println("Vorname: " + 
                           this.getVorname());
        
        System.out.println("Name: " + 
                           this.getName());
        
        System.out.println("Alter: " +
                           this.getAlter());
        
        System.out.println("Gehalt: " +
                           this.getGehalt());  
    }
}
