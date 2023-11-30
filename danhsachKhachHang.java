package sach;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class danhsachKhachHang implements DanhSach {
	public static Scanner sc = new Scanner(System.in);
	private static int soLuong = 0;
	private static newKhachHang khachHang[];

	public danhsachKhachHang() {

	}

	public static int getSoluong() {
		return soLuong;
	}

	public static void setSoluong(int sl) {
		soLuong = sl;
	}

	// nhap thong tin cho danh sach khach hang
	public void nhapDanhSach() {
		while (soLuong <= 0) {
			System.out.print("Nhap so luong khach hang: ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+"))
				soLuong = Integer.parseInt(sl);
			else
				soLuong = 0;
		}
		khachHang = new newKhachHang[soLuong];
		for (int i = 0; i < khachHang.length; i++) {
			khachHang[i] = new newKhachHang();
			System.out.println("----Nhap thong tin khach hang [" + (i + 1) + "]:----");
			khachHang[i].nhap();
		}
	}

	/* doc ghi file */
	public void docfile(String filename) {
		try {
			FileReader readfile = new FileReader(filename);
			BufferedReader br = new BufferedReader(readfile);
			String line;
			int i;
			while ((line = br.readLine()) != null) {
				String text[] = line.split("#");
				if (khachHang == null) {
					khachHang = new newKhachHang[1];
					i = 0;
				} else {
					i = soLuong;
					khachHang = Arrays.copyOf(khachHang, khachHang.length + 1);
				}
				if (text.length == 5 && text[0].matches("\\d+") && trungLap(text[0]) == null
						&& !text[1].matches(".*\\d.*") && text[2].matches("\\d+")) {
					if (khachHang[i] == null)
						khachHang[i] = new newKhachHang();
					khachHang[i].capNhatKhachHang(text[0], text[1], Integer.parseInt(text[2]), text[3]);
					i++;
					soLuong++;
				} else
					khachHang = Arrays.copyOf(khachHang, khachHang.length - 1);
			}
			br.close();
			readfile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ghifile(String filename) {
		try {
			FileWriter writefile = new FileWriter(filename);
			FileWriter bin = new FileWriter("D:\\java\\java_project\\food\\sach\\khachhang_ghi.txt");
			int i = 0;
			if (khachHang == null) {
				System.out.println("Danh sach rong");
				writefile.close();
				bin.close();
				return;
			}
			while (i < khachHang.length && khachHang[i] != null) {
				if (khachHang[i].trangThai == 1)
					writefile.write(khachHang[i].getId() + "#" + khachHang[i].getTen() + "#" + khachHang[i].getTuoi()
							+ "#" + khachHang[i].getGioitinh() + "\n");
				else
					bin.write(khachHang[i].getId() + "#" + khachHang[i].getTen() + "#" + khachHang[i].getTuoi() + "#"
							+ khachHang[i].getGioitinh() + "\n");
				i++;
			}
			writefile.close();
			bin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// tim kiem thong tin bi trung lap
	// trung lap duoc cho phep
	public static newKhachHang trungLap(String id) {
		if (khachHang == null || khachHang[0] == null)
			return null;
		for (int i = 0; i < khachHang.length; i++)
			if (khachHang[i] != null)
				if (khachHang[i].getId() != null && khachHang[i].getId().equals(id))
					return khachHang[i];
		return null;
	}

	// xuat thong tin
	public void xuatDanhSach() {
		if (khachHang.length == 0) {
			System.out.println("Khong co khach hang nao.");
			return;
		}
		System.out.println("+------------------------DANH SACH KHACH HANG----------------------+");
		for (int i = 0; i < khachHang.length; i++) {
			if (khachHang[i] != null && khachHang[i].trangThai == 1) {
				System.out.println(khachHang[i].xuat());
			}
		}
		System.out.println("+------------------------------------------------------------------+");
	}

	// them thong tin khach hang
	public static newKhachHang them() {
		int i;
		if (khachHang == null) {
			khachHang = new newKhachHang[1];
			i = 0;
		} else {
			i = soLuong;
			khachHang = Arrays.copyOf(khachHang, khachHang.length + 1);
		}
		khachHang[i] = new newKhachHang();
		System.out.println("Nhap thong tin khach hang [" + (i + 1) + "]");
		khachHang[i].nhap();
		soLuong++;
		return khachHang[i];
	}

	public static void themKhachHang() {
		int soLuongCanThem = -1;
		while (soLuongCanThem == -1) {
			System.out.print("Nhap so luong khach hang muon them: ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				soLuongCanThem = Integer.parseInt(sl);
				if (soLuongCanThem == 0) {
					if (soLuong == 0)
						System.out.println("Danh sach rong");
					else
						System.out.println("Khong them khach hang");
					return;
				}
				while (soLuongCanThem != 0) {
					them();
					soLuongCanThem--;
				}
			} else
				soLuongCanThem = -1;
		}
	}

	// tim kiem thong tin khach hang
	public static int timKiem(String id) {
		for (int i = 0; i < khachHang.length; i++) {
			if (khachHang[i].trangThai == 1 && khachHang[i].getId() != null && khachHang[i].getId().equals(id))
				return i;
		}
		return -1;
	}

	public static void timKiemKhachHang() {
		while (true) {
			System.out.print("Nhap ma so tac gia can tim: ");
			String masotacgia = sc.nextLine();
			int i = timKiem(masotacgia);

			if (i == -1) {
				System.out.println("Khong tim thay !");
				System.out.println("1.Tiep tuc tim kiem");
				System.out.println("2.Thoat tim kiem");
				int luachon = Integer.parseInt(sc.nextLine());

				if (luachon == 2) {
					return;
				}
			} else {
				System.out.println("Tim thay!\n" + khachHang[i].xuat());
				System.out.println("1.Tiep tuc tim kiem");
				System.out.println("2.Thoat tim kiem");
				int luachon = Integer.parseInt(sc.nextLine());

				if (luachon == 2) {
					return;
				}
			}
		}
	}

	// xoa thong tin
	public static void xoa() {
		System.out.print("Nhap ID khach hang can xoa: ");
		String id = sc.nextLine();
		int i = timKiem(id);
		if (i == -1) {
			System.out.println("Khong tim thay !");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int chon = Integer.parseInt(sc.nextLine());
			if (chon == 1)
				xoa();
		} else {
			khachHang[i].trangThai = 0;
			return;
		}
	}

	public static void xoaKhachHang() {
		if (soLuong == 0) {
			System.out.println("Danh sach rong");
			return;
		}

		int soLuongCanXoa = -1;
		while (soLuongCanXoa == -1) {
			System.out.print("Nhap so luong khach hang can xoa (Khong vuot qua " + khachHang.length + "): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				soLuongCanXoa = Integer.parseInt(sl);
				if (soLuongCanXoa == 0) {
					System.out.println("Khong xoa tac gia");
					return;
				}
				if (soLuongCanXoa > khachHang.length) {
					return;
				}

				System.out.println("Chon lua truoc khi xoa:");
				System.out.println("1. Xem danh sach va xoa");
				System.out.println("2. Xoa ngay");

				int luaChon = Integer.parseInt(sc.nextLine());

				if (luaChon == 1) {
					for (int i = 0; i < soLuongCanXoa; i++) {
						xemDanhSachHienTai();
						xoa();
					}
				} else if (luaChon == 2) {
					while (soLuongCanXoa != 0) {
						xoa();
						soLuongCanXoa--;
					}
				} else {
					System.out.println("Lua chon khong hop le. Quay tro lai menu.");
					return;
				}
			} else {
				soLuongCanXoa = -1;
			}
		}
	}

	// khoi phuc thong tin da xoa
	public static newKhachHang khoiPhuc(String idKhachHang_canKhoiPhuc) {
		int i;
		for (i = 0; i < khachHang.length; i++)
			if (khachHang[i].getId() != null && khachHang[i].getId().equals(idKhachHang_canKhoiPhuc)
					&& khachHang[i].trangThai == 0) {
				khachHang[i].trangThai = 1;
				return khachHang[i];
			}
		return null;
	}

	public static void khoiPhucKhachHang() {
		if (soLuong == 0) {
			System.out.println("Danh sach rong");
			return;
		}

		int soLuongCanKhoiPhuc = -1;
		int soKhachHangDaXoa = soKhachHangBiXoa();

		if (soKhachHangDaXoa == 0) {
			System.out.println("Khong co khach hang nao bi xoa. Khong can khoi phuc.");
			return;
		}

		while (soLuongCanKhoiPhuc == -1) {
			System.out.print("Nhap so luong khach hang can khoi phuc (Khong vuot qua " + soKhachHangDaXoa + "): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				soLuongCanKhoiPhuc = Integer.parseInt(sl);
				if (soLuongCanKhoiPhuc == 0) {
					System.out.println("Khong khoi phuc khach hang");
					return;
				}
				if (soLuongCanKhoiPhuc > soKhachHangDaXoa)
					return;

				for (int i = 0; i < soLuongCanKhoiPhuc; i++) {
					System.out.print("Nhap ID khach hang can khoi phuc: ");
					String idKhachHang_canKhoiPhuc = sc.nextLine();
					khoiPhuc(idKhachHang_canKhoiPhuc);
				}
			} else
				soLuongCanKhoiPhuc = -1;
		}
	}

	// Hàm kiểm tra số lượng khách hàng bị xóa
	public static int soKhachHangBiXoa() {
		int count = 0;
		for (int i = 0; i < khachHang.length; i++) {
			if (khachHang[i] != null && khachHang[i].trangThai == 0) {
				count++;
			}
		}
		return count;
	}

	// sua thong tin
	public static newKhachHang sua(String idKhachHang_canSua) {
		int i = timKiem(idKhachHang_canSua);
		if (i == -1) {
			System.out.println("Khong tim thay !");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int chon = Integer.parseInt(sc.nextLine());
			if (chon == 1) {
				System.out.print("Nhap ID khach hang can sua: ");
				return sua(sc.nextLine());
			} else
				return null;
		}
		int soLuongCanSua = -1;
		while (soLuongCanSua == -1) {
			System.out.print("Ban muon sua bao nhieu thong tin cua khach hang (max=4)");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				soLuongCanSua = Integer.parseInt(sl);
				if (soLuongCanSua > 4)
					return null;
				while (soLuongCanSua != 0) {
					System.out.println("Sua thong tin cua khach hang\" " + khachHang[i].getTen() + "\"");
					khachHang[i].suathongtin();
					soLuongCanSua--;
				}
			} else
				soLuongCanSua = -1;
		}
		return khachHang[i];
	}

	public static void suaKhachHang() {
		if (soLuong == 0) {
			System.out.println("Danh sach rong");
			return;
		}
		int soLuongCanSua = -1;
		while (soLuongCanSua == -1) {
			System.out.print("Nhap so luong khach hang can sua (Khong vuot qua " + khachHang.length + "): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				soLuongCanSua = Integer.parseInt(sl);
				if (soLuongCanSua == 0) {
					System.out.println("Khong sua khach hang");
					return;
				}
				if (soLuongCanSua > khachHang.length)
					return;

				System.out.println("Chon lua truoc khi sua:");
				System.out.println("1. Xem danh sach va sua");
				System.out.println("2. Sua ngay");

				int luaChon = Integer.parseInt(sc.nextLine());

				if (luaChon == 1) {
					for (int i = 0; i < soLuongCanSua; i++) {
						xemDanhSachHienTai();
						System.out.print("Nhap ID khach hang can sua: ");
						String idKhachHang_canSua = sc.nextLine();
						sua(idKhachHang_canSua);
					}
				} else if (luaChon == 2) {
					while (soLuongCanSua != 0) {
						System.out.print("Nhap ID khach hang can sua: ");
						String idKhachHang_canSua = sc.nextLine();
						sua(idKhachHang_canSua);
						soLuongCanSua--;
					}
				} else {
					System.out.println("Lua chon khong hop le. Quay tro lai menu.");
					return;
				}
			} else
				soLuongCanSua = -1;
		}
	}

	// danh sach khach hang hien tai
	public static void xemDanhSachHienTai() {
		if (khachHang.length == 0) {
			System.out.println("Danh sach rong");
			return;
		}
		System.out.println("+-------------------Danh sach khach hang hien tai------------------+");
		for (int i = 0; i < khachHang.length; i++) {
			if (khachHang[i] != null && khachHang[i].trangThai == 1) {
				System.out.println(khachHang[i].xuat());
			}
		}
		System.out.println("+------------------------------------------------------------------+");
	}

	public static KhachHang getKhachHang(int index) {
		if (index >= 0 && index < soLuong) {
			return khachHang[index];
		} else {
			System.out.println("Index is out of bounds.");
			return null; // or throw an exception
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
