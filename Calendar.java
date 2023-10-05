/*
 * Author: Shivam and Nathaniel
 * Date: 6/1/22
 * Description: Class thawt performs all the actions, manages the user inputs, anbd creates the grid
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.management.AttributeChangeNotification;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calendar implements ActionListener{
	//creates the frame, containers and buttons
	JFrame frame = new JFrame();
	JButton January = new JButton("Jan");
	JButton February = new JButton("Feb");
	JButton March = new JButton("Mar");
	JButton April = new JButton("Apr");
	JButton May = new JButton("May");
	JButton June = new JButton("Jun");
	JButton July = new JButton("Jul");
	JButton August = new JButton("Aug");
	JButton September = new JButton("Sep");
	JButton October = new JButton("Oct");
	JButton November = new JButton("Nov");
	JButton December = new JButton("Dec");
	JButton newEvent = new JButton("Add Event");
	JButton remove = new JButton("Remove Event");
	JTextField subject = new JTextField("Subject");
	JTextField date = new JTextField("Day");
	Container north = new Container();
	Container south = new Container();
	CalendarGrid current;
	
	
	public Calendar(){
		//sets the size of the frawme and adds things to it
		frame.setSize(800, 700);
		frame.setLayout(new BorderLayout());
		
		north.setLayout(new GridLayout(1, 12));
		north.add(January);
		January.addActionListener(this);
		north.add(February);
		February.addActionListener(this);
		north.add(March);
		March.addActionListener(this);
		north.add(April);
		April.addActionListener(this);
		north.add(May);
		May.addActionListener(this);
		north.add(June);
		June.addActionListener(this);
		north.add(July);
		July.addActionListener(this);
		north.add(August);
		August.addActionListener(this);
		north.add(September);
		September.addActionListener(this);
		north.add(October);
		October.addActionListener(this);
		north.add(November);
		November.addActionListener(this);
		north.add(December);
		December.addActionListener(this);
		frame.add(north, BorderLayout.NORTH);
		
		south.setLayout(new GridLayout(1, 4));
		south.add(newEvent);
		newEvent.addActionListener(this);
		south.add(remove);
		remove.addActionListener(this);
		south.add(subject);
		south.add(date);
		frame.add(south, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Calendar();

	}
	//inputs everything in the file to the buttons in the grid
	String filename;
	public void inputEvents(String fileName) {
		Scanner fileInput = new Scanner(System.in);
		try {
			fileInput = new Scanner(new File(fileName + ".txt"));
			
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
				System.exit(0);			
			}
			String infile = fileInput.nextLine();
			System.out.println("Whats being read in " + infile);
			String[] inputStringArray = infile.split("@");
			for (int i = 0; i < inputStringArray.length; i++) {
				System.out.println(inputStringArray[i]);
				String[] inputs = inputStringArray[i].split(",");
				for (int j = 0; j < inputs.length; j++) {
					if(inputs[j].equals("") == false) {
						current.getAllEvents().get(i).add(inputs[j]);
					}
				}
			}
			current.highlight();
			filename = fileName;
	}
	//goes through to check which month is pressed, goes to that month, and sets it to the current month
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(January)) {
			
			CalendarGrid grid = new CalendarGrid(6, 31);
			if(current != null) {
				frame.remove(current.getCenter());
			}
			frame.add(grid.getCenter() , BorderLayout.CENTER);
			current = grid;
			frame.resize(800, 900);
			frame.resize(1000, 700);
			frame.repaint();
			inputEvents("Jan");
		}
		else if(e.getSource().equals(February)) {
			
			CalendarGrid grid = new CalendarGrid(2, 28);
			if(current != null) {
				frame.remove(current.getCenter());
			}
		    frame.add(grid.getCenter() , BorderLayout.CENTER);
		    current = grid;
		    frame.resize(800, 900);
			frame.resize(1000, 700);
			frame.repaint();
			inputEvents("Feb");
		}
		else if(e.getSource().equals(March)) {
			
			CalendarGrid grid = new CalendarGrid(2, 31);
			if(current != null) {
				frame.remove(current.getCenter());
			}
			frame.add(grid.getCenter() , BorderLayout.CENTER);
			current = grid;
			frame.resize(800, 900);
			frame.resize(1000, 700);
			frame.repaint();
			inputEvents("Mar");
		}
		else if(e.getSource().equals(April)) {
			
			CalendarGrid grid = new CalendarGrid(5, 30);
			if(current != null) {
				frame.remove(current.getCenter());
			}
			frame.add(grid.getCenter() , BorderLayout.CENTER);
			current = grid;
			frame.resize(800, 900);
			frame.resize(1000, 700);
			frame.repaint();
			inputEvents("Apr");
		}
		else if(e.getSource().equals(May)) {
			
			CalendarGrid grid = new CalendarGrid(0, 31);
			if(current != null) {
				frame.remove(current.getCenter());
			}
			frame.add(grid.getCenter() , BorderLayout.CENTER);
			current = grid;
			frame.resize(800, 900);
			frame.resize(1000, 700);
			frame.repaint();
			inputEvents("May");
		}
		else if(e.getSource().equals(June)) {
			
			CalendarGrid grid = new CalendarGrid(3, 30);
			if(current != null) {
				frame.remove(current.getCenter());
			}
			frame.add(grid.getCenter() , BorderLayout.CENTER);
			current = grid;
			frame.resize(800, 900);
			frame.resize(1000, 700);
			frame.repaint();
			inputEvents("Jun");
		}
		else if(e.getSource().equals(July)) {
			
			CalendarGrid grid = new CalendarGrid(5, 31);
			if(current != null) {
				frame.remove(current.getCenter());
			}
			frame.add(grid.getCenter() , BorderLayout.CENTER);
			current = grid;
			frame.resize(800, 900);
			frame.resize(1000, 700);
			frame.repaint();
			inputEvents("Jul");
		}
		else if(e.getSource().equals(August)) {
			
			CalendarGrid grid = new CalendarGrid(1, 31);
			if(current != null) {
				frame.remove(current.getCenter());
			}
			frame.add(grid.getCenter() , BorderLayout.CENTER);
			current = grid;
			frame.resize(800, 900);
			frame.resize(1000, 700);
			frame.repaint();
			inputEvents("Aug");
		}
		else if(e.getSource().equals(September)) {
			
			CalendarGrid grid = new CalendarGrid(4, 30);
			if(current != null) {
				frame.remove(current.getCenter());
			}
			frame.add(grid.getCenter() , BorderLayout.CENTER);
			current = grid;
			frame.resize(800, 900);
			frame.resize(1000, 700);
			frame.repaint();
			inputEvents("Sep");
		}
		else if(e.getSource().equals(October)) {
			
			CalendarGrid grid = new CalendarGrid(6, 31);
			if(current != null) {
				frame.remove(current.getCenter());
			}
			frame.add(grid.getCenter() , BorderLayout.CENTER);
			current = grid;
			frame.resize(800, 900);
			frame.resize(1000, 700);
			frame.repaint();
			inputEvents("Oct");
		}
		else if(e.getSource().equals(November)) {
			
			CalendarGrid grid = new CalendarGrid(2, 30);
			if(current != null) {
				frame.remove(current.getCenter());
			}
			frame.add(grid.getCenter() , BorderLayout.CENTER);
			current = grid;
			frame.resize(800, 900);
			frame.resize(1000, 700);
			frame.repaint();
			inputEvents("Nov");
		}
		else if(e.getSource().equals(December)) {
			
			CalendarGrid grid = new CalendarGrid(4, 31);
			if(current != null) {
				frame.remove(current.getCenter());
			}
			frame.add(grid.getCenter() , BorderLayout.CENTER);
			current = grid;
			frame.resize(800, 900);
			frame.resize(1000, 700);
			frame.repaint();
			inputEvents("Dec");
		}
		//adds event to grid
		else if(e.getSource().equals(newEvent)) {
			if(current != null) {
				if(subject.getText() != "") {
					if((current.getLabelButton(date.getText()) == (null)) == false) {
						current.getAllEvents().get(current.getIndex()).add(subject.getText());
						current.highlight();
						JOptionPane.showMessageDialog(frame, "Event has been added. Click on the day to see the event");
						
						//Output Attempt (Have to clerify confusion with Mr. G)
						//Checks if file exists
									Scanner textGet = new Scanner(System.in);
									try {
										textGet = new Scanner(new File(filename + ".txt"));
										
										} catch (FileNotFoundException ex) {
											ex.printStackTrace();
											System.exit(0);			
										}
									String input = textGet.nextLine();
									PrintWriter pw;
									//print into a new output file
									try {
										pw = new PrintWriter(new FileWriter(new File(filename + ".txt")));
										String output = input;
										int index = -1;
										for (int i = 0; i < Integer.parseInt(date.getText()); i++) {
											index = output.indexOf('@', index + 1);
										}
										System.out.println("index of the @: " + index);
										output = addEvent(input, subject.getText(), index);
										pw.write(output);
										System.out.println("What is being outputed into the file: " + output);
										pw.close();
									} catch (IOException ex) {
										ex.printStackTrace();
										System.exit(0);
									}
					}
					else {
						JOptionPane.showMessageDialog(frame, "That date does not exist");
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Write a subject for your event");
				}
			}
			else {
				JOptionPane.showMessageDialog(frame, "Select a starting month");
			}
		}
		// removes event from grid
		else if(e.getSource().equals(remove)) {
			if(current != null) {
				if(subject != null) {
					if(current.getLabelButton(date.getText()).equals(null) == false) {
						current.getAllEvents().get(current.getIndex()).remove(subject.getText());
						current.highlight();
						JOptionPane.showMessageDialog(frame, "Event has been removed. Click on the day to check");
						
					}
					else {
						JOptionPane.showMessageDialog(frame, "That date does not exist");
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Write the correct subject for your event");
				}
			}
		}
	}

	private String addEvent(String current, String str, int index) {
		StringBuilder changeStr = new StringBuilder();
		changeStr.append(current);
		if(index != 0) {
			if(changeStr.charAt(index - 1) == '@' && changeStr.charAt(index) == '@') {
				changeStr.insert(index, str);
			}
			else {
				changeStr.insert(index, ',' + str);
			}
		}
		else {
			changeStr.insert(index, str);
		}
		return changeStr.toString();
	}
}