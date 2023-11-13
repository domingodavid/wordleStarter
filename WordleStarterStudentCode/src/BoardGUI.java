import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class BoardGUI extends JPanel implements KeyListener,   MouseListener{
	private Tile[][] b;
	private Board data;
	private Color[] colors;
	JPanel main2, main;
	Timer t; //used for bot 
	private ArrayList<String> dict;
	private Key[][] keys = new Key[3][];
	private String list = ""; //contains list of indexes used
	
	//starting index into the board for guessing letters
	private int row  = 0;
	private int col = 0;
	 JLabel txt = new JLabel();
	 String word = "";
	
	public BoardGUI() {
		b = new Tile[6][5];
		setup();
	}	
	
	public BoardGUI(int x, int y) {
		this();
		this.setLocation(x, y);
		frame.setLocation(x, y);
	}
	
	JFrame frame;
	public void setup( ) {
		 frame = new JFrame("WORDLE");
		frame.setSize(700, 860);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.black);
		frame.addKeyListener(this);
		
 		Font bigFont = new Font("Serif", Font.BOLD, 55);
		GridLayout g = new GridLayout(3,6);

		 main = new JPanel();
		main.setSize(new Dimension(470,540));
		main.setLayout(g);
		main.setBackground(Color.black);
		GridLayout g2 = new GridLayout(3,1);
		frame.setLayout(g2);
		
		
		JPanel message = new JPanel();
		message.setLayout(new GridLayout(1,1));
		message.add(txt);
		message.setSize(50,800);
		message.setBackground(Color.black);
  		
		main2 = new JPanel();
		main2.setLayout(new GridLayout(3, 6));
		main2.setBackground(Color.black);
 		this.setBackground(Color.black);
 		
 		for(int i =0; i < b.length/2;i++) {
			main.add(new JLabel());
			for(int j = 0; j < b[0].length;j++) {
				b[i][j] = new Tile();
				b[i][j].setSize(100,100); //				Tile.setHorizontalAlignment(JTextField.CENTER);
				b[i][j].setFont(bigFont);
				b[i][j].setHorizontalAlignment(JTextField.CENTER);
				main.add(b[i][j]);
			}
			main.add(new JLabel());
		}
 		
 		for(int i =b.length/2; i < b.length;i++) {
			main2.add(new JLabel());
			for(int j = 0; j < b[0].length;j++) {
				b[i][j] = new Tile();
				b[i][j].setSize(100,100); //				Tile.setHorizontalAlignment(JTextField.CENTER);
				b[i][j].setFont(bigFont);
				b[i][j].setHorizontalAlignment(JTextField.CENTER);
				main2.add(b[i][j]);
			}
			main2.add(new JLabel());
		}
 		frame.add(main);	
 		frame.add(main2);		

		JPanel keyboard = new JPanel();
		keyboard.setBackground(Color.black);
		keyboard.setLayout(new GridLayout(3, 1));		
		JPanel row1 = new JPanel();
		row1.setLayout(new GridLayout(1, 10));
		row1.setSize(new Dimension(5,50));
		row1.setBackground(Color.black);
		
		String[] keyRow1 = { "q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
		Key[] rowKeys1 = new Key[keyRow1.length];
		for(int i = 0; i < 10; i++) {
			Key k = new Key(keyRow1[i]);
			k.addMouseListener(this);
			k.addKeyListener(this);
			row1.add(k);
			rowKeys1[i] = k;
		}
		keys[0] = rowKeys1;
		
		
		JPanel row2 = new JPanel();
		String[] keyRow2 = { "a", "s", "d", "f", "g", "h", "j", "k", "l"};
		row2.setBackground(Color.black);
		row2.setLayout(new GridLayout(1, 9));
		row2.setSize(new Dimension(500,50));
		Key[] rowKeys2 = new Key[keyRow2.length];

		for(int i = 0; i < 9; i++) {
			Key k = new Key(keyRow2[i]);
			k.addKeyListener(this);
 
			k.addMouseListener(this);
			row2.add(k);
			rowKeys2[i] = k;
		}
		keys[1] = rowKeys2;
		
		JPanel row3 = new JPanel();
		row3.setLayout(new GridLayout(1, 9));
		String[] keyRow3 = { "ENTER","z", "x", "c", "v", "b", "n", "m" , "DEL"};
		Key[] rowKeys3 = new Key[keyRow3.length];

		row3.setBackground(Color.black);
		row3.setSize(new Dimension(500,50));
		for(int i = 0; i < 9; i++) {
			Key k = new Key(keyRow3[i]);
			if(keyRow3[i].equals("ENTER") || keyRow3[i].equals("DEL")) {
				k.setBackground(Color.gray);
			}
 			k.addMouseListener(this);
			k.addKeyListener(this);
			row3.add(k);
			rowKeys3[i] = k;
		}
		keys[2] = rowKeys3;

		
		
		
	    dict = new ArrayList<String>();
        String src = new File("").getAbsolutePath() + "/src/";
        try {
            BufferedReader br = new BufferedReader(new FileReader(src + "dict"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                dict.add(line.trim());
                line = br.readLine();
            }
            String everything = sb.toString();
        } catch (Exception ex) {
        }		
		System.out.println(dict.size());
		
		keyboard.add(row1);
		keyboard.add(row2);
		keyboard.add(row3);
		
 		frame.addKeyListener(this);
 		frame.add(keyboard);
 		frame.setBackground(Color.black);

 		this.setOpaque(true);
		this.setBackground(Color.black);
		data = new Board();
  		frame.setResizable(false);
  		
		try {
			Scanner scan = new Scanner(new File("dict"));
			while(scan.hasNext()) {
				dict.add(scan.next());
			}
			scan.close();
			int next = (int)(Math.random()*dict.size());
			this.word = dict.get(next);
			list+=next;
			System.out.println("=================");
			System.out.println(this.word);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
		//Menu bar
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;

		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("A Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		
		//a group of radio button menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Another one");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		//a submenu
		menu.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);

 
		
		
		
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.black);
		
		
		
 		update();
 

	}
	
	public void update() {
		for(int r = 0; r < b.length;r++) {
			for(int c = 0; c < b[0].length; c++) {
				b[r][c].setValue(data.getBoard()[r][c]);
			}
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		System.out.println("pressed"+arg0.getKeyCode());
		
		if(arg0.getKeyChar()>=65 && arg0.getKeyChar()<=122) {
			updateGUI(arg0.getKeyChar()+"");
		}
		else if(arg0.getKeyCode()== 8 && col >= 1){
 			data.getBoard()[row%6][--col] = "";
		}else if(arg0.getKeyCode()==10) {
			 if(col == 5) {
					String curr = "";
	 				for(Tile t: b[row]) {
	 					curr += t.getText().toLowerCase();
	 				}
	 				if(!Logic.isWord(curr, dict)) {
	 					JOptionPane.showMessageDialog(null, "My Goodness, that's not a word");

	 					return;
	 					
	 				}
				colorChange();					
				row++;
				col = 0;
			}
		}
		
 		update();
		
		 
	}

	public void updateGUI(String key) {
		if(col < 5) {
				data.getBoard()[row%6][col%5] = key+"";
				col++;
		}
 	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ty");

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ty");

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Key lab = (Key) e.getComponent(); 
		
 		if(lab.getText().equals("ENTER")) {
 			if(col == 5) {
 				
 				String curr = "";
 				for(Tile t: b[row]) {
 					curr += t.getText().toLowerCase();
 				}
 				if(!Logic.isWord(curr, dict)) { 
 					JOptionPane.showMessageDialog(null, "My Goodness, that's not a word");

 					return;
 				
 				}
 				
	 			colorChange();
				row++;
				col = 0;
			}
			 
		}else if(lab.getText().equals("DEL") && col >= 1){
			System.out.println(lab.getText());
			data.getBoard()[row%6][--col] = "";
		}else if(!lab.getText().equals("DEL")){
			updateGUI(lab.getText());
		}	
		update();
	}
	
	
	public  void colorChange() {
			String curr = "";
			for(Tile t: b[row]) {
				curr += t.getText().toLowerCase();
			}
			System.out.println("Current word is "+curr);
			for(Key[] keyRow: keys) {
				System.out.println(Arrays.toString(keyRow));
 				for(Key k: keyRow) {
 					if(curr.indexOf(k.getText().toLowerCase())>=0) {
 						((Key) k ).updateColor(Logic.exists(word, k.getText().toLowerCase() ) ? 1 : 0);
 					}
 					 
  				}
 			}
			main.revalidate();
			main2.revalidate();
			
			//Update displayed colors
			int i = 0; 
			for(Tile t: b[row]) {
				t.updateColor(Logic.location(word, curr, i++) ? 2 : t.state );
			}
			
			
		
			if( Logic.guessWord(word, curr)|| row >= 5 && col >= 5) {
		        JLabel label = new JLabel();

		        
		        
			  int result = JOptionPane.showConfirmDialog(this,"Play Again?", "",
		               JOptionPane.YES_NO_OPTION,
		               JOptionPane.QUESTION_MESSAGE);
		            if(result == JOptionPane.YES_OPTION){
		               reset();
		            }else if (result == JOptionPane.NO_OPTION){
		                System.exit(-1);
		            }else {
		                
		            }
			}
	}
	
	public void reset() {
		//reset row col
		row = 0;
		col = 0;
		int locX = frame.getX();
		int locY = frame.getY();
		frame.dispose();
	//	BoardGUI temp = new BoardGUI();
	//	temp.setLocation(locX, locY);
		new BoardGUI(locX, locY);
	 
	}

	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] arg) {
		BoardGUI b = new BoardGUI();
		System.out.println("word is "+b.word);
	}
	
}
