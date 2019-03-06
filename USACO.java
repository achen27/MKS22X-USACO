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
      for (int i = 0; i < list.length; i++){
        stomp(list[i][1], list[i][2], list[i][3], pasture); //helper method to modify array
      }

    } catch (FileNotFoundException e){
      System.out.println("File not found");
    }
    return 0;
  }

  private static void stomp(int Rs, int Cs, int Ds, int[][] pasture){
    //Pt.1 Find highest point
    int high = 0;
    for (int i = Rs; i < Rs + 3; i++){
      for (int j = Cs; j < Cs + 3; j++){
        if (pasture[i][j] > high){
          high = pasture[i][j];
        }
      }
    }
  }

  public static void main(String[] args){
    bronze("makelake.1.in");

  }
  //public static int silver(String filename)

}
