public class Test {

    public static void main(String[] args) {
        int[] a = {2,67,45,4,10,9};
        int n = a.length;

        for (int i =0;i<n-1;i++){
            for(int j=0; j<n-i-1; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j] ;
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++){
            int diff = a[i+1]-a[i];

            if(diff < min){
                min = diff;
            }
        }
        System.out.println("Minimum diffrence is : "+ min);
    }
}
