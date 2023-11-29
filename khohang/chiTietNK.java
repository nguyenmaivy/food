package sach;
import java.util.*;

public class chiTietNK {
    public Scanner sc = new Scanner(System.in);
    private int soluong;
    private double giaNhap;
    private String masach;
    //private sach sach;
    public int trangthai;
    public chiTietNK(int soluong, double giaNhap, String masach, int trangthai){
        this.soluong = soluong;
        this.giaNhap = giaNhap;
        this.masach = masach;
        //this.sach = sach;
        this.trangthai = trangthai;
    }
    public chiTietNK(){
    }

    public int getTrangthai() {
        return trangthai;
    }
    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getsoluong(){
        return soluong;
    }
    public void setsoluong(int soluong){
        this.soluong = soluong;
    }

    public double getgiaNhap(){
        return giaNhap;
    }
    public void setgiaNhap(double giaNhap){
        this.giaNhap = giaNhap;
    }

    public String getmasach(){
        return masach;
    }
    public void setmasach(String masach){
        this.masach = masach;
    }

    /*public sach getsach(){
        return sach;
    }
    public void setsach(sach sach){
        this.sach = sach;
    }*/

    public void Nhap(){
        while(soluong <= 0){
            System.out.print("Nhap so luong sach: ");
            String newsoluong = sc.nextLine();
            if (newsoluong.matches("\\d+"))
                this.soluong = Integer.parseInt(newsoluong);
            else
                this.soluong = 0;
        }
        while(this.giaNhap == 0 || this.giaNhap >100000000){
            System.out.print("Gia nhap: ");
            String newgiaNhap = sc.nextLine();
            if (newgiaNhap.matches("\\d+"))
                this.giaNhap = Double.parseDouble(newgiaNhap);
            else
                this.giaNhap = 0;
        }
        while (this.masach == null || this.masach.isEmpty()) {
            System.out.print("Nhap ma sach: ");
            String newmasach = sc.nextLine();
            sach new_masach = danhsachSach.Trunglap(newmasach);
            if (new_masach == null) {
                this.masach = newmasach;
                break;
            } else if (new_masach != null && new_masach.getTrangthai() == 1) {
                System.out.println("Trung lap ma sach - hay lua chon:");
                System.out.println("1.Sua thong tin sach");
                System.out.println("2.Tao sach moi");
                int luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        System.out.println("Dang Sua");
                        danhsachSach.Sua(newmasach);
                        return;
                    default:
                        Nhap();
                        return;
                }
            }
        }
        /*while (sach == null) {
            sach = new sach();
            if (danhsachSach.getSoluong() == 0) {
                sach = danhsachSach.Them();
                break;
            }
        }*/
        this.trangthai = 1; 
    }

    public void suaThongTin() {
        System.out.println("1. Sua ma sach sach");
        System.out.println("2. Sua gia nhap sach moi");
        System.out.println("3. Sua so luong");
        //System.out.println("4. Sua thong tin sach");

        System.out.println("Nhap lua chon: ");
        int luaChon = Integer.parseInt(sc.nextLine());
        boolean exitLoop = false;

        switch (luaChon) {
            case 1:
                while (!exitLoop) {
                    System.out.println("Nhap ma sach moi");
                    String newmasach = sc.nextLine();
                    sach new_masach = danhsachSach.Trunglap(newmasach);
                    if (new_masach == null && !this.masach.equals(newmasach)) {
                        this.masach = newmasach;
                        exitLoop = true;
                        break;
                    } else if (new_masach != null && new_masach.getTrangthai() == 1) {
                        System.out.println("Trung lap Sach moi nhap lai:");
                        exitLoop = false;
                    } else {
                        System.out.println("Sach da bi xoa du lieu - hay lua chon:");
                        System.out.println("1.Khoi phuc Sach");
                        System.out.println("2.Sua thong tin Sach");
                        System.out.println("3.Tao Sach moi");
                        int luachon_1 = Integer.parseInt(sc.nextLine());
                        switch (luachon_1) {
                            case 1:
                                danhsachSach.Khoiphuc(newmasach);
                                System.out.println("Da khoi phuc");
                                return;
                            case 2:
                                danhsachSach.Khoiphuc(newmasach);
                                danhsachSach.Sua(newmasach);
                                System.out.println("Dang Sua");
                                return;
                            default:
                                danhsachSach.Them();
                                return;
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Nhap gia nhap sach moi: ");
                this.giaNhap = Double.parseDouble(sc.nextLine());
                break;
            case 3:
                System.out.println("Nhap so luong sach moi: ");
                this.soluong = Integer.parseInt(sc.nextLine());
                break;
            /*case 4:
                sach.suathongtin();*/
            default:
                break;
        }
    }

    public void capnhatchiTietNK(int soluong, double giaNhap, String masach){
        this.soluong = soluong;
        this.giaNhap = giaNhap;
        this.masach = masach;
        //this.sach = sach;
    }

    public String Xuat(){
        return String.format("masach: %s | soluong: %d | Gia nhap: %,-10.3f%-3s ", masach, soluong, giaNhap,"VND");
    }

    public boolean daXoa() {
        return false;
    }

    public boolean isDeleted() {
        return false;
    }   
}
