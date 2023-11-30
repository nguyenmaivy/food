package sach;

import java.util.Arrays;
import java.util.Scanner;

public class danhsachPhuongThucThanhToan implements DanhSach {
    private static Scanner sc = new Scanner(System.in);
    private static int soLuong = 0;
    private static PhuongThucThanhToan danhSachPhuongThucThanhToan[];

    public danhsachPhuongThucThanhToan() {
        // Constructor mặc định
    }

    public static int getSoLuong() {
        return soLuong;
    }

    public static void setSoLuong(int sl) {
        soLuong = sl;
    }

    // Nhập thông tin cho danh sách phương thức thanh toán

    public void nhapPhuongThucThanhToan(Scanner scanner) {
        int soLuongPhuongThucThanhToan = -1;

        while (soLuongPhuongThucThanhToan == -1) {
            System.out.print("Nhap so luong phuong thuc thanh toan muon them: ");
            String slPhuongThuc = scanner.nextLine();

            if (slPhuongThuc.matches("\\d+")) {
                soLuongPhuongThucThanhToan = Integer.parseInt(slPhuongThuc);
                if (soLuongPhuongThucThanhToan < 0) {
                    System.out.println("So luong phuong thuc thanh toan khong hop le. Vui long nhap lai.");
                    soLuongPhuongThucThanhToan = -1;
                }
            } else {
                System.out.println("So luong phuong thuc thanh toan khong hop le. Vui long nhap lai.");
            }
        }

        danhSachPhuongThucThanhToan = new PhuongThucThanhToan[soLuongPhuongThucThanhToan];

        for (int j = 0; j < soLuongPhuongThucThanhToan; j++) {
            PhuongThucThanhToan phuongThuc = new PhuongThucThanhToan();
            System.out.println("----Nhap thong tin cho phuong thuc thanh toan thu [" + (j + 1) + "]----");
            phuongThuc.nhapThongTinPhuongThuc();
            danhSachPhuongThucThanhToan[j] = phuongThuc;
        }
    }

    // Hiển thị thông tin cho danh sách phương thức thanh toán
    public void xuatDanhSachPhuongThuc() {
        if (danhSachPhuongThucThanhToan.length == 0) {
            System.out.println("Khong co phuong thuc thanh toan nao.");
            return;
        }

        for (PhuongThucThanhToan phuongThucThanhToan : danhSachPhuongThucThanhToan) {
            if (phuongThucThanhToan != null) {
                System.out.println(phuongThucThanhToan.xuat());
            }
        }
    }

    public static PhuongThucThanhToan themPhuongThucThanhToan() {
        int i;
        if (danhSachPhuongThucThanhToan == null) {
            danhSachPhuongThucThanhToan = new PhuongThucThanhToan[1];
            i = 0;
        } else {
            i = soLuong;
            danhSachPhuongThucThanhToan = Arrays.copyOf(danhSachPhuongThucThanhToan,
                    danhSachPhuongThucThanhToan.length + 1);
        }
        danhSachPhuongThucThanhToan[i] = new PhuongThucThanhToan();
        System.out.println("Nhap thong tin phuong thuc thanh toan [" + (i + 1) + "]");
        danhSachPhuongThucThanhToan[i].nhapThongTinPhuongThuc();
        soLuong++;
        return danhSachPhuongThucThanhToan[i];
    }

    public static void themPhuongThucThanhToanChoDonHang(DonHang donHang) {
        int soLuongCanThem = -1;
        while (soLuongCanThem == -1) {
            System.out.print("Nhap so luong phuong thuc thanh toan muon them cho don hang: ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                soLuongCanThem = Integer.parseInt(sl);
                if (soLuongCanThem == 0) {
                    if (soLuong == 0) {
                        System.out.println("Danh sach phuong thuc thanh toan rong");
                    } else {
                        System.out.println("Khong them phuong thuc thanh toan");
                    }
                    return;
                }
                while (soLuongCanThem != 0) {
                    donHang.getPhuongThucThanhToan();
                    soLuongCanThem--;
                }
            } else {
                soLuongCanThem = -1;
            }
        }
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

    @Override
    public void nhapdanhsach() {
        // TODO Auto-generated method stub

    }

    @Override
    public void xuatdanhsach() {
        // TODO Auto-generated method stub

    }

}