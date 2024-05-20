import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Data {
    double[] data = {1,1,1,1};
    double[] ans = {0,1};

    Data(double[] data, double[] ans){
        for(int i = 0; i< data.length;i++){
            this.data[i] = data[i];
        }
        for(int i = 0; i< ans.length;i++){
            this.ans[i] = ans[i];
        }
    }

    double[] get_ans(){
        return ans;
    }


    static ArrayList<Data> dataset = new ArrayList<>();

    static void data_read(){
        String filename = "dataset.txt";
        try{
            File file = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                // System.out.println(line);
                String[] s = line.split("#");
                String[] sd = s[0].split(",");
                String[] sa = s[1].split(",");
                double[] dd = new double[sd.length];
                for(int i = 0;i<sd.length;i++){
                    dd[i] = Double.parseDouble(sd[i]);
                }
                double[] da = new double[sa.length];
                for(int i = 0;i<sa.length;i++){
                    da[i] = Double.parseDouble(sa[i]);
                }
                dataset.add(new Data(dd,da));
            }
        }catch(Exception e){}

    }
}
