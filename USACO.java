import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename){
    try {
      int[][] list;

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

      System.out.println(Arrays.deepToString(pasture));

    } catch (FileNotFoundException e){
      System.out.println("File not found");
    }
    return 0;
  }

  public static void main(String[] args){
    bronze("makelake.1.in");

  }
  //public static int silver(String filename)

}
