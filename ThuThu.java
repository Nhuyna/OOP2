import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThuThu extends ConNguoi {
    private String maThuThu; 
    private int SoGioLam;
    private int Luong;

    // Constructor
    public ThuThu(String maThuThu, String ten, int tuoi, String diaChi, int SoGioLam, int Luong) {
        super(ten, tuoi, diaChi);
        this.maThuThu = maThuThu;
        setSoGioLam(SoGioLam);
        setLuong(Luong);
    }

    public ThuThu() {
    }

    // Getter và Setter
    public String getMaThuThu() {
        return maThuThu;
    }

    public void setMaThuThu(String maThuThu) {
        if (maThuThu.matches("\\d{3}")) {
            this.maThuThu = maThuThu;
        } else {
            throw new IllegalArgumentException("Ma thu thu phai la 3 chu so.");
        }
    }

    public void setLuong(int Luong) {
        if (Luong > 0) {
            this.Luong = Luong;
        } else {
            throw new IllegalArgumentException("Luong phai lon hon 0.");
        }
    }

    public void setSoGioLam(int SoGioLam) {
        if (SoGioLam > 0) {
            this.SoGioLam = SoGioLam;
        } else {
            throw new IllegalArgumentException("Số giờ làm phải lớn hơn 0.");
        }
    }

    public int getSoGioLam() {
        return SoGioLam;
    }

    public int getLuong() {
        return Luong;
    }

    public int TinhLuong() {
        return SoGioLam * Luong;
    }

    public static ThuThu[] nhapDanhSachThuThu(ThuThu[] dsThuThu) {
        Scanner sc = new Scanner(System.in);
        int soLuong = 0;

        while (true) {
            System.out.print("Nhap so luong thu thu muon them: ");
            try {
                soLuong = Integer.parseInt(sc.nextLine());
                if (soLuong > 0) {
                    break;
                } else {
                    System.out.println("So luong phai lon hon 0. Vui long nhap lai!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so hop le!");
            }
        }

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhap thong tin thu thu thu " + (i + 1) + ":");
            try {
                ThuThu tt = new ThuThu();
                tt.inputThuThu(); 
                dsThuThu = ThuThu.addElementThuThu(dsThuThu, tt); 
            } catch (Exception e) {
                System.out.println("Co loi khi nhap thong tin thu thu. Vui long thu lai!");
                i--; 
            }
        }

        System.out.println("Nhap du lieu thu thu thanh cong!");
        return dsThuThu;
    }

    public void inputThuThu() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma thu thu: ");
        while (true) {
            try {
                maThuThu = sc.nextLine();
                setMaThuThu(maThuThu); 
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); 
            }
        }

        // Kiểm tra trùng lặp nếu cần
        ThuThu[] dsThuThu = new ThuThu[0];
        dsThuThu = DocGhiDuLieuThuThu(false, dsThuThu);
        for (ThuThu tt : dsThuThu) {
            if (tt != null && tt.getMaThuThu().equals(maThuThu)) {
                System.out.println("Ma thu thu vua nhap da ton tai, vui long nhap ma khac.");
                return;
            }
        }

        System.out.print("Nhap ten thu thu: ");
        ten = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        while (true) {
            try {
                tuoi = Integer.parseInt(sc.nextLine());
                if (tuoi > 18) {
                    setTuoi(tuoi); // Sử dụng setter để kiểm tra tuổi
                    break;
                }
                System.out.println("Tuoi phai lon hon 18. Vui long nhap lai.");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so hop le.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Nhap so gio lam: ");
        while (true) {
            try {
                SoGioLam = Integer.parseInt(sc.nextLine());
                if (SoGioLam > 0)
                    break;
                System.out.println("So gio lam phai lon hon 0. Vui long nhap lai.");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le.");
            }
        }

        System.out.print("Nhap luong: ");
        while (true) {
            try {
                Luong = Integer.parseInt(sc.nextLine());
                if (Luong > 0)
                    break;
                System.out.println("Luong phai lon hon 0. Vui long nhap lai.");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le.");
            }
        }

        System.out.print("Nhap dia chi: ");
        diaChi = sc.nextLine();
    }

public static ThuThu[] DocGhiDuLieuThuThu(boolean write, ThuThu[] dsThuThu) {
    String filePath = "./data/Thuthu.txt";

    if (write) {
        // Ghi dữ liệu vào file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, false))) { 
            for (ThuThu tt : dsThuThu) {
                if (tt != null) {
                    bw.write(tt.getMaThuThu() + ";" + tt.getTen() + ";" + tt.getTuoi() + ";" + tt.getDiaChi() + ";"
                            + tt.getSoGioLam() + ";" + tt.getLuong());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi du lieu: " + e.getMessage());
        }
    } else {
        ThuThu[] tempThuThu = new ThuThu[1000]; 
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    String maThuThu = parts[0];
                    String name = parts[1];
                    int tuoi = Integer.parseInt(parts[2]);
                    String address = parts[3];
                    int soGioLam = Integer.parseInt(parts[4]);
                    int luong = Integer.parseInt(parts[5]);
                    tempThuThu[index++] = new ThuThu(maThuThu, name, tuoi, address, soGioLam, luong);
                }
            }

            dsThuThu = new ThuThu[index];
            System.arraycopy(tempThuThu, 0, dsThuThu, 0, index);

        } catch (FileNotFoundException e) {
            System.out.println("File khong ton tai. Khoi tao danh sach rong.");
            dsThuThu = new ThuThu[0];
        } catch (IOException e) {
            System.out.println("Loi khi doc du lieu: " + e.getMessage());
            dsThuThu = new ThuThu[0];
        }
    }

    return dsThuThu;
}   

    // Tìm kiếm bằng tên
    public static ThuThu findNameThuThu(ThuThu[] DS, String tenThuThu) {
        for (ThuThu x : DS) {
            if (x.getTen().equalsIgnoreCase(tenThuThu)) {
                return x;
            }
        }
        System.out.println("Khong tim thay thu thu.\n");
        return null;
    }

    public static ThuThu[] findNameThuThu_tuongdoi(ThuThu[] DS, String tenThuThu) {
        ThuThu[] y = new ThuThu[DS.length];
        int count = 0;
        for (ThuThu x : DS) {
            if (x.getTen().toLowerCase().contains(tenThuThu.toLowerCase())) {
                y[count] = x;
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Khong tim thay thu thu.\n");
            return new ThuThu[0];
        }
        ThuThu[] result = new ThuThu[count];
        System.arraycopy(y, 0, result, 0, count);
        return result;
    }

    // Sửa
    public static void updateThuThu(ThuThu[] DS, String maThuThu, ThuThu newInfo) {
        for (int i = 0; i < DS.length; i++) {
            if (DS[i].getMaThuThu().equals(maThuThu)) {
                DS[i].setTen(newInfo.getTen());
                DS[i].setTuoi(newInfo.getTuoi());
                DS[i].setDiaChi(newInfo.getDiaChi());
                DS[i].setSoGioLam(newInfo.getSoGioLam());
                DS[i].setLuong(newInfo.getLuong());
                System.out.println("Da cap nhat thong tin thu thu voi ma: " + maThuThu);
                return;
            }
        }
        System.out.println("Khong tim thay thu thu voi ma: " + maThuThu);
    }

    // Xóa
    public static ThuThu[] removeThuThu(ThuThu[] DS, String maThuThu) {
        int index = -1;
        for (int i = 0; i < DS.length; i++) {
            if (DS[i].getMaThuThu().equals(maThuThu)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Khong tim thay thu thu voi ma: " + maThuThu);
            return DS;
        }

        ThuThu[] newArray = new ThuThu[DS.length - 1];
        System.arraycopy(DS, 0, newArray, 0, index);
        System.arraycopy(DS, index + 1, newArray, index, DS.length - index - 1);
        System.out.println("Da xoa thu thu voi ma: " + maThuThu);
        return newArray;
    }

    // Thêm thủ thư vào mảng
    public static ThuThu[] addElementThuThu(ThuThu[] dsThuThu, ThuThu tmp) {
        ThuThu[] newArray = new ThuThu[dsThuThu.length + 1];
        System.arraycopy(dsThuThu, 0, newArray, 0, dsThuThu.length);
        newArray[dsThuThu.length] = tmp;
        return newArray;
    }

    // Tìm thủ thư theo mã
    public static ThuThu SearchId(ThuThu[] dsThuThu, String maThuThu) {
        for (ThuThu tt : dsThuThu) {
            if (tt.getMaThuThu().equals(maThuThu)) {
                return tt;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%10s%15s%10d%20s%10d%10d", maThuThu, ten, tuoi, diaChi, SoGioLam, Luong);
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin(); 
        System.out.println("Ma thu thu: " + maThuThu);
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

    // Thêm thẻ thư viện
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
