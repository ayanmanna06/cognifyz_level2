package level2;
import java.util.*;
/// Game class is for make game and check game logic accroding to input
class game {
    char ar[][] = new char[3][3];
    int p1_num1, p1_num2;//co-ordinate's of player's 1. X->p1_num1 and O->p1_num2
    int p2_num1, p2_num2;//co-ordinate's of player's 2. X->p2_num1 and O->p2_num2
    boolean flag = true,fg=true;
    static int cp;// this cp is for to check how many items are store in this 2-d array
    Scanner sc = new Scanner(System.in);
    /// I take player-1 means 'X' input 
    void player1_input() {
        try{
        System.out.println("In which position (Co-ordinate's value (x,y)) You want to Enter your input 'X' ?");
        String num1 = sc.next();
        String num2 = sc.next();
        p1_num1=Integer.parseInt(num1);
        p1_num2=Integer.parseInt(num2);
        if(p1_num1>2 || p1_num2>2)
                throw new InputMismatchException("Out Of Bound player 'X' input");
        }
        // This Exception for player-1
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            p1_num1 =-1;
            p1_num2 =-1;
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
            p1_num1 =-1;
            p1_num2 =-1;
        }
    }// End of player-1 method
    // I take player-2 means 'O' input
    void player2_input() {
        try{
        System.out.println("In which position (Co-ordinate's value (x,y)) You want to Enter your input 'O' ?");
        p2_num1 = sc.nextInt();
        p2_num2 = sc.nextInt();
        if(p2_num1>2 || p2_num2>2)
            throw new InputMismatchException("Out Of Bound player 'O' input");
        }
        // This Exception for player-2
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            p2_num1 =-1;
            p2_num2=-1;
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
            p2_num1 =-1;
            p2_num2=-1;
        }
    }//End of player-2 method
    // This make_box method is created for make the squre box for tic-tak-toe game
    void make_box() {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < 3; j++) {
                ar[i][j]=' ';
            }
        }
    }//End of make_box
    // this update_box method is created for update the squre box upto date
    void update_box() {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ar[i][j] + " | ");
            }
            System.out.println();
        }
    }//End of update_box method
    // This method is for check of squre box are fill or not. Mainly this is for check the Game over condition
    void isfull(){
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < 3; j++) {
                if(ar[i][j] == ' '){
                }
            }
        }
        if(cp==9){
            System.out.println("Game Over. "+cp);
            flag = false;
        }
    }//End of isfull method
    // this Check method is created for check the winner
    boolean check() {
        if (ar[0][0] == 'X' && ar[0][1] == 'X' && ar[0][2] == 'X'
                || ar[0][0] == 'O' && ar[0][1] == 'O' && ar[0][2] == 'O') {
            if (ar[0][0] == 'X')
                System.out.println("Player X is Winner !");
            else
                System.out.println("Player O is Winner !");
            flag = false;
            return flag;
        } else if (ar[0][0] == 'X' && ar[1][0] == 'X' && ar[2][0] == 'X'
                || ar[0][0] == 'O' && ar[1][0] == 'O' && ar[2][0] == 'O') {
            if (ar[0][0] == 'X')
                System.out.println("Player X is Winner !");
            else
                System.out.println("Player O is Winner !");
            flag = false;
            return flag;
        } else if (ar[2][0] == 'X' && ar[2][1] == 'X' && ar[2][2] == 'X'
                || ar[2][0] == 'O' && ar[2][1] == 'O' && ar[2][2] == 'O') {
            if (ar[2][2] == 'X')
                System.out.println("Player X is Winner !");
            else
                System.out.println("Player O is Winner !");
            flag = false;
            return flag;
        } else if (ar[0][2] == 'X' && ar[1][2] == 'X' && ar[2][2] == 'X'
                || ar[0][2] == 'O' && ar[1][2] == 'O' && ar[2][2] == 'O') {
            if (ar[2][2] == 'X')
                System.out.println("Player X is Winner !");
            else
                System.out.println("Player O is Winner !");
            flag = false;
            return flag;
        }
        // middel start
        else if (ar[0][1] == 'X' && ar[1][1] == 'X' && ar[2][1] == 'X'
                || ar[0][1] == 'O' && ar[1][1] == 'O' && ar[2][1] == 'O') {
            if (ar[1][1] == 'X')
                System.out.println("Player X is Winner !");
            else
                System.out.println("Player O is Winner !");
            flag = false;
            return flag;
        }
        else if (ar[1][0] == 'X' && ar[1][1] == 'X' && ar[1][2] == 'X'
                || ar[1][0] == 'O' && ar[1][1] == 'O' && ar[1][2] == 'O') {
            if (ar[1][1] == 'X')
                System.out.println("Player X is Winner !");
            else
                System.out.println("Player O is Winner !");
            flag = false;
            return flag;
        }
        // Diagonal start
        else if (ar[0][0] == 'X' && ar[1][1] == 'X' && ar[2][2] == 'X'
                || ar[0][0] == 'O' && ar[1][1] == 'O' && ar[2][2] == 'O') {
            if (ar[1][1] == 'X')
                System.out.println("Player X is Winner !");
            else
                System.out.println("Player O is Winner !");
            flag = false;
            return flag;
        } else if (ar[0][2] == 'X' && ar[1][1] == 'X' && ar[2][0] == 'X'
                || ar[0][2] == 'O' && ar[1][1] == 'O' && ar[2][0] == 'O') {
            if (ar[1][1] == 'X')
                System.out.println("Player X is Winner !");
            else
                System.out.println("Player O is Winner !");
            flag = false;
            return flag;
        }
        else {
            flag = true;
            isfull();// this function is called to check the game over condition
            return flag;
        }
    }// End of check method
    // this is the main logic of the game where all possibel condition's are checked
    void game_logic() {
        make_box();
        // This is the Outter loops for take input from Player-1('X') and check all condition's
        while (flag) {
            fg=true;
            try{
                player1_input();
                if (ar[p1_num1][p1_num2] != 'X'){
                    if(ar[p1_num1][p1_num2] != 'O'){
                        ar[p1_num1][p1_num2] = 'X';
                        cp++;
                    }
                    else
                        throw new ExceptionInInitializerError(" Already Player 'O' is here!\n So choose another! ");
                }
                else
                    throw new ExceptionInInitializerError(" Already Player 'X' is here!\n So choose another! ");
                update_box();
                if (!check())
                    break;
                    // This is the Inner loops for take input from player-2('O') and check all condition's
                while(fg){
                    try{
                        player2_input();
                        if (ar[p2_num1][p2_num2] != 'O') {
                            if(ar[p2_num1][p2_num2] != 'X'){
                                ar[p2_num1][p2_num2] = 'O';
                                cp++;
                                fg=false;
                            }
                            else
                                throw new Exception("Already Player 'X' is here!\n So choose another!");
                        }
                        else
                            throw new Exception("Already Player 'O' is here!\n So choose another!");
                        update_box();
                        if (!check())
                            break;
                    }
                    // This Exception for Inner loop's Try method
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Sorry your input is invalid . try again!");
                        continue;
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                } // End of the Inner loop
            }
            // This Exception's for Outter loop's Try method
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Sorry your input is invalid . try again!");
                continue;
            }
            catch(ExceptionInInitializerError e){
                System.out.println(e.getMessage());
                continue;
            }
        }// End of the Outter loop
    }// End of game_logic method
}
public class tic_tak_toe {
    public static void main(String[] args) {
        game g = new game();// Object creation of game class to access all the features.
        g.update_box();// see the upto date squre.
        g.game_logic();// parform the actual game
    }
}

