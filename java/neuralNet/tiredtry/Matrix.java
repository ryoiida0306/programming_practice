public class Matrix {
    static double[][] mul(double[][] x, double[][] y) throws MatException{//掛け算
        double[][] ans = new double[x.length][y[0].length];
        for(int i = 0;i<ans.length;i++){
            for(int j = 0;j<ans[0].length;j++){
                ans[i][j] = 0;
                if(x[0].length != y.length){throw new MatException("配列の幅が合わない。:mul");}
                for(int k = 0;k<x[0].length;k++){
                    ans[i][j] += x[i][k]*y[k][j];
                }
            }
        }
        return ans;
    }
    static double[][] mul_ind(double[][] x, double[][] y) throws MatException{//要素別掛け算
        double[][] ans = new double[x.length][x[0].length];
        for(int i = 0;i<ans.length;i++){
            for(int j = 0;j<ans[0].length;j++){
                if(x.length !=y.length || x[0].length != y[0].length){throw new MatException("配列の大きさが合わない。:mul_ind");}
                ans[i][j] = 0;
                ans[i][j] = x[i][j] * y[i][j];
            }
        }
        return ans;
    }
    static double[][] mul_const(double cons, double[][] x) throws MatException{
        double[][] Cons = new double[x.length][x[0].length];
        for(int i = 0;i<x.length;i++){
            for(int j = 0;j<x[0].length;j++){
                Cons[i][j] = cons;
            }
        }
        return mul_ind(Cons,x);
    }
    static double[][] add(double[][] x, double[][] y) throws MatException{//足し算
        double[][] ans = new double[x.length][x[0].length];
        for(int i = 0;i<ans.length;i++){
            for(int j = 0;j<ans[0].length;j++){
                ans[i][j] = 0;
                if(x.length !=y.length || x[0].length != y[0].length){throw new MatException("配列の大きさが合わない。:add/sub");}
                ans[i][j] = x[i][j] + y[i][j];
            }
        }
        return ans;
    }
    static double[][] sub(double[][] x, double[][] y) throws MatException{//引き算
        for(int i = 0;i<y.length;i++){
            for(int j = 0;j<y[0].length;j++){
                y[i][j] *= -1;
            }
        }
        return add(x,y);
    }
    static double[][] transpose(double[][] x){//転置
        double[][] ans = new double[x[0].length][x.length];
        for(int i = 0;i<x.length;i++){
            for(int j = 0;j<x[0].length;j++){
                ans[j][i] = 0;
                ans[j][i] = x[i][j];
            }
        }
        return ans;
    }
    static double[][] concat_hor(double[][] x, double[][] y) throws MatException{//横にくっつける
        double[][] ans = new double[x.length][x[0].length+y[0].length];
        if(x.length != y.length){throw new MatException("配列の大きさが合わない。:concat_hor");}
        for(int i = 0;i<x.length;i++){
            for(int j = 0;j<x[0].length;j++){
                ans[i][j] = 0;
                ans[i][j] = x[i][j];
            }
        }
        for(int i = 0;i<y.length;i++){
            for(int j = 0;j<y[0].length;j++){
                ans[i][j+x[0].length] = 0;
                ans[i][j+x[0].length] = y[i][j];
            }
        }
        return ans;
    }
    static double[][] concat_ver(double[][] x, double[][] y) throws MatException{//縦にくっつける
        double[][] ans = new double[x.length+y.length][x[0].length];
        if(x[0].length != y[0].length){throw new MatException("配列の大きさが合わない。:concat_ver");}
        for(int i = 0;i<x.length;i++){
            for(int j = 0;j<x[0].length;j++){
                ans[i][j] = 0;
                ans[i][j] = x[i][j];
            }
        }
        for(int i = 0;i<y.length;i++){
            for(int j = 0;j<y[0].length;j++){
                ans[i+x.length][j] = 0;
                ans[i+x.length][j] = y[i][j];
            }
        }
        return ans;
    }

    static double[][] throw_f(double[][] x){
        for(int i = 0;i < x.length;i++){
            for(int j = 0;j < x[0].length;j++){
                x[i][j] = f(x[i][j]);
            }
        }
        return x;
    }
    static double[][] throw_fsub(double[][] x){
        for(int i = 0;i < x.length;i++){
            for(int j = 0;j < x[0].length;j++){
                x[i][j] = f_sub(x[i][j]);
            }
        }
        return x;
    }

    static double[][] cut(double[][] x,int v, int h, int height,int weight) throws MatException{//v:高さの座標(0<=v<=x.length-1),h:幅の座標(0<=h<=x[0].length-1),
        double[][] ans = new double[weight][height];
        if(v+height>x.length || h+weight>x[0].length){throw new MatException("配列の大きさが合わない。:cut");}
        for(int i = 0;i<height;i++){
            for(int j = 0;j<weight;j++){
                ans[i][j] = 0;
                ans[i][j] = x[i+v][j+h];
            }
        }
        return ans;

    }

    static double f(double x){
        return sigmoid(x);
    }
    static double f_sub(double x){
        return sigmoid_sub(x);
    }

    static double sigmoid(double x){
        return 1/(1+Math.exp(-x));
    }

    static double sigmoid_sub(double x){
        return sigmoid(x)*(1-sigmoid(x));
    }




    public static void printMat(double[][] x) {//表示
        for(int i = 0;i < x.length;i++){
            for(int j = 0;j<x[0].length;j++){
                System.out.print(x[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}

