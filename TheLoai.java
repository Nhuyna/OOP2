import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TheLoai {
    private String maTheLoai;  // Mã thể loại
    private String tenTheLoai; // Tên thể loại

    // Constructor
    public TheLoai(String maTheLoai, String tenTheLoai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    // Getter và Setter
    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    // Hiển thị thông tin thể loại
    public void hienThiTheLoai() {
        System.out.println("Mã thể loại: " + maTheLoai);
        System.out.println("Tên thể loại: " + tenTheLoai);
    }
     public static TheLoai[] themTheLoai(TheLoai[] theLoai, TheLoai tmp) {
    TheLoai[] array = new TheLoai[theLoai.length + 1];
    System.arraycopy(theLoai, 0, array, 0, theLoai.length);
    array[theLoai.length] = tmp;
    return array;}
       public static TheLoai[] DocGhiDuLieuTheLoai(boolean a,TheLoai TheLoai[]){
        //true: ghi
        int slTheLoai;

        if(a){
   try {

    FileWriter fw =new FileWriter("./data/TheLoai.txt");
    BufferedWriter bw =new BufferedWriter(fw);
               bw.write(""+TheLoai.length);
               bw.newLine();
              for(TheLoai t:TheLoai){
                // bw.write(t.toString());
               bw.write(t.getMaTheLoai()+";"+t.getTenTheLoai());
               bw.newLine();
              }
              bw.close();
              fw.close();
        } catch (Exception e) {
        }
        }
        else{
               try {
                FileReader fr=new FileReader("./data/TheLoai.txt");
                BufferedReader br =new BufferedReader(fr);
                String line="";
                slTheLoai = Integer.parseInt(br.readLine());                while(true){
                  
                    line=br.readLine();
                    if(line ==""){
                        break;
                    }
                    String txt[]=line.split(";");
                    String id=txt[0];
                    String name=txt[1]; 
                    TheLoai tmp=new TheLoai(id, name);
                    TheLoai=themTheLoai(TheLoai, tmp);
                                    }
                                    br.close();
                                    fr.close();
                            } catch (Exception e) {
                               
                            }
                            }
                        return TheLoai;
                        }
}
