import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zseapeng on 2016/5/14.
 */
public class CalFrame extends JFrame {
    private CalService calService = new CalService();
    private JTextField jTextField = null;
    private String[] str_left = {"","Mc","MR","MS","M+"};
    private String[] str_right_top = {"Back","CE","C"};
    private String[] str_right = {"7","8","9","/","sqrt","4","5","6","*",
                                    "%","1","2","3","-","1/x","0","+/-",".","+","="};
    private JButton jButton = null;
    private ActionListener actionListener = null;

    private final int CAL_WIDTH = 360;
    private final int CAL_HIGHT = 250;

    public void initialize(){
        this.setTitle("计算器");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(CAL_WIDTH,CAL_HIGHT);
        this.setLocation(200,300);
        //this.setResizable(false);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout(10,1));
        jPanel.add(getjTextField(), BorderLayout.NORTH);
        JPanel jPanel1 = new JPanel(new GridLayout(5,1,0,5));
        for (JButton b:getjButtons_left()){
            jPanel1.add(b);
        }
        JPanel jPanel2 = new JPanel(new GridLayout(4,5,0,5));
        for (JButton b :getJbutton_right()){
            jPanel2.add(b);
        }
        JPanel jPanel3 = new JPanel(new GridLayout(1,3,0,5));
        for (JButton b:getJbutton_right_top()){
            jPanel3.add(b);
        }
        JPanel j = new JPanel(new BorderLayout());
        this.add(jPanel);
        jPanel.add(jPanel1,BorderLayout.WEST);
        j.add(jPanel3,BorderLayout.NORTH);
        j.add(jPanel2,BorderLayout.CENTER);
        jPanel.add(j);
        this.setVisible(true);
    }

    public JTextField getjTextField() {
        if (jTextField == null){
            jTextField = new JTextField("0");
            jTextField.setEditable(false);
            jTextField.setBackground(Color.white);
        }
        return jTextField;
    }

    //public JButton getjButton() {
    //    if (jButton == null){
    //        jButton = new JButton();
    //    }
    //    return jButton;
    //}
    public JButton[] getjButtons_left(){
        JButton[] result = new JButton[str_left.length];
        for (int i=0;i<this.str_left.length;i++){
            JButton button = new JButton(this.str_left[i]);
            button.setForeground(Color.red);
            button.addActionListener(getActionListener());
            result[i] = button;
        }
        return result;
    }
    public JButton[] getJbutton_right(){
        JButton[] result = new JButton[str_right.length];
        for (int i=0;i<this.str_right.length;i++){
            JButton button = new JButton(this.str_right[i]);
            if (i==3||i==8||i==18||i==19||i==13){
                button.setForeground(Color.red);
            }
            button.addActionListener(getActionListener());
            result[i] = button;
        }
        return result;
    }
    public JButton[] getJbutton_right_top(){
        JButton[] result = new JButton[str_right_top.length];
        for (int i=0;i<str_right_top.length;i++){
            JButton button = new JButton(str_right_top[i]);
            button.setForeground(Color.red);
            button.addActionListener(getActionListener());
            result[i] = button;
        }
        return result;
    }
   public ActionListener getActionListener(){
       if (actionListener == null){

           actionListener = new ActionListener() {
               String result = null;
               @Override
               public void actionPerformed(ActionEvent e) {
                   String cmd = e.getActionCommand();

                   if (cmd.equals("=")) {
                       result = calService.calEnd();
                       jTextField.setText(result);
                       result = null;
                       return;
                   }
                   else if (result!=null){
                       result += calService.calMethod(cmd);
                   }else if (result == null){
                       result = calService.calMethod(cmd);
                   }
                   jTextField.setText(result);

               }
           };
       }
       return actionListener;
   }
}
