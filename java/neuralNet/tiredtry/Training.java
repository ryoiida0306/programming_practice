public class Training {
    static double[][] one = {{1}};
    static double myu = 0.001;
    static void training(double[][] input, double[][] target){
        try{

            double[][] y = Matrix.throw_f(as.a3);

            double[][] delta3 = new double[2][1];
            double[][] delta2 = new double[2][1];

            delta3 = Matrix.mul_ind(Matrix.throw_fsub(as.a3),Matrix.sub(y,target));
            delta2 = Matrix.mul_ind(Matrix.throw_fsub(as.a2),Matrix.mul(Ws.W3,delta3));
            
            double[][] Delta3 = new double[3][2];
            double[][] Delta2 = new double[4][2];
            double[][] Delta1 = new double[5][3];

            Delta3 = Matrix.mul(Matrix.concat_ver(one,Matrix.throw_f(as.a2)),Matrix.transpose(delta3));
            Delta2 = Matrix.mul(Matrix.concat_ver(one,Matrix.throw_f(as.a1)),Matrix.transpose(Matrix.mul_ind(Matrix.throw_fsub(as.a2),Matrix.mul(Ws.W3,delta3))));
            Delta1 = Matrix.mul(Matrix.concat_ver(one,input),Matrix.transpose(Matrix.mul_ind(Matrix.throw_fsub(as.a1),Matrix.mul(Ws.W2,delta2))));

            Matrix.printMat(Matrix.mul_const(myu,Delta1));
            // Matrix.printMat(Matrix.cut(Matrix.mul_const(myu,Delta1),0,0,2,1));
            // bs.b1 = Matrix.sub(bs.b1,Matrix.cut(Matrix.mul_const(myu,Delta1),0,0,1,3));
            // bs.b2 = Matrix.sub(bs.b2,Matrix.cut(Matrix.mul_const(myu,Delta2),0,0,1,2));
            // bs.b3 = Matrix.sub(bs.b3,Matrix.cut(Matrix.mul_const(myu,Delta3),0,0,1,2));
            // Ws.W1 = Matrix.sub(Ws.W1,Matrix.cut(Matrix.mul_const(myu,Delta1),1,0,2,2));
            // Ws.W2 = Matrix.sub(Ws.W2,Matrix.cut(Matrix.mul_const(myu,Delta2),1,0,3,2));
            // Ws.W3 = Matrix.sub(Ws.W3,Matrix.cut(Matrix.mul_const(myu,Delta3),1,0,4,3));

        }catch(Exception e){
            System.out.println(e);
        }


    }
}
