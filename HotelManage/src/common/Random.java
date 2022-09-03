package common;

import java.util.Arrays;



public class Random {
    public static void main(String[] args) {
        /*MyMethod mm=new MyMethod();
        System.out.println("随机的验证码为："+mm.MyMethod1());*/
        /*String method1[]=new String[10];
        for(int i=0;i<10;i++){
            method1[i]=mm.MyMethod1();
        }*/
        //System.out.println("随机验证码为："+Arrays.toString(method1));
        System.out.println(random());
        String s=random();
    }
    public static String random(){
        String str="";
        for(int i=0;i<4;i++){
            int n=(int) (Math.random()*3);
            char c=' ';
            if(n==0){
                c=(char)(Math.random()*10+48);//随机出0-9个数字
            }else if(n==1){
                c=(char)(Math.random()*26+97);//随机出小写字母
            }else{
                c=(char)(Math.random()*26+65);//随机出大写字母
            }
            str=c+str; }
        return str;
    }
}




