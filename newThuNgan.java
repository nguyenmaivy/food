package sach;

public class newThuNgan extends ThuNgan {
	public newThuNgan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public newThuNgan(double DSBH, String quayTT, String maNV, String chucVu, double luong, int trangthai, String ten,
			int tuoi, String gioitinh) {
		super(DSBH, quayTT, maNV, chucVu, luong, trangthai, ten, tuoi, gioitinh);

	}

	@Override
	public void nhap() {

		while (this.getMaNV() == null || this.getMaNV().isEmpty()) {

			System.out.print("Nhap Ma so Thu Ngan( bat dau bang TN... VD: TN123): ");
			String newMaNV = sc.nextLine();

			if (newMaNV.matches("^TN\\d+")) {
				ThuNgan new_MaNV = danhsachThuNgan.Trunglap(newMaNV);

				if (new_MaNV == null) {
					this.setMaNV(newMaNV);
					break;

				} else if (new_MaNV != null && new_MaNV.getTrangthai() == 1)
					System.out.println("Trung lap Thu Ngan - hay nhap lai");

				else {
					System.out.println("Thu Ngan da bi xoa du lieu - hay lua chon:");
					System.out.println("1.Khoi phuc thong tin Thu Ngan ");
					System.out.println("2.Khoi phuc va Sua thong tin Thu Ngan");
					System.out.println("3.Tao Thu Ngan moi");

					int luachon_1 = Integer.parseInt(sc.nextLine());

					switch (luachon_1) {

						case 1:
							danhsachThuNgan.Khoiphuc(newMaNV);
							System.out.println("Da khoi phuc");
							return;

						case 2:
							danhsachThuNgan.Khoiphuc(newMaNV);
							danhsachThuNgan.Sua(newMaNV);
							System.out.println("Dang Sua");
							return;

						default:
							danhsachThuNgan.Them();
							return;

					}
				}
			}
		}

		while (this.getTen() == null || this.getTen().isEmpty()) {

			System.out.print("Nhap Ho va Ten: ");
			String newten = sc.nextLine();

			if (!newten.matches(".*\\d.*"))
				this.setTen(newten);

			else
				this.setTen(null);

		}
		while (this.getTuoi() <= 0 || this.getTuoi() > 200) {

			System.out.print("Nhap Tuoi: ");
			String newtuoi = sc.nextLine();

			if (newtuoi.matches("\\d+"))
				this.setTuoi(Integer.parseInt(newtuoi));

			else
				this.setTuoi(0);

		}
		while (this.getGioitinh() == null || this.getGioitinh().isEmpty()) {

			System.out.print("Nhap Gioi tinh: ");
			this.setGioitinh(sc.nextLine());

		}
		while (true) {

			String newchucVu = sc.nextLine();
			boolean check = setChucVu(newchucVu);

			if (check) {
				break;
			}

		}

		while (true) {

			double newluong = Double.parseDouble(sc.nextLine());
			boolean check = setLuong(newluong);

			if (check) {
				break;
			}

		}

		this.trangthai = 1;
	}

	@Override
	public void suathongtin() {

		System.out.println("1.Sua Ma so Thu Ngan");
		System.out.println("2.Sua Ho va Ten Thu Ngan");
		System.out.println("3.Sua Tuoi Thu Ngan");
		System.out.println("4.Sua Gioi tinh Thu Ngan");
		System.out.println("5.Sua Chuc vu Thu Ngan");
		System.out.println("6.Sua Quay thanh toan Thu Ngan");
		System.out.println("7.Sua Luong Thu Ngan");
		System.out.print("Nhap lua chon: ");

		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;

		switch (luachon) {

			case 1:
				while (!exitLoop) {

					System.out.print("Nhap Ma so moi cua Thu Ngan( bat dau bang TN... VD: TN123): ");
					String newMaNV = sc.nextLine();

					if (newMaNV.matches("^TN\\d+")) {
						ThuNgan new_MaNV = danhsachThuNgan.Trunglap(newMaNV);

						if (new_MaNV == null && !this.getMaNV().equals(newMaNV)) {
							this.setMaNV(newMaNV);
							exitLoop = true;
							break;

						} else if (new_MaNV != null && new_MaNV.getTrangthai() == 1) {
							System.out.println("Trung lap Thu Ngan moi nhap lai:");
							exitLoop = false;

						} else {
							System.out.println("Thu Ngan da bi xoa du lieu - hay lua chon:");
							System.out.println("1.Khoi phuc Thu Ngan");
							System.out.println("2.Khoi phuc va Sua thong tin Thu Ngan");
							System.out.println("3.Thoat");

							int luachon_1 = Integer.parseInt(sc.nextLine());

							switch (luachon_1) {

								case 1:
									danhsachThuNgan.Khoiphuc(newMaNV);
									System.out.println("Da khoi phuc");
									return;

								case 2:
									danhsachThuNgan.Khoiphuc(newMaNV);
									danhsachThuNgan.Sua(newMaNV);
									System.out.println("Dang Sua");
									return;

								default:
									return;

							}
						}
					}
				}
				break;
			case 2:
				while (!exitLoop) {

					System.out.print("Nhap Ho va Ten moi: ");
					String newten = sc.nextLine();

					if (!newten.equals(this.getTen())) {
						this.setTen(newten);
						exitLoop = true;
					}

				}
				break;
			case 3:
				while (!exitLoop) {

					System.out.print("Nhap Tuoi moi: ");
					String newtuoi = sc.nextLine();

					if (newtuoi.matches("\\d+") && Integer.parseInt(newtuoi) != this.getTuoi()
							&& Integer.parseInt(newtuoi) > 0 && Integer.parseInt(newtuoi) < 200) {
						this.setTuoi(Integer.parseInt(newtuoi));
						exitLoop = true;
					}

				}
				break;
			case 4:
				while (!exitLoop) {

					System.out.print("Nhap Gioi tinh moi: ");
					String newgioitinh = sc.nextLine();

					if (!newgioitinh.equals(this.getGioitinh())) {
						this.setGioitinh(newgioitinh);
						exitLoop = true;
					}

				}
				break;
			case 5:
				while (!exitLoop) {

					System.out.print("Nhap chuc vu moi cua Thu Ngan: ");
					String newchucvu = sc.nextLine();

					if (!newchucvu.equals(this.getChucVu())) {
						this.setChucVu(newchucvu);
						exitLoop = true;
					}

				}
				break;
			case 6:
				while (!exitLoop) {

					System.out.print("Nhap quay thanh toan moi cua Thu Ngan: ");
					String newquayTT = sc.nextLine();

					if (!newquayTT.equals(this.getQuayTT())) {
						this.setQuayTT(newquayTT);
						exitLoop = true;
					}

				}
				break;
			case 7:
				while (!exitLoop) {

					System.out.print("Nhap Luong moi cua Thu Ngan: ");
					String newLuong = sc.nextLine();

					if (newLuong.matches("\\d+\\d*\\.?\\,?") && Double.parseDouble(newLuong) != this.getLuong()) {
						this.setLuong(Integer.parseInt(newLuong));
						exitLoop = true;
					}

				}
				break;
			default:
				break;
		}
	}
}
