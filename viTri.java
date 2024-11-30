import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class viTri {
    private String id;
    private String Khuvuc;
    private String Ke;
    private String Hang;

    public viTri() {
    }

    public viTri(String id, String khuvuc, String ke, String hang) {
        this.id = id;
        this.Khuvuc = khuvuc;
        this.Ke = ke;
        this.Hang = hang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.matches("\\d{3}")) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Ma phai la chuoi 3 chu so.");
        }
    }

    public String getKhuvuc() {
        return Khuvuc;
    }
    
    public void setKhuvuc(String khuvuc) {
        if (khuvuc == null || khuvuc.trim().isEmpty()) {
            throw new IllegalArgumentException("Khu vuc khong duoc de trong.");
        }
        if (!khuvuc.matches("Khu vuc\\s[A-Z]")) {
            throw new IllegalArgumentException("Khu vuc phai co dinh dang 'Khu vuc X' voi X la chu in hoa.");
        }        
        this.Khuvuc = khuvuc.trim();
    }
    
    public String getKe() {
        return Ke;
    }
    
    public void setKe(String ke) {
        if (ke == null || ke.trim().isEmpty()) {
            throw new IllegalArgumentException("Ke khong duoc de trong.");
        }
        if (!ke.matches("Ke\\s[0-9]+")) {
            throw new IllegalArgumentException("Ke phai co dinh dang 'Ke X' voi X la so.");
        }
        this.Ke = ke.trim();
    }
    
    public String getHang() {
        return Hang;
    }
    
    public void setHang(String hang) {
        if (hang == null || hang.trim().isEmpty()) {
            throw new IllegalArgumentException("Hang khong duoc de trong.");
        }
        if (!hang.matches("Hang\\s[0-9]+")) {
            throw new IllegalArgumentException("Hang phai co dinh dang 'Hang X' voi X la so.");
        }
        this.Hang = hang.trim();
    }
    
    public static viTri[] nhapDanhSachViTri(viTri[] dsViTri) {
        Scanner sc = new Scanner(System.in);
        int soLuong = 0;
    
        while (true) {
            System.out.print("Nhap so luong vi tri muon them: ");
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
            System.out.println("Nhap thong tin vi tri thu " + (i + 1) + ":");
            try {
                viTri vt = new viTri();
                vt.inputViTri(dsViTri); 
                dsViTri = viTri.addElementViTri(dsViTri, vt); 
            } catch (Exception e) {
                System.out.println("Co loi khi nhap thong tin vi tri. Vui long thu lai!");
                i--; 
            }
        }
    
        System.out.println("Nhap du lieu vi tri thanh cong!");
        return dsViTri;
    }
    

    public void inputViTri(viTri[] dsViTri) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma: ");
        while (true) {
            try {
                String id = sc.nextLine();
                setId(id); 

                //Kiểm tra trùng lập
                boolean isDuplicate = false;
                for (viTri vt : dsViTri) {
                    if (vt != null && vt.getId().equals(id)) {
                        System.out.println("Ma vua nhap da ton tai. Vui long nhap ma khac.");
                        isDuplicate = true;
                        break;
                    }
                }
    
                if (!isDuplicate) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Nhap lai ma: ");
        }
    
        // Nhập khu vực
        System.out.print("Nhap khu vuc: ");
        while (true) {
            Khuvuc = sc.nextLine();
            if (!Khuvuc.isEmpty()) {
                break;
            } else {
                System.out.println("Khu vuc khong duoc de trong. Vui long nhap lai.");
            }
            System.out.print("Nhap lai khu vuc: ");
        }
    
        // Nhập kệ
        System.out.print("Nhap ke: ");
        while (true) {
            Ke = sc.nextLine();
            if (!Ke.isEmpty()) {
                break;
            } else {
                System.out.println("Ke khong duoc de trong. Vui long nhap lai.");
            }
            System.out.print("Nhap lai ke: ");
        }
    
        // Nhập hàng
        System.out.print("Nhap hang: ");
        while (true) {
            Hang = sc.nextLine();
            if (!Hang.isEmpty()) {
                break;
            } else {
                System.out.println("Hang khong duoc de trong. Vui long nhap lai.");
            }
        }
    } 
    

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-10s %-10s", id, Khuvuc, Ke, Hang);
    }

    // Thêm vị trí vào mảng
    public static viTri[] addElementViTri(viTri[] dsViTri, viTri tmp) {
        if (dsViTri == null) {
            dsViTri = new viTri[0];
        }
        viTri[] newArray = new viTri[dsViTri.length + 1];
        System.arraycopy(dsViTri, 0, newArray, 0, dsViTri.length);
        newArray[dsViTri.length] = tmp;
        return newArray;
    }
    

    // Tìm vị trí theo ID
    public static viTri SearchId(viTri[] dsViTri, String id) {
        for (viTri vt : dsViTri) {
            if (vt.getId().equals(id)) {
                return vt;
            }
        }
        return null;
    }

    // Tìm kiếm tương đối theo khu vực, kệ, hàng
    public static viTri[] findViTriByKhuvuc(viTri[] dsViTri, String khuvuc) {
        viTri[] results = new viTri[dsViTri.length];
        int count = 0;

        for (viTri vt : dsViTri) {
            if (vt.getKhuvuc().toLowerCase().contains(khuvuc.toLowerCase())) {
                results[count++] = vt;
            }
        }

        if (count == 0) {
            return new viTri[0];
        }

        viTri[] finalResults = new viTri[count];
        System.arraycopy(results, 0, finalResults, 0, count);
        return finalResults;
    }

    public static viTri[] findViTriByKe(viTri[] dsViTri, String ke) {
        viTri[] results = new viTri[dsViTri.length];
        int count = 0;
    
        for (viTri vt : dsViTri) {
            if (vt != null && vt.getKe().equalsIgnoreCase(ke)) {
                results[count++] = vt;
            }
        }
    
        if (count == 0) {
            return new viTri[0];
        }
    
        viTri[] finalResults = new viTri[count];
        System.arraycopy(results, 0, finalResults, 0, count);
        return finalResults;
    }

    public static viTri[] findViTriByHang(viTri[] dsViTri, String hang) {
        viTri[] results = new viTri[dsViTri.length];
        int count = 0;
    
        for (viTri vt : dsViTri) {
            if (vt != null && vt.getHang().equalsIgnoreCase(hang)) {
                results[count++] = vt;
            }
        }
    
        if (count == 0) {
            return new viTri[0];
        }
    
        viTri[] finalResults = new viTri[count];
        System.arraycopy(results, 0, finalResults, 0, count);
        return finalResults;
    }

    // Sửa thông tin vị trí
    public static void updateViTri(viTri[] dsViTri, String id, viTri newInfo) {
        for (int i = 0; i < dsViTri.length; i++) {
            if (dsViTri[i].getId().equals(id)) {
                dsViTri[i].setKhuvuc(newInfo.getKhuvuc());
                dsViTri[i].setKe(newInfo.getKe());
                dsViTri[i].setHang(newInfo.getHang());
                return;
            }
        }
    }

    // Xóa vị trí
    public static viTri[] removeViTri(viTri[] dsViTri, String id) {
        int index = -1;
        for (int i = 0; i < dsViTri.length; i++) {
            if (dsViTri[i].getId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Khong tim thay vi tri voi ma: " + id);
            return dsViTri;
        }

        viTri[] newArray = new viTri[dsViTri.length - 1];
        System.arraycopy(dsViTri, 0, newArray, 0, index);
        System.arraycopy(dsViTri, index + 1, newArray, index, dsViTri.length - index - 1);
        return newArray;
    }

    // Đọc và ghi dữ liệu vị trí
    public static viTri[] DocGhiDuLieuViTri(boolean write, viTri[] dsViTri) {
        String filePath = "./data/ViTri.txt";
    
        if (write) {
            // Ghi dữ liệu vào file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, false))) {
                for (viTri vt : dsViTri) {
                    if (vt != null) {
                        bw.write(vt.getId() + ";" + vt.getKhuvuc() + ";" + vt.getKe() + ";" + vt.getHang());
                        bw.newLine();
                    }
                }
                System.out.println("Ghi du lieu vi tri thanh cong!");
            } catch (IOException e) {
                System.out.println("Loi khi ghi du lieu: " + e.getMessage());
            }
        } else {
            // Đọc dữ liệu từ file
            viTri[] tempViTri = new viTri[1000];
            int index = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length == 4) {
                        try {
                            String id = parts[0].trim();
                            String khuvuc = parts[1].trim();
                            String ke = parts[2].trim();
                            String hang = parts[3].trim();
                            viTri vt = new viTri();
                            vt.setId(id);
                            vt.setKhuvuc(khuvuc);
                            vt.setKe(ke);
                            vt.setHang(hang);
    
                            tempViTri[index++] = vt;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Loi khi doc vi tri: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Dong du lieu khong dung dinh dang: " + line);
                    }
                }
                dsViTri = new viTri[index];
                System.arraycopy(tempViTri, 0, dsViTri, 0, index);
                System.out.println("Doc du lieu vi tri thanh cong!");
            } catch (FileNotFoundException e) {
                System.out.println("Khong tim thay file: " + filePath);
            } catch (IOException e) {
                System.out.println("Loi khi doc du lieu: " + e.getMessage());
            }
        }
        return dsViTri;
    }    

    //Thống kê (đại đại đi)
    public static Map<String, Integer> thongKeTheoKhoa(viTri[] dsViTri, String khoa) {
    Map<String, Integer> stats = new HashMap<>();

    for (viTri vt : dsViTri) {
        if (vt != null) {
            String key = "";
            switch (khoa) {
                case "Khuvuc":
                    key = vt.getKhuvuc();
                    break;
                case "Ke":
                    key = vt.getKe();
                    break;
                case "Hang":
                    key = vt.getHang();
                    break;
                default:
                    throw new IllegalArgumentException("Khoa khong hop le: " + khoa);
            }

            stats.put(key, stats.getOrDefault(key, 0) + 1);
        }
    }

    return stats;
}

    public void hienThiThongTin() {
        System.out.println(this.toString());
    }
}
