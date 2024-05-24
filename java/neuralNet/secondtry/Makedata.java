import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
public class Makedata {

    static void make(int n){
        String filename = "dataset.txt";
            try{
                File file = new File(filename);
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                Random rand = new Random();
                for(int i = 0;i<n;i++){
                    int d1 = rand.nextInt(9);
                    int d2 = rand.nextInt(9);
                    int d3 = rand.nextInt(9);
                    int d4 = rand.nextInt(9);
                    int a1 = 0;
                    int a2 = 0;
                    if(d1 >= 5){
                        a1 = 1;
                    }
                    if(d2>=5){
                        a2 = 1;
                    }
                    bw.write(d1+","+d2+","+d3+","+d4+"#"+a1+","+a2);
                    bw.newLine();
                }
                bw.close();
                
            }catch(Exception e){}

    }

    
}
