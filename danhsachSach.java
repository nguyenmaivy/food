package sach;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class danhsachSach implements DanhSach {
	public static Scanner sc = new Scanner(System.in);
	private static int soluong = 0;
	private static newSach Sach[];

	public danhsachSach() {
	}

	public static int getSoluong() {
		return soluong;
	}

	public static void setSoluong(int soluong) {
		danhsachSach.soluong = soluong;
	}

	// dùng cho hàm tìm kiếm
	public static newSach getSach(int i) {
		return Sach[i];
	}

	// nhập thông tin
	public static void nhapdanhsach() {
		while (soluong == 0) {
			System.out.print("Nhap so luong Sach: ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+"))
				soluong = Integer.parseInt(sl);
			else
				soluong = 0;
		}
		Sach = new newSach[soluong];
		for (int i = 0; i < Sach.length; i++) {
			Sach[i] = new newSach();
			System.out.println("Nhap thong tin Sach");
			Sach[i].nhap();
		}
	}

	// đọc file
	public static void docfile(String filename) {
		try {
			FileReader readfile = new FileReader(filename);
			BufferedReader br = new BufferedReader(readfile);
			String line;
			int i;
			while ((line = br.readLine()) != null) {
				String text[] = line.split("#");
				if (Sach == null)
					Sach = new newSach[1];
				else
					Sach = Arrays.copyOf(Sach, Sach.length + 1);
				i = Sach.length - 1;
				if (text.length == 8 && Trunglap(text[0]) == null && !text[3].matches(".\\d.*")
						&& text[6].matches("\\d+\\d*\\.?\\,?") && text[7].matches("\\d+")
						&& danhsachTacGia.Trunglap(text[3]) != null && danhsachNXB.Trunglap(text[4]) != null
						&& danhsachTheLoai.Trunglap(text[5]) != null) {
					if (Sach[i] == null)
						Sach[i] = new newSach(text[0], text[1], danhsachTacGia.Trunglap(text[3]),
								danhsachNXB.Trunglap(text[4]), null, danhsachTheLoai.Trunglap(text[5]),
								Double.parseDouble(text[6]), Integer.parseInt(text[7]), 1);
					// Sach[i].capnhatSach(text[0], text[1], danhsachTacGia.Trunglap(text[3]),
					// danhsachNXB.Trunglap(text[4]), danhsachTheLoai.Trunglap(text[5]),
					// Double.parseDouble(text[6]), Integer.parseInt(text[7]), 1);
					i++;
				} else
					Sach = Arrays.copyOf(Sach, Sach.length - 1);
			}
			soluong = Sach.length;
			br.close();
			readfile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ghi file
	public static void ghifile(String filename) {
		try {
			FileWriter writefile = new FileWriter(filename);
			FileWriter bin = new FileWriter("D:\\java\\java_project\\food\\sach\\Sach_recyclebin.txt");
			int i = 0;
			if (Sach == null) {
				System.out.println("Danh Sach rong");
				writefile.close();
				bin.close();
				return;
			}
			while (i < Sach.length && Sach[i] != null) {
				if (Sach[i].trangthai == 1)
					writefile
							.write(Sach[i].getTenSach() + "#" + Sach[i].getMaSach() + "#" + Sach[i].getTacGia().getTen()
									+ "#" + Sach[i].getNXB().getTenNXB() + "#" + Sach[i].getTheLoai().getTenTheLoai()
									+ "#" + Sach[i].getGiaban() + "#" + Sach[i].getSoluong() + "\n");
				else
					bin.write(Sach[i].getTenSach() + "#" + Sach[i].getMaSach() + "#" + Sach[i].getTacGia().getTen()
							+ "#" + Sach[i].getNXB().getTenNXB() + "#" + Sach[i].getTheLoai().getTenTheLoai() + "#"
							+ Sach[i].getGiaban() + "#" + Sach[i].getSoluong() + "\n");
				i++;
			}
			writefile.close();
			bin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// tìm kiếm thông tin bị trùng lặp
	public static newSach Trunglap(String maSach) {
		if (Sach == null || Sach[0] == null)
			return null;
		for (int i = 0; i < Sach.length; i++)
			if (Sach[i] != null)
				if (Sach[i].getMaSach() != null && Sach[i].getMaSach().equals(maSach))
					return Sach[i];
		return null;
	}

	// xuất thông tin
	public void xuatdanhsach() {
		if (Sach == null) {
			System.out.println("Khong co Sach nao");
			return;
		}
		for (int i = 0; i < Sach.length; i++) {
			if (Sach[i] != null && Sach[i].trangthai == 1) {
				System.out.println("");
				System.out.println(Sach[i].xuat());
			}
		}
	}

	// sắp xếp theo mã sách
	public static newSach[] Sapxep_ma() {
		if (Sach == null || Sach.length <= 1)
			return Sach;

		newSach Sach_sapxep[] = Arrays.copyOf(Sach, Sach.length);
		newSach tmp;

		for (int i = 0; i < Sach_sapxep.length; i++) {
			for (int j = 0; j < Sach_sapxep.length - i - 1; j++) {
				String maSach1 = Sach_sapxep[j].getMaSach().toLowerCase();
				String maSach2 = Sach_sapxep[j + 1].getMaSach().toLowerCase();

				if (maSach1.compareTo(maSach2) > 0) {
					tmp = Sach_sapxep[j];
					Sach_sapxep[j] = Sach_sapxep[j + 1];
					Sach_sapxep[j + 1] = tmp;
				}
			}
		}
		return Sach_sapxep;
	}

	public void SapxepTheoMa() {
		if (Sach == null)
			return;

		newSach Sach_sapxep[] = Arrays.copyOf(Sapxep_ma(), Sapxep_ma().length);

		for (int i = 0; i < Sach_sapxep.length; i++) {

			if (Sach_sapxep[i] != null && Sach_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(Sach_sapxep[i].xuat());
			}

		}
	}

	// sắp xếp theo tên sách
	public static newSach[] Sapxep_ten() {
		if (Sach == null)
			return null;

		newSach Sach_sapxep[] = Arrays.copyOf(Sach, Sach.length);
		newSach tmp;

		for (int i = 0; i < Sach_sapxep.length; i++) {
			for (int j = 0; j < Sach_sapxep.length - i - 1; j++) {
				String kyTu1 = Sach_sapxep[j].getTenSach().substring(0, 1).toLowerCase();
				String kyTu2 = Sach_sapxep[j + 1].getTenSach().substring(0, 1).toLowerCase();

				if (kyTu1.compareTo(kyTu2) > 0) {
					tmp = Sach_sapxep[j];
					Sach_sapxep[j] = Sach_sapxep[j + 1];
					Sach_sapxep[j + 1] = tmp;
				}
			}
		}
		return Sach_sapxep;
	}

	public void SapxepTheoTen() {
		if (Sach == null)
			return;
		newSach Sach_sapxep[] = Arrays.copyOf(Sapxep_ten(), Sapxep_ten().length);

		for (int i = 0; i < Sach_sapxep.length; i++) {

			if (Sach_sapxep[i] != null && Sach_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(Sach_sapxep[i].xuat());
			}

		}
	}

	// thêm thông tin đối tượng
	public static newSach Them() {
		int i;
		if (Sach == null || Sach[0] == null)
			Sach = new newSach[1];
		else
			Sach = Arrays.copyOf(Sach, Sach.length + 1);
		i = Sach.length - 1;
		Sach[i] = new newSach();
		System.out.println("nhap thong tin Sach");
		Sach[i].nhap();
		soluong = Sach.length;
		return Sach[i];
	}

	public static void ThemSach() {
		int so_luong_can_them = -1;
		while (so_luong_can_them == -1) {
			System.out.print("So Luong Sach can them: ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				so_luong_can_them = Integer.parseInt(sl);
				if (so_luong_can_them == 0) {
					if (Sach == null)
						System.out.println("Danh Sach rong");
					else
						System.out.println("Khong them Sach");
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
	public static int Timkiem(String maSach) {
		for (int i = 0; i < Sach.length; i++) {
			if (Sach[i] != null && Sach[i].trangthai == 1 && Sach[i].getMaSach() != null
					&& Sach[i].getMaSach().equals(maSach))
				return i;
		}
		return -1;
	}

	public static void TimkiemSach() {
		if (Sach == null) {
			System.out.println("Danh Sach rong");
			return;
		}
		System.out.print("Nhap ma Sach can tim: ");
		String maSach = sc.nextLine();
		int i = Timkiem(maSach);
		while (i == -1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon = Integer.parseInt(sc.nextLine());
			if (luachon == 1)
				TimkiemSach();
			else
				return;
		}
		System.out.println(Sach[i].xuat());
	}

	// xóa thông tin(xóa giả => ẩn thông tin)
	public static void Xoa() {
		System.out.print("Nhap ma Sach can xoa: ");
		String maSach = sc.nextLine();
		int i = Timkiem(maSach);
		if (i == -1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon = Integer.parseInt(sc.nextLine());
			if (luachon == 1)
				Xoa();
		} else {
			Sach[i].trangthai = 0;
			return;
		}
	}

	public static void XoaSach() {
		if (Sach == null) {
			System.out.println("Danh Sach rong");
			return;
		}
		int so_luong_can_xoa = -1;
		while (so_luong_can_xoa == -1) {
			System.out.print("Nhap so luong Sach can xoa thong tin(khong vuot qua " + Sach.length + "): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				so_luong_can_xoa = Integer.parseInt(sl);
				if (so_luong_can_xoa == 0) {
					System.out.println("Khong xoa Sach");
					return;
				}
				if (so_luong_can_xoa > Sach.length)
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
	public static newSach Khoiphuc(String maSach_cankhoiphuc) {
		for (int i = 0; i < Sach.length; i++)
			if (Sach[i].getMaSach() != null && Sach[i].getMaSach().equals(maSach_cankhoiphuc)
					&& Sach[i].trangthai == 0) {
				Sach[i].trangthai = 1;
				return Sach[i];
			}
		return null;
	}

	public static void KhoiphucSach() {
		if (Sach == null) {
			System.out.println("Danh Sach rong");
			return;
		}
		int soluong_Sach_cankhoiphuc = -1;
		while (soluong_Sach_cankhoiphuc == -1) {
			System.out.print("Nhap so luong Sach can khoi phuc thong tin(khong vuot qua " + Sach.length + "): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				soluong_Sach_cankhoiphuc = Integer.parseInt(sl);
				if (soluong_Sach_cankhoiphuc > Sach.length)
					return;
				for (int i = 0; i < soluong_Sach_cankhoiphuc; i++) {
					System.out.print("Nhap ma Sach can khoi phuc: ");
					String tenSach_cankhoiphuc = sc.nextLine();
					Khoiphuc(tenSach_cankhoiphuc);
				}
			} else
				soluong_Sach_cankhoiphuc = -1;
		}
	}

	// sửa thông tin
	public static newSach Sua(String ten_Sach_cansua) {
		int i = Timkiem(ten_Sach_cansua);
		if (i == -1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon = Integer.parseInt(sc.nextLine());
			System.out.print("Nhap Ma Sach can sua thong tin: ");
			switch (luachon) {
				case 1:
					System.out.print("Nhap Ma Sach can sua thong tin: ");
					return Sua(sc.nextLine());
				default:
					return null;
			}
		}
		int so_luong_thong_tin_can_sua = -1;
		while (so_luong_thong_tin_can_sua == -1) {
			System.out.println("Ban muon sua bao nhieu thong tin cua Sach(toi da 7): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				so_luong_thong_tin_can_sua = Integer.parseInt(sl);
				if (so_luong_thong_tin_can_sua > 7)
					return null;
				while (so_luong_thong_tin_can_sua != 0) {
					System.out.println("Sua thong tin cua Sach '" + Sach[i].getTenSach() + "'");
					Sach[i].suathongtin();
					so_luong_thong_tin_can_sua--;
				}
			} else
				so_luong_thong_tin_can_sua = -1;
		}
		return Sach[i];
	}

	public static void SuaSach() {
		if (Sach == null) {
			System.out.println("Danh Sach rong");
			return;
		}
		int so_luong_can_sua = -1;
		while (so_luong_can_sua == -1) {
			System.out.print("Nhap so luong Sach can sua thong tin(khong vuot qua " + Sach.length + "): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				so_luong_can_sua = Integer.parseInt(sl);
				if (so_luong_can_sua == 0) {
					System.out.println("Khong sua Sach");
					return;
				}
				if (so_luong_can_sua > Sach.length)
					return;
				while (so_luong_can_sua != 0) {
					System.out.print("Nhap Ma Sach can sua thong tin: ");
					String maso_Sach_cansua = sc.nextLine();
					Sua(maso_Sach_cansua);
					so_luong_can_sua--;
				}
			} else
				so_luong_can_sua = -1;
		}
	}

	public static newSach[] getSach() {
		return null;
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
