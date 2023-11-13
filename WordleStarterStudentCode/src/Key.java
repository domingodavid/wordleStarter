import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

public class Key extends JButton {
	public static  int tots = 0;
	private Color c;
	private Color cb;
	String val = "";
	int cIndex = 2;
	
	public Key() {
		cb = Color.black;
		setOpaque(true);
		tots++;		
		MatteBorder matte = new MatteBorder(4,4,4,4,cb);
		this.setForeground(Color.white);
		this.setBorder(matte);
		this.setBackground(new Color(44,44,44));
 	}
 
	public Key(String v) {
		this();
		val = v.toUpperCase();
		if(val.length()>0) {
			setText(val);
		}
	}
	
	public void updateColor(int res) {
		System.out.println("update color");
		
		if(this.cIndex == 0 || this.cIndex == 1 ) return;
		
		this.cIndex = res;
		switch(res) {
		case 0: //guessed
			c = new Color(25, 25, 25);
			this.setForeground(Color.white);
			break;
		case 1: //correct
			c = new Color(68, 124, 62);
			break;
		case 2: //default
			c = new Color(44,44,44);
			break;
		}
		
		 setBackground(c);
	}
	
	public String toString() {
		return cIndex + ":"+val;
	}
	
	public void reset() {
		cb = Color.black;
		setOpaque(true);
		tots++;		
		MatteBorder matte = new MatteBorder(4,4,4,4,cb);
		this.setForeground(Color.white);
		this.setBorder(matte);
		this.setBackground(new Color(44,44,44));
		cIndex = 2;
	}

}
