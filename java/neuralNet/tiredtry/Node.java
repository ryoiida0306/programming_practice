
class Node{
    double u = 1;//パラメータ
    double b = 0;//パラメータ
    int layer;//入力層が0層
    int senum;//定数の入力層を0層とするため1層から
    boolean isConst = false;

    Node(int layer, int senum){
        this.layer = layer;
        this.senum = senum;
    }
    Node(int layer, int senum, boolean isConst){
        this(layer,senum);
        this.isConst = isConst;

    }
    
    void set_u(double[] x,W preW){
        // System.out.println(layer+" "+senum+"  ");
        // System.out.println(preW.get_ulength()+" "+preW.get_xlength());
        double[] w_j = preW.w[senum-1];
        u = 0;
        for(int i = 0;i < x.length;i++){
            u += w_j[i]*x[i];
        }
        u += b;
    }

    double get_u(){
        if(isConst){return 1001001001;}
        return u;
    }

    double get_z(){
        if(isConst){return 1;}
        return sigmoid(u);
    }


    static double sigmoid(double x){
        return 1/(1+Math.exp(-x));
    }

    static double sigmoid_sub(double x){
        return sigmoid(x)*(1-sigmoid(x));
    }


   
}