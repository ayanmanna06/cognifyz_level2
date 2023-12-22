package level2;
import java.util.*;
class password{
    String st;
    String low= "abcdefghijklmnopqrstuvwxyz";
    String up="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String number="0123456789";
    String spe="~!@#$%^&*?";
    static int count=0,count1=0,count2=0,count3=0;
    password(String st){
        this.st=st;
    }
    void checkpassword(){
        for(int i=0;i<st.length();i++){
            for(int j=0;j<up.length();j++){
                if(st.charAt(i)==low.charAt(j) ){
                    count++;
                }
               if(st.charAt(i)==up.charAt(j)){
                    count1++;
               }
            }
            for(int j=0;j<number.length();j++){
                if(st.charAt(i)==number.charAt(j) ){
                    count2++;
                }
                if(st.charAt(i)==spe.charAt(j)){
                    count3++;
                }
            }   
        }
        if(count>0 && count1>0 && count2>0 && count3>0){
            System.out.println("Your password is Strong.");
        }  
        else{
            System.out.println("Your password is week.");
        }
    }
}
public class password_strength {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your password to check the strength: ");
        String st=sc.nextLine();
        password p=new password(st);
        p.checkpassword();
    }
}
