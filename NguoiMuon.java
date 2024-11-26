public class NguoiMuon extends ConNguoi {
    private String maNguoiMuon;  // Mã người mượn
    private TheThuVien theThuVien;  // Thẻ thư viện của người mượn
    private Sach[] sachMuon;  // Mảng sách người mượn đã mượn
    private int soLuongSachMuon;  // Số lượng sách đã mượn

    // Constructor
    public NguoiMuon(String maNguoiMuon, String ten, int tuoi, String diaChi, TheThuVien theThuVien) {
        super(ten, tuoi, diaChi);  // Gọi constructor của lớp ConNguoi
        this.maNguoiMuon = maNguoiMuon;
        this.theThuVien = theThuVien;
        this.sachMuon = new Sach[10];  // Giới hạn mượn tối đa 10 sách
        this.soLuongSachMuon = 0;
    }

    // Getter và Setter
    public String getMaNguoiMuon() {
        return maNguoiMuon;
    }

    public void setMaNguoiMuon(String maNguoiMuon) {
        this.maNguoiMuon = maNguoiMuon;
    }

    public TheThuVien getTheThuVien() {
        return theThuVien;
    }

    public void setTheThuVien(TheThuVien theThuVien) {
        this.theThuVien = theThuVien;
    }

    public Sach[] getSachMuon() {
        return sachMuon;
    }

    public int getSoLuongSachMuon() {
        return soLuongSachMuon;
    }

    // Phương thức hiển thị thông tin người mượn
    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();  // Hiển thị thông tin của người (từ lớp ConNguoi)
        System.out.println("Mã người mượn: " + maNguoiMuon);
        System.out.println("Thẻ thư viện: " + theThuVien.getMaThe() + " - Loại: " + theThuVien.getLoaiThe());
        System.out.println("Số lượng sách đã mượn: " + soLuongSachMuon);
        System.out.println("Danh sách sách đã mượn: ");
        for (int i = 0; i < soLuongSachMuon; i++) {
            System.out.println("- " + sachMuon[i].getTenTaiLieu());
        }
    }

    // Phương thức mượn sách
    public void muonSach(Sach sach) {
        if (soLuongSachMuon < 10) {
            sachMuon[soLuongSachMuon] = sach;
            soLuongSachMuon++;
            System.out.println("Đã mượn sách: " + sach.getTenTaiLieu());
        } else {
            System.out.println("Không thể mượn thêm sách, số lượng đã đạt giới hạn.");
        }
    }

    // Phương thức trả sách
    public void traSach(Sach sach) {
        for (int i = 0; i < soLuongSachMuon; i++) {
            if (sachMuon[i].getMaTaiLieu().equals(sach.getMaTaiLieu())) {
                // Xóa sách khỏi danh sách mượn
                for (int j = i; j < soLuongSachMuon - 1; j++) {
                    sachMuon[j] = sachMuon[j + 1];
                }
                sachMuon[soLuongSachMuon - 1] = null;
                soLuongSachMuon--;
                System.out.println("Đã trả sách: " + sach.getTenTaiLieu());
                return;
            }
        }
        System.out.println("Sách này không có trong danh sách mượn của bạn.");
    }

    // Tính phí dựa trên loại thẻ và thời gian mượn
    public double tinhPhiMuuon() {
        int soNgayMuon = 0;
        if (theThuVien.getLoaiThe().equals("A")) {
            soNgayMuon = 30; // Thẻ A mượn tối đa 30 ngày
        } else if (theThuVien.getLoaiThe().equals("B")) {
            soNgayMuon = 15; // Thẻ B mượn tối đa 15 ngày
        }

        // Tính phí: Giả sử mỗi ngày tính phí 500 đồng
        double phi = soNgayMuon * 500;
        System.out.println("Phí mượn sách: " + phi + " VND");
        return phi;
    }
}
