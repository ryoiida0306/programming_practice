public class Run {
    static double[][] one = {{1}};
    static void running(double[][] x){
        try{
            double[][] input = Matrix.concat_ver(one, x);


            as.a1 = Matrix.mul(Matrix.concat_hor(bs.b1,Matrix.transpose(Ws.W1)),input);
            as.a2 = Matrix.mul(Matrix.concat_hor(bs.b2,Matrix.transpose(Ws.W2)),Matrix.concat_ver(one,Matrix.throw_f(as.a1)));
            as.a3 = Matrix.mul(Matrix.concat_hor(bs.b3,Matrix.transpose(Ws.W3)),Matrix.concat_ver(one,Matrix.throw_f(as.a2)));
            
            // Matrix.printMat(Matrix.throw_f(as.a1));
            // System.out.println();
            // Matrix.printMat(Matrix.throw_f(as.a2));
            // System.out.println();
            // Matrix.printMat(Matrix.throw_f(as.a3));

        }catch(Exception e){
            System.out.println(e);
            
        }





    }
}
