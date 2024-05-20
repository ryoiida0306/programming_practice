import java.util.Random;

public class Training {
    static double myu = 1;
    static void training(Boolean write){
        Random rand = new Random();
        int counter = 0;
        for(Data d : Data.dataset){
            counter++;
            if(counter <30 && write)
            writepara.write(counter);
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
            if(counter%500==0){
                System.out.println(counter+"try");
                System.out.println(d.ans[0]+" "+d.ans[1]);
                System.out.println(x3[0]+" "+x3[1]+"\n");
            }
            
            double[] delta_1 = new double[x1.length];
            double[] delta_2 = new double[x2.length];
            double[] delta_3 = new double[x3.length];

            for(int i = 0;i<x3.length;i++){
                delta_3[i] = 0;
                delta_3[i] = x3[i]-d.ans[i];
            }
            for(int j = 0;j<x2.length;j++){
                delta_2[j] = 0;
                for(int k = 0;k<x3.length;k++){
                    delta_2[j] += delta_3[k]*Ws.W3.get_w(k,j)*Node.sigmoid_sub(Nodes.N2[j].get_u());
                }
            }
            for(int j = 0;j<x1.length;j++){
                delta_1[j] = 0;
                for(int k = 0;k<x2.length;k++){
                    delta_1[j] += delta_2[k]*Ws.W2.get_w(k,j)*Node.sigmoid_sub(Nodes.N1[j].get_u());
                }
            }
            if(counter%3 == 0){
                int ri = rand.nextInt(Ws.W1.get_xlength());
                int rj = rand.nextInt(Ws.W1.get_ulength());
                for(int i = 0;i<Ws.W1.get_xlength();i++){
                    for(int j = 0;j<Ws.W1.get_ulength();j++){
                        if(ri == i && rj == j)
                        Ws.W1.set_w(j,i,Ws.W1.get_w(j,i)-myu*delta_1[j]*d.data[i]);
                    }
                }
            }
            if(counter%3 == 1){
                int ri = rand.nextInt(Ws.W2.get_xlength());
                int rj = rand.nextInt(Ws.W2.get_ulength());
                for(int i = 0;i<Ws.W2.get_xlength();i++){
                    for(int j = 0;j<Ws.W2.get_ulength();j++){
                        if(ri == i && rj == j)
                        Ws.W2.set_w(j,i,Ws.W2.get_w(j,i)-myu*delta_2[j]*Nodes.N1[i].get_z());
                    }
                }
            }
            if(counter%3 == 2){
                int ri = rand.nextInt(Ws.W3.get_xlength());
                int rj = rand.nextInt(Ws.W3.get_ulength());
                for(int i = 0;i<Ws.W3.get_xlength();i++){
                    for(int j = 0;j<Ws.W3.get_ulength();j++){
                        if(ri == i && rj == j)
                        Ws.W3.set_w(j,i,Ws.W3.get_w(j,i)-myu*delta_3[j]*Nodes.N2[i].get_z());
                    }
                }
            }




        }
    }
}
