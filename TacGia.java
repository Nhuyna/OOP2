import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TacGia {
    private String id;
    private String tenTacGia;  // Tên tác giả
    private int namSinh;       // Năm sinh của tác giả

    // Constructor
    public TacGia(String id,String tenTacGia, int namSinh) {
        this.id=id;
        this.tenTacGia = tenTacGia;
        this.namSinh = namSinh;
    }

    // Getter và Setter
    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    // Phương thức hiển thị thông tin tác giả
    public void hienThiThongTin() {
        System.out.println("Tên tác giả: " + tenTacGia);
        System.out.println("Năm sinh: " + namSinh);
    }
       public static TacGia[] DocGhiDuLieuTacGia(boolean a,TacGia TacGia[]){
        //true: ghi
        int slTacGia;
     
        if(a){
            System.out.println("SoLuongTacGiala: "+TacGia.length);
   try {
    FileWriter fw =new FileWriter("./data/NhanVien.txt");
    BufferedWriter bw =new BufferedWriter(fw);
              for(TacGia t:TacGia){
                // bw.write(t.toString());
               bw.write(t.getId()+";"+t.getTenTacGia()+";"+t.getNamSinh());
               bw.newLine();
              }
              bw.close();
              fw.close();
        } catch (Exception e) {
        }
        }
        else{
               try {
                FileReader fr=new FileReader("./data/TacGia.txt");
                BufferedReader br =new BufferedReader(fr);
                String line="";
                slTacGia = Integer.parseInt(br.readLine());  
                       
                 while(true){
                  
                    line=br.readLine();
                    if(line ==""){
                        break;
                    }
                   
                    String txt[]=line.split(";");
                    String id=txt[0];
                    String name=txt[1]; 
                    int NamSinh= Integer.parseInt(txt[2]);
                    

                  
                    TacGia tmp=new TacGia(id, name,NamSinh);
                  
                           TacGia=  themTacGia(TacGia, tmp);
                                    }
                                    br.close();
                                    fr.close();
                            } catch (Exception e) {
                                System.out.println("Không tìm thấy file");
                            }
                            }
                        return TacGia;
                        }

                        public static TacGia[] themTacGia(TacGia[] TacGia, TacGia tmp) {
                            TacGia[] array = new TacGia[TacGia.length + 1];
                            System.arraycopy(TacGia, 0, array, 0, TacGia.length);
                            array[TacGia.length] = tmp;
                            return array;}
}
