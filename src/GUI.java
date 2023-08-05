import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class GUI {
    static JFrame frame;
    public GUI (String windowName,int width,int height,LayoutManager layout){
        frame = new JFrame(windowName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(layout);
        frame.setSize(width, height);
        frame.setResizable(false);
        
    }
    public void addPanel(JPanel panel){
        frame.add(panel);
    }
    public void run(boolean b){
        frame.setVisible(b);
    }
}
class PanelGui {
    JPanel panel;
    public PanelGui(LayoutManager layout, int width ,int height){
        panel = new JPanel(layout);
        panel.setPreferredSize(new Dimension(width, height));
        
        
    }
    public void setBounds(int x,int y,int width,int height){
        panel.setBounds(x, y, width, height);
        
    }
    public void addWidgets(Component widgets){
        panel.add(widgets);
    }
    
    public void setBackground(Color color) {
        panel.setBackground(color);
    }

    public JPanel getPanel() {
        return panel;
    }
    public void removeComp(){
        panel.removeAll();
    }
    public void repaint(){
        panel.repaint();
    }
}
class Widgets{
    private int sizeLabel = 0;int sizeField = 0;int sizePass=0;int sizeBtn =0;int sizeCombo =0;int checkIndex;
    private JLabel[] label = new JLabel[10];
    private JTextField[] field = new JTextField[10];
    private JPasswordField[] passwordField = new JPasswordField[10];
    private JButton[] button = new JButton[10];
    private JComboBox<String> comboBox[] = new JComboBox[10];
    private JRadioButton[] checkBox = new JRadioButton[10];
    private Font font = new Font("Roboto",Font.CENTER_BASELINE,14);
    private ButtonGroup buttonGroup = new ButtonGroup();
    
    

    public void setLabel(JPanel panel, String name, int x, int y, int width, int height) {
        label[sizeLabel] = new JLabel();
        label[sizeLabel].setText(name);
        label[sizeLabel].setBounds(x, y, width, height);
        label[sizeLabel].setFont(font);
        panel.add(label[sizeLabel]);
        sizeLabel++;
    }

    public void setSubLabel(JPanel panel, String name, int x, int y, int width, int height) {
        font = new Font("Roboto", Font.CENTER_BASELINE, 12);
        setLabel(panel, name, x, y, width, height);
    }

    public void setTextField(JPanel panel, int x, int y, int width, int height) {
        field[sizeField] = new JTextField();
        field[sizeField].setBounds(x, y, width, height);
        panel.add(field[sizeField]);
        sizeField++;
    }

    public void setPasswordField(JPanel panel, int x, int y, int width, int height) {
        passwordField[sizePass] = new JPasswordField();
        passwordField[sizePass].setBounds(x, y, width, height);
        panel.add(passwordField[sizePass]);
        sizePass++;
    }

    public void setButton(JPanel panel, String name, int x, int y, int width, int height) {
        button[sizeBtn] = new JButton(name);
        button[sizeBtn].setBackground(Color.WHITE);
        button[sizeBtn].setForeground(Color.BLACK);
        button[sizeBtn].setFont(font);
        button[sizeBtn].setBounds(x, y, width, height);
        panel.add(button[sizeBtn]);
        sizeBtn++;
    }

    public void setHeading(){
        font = new Font("Roboto",Font.BOLD,24);
    }
    public void setTextStyle(){
        font = new Font("Roboto",Font.CENTER_BASELINE,14);

    }
    public void addImage(JPanel panel ,String pathname,int x ,int y , int width, int height){
        
    
        try{
            BufferedImage image = ImageIO.read(new File(pathname));
            Icon icon = new ImageIcon(image.getScaledInstance(width,height,Image.SCALE_SMOOTH));
            JLabel pic = new JLabel();
            pic.setIcon(icon);
            pic.setBounds(x, y, width, height);
            panel.add(pic);
            
        }catch(Exception e){
            setLabel(panel,"image not found", x, y, width, height);
        }
    }

    public void labelIcon(JPanel panel ,String pathname,String text,int x ,int y , int width, int height){
        File file = new File(pathname);
    
        try{
            BufferedImage image = ImageIO.read(file);
            Icon icon = new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
            JLabel pic = new JLabel(icon);
            pic.setFont(new Font("Arial",1,14));
            pic.setText(text);
            pic.setHorizontalTextPosition(SwingConstants.LEADING);
            pic.setAlignmentX(SwingConstants.RIGHT);
            pic.setBounds(x, y, width, height);
            panel.add(pic);
            
        }catch(Exception e){
            setLabel(panel,"image not found", x, y, width, height);
        }
    }
    
    public void setTable(JPanel panel, Object[][] data, Object[] col, int x, int y, int width, int height,Color Bg,Color fg) {
        JTable table = new JTable(data,col);
        table.setModel(new MyTableModel(col, col.length, data, data.length, data[0].length));
        table.setFont(new Font("Arial",1,14));
        table.setCellSelectionEnabled(false);
        table.setRowHeight(80);

        table.setForeground(fg);
        table.setBackground(Bg);
        table.getTableHeader().setBackground(fg);
        table.getTableHeader().setForeground(Bg);
        table.getTableHeader().setFont(new Font("Arial",1,12));
        table.getTableHeader().setPreferredSize(new Dimension(0,60));
        
        
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(x,y,width,height);
        panel.add(scrollPane);
    }

    public void setComboBox(JPanel panel,String [] ar,int x,int y,int width,int height){
        comboBox[sizeCombo] = new JComboBox<>(ar);
        comboBox[sizeCombo].setBounds(x,y,width,height);
        panel.add(comboBox[sizeCombo]);
        sizeCombo++;
    }
    public void setRadioBox(JPanel panel , String name ,int x,int y,int width,int height){
        checkBox[checkIndex] = new JRadioButton(name);
        checkBox[checkIndex].setBounds(x, y, width, height);
        buttonGroup.add(checkBox[checkIndex]);
        panel.add(checkBox[checkIndex]);
        checkIndex++;
    }
    public void radioboxListener(ActionListener listener){
        checkBox[checkIndex-1].addActionListener(listener);
    }
    public int getComboIndex(int index){
        return comboBox[index].getSelectedIndex();
    }

    
    public void addActionListener(ActionListener listener) {
        button[sizeBtn-1].addActionListener(listener);
        
    }
    public void comboListener(ActionListener listener){
        comboBox[sizeCombo-1].addActionListener(listener);
    }

    public JTextField getTextField(int num) {
        return field[num-1];
    }

    public JPasswordField getPasswordField(int num) {
        return passwordField[num-1];
    }

    public static class MyTableModel extends AbstractTableModel {
         private Object[] columnNames;
        private Object[][] data ;


        public MyTableModel(Object[] column,int size,Object [][] data,int row,int col){
            this.columnNames = new String[size];
            this.columnNames = column;
            this.data = new Object[row][col];
            this.data = data;

        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
         @Override
        public String getColumnName(int columnIndex) {
            return (String)columnNames[columnIndex];
    }

        
    }

}
    
