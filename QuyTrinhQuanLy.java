public interface QuyTrinhQuanLy {

    // Quản lý sách
    void themSach(Sach sach);
    void xoaSach(String maSach);
    void suaSach(String maSach, String tenSach, String tacGia, String nhaXuatBan);
    void timKiemSach(String tuKhoa);
    void thongKeSach();

    // Quản lý thẻ thư viện
    void themTheThuVien(TheThuVien theThuVien);
    void suaTheThuVien(String maThe, String loaiThe);
    void xoaTheThuVien(String maThe);

    // Quản lý người mượn
    void themNguoiMuon(NguoiMuon nguoiMuon);
    void xoaNguoiMuon(String maNguoiMuon);

    // Mượn và trả sách
    void muonSach(NguoiMuon nguoiMuon, Sach sach);
    void traSach(NguoiMuon nguoiMuon, Sach sach);
}
