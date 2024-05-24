public class main {
    public static void main(String[] args){

        // 1 1 1 u
        // x u u u
        // x u u
        // x u
        // x
        // double[][] x = {{1,2,3},{2,3,4}};
        // double[][] z = {{1,2,3},{2,3,4}};
        // double[][] y = {{1,2},{2,3},{3,4}};

        // try{
        //     Matrix.printMat(Matrix.cut(x,0,1,2,2));
        // }catch(Exception e){
        //     System.out.println(e);
        // }

        double[][] x = {{1},{2},{3},{4}};
        double[][] t = {{1},{1}};

        Ws.init();
        Run.running(x);
        Training.training(x,t);

        // Makedata.make(1000);
        // Data.data_read();
        // for(Data d : Data.dataset){
        //     Run.running(d.data);
        //     Training.training(x,);

        // }

        // Makedata.make(10000);
        // Data.data_read();
        // writepara.Wclean();
        // Training.training(true);
        // Test.test();


    }

    
}
