import java.awt.*;
import java.awt.event.*;


public class admin {
    static TimeTableGenerator table;
    public static void main(String[] args) {
       
        table = TimeTableGenerator.genrate(data.faculty);
        GUI frame = new GUI("Adminstration", 1280, 720, null);
        PanelGui panel = new PanelGui(new FlowLayout(1,150,5), 1280, 72);
        PanelGui panel2 = new PanelGui(null, 1280, 700);
        panel.setBackground(Color.GRAY);
        Widgets wd = new Widgets();
        wd.setLabel(panel.getPanel(), "Faculty", 0, 0, 100, 50);
        wd.setComboBox(panel.getPanel(), data.faculty, 0, 0, 100, 50);
        wd.comboListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               panel2.removeComp();
               panel2.repaint();
                int index = wd.getComboIndex(0);
                String [][] classes = table.getteacher2Darray(index);
                Section sc = new Section(classes);
                wd.setTable(panel2.getPanel(), sc.getData(),data.col, 0, 0, 1280, 700, Color.white, Color.black); 
            }
        });


        wd.setLabel(panel.getPanel(), "Sections", 0, 0, 100, 50);
        wd.setComboBox(panel.getPanel(), data.section, 0, 0, 100, 50);
       wd.comboListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
           panel2.removeComp();
           panel2.repaint();
            int index = wd.getComboIndex(0);
            String [][] classes = table.get2Darray(index);
            Section sc = new Section(classes);
            wd.setTable(panel2.getPanel(), sc.getData(),data.col, 0, 0, 1280, 700, Color.white, Color.black);
        }
       });
        wd.setButton(panel.getPanel(), "Genrate", 600, 0, 100, 20);
        panel.setBounds(0, 0, 1280, 72);
        panel2.setBounds(0, 72, 1280, 700);
        frame.addPanel(panel2.getPanel());
        frame.addPanel(panel.getPanel());
        frame.run();
        

    }
    
    
}
