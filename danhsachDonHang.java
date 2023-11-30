package sach;

import java.io.BufferedReader;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;

public class danhsachDonHang implements DanhSach {
    private static Scanner sc = new Scanner(System.in);
    private static int soluong = 0;
    private static DonHang danhsachDonHang[];

    // private static String[] danhSachIdKhachHang;

    public danhsachDonHang() {
        // Constructor mặc định
    }

    public static int getSoLuong() {
        return soluong;
    }

    public static void setSoLuong(int sl) {
        soluong = sl;
    }

    // *PHAN DOC - GHI FILE *//
    public void docfile(String filename) {
        try {
            FileReader readfile = new FileReader(filename);
            BufferedReader br = new BufferedReader(readfile);
            String line;
            int i;

            while ((line = br.readLine()) != null) {
                String text[] = line.split("#");

                if (danhsachDonHang == null) {
                    danhsachDonHang = new DonHang[1];
                    i = 0;
                } else {
                    i = soluong;
                    danhsachDonHang = Arrays.copyOf(danhsachDonHang, danhsachDonHang.length + 1);
                }

                // Kiểm tra định dạng và các điều kiện khác
                if (text.length == 8 && !text[1].matches(".\\d.*") && text[6].matches("\\d+\\d*\\.?\\,?")
                        && text[7].matches("\\d+")) {
                    if (danhsachDonHang[i] == null)
                        danhsachDonHang[i] = new DonHang();

                    // Chuyển đổi ngày từ chuỗi sang đối tượng Date
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date ngayDat = dateFormat.parse(text[2]);
                    Date ngayGiao = dateFormat.parse(text[3]);

                    // Cập nhật thông tin đơn hàng
                    danhsachDonHang[i].capNhatDonHang(text[0], Integer.parseInt(text[1]), ngayDat, ngayGiao, text[4]);
                    i++;
                    soluong++;
                } else {
                    danhsachDonHang = Arrays.copyOf(danhsachDonHang, danhsachDonHang.length - 1);
                }
            }

            br.close();
            readfile.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void ghifile(String filename) {
        try {
            FileWriter writefile = new FileWriter(filename);

            int i = 0;
            if (danhsachDonHang == null) {
                System.out.println("Danh sach rong");
                writefile.close();
                return;
            }

            while (i < danhsachDonHang.length && danhsachDonHang[i] != null) {
                // Ghi thông tin đơn hàng vào file
                writefile.write(danhsachDonHang[i].xuat() + "\n");
                i++;
            }

            writefile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // *PHAN DOC - GHI FILE *//
    // Nhập thông tin cho danh sách đơn hàng
    public static  void nhapdanhsach() {
        System.out.print("Nhap so luong don hang: ");
        soluong = Integer.parseInt(sc.nextLine());
        danhsachDonHang = new DonHang[soluong];

        for (int i = 0; i < soluong; i++) {
            danhsachDonHang[i] = new DonHang();
            System.out.println("----Nhap thong tin cho don hang thu [" + (i + 1) + "]----");

            // Input and check for duplicate order ID
            String newMaDonHang;
            do {
                System.out.print("Nhap ID don hang: ");
                newMaDonHang = sc.nextLine();
            } while (hasDuplicateOrderId(newMaDonHang, i));

            danhsachDonHang[i].setMaDonHang(newMaDonHang);
            danhsachDonHang[i].nhap();
        }
    }

    // Check for duplicate order ID
    public static boolean hasDuplicateOrderId(String id, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (danhsachDonHang[i] != null && danhsachDonHang[i].getMaDonHang() != null &&
                    danhsachDonHang[i].getMaDonHang().equals(id)) {
                System.out.println("ID don hang da ton tai. Vui long nhap lai.");
                return true; // Found a duplicate
            }
        }
        return false; // No duplicate found
    }

    // Hiển thị thông tin cho danh sách đơn hàng
    public static  void xuatdanhsach() {
        if (danhsachDonHang.length == 0) {
            System.out.println("Khong co don hang nao.");
            return;
        }
        System.out.println("--------Thong tin don hang--------");
        for (DonHang donHang : danhsachDonHang) {
            if (donHang != null && !donHang.isDeleted()) {
                System.out.println(donHang.xuat());
            }
        }
    }

    // Tìm kiếm thông tin đơn hàng
    public static int Timkiem(String orderId) {
        for (int i = 0; i < danhsachDonHang.length; i++) {
            if (danhsachDonHang[i].getMaDonHang() != null
                    && danhsachDonHang[i].getMaDonHang().equals(orderId)) {
                return i;
            }
        }
        return -1;
    }

    public static void TimkiemDonHang() {
        System.out.println("----Tim kiem don hang----");
        while (true) {
            System.out.print("Nhap ID don hang can tim: ");
            String maSoDonHang = sc.nextLine();
            int i = Timkiem(maSoDonHang);

            if (i == -1 || danhsachDonHang[i].isDeleted()) {
                System.out.println("Khong tim thay");
                System.out.println("1.Tiep tuc tim kiem");
                System.out.println("2.Thoat tim kiem");
                int luaChon = Integer.parseInt(sc.nextLine());

                if (luaChon == 2) {
                    return;
                }
            } else {
                System.out.println(danhsachDonHang[i].xuat());
                System.out.println("1.Tiep tuc tim kiem");
                System.out.println("2.Thoat tim kiem");
                int luaChon = Integer.parseInt(sc.nextLine());

                if (luaChon == 2) {
                    return;
                }
            }
        }
    }

    // Xóa thông tin đơn hàng
    public static boolean Xoa(String maSoDonHang) {
        int i = Timkiem(maSoDonHang);
        if (i == -1) {
            System.out.println("Khong tim thay don hang.");
            return false;
        } else {
            danhsachDonHang[i].setTrangThaiDonHang(-1); // Set trangThaiDonHang to -1 to indicate deletion
            System.out.println("Da xoa don hang.");
            return true;
        }
    }

    public static void XoaDonHang() {
        if (soluong == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("----Xoa don hang----");
        int soLuongCanXoa = -1;
        while (soLuongCanXoa == -1) {
            System.out.print("Nhap so luong don hang can xoa (Khong vuot qua " + danhsachDonHang.length + "): ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                soLuongCanXoa = Integer.parseInt(sl);
                if (soLuongCanXoa == 0) {
                    System.out.println("Khong xoa don hang");
                    return;
                }
                if (soLuongCanXoa > danhsachDonHang.length) {
                    System.out.println("So luong can xoa vuot qua so luong don hang hien co.");
                    return;
                }
                while (soLuongCanXoa != 0) {
                    System.out.print("Nhap ID don hang can xoa: ");
                    String maSoDonHang = sc.nextLine();
                    if (!Xoa(maSoDonHang)) {
                        System.out.println("Xoa don hang khong thanh cong. Khong tim thay don hang.");
                    }
                    soLuongCanXoa--;
                }
            } else {
                soLuongCanXoa = -1;
            }
        }
    }

    // Khôi phục thông tin đã xóa
    public static DonHang Khoiphuc(String maSoDonHang_cankhoiphuc) {
        for (int i = 0; i < danhsachDonHang.length; i++) {
            if (danhsachDonHang[i].getMaDonHang() != null &&
                    danhsachDonHang[i].getMaDonHang().equals(maSoDonHang_cankhoiphuc) &&
                    danhsachDonHang[i].getTrangThaiDonHang() == -1) { // Corrected condition
                danhsachDonHang[i].setTrangThaiDonHang(1);
                return danhsachDonHang[i];
            }
        }
        return null;
    }

    public static void KhoiphucDonHang() {
        if (soluong == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("----Khoi phuc don hang----");
        int soLuongCanKhoiPhuc = -1;
        while (soLuongCanKhoiPhuc == -1) {
            System.out.print("Nhap so luong don hang can khoi phuc (Khong vuot qua " + danhsachDonHang.length + "): ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                soLuongCanKhoiPhuc = Integer.parseInt(sl);
                if (soLuongCanKhoiPhuc > danhsachDonHang.length)
                    return;
                for (int i = 0; i < soLuongCanKhoiPhuc; i++) {
                    System.out.print("Nhap ID don hang can khoi phuc: ");
                    String maSoDonHang_canKhoiPhuc = sc.nextLine();
                    Khoiphuc(maSoDonHang_canKhoiPhuc);
                }
            } else
                soLuongCanKhoiPhuc = -1;
        }
    }

    // Chỉnh sửa thông tin
    public static DonHang Sua(String maSoDonHang_canSua) {
        int i = Timkiem(maSoDonHang_canSua);
        if (i == -1) {
            System.out.println("Khong tim thay");
            System.out.println("1. Tiep tuc tim kiem");
            System.out.println("2. Thoat tim kiem");
            int chon = Integer.parseInt(sc.nextLine());
            if (chon == 1) {
                System.out.print("Nhap ID don hang can sua: ");
                return Sua(sc.nextLine());
            } else {
                System.out.println("Thoat tim kiem");
                return null;
            }
        }

        // If a match is found, print the information and exit
        System.out.println("Thong tin cua don hang \"" + danhsachDonHang[i].getMaDonHang() + "\":");
        System.out.println(danhsachDonHang[i].xuat());

        int soLuongCanSua = -1;
        while (soLuongCanSua == -1) {
            System.out.print("Ban muon sua bao nhieu thong tin cua don hang (Khong vuot qua 8): ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                soLuongCanSua = Integer.parseInt(sl);
                if (soLuongCanSua > 8)
                    return null;
                while (soLuongCanSua != 0) {
                    System.out.println("Sua thong tin cua don hang \"" + danhsachDonHang[i].getMaDonHang() + "\"");
                    danhsachDonHang[i].suaThongTin();
                    soLuongCanSua--;
                }
            } else
                soLuongCanSua = -1;
        }
        return danhsachDonHang[i];
    }

    public static void SuaDonHang() {
        if (soluong == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("----Sua don hang----");
        int soLuongCanSua = -1;
        while (soLuongCanSua == -1) {
            System.out.print("Nhap so luong don hang can sua (Khong vuot qua " + danhsachDonHang.length
                    + " - hoac nhap 0 de khong sua): ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                soLuongCanSua = Integer.parseInt(sl);
                if (soLuongCanSua == 0) {
                    System.out.println("Khong sua don hang");
                    return;
                }
                if (soLuongCanSua > danhsachDonHang.length) {
                    System.out.println("So luong can sua lon hon so luong don hang. Khong sua don hang");
                    return;
                }

                while (soLuongCanSua != 0) {
                    System.out.print("Nhap ID don hang can sua: ");
                    String maSoDonHang_canSua = sc.nextLine();
                    Sua(maSoDonHang_canSua);
                    soLuongCanSua--;
                }
            } else
                soLuongCanSua = -1;
        }
    }

    public static void themDonHang() {
        System.out.println("----Them don hang moi----");

        int soLuongThem = -1;
        while (soLuongThem == -1) {
            System.out.print("Nhap so luong don hang muon them: ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                soLuongThem = Integer.parseInt(sl);
                if (soLuongThem == 0) {
                    System.out.println("Khong them don hang");
                    return;
                }
                while (soLuongThem != 0) {
                    DonHang newDonHang = new DonHang();

                    // Input and check for duplicate order ID
                    String newMaDonHang;
                    do {
                        System.out.print("Nhap ID don hang: ");
                        newMaDonHang = sc.nextLine();
                    } while (hasDuplicateOrderId(newMaDonHang, soluong));

                    newDonHang.setMaDonHang(newMaDonHang);
                    newDonHang.nhap();

                    // Expand the array to accommodate the new order
                    danhsachDonHang = Arrays.copyOf(danhsachDonHang, danhsachDonHang.length + 1);
                    danhsachDonHang[soluong] = newDonHang;

                    soluong++; // Increment the total order count
                    soLuongThem--;
                }
            } else {
                soLuongThem = -1;
            }
        }
    }

    public static boolean trungLapMaDonHang(String maDonHang) {
        for (int i = 0; i < soluong; i++) {
            if (danhsachDonHang[i] != null && danhsachDonHang[i].getMaDonHang() != null &&
                    danhsachDonHang[i].getMaDonHang().equals(maDonHang)) {
                return true; // Duplicate order ID found
            }
        }
        return false; // No duplicate order ID found
    }

    @Override
    public void SapxepTheoMa() {
        // TODO Auto-generated method stub

    }

    @Override
    public void SapxepTheoTen() {
        // TODO Auto-generated method stub

    }

    @Override
    public void docFile(String filename) {
        // TODO Auto-generated method stub

    }

    @Override
    public void ghiFile(String filename) {
        // TODO Auto-generated method stub

    }

    public static void suaDonHang() {
    }

    public static void xuatDanhSach() {
    }

}