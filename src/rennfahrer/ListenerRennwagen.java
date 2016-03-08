package rennfahrer;

import java.awt.Button;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

import javax.swing.JList;

import db.bean.Rennwagen;

/**
 * The Class ListenerRennwagen.
 */
public class ListenerRennwagen extends WindowAdapter 
implements ActionListener, MouseListener
{  
	
	/** The guirennwagen. */
	private GuiRennwagen      guirennwagen;
	
	/** The vectorrennwagen. */
	private Vector<Rennwagen> vectorrennwagen = new Vector<Rennwagen>();

	/**
	 * Instantiates a new listener rennwagen.
	 *
	 * @param guirennwagen the guirennwagen
	 */
	public ListenerRennwagen(GuiRennwagen guirennwagen)
	{ 
		this.guirennwagen = guirennwagen;
	}

	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{ 
		Rennwagen rennwagen  = new Rennwagen();
		Boolean   duplicate  = false;
		Button    button     = (Button) e.getSource();
		
		if (button.getActionCommand() == "OK")
		{  
			this.guirennwagen.liesRennwagendaten(rennwagen);
			List<Rennwagen> dbList = guirennwagen.getRennwagenInDatabase();
			
			System.out.println("current rw: " + rennwagen.getId());
			
			for (int i = 0; i < dbList.size(); i++) {
				
				System.out.println("db rw id: " + dbList.get(i).getId());
				
				if (dbList.get(i).getId().equals(rennwagen.getId())) {
					guirennwagen.removeRennwagenFromList(rennwagen);
					rennwagen.updateInDatabase();
					duplicate = true;
				}
			}
			
			if (duplicate == false) {
				
				this.vectorrennwagen.add(rennwagen);	
				rennwagen.createInDatabase();
			}
			
			this.guirennwagen.initRennwagendaten();
			this.guirennwagen.zeigeRennwagendaten(rennwagen.toString());
		}
		
		if (button.getActionCommand() == "Ende")
		{  
			this.guirennwagen.dispose();
		}
		
		if (button.getActionCommand() == "Aendern")
		{  	
//			for (int i = 0; i < this.vectorrennwagen.size(); i++)
//			{
//				if (this.vectorrennwagen.elementAt(i).getId().equals(this.guirennwagen.getRennwagenid()))
//				{
//					this.guirennwagen.initRennwagendaten();
//					this.guirennwagen.zeigeRennwagendaten(this.vectorrennwagen.elementAt(i));
//				}
//			}
		}
		if (button.getActionCommand() == "Laden") {
			guirennwagen.ladeRennwagendatenAusDatenbankInListe();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
	 */
	public void windowClosing(WindowEvent e)
	{   
		guirennwagen.dispose();         
	}


	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		int index = 0;
		
		if (e.getClickCount() == 1) {
			
			JList source = (JList) e.getSource();
			index = source.locationToIndex(e.getPoint()); 
//			guirennwagen.zeigeRennwagendaten(((Rennwagen) source.getSelectedValue()));
			System.out.println("Index " + index + " wurde ausgew�hlt");
		}
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arge0) 
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}
