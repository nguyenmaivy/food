package sach;

import java.util.*;
import java.io.*;

public class danhsachTacGia implements DanhSach {

	public static Scanner sc = new Scanner(System.in);
	private static int soluong = 0;
	private static newTacGia TacGia[];

	public danhsachTacGia() {
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

			System.out.print("Nhap so luong tac gia: ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+"))
				soluong = Integer.parseInt(sl);
			else
				soluong = 0;

		}

		TacGia = new newTacGia[soluong];

		for (int i = 0; i < TacGia.length; i++) {
			TacGia[i] = new newTacGia();
			System.out.println("Nhap thong tin tac gia:");
			TacGia[i].nhap();
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

				if (TacGia == null)
					TacGia = new newTacGia[1];
				else
					TacGia = Arrays.copyOf(TacGia, TacGia.length + 1);

				i = TacGia.length - 1;

				if (text.length == 5 && text[0].matches("\\d+") && Trunglap(text[0]) == null
						&& !text[1].matches(".*\\d.*") && text[2].matches("\\d+")) {
					if (TacGia[i] == null)
						TacGia[i] = new newTacGia(text[0], text[1], Integer.parseInt(text[2]), text[3], text[4], 1);
					// TacGia[i].capnhatTacGia(text[0],text[1], Integer.parseInt(text[2]), text[3],
					// text[4], 1);
					i++;
				} else
					TacGia = Arrays.copyOf(TacGia, TacGia.length - 1);

			}

			soluong = TacGia.length;
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
			FileWriter bin = new FileWriter("D:\\java\\java_project\\food\\sach\\TacGia_recyclebin.txt");

			int i = 0;

			if (TacGia == null) {
				System.out.println("Danh sach rong");
				writefile.close();
				bin.close();
				return;
			}

			while (i < TacGia.length && TacGia[i] != null) {

				if (TacGia[i].trangthai == 1)
					writefile.write(TacGia[i].getMasoTacGia() + "#" + TacGia[i].getTen() + "#" + TacGia[i].getTuoi()
							+ "#" + TacGia[i].getGioitinh() + "#" + TacGia[i].getQuequan() + "\n");
				else
					bin.write(TacGia[i].getMasoTacGia() + "#" + TacGia[i].getTen() + "#" + TacGia[i].getTuoi() + "#"
							+ TacGia[i].getGioitinh() + "#" + TacGia[i].getQuequan() + "\n");

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
	public static newTacGia Trunglap(String masoTacGia) {
		if (TacGia == null || TacGia[0] == null)
			return null;

		for (int i = 0; i < TacGia.length; i++)
			if (TacGia[i] != null)
				if (TacGia[i].getMasoTacGia() != null && TacGia[i].getMasoTacGia().equals(masoTacGia))
					return TacGia[i];

		return null;

	}

	// xuất thông tin
	public void xuatdanhsach() {

		if (TacGia == null) {
			System.out.println("Khong co tac gia nao");
			return;
		}

		for (int i = 0; i < TacGia.length; i++) {
			if (TacGia[i] != null && TacGia[i].trangthai == 1) {
				System.out.println("");
				System.out.println(TacGia[i].xuat());
			}
		}

	}

	// sắp xếp theo mã tác giả
	public static newTacGia[] Sapxep_ma() {
		if (TacGia == null || TacGia.length <= 1)
			return TacGia;

		newTacGia TacGia_sapxep[] = Arrays.copyOf(TacGia, TacGia.length);
		newTacGia tmp;

		for (int i = 0; i < TacGia_sapxep.length; i++) {
			for (int j = 0; j < TacGia_sapxep.length - i - 1; j++) {
				int masoTacGia1 = Integer.parseInt(TacGia_sapxep[j].getMasoTacGia());
				int masoTacGia2 = Integer.parseInt(TacGia_sapxep[j + 1].getMasoTacGia());

				if (masoTacGia1 > masoTacGia2) {
					tmp = TacGia_sapxep[j];
					TacGia_sapxep[j] = TacGia_sapxep[j + 1];
					TacGia_sapxep[j + 1] = tmp;
				}
			}
		}
		return TacGia_sapxep;
	}

	public void SapxepTheoMa() {
		if (TacGia == null)
			return;

		newTacGia TacGia_sapxep[] = Arrays.copyOf(Sapxep_ma(), Sapxep_ma().length);

		for (int i = 0; i < TacGia_sapxep.length; i++) {
			if (TacGia_sapxep[i] != null && TacGia_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(TacGia_sapxep[i].xuat());
			}

		}
	}

	// sắp xếp theo tên tác giả
	public static newTacGia[] Sapxep_ten() {
		if (TacGia == null)
			return null;

		newTacGia TacGia_sapxep[] = Arrays.copyOf(TacGia, TacGia.length);
		newTacGia tmp;

		for (int i = 0; i < TacGia_sapxep.length; i++) {
			for (int j = 0; j < TacGia_sapxep.length - i - 1; j++) {
				String kyTu1 = TacGia_sapxep[j].getTen().substring(0, 1).toLowerCase();
				String kyTu2 = TacGia_sapxep[j + 1].getTen().substring(0, 1).toLowerCase();

				if (kyTu1.compareTo(kyTu2) > 0) {
					tmp = TacGia_sapxep[j];
					TacGia_sapxep[j] = TacGia_sapxep[j + 1];
					TacGia_sapxep[j + 1] = tmp;
				}
			}
		}
		return TacGia_sapxep;
	}

	public void SapxepTheoTen() {
		if (TacGia == null)
			return;

		newTacGia TacGia_sapxep[] = Arrays.copyOf(Sapxep_ten(), Sapxep_ten().length);

		for (int i = 0; i < TacGia_sapxep.length; i++) {

			if (TacGia_sapxep[i] != null && TacGia_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(TacGia_sapxep[i].xuat());
			}

		}
	}

	// thêm thông tin đối tượng
	public static newTacGia Them() {
		int i;

		if (TacGia == null)
			TacGia = new newTacGia[1];
		else
			TacGia = Arrays.copyOf(TacGia, TacGia.length + 1);

		i = TacGia.length - 1;
		TacGia[i] = new newTacGia();

		System.out.println("nhap thong tin tac gia");

		TacGia[i].nhap();
		soluong = TacGia.length;

		return TacGia[i];

	}

	public static void ThemTacGia() {
		int so_luong_can_them = -1;

		while (so_luong_can_them == -1) {

			System.out.print("Nhap so luong tac gia can them: ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				so_luong_can_them = Integer.parseInt(sl);

				if (so_luong_can_them == 0) {
					if (TacGia == null)
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
	public static int Timkiem(String masoTacGia) {
		for (int i = 0; i < TacGia.length; i++) {
			if (TacGia[i].trangthai == 1 && TacGia[i].getMasoTacGia() != null
					&& TacGia[i].getMasoTacGia().equals(masoTacGia))
				return i;
		}

		return -1;
	}

	public static void TimkiemTacGia() {
		System.out.print("Nhap ma so tac gia can tim: ");
		String masoTacGia = sc.nextLine();

		int i = Timkiem(masoTacGia);

		while (i == -1) {

			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");

			int luachon = Integer.parseInt(sc.nextLine());

			if (luachon == 1)
				TimkiemTacGia();
			else
				return;

		}

		System.out.println(TacGia[i].xuat());

	}

	// xóa thông tin(xóa giả => ẩn thông tin)
	public static void Xoa() {
		System.out.print("Nhap ma tac gia can xoa: ");
		String masoTacGia = sc.nextLine();

		int i = Timkiem(masoTacGia);

		if (i == -1) {

			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");

			int luachon = Integer.parseInt(sc.nextLine());

			if (luachon == 1)
				Xoa();

		} else {
			TacGia[i].trangthai = 0;
			return;
		}

	}

	public static void XoaTacGia() {
		if (TacGia == null) {
			System.out.println("Danh sach rong");
			return;
		}

		int so_luong_can_xoa = -1;

		while (so_luong_can_xoa == -1) {

			System.out.print("Nhap so luong tac gia can xoa (Khong vuot qua " + TacGia.length + "): ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				so_luong_can_xoa = Integer.parseInt(sl);

				if (so_luong_can_xoa == 0) {
					System.out.println("Khong xoa Tac gia");
					return;
				}

				if (so_luong_can_xoa > TacGia.length)
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
	public static newTacGia Khoiphuc(String maTacGia_cankhoiphuc) {
		int i;
		for (i = 0; i < TacGia.length; i++)
			if (TacGia[i].getMasoTacGia() != null && TacGia[i].getMasoTacGia().equals(maTacGia_cankhoiphuc)
					&& TacGia[i].trangthai == 0) {
				TacGia[i].trangthai = 1;
				return TacGia[i];
			}

		return null;
	}

	public static void KhoiphucTacGia() {
		if (TacGia == null) {
			System.out.println("Danh sach rong");
			return;
		}

		int soluong_TacGia_cankhoiphuc = -1;

		while (soluong_TacGia_cankhoiphuc == -1) {

			System.out.print("Nhap so luong tac gia can khoi phuc (Khong vuot qua " + TacGia.length + "): ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				soluong_TacGia_cankhoiphuc = Integer.parseInt(sl);
				if (soluong_TacGia_cankhoiphuc > TacGia.length)
					return;
				for (int i = 0; i < soluong_TacGia_cankhoiphuc; i++) {
					System.out.print("Nhap ma tac gia can khoi phuc: ");
					String maTacGia_cankhoiphuc = sc.nextLine();
					Khoiphuc(maTacGia_cankhoiphuc);
				}
			} else
				soluong_TacGia_cankhoiphuc = -1;
		}
	}

	// sửa thông tin
	public static newTacGia Sua(String maso_TacGia_cansua) {
		int i = Timkiem(maso_TacGia_cansua);

		if (i == -1) {

			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");

			int luachon = Integer.parseInt(sc.nextLine());
			if (luachon == 1) {
				System.out.print("Nhap Ma so tac gia can sua thong tin: ");
				return Sua(sc.nextLine());
			} else
				return null;
		}

		int so_luong_thong_tin_can_sua = -1;

		while (so_luong_thong_tin_can_sua == -1) {
			System.out.print("Ban muon sua bao nhieu thong tin cua tac gia (toi da 5): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				so_luong_thong_tin_can_sua = Integer.parseInt(sl);
				if (so_luong_thong_tin_can_sua > 5)
					return null;
				while (so_luong_thong_tin_can_sua != 0) {
					System.out.println("Sua thong tin cua tac gia '" + TacGia[i].getTen() + "'");
					TacGia[i].suathongtin();
					so_luong_thong_tin_can_sua--;
				}
			} else
				so_luong_thong_tin_can_sua = -1;
		}
		return TacGia[i];
	}

	public static void SuaTacGia() {
		if (TacGia == null) {
			System.out.println("Danh sach rong");
			return;
		}
		int so_luong_can_sua = -1;
		while (so_luong_can_sua == -1) {
			System.out.print("Nhap so luong tac gia can sua (Khong vuot qua " + TacGia.length + "): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				so_luong_can_sua = Integer.parseInt(sl);
				if (so_luong_can_sua == 0) {
					System.out.println("Khong sua tac gia");
					return;
				}
				if (so_luong_can_sua > TacGia.length)
					return;
				while (so_luong_can_sua != 0) {
					System.out.print("Nhap ma so tac gia can sua: ");
					String maso_TacGia_cansua = sc.nextLine();
					Sua(maso_TacGia_cansua);
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
