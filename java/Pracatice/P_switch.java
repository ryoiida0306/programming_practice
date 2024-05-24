class P_switch{
    public static void main(String[] args){
        int x=4;
        switch(x){
            case 1:
            System.out.println("x=1");
            break;
            case 2:
            case 3:
            System.out.println("x=2 or 3");
            break;
            default:
            System.out.println("x is not 1,2,3");
            break;
        }
    }
}