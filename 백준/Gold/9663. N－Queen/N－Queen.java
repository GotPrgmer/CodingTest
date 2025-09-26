import java.io.*;
public class Main{
  public static void main(String[] args)throws Exception{
    int[] a={0,1,0,0,2,10,4,40,92,352,724,2680,14200,73712,365596};
    System.out.print(a[Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())]);
  }
}