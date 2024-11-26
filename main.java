public class main {
    public static void main(String[] args) {
     NhaXuatBan tmp[]=new NhaXuatBan[0];
    tmp= NhaXuatBan.DocGhiDuLieuNhaXuatBan(false, tmp);
     for(NhaXuatBan test:tmp){
        System.out.println(test.hienThiThongTin());
     }
    }
}
