package sach;

import java.util.*;

class ChiTietDonHang {
    // private String mahoadon;
    private newSach[] Sach;
    private int so_luong_moi_loai[];
    private int so_luong_loai_sach;
    private double tongtien;
    Scanner sc = new Scanner(System.in);

    public ChiTietDonHang() {

    }

    public ChiTietDonHang(/* String mahoadon, */newSach[] Sach, int so_luong_loai_sach, int so_luong_moi_loai[],
            double tongtien) {
        this.Sach = Sach;
        this.so_luong_loai_sach = so_luong_loai_sach;
        this.so_luong_moi_loai = so_luong_moi_loai;
        // this.mahoadon=mahoadon;
        this.tongtien = tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public double getTongtien() {
        return tongtien;
    }

    /*
     * public void setMahoadon(String mahoadon) {
     * this.mahoadon = mahoadon;
     * }
     * public String getMahoadon() {
     * return mahoadon;
     * }
     */
    public void setSach(newSach[] Sach) {
        this.Sach = Sach;
    }

    public void setSo_luong_loai_sach(int so_luong_loai_sach) {
        this.so_luong_loai_sach = so_luong_loai_sach;
    }

    public void setSo_luong_moi_loai(int[] so_luong_moi_loai) {
        this.so_luong_moi_loai = so_luong_moi_loai;
    }

    public newSach[] getSach() {
        return Sach;
    }

    public int getSo_luong_loai_sach() {
        return so_luong_loai_sach;
    }

    public int[] getSo_luong_moi_loai() {
        return so_luong_moi_loai;
    }

    public void nhap() {
        Boolean exitLoop = false;

        while (true) {
            System.out.print("Nhap so luong loai sach can mua: ");
            String soluong = sc.nextLine();

            if (soluong.matches("\\d+")) {
                so_luong_loai_sach = Integer.parseInt(soluong);
                int i = 0;
                Sach = new newSach[so_luong_loai_sach];
                so_luong_moi_loai = new int[so_luong_loai_sach];

                while (i < so_luong_loai_sach) {
                    System.out.print("Nhap Ma sach: ");
                    String newmasach = sc.nextLine();
                    int location = danhsachSach.Timkiem(newmasach);

                    if (location != -1) {
                        Sach new_masach = danhsachSach.getSach(location);
                        Sach[i] = new newSach(new_masach.getTenSach(), new_masach.getMaSach(), new_masach.getTacGia(),
                                new_masach.getNXB(), new_masach.getTheLoai(), new_masach.getGiaban(),
                                new_masach.getSoluong(), 1);
                        so_luong_moi_loai[i] = 0;

                        while (so_luong_moi_loai[i] <= 0 || so_luong_moi_loai[i] > new_masach.getSoluong()) {
                            System.out.print("Nhap so luong sach \"" + Sach[i].getTenSach()
                                    + "\" can mua (khong vuot qua so luong co san " + new_masach.getSoluong() + "): ");
                            String sl = sc.nextLine();

                            if (sl.matches("\\d+")) {
                                so_luong_moi_loai[i] = Integer.parseInt(sl);
                            } else {
                                so_luong_moi_loai[i] = 0;
                            }
                        }
                        i++;
                    } else {
                        System.out.println("Khong tim thay sach.");
                        System.out.println("1. Xem lai sach da nhap");
                        System.out.println("2. Nhap lai Ma sach");
                        System.out.print("Nhap lua chon: ");
                        int luaChon = Integer.parseInt(sc.nextLine());

                        switch (luaChon) {
                            case 1:
                                // Xem lai sach da nhap
                                danhsachSach.xuatdanhsach();
                                break;
                            case 2:
                                // Nhập lại Ma sach
                                break;
                            default:
                                System.out.println("Lua chon khong hop le.");
                                break;
                        }
                    }
                }
                break;
            }
        }
        // this.trangthai=1;
    }

    public double tonghoadon() {
        double tong = 0.0;
        for (int i = 0; i < Sach.length; i++) {
            tong = tong + so_luong_moi_loai[i] * Sach[i].getGiaban();
        }
        return tong;
    }

    public String xuat() {
        StringBuilder result = new StringBuilder();

        if (this.Sach != null) {
            for (int i = 0; i < Sach.length; i++) {
                result.append(String.format("Ten sach: %s gia: %.2f So luong:x%d ", Sach[i].getTenSach(),
                        Sach[i].getGiaban(), so_luong_moi_loai[i]));
            }
        }

        result.append(String.format("|Thanh tien: %.2f", tonghoadon()));
        return result.toString();
    }
}
