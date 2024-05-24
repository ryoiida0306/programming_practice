import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.text.Segment;

public class NN {
    public static void main(String[] args){
        // 0層:3つ（入力層）
        // 1層:3つ
        // 2層:3つ
        // 3層:3つ
        // 4層:1つ（出力層）
        int[] setting = {3,3,3,3,1};
        int[] data = {1,2,3};

        Node[][] nodes = {//何層の何個目のノードか
        {new Node(1,data[0]),new Node(1,data[1]),new Node(1,data[2])},
        {new Node(),new Node(),new Node()},
        {new Node(),new Node(),new Node()},
        {new Node(),new Node(),new Node()},
        {new Node(2)}
        };
    // new Node(0,0),new Node(0,1),new Node(0,2),
    // new Node(1,3),new Node(1,4),new Node(1,5),
    // new Node(2,6),new Node(2,7),new Node(2,8),
    // new Node(3,9),new Node(3,10),new Node(3,11),
    // new Node(4,12)}
    
        Edge[][][] edges = {//n層とn+1層をつなぐ何個目(n層)と何個目(n+1層)をつなぐエッジか
            {
            {new Edge(),new Edge(),new Edge()},
            {new Edge(),new Edge(),new Edge()},
            {new Edge(),new Edge(),new Edge()}
            },{
            {new Edge(),new Edge(),new Edge()},
            {new Edge(),new Edge(),new Edge()},
            {new Edge(),new Edge(),new Edge()}
            },{
            {new Edge(),new Edge(),new Edge()},
            {new Edge(),new Edge(),new Edge()},
            {new Edge(),new Edge(),new Edge()}
            },{
            {new Edge(),new Edge(),new Edge()}
            }
        };
        //in Node
        for(int i = 1;i<setting.length;i++){
            for(int j = 0;j<setting[i];j++){
                for(int k = 0;k<setting[i-1];k++){
                    // System.out.println(i+","+j+","+k);
                    try{
                        nodes[i][j].add_in(edges[i-1][k][j]);       
                    }catch(ArrayIndexOutOfBoundsException e){}
                }
            }
        }
        //out Node
        for(int i = 0;i<setting.length-1;i++){
            for(int j = 0;j<setting[i+1];j++){
                for(int k = 0;k<setting[i];k++){
                    try{
                        nodes[i][j].add_out(edges[i][k][j]);       
                    }catch(ArrayIndexOutOfBoundsException e){}
                }
            }
        }
        //Edge
        for(int i = 0;i<setting.length-1;i++){
            for(int j = 0;j<setting[i];j++){
                for(int k = 0;k<setting[i+1];k++){
                    try{
                        edges[i][j][k].set_back(nodes[i][j]); //back
                        edges[i][j][k].set_next(nodes[i][k]); //next
                    }catch(ArrayIndexOutOfBoundsException e){}
                    
                }
            }
        }
        



        // String filename = "WBdata";
        // try{
        //     BufferedReader reader = new BufferedReader(new FileReader(filename));
        //     String line;
        //     int i = 0;
        //     while((line = reader.readLine()) != null){
        //         String[] w_b = line.split(",");
        //         nodes[i].set_w(Integer.parseInt(w_b[0]));
        //         nodes[i].set_b(Integer.parseInt(w_b[1]));
        //         i++;
        //     }
        //     reader.close();
        // }catch(IOException e){
        //     System.out.println(e);
        // }



        for(int i = 0;i<setting.length;i++){
            for(int j = 0;j<setting[i];j++){
                nodes[i][j].through();
            }
        }
        

        System.out.println(nodes[setting.length-1][0].get_z());
        System.out.println(nodes[1][0].get_z());
        System.out.println(nodes[1][1].get_z());
        System.out.println(nodes[1][2].get_z());
        
    }
    
}



