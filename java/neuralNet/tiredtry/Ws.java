import java.util.Arrays;

public class Ws {
    // static W W1 = new W(4,4);
    // static W W2 = new W(3,4);
    // static W W3 = new W(2,3);

    static double[][] W1 = new double[4][3];
    static double[][] W2 = new double[3][2];
    static double[][] W3 = new double[2][2];

    static void init(){
        Arrays.fill(W1[0],1);
        Arrays.fill(W2[0],1);
        Arrays.fill(W3[0],1);
    }

}
