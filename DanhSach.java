package sach;

import java.util.List;

public interface DanhSach {
    // Định nghĩa interface
    void nhapdanhsach(); // Phương thức nhập danh sách

    void docFile(String filename); // Phương thức đọc từ file

    void ghiFile(String filename); // Phương thức ghi vào file

    void xuatdanhsach(); // Phương thức xuất danh sách

    void SapxepTheoMa();

    void SapxepTheoTen();
}
