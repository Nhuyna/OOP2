public class ThuThu extends ConNguoi {
    private String maThuThu;  // Mã thủ thư
    private String chucVu;    // Chức vụ của thủ thư (Ví dụ: quản lý sách, thủ thư chính...)

    // Constructor
    public ThuThu(String maThuThu, String ten, int tuoi, String diaChi, String chucVu) {
        super(ten, tuoi, diaChi);  // Gọi constructor của lớp ConNguoi
        this.maThuThu = maThuThu;
        this.chucVu = chucVu;
    }
    public ThuThu(){

    }
    // Getter và Setter
    public String getMaThuThu() {
        return maThuThu;
    }

    public void setMaThuThu(String maThuThu) {
        this.maThuThu = maThuThu;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    // Phương thức hiển thị thông tin thủ thư
    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();  // Hiển thị thông tin của người (từ lớp ConNguoi)
        System.out.println("Mã thủ thư: " + maThuThu);
        System.out.println("Chức vụ: " + chucVu);
    }

    // Các chức năng quản lý sách

    // Thêm sách vào thư viện
    public static void themSach(Sach[] sachList, Sach sachMoi) {
        for (int i = 0; i < sachList.length; i++) {
            if (sachList[i] == null) {
                sachList[i] = sachMoi;
                System.out.println("Thêm sách thành công: " + sachMoi.getTenTaiLieu());
                return;
            }
        }
        System.out.println("Không thể thêm sách, thư viện đã đầy.");
    }

    // Xóa sách theo mã
    public void xoaSach(Sach[] sachList, String maSach) {
        for (int i = 0; i < sachList.length; i++) {
            if (sachList[i] != null && sachList[i].getMaTaiLieu().equals(maSach)) {
                sachList[i] = null;
                System.out.println("Xóa sách thành công: " + maSach);
                return;
            }
        }
        System.out.println("Sách không tồn tại.");
    }

    // Sửa thông tin sách theo mã
    public void suaSach(Sach[] sachList, String maSach, Sach sachMoi) {
        for (int i = 0; i < sachList.length; i++) {
            if (sachList[i] != null && sachList[i].getMaTaiLieu().equals(maSach)) {
                sachList[i] = sachMoi;
                System.out.println("Sửa sách thành công: " + sachMoi.getTenTaiLieu());
                return;
            }
        }
        System.out.println("Sách không tồn tại.");
    }

    // Tìm kiếm sách theo tên
    public void timKiemSach(Sach[] sachList, String tenSach) {
        for (int i = 0; i < sachList.length; i++) {
            if (sachList[i] != null && sachList[i].getTenTaiLieu().equalsIgnoreCase(tenSach)) {
                System.out.println("Sách tìm thấy: " + sachList[i].getTenTaiLieu());
                return;
            }
        }
        System.out.println("Sách không tồn tại.");
    }

    // Thêm, sửa, xóa người mượn
    public void themNguoiMuon(NguoiMuon[] nguoiMuonList, NguoiMuon nguoiMuonMoi) {
        for (int i = 0; i < nguoiMuonList.length; i++) {
            if (nguoiMuonList[i] == null) {
                nguoiMuonList[i] = nguoiMuonMoi;
                System.out.println("Thêm người mượn thành công: " + nguoiMuonMoi.getTen());
                return;
            }
        }
        System.out.println("Không thể thêm người mượn, danh sách đã đầy.");
    }

    // Xóa người mượn theo mã
    public void xoaNguoiMuon(NguoiMuon[] nguoiMuonList, String maNguoiMuon) {
        for (int i = 0; i < nguoiMuonList.length; i++) {
            if (nguoiMuonList[i] != null && nguoiMuonList[i].getMaNguoiMuon().equals(maNguoiMuon)) {
                nguoiMuonList[i] = null;
                System.out.println("Xóa người mượn thành công: " + maNguoiMuon);
                return;
            }
        }
        System.out.println("Người mượn không tồn tại.");
    }

    // Sửa thông tin người mượn
    public void suaNguoiMuon(NguoiMuon[] nguoiMuonList, String maNguoiMuon, NguoiMuon nguoiMuonMoi) {
        for (int i = 0; i < nguoiMuonList.length; i++) {
            if (nguoiMuonList[i] != null && nguoiMuonList[i].getMaNguoiMuon().equals(maNguoiMuon)) {
                nguoiMuonList[i] = nguoiMuonMoi;
                System.out.println("Sửa thông tin người mượn thành công: " + nguoiMuonMoi.getTen());
                return;
            }
        }
        System.out.println("Người mượn không tồn tại.");
    }

    // Thêm, sửa, xóa thẻ thư viện
    public void themTheThuVien(TheThuVien[] theThuVienList, TheThuVien theThuVienMoi) {
        for (int i = 0; i < theThuVienList.length; i++) {
            if (theThuVienList[i] == null) {
                theThuVienList[i] = theThuVienMoi;
                System.out.println("Thêm thẻ thư viện thành công: " + theThuVienMoi.getMaThe());
                return;
            }
        }
        System.out.println("Không thể thêm thẻ thư viện, danh sách đã đầy.");
    }

    // Xóa thẻ thư viện theo mã
    public void xoaTheThuVien(TheThuVien[] theThuVienList, String maThe) {
        for (int i = 0; i < theThuVienList.length; i++) {
            if (theThuVienList[i] != null && theThuVienList[i].getMaThe().equals(maThe)) {
                theThuVienList[i] = null;
                System.out.println("Xóa thẻ thư viện thành công: " + maThe);
                return;
            }
        }
        System.out.println("Thẻ thư viện không tồn tại.");
    }

    // Sửa thông tin thẻ thư viện
    public void suaTheThuVien(TheThuVien[] theThuVienList, String maThe, TheThuVien theThuVienMoi) {
        for (int i = 0; i < theThuVienList.length; i++) {
            if (theThuVienList[i] != null && theThuVienList[i].getMaThe().equals(maThe)) {
                theThuVienList[i] = theThuVienMoi;
                System.out.println("Sửa thẻ thư viện thành công: " + theThuVienMoi.getMaThe());
                return;
            }
        }
        System.out.println("Thẻ thư viện không tồn tại.");
    }
}
