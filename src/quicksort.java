import java.util.Scanner;

public class quicksort {

    public static void quickSort(int[] a,int l,int r){
        if(l<r){
            int mid = Partition(a,l,r);
            quickSort(a,l,mid-1);
            quickSort(a,mid+1,r);
        }
    }

    public static int Partition(int[] a,int l,int r){
        int pivot = a[l];
        //先移动右指针
        while(l<r){
            while(l<r&&a[r]>=pivot) --r;//当右侧元素大于pivot时,右指针左移
            a[l] = a[r];
            while(l<r&&a[l]<=pivot) ++l;
            a[r] = a[l];
        }
        //当l>=r时,pivot移动到指针l处
        a[l] = pivot;
        return l;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] nums = str.split(",");
        int length = nums.length;
        int[] array = new int[length];
        for(int i=0;i<length;i++){
            array[i] = Integer.parseInt(nums[i]);
        }

        quickSort(array,0,length-1);
        for(int i:array){
            System.out.print(i+" ");
        }


    }
}
