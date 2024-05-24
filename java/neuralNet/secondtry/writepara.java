import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class writepara {
    static void write(int num){
        String filename = "W.txt";
            try{
                File file = new File(filename);
                BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
                bw.write(num+"try\n");
                bw.write("W1:\n");
                bw.write(Ws.W1.toString());
                bw.write("W2:\n");
                bw.write(Ws.W2.toString());
                bw.write("W3:\n");
                bw.write(Ws.W3.toString());
                bw.newLine();
                bw.close();
                
            }catch(Exception e){}
    }
    static void Wclean(){
        String filename = "W.txt";
        try{
            File file = new File(filename);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.close();
            
        }catch(Exception e){}
    }
    
}
