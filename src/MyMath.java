import java.math.BigDecimal;

/**
 * Created by zseapeng on 2016/5/14.
 */
public class MyMath {
    public static double add(double number1,double number2){
        //加法实现
        BigDecimal first = new BigDecimal(number1);
        BigDecimal second = new BigDecimal(number2);
        return first.add(second).doubleValue();

    }
    static double subtract(double number1,double number2){
        //减法实现
        BigDecimal first = new BigDecimal(number1);
        BigDecimal second = new BigDecimal(number2);
        return first.subtract(second).doubleValue();
    }
    static double mulitiply(double number1,double number2){
        //乘法实现
        BigDecimal first = new BigDecimal(number1);
        BigDecimal second = new BigDecimal(number2);
        return first.multiply(second).doubleValue();
    }
    static double divide(double number1,double number2){
        //除法实现
        BigDecimal first = new BigDecimal(number1);
        BigDecimal second = new BigDecimal(number2);
        return first.divide(second, 6, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }
    static double baifenhao(double number1,double number2){

        double n1 = mulitiply(number1,number2);
        return divide(n1,100);
    }
}
