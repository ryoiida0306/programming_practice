class Hanpuku2 {
    public static void main(String[] args){
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                System.out.println(i+"-"+j);
            }
        }
        int arr[]={2,4,6,8,10};
        for(int i=0;i<=4;i++){
            System.out.println(arr[i]);
        }
        int sum=0;
        for(int i=0;i<=4;i++){
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}