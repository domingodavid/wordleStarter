import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

public class Tile extends JLabel {
	public static  int tots = 0;
	private Color c;
	private Color cb;
	private String val = "";
	int state = 0;
	
	public Tile() {
		cb = Color.black;
		setOpaque(true);
		tots++;		
		MatteBorder matte = new MatteBorder(2,2,2,2,cb);
		this.setForeground(Color.white);
		this.setBorder(matte);
		this.setText("");
 	}
	
	
	public void setValue(String v) {
		if(v == null) val = "";
		else val = v;
		 val = val.toUpperCase();
		setText(val);
		updateColor(this.state);

	}
	public Tile(String v) {
		this();
		val = v.toUpperCase();
		if(val.length()>0) {
			setText(val);
		}
	}
	
	public void updateColor(int val) {
		this.state = val;
		switch(state) {
			case 0:
				c = new Color(44,44,44);
	 			break;
			case 1://yellow
				c = new Color(165,144, 44);
				break;
			case 2: //green
				c = new Color(68, 124, 62);
				break;
		}
		this.setBackground(c);
	}
	
	public void reset() {
		this.state = 0;
		cb = Color.black;
		setOpaque(true);
		tots++;		
		MatteBorder matte = new MatteBorder(2,2,2,2,cb);
		this.setForeground(Color.white);
		this.val = "";
		this.setValue(null);
		this.setBorder(matte);
	}
	

}
