import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args){
        Date today = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-dd");
        String today_format = format1.format(today);
        System.out.println(today_format);
    }
}