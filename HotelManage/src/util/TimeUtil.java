package util;

import org.apache.poi.ss.formula.functions.Now;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:qwertyuiop
 * @Date:2022/8/21 16:31
 * @Description:
 * @Version 1.0
 */
public class TimeUtil {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(System.currentTimeMillis());
        System.out.println("---------------");
        System.out.println(date.getTime());
        System.out.println("---------------");

        System.out.println("---------------");


    }


    /**
     *@Author: qwertyuiop
     *@Date: 2022/8/21 16:24
     *Description: 时间格式转换成 日常时间。
     */

    public static String dateToSting(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//时间格式
        return simpleDateFormat.format(date);
    }

    /**
    *@Author: qwertyuiop
    *@Date: 2022/8/21 17:15
    *Description: 将string 的时间转换为date
    */
    public static Date stringToDate(String date){
        Date date1 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date1 = simpleDateFormat.parse(date);

            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    /**
    *@Author: qwertyuiop
    *@Date: 2022/8/21 17:31
    *Description: 将date时间转换为long
    */
    public static long dateToLong(Date date){
        return date.getTime();
    }

    /**
    *@Author: qwertyuiop
    *@Date: 2022/8/21 18:03
    *Description: 将long 时间转换为date 时间
    */
    public static Date longToDate(long l){
        Date date = new Date();
        date.setTime(l);
        return date;
    }

    /**
    *@Author: qwertyuiop
    *@Date: 2022/8/21 18:15
    *Description:将String转换为long
    */
    public static long stringToLong(String date){
        return dateToLong(stringToDate(date));
    }

    /**
    *@Author: qwertyuiop
    *@Date: 2022/8/21 18:19
    *Description: 将long转换为string
    */
    public static String longToString(long l){
        return dateToSting(longToDate(l));
    }



}
