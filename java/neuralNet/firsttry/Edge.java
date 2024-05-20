public class Edge {
    Node back;
    Node next;
    double w = 1;
    
    Edge(){}
    Edge(double w){
        this.w = w;
    }

    public double get_w(){
        return w;
    }

    public Node get_back(){
        return back;
    }
    public Node get_next(){
        return next;
    }
    public void set_w(double w){
        this.w = w;
    }
    public void update_w(double y,double d){
        w -=(y-d)*back
    }
    public void set_back(Node back){
        this.back = back;
    }
    public void set_next(Node next){
        this.next = next;
    }
    // double through(double u){
    //     u*=w;
    //     return u;
    // }
    double segmoid(double u){
        return 1/(1+Math.pow(Math.E,-u));
    }
    double segmoid_delta(double u){
        return segmoid(u)*(1-segmoid(u));
    }
}