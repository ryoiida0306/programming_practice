class Try{
    static int var(int[] atai){
        int sum=0;
        for(int i=0;i<atai.length;i++){
            sum+=atai[i];
        }
        int average=sum/atai.length;
        int hensa2wa=0;
        for(int i=0;i<atai.length;i++){
            hensa2wa+=(atai[i]-average)*(atai[i]-average);
        }
        return hensa2wa/atai.length;
    }
    public static void main(String[] args){
        int[] data={1,2,3,4,5};
        int x=var(data);
        System.out.println(x);
    }
}