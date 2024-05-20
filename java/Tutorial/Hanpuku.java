class Hanpuku {
    public static void main(String[] args){
        //for
        for(int i=0;i<=4;i++){
            System.out.println(i);
        }
        //break
        for(int i=0;i<=4;i++){
            if(i==3){
                break;
            }
            System.out.println(i);
        }
        //count
        for(int i=0;i<=4;i++){
            if(i==3){
                continue;
            }
            System.out.println(i);
        }
    }
    
}