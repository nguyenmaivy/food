package sach;
import java.util.*;

public class danhsachChiTietNK {
    public static Scanner sc = new Scanner(System.in);
    private static int soluong = 0;
    private static chiTietNK dSChiTietNK[];

    public danhsachChiTietNK(){
    }

    public static int getSoluong() {
        return soluong;
    }
    public static void setSoluong(int sl) {
        soluong = sl;
    }

    //nhập thông tin
	public static void nhapdanhsach() {
		while(soluong==0) {
			System.out.print("Nhap so luong chi tiet NK: ");
			soluong=Integer.parseInt(sc.nextLine());
		}
		dSChiTietNK=new chiTietNK[soluong];
		for(int i=0;i<dSChiTietNK.length;i++) {
			dSChiTietNK[i]=new chiTietNK();
			System.out.println("Nhap thong tin chi tiet NK ");
			dSChiTietNK[i].Nhap();
		}
	}

    //xuất thông tin
    public static void xuatdanhsach() {
		if(dSChiTietNK.length==0) {
			System.out.println("Kho sach rong");
			return;
		}
        for (chiTietNK chitietNK : dSChiTietNK) {
            if (chitietNK != null && !chitietNK.isDeleted()) {
                System.out.println(chitietNK.Xuat());
            }
        }
    }

    // tìm kiếm thông tin bị trùng lặp
    public static chiTietNK Trunglap(String masach) {
        if (dSChiTietNK == null || dSChiTietNK[0] == null)
            return null;
        for (int i = 0; i < dSChiTietNK.length; i++)
            if (dSChiTietNK[i] != null)
                if (dSChiTietNK[i].getmasach() != null && dSChiTietNK[i].getmasach().equals(masach))
                    return dSChiTietNK[i];
        return null;
    }

    // thêm thông tin đối tượng
    public static chiTietNK Them() {
        int i;
        if (dSChiTietNK == null) {
            dSChiTietNK = new chiTietNK[1];
            i = 0;
        } else {
            dSChiTietNK = Arrays.copyOf(dSChiTietNK, dSChiTietNK.length + 1);
            i = soluong;
        }
        dSChiTietNK[i] = new chiTietNK();
        System.out.println("Nhap thong tin chi tiet NK");
        dSChiTietNK[i].Nhap();
        soluong++;
        return dSChiTietNK[i];
    }

    public static void ThemchiTietNK() {
        int so_luong_can_them = -1;
        while (so_luong_can_them == -1) {
            System.out.print("So luong chi tiet NK can them: ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                so_luong_can_them = Integer.parseInt(sl);
                if (so_luong_can_them == 0) {
                    if (soluong == 0)
                        System.out.println("Danh sach rong");
                    else
                        System.out.println("Khong them sach");
                    return;
                }
                while (so_luong_can_them != 0) {
                    Them();
                    so_luong_can_them--;
                }
            } else
                so_luong_can_them = -1;
        }
    }
    
    // tìm kiếm thông tin
    public static int Timkiem(String masach) {
        for (int i = 0; i < dSChiTietNK.length; i++) {
            if (dSChiTietNK[i].trangthai == 1 && dSChiTietNK[i].getmasach().equals(masach))
                return i;
        }
        return -1;
    }

    public static void TimkiemChiTietNK() {
        if (soluong == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.print("Nhap masach sach can tim: ");
        String masach = sc.nextLine();
        int i = Timkiem(masach);
        while (i == -1) {
            System.out.println("Khong tim thay");
            System.out.println("1.Tiep tuc tim kiem");
            System.out.println("2.Thoat tim kiem");
            int luachon = Integer.parseInt(sc.nextLine());
            if (luachon == 1) {
                if (luachon == 1)
                    TimkiemChiTietNK();
            } else
                return;
        }
        System.out.println(dSChiTietNK[i].Xuat());
    }
    
    // xóa thông tin(xóa giả => ẩn thông tin)
    public static void Xoa() {
        System.out.print("Nhap masach sach can xoa: ");
        String masach = sc.nextLine();
        int i = Timkiem(masach);
        if (i == -1) {
            System.out.println("Khong tim thay");
            System.out.println("1.Tiep tuc tim kiem");
            System.out.println("2.Thoat tim kiem");
            int luachon = Integer.parseInt(sc.nextLine());
            if (luachon == 1)
                Xoa();
        } else {
            dSChiTietNK[i].trangthai = 0;
            return;
        }
    }

    public static void XoaChiTietNK() {
        if (soluong == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        int so_luong_can_xoa = -1;
        while (so_luong_can_xoa == -1) {
            System.out.print("Nhap so luong masach can xoa (Khong vuot qua " + dSChiTietNK.length + "): ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                so_luong_can_xoa = Integer.parseInt(sl);
                if (so_luong_can_xoa == 0) {
                    System.out.println("Khong xoa ChiTietNK");
                    return;
                }
                if (so_luong_can_xoa > dSChiTietNK.length)
                    return;
                while (so_luong_can_xoa != 0) {
                    Xoa();
                    so_luong_can_xoa--;
                }
            } else
                so_luong_can_xoa = -1;
        }
    }
    
    // khôi phục thông tin đã xóa
    public static chiTietNK Khoiphuc(String masachsach_cankhoiphuc) {
        int i;
        for (i = 0; i < dSChiTietNK.length; i++)
            if (dSChiTietNK[i].getmasach() != null && dSChiTietNK[i].getmasach().equals(masachsach_cankhoiphuc) && dSChiTietNK[i].trangthai == 0) {
                dSChiTietNK[i].trangthai = 1;
                return dSChiTietNK[i];
            }
        return null;
    }

    public static void KhoiphucChiTietNK() {
        if (soluong == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        int soluong_masachsach_cankhoiphuc = -1;
        while (soluong_masachsach_cankhoiphuc == -1) {
            System.out.print("Nhap so luong masach sach can khoi phuc thong tin (Khong vuot qua " + dSChiTietNK.length + "): ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                soluong_masachsach_cankhoiphuc = Integer.parseInt(sl);
                if (soluong_masachsach_cankhoiphuc > dSChiTietNK.length)
                    return;
                for (int i = 0; i < soluong_masachsach_cankhoiphuc; i++) {
                    System.out.println("Nhap masach sach can khoi phuc: ");
                    String masachsach_cankhoiphuc = sc.nextLine();
                    Khoiphuc(masachsach_cankhoiphuc);
                }
            } else
                soluong_masachsach_cankhoiphuc = -1;
        }
    }
    
    // sửa thông tin
    public static chiTietNK Sua(String masach) {
        int i = Timkiem(masach);
        if (i == -1) {
            System.out.println("Khong tim thay");
            System.out.println("1.Tiep tuc tim kiem");
            System.out.println("2.Thoat tim kiem");
            int luachon = Integer.parseInt(sc.nextLine());
            if (luachon == 1) {
                System.out.print("Nhap masach can sua thong tin: ");
                return Sua(sc.nextLine());
            } else
                return null;
        }
        int so_luong_thong_tin_can_sua = -1;
        while (so_luong_thong_tin_can_sua == -1) {
            System.out.println("Ban muon sua bao nhieu thong tin (toi da 3): ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                so_luong_thong_tin_can_sua = Integer.parseInt(sl);
                if (so_luong_thong_tin_can_sua > 3)
                    return null;
                while (so_luong_thong_tin_can_sua != 0) {
                    System.out.println("Sua thong tin cua chi tiet NK ");
                    dSChiTietNK[i].suaThongTin();
                    so_luong_thong_tin_can_sua--;
                }
            } else
                so_luong_thong_tin_can_sua = -1;
        }
        return dSChiTietNK[i];
    }

    public static void SuachiTietNK() {
        if (soluong == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        int so_luong_can_sua = -1;
        while (so_luong_can_sua == -1) {
            System.out.print("Nhap so luong masach can sua thong tin (Khong vuot qua " + dSChiTietNK.length + "): ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                so_luong_can_sua = Integer.parseInt(sl);
                if (so_luong_can_sua == 0) {
                    System.out.println("Khong sua");
                    return;
                }
                if (so_luong_can_sua > dSChiTietNK.length)
                    return;
                while (so_luong_can_sua != 0) {
                    System.out.print("Nhap masach sach can sua thong tin: ");
                    String masach = sc.nextLine();
                    Sua(masach);
                    so_luong_can_sua--;
                }
            } else
                so_luong_can_sua = -1;
        }
    }
}
