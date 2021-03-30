package Quartile;
/**
 * This class represents the GUI of this project.
 * @author Marius Haueis
 * @version 30.03.2021
 */
import java.io.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class GUI {
	private JFrame frame;
	private JPanel panel;
	private JTextField input;
	private JTextField number;
	private JButton exitButton;
	ArrayList<Integer> list = new ArrayList<Integer>(51);
	ArrayList<Integer> result = new ArrayList<Integer>();
	
	public GUI() {
	//Set up
	QuartilesCalculator calculator = new QuartilesCalculator();
	frame = new JFrame();
	panel = new JPanel();

	//Buttons and input fields
	exitButton = new JButton("Start");
	exitButton.setFont(new Font("SansSerif", Font.BOLD, 50));
	input = new JTextField("Input numbers here", 51);
	input.setFont(new Font("SansSerif", Font.BOLD, 25));
	
	
		//Panel settings
		panel.setBorder(BorderFactory.createEmptyBorder(40, 80, 80, 80));
		panel.setLayout(new GridLayout(0, 1)); 
		
		panel.setLayout(new GridLayout(0, 1));
		panel.add(exitButton);
		panel.add(input); 
		
		exitButton.addActionListener(e -> {
			if (e.getSource() == exitButton) {			
				int n = Integer.parseInt(input.getText().trim());
				while(n>0) {
					 while (n > 0) {
				            list.add(n % 10);
				            n = n / 10;
				}
				}		
				result = (ArrayList<Integer>) calculator.quartiles(list);
				int g = result.size();
				System.out.println("The left quartile: " + result.get(0));
				System.out.println("The left quartile: " + result.get(1));
				System.out.println("The left quartile: " + result.get(2));
		}
		});
		
		frame.setSize(800, 400);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Quartiles");
		frame.setVisible(true);
	
}
}

