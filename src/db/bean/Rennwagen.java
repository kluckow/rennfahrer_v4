package db.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.conn.MyConnection;
import rennfahrer.Fahrer;

/**
 * The Class Rennwagen.
 */
public class Rennwagen {
	
	/** The Constant TABLE_NAME. */
	private static final String TABLE_NAME = "t_rennwagen";
	
	/** The id. */
	private Long id;
	
	/** The modell. */
	private String modell;
	
	/** The hersteller. */
	private String hersteller;
	
	/** The leistung. */
	private int leistung;
	
	/** The hubraum. */
	private int hubraum;
	
	/** The isttankinhalt. */
	private float isttankinhalt;
	
	/** The maxtankinhalt. */
	private float maxtankinhalt;
	
	/** The meinefahrer. */
	private List<Fahrer> meinefahrer = new ArrayList<Fahrer>();
	
	/**
	 * Instantiates a new rennwagen.
	 */
	public Rennwagen() {
	}
	
	/**
	 * Instantiates a new rennwagen.
	 *
	 * @param id the id
	 * @param modell the modell
	 * @param hersteller the hersteller
	 * @param leistung the leistung
	 * @param hubraum the hubraum
	 * @param isttankinhalt the isttankinhalt
	 * @param maxtankinhalt the maxtankinhalt
	 */
	public Rennwagen(Long id, String modell, String hersteller, int leistung, int hubraum, float isttankinhalt, float maxtankinhalt) {
		this.id = id;
		this.modell = modell;
		this.hersteller = hersteller;
		this.leistung = leistung;
		this.hubraum = hubraum;
		this.isttankinhalt = isttankinhalt;
		this.maxtankinhalt = maxtankinhalt;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Gets the modell.
	 *
	 * @return the modell
	 */
	public String getModell() {
		return this.modell;
	}

	/**
	 * Sets the modell.
	 *
	 * @param modell the new modell
	 */
	public void setModell(String modell) {
		this.modell = modell;
	}

	/**
	 * Gets the hersteller.
	 *
	 * @return the hersteller
	 */
	public String getHersteller() {
		return this.hersteller;
	}

	/**
	 * Sets the hersteller.
	 *
	 * @param hersteller the new hersteller
	 */
	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	/**
	 * Gets the leistung.
	 *
	 * @return the leistung
	 */
	public int getLeistung() {
		return this.leistung;
	}

	/**
	 * Sets the leistung.
	 *
	 * @param leistung the new leistung
	 */
	public void setLeistung(int leistung) {
		this.leistung = leistung;
	}

	/**
	 * Gets the hubraum.
	 *
	 * @return the hubraum
	 */
	public int getHubraum() // Kubikzentimeter
	{
		return this.hubraum;
	}
	
	/**
	 * Sets the hubraum.
	 *
	 * @param hubraum the new hubraum
	 */
	public void setHubraum(int hubraum) // Kubikzentimeter
	{
		this.hubraum = hubraum;
	}
	
	/**
	 * Gets the isttankinhalt.
	 *
	 * @return the isttankinhalt
	 */
	public float getIsttankinhalt() {
		return this.isttankinhalt;
	}
	
	/**
	 * Sets the isttankinhalt.
	 *
	 * @param isttankinhalt the new isttankinhalt
	 */
	public void setIsttankinhalt(float isttankinhalt) {
		if (isttankinhalt <= this.getMaxtankinhalt()) {
			this.isttankinhalt = isttankinhalt;
		} else {
			this.isttankinhalt = this.getMaxtankinhalt();
			System.out.println("Tank l�uft �ber!");
		}
	}
	
	/**
	 * Gets the maxtankinhalt.
	 *
	 * @return the maxtankinhalt
	 */
	public float getMaxtankinhalt() {
		return this.maxtankinhalt;
	}
	
	/**
	 * Sets the maxtankinhalt.
	 *
	 * @param maxtankinhalt the new maxtankinhalt
	 */
	public void setMaxtankinhalt(int maxtankinhalt) {
		this.maxtankinhalt = maxtankinhalt;
	}
	
	/**
	 * Fahren.
	 *
	 * @param gefahrenekilometer the gefahrenekilometer
	 * @param durchschnittsverbrauch the durchschnittsverbrauch
	 */
	public void fahren(float gefahrenekilometer, float durchschnittsverbrauch) {
		// Durchschnittsverbrauch = liter pro 100 km
		float verbrauch = gefahrenekilometer * durchschnittsverbrauch / 100;

		if (verbrauch >= this.getIsttankinhalt()) {
			this.setIsttankinhalt(0);
			System.out.println("Tank leer. Sie sind leider liegen geblieben!");
		} else {
			this.setIsttankinhalt(this.getIsttankinhalt() - verbrauch);
		}
	}
	
	/**
	 * Tanken.
	 *
	 * @param liter the liter
	 */
	public void tanken(float liter) {
		this.setIsttankinhalt(this.getIsttankinhalt() + liter);
	}
	
	/**
	 * Einfuegen fahrer.
	 *
	 * @param fahrer the fahrer
	 */
	public void einfuegenFahrer(Fahrer fahrer) {
		meinefahrer.add(fahrer);
	}
	
	/**
	 * Einfuegen fahrer.
	 *
	 * @param fahrer the fahrer
	 * @param index the index
	 */
	public void einfuegenFahrer(Fahrer fahrer, int index) {
		meinefahrer.add(index, fahrer);
	}
	
	/**
	 * Loesche fahrer.
	 *
	 * @param index the index
	 */
	public void loescheFahrer(int index) {
		meinefahrer.remove(index);
	}
	
	/**
	 * Drucke fahrerliste.
	 */
	public void druckeFahrerliste() {
		System.out.println("M�gliche Fahrer des Wagens " + this.id + ":\n\n");

		for (int i = 0; i < this.meinefahrer.size(); i++) {
			((Fahrer) this.meinefahrer.get(i)).getInfo();
			System.out.println();
		}
	}
	
	/**
	 * Update.
	 *
	 * @param id the id
	 * @param modell the modell
	 * @param hersteller the hersteller
	 * @param leistung the leistung
	 * @param hubraum the hubraum
	 * @param maxtankinhalt the maxtankinhalt
	 * @param isttankinhalt the isttankinhalt
	 */
	public void update(long id, String modell, String hersteller, int leistung, int hubraum, float maxtankinhalt,
			float isttankinhalt) {
		this.id = id;
		this.modell = modell;
		this.hersteller = hersteller;
		this.leistung = leistung;
		this.hubraum = hubraum;
		this.maxtankinhalt = maxtankinhalt;
		this.isttankinhalt = isttankinhalt;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String wrk = this.id + "    " + this.modell + "    " + this.hersteller + "    " + this.leistung + "    "
				+ this.hubraum + "    " + this.maxtankinhalt + "    " + this.isttankinhalt + "\n";
		return wrk;
	}
	
	/**
	 * Creates the in database.
	 */
	public void createInDatabase() {
		System.out.println("INSERT");
		String sql = "INSERT INTO " + TABLE_NAME + " "
				 + "(modell, hersteller, leistung, hubraum, ist_tankinhalt,max_tankinhalt) "
				 + "VALUES ('" + this.modell + "', '" + this.hersteller + "', " + this.leistung + ", "
				 + this.hubraum + ", " + this.isttankinhalt + ", " + this.maxtankinhalt + ")";
		executeQuery(sql);
	}
	
	/**
	 * Update in database.
	 */
	public void updateInDatabase() {
		System.out.println("UPDATE");
		String sql = "UPDATE " + TABLE_NAME + " SET "
				+ "modell='" + this.modell + "', hersteller='" + this.hersteller + "', "
				+ "leistung=" + this.leistung + ", hubraum=" + this.hubraum + ", "
				+ "ist_tankinhalt=" + this.isttankinhalt + ", max_tankinhalt=" + this.maxtankinhalt + " "
				+ "WHERE id=" + this.id;
		executeQuery(sql);
	}
	
	/**
	 * Execute query.
	 *
	 * @param sql the sql
	 */
	private void executeQuery(String sql) {
		
		MyConnection con = new MyConnection();
		try {
			int code = con.getStmt().executeUpdate(sql);
			System.out.println("return value of sql: " + code);
			if (con.getStmt() != null) con.getStmt().close();
			if (con.getCon() != null) con.getCon().close();
		} catch (SQLException e) {
			System.out.println("Could not execute SQL Query!");
		}
	}
}
