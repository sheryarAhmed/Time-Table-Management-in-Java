import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App2 {
    static String col [] = {"Days",
    "8:00am to 9:30am",
    "9:40am to 11:10am",
    "11:20am to 12:50pm",
    "1:40pm to 3:10pm",
    "3:20pm to 4:50pm"};
    static String section []={"BCE-4A","BCE-4B","BCE-4C","BCE-4D","BCE-4E","BCE-4F"};
    
    public static void main(String[] args) {
        GUI frame = new GUI("Time Table", 1280, 720, null);
        PanelGui panel1 = new PanelGui(new FlowLayout(1,10,10), 1280, 72);                
        PanelGui panel3 = new PanelGui(null, 960, 648);
        panel1.setBackground(Color.WHITE);
        
        

        // panel 1 

        Widgets wd = new Widgets();
        wd.setLabel(panel1.getPanel(), "Chose the Section", 0, 0, 200, 20);
        wd.setComboBox(panel1.getPanel(), section, 0, 0, 300, 100);
        wd.setButton(panel1.getPanel(), "Check Table", 0, 0, 200, 100);
        check.main(args);
        // panel 3 
        wd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int index = wd.getComboIndex(1);
                panel3.removeComp();
                panel3.repaint();
                // String s = String.format("index %d length of class %d length of col %d",index,check.getClass(index).length,0);
                // wd.setLabel(panel3.getPanel(), s, 100, 0, 500, 200);
                String [][] s = check.getClass(index);
                // check.printArray(s);
                wd.setTable(panel3.getPanel(), s, col, 0, 0, 1280, 960, Color.white, Color.black);
            }
        });        
        


        panel1.setBounds(0, 0, 1280, 72);
        panel3.setBounds(0, 72, 1280, 960);

        frame.addPanel(panel1.getPanel());
        frame.addPanel(panel3.getPanel());
        frame.run();

    }
    
    
}
