import java.util.ArrayList;
import java.util.List;

/**
 * Created by zseapeng on 2016/5/14.
 */
public class CalService {
    private List<String> tempNum = new ArrayList<String>();
    private List<String> number = new ArrayList<String>();
    private List<String> operator = new ArrayList<String>();
    private String oldNum = null;
    private boolean negate = true;
    private String numberStr = "0123456789.";
    private String operatorStr = "+-*/";
    public void getNum(){
        String temp = "";
        for (int i=0;i<tempNum.size();i++){
            temp +=tempNum.get(i);
        }
        number.add(temp);
        tempNum.clear();
    }
    public String calMethod(String cmd,String text){
         if (operatorStr.indexOf(cmd)!=-1){
                operator.add(cmd);
                getNum();
          } else if (cmd.equalsIgnoreCase("back")){
             String string = text.substring(text.length()-1,text.length());
             //System.out.println(string+"_________"+text+"________________");
             if (operatorStr.indexOf(string)!=-1&&operator.size()>0) operator.remove(operator.size()-1);
            else if (tempNum.size()>0)tempNum.remove(tempNum.size()-1);
             else {
                 int len = number.get(number.size() - 1).length();
                 //System.out.println("len="+len);
                 if (len==0) number.remove(number.size()-1);
                 else number.set(number.size() - 1, number.get(number.size() - 1).substring(0, len-1));
             }
                 return backText(text);
        }
         //else if (cmd.equalsIgnoreCase("%")){
        //     getNum();
        //     return MyMath.baifenhao()
        // }
         else if (cmd.equalsIgnoreCase("1/x")){
             return "  1/"+text+"= "+reciprocal(text);
         }else if (cmd.equalsIgnoreCase("sqrt")){
             getNum();
             return " Sqrt = "+calSqrt();
         }else if (cmd.equalsIgnoreCase("+/-")){
             if (negate){
                 tempNum.add(0,"-");
             }
             return null;
         }else{
        tempNum.add(cmd);}
        //System.out.println("tempNumSize   "+tempNum.size());
        //System.out.println("opSI   "+operator.size());
        //for (String s :number){
        //    System.out.println("numberList=   "+s);
        //}
        //for (String s :operator){
        //    System.out.println("operatorList=   "+s);
        //}
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
                System.out.println("error 除数不能为0");
            }else
                temp = MyMath.divide(temp,getDouble(number.get(i+1)));}
        }
        number.clear();
        operator.clear();
        negate = true;
        return String.valueOf(temp);
    }
    public String clearAll(){
        tempNum.clear();
        number.clear();
        operator.clear();
        return "0";
    }
    public String backText(String text){
        return text.equals("0") || text.equals("") ? "0" : text.substring(0,text.length() - 1);
    }
    public String calSqrt(){
        return String.valueOf(Math.sqrt(getDouble(number.get(0))));

    }

    public String getOldNum() {
        return oldNum;
    }

    public void setOldNum(String oldNum) {
        this.oldNum = oldNum;
    }

    public String reciprocal(String test){
        return String.valueOf(MyMath.divide(1,Double.valueOf(test)));
    }
    public String syns(String text){
        if (negate){
            text = "-"+text;
        }else text = text.substring(1,text.length());
       // String some = null;
        //for (int i=0;i<tempNum.size();i++){
        //    some +=tempNum.get(i).toString();
        //}
        return text;
    }
}
