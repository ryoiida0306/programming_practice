import java.util.ArrayList;

public class Node {
    ArrayList<Edge> in = new ArrayList<Edge>();
    ArrayList<Edge> out = new ArrayList<Edge>();

    double x = 1;
    // double b = 1;
    double u = 1;
    double z = 1;


    boolean isInputData = false;
    boolean isOutputData = false;
    boolean isConst = false;

    // int depth = 1;
    // int id = 0;

    public Node(){}
    public Node(int num){
        if(num == 1){isInputData = true;}
        if(num == 2){isOutputData = true;}
        if(num == 3){isConst = true;}

    }
    public Node(int num,int x){
        this(num);
        this.x = x;
    }
    // public Node(int depth){
    //     this.depth = depth;
    // }
    // public Node(int depth,int id){
    //     this(depth);
    //     this.id = id;
    // }

    public void add_in(Edge e){
        in.add(e);
    }
    public void add_out(Edge e){
        out.add(e);
    }

    
    public void through(){
        if(!isInputData){
            set_u_z();
        }
    }
    
    
    public double get_z(){
        if(isInputData){return x;}
        if(isConst){return 1;}
        return z;
    }
    
    
    public void set_u_z(){
        u = 0;
        for(int i = 0;i<in.size();i++){
            double x = in.get(i).get_back().get_z();
            double w = in.get(i).get_w();
            u += w*x;
        }
        // u += b;
        z = segmoid(u);
    }

    // public void set_b(double b){
    //     this.b = b;
    // }

    
    // public void add(int num){
    //     this.u += num;
    // }

    double segmoid(double u){
        return 1/(1+Math.pow(Math.E,-u));
    }

    // public void linkPreEdge(Edge e){
    //     pre = e;
    // }

    // public void linkNextEdge(Edge e){
    //     next = e;
    // }
}
