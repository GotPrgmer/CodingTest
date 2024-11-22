import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int testLine = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();
        for(int inputIdx=0;inputIdx<input.length();inputIdx++){
            list.add(input.charAt(inputIdx));
        }
        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }
        for(int cmdIdx=0;cmdIdx<testLine;cmdIdx++){
            String cmd = br.readLine();
            char cmdKind = cmd.charAt(0);
            if (cmdKind=='L') {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (cmdKind=='D') {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (cmdKind=='B') {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if (cmdKind=='P') {
                char plusChar = cmd.charAt(2);
                iter.add(plusChar);
            }
        }
        for (Character chr : list) {
            bw.write(chr);
        }
        bw.flush();
        bw.close();
    }
}
