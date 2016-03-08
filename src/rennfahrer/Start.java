package rennfahrer;

import java.sql.SQLException;

import db.conn.MyConnection;

public class Start {

	public static void main(String[] args) {
		
		GuiRennwagen guirennwagen = new GuiRennwagen("Rennwageneingabe");
		guirennwagen.setVisible(true);
		
	}	
}
