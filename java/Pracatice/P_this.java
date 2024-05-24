class P_this{

    //クラス変数
    String animal ="rabbit";

    public void print(){

        //ローカル変数
        String animal="cat";
        System.out.println("rocal="+animal);
        System.out.println("class="+this.animal);
    }
}

public static void main(String[] args){

    P_this aiueo = new P_this();
    aiueo.print();
}