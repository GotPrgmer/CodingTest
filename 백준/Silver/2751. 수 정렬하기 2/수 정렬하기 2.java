import java.util.*;
import java.io.*;
public class Main {
    static int[] arr;
    static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0,N);
        for(int i=0;i<N;i++){
            System.out.println(arr[i]);
        }
    }
    static void merge(int st, int end){
        int mid = (st+end)/2;
        int[] arr1 = Arrays.copyOfRange(arr,st,mid);
        int[] arr2 = Arrays.copyOfRange(arr,mid,end);
        int l1 = arr1.length;
        int l2 = arr2.length;
        int idx1 = 0;
        int idx2 = 0;
        for(int i=st;i<end;i++){
            if(idx1 == l1) tmp[i] = arr2[idx2++];
            else if(idx2 == l2) tmp[i] = arr1[idx1++];
            else if(arr1[idx1]<=arr2[idx2]) tmp[i] = arr1[idx1++];
            else tmp[i] = arr2[idx2++];
        }
        for(int i=st;i<end;i++){
            arr[i] = tmp[i];
        }
    }
    static void mergeSort(int st, int end){
        if(st+1 == end){
            return;
        }
        int mid = (st+end)/2;
        mergeSort(st,mid);
        mergeSort(mid,end);
        merge(st,end);
    }
}
