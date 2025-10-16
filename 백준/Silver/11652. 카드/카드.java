import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long maxVal = arr[0];
        int maxCnt = 1;
        long curVal = arr[0];
        int curCnt = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == curVal) {
                curCnt++;
            } else {
                // 새로운 값이 등장할 때 이전값과 비교
                if (curCnt > maxCnt || (curCnt == maxCnt && curVal < maxVal)) {
                    maxCnt = curCnt;
                    maxVal = curVal;
                }
                curVal = arr[i];
                curCnt = 1;
            }
        }

        // 마지막 그룹 처리
        if (curCnt > maxCnt || (curCnt == maxCnt && curVal < maxVal)) {
            maxCnt = curCnt;
            maxVal = curVal;
        }

        System.out.println(maxVal);
    }
}
