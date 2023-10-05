import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
 	

public class CalendarGrid implements ActionListener{
	Container center = new Container();
	ArrayList<JButton> events = new ArrayList<JButton>();
	ArrayList<ArrayList<String>> allEvents = new ArrayList<ArrayList<String>>();
	//allEvents is equal to file value
	Color VERY_LIGHT_GRAY = new Color (201,196,196);
	
	public CalendarGrid(int blanks, int day) {
		int x = (blanks + day) / 7 + 1;
		if((blanks + day) % 7 >= 1) {
			x++;
		}
		center.setLayout(new GridLayout(x, 7));	
		
		center.add(new JLabel("Sunday"));
		center.add(new JLabel("Monday"));
		center.add(new JLabel("Tuesday"));
		center.add(new JLabel("Wednesday"));
		center.add(new JLabel("Thursday"));
		center.add(new JLabel("Friday"));
		center.add(new JLabel("Saturday"));
		
		for(int i = 0; i < blanks; i++) {
			JLabel blank = new JLabel();
			center.add(blank);
			
		}
		for (int i = 0; i < day; i++) {
			JButton date = new JButton("" + (i + 1));
			date.setBackground(VERY_LIGHT_GRAY);
			date.addActionListener(this);
			center.add(date);
			events.add(date);
			allEvents.add(new ArrayList<String>());
		}
		
	}
	
	public Container getCenter() {
		return center;
	}
	
	int index = 0;
	public JButton getLabelButton(String s) {
		for(int i = 0; i < events.size(); i++) {
			if(events.get(i).getText().equals(s)) {
				index = i;
				System.out.println(index);
				return events.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<ArrayList<String>> getAllEvents(){
		return allEvents;
	}
	
	public int getIndex(){
		return index;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < events.size(); i++) {
			if(e.getSource().equals(events.get(i))) {
				String eventsList = "";
				if(allEvents.get(i).size() > 0) {
					for(int j = 0; j < allEvents.get(i).size(); j++) {
						eventsList = eventsList + (j + 1) + ") " + allEvents.get(i).get(j) + "\n";	
					}
					JOptionPane.showMessageDialog(center, "Events today:\n" + eventsList);
				}
				else {
					JOptionPane.showMessageDialog(center, "No events today");
				}
			}
		}
	}
	
	
	public void highlight() {
		for(int i = 0; i < allEvents.size(); i++) {
			if(allEvents.get(i).size() > 0) {
				events.get(i).setBackground(Color.pink);
			}
			else {
				events.get(i).setBackground(VERY_LIGHT_GRAY);
			}
		}
	}
}
