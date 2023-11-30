package sach;

import java.util.*;
import java.io.*;

public class danhsachThuNgan implements DanhSach {
    public static Scanner sc = new Scanner(System.in);
    private static int soluong = 0;
    private static newThuNgan ThuNgan[];

    public danhsachThuNgan() {
    }

    public static int getSoluong() {
        return soluong;
    }

    public static void setSoluong(int sl) {
        soluong = sl;
    }

    // nhập thông tin
    public void nhapdanhsach() {
        while (soluong == 0) {

            System.out.print("Nhap so luong Thu Ngan : ");
            String sl = sc.nextLine();

            if (sl.matches("\\d+"))
                soluong = Integer.parseInt(sl);
            else
                soluong = 0;

        }

        ThuNgan = new newThuNgan[soluong];

        for (int i = 0; i < ThuNgan.length; i++) {
            ThuNgan[i] = new newThuNgan();
            System.out.println("Nhap thong tin Thu Ngan:");
            ThuNgan[i].nhap();
        }

    }

    public void docfile(String filename) {
        try {

            FileReader readfile = new FileReader(filename);
            BufferedReader br = new BufferedReader(readfile);
            String line;
            int i;

            while ((line = br.readLine()) != null) {

                String text[] = line.split("#");

                if (ThuNgan == null)
                    ThuNgan = new newThuNgan[1];
                else
                    ThuNgan = Arrays.copyOf(ThuNgan, ThuNgan.length + 1);

                i = ThuNgan.length - 1;

                if (text.length == 7 && text[1].matches("^TN.*") && Trunglap(text[1]) == null
                        && !text[4].matches(".*\\d.*") && text[5].matches("\\d+")) {
                    if (ThuNgan[i] == null)
                        ThuNgan[i] = new newThuNgan(i, text[0], text[1], text[2], Double.parseDouble(text[3]), 1,
                                text[4],
                                Integer.parseInt(text[5]), text[6]);
                    i++;

                } else
                    ThuNgan = Arrays.copyOf(ThuNgan, ThuNgan.length - 1);

            }

            soluong = ThuNgan.length;
            br.close();
            readfile.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public void ghifile(String filename) {
        try {

            FileWriter writefile = new FileWriter(filename);
            FileWriter bin = new FileWriter("D:\\java\\java_project\\food\\sach\\ThuNgan_recyclebin.txt");

            int i = 0;

            if (ThuNgan == null) {
                System.out.println("Danh sach rong");
                writefile.close();
                bin.close();
                return;
            }

            while (i < ThuNgan.length && ThuNgan[i] != null) {

                if (ThuNgan[i].trangthai == 1)
                    writefile.write(ThuNgan[i].getDSBH() + "#" + ThuNgan[i].getQuayTT() + "#" + ThuNgan[i].getMaNV()
                            + "#" + ThuNgan[i].getChucVu() + "#"
                            + ThuNgan[i].getLuong() + "#" + ThuNgan[i].getTen() + "#" + ThuNgan[i].getTuoi() + "#"
                            + ThuNgan[i].getGioitinh() + "\n");

                else
                    bin.write(ThuNgan[i].getDSBH() + "#" + ThuNgan[i].getQuayTT() + "#" + ThuNgan[i].getMaNV() + "#"
                            + ThuNgan[i].getChucVu() + "#"
                            + ThuNgan[i].getLuong() + "#" + ThuNgan[i].getTen() + "#" + ThuNgan[i].getTuoi() + "#"
                            + ThuNgan[i].getGioitinh() + "\n");

                i++;

            }

            writefile.close();
            bin.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    // tìm kiếm thông tin bị trùng lặp
    // trùng lặp được cho phép
    public static newThuNgan Trunglap(String masoThuNgan) {
        if (ThuNgan == null || ThuNgan[0] == null)
            return null;

        for (int i = 0; i < ThuNgan.length; i++)
            if (ThuNgan[i] != null)
                if (ThuNgan[i].getMaNV() != null && ThuNgan[i].getMaNV().equals(masoThuNgan))
                    return ThuNgan[i];

        return null;
    }

    // xuất thông tin
    public void xuatdanhsach() {
        if (ThuNgan == null) {
            System.out.println("Khong co Thu Ngan nao");
            return;
        }

        for (int i = 0; i < ThuNgan.length; i++) {
            if (ThuNgan[i] != null && ThuNgan[i].trangthai == 1) {
                System.out.println("");
                System.out.println(ThuNgan[i].xuat());
            }
        }
    }

    public static newThuNgan[] Sapxep_ma() {
        if (ThuNgan == null)
            return null;

        newThuNgan ThuNgan_sapxep[] = Arrays.copyOf(ThuNgan, ThuNgan.length);
        newThuNgan tmp;

        for (int i = 0; i < ThuNgan_sapxep.length; i++) {
            for (int j = i + 1; j < ThuNgan_sapxep.length; j++) {
                if (Integer.parseInt(ThuNgan_sapxep[i].getMaNV().substring(2)) > Integer
                        .parseInt(ThuNgan_sapxep[j].getMaNV().substring(2))) {
                    tmp = ThuNgan_sapxep[i];
                    ThuNgan_sapxep[i] = ThuNgan_sapxep[j];
                    ThuNgan_sapxep[j] = tmp;
                }

            }
        }
        return ThuNgan_sapxep;
    }

    public void SapxepTheoMa() {
        if (ThuNgan == null)
            return;

        newThuNgan ThuNgan_sapxep[] = Arrays.copyOf(Sapxep_ma(), Sapxep_ma().length);

        for (int i = 0; i < ThuNgan_sapxep.length; i++) {

            if (ThuNgan_sapxep[i] != null && ThuNgan_sapxep[i].trangthai == 1) {
                System.out.println("");
                System.out.println(ThuNgan_sapxep[i].xuat());
            }

        }
    }

    public static newThuNgan[] Sapxep_ten() {
        if (ThuNgan == null)
            return null;

        newThuNgan ThuNgan_sapxep[] = Arrays.copyOf(ThuNgan, ThuNgan.length);
        newThuNgan tmp;

        for (int i = 0; i < ThuNgan_sapxep.length; i++) {
            for (int j = 0; j < ThuNgan_sapxep.length - i - 1; j++) {
                String kyTu1 = ThuNgan_sapxep[j].getTen().substring(0, 1).toLowerCase();
                String kyTu2 = ThuNgan_sapxep[j + 1].getTen().substring(0, 1).toLowerCase();

                if (kyTu1.compareTo(kyTu2) > 0) {
                    tmp = ThuNgan_sapxep[j];
                    ThuNgan_sapxep[j] = ThuNgan_sapxep[j + 1];
                    ThuNgan_sapxep[j + 1] = tmp;
                }
            }
        }
        return ThuNgan_sapxep;
    }

    public void SapxepTheoTen() {
        if (ThuNgan == null)
            return;

        newThuNgan ThuNgan_sapxep[] = Arrays.copyOf(Sapxep_ten(), Sapxep_ten().length);

        for (int i = 0; i < ThuNgan_sapxep.length; i++) {

            if (ThuNgan_sapxep[i] != null && ThuNgan_sapxep[i].trangthai == 1) {
                System.out.println("");
                System.out.println(ThuNgan_sapxep[i].xuat());
            }

        }
    }

    // thêm thông tin đối tượng
    public static newThuNgan Them() {
        int i;

        if (ThuNgan == null)
            ThuNgan = new newThuNgan[1];

        else
            ThuNgan = Arrays.copyOf(ThuNgan, ThuNgan.length + 1);

        i = ThuNgan.length - 1;
        ThuNgan[i] = new newThuNgan();

        System.out.println("nhap thong tin Thu Ngan ");

        ThuNgan[i].nhap();
        soluong = ThuNgan.length;

        return ThuNgan[i];
    }

    public static void ThemThuNgan() {
        int so_luong_can_them = -1;

        while (so_luong_can_them == -1) {

            System.out.print("Nhap so luong Thu Ngan can them: ");
            String sl = sc.nextLine();

            if (sl.matches("\\d+")) {
                so_luong_can_them = Integer.parseInt(sl);

                if (so_luong_can_them == 0) {
                    if (ThuNgan == null)
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
    public static int Timkiem(String masoThuNgan) {
        for (int i = 0; i < ThuNgan.length; i++) {
            if (ThuNgan[i].trangthai == 1 && ThuNgan[i].getMaNV() != null && ThuNgan[i].getMaNV().equals(masoThuNgan))
                return i;
        }

        return -1;

    }

    public static void TimkiemThuNgan() {
        System.out.print("Nhap ma so Thu Ngan can tim: ");
        String masoThuNgan = sc.nextLine();

        int i = Timkiem(masoThuNgan);

        while (i == -1) {

            System.out.println("Khong tim thay");
            System.out.println("1.Tiep tuc tim kiem");
            System.out.println("2.Thoat tim kiem");

            int luachon = Integer.parseInt(sc.nextLine());

            if (luachon == 1)
                TimkiemThuNgan();

            else
                return;

        }

        System.out.println(ThuNgan[i].xuat());

    }

    // xóa thông tin(xóa giả => ẩn thông tin)
    public static void Xoa() {
        System.out.print("Nhap ma Thu Ngan can xoa: ");
        String masoThuNgan = sc.nextLine();

        int i = Timkiem(masoThuNgan);

        if (i == -1) {

            System.out.println("Khong tim thay");
            System.out.println("1.Tiep tuc tim kiem");
            System.out.println("2.Thoat tim kiem");

            int luachon = Integer.parseInt(sc.nextLine());

            if (luachon == 1)
                Xoa();

        } else {
            ThuNgan[i].trangthai = 0;
            return;
        }

    }

    public static void XoaThuNgan() {
        if (ThuNgan == null) {
            System.out.println("Danh sach rong");
            return;
        }

        int so_luong_can_xoa = -1;

        while (so_luong_can_xoa == -1) {

            System.out.print("Nhap so luong Thu Ngan can xoa (Khong vuot qua " + ThuNgan.length + "): ");
            String sl = sc.nextLine();

            if (sl.matches("\\d+")) {
                so_luong_can_xoa = Integer.parseInt(sl);

                if (so_luong_can_xoa == 0) {
                    System.out.println("Khong xoa Thu Ngan");
                    return;
                }

                if (so_luong_can_xoa > ThuNgan.length)
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
    public static newThuNgan Khoiphuc(String maThuNgan_cankhoiphuc) {
        int i;

        for (i = 0; i < ThuNgan.length; i++)
            if (ThuNgan[i].getMaNV() != null && ThuNgan[i].getMaNV().equals(maThuNgan_cankhoiphuc)
                    && ThuNgan[i].trangthai == 0) {
                ThuNgan[i].trangthai = 1;
                return ThuNgan[i];
            }

        return null;
    }

    public static void KhoiphucThuNgan() {
        if (ThuNgan == null) {
            System.out.println("Danh sach rong");
            return;
        }

        int soluong_ThuNgan_cankhoiphuc = -1;

        while (soluong_ThuNgan_cankhoiphuc == -1) {

            System.out.print("Nhap so luong Thu Ngan can khoi phuc (Khong vuot qua " + ThuNgan.length + "): ");
            String sl = sc.nextLine();

            if (sl.matches("\\d+")) {
                soluong_ThuNgan_cankhoiphuc = Integer.parseInt(sl);

                if (soluong_ThuNgan_cankhoiphuc > ThuNgan.length)
                    return;

                for (int i = 0; i < soluong_ThuNgan_cankhoiphuc; i++) {

                    System.out.print("Nhap ma Thu Ngan can khoi phuc: ");
                    String maThuNgan_cankhoiphuc = sc.nextLine();

                    Khoiphuc(maThuNgan_cankhoiphuc);
                }

            } else
                soluong_ThuNgan_cankhoiphuc = -1;
        }

    }

    // sửa thông tin
    public static newThuNgan Sua(String maso_ThuNgan_cansua) {
        int i = Timkiem(maso_ThuNgan_cansua);

        if (i == -1) {

            System.out.println("Khong tim thay");
            System.out.println("1.Tiep tuc tim kiem");
            System.out.println("2.Thoat tim kiem");

            int luachon = Integer.parseInt(sc.nextLine());

            if (luachon == 1) {
                System.out.print("Nhap Ma so Thu Ngan can sua thong tin: ");
                return Sua(sc.nextLine());

            } else
                return null;

        }

        int so_luong_thong_tin_can_sua = -1;

        while (so_luong_thong_tin_can_sua == -1) {

            System.out.print("Ban muon sua bao nhieu thong tin cua Thu Ngan (toi da 5): ");
            String sl = sc.nextLine();

            if (sl.matches("\\d+")) {
                so_luong_thong_tin_can_sua = Integer.parseInt(sl);

                if (so_luong_thong_tin_can_sua > 5)
                    return null;

                while (so_luong_thong_tin_can_sua != 0) {
                    System.out.println("Sua thong tin cua ThuNgan '" + ThuNgan[i].getTen() + "'");
                    ThuNgan[i].suathongtin();
                    so_luong_thong_tin_can_sua--;
                }

            } else
                so_luong_thong_tin_can_sua = -1;
        }

        return ThuNgan[i];
    }

    public static void SuaThuNgan() {
        if (ThuNgan == null) {
            System.out.println("Danh sach rong");
            return;
        }

        int so_luong_can_sua = -1;

        while (so_luong_can_sua == -1) {
            System.out.print("Nhap so luong Thu Ngan can sua (Khong vuot qua " + ThuNgan.length + "): ");
            String sl = sc.nextLine();

            if (sl.matches("\\d+")) {
                so_luong_can_sua = Integer.parseInt(sl);

                if (so_luong_can_sua == 0) {
                    System.out.println("Khong sua Thu Ngan");
                    return;
                }

                if (so_luong_can_sua > ThuNgan.length)
                    return;

                while (so_luong_can_sua != 0) {
                    System.out.print("Nhap ma so Thu Ngan sua: ");
                    String maso_ThuNgan_cansua = sc.nextLine();
                    Sua(maso_ThuNgan_cansua);
                    so_luong_can_sua--;
                }

            } else
                so_luong_can_sua = -1;
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
