public class W {
    double[][] w;

    W(){};

    W(int ulength, int xlength){
        w = new double[ulength][xlength];
        for(int i = 0;i<ulength;i++){
            for(int j = 0;j<xlength;j++){
                w[i][j]=1;
            }
        }
    }

    public int get_ulength(){
        return w.length;
    }
    public int get_xlength(){
        return w[0].length;
    }

    public double get_w(int i, int j) {
        return w[i][j];
    }
    public void set_w(int i, int j, double value){
        w[i][j] = value;
    }

    @Override
    public String toString() {
        String S ="";
        for(int i = 0;i<get_ulength();i++){
            for(int j = 0;j<get_xlength();j++){
                S = S + w[i][j]+" ";
            }
            S = S + "\n";
        }
        return S;
    }
}
