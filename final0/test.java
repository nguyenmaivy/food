package final0;

import java.util.Scanner;

// import com.example.otherpackage.*;
public class test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // phan khach hang

        // danhsachKhachHang.nhapDanhSach();
        // danhsachKhachHang.themKhachHang();
        // danhsachKhachHang.suaKhachHang();
        // danhsachKhachHang.xoaKhachHang();
        // danhsachKhachHang.timKiemKhachHang();
        // danhsachKhachHang.khoiPhucKhachHang(); //kết hợp với hàm xóa
        // danhsachKhachHang.xuatDanhSach();

        // phan don hang
        // khách hàng
        danhsachKhachHang scanner =new danhsachKhachHang();
        int choice;
        danhsachKhachHang tmp = new danhsachKhachHang();
        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Hiển thị danh sách khách hàng");
            System.out.println("2. Thêm khách hàng mới");
            System.out.println("3. Xóa khách hàng");
            System.out.println("4. Sửa thông tin khách hàng");
            System.out.println("5. Tìm kiếm khách hàng");
            System.out.println("6. Thêm khách hàng (số lượng)");
            System.out.println("7. Xem danh sách khách hàng đã xóa");
            System.out.println("8. Khôi phục khách hàng");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            System.out.println(scanner.next());
            if (choice == 0){
                break;
            }
            switch (choice) {
            case 1:
                tmp.nhapDanhSach();
                break;
            case 2:
                tmp.themKhachHang();
                break;
            case 3:
                tmp.suaKhachHang();
                break;
            case 4:
                tmp.xoaKhachHang();
                break;
            case 5:
                tmp.timKiemKhachHang();
                break;
            case 6:
                tmp.khoiPhucKhachHang();
                break;
            case 7:
                    tmp.xuatDanhSach();
                    break;
            case 0:
                System.out.println("Thoát chương trình.");
                System.exit(0);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại. ");
        }
        }
        danhsachDonHang.nhapDanhSach();
        // danhsachDonHang.themDonHang();
        // danhsachDonHang.suaDonHang();
        danhsachDonHang.xoaDonHang();
        danhsachDonHang.khoiPhucDonHang();
        danhsachDonHang.timKiemDonHang();
        danhsachDonHang.xuatDanhSach();

        // phan phuong thuc thanh toan

        // danhsachPhuongThucThanhToan.nhapDanhSachPhuongThuc();
        // danhsachPhuongThucThanhToan.xuatDanhSachPhuongThuc();
    }
}
