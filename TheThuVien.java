public class TheThuVien {
    private String maThe; // Mã thẻ
    private String loaiThe; // Loại thẻ A hoặc B
    private int soNgayMuon; // Số ngày có thể mượn sách
    private double phiThuongNien; // Phí thường niên

    // Constructor để tạo thẻ thư viện, mặc định sẽ có loại thẻ A hoặc B
    public TheThuVien(String maThe, String loaiThe) {
        this.maThe = maThe;
        this.loaiThe = loaiThe;
        // Cài đặt thông tin cho từng loại thẻ
        if (loaiThe.equals("A")) {
            this.soNgayMuon = 30; // Thẻ A mượn 30 ngày
            this.phiThuongNien = 100000; // Phí thường niên cho thẻ A
        } else if (loaiThe.equals("B")) {
            this.soNgayMuon = 15; // Thẻ B mượn 15 ngày
            this.phiThuongNien = 50000; // Phí thường niên cho thẻ B
        } else {
            this.soNgayMuon = 0;
            this.phiThuongNien = 0;
            System.out.println("Loại thẻ không hợp lệ.");
        }
    }

    // Getter và Setter
    public String getMaThe() {
        return maThe;
    }

    public String getLoaiThe() {
        return loaiThe;
    }

    public int getSoNgayMuon() {
        return soNgayMuon;
    }

    public void setSoNgayMuon(int soNgayMuon) {
        this.soNgayMuon = soNgayMuon;
    }

    public double getPhiThuongNien() {
        return phiThuongNien;
    }

    public void setPhiThuongNien(double phiThuongNien) {
        this.phiThuongNien = phiThuongNien;
    }

    // Phương thức hiển thị thông tin thẻ
    public void hienThiThongTin() {
        System.out.println("Mã thẻ: " + maThe);
        System.out.println("Loại thẻ: " + loaiThe);
        System.out.println("Số ngày mượn: " + soNgayMuon);
        System.out.println("Phí thường niên: " + phiThuongNien);
    }
}
