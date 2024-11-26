public class Sach extends TaiLieu {
    private int soTrang;  // Số trang của sách
    private TheLoai TheLoai;
    // Constructor
    public Sach(String maTaiLieu, String tenTaiLieu, NhaXuatBan nhaXuatBan, viTri viTri, TacGia tacGia,TheLoai TheLoai, int soTrang) {
        super(maTaiLieu, tenTaiLieu, nhaXuatBan, viTri, tacGia);
        this.soTrang = soTrang;
        this.TheLoai=TheLoai;
    }

    // Getter và Setter
    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }
    

    // Phương thức hiển thị thông tin sách
    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();  // Hiển thị thông tin tài liệu
        System.out.println("Số trang: " + soTrang);
    }
}
