import java.util.ArrayList;
import java.util.List;

/**
 * Created by zseapeng on 2016/5/14.
 */
public class CalService {
    private List<String> number = new ArrayList<String>();
    private List<String> operator = new ArrayList<String>();

    public String calMethod(String cmd){
        if (!cmd.equals("+")&&!cmd.equals("=")){
            number.add(cmd);
        }
        if (cmd.equals("+")){
            operator.add(cmd);
        }
        for (String s :number){
            System.out.println("numberList=   "+s);
        }
        for (String s :operator){
            System.out.println("operatorList=   "+s);
        }
        return show(cmd);
    }
    public String show(String cmd){
        return cmd;
    }
    public String calEnd(){
        double result = MyMath.add(Double.valueOf(number.get(0)),Double.valueOf(number.get(1)));
        return String.valueOf(result);
    }

}
