import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

@SuppressWarnings("serial")
public class TornChainPay extends JFrame implements ActionListener{

	//Fields.
	private int playerOutcome = 0;
	private int rating = 5;
	private double rate = 0.10;
	private final double mil = 2000000;
	private final double mill = 3000000;
	private boolean checking = true;
	private String hitRange;
	private JTextField textInput = new JTextField(3);
	private JLabel label = new JLabel("Outcome: ");
	private JButton calculate = new JButton("Ok");
	private JButton exit = new JButton("Exit");
	private JPanel pane1 = new JPanel(new GridLayout(3, 3));
	private JPanel pane2 = new JPanel(new GridBagLayout());
	NumberFormat myFormat = NumberFormat.getInstance();
	
	public TornChainPay() 
	{
		//Set dimensions.
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		//Define panel positions.	
		add(pane1);
		add(pane2, BorderLayout.SOUTH);

		//Build the panel.
		buildPanel();

		//Define frame size, visibility and default close parameters.
		setTitle("Torn Chain Pay");
		setSize(150,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//Constructor.
	
	public void buildPanel()
	{
			GridBagConstraints cons = new GridBagConstraints();
			cons.anchor = GridBagConstraints.CENTER;
			cons.insets = new Insets(10,10,0,0);
			
			label.setBounds(2,2,10,10);
			label.setBounds(1,1,10,10);
			cons.gridx = 0;
			cons.gridy = 0;
			pane1.add(label, cons);
		 
			cons.gridx = 0;
			cons.gridy = 1;
			pane1.add(textInput, cons);

			pane2.add(calculate);
			pane2.add(exit);
			
			//Create event handling objects.
			calculate.addActionListener(new calc());
			exit.addActionListener(new exit());
			
		    textInput.addActionListener(new java.awt.event.ActionListener() 
		    {
		    	public void actionPerformed(ActionEvent e) 
		    	{
		    	calc();
		    	}
		    });//Text input.
	}//Panel builder.

	//Calc.
	public class calc implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			calc();
		}//Action Performed
	}//Calc Listener.
	
	//Calc.
	public class exit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
		}//Action Performed
	}//Calc Listener.

	public void calc()
	{
		checking = true;
		hitRange = textInput.getText();
		playerOutcome = Integer.parseInt(hitRange);
		label.setText("Outcome: " + String.valueOf(playerOutcome));
		
		while(checking)
		{
			
			if(playerOutcome < rating && playerOutcome >= rating -5)
			{
				if(playerOutcome < 50)
				{
					String s = ("Outcome : $");
					label.setText(s + myFormat.format(mil * rate));
					checking = false;
				}//-50 If.
				
				if(playerOutcome >= 50)
				{
					if(playerOutcome >= 80)
					{
						String s = ("Outcome : $");
						label.setText(s + myFormat.format(mill));
						checking = false;
					}//If.
					else 
					{
						String s = ("Outcome : $");
						label.setText(s + myFormat.format(mill * rate));
						checking = false;
					}//Else.
				}//+50 If.
			}//If.
			else 
			{
				rating += 5;
				rate += .05;	
			}//Else.
		}//While.
		playerOutcome = 0;
		rating = 5;
		rate = .10;
	}//Calc.
	
	public static void main(String [] args) 
	{
		new TornChainPay();
	}//Main.

	@Override public void actionPerformed(ActionEvent arg0) {}//Action performed.
}//Class.
