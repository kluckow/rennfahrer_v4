package rennfahrer;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import db.bean.Rennwagen;
import db.conn.MyConnection;

/**
 * The Class GuiRennwagen.
 */
public class GuiRennwagen extends Frame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6657521948093026829L;
	
	/** The la_ueberschrift. */
	private Label la_ueberschrift;
	
	/** The la_rennwagenid. */
	private Label la_rennwagenid;
	
	/** The tf_rennwagenid. */
	private TextField tf_rennwagenid;
	
	/** The la_modell. */
	private Label la_modell;
	
	/** The tf_modell. */
	private TextField tf_modell;
	
	/** The la_hersteller. */
	private Label la_hersteller;
	
	/** The tf_hersteller. */
	private TextField tf_hersteller;
	
	/** The la_leistung. */
	private Label la_leistung;
	
	/** The tf_leistung. */
	private TextField tf_leistung;
	
	/** The la_hubraum. */
	private Label la_hubraum;
	
	/** The tf_hubraum. */
	private TextField tf_hubraum;
	
	/** The la_maxtankinhalt. */
	private Label la_maxtankinhalt;
	
	/** The tf_maxtankinhalt. */
	private TextField tf_maxtankinhalt;
	
	/** The la_isttankinhalt. */
	private Label la_isttankinhalt;
	
	/** The tf_isttankinhalt. */
	private TextField tf_isttankinhalt;
	
	/** The bu_ok. */
	private Button bu_ok;
	
	/** The bu_ende. */
	private Button bu_ende;
	
	/** The bu_aendern. */
	private Button bu_aendern;
	
	/** The bu_laden. */
	private Button bu_laden;
	
	/** The pa_oben. */
	private Panel pa_oben;
	
	/** The pa_mitte. */
	private Panel pa_mitte;
	
	/** The pa_unten. */
	private Panel pa_unten;

	/** The borderlayout. */
	private BorderLayout borderlayout = new BorderLayout();

	/** The listener_rennwagen. */
	private ListenerRennwagen listener_rennwagen = null;

	/** The defaultlistmodel. */
	private DefaultListModel defaultlistmodel = null;
	
	/** The ergebnis. */
	private JList ergebnis = null;
	
	/** The scrollpane. */
	private JScrollPane scrollpane = null;

	/**
	 * Instantiates a new gui rennwagen.
	 *
	 * @param title the title
	 */
	public GuiRennwagen(String title) {
		super(title);

		this.listener_rennwagen = new ListenerRennwagen(this);
		this.setSize(500, 400);

		this.la_ueberschrift = new Label("Rennwagenverwaltung");
		this.la_rennwagenid = new Label("Rennwagenid");
		this.tf_rennwagenid = new TextField(30);
		this.la_modell = new Label("Modell");
		this.tf_modell = new TextField(30);
		this.la_hersteller = new Label("Hersteller");
		this.tf_hersteller = new TextField(30);
		this.la_leistung = new Label("Leistung");
		this.tf_leistung = new TextField(30);
		this.la_hubraum = new Label("Hubraum");
		this.tf_hubraum = new TextField(30);
		this.la_maxtankinhalt = new Label("maixmaler Tankinhalt");
		this.tf_maxtankinhalt = new TextField(30);
		this.la_isttankinhalt = new Label("aktueller Tankinhalt");
		this.tf_isttankinhalt = new TextField(30);
		this.bu_ok = new Button("OK");
		this.bu_ende = new Button("Ende");
		this.bu_aendern = new Button("Aendern");
		this.bu_laden = new Button("Laden");
		this.pa_oben = new Panel(new FlowLayout());
		this.pa_unten = new Panel(new FlowLayout());
		this.pa_mitte = new Panel(new GridLayout(0, 2));

		this.setLayout(borderlayout);

		this.pa_oben.add(la_ueberschrift);
		this.pa_mitte.add(la_rennwagenid);
		this.pa_mitte.add(tf_rennwagenid);
		this.pa_mitte.add(la_modell);
		this.pa_mitte.add(tf_modell);
		this.pa_mitte.add(la_hersteller);
		this.pa_mitte.add(tf_hersteller);
		this.pa_mitte.add(la_leistung);
		this.pa_mitte.add(tf_leistung);
		this.pa_mitte.add(la_hubraum);
		this.pa_mitte.add(tf_hubraum);
		this.pa_mitte.add(la_maxtankinhalt);
		this.pa_mitte.add(tf_maxtankinhalt);
		this.pa_mitte.add(la_isttankinhalt);
		this.pa_mitte.add(tf_isttankinhalt);
		this.pa_mitte.add(bu_ende);
		this.pa_mitte.add(bu_ok);
		this.pa_mitte.add(bu_aendern);
		this.pa_mitte.add(bu_laden);

		this.defaultlistmodel = new DefaultListModel();
		this.ergebnis = new JList(defaultlistmodel);
		this.scrollpane = new JScrollPane(ergebnis);

		this.pa_unten.add(scrollpane);

		this.add(pa_oben, BorderLayout.NORTH);
		this.add(pa_mitte, BorderLayout.CENTER);
		this.add(pa_unten, BorderLayout.SOUTH);

		this.addWindowListener(this.listener_rennwagen);
		this.bu_ok.addActionListener(this.listener_rennwagen);
		this.bu_ende.addActionListener(this.listener_rennwagen);
		this.bu_aendern.addActionListener(this.listener_rennwagen);
		this.bu_laden.addActionListener(this.listener_rennwagen);
		this.ergebnis.addMouseListener(this.listener_rennwagen);

//		ladeRennwagendatenAusDatenbank();
		
		this.pack();
	}

	/**
	 * Lies rennwagendaten.
	 *
	 * @param rennwagen the rennwagen
	 * @return the rennwagen
	 */
	public Rennwagen liesRennwagendaten(Rennwagen rennwagen) {
		rennwagen.update(Long.parseLong(this.tf_rennwagenid.getText()), this.tf_modell.getText(), this.tf_hersteller.getText(),
				Integer.parseInt(this.tf_leistung.getText()), Integer.parseInt(this.tf_hubraum.getText()),
				Float.parseFloat(this.tf_maxtankinhalt.getText()), Float.parseFloat(this.tf_maxtankinhalt.getText()));

		return rennwagen;
	}

	/**
	 * Gets the rennwagenid.
	 *
	 * @return the rennwagenid
	 */
	public String getRennwagenid() {
		return this.tf_rennwagenid.getText();
	}

	/**
	 * Zeige rennwagendaten.
	 *
	 * @param rennwagendaten the rennwagendaten
	 */
	public void zeigeRennwagendaten(String rennwagendaten) {
		
		defaultlistmodel.addElement(rennwagendaten);
	}
	
	/**
	 * Lade rennwagendaten aus datenbank in liste.
	 */
	public void ladeRennwagendatenAusDatenbankInListe() {
		
		defaultlistmodel.removeAllElements();
		
		List<Rennwagen> rwList = getRennwagenInDatabase();
		for (Rennwagen rw : rwList) {
			defaultlistmodel.addElement(rw.toString());
		}
	}
	
	/**
	 * Gets the rennwagen in database.
	 *
	 * @return the rennwagen in database
	 */
	public List<Rennwagen> getRennwagenInDatabase() {
		
		List<Rennwagen> dbList = new ArrayList<Rennwagen>();
		String sql = "SELECT "
				+ "id, modell, hersteller, leistung, hubraum, ist_tankinhalt, max_tankinhalt "
				+ "FROM "
				+ "t_rennwagen";
		
		Rennwagen tempRw = null;
		ResultSet res = null;
		MyConnection con = new MyConnection();
		
		try {
			
			res = con.getStmt().executeQuery(sql);
			
			while (res.next()) {
				
				tempRw = new Rennwagen(res.getLong("id"), res.getString("modell"), res.getString("hersteller"),
					res.getInt("leistung"), res.getInt("hubraum"), res.getFloat("ist_tankinhalt"),
					res.getFloat("max_tankinhalt"));
				dbList.add(tempRw);
			}
			
			if (con.getStmt() != null) con.getStmt().close();
			if (con.getCon() != null) con.getCon().close();
		} catch (SQLException e) {
			System.out.println("Could not execute SQL Query!");
		}
		return dbList;
	}

	/**
	 * Inits the rennwagendaten.
	 */
	public void initRennwagendaten() {
		this.tf_rennwagenid.setText("");
		this.tf_modell.setText("");
		this.tf_hersteller.setText("");
		this.tf_leistung.setText("");
		this.tf_hubraum.setText("");
		this.tf_maxtankinhalt.setText("");
		this.tf_isttankinhalt.setText("");
	}

	/**
	 * Zeige rennwagendaten.
	 *
	 * @param rennwagen the rennwagen
	 */
	public void zeigeRennwagendaten(Rennwagen rennwagen) {
		this.tf_rennwagenid.setText(String.valueOf(rennwagen.getId()));
		this.tf_modell.setText(rennwagen.getModell());
		this.tf_hersteller.setText(rennwagen.getHersteller());
		this.tf_leistung.setText(Integer.toString(rennwagen.getLeistung()));
		this.tf_hubraum.setText(Integer.toString(rennwagen.getHubraum()));
		this.tf_maxtankinhalt.setText(Float.toString(rennwagen.getMaxtankinhalt()));
		this.tf_isttankinhalt.setText(Float.toString(rennwagen.getIsttankinhalt()));

//		sortListByIndex();
		
		this.setVisible(true);
	}

	/**
	 * Removes the rennwagen from list.
	 *
	 * @param rennwagen the rennwagen
	 */
	public void removeRennwagenFromList(Rennwagen rennwagen) {
		
		for (int i = 0; i < defaultlistmodel.size(); i++) {
			if (( (Rennwagen) defaultlistmodel.getElementAt(i)).getId().equals(rennwagen.getId())) {
				defaultlistmodel.remove(i);
			}
		}
	}

	/**
	 * Sort list by index.
	 */
	public void sortListByIndex() {
		List<String> rwList = (List<String>) defaultlistmodel;
		Collections.sort(rwList);
	}
	
}