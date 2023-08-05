import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teacher {
    public static void main(String[] args) {
        GUI frame =new GUI("Teacher", 1280, 720, null);
        PanelGui panel = new PanelGui(new FlowLayout(), 1280, 72);
        PanelGui panel2 = new PanelGui(null, 1280, 700);
        Widgets wd = new Widgets();
        panel.setBackground(Color.gray);
        panel2.setBackground(Color.DARK_GRAY);

        wd.setLabel(panel.getPanel(), "Select the Section", 0, 0, 200, 50);
        wd.setComboBox(panel.getPanel(), data.faculty, 0, 0, 200, 50);
        
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
        
        
        

        panel.setBounds(0, 0, 1280, 72);
        panel2.setBounds(0, 72, 1280, 700);
        frame.addPanel(panel.getPanel());
        frame.addPanel(panel2.getPanel());
        frame.run(true);

    }
}
