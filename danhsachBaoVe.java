package sach;

import java.util.*;
import java.io.*;

public class danhsachBaoVe implements DanhSach {

	public static Scanner sc = new Scanner(System.in);
	private static int soluong = 0;
	private static newBaoVe BaoVe[];

	public danhsachBaoVe() {
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

			System.out.print("Nhap so luong Bao Ve: ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+"))
				soluong = Integer.parseInt(sl);
			else
				soluong = 0;

		}

		BaoVe = new newBaoVe[soluong];

		for (int i = 0; i < BaoVe.length; i++) {
			BaoVe[i] = new newBaoVe();
			System.out.println("Nhap thong tin Bao Ve:");
			BaoVe[i].nhap();
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

				if (BaoVe == null)
					BaoVe = new newBaoVe[1];
				else
					BaoVe = Arrays.copyOf(BaoVe, BaoVe.length + 1);

				i = BaoVe.length - 1;

				if (text.length == 7 && text[1].matches("^BV.*") && Trunglap(text[1]) == null
						&& !text[4].matches(".*\\d.*") && text[5].matches("\\d+")) {
					if (BaoVe[i] == null)
						BaoVe[i] = new newBaoVe(text[0], text[1], text[2], Double.parseDouble(text[3]), 1, text[4],
								Integer.parseInt(text[5]), text[6]);
					// BaoVe[i].capnhatBaoVe(text[0],text[1], Integer.parseInt(text[2]), text[3],
					// text[4], 1);
					i++;

				} else
					BaoVe = Arrays.copyOf(BaoVe, BaoVe.length - 1);

			}

			soluong = BaoVe.length;
			br.close();
			readfile.close();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void ghifile(String filename) {
		try {

			FileWriter writefile = new FileWriter(filename);
			FileWriter bin = new FileWriter("D:\\java\\java_project\\food\\sach\\BaoVe_recyclebin.txt");

			int i = 0;

			if (BaoVe == null) {
				System.out.println("Danh sach rong");
				writefile.close();
				bin.close();
				return;
			}

			while (i < BaoVe.length && BaoVe[i] != null) {

				if (BaoVe[i].trangthai == 1)
					writefile.write(BaoVe[i].getKynang() + "#" + BaoVe[i].getMaNV() + "#" + BaoVe[i].getChucVu() + "#"
							+ BaoVe[i].getLuong() + "#" + BaoVe[i].getTen() + "#" + BaoVe[i].getTuoi() + "#"
							+ BaoVe[i].getGioitinh() + "\n");

				else
					bin.write(BaoVe[i].getKynang() + "#" + BaoVe[i].getMaNV() + "#" + BaoVe[i].getChucVu() + "#"
							+ BaoVe[i].getLuong() + "#" + BaoVe[i].getTen() + "#" + BaoVe[i].getTuoi() + "#"
							+ BaoVe[i].getGioitinh() + "\n");

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
	public static newBaoVe Trunglap(String masoBaoVe) {
		if (BaoVe == null || BaoVe[0] == null)
			return null;

		for (int i = 0; i < BaoVe.length; i++)
			if (BaoVe[i] != null)
				if (BaoVe[i].getMaNV() != null && BaoVe[i].getMaNV().equals(masoBaoVe))
					return BaoVe[i];

		return null;
	}

	// xuất thông tin
	public void xuatdanhsach() {
		if (BaoVe == null) {
			System.out.println("Khong co Bao Ve nao");
			return;
		}

		for (int i = 0; i < BaoVe.length; i++) {
			if (BaoVe[i] != null && BaoVe[i].trangthai == 1) {
				System.out.println("");
				System.out.println(BaoVe[i].xuat());
			}
		}
	}

	public static newBaoVe[] Sapxep_ma() {
		if (BaoVe == null)
			return null;

		newBaoVe BaoVe_sapxep[] = Arrays.copyOf(BaoVe, BaoVe.length);
		newBaoVe tmp;

		for (int i = 0; i < BaoVe_sapxep.length; i++) {
			for (int j = i + 1; j < BaoVe_sapxep.length; j++) {
				if (Integer.parseInt(BaoVe_sapxep[i].getMaNV().substring(2)) > Integer
						.parseInt(BaoVe_sapxep[j].getMaNV().substring(2))) {
					tmp = BaoVe_sapxep[i];
					BaoVe_sapxep[i] = BaoVe_sapxep[j];
					BaoVe_sapxep[j] = tmp;
				}

			}
		}
		return BaoVe_sapxep;
	}

	public void SapxepTheoMa() {
		if (BaoVe == null)
			return;

		newBaoVe BaoVe_sapxep[] = Arrays.copyOf(Sapxep_ma(), Sapxep_ma().length);

		for (int i = 0; i < BaoVe_sapxep.length; i++) {

			if (BaoVe_sapxep[i] != null && BaoVe_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(BaoVe_sapxep[i].xuat());
			}

		}
	}

	public static newBaoVe[] Sapxep_ten() {
		if (BaoVe == null)
			return null;

		newBaoVe BaoVe_sapxep[] = Arrays.copyOf(BaoVe, BaoVe.length);
		newBaoVe tmp;

		for (int i = 0; i < BaoVe_sapxep.length; i++) {
			for (int j = 0; j < BaoVe_sapxep.length - i - 1; j++) {
				String kyTu1 = BaoVe_sapxep[j].getTen().substring(0, 1).toLowerCase();
				String kyTu2 = BaoVe_sapxep[j + 1].getTen().substring(0, 1).toLowerCase();

				if (kyTu1.compareTo(kyTu2) > 0) {
					tmp = BaoVe_sapxep[j];
					BaoVe_sapxep[j] = BaoVe_sapxep[j + 1];
					BaoVe_sapxep[j + 1] = tmp;
				}
			}
		}
		return BaoVe_sapxep;
	}

	public void SapxepTheoTen() {
		if (BaoVe == null)
			return;

		newBaoVe BaoVe_sapxep[] = Arrays.copyOf(Sapxep_ten(), Sapxep_ten().length);

		for (int i = 0; i < BaoVe_sapxep.length; i++) {

			if (BaoVe_sapxep[i] != null && BaoVe_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(BaoVe_sapxep[i].xuat());
			}

		}
	}

	// thêm thông tin đối tượng
	public static newBaoVe Them() {
		int i;

		if (BaoVe == null)
			BaoVe = new newBaoVe[1];

		else
			BaoVe = Arrays.copyOf(BaoVe, BaoVe.length + 1);

		i = BaoVe.length - 1;
		BaoVe[i] = new newBaoVe();

		System.out.println("nhap thong tin Bao Ve");

		BaoVe[i].nhap();
		soluong = BaoVe.length;

		return BaoVe[i];
	}

	public static void ThemBaoVe() {
		int so_luong_can_them = -1;

		while (so_luong_can_them == -1) {

			System.out.print("Nhap so luong Bao Ve can them: ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				so_luong_can_them = Integer.parseInt(sl);

				if (so_luong_can_them == 0) {
					if (BaoVe == null)
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
	public static int Timkiem(String masoBaoVe) {
		for (int i = 0; i < BaoVe.length; i++) {
			if (BaoVe[i].trangthai == 1 && BaoVe[i].getMaNV() != null && BaoVe[i].getMaNV().equals(masoBaoVe))
				return i;
		}

		return -1;

	}

	public static void TimkiemBaoVe() {
		System.out.print("Nhap ma so Bao Ve can tim: ");
		String masoBaoVe = sc.nextLine();

		int i = Timkiem(masoBaoVe);

		while (i == -1) {

			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");

			int luachon = Integer.parseInt(sc.nextLine());

			if (luachon == 1)
				TimkiemBaoVe();

			else
				return;

		}

		System.out.println(BaoVe[i].xuat());

	}

	// xóa thông tin(xóa giả => ẩn thông tin)
	public static void Xoa() {
		System.out.print("Nhap ma Bao Ve can xoa: ");
		String masoBaoVe = sc.nextLine();

		int i = Timkiem(masoBaoVe);

		if (i == -1) {

			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");

			int luachon = Integer.parseInt(sc.nextLine());

			if (luachon == 1)
				Xoa();

		} else {
			BaoVe[i].trangthai = 0;
			return;
		}

	}

	public static void XoaBaoVe() {
		if (BaoVe == null) {
			System.out.println("Danh sach rong");
			return;
		}

		int so_luong_can_xoa = -1;

		while (so_luong_can_xoa == -1) {

			System.out.print("Nhap so luong Bao Ve can xoa (Khong vuot qua " + BaoVe.length + "): ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				so_luong_can_xoa = Integer.parseInt(sl);

				if (so_luong_can_xoa == 0) {
					System.out.println("Khong xoa Bao Ve");
					return;
				}

				if (so_luong_can_xoa > BaoVe.length)
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
	public static newBaoVe Khoiphuc(String maBaoVe_cankhoiphuc) {
		int i;

		for (i = 0; i < BaoVe.length; i++)
			if (BaoVe[i].getMaNV() != null && BaoVe[i].getMaNV().equals(maBaoVe_cankhoiphuc)
					&& BaoVe[i].trangthai == 0) {
				BaoVe[i].trangthai = 1;
				return BaoVe[i];
			}

		return null;
	}

	public static void KhoiphucBaoVe() {
		if (BaoVe == null) {
			System.out.println("Danh sach rong");
			return;
		}

		int soluong_BaoVe_cankhoiphuc = -1;

		while (soluong_BaoVe_cankhoiphuc == -1) {

			System.out.print("Nhap so luong Bao Ve can khoi phuc (Khong vuot qua " + BaoVe.length + "): ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				soluong_BaoVe_cankhoiphuc = Integer.parseInt(sl);

				if (soluong_BaoVe_cankhoiphuc > BaoVe.length)
					return;

				for (int i = 0; i < soluong_BaoVe_cankhoiphuc; i++) {

					System.out.print("Nhap ma Bao Ve can khoi phuc: ");
					String maBaoVe_cankhoiphuc = sc.nextLine();

					Khoiphuc(maBaoVe_cankhoiphuc);
				}

			} else
				soluong_BaoVe_cankhoiphuc = -1;
		}

	}

	// sửa thông tin
	public static newBaoVe Sua(String maso_BaoVe_cansua) {
		int i = Timkiem(maso_BaoVe_cansua);

		if (i == -1) {

			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");

			int luachon = Integer.parseInt(sc.nextLine());

			if (luachon == 1) {
				System.out.print("Nhap Ma so Bao Ve can sua thong tin: ");
				return Sua(sc.nextLine());

			} else
				return null;

		}

		int so_luong_thong_tin_can_sua = -1;

		while (so_luong_thong_tin_can_sua == -1) {

			System.out.print("Ban muon sua bao nhieu thong tin cua Bao Ve (toi da 5): ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				so_luong_thong_tin_can_sua = Integer.parseInt(sl);

				if (so_luong_thong_tin_can_sua > 5)
					return null;

				while (so_luong_thong_tin_can_sua != 0) {
					System.out.println("Sua thong tin cua Bao Ve '" + BaoVe[i].getTen() + "'");
					BaoVe[i].suathongtin();
					so_luong_thong_tin_can_sua--;
				}

			} else
				so_luong_thong_tin_can_sua = -1;
		}

		return BaoVe[i];
	}

	public static void SuaBaoVe() {
		if (BaoVe == null) {
			System.out.println("Danh sach rong");
			return;
		}

		int so_luong_can_sua = -1;

		while (so_luong_can_sua == -1) {
			System.out.print("Nhap so luong Bao Ve can sua (Khong vuot qua " + BaoVe.length + "): ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				so_luong_can_sua = Integer.parseInt(sl);

				if (so_luong_can_sua == 0) {
					System.out.println("Khong sua Bao Ve");
					return;
				}

				if (so_luong_can_sua > BaoVe.length)
					return;

				while (so_luong_can_sua != 0) {
					System.out.print("Nhap ma so Bao Ve can sua: ");
					String maso_BaoVe_cansua = sc.nextLine();
					Sua(maso_BaoVe_cansua);
					so_luong_can_sua--;
				}

			} else
				so_luong_can_sua = -1;
		}
	}

	@Override
	public void docFile(String filename) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'docFile'");
	}

	@Override
	public void ghiFile(String filename) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'ghiFile'");
	}

}
