public class TaiLieu {
    private String maTaiLieu;   // Mã tài liệu
    private String tenTaiLieu;  // Tên tài liệu
    private NhaXuatBan nhaXuatBan;  // Tham chiếu đến nhà xuất bản
    private viTri viTri;  // Vị trí sách trong thư viện
    private TacGia tacGia;  // Tham chiếu đến tác giả

    // Constructor
    public TaiLieu(String maTaiLieu, String tenTaiLieu, NhaXuatBan nhaXuatBan, viTri viTri, TacGia tacGia) {
        this.maTaiLieu = maTaiLieu;
        this.tenTaiLieu = tenTaiLieu;
        this.nhaXuatBan = nhaXuatBan;
        this.viTri = viTri;
        this.tacGia = tacGia;
    }

    // Getter và Setter
    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getTenTaiLieu() {
        return tenTaiLieu;
    }

    public void setTenTaiLieu(String tenTaiLieu) {
        this.tenTaiLieu = tenTaiLieu;
    }

    public NhaXuatBan getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public viTri getViTri() {
        return viTri;
    }

    public void setViTri(viTri viTri) {
        this.viTri = viTri;
    }

    public TacGia getTacGia() {
        return tacGia;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    // Phương thức hiển thị thông tin tài liệu
    public void hienThiThongTin() {
        System.out.println("Mã tài liệu: " + maTaiLieu);
        System.out.println("Tên tài liệu: " + tenTaiLieu);
        nhaXuatBan.hienThiThongTin();  // Hiển thị thông tin nhà xuất bản
        viTri.hienThiThongTin();  // Hiển thị thông tin vị trí
        tacGia.hienThiThongTin();  // Hiển thị thông tin tác giả
    }
}
