public class ThuVien {
    private TaiLieu[] taiLieus; // Mảng chứa các tài liệu
    private int soLuongTaiLieu; // Biến đếm số lượng tài liệu trong thư viện

    public ThuVien(int soLuong) {
        taiLieus = new TaiLieu[soLuong]; // Khởi tạo mảng tài liệu với số lượng tối đa
        soLuongTaiLieu = 0;
    }

    // Thêm tài liệu vào thư viện
    public void themTaiLieu(TaiLieu taiLieu) {
        if (soLuongTaiLieu < taiLieus.length) {
            taiLieus[soLuongTaiLieu++] = taiLieu;
            System.out.println("Đã thêm tài liệu: " + taiLieu.getTenTaiLieu());
        } else {
            System.out.println("Thư viện đã đầy, không thể thêm tài liệu.");
        }
    }

    // Xóa tài liệu theo mã tài liệu
    public void xoaTaiLieu(String maTaiLieu) {
        for (int i = 0; i < soLuongTaiLieu; i++) {
            if (taiLieus[i].getMaTaiLieu().equals(maTaiLieu)) {
                // Dịch chuyển các tài liệu còn lại lên một vị trí
                for (int j = i; j < soLuongTaiLieu - 1; j++) {
                    taiLieus[j] = taiLieus[j + 1];
                }
                taiLieus[--soLuongTaiLieu] = null; // Giảm số lượng tài liệu và đặt phần tử cuối là null
                System.out.println("Đã xóa tài liệu có mã: " + maTaiLieu);
                return;
            }
        }
        System.out.println("Không tìm thấy tài liệu có mã: " + maTaiLieu);
    }

    // Tìm tài liệu theo mã tài liệu
    public TaiLieu timTaiLieu(String maTaiLieu) {
        for (int i = 0; i < soLuongTaiLieu; i++) {
            if (taiLieus[i].getMaTaiLieu().equals(maTaiLieu)) {
                return taiLieus[i]; // Trả về tài liệu tìm thấy
            }
        }
        System.out.println("Không tìm thấy tài liệu có mã: " + maTaiLieu);
        return null;
    }

    // Sửa thông tin tài liệu
    public void suaTaiLieu(String maTaiLieu, TaiLieu taiLieuMoi) {
        for (int i = 0; i < soLuongTaiLieu; i++) {
            if (taiLieus[i].getMaTaiLieu().equals(maTaiLieu)) {
                taiLieus[i] = taiLieuMoi;
                System.out.println("Đã sửa tài liệu có mã: " + maTaiLieu);
                return;
            }
        }
        System.out.println("Không tìm thấy tài liệu có mã: " + maTaiLieu);
    }

    // Phương thức ghi dữ liệu vào file (dạng đơn giản)
    public void ghiDuLieu() {
        // Ví dụ ghi vào file (có thể sử dụng BufferedWriter)
        System.out.println("Ghi dữ liệu vào file...");
    }

    // Phương thức đọc dữ liệu từ file
    public void docDuLieu() {
        // Ví dụ đọc từ file
        System.out.println("Đọc dữ liệu từ file...");
    }
}
