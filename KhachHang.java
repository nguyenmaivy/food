package sach;

import java.util.Scanner;

public class KhachHang extends ConNguoi {
	public Scanner sc = new Scanner(System.in);
	// thuoc tinh
	private String id;
	public int trangThai;

	// constructor
	public KhachHang(String id, String ten, int trangThai, String gioitinh, int tuoi) {
		super(ten, tuoi, gioitinh);
		this.id = id;
		this.trangThai = trangThai;
	}

	public KhachHang() {
		super();
	}

	// getter_setter
	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// cac phuong thuc nhap_xuat
	@Override
	public void nhap() {
		while (this.id == null || this.id.isEmpty()) {
			System.out.print("Nhap ma so khach hang: ");
			String newId = sc.nextLine();
			if (newId.matches("\\d+")) {
				this.id = newId;
			}
		}
		super.nhap();
		this.trangThai = 1;
		System.out.println("-------------------");
	}

	@Override
	public void suathongtin() {
		System.out.println("1.Sua ID khach hang");
		System.out.println("2.Sua Ho va Ten khach hang");
		System.out.println("3.Sua Tuoi khach hang");
		System.out.println("4.Sua Gioi tinh khach hang");
		System.out.println("Nhap lua chon: ");
		int chon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;
		switch (chon) {
			case 1:
				while (!exitLoop) {
					System.out.println("Nhap Ma so moi cua Tac gia");
					String newId = sc.nextLine();
					if (newId.matches("\\d+")) {
						if (!this.id.equals(newId)) {
							this.id = newId;
							exitLoop = true;
							break;
						}
					}
				}
				break;
			case 2:
				while (!exitLoop) {
					System.out.print("Nhap Ho va Ten moi: ");
					String newTen = sc.nextLine();
					if (!newTen.equals(this.getTen())) {
						this.setTen(newTen);
						exitLoop = true;
					}
				}
				break;
			case 3:
				while (!exitLoop) {
					System.out.print("Nhap Tuoi moi: ");
					String newTuoi = sc.nextLine();
					if (newTuoi.matches("\\d+") && Integer.parseInt(newTuoi) != this.getTuoi()
							&& Integer.parseInt(newTuoi) > 0 && Integer.parseInt(newTuoi) < 200) {
						this.setTuoi(Integer.parseInt(newTuoi));
						exitLoop = true;
					}
				}
				break;
			case 4:
				while (!exitLoop) {
					System.out.print("Nhap Gioi tinh moi: ");
					String newGioiTinh = sc.nextLine();
					if (!newGioiTinh.equals(this.getGioitinh())) {
						this.setGioitinh(newGioiTinh);
						exitLoop = true;
					}
				}
				break;

			default:
				break;
		}
	}

	public void capNhatKhachHang(String id, String ten, int tuoi, String gioiTinh) {
		this.setTen(ten);
		this.setTuoi(tuoi);
		this.setGioitinh(gioiTinh);
		this.id = id;
	}

	@Override
	public String xuat() {
		return String.format("|ID-KH: %-5s|%s|", id, super.xuat());
	}
}
