package sach;
import java.util.*;
class ChiTietDonHang{
    //private String mahoadon;
    private newsach[] sach;
    private int so_luong_moi_loai[];
    private int so_luong_loai_sach;
    private double tongtien;
    Scanner sc=new Scanner(System.in);
    public ChiTietDonHang(){

    }
    public ChiTietDonHang(/*String mahoadon,*/newsach[] sach,int so_luong_loai_sach,int so_luong_moi_loai[],double tongtien){
        this.sach=sach;
        this.so_luong_loai_sach=so_luong_loai_sach;
        this.so_luong_moi_loai=so_luong_moi_loai;
        //this.mahoadon=mahoadon;
        this.tongtien=tongtien;
    }
    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }
    public double getTongtien() {
        return tongtien;
    }
    /*public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }
    public String getMahoadon() {
        return mahoadon;
    }*/
    public void setSach(newsach []sach) {
        this.sach = sach;
    }
    public void setSo_luong_loai_sach(int so_luong_loai_sach) {
        this.so_luong_loai_sach = so_luong_loai_sach;
    }
    public void setSo_luong_moi_loai(int[] so_luong_moi_loai) {
        this.so_luong_moi_loai = so_luong_moi_loai;
    }
    public newsach[] getSach() {
        return sach;
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
                sach = new newsach[so_luong_loai_sach];
                so_luong_moi_loai = new int[so_luong_loai_sach];
    
                while (i < so_luong_loai_sach) {
                    System.out.print("Nhap Ma sach: ");
                    String newmasach = sc.nextLine();
                    int location = danhsachSach.Timkiem(newmasach);
    
                    if (location != -1) {
                        sach new_masach = danhsachSach.getSach(location);
                        sach[i] = new newsach(new_masach.getTensach(), new_masach.getMasach(), new_masach.getTacgia(), new_masach.getNXB(), new_masach.getTheloai(), new_masach.getGiaban(), new_masach.getSoluong(), 1);
                        so_luong_moi_loai[i] = 0;
    
                        while (so_luong_moi_loai[i] <= 0 || so_luong_moi_loai[i] > new_masach.getSoluong()) {
                            System.out.print("Nhap so luong sach \"" + sach[i].getTensach() + "\" can mua (khong vuot qua so luong co san " + new_masach.getSoluong() + "): ");
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
        //this.trangthai=1;
    }
    
    public double tonghoadon(){
        double tong=0.0;
        for(int i=0;i<sach.length;i++){
            tong=tong+so_luong_moi_loai[i]*sach[i].getGiaban();
        }
        return tong;
    }
    public String xuat() {
        StringBuilder result = new StringBuilder();
    
        if (this.sach != null) {
            for (int i = 0; i < sach.length; i++) {
                result.append(String.format("Ten sach: %s gia: %.2f So luong:x%d ", sach[i].getTensach(), sach[i].getGiaban(), so_luong_moi_loai[i]));
            }
        }
    
        result.append(String.format("|Thanh tien: %.2f", tonghoadon()));
        return result.toString();
    }
}
