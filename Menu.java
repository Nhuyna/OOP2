import java.util.Scanner;

public class Menu implements QuyTrinhQuanLy{
    public static void MenuQLTV(){
         Sach sach1 = new Sach("S001", "Sách 1", "Tác Giả A", "NXB A", "Đang rảnh");
        Sach sach2 = new Sach("S002", "Sách 2", "Tác Giả B", "NXB B", "Đang rảnh");
        NguoiMuon nguoiMuon = new NguoiMuon("GM01", "Người Mượn A");
        TheThuVien theThuVien = new TheThuVien("A001", 30, 100);
        
        // Tạo thủ thư và quy trình quản lý
        QuyTrinhQuanLy quyTrinhQuanLy = new QuyTrinhQuanLyImpl();

        // Thêm sách vào hệ thống
        quyTrinhQuanLy.themSach(sach1);
        quyTrinhQuanLy.themSach(sach2);

        // Menu cho người dùng
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Menu Quản Lý Thư Viện =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Xóa sách");
            System.out.println("3. Sửa thông tin sách");
            System.out.println("4. Tìm kiếm sách");
            System.out.println("5. Thống kê sách");
            System.out.println("6. Thêm thẻ thư viện");
            System.out.println("7. Xóa thẻ thư viện");
            System.out.println("8. Thêm người mượn");
            System.out.println("9. Xóa người mượn");
            System.out.println("10. Mượn sách");
            System.out.println("11. Trả sách");
            System.out.println("12. Thoát");

            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ ký tự newline

            switch (choice) {
                case 1:
                    // Thêm sách
                    System.out.print("Nhập mã sách: ");
                    String maSach = scanner.nextLine();
                    System.out.print("Nhập tên sách: ");
                    String tenSach = scanner.nextLine();
                    System.out.print("Nhập tác giả: ");
                    String tacGia = scanner.nextLine();
                    System.out.print("Nhập nhà xuất bản: ");
                    String nhaXuatBan = scanner.nextLine();
                    quyTrinhQuanLy.themSach(new Sach(maSach, tenSach, tacGia, nhaXuatBan, "Đang rảnh"));
                    break;
                case 2:
                    // Xóa sách
                    System.out.print("Nhập mã sách cần xóa: ");
                    maSach = scanner.nextLine();
                    quyTrinhQuanLy.xoaSach(maSach);
                    break;
                case 3:
                    // Sửa sách
                    System.out.print("Nhập mã sách cần sửa: ");
                    maSach = scanner.nextLine();
                    System.out.print("Nhập tên sách mới: ");
                    tenSach = scanner.nextLine();
                    System.out.print("Nhập tác giả mới: ");
                    tacGia = scanner.nextLine();
                    System.out.print("Nhập nhà xuất bản mới: ");
                    nhaXuatBan = scanner.nextLine();
                    quyTrinhQuanLy.suaSach(maSach, tenSach, tacGia, nhaXuatBan);
                    break;
                case 4:
                    // Tìm kiếm sách
                    System.out.print("Nhập từ khóa tìm kiếm sách: ");
                    String tuKhoa = scanner.nextLine();
                    quyTrinhQuanLy.timKiemSach(tuKhoa);
                    break;
                case 5:
                    // Thống kê sách
                    quyTrinhQuanLy.thongKeSach();
                    break;
                case 6:
                    // Thêm thẻ thư viện
                    System.out.print("Nhập mã thẻ thư viện: ");
                    String maThe = scanner.nextLine();
                    System.out.print("Nhập loại thẻ: ");
                    String loaiThe = scanner.nextLine();
                    System.out.print("Nhập phí thường niên: ");
                    double phiThue = scanner.nextDouble();
                    System.out.print("Nhập số ngày mượn: ");
                    int soNgayMuon = scanner.nextInt();
                    scanner.nextLine();  // Đọc bỏ ký tự newline
                    quyTrinhQuanLy.themTheThuVien(new TheThuVien(maThe, soNgayMuon, phiThue));
                    break;
                case 7:
                    // Xóa thẻ thư viện
                    System.out.print("Nhập mã thẻ thư viện cần xóa: ");
                    maThe = scanner.nextLine();
                    quyTrinhQuanLy.xoaTheThuVien(maThe);
                    break;
                case 8:
                    // Thêm người mượn
                    System.out.print("Nhập mã người mượn: ");
                    String maNguoiMuon = scanner.nextLine();
                    System.out.print("Nhập tên người mượn: ");
                    String tenNguoiMuon = scanner.nextLine();
                    quyTrinhQuanLy.themNguoiMuon(new NguoiMuon(maNguoiMuon, tenNguoiMuon));
                    break;
                case 9:
                    // Xóa người mượn
                    System.out.print("Nhập mã người mượn cần xóa: ");
                    maNguoiMuon = scanner.nextLine();
                    quyTrinhQuanLy.xoaNguoiMuon(maNguoiMuon);
                    break;
                case 10:
                    // Mượn sách
                    System.out.print("Nhập mã người mượn: ");
                    maNguoiMuon = scanner.nextLine();
                    System.out.print("Nhập mã sách mượn: ");
                    maSach = scanner.nextLine();
                    NguoiMuon nguoiMuon = null;
                    Sach sach = null;
                    // Tìm người mượn và sách theo mã
                    for (NguoiMuon nm : quyTrinhQuanLy.nguoiMuonList) {
                        if (nm.getMaNguoiMuon().equals(maNguoiMuon)) {
                            nguoiMuon = nm;
                            break;
                        }
                    }
                    for (Sach s : quyTrinhQuanLy.sachList) {
                        if (s.getMaSach().equals(maSach)) {
                            sach = s;
                            break;
                        }
                    }
                    if (nguoiMuon != null && sach != null) {
                        quyTrinhQuanLy.muonSach(nguoiMuon, sach);
                    } else {
                        System.out.println("Không tìm thấy sách hoặc người mượn.");
                    }
                    break;
                case 11:
                    // Trả sách
                    System.out.print("Nhập mã người mượn: ");
                    maNguoiMuon = scanner.nextLine();
                    System.out.print("Nhập mã sách trả: ");
                    maSach = scanner.nextLine();
                    for (NguoiMuon nm : quyTrinhQuanLy.nguoiMuonList) {
                        if (nm.getMaNguoiMuon().equals(maNguoiMuon)) {
                            nguoiMuon = nm;
                            break;
                        }
                    }
                    for (Sach s : quyTrinhQuanLy.sachList) {
                        if (s.getMaSach().equals(maSach)) {
                            sach = s;
                            break;
                        }
                    }
                    if (nguoiMuon != null && sach != null) {
                        quyTrinhQuanLy.traSach(nguoiMuon, sach);
                    } else {
                        System.out.println("Không tìm thấy sách hoặc người mượn.");
                    }
                    break;
                case 12:
                    // Thoát
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Chọn chức năng không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 12);

        scanner.close();
    }
    @Override
    public void themSach(Sach sach) {
        ThuThu a=new ThuThu();
        a.themSach(null, sach);

    }

    @Override
    public void xoaSach(String maSach) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void suaSach(String maSach, String tenSach, String tacGia, String nhaXuatBan) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void timKiemSach(String tuKhoa) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void thongKeSach() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void themTheThuVien(TheThuVien theThuVien) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void suaTheThuVien(String maThe, String loaiThe) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void xoaTheThuVien(String maThe) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void themNguoiMuon(NguoiMuon nguoiMuon) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void xoaNguoiMuon(String maNguoiMuon) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void muonSach(NguoiMuon nguoiMuon, Sach sach) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void traSach(NguoiMuon nguoiMuon, Sach sach) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
