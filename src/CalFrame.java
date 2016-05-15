import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by zseapeng on 2016/5/14.
 */
public class CalFrame extends JFrame {
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
        this.setResizable(false);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout(10,1));
        jPanel.add(getjTextField(), BorderLayout.NORTH);
        JPanel jPanel1 = new JPanel(new GridLayout(5,1,0,5));
        for (JButton b:getjButtons_left()){
            jPanel1.add(b);
        }
        this.add(jPanel1);
        this.add(jPanel);
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

    public JButton getjButton() {
        if (jButton == null){
            jButton = new JButton();
        }
        return jButton;
    }
    public JButton[] getjButtons_left(){
        JButton[] result = new JButton[str_left.length];
        for (int i=0;i<this.str_left.length;i++){
            JButton button = new JButton(this.str_left[i]);
            button.setForeground(Color.red);
            result[i] = button;
        }
        return result;
    }
    //public ActionListener getActionListener(){
    //    if (actionListener == null){
    //        new ActionListener() {
    //            @Override
    //            public void actionPerformed(ActionEvent e) {
    //                String cmd = e.getActionCommand();
    //                String result = null;
    //
    //            }
    //        }
    //    }
    //    return actionListener;
    //}
}
