import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        GUI frame = new GUI("Time Table", 1280, 720, null);
        PanelGui panel = new PanelGui(new GridLayout(5,1) , 320, 360);
        PanelGui panel2 = new PanelGui(new FlowLayout(1,10,10), 960, 72);                
        PanelGui panel3 = new PanelGui(null, 960, 648);
        PanelGui panel4 = new PanelGui(null, 320, 360);
        panel.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        panel4.setBackground(Color.WHITE);
        
        

        // panel 1 

        Widgets wd = new Widgets();
        wd.setHeading();
        wd.setLabel(panel2.getPanel(), "Welcome to the TimeTable System", 0, 0, 200, 50);
        wd.setTextStyle();
        wd.labelIcon(panel.getPanel(),"images/right-arrow-icon.png" ,"Constraints", 0, 0, 50, 50);
        wd.setButton(panel.getPanel(), "Student", 0, 0, 0, 0);
        
    

        wd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                panel2.removeComp();
                panel2.repaint();
                panel2.setBackground(Color.LIGHT_GRAY);
                wd.setLabel(panel2.getPanel(), "Pick the Section", 0, 11, 100, 50);
                String day[] = {"Section 1","Section 2","Section 3","Section 4","Section 5"};
                wd.setComboBox(panel2.getPanel(), day, 0, 11, 150, 50);

                wd.setButton(panel2.getPanel(), "Generate", 0, 0, 50, 25);

                

            }

        });

        wd.setButton(panel.getPanel(), "Teachers", 0, 0, 0, 0);
        wd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                panel2.removeComp();
                panel2.repaint();
                panel2.setBackground(Color.LIGHT_GRAY);
                wd.setLabel(panel2.getPanel(), "Pick the day", 0, 11, 100, 50);
                String day[] = {"Monday","Tuesday","Wednessday","Thursday","Friday"};
                wd.setComboBox(panel2.getPanel(), day, 0, 11, 150, 50);
                
                wd.setLabel(panel2.getPanel(), "Pick the Faculity", 0, 11, 150, 50);
                String teacher[] = {"Teacher 1","Teacher 2","Teacher 3","Teacher 4","Teacher 5"};
                wd.setComboBox(panel2.getPanel(), teacher, 0, 11, 150, 50); 


                wd.setLabel(panel2.getPanel(), "Pick the slot", 0, 11, 100, 50);
                String slot[] = {"slot 1","slot 2","slot 3","slot 4","slot 5"};
                wd.setComboBox(panel2.getPanel(), slot, 0, 11, 150, 50);

                wd.setButton(panel2.getPanel(), "Generate", 0, 0, 50, 25);
                

            }

        });
        
        wd.setButton(panel.getPanel(), "Coordinator", 0, 0, 0, 0);
        wd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                panel2.removeComp();
                panel2.repaint();
                panel2.setBackground(Color.LIGHT_GRAY);
                wd.setLabel(panel2.getPanel(), "Pick the Section", 0, 11, 100, 50);
                String section[] = {"Section 1","Section 2","Section 3","Section 4","Section 5"};
                wd.setComboBox(panel2.getPanel(), section, 0, 11, 150, 50);


                wd.setLabel(panel2.getPanel(), "Pick the day", 0, 11, 100, 50);
                String day[] = {"Monday","Tuesday","Wednessday","Thursday","Friday"};
                wd.setComboBox(panel2.getPanel(), day, 0, 11, 150, 50);
                
                wd.setLabel(panel2.getPanel(), "Pick the Faculity", 0, 11, 150, 50);
                String teacher[] = {"Teacher 1","Teacher 2","Teacher 3","Teacher 4","Teacher 5"};
                wd.setComboBox(panel2.getPanel(), teacher, 0, 11, 150, 50); 


                wd.setLabel(panel2.getPanel(), "Pick the slot", 0, 11, 100, 50);
                String slot[] = {"slot 1","slot 2","slot 3","slot 4","slot 5"};
                wd.setComboBox(panel2.getPanel(), slot, 0, 11, 150, 50);

                wd.setButton(panel2.getPanel(), "Generate", 0, 0, 50, 25);

                

            }

        });
        
        // panel 3 
        String data [][] = {{"Monday","slot 1","slot 2","slot 3","slot 4","slot 5"},
                            {"Tuesday","slot 1","slot 2","slot 3","slot 4","slot 5"},
                            {"Wednessday","slot 1","slot 2","slot 3","slot 4","slot 5"},
                            {"Thursday","slot 1","slot 2","slot 3","slot 4","slot 5"},
                            {"Friday","slot 1","slot 2","slot 3","slot 4","slot 5"},
                            {"Saturday","slot 1","slot 2","slot 3","slot 4","slot 5"},
                            {"Sunday","slot 1","slot 2","slot 3","slot 4","slot 5"},
                            };
        String col [] = {"Days","8:00am to 9:30am","9:40am to 11:10am","11:20am to 12:50pm","1:40pm to 3:10pm","3:20pm to 4:50pm"};
        
        wd.setTable(panel3.getPanel(), data, col, 10, 0, 940, 648,Color.WHITE,Color.BLACK);
        wd.addImage(panel4.getPanel(), "images/time2.png", 0, 5, 360, 360);
        


        panel.setBounds(0, 0, 320, 360);
        panel2.setBounds(320, 0, 960, 72);
        panel3.setBounds(320, 72, 960, 648);
        panel4.setBounds(0, 360, 320, 360);

        frame.addPanel(panel.getPanel());
        frame.addPanel(panel2.getPanel());
        frame.addPanel(panel3.getPanel());
        frame.addPanel(panel4.getPanel());
        frame.run();

    }
    
    
}
