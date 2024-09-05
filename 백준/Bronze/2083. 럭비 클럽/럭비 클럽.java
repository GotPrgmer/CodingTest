import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String name;
            int age;
            int weight;
            String[] inputList = br.readLine().split(" ");
            name = inputList[0];
            age = Integer.parseInt(inputList[1]);
            weight = Integer.parseInt(inputList[2]);
            if(name.equals("#") && age==0 && weight==0){
                break;
            }
            else{
                if(age>17 || weight>=80){
                    System.out.println(name + " "+"Senior");
                }
                else{
                    System.out.println(name + " "+"Junior");
                }
            }

        }
    }
}
