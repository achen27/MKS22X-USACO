import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename){
    try {

      File f = new File(filename);
      Scanner s = new Scanner(f);

      //reads first line of file and places valeus into variables
      int row;
      int col;
      int elevation;
      int instructions;

      row = s.nextInt();
      col = s.nextInt();
      elevation = s.nextInt();
      instructions = s.nextInt();
      //System.out.println(row + " " + col + " " + elevation + " " + instructions);

      //reading pasture elevations onto a 2D array
      int[][] pasture = new int[row][col];
      for (int i = 0; i < row; i++){
        for (int j = 0; j < col; j++){
          pasture[i][j] = s.nextInt();
        }
      }
      //System.out.println(Arrays.deepToString(pasture));

      //reading list of instructions into 2D Array
      int[][] list = new int[instructions][3];
      for (int i = 0; i < instructions; i++){
        for (int j = 0; j < 3; j++){
          list[i][j] = s.nextInt();
        }
      }
      //System.out.println(Arrays.deepToString(list));

      //reading through instructions and changing pasture accordingly
      System.out.println(toString(pasture));
      for (int i = 0; i < list.length; i++){
        stomp(list[i][0] - 1, list[i][1] - 1, list[i][2], pasture); //helper method to modify array
        System.out.println(toString(pasture));
      }

    } catch (FileNotFoundException e){
      System.out.println("File not found");
    }
    return 0;
  }

  private static void stomp(int Rs, int Cs, int Ds, int[][] pasture){
    //Find highest elevation
    int high = 0;
    for (int i = Rs; i < Rs + 3; i++){
      for (int j = Cs; j < Cs + 3; j++){
        //System.out.println(i);
        //System.out.println(j);
        if (pasture[i][j] > high){
          high = pasture[i][j];
        }
      }
    }
    //System.out.println(high);
    high -= Ds;
    //System.out.println(high);

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


  public static void main(String[] args){
    bronze("makelake.1.in");

  }
  //public static int silver(String filename)

}
