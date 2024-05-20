class Enzansi3 {
    public static void main(String[] args){
        int x=2;
        int y=10;
        int z=20;
        System.out.println(x+=10);//12
        System.out.println(z+=y);//30
        System.out.println(z);//30
        x++;
        System.out.println(x);//13
        y--;
        System.out.println(y);//9
    }   
}