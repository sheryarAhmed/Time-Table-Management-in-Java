import java.awt.*;
import java.awt.event.*;


public class admin {
    public static void main(String[] args) {
       
        
        GUI frame = new GUI("Adminstration", 1280, 720, null);
        PanelGui panel = new PanelGui(new FlowLayout(1,150,5), 1280, 72);
        PanelGui panel2 = new PanelGui(null, 1280, 700);
        panel.setBackground(Color.GRAY);
        panel2.setBackground(Color.DARK_GRAY);
        Widgets wd = new Widgets();
        wd.setLabel(panel.getPanel(), "Faculty", 0, 0, 100, 50);
        wd.setComboBox(panel.getPanel(), data.faculty, 0, 0, 100, 50);
        wd.comboListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               panel2.removeComp();
               panel2.repaint();
                int index = wd.getComboIndex(0);
                String [][] classes = data.table.getteacher2Darray(index);
                Section sc = new Section(classes);
                wd.setTable(panel2.getPanel(), sc.getData(),data.col, 0, 0, 1280, 545, Color.white, Color.black);
                wd.setButton(panel2.getPanel(), "Main Menu", 10, 550, 200, 30);
                wd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                        frame.run(false);
                        App.main(args);
                    }
                }); 
            }
        });


        wd.setLabel(panel.getPanel(), "Sections", 0, 0, 100, 50);
        wd.setComboBox(panel.getPanel(), data.section, 0, 0, 100, 50);
       wd.comboListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
           panel2.removeComp();
           panel2.repaint();
            int index = wd.getComboIndex(1);
            String [][] classes = data.table.get2Darray(index);
            Section sc = new Section(classes);
            wd.setTable(panel2.getPanel(), sc.getData(),data.col, 0, 0, 1280, 545, Color.white, Color.black);
            wd.setButton(panel2.getPanel(), "Main Menu", 10, 550, 200, 30);
                wd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                        frame.run(false);
                        App.main(args);
                    }
                });
        }
       });
        wd.setButton(panel.getPanel(), "Generate ", 600, 0, 100, 20);
        wd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                data.genrate();
            }
        });
        panel.setBounds(0, 0, 1280, 72);
        panel2.setBounds(0, 72, 1280, 700);
        frame.addPanel(panel2.getPanel());
        frame.addPanel(panel.getPanel());
        frame.run(true);
        

    }
    
    
}
