import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class NhaXuatBan {
    private String maNXB;   // Mã nhà xuất bản
    private String tenNXB;  // Tên nhà xuất bản


    // Constructor
    public NhaXuatBan(String maNXB, String tenNXB) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
  
    }

    // Getter và Setter
    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

 

    // Phương thức hiển thị thông tin nhà xuất bản
    public String hienThiThongTin() {
        return String.format("%s%s", getMaNXB(),getTenNXB());
    }
       public static NhaXuatBan[] DocGhiDuLieuNhaXuatBan(boolean a,NhaXuatBan NhaXuatBan[]){
        //true: ghi
        int slNhaXuatBan;
     
        if(a){
            System.out.println("SoLuongNhaXuatBanla: "+NhaXuatBan.length);
   try {
    FileWriter fw =new FileWriter("./data/NhanVien.txt");
    BufferedWriter bw =new BufferedWriter(fw);
              for(NhaXuatBan t:NhaXuatBan){
                // bw.write(t.toString());
               bw.write(t.getMaNXB()+";"+t.getTenNXB());
               bw.newLine();
              }
              bw.close();
              fw.close();
        } catch (Exception e) {
        }
        }
        else{
               try {
                FileReader fr=new FileReader("./data/NhaXuatBan.txt");
                BufferedReader br =new BufferedReader(fr);
                String line="";
                slNhaXuatBan = Integer.parseInt(br.readLine());  
                       
                 while(true){
                  
                    line=br.readLine();
                    if(line ==""){
                        break;
                    }
                   
                    String txt[]=line.split(";");
                    String id=txt[0];
                    String name=txt[1];              
                    NhaXuatBan tmp=new NhaXuatBan(id, name);
                  
                           NhaXuatBan=  themNhaXuatBan(NhaXuatBan, tmp);
                                    }
                                    br.close();
                                    fr.close();
                            } catch (Exception e) {
                                System.out.println("Không tìm thấy file");
                            }
                            }
                        return NhaXuatBan;
                        }

                        public static NhaXuatBan[] themNhaXuatBan(NhaXuatBan[] NhaXuatBan, NhaXuatBan tmp) {
                            NhaXuatBan[] array = new NhaXuatBan[NhaXuatBan.length + 1];
                            System.arraycopy(NhaXuatBan, 0, array, 0, NhaXuatBan.length);
                            array[NhaXuatBan.length] = tmp;
                            return array;}
}
