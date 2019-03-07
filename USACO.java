import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename){
    try {

      File f = new File(filename);
      Scanner s = new Scanner(f);

      //reads first line of file and places valeus into variables
      int row = s.nextInt();
      int col = s.nextInt();
      int elevation = s.nextInt();
      int instructions = s.nextInt();

      //reading pasture elevations onto a 2D array
      int[][] pasture = new int[row][col];
      for (int i = 0; i < row; i++){
        for (int j = 0; j < col; j++){
          pasture[i][j] = s.nextInt();
        }
      }

      //reading list of instructions into 2D Array
      int[][] list = new int[instructions][3];
      for (int i = 0; i < instructions; i++){
        for (int j = 0; j < 3; j++){
          list[i][j] = s.nextInt();
        }
      }

      //reading through instructions and changing pasture accordingly
      for (int i = 0; i < list.length; i++){
        stomp(list[i][0] - 1, list[i][1] - 1, list[i][2], pasture); //helper method to modify array
      }

      //Changing pasture depths
      for (int i = 0; i < row; i++){
        for (int j = 0; j < col; j++){
          pasture[i][j] = elevation - pasture[i][j];
          if (pasture[i][j] < 0){
            pasture[i][j] = 0;
          }
        }
      }

      //Finding total aggrevated depth
      int depth = 0;
      for (int i = 0; i < row; i++){
        for (int j = 0; j < col; j++){
          depth += pasture[i][j];
        }
      }

      return depth * 72 * 72;

    } catch (FileNotFoundException e){
      System.out.println("File not found");
      return 0;
    }
  }

  private static void stomp(int Rs, int Cs, int Ds, int[][] pasture){
    //Find highest elevation
    int high = 0;
    for (int i = Rs; i < Rs + 3; i++){
      for (int j = Cs; j < Cs + 3; j++){
        if (pasture[i][j] > high){
          high = pasture[i][j];
        }
      }
    }
    high -= Ds;

    //Change all elevations higher or equal to high - Ds
    for (int i = Rs; i < Rs + 3; i++){
      for (int j = Cs; j < Cs + 3; j++){
        if (pasture[i][j] > high){
          pasture[i][j] = high;
        }
      }
    }
  }

  public static String toString(int[][] array){
    String s = "";
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[0].length; j++){
        s += array[i][j] + " ";
      }
      s += "\n";
    }
    return s;
  }

  public static int silver(String filename){
    try {

      File f = new File(filename);
      Scanner s = new Scanner(f);

      //put row length, col length, and seconds into variables
      int row = s.nextInt();
      int col = s.nextInt();
      int seconds = s.nextInt();

      String p = "";
      for (int i = 0; i < row; i++){
        p += s.next();
      }
      //System.out.println(p);
      //System.out.println(row);
      //System.out.println(col);
      char[][] pasture = new char[row][col];
      int idx = 0;
      for (int i = 0; i < row; i++){
        for (int j = 0; j < col; j++){
          pasture[i][j] = p.charAt(idx);
          idx++;
        }
      }
      //System.out.println(toString(pasture));

      int startR = s.nextInt();
      int startC = s.nextInt();
      //System.out.println(startR + ", " + startC);
      int endR = s.nextInt();
      int endC = s.nextInt();
      //System.out.println(endR + ", " + endC);

      int[][] moves = new int[row][col];

      updateMoves(pasture, moves, startR, startC, seconds);
      System.out.println(toString(moves));
      return moves[endR-1][endC-1];

    } catch (FileNotFoundException e){
      System.out.println("File not found");
      return 0;
    }
  }

  private static void updateMoves(char[][] c, int[][] m, int row, int col, int s){
    int idx = 1;
    m[row][col] = 1;
    while (idx < s){
      for (int i = 0; i < m.length; i++){
        for(int j = 0; j <m[0].length; j++){
          if (m[i][j] != 0){
            m[i][j] -= 1;
            try{
              if (c[i+1][j] != '*'){
                m[i+1][j] += 1;
              }
              if (c[i-1][j] != '*'){
                m[i-1][j] += 1;
              }
              if (c[i][j+1] != '*'){
                m[i][j+1] += 1;
              }
              if (c[i][j-1] != '*'){
                m[i][j-1] += 1;
              }
            }catch(ArrayIndexOutOfBoundsException e){

            }
          }
        }
      }

      s--;
    }
  }

  public static String toString(char[][] array){
    String s = "";
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[0].length; j++){
        s += array[i][j] + " ";
      }
      s += "\n";
    }
    return s;
  }

  public static void main(String[] args){
    /*System.out.println(bronze("makelake.1.in"));
    System.out.println(bronze("makelake.2.in"));
    System.out.println(bronze("makelake.3.in"));
    System.out.println(bronze("makelake.4.in"));
    System.out.println(bronze("makelake.5.in"));*/

    //System.out.println(silver("ctravel.1.in"));
    System.out.println(silver("ctravel.2.in"));
    //System.out.println(silver("ctravel.3.in"));
    //System.out.println(silver("ctravel.4.in"));
    //System.out.println(silver("ctravel.5.in"));
  }

}
