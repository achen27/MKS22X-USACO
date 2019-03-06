import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename){
    try {
      int[][] pasture;
      int row;
      int col;
      int elevation;
      int instructions;
      int[][] list;

      File f = new File(filename);
      Scanner s = new Scanner(f);
      row = s.nextInt();
      col = s.nextInt();
      elevation = s.nextInt();
      instructions = s.nextInt();
      System.out.println(row + " " + col + " " + elevation + " " + instructions);
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
