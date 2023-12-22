package level2;
import java.io.*;
import java.util.Scanner;
class myfile{
    public String name;
    public String input;
    public boolean flag=true,result;
    public static String key,okey;
    public  StringBuffer text;
    public char ar[],ch;
    public myfile(String name){
        this.name=name+".txt";
    }
    // create file
    void create(){
        try{
            File f=new File(name);
            f.createNewFile();
            System.out.println("File Creation Successfully.");
        }catch(IOException e){
            System.out.println("Error are found during File creation.");
            e.printStackTrace();
        }
    }
    // write contents
    void writefile()
    {
        Scanner sc=new Scanner(System.in);
        try {
            FileWriter wf=new FileWriter(name);
            System.out.println("Enter the content for "+name+" File ( Here 'Enter' is treated as end of content ):");
            input = sc.nextLine();
            wf.write(input);
            wf.close();
        } catch (IOException e) {
            System.out.println("Error are found during Write a file.");
            e.printStackTrace();
        }
    }
    // read file
    void readfile()
    {
        File rf=new File(name);
        try{
            Scanner sc=new Scanner(rf);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println(name);
            System.out.println("Error are found during reading file.");
            e.printStackTrace();
        }
    }
    // get permission for doing operations
    void permission(){
            Scanner sc=new Scanner(System.in); 
            //System.out.println("Name = "+name);
            String choice;
            char ch;
            while(flag)
            {
                System.out.println("Do you want to encripte "+name+" this file ? ( Yes->y and No->n )");
                choice=sc.nextLine();
                ch=choice.charAt(0);
                if(ch=='y'){
                    System.out.println("Enter a password for encripte the "+name+" file.");
                    key=sc.nextLine();
                    System.out.println("Before Encripted file content:-");
                    readfile();
                    encripte();
                    System.out.println("After Encription file content:-");
                    readfile();
                    System.out.println();
                    System.out.println("Do you want to decripte "+name+" this file ? ( Yes->y and No->n )");
                    choice=sc.nextLine();
                    char ch1=choice.charAt(0);
                    if(ch1=='y'){
                        decripte();
                        readfile();
                        flag=false;
                    }
                    else{
                        flag=false;
                    }
                }
                else{
                    System.out.println("File's Content :- ");
                    readfile();
                    flag=false;
                }
            }
    }
    /// Encripte the file
    void encripte()
    {
        File rf=new File(name);
        text = new StringBuffer();
        try {
            Scanner sc=new Scanner(rf);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                ar=new char[line.length()];
                for(int i=0;i<ar.length;i++){
                    ar[i]=line.charAt(i);
                }
            }
            sc.close();
            for(int i=0;i<ar.length;i++){
                ar[i]=(char)((int)ar[i]-1);
                text.append(ar[i]);
            }// reading modified.
            FileWriter wf=new FileWriter(name);
           wf.write(text.toString());
           wf.close();
           text.delete(0, text.length());
        } catch (Exception e) {
            System.out.println("Error are found during Encription file.");
            e.printStackTrace();
        }
    }
    // decripte file
    void decripte(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your key :");
        okey=sc.nextLine();
        result=key.equals(okey);
        if(result){
            File rf=new File(name);
        try {
            Scanner sc1=new Scanner(rf);
            for(int i=0;i<ar.length;i++){
                ar[i]=(char)((int)ar[i]+1);
                text.append(ar[i]);
            }
            FileWriter wf=new FileWriter(name);
           wf.write(text.toString());
           wf.close();
        }catch (Exception e) {
            System.out.println("Error are found during Decription file.");
            e.printStackTrace();
        }
    }
        else{
            System.out.println("Real Key= "+key+" Your key= "+okey);
            System.out.println("You enter a wrong password.");
        }
    }
}
// This is the main program
public class file_encription_decription {
    public static void main(String [] args){
        Scanner sc =new Scanner(System.in);
        System.out.println("For Creating the file, enter file name:");
        String name=sc.nextLine();
        myfile m=new myfile(name);
        m.create();
        m.writefile();
        m.permission();
    }
}
