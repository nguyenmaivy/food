package sach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DonHang {
    public Scanner sc = new Scanner(System.in);

    // Thuộc tính
    private KhachHang khachHang;  // Giả sử DonHang liên quan đến một KhachHang
    private String maDonHang;
    private String maKhachHang;  
    private int trangThaiDonHang;
    private Date ngayDat;
    private Date ngayGiao;
    private double tongChiPhi;
    private PhuongThucThanhToan phuongThucThanhToan;
    private ChiTietDonHang chiTietDonHang;

    ChiTietDonHang dh=new ChiTietDonHang();

    public PhuongThucThanhToan[] danhsachPhuongThucThanhToan;

    // Getter và setter cho maKhachHang
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    
    // Constructor
    public DonHang(String maDonHang, int trangThaiDonHang, KhachHang khachHang) {
        this.maDonHang = maDonHang;
        this.trangThaiDonHang = trangThaiDonHang;
        this.khachHang = khachHang;
    }

    // Getter và Setter methods
    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }



    public DonHang() {
        // Khởi tạo giá trị mặc định cho trạng thái đơn hàng
        this.trangThaiDonHang = 1; // 1 có thể là giá trị mặc định cho đơn hàng chưa bị xóa
    }

    // Thêm getter và setter cho trạng thái đơn hàng
    public int getTrangThaiDonHang() {
        return trangThaiDonHang;
    }

    public void setTrangThaiDonHang(int trangThaiDonHang) {
        this.trangThaiDonHang = trangThaiDonHang;
    }

    public ChiTietDonHang getChiTietDonHang(){
        return chiTietDonHang;
    }
    public void setChiTietDonHang(ChiTietDonHang chiTietDonHang){
        this.chiTietDonHang=chiTietDonHang;
    }
    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public PhuongThucThanhToan getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(PhuongThucThanhToan phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public double getTongChiPhi() {
        return tongChiPhi;
    }

    public void setTongChiPhi(double tongChiPhi) {
        this.tongChiPhi = tongChiPhi;
    }

    // Các phương thức nhập và xuất
    public void nhap() {
        // Nhap ID don hang
        while (this.maDonHang == null || this.maDonHang.isEmpty()) {
            System.out.print("Nhap ID don hang: ");
            String newMaDonHang = sc.nextLine();
            if (newMaDonHang.matches("\\d+")) {
                this.maDonHang = newMaDonHang;
            }
        }
    
        // Nhap ngay dat
        while (true) {
            System.out.print("Nhap ngay dat (dd/MM/yyyy): ");
            String strNgayDat = sc.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false); // check ngay thang nam
                this.ngayDat = dateFormat.parse(strNgayDat);
                break; // Ngay dat hop le, thoat khoi vong lap
            } catch (ParseException e) {
                System.out.println("Ngay dat khong hop le. Vui long nhap theo dinh dang dd/MM/yyyy.");
            }
        }
    
        // Nhap ngay giao
        while (true) {
            System.out.print("Nhap ngay giao (dd/MM/yyyy): ");
            String strNgayGiao = sc.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false); // check ngay
                this.ngayGiao = dateFormat.parse(strNgayGiao);
    
                // check ngay giao PHAI SAU lon hon ngay dat
                if (this.ngayGiao.after(this.ngayDat)) {
                    break; // Ngay giao hop le, thoat khoi vong lap
                } else {
                    System.out.println("Ngay giao phai lon hon ngay dat. Vui long nhap lai.");
                }
            } catch (ParseException e) {
                System.out.println("Ngay giao khong hop le. Vui long nhap theo dinh dang dd/MM/yyyy.");
            }
        }
    
        // Nhap tong chi phi
        while (true) {
            System.out.print("Nhap chi phi giao: ");
            try {
                this.tongChiPhi = Double.parseDouble(sc.nextLine());
                break; // Tong chi phi hop le, thoat khoi vong lap
            } catch (NumberFormatException e) {
                System.out.println("Phi giao khong hop le. Vui long nhap lai.");
            }
        }
    
        // Nhap trang thai don hang
        while (true) {
            System.out.print("Nhap trang thai don hang (1 - Da dat, 2 - Dang giao, 3 - Da giao): ");
            try {
                int trangThai = Integer.parseInt(sc.nextLine());
                if (trangThai >= 1 && trangThai <= 3) {
                    this.trangThaiDonHang = trangThai;
                    break; // Trang thai hop le, thoat khoi vong lap
                } else {
                    System.out.println("Trang thai khong hop le. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Trang thai khong hop le. Vui long nhap lai.");
            }
        }
        //nhap khach hang
        while (true) {
            System.out.print("Nhap ID khach hang: ");
            String newMaKhachHang = sc.nextLine();
            
            if (newMaKhachHang.matches("\\d+")) {
                int index = Integer.parseInt(newMaKhachHang) - 1; // Adjust to 0-based index
        
                if (index >= 0 && index < danhsachKhachHang.getSoluong()) {
                    // Existing customer
                    this.maKhachHang = newMaKhachHang;
                    this.khachHang = danhsachKhachHang.getKhachHang(index);
                    break;
                } else {
                    System.out.println("Khach hang khong ton tai.");
                    System.out.println("1. Tao moi khach hang");
                    System.out.println("2. Nhap lai");
        
                    System.out.print("Nhap lua chon: ");
                    int luaChon = Integer.parseInt(sc.nextLine());
        
                    switch (luaChon) {
                        case 1:
                            // Create a new customer
                            this.khachHang = new KhachHang();
                            danhsachKhachHang.themKhachHang();
                            this.maKhachHang = newMaKhachHang;
                            break;
                        case 2:
                            // Continue to the next iteration of the loop to retry input
                            break;
                        default:
                            System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                    }
                }
            }
        }
        dh.nhap();
        nhapPhuongThucThanhToan();
    }
    public void nhapPhuongThucThanhToan() {
        // Tạo một đối tượng PhuongThucThanhToan mới
        PhuongThucThanhToan phuongThuc = new PhuongThucThanhToan();
    
        // Nhập thông tin cho phương thức thanh toán
        System.out.println("----Nhap thong tin cho phuong thuc thanh toan----");
        phuongThuc.nhapThongTinPhuongThuc();
    
        // Kiểm tra ngày thanh toán
        while (true) {
            Date ngayThanhToan = phuongThuc.getNgayThanhToan();
            if (ngayThanhToan.compareTo(this.ngayDat) >= 0 && ngayThanhToan.compareTo(this.ngayGiao) <= 0) {
                // Ngày thanh toán hợp lệ, gán cho đơn hàng và thoát khỏi vòng lặp
                this.setPhuongThucThanhToan(phuongThuc);
                break;
            } else {
                System.out.println("Ngay thanh toan khong hop le. Phai thanh toan truoc hoac trong ngay giao.");
                // Nếu không hợp lệ, yêu cầu nhập lại
                System.out.println("Nhap lai thong tin cho phuong thuc thanh toan.");
                phuongThuc.nhapThongTinPhuongThuc();
            }
        }
    }
    public void suaThongTin() {
        System.out.println("1. Sua ID don hang");
        System.out.println("2. Sua trang thai don hang");
        System.out.println("3. Sua thong tin khach hang");
        System.out.println("4. Sua ngay dat");
        System.out.println("5. Sua ngay giao");
        System.out.println("6. Sua phi giao");
        System.out.println("7. Sua thong tin phuong thuc thanh toan");
        System.out.println("8. Sua thong tin gia");
        
        System.out.print("Nhap lua chon: ");
        int luaChon = Integer.parseInt(sc.nextLine());

        switch (luaChon) {
            case 1:
                while (true) {
                    System.out.println("Nhap ID don hang moi: ");
                    String newMaDonHang = sc.nextLine();
                    if (newMaDonHang.matches("\\d+")) {
                        if (!this.maDonHang.equals(newMaDonHang)) {
                            this.maDonHang = newMaDonHang;
                            break;
                        }
                    }
                }
                break;
            case 2:
                System.out.print("Nhap ma trang thai moi (1: Da dat, 2: Dang giao, 3: Da nhan): ");
                this.trangThaiDonHang = Integer.parseInt(sc.nextLine());
                break;
            case 3:
                // Giả sử có một phương thức trong KhachHang để chỉnh sửa thông tin
                this.khachHang.suathongtin();
                break;
            case 4:
                System.out.print("Nhap ngay dat moi (dd/MM/yyyy): ");
                String strNgayDat = sc.nextLine();
                try {
                    this.ngayDat = new SimpleDateFormat("dd/MM/yyyy").parse(strNgayDat);
                } catch (Exception e) {
                    System.out.println("Ngay dat khong hop le.");
                }
                break;
                case 5:
                while (true) {
                    System.out.print("Nhap ngay giao moi (dd/MM/yyyy): ");
                    String strNgayGiao = sc.nextLine();
                    try {
                        Date ngayGiaoMoi = new SimpleDateFormat("dd/MM/yyyy").parse(strNgayGiao);
            
                        // Check if the delivery date is not earlier than the order date
                        if (ngayGiaoMoi.after(this.ngayDat)) {
                            this.ngayGiao = ngayGiaoMoi;
                            break;
                        } else {
                            System.out.println("Ngay giao phai sau ngay dat. Vui long nhap lai.");
                        }
                    } catch (ParseException e) {
                        System.out.println("Ngay giao khong hop le. Vui long nhap lai.");
                    }
                }
                break;
            case 6:
                System.out.print("Nhap phi giao moi: ");
                this.tongChiPhi = Double.parseDouble(sc.nextLine());
                break;
                case 7:
                if (this.phuongThucThanhToan != null) {
                    System.out.println("Thong tin phuong thuc thanh toan truoc khi sua: " + this.phuongThucThanhToan.xuat());
                    this.phuongThucThanhToan.suaThongTinPhuongThuc();
                    System.out.println("Thong tin phuong thuc thanh toan sau khi sua: " + this.phuongThucThanhToan.xuat());
                } else {
                    System.out.println("Don hang chua co phuong thuc thanh toan.");
                }
                break;
                case 8:
                dh.nhap();
            default:
                break;
        }
    }

    public String xuat() {
        String trangThaiString;
        switch (trangThaiDonHang) {
            case 1:
                trangThaiString = "Da dat";
                break;
            case 2:
                trangThaiString = "Dang giao";
                break;
            case 3:
                trangThaiString = "Da giao";
                break;
            default:
                trangThaiString = "Trang thai khong xac dinh";
                break;
        }
        
        return String.format("|ID don hang: %-5s|Trang thai: %-10s|Ngay dat: %tD|Ngay giao: %tD|Phi giao: %.2f %s %s %s",
                maDonHang, trangThaiString, ngayDat, ngayGiao, tongChiPhi, khachHang.xuat(), phuongThucThanhToan.xuat(),dh.xuat());
        }

    public boolean daXoa() {
        return false;
    }

    
    public boolean isDeleted() {
        return trangThaiDonHang == -1; // Check if the order is marked as deleted
    }
    public void capNhatDonHang(String maDonHang, int trangThaiDonHang, Date ngayDat, Date ngayGiao, String tongChiPhi) {
        if (kiemTraDinhDangNgay(ngayDat) && kiemTraDinhDangNgay(ngayGiao) && kiemTraDinhDangSo(tongChiPhi)) {
            this.maDonHang = maDonHang;
            this.trangThaiDonHang = trangThaiDonHang;
            this.ngayDat = ngayDat;
            this.ngayGiao = ngayGiao;
            this.tongChiPhi = Double.parseDouble(tongChiPhi);
            System.out.println("Cap nhat don hang thanh cong.");
        } else {
            System.out.println("Du lieu nhap vao khong hop le. Khong cap nhat don hang.");
        }
    }
    
    private boolean kiemTraDinhDangNgay(Date ngay) {
        // Thêm logic kiểm tra định dạng ngày ở đây, ví dụ: ngày có dạng "dd/MM/yyyy"
        return true;
    }
    
    private boolean kiemTraDinhDangSo(String so) {
        // Thêm logic kiểm tra định dạng số ở đây, ví dụ: số không chứa ký tự đặc biệt
        return true;
    }
    
    

}