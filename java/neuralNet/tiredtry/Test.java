public class Test {
    static void test(){
        for(Data d : Data.dataset){
            double[] input_x = new double[d.data.length];
            for(int i = 0;i<d.data.length;i++){
                input_x[i] = d.data[i];
            }
            for(Node n1 : Nodes.N1){
                n1.set_u(input_x, Ws.W1);
            }
            double x1[] = {Nodes.N11.get_z(),Nodes.N12.get_z(),Nodes.N13.get_z(),Nodes.N14.get_z()};
            for(Node n2 : Nodes.N2){
                n2.set_u(x1, Ws.W2);
            }
            double x2[] = {Nodes.N21.get_z(),Nodes.N22.get_z(),Nodes.N23.get_z()};
            for(Node n3 : Nodes.N3){
                n3.set_u(x2, Ws.W3);
            }
            double x3[] = {Nodes.N31.get_z(),Nodes.N32.get_z()};
            System.out.println(x3[0]+" "+x3[1]);
        }
    }
}
