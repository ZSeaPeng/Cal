import java.util.ArrayList;
import java.util.List;

/**
 * Created by zseapeng on 2016/5/14.
 */
public class CalService {
    private List<String> tempNum = new ArrayList<String>();
    private List<String> number = new ArrayList<String>();
    private List<String> operator = new ArrayList<String>();

    public void getNum(){
        String temp = "";
        for (int i=0;i<tempNum.size();i++){
            temp +=tempNum.get(i);
        }
        number.add(temp);
        tempNum.clear();
    }
    public String calMethod(String cmd){
        //if (!cmd.equals("+")&&!cmd.equals("=")&&!cmd.equals("-")&&!cmd.equals("*")&&!cmd.equals("/")){
        //    tempNum.add(cmd);
        //}
        if (cmd.equals("+")){
            operator.add(cmd);
            getNum();
        }
        else if (cmd.equals("-")){
            operator.add(cmd);
            getNum();
        }
        else if (cmd.equals("*")){
            operator.add(cmd);
            getNum();
        }
        else if (cmd.equals("/")){
            operator.add(cmd);
            getNum();
        }else{
        tempNum.add(cmd);}
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
    public double getDouble(String num){
        return Double.valueOf(num);
    }
    public String calEnd(){
        getNum();
        double temp = getDouble(number.get(0));
        for (int i=0;i<operator.size();i++){
            if (operator.get(i).equals("+")) {
                temp = MyMath.add(temp,getDouble(number.get(i+1)));
            }else if (operator.get(i).equals("-")){
                temp = MyMath.subtract(temp,getDouble(number.get(i+1)));
            }else if (operator.get(i).equals("*")){
                temp = MyMath.mulitiply(temp,getDouble(number.get(i+1)));
            }else {if (getDouble(number.get(i+1))==0){
                System.out.println("err 除数不能为0");
            }else
                temp = MyMath.divide(temp,getDouble(number.get(i+1)));}
        }
        number.clear();
        operator.clear();
        return String.valueOf(temp);
    }
    public String clearAll(){
        tempNum.clear();
        number.clear();
        operator.clear();
        return "";
    }
}
