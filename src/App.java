import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        GUI frame = new GUI("Time Table Managment System", 1280, 720, null);
        PanelGui panel = new PanelGui(new FlowLayout(), 1280, 144);
        PanelGui panel2 = new PanelGui(new FlowLayout(), 1280, 72);
        PanelGui panel3 = new PanelGui(null, 1280,504);
        panel.setBackground(Color.GRAY);
        panel2.setBackground(new Color(120, 120, 220));
        panel3.setBackground(new Color(100, 100, 200, 255));

        Widgets wd = new Widgets();
        wd.addImage(panel.getPanel(), "images/bg-login-top.png", 0, 0, 1280, 216);
        wd.setTextStyle();
        wd.setRadioBox(panel2.getPanel(), "Administration ", 0, 0, 100, 72);
        wd.radioboxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                panel3.removeComp();
                panel3.repaint();
                wd.setLabel(panel3.getPanel(), "Enter your passcode", 540, 100, 200, 20);
                wd.setPasswordField(panel3.getPanel(), 540, 150, 200, 20);
                wd.setButton(panel3.getPanel(), "Confirm", 640, 190, 100, 20);
                wd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        String a = new String(wd.getPasswordField(1).getPassword());
                        if(a.equals("admin")){
                            frame.run(false);
                            admin.main(args);
                            

                        }else{
                            JOptionPane.showMessageDialog(panel3.getPanel(), "kindly check the password again", "Password Incorrect", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                });
                
            }
        });
        wd.setRadioBox(panel2.getPanel(), "Teachers", 0, 0, 100, 72);
        wd.radioboxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.run(false);
                Teacher.main(args);

            }
        });
        wd.setRadioBox(panel2.getPanel(), "Student", 0, 0, 100, 72);
        wd.radioboxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.run(false);
                Student.main(args);
                
            }
        });
        panel.setBounds(0, 0, 1280, 216);
        panel2.setBounds(0, 216, 1280, 72);
        panel3.setBounds(0,288, 1280, 504);
        frame.addPanel(panel.getPanel());
        frame.addPanel(panel2.getPanel());
        frame.addPanel(panel3.getPanel());
        frame.run(true);

    }
    
    
}
