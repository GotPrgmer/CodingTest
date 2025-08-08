import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            LinkedList<Character> lst = new LinkedList<>();
            ListIterator<Character> li = lst.listIterator();
            String s = br.readLine();
            for(char c:s.toCharArray()){
                if(c == '<'){
                    if(li.hasPrevious()) {
                        li.previous();
                    }
                }
                else if(c == '>'){
                if(li.hasNext()) {
                    li.next();
                }
                }
                else if(c == '-') {

                    if (li.hasPrevious()) {
                        if (li.hasPrevious()) {
                            li.previous();
                            li.remove();
                        }
                    }
                }
                else{
                    li.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!lst.isEmpty()){
                sb.append(lst.poll());
            }
            System.out.println(sb.toString());
        }

    }
}