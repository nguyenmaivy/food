package sach;

public class newtacgia extends tacgia {
	
	public newtacgia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public newtacgia(String masotacgia, String ten, int tuoi, String gioitinh, String quequan, int trangthai) {
		super(masotacgia, ten, tuoi, gioitinh, quequan, trangthai);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void nhap() {
		while(this.getMasotacgia()==null||this.getMasotacgia().isEmpty()){
			System.out.print("Nhap Ma so Tac gia: ");
			String newmasotacgia=sc.nextLine();
			if(newmasotacgia.matches("\\d+")) {
				tacgia new_masotacgia=danhsachTacgia.Trunglap(newmasotacgia);
				if (new_masotacgia==null) {
		            this.setMasotacgia(newmasotacgia);
		            break;
				}else if(new_masotacgia!=null&&new_masotacgia.getTrangthai()==1)
					System.out.println("Trung lap tac gia - hay nhap lai");
				else {
					System.out.println("Tac gia da bi xoa du lieu - hay lua chon:");
					System.out.println("1.Khoi phuc thong tin Tac gia ");
					System.out.println("2.Khoi phuc va Sua thong tin Tac gia");
					System.out.println("3.Tao Tac gia moi");
					int luachon_1=Integer.parseInt(sc.nextLine());
					switch(luachon_1){
						case 1:danhsachTacgia.Khoiphuc(newmasotacgia);
								System.out.println("Da khoi phuc");
								return;
						case 2:danhsachTacgia.Khoiphuc(newmasotacgia);
								danhsachTacgia.Sua(newmasotacgia);
								System.out.println("Dang Sua");
								return;
						default:danhsachTacgia.Them();
								return;
					}
				}
			}
		}
		// TODO Auto-generated method stub
		super.nhap();
		while(this.getQuequan()==null||this.getQuequan().isEmpty()) {
			System.out.print("Nhap Que quan: ");
			this.setQuequan(sc.nextLine());
		}
			this.setTrangthai(1);
	}
	@Override
	public void suathongtin() {
	System.out.println("1.Sua Ma so tac gia");
	System.out.println("2.Sua Ho va Ten tac gia");
	System.out.println("3.Sua Tuoi tac gia");
	System.out.println("4.Sua Gioi tinh tac gia");
	System.out.println("5.Sua Que quan tac gia");
	System.out.print("Nhap lua chon: ");
	int luachon=Integer.parseInt(sc.nextLine());
	boolean exitLoop=false;
		switch(luachon) {
		case 1:
			while(!exitLoop) {
				System.out.println("Nhap Ma so moi cua Tac gia");
				String newmasotacgia=sc.nextLine();
				if(newmasotacgia.matches("\\d+")) {
					tacgia new_masotacgia=danhsachTacgia.Trunglap(newmasotacgia);
					if (new_masotacgia==null&&!this.getMasotacgia().equals(newmasotacgia)) {
		                this.setMasotacgia(newmasotacgia);
		                exitLoop=true;
		                break; 
					}
					else if(new_masotacgia!=null&&new_masotacgia.getTrangthai()==1){
							System.out.println("Trung lap Tac gia moi nhap lai:");
							exitLoop=false;
						} else {
							System.out.println("Tac gia da bi xoa du lieu - hay lua chon:");
							System.out.println("1.Khoi phuc Tac gia");
							System.out.println("2.Khoi phuc va Sua thong tin Tac gia");
							System.out.println("3.Thoat");
							int luachon_1=Integer.parseInt(sc.nextLine());
							switch(luachon_1){
								case 1:danhsachTacgia.Khoiphuc(newmasotacgia);
										System.out.println("Da khoi phuc");
									return;
								case 2:danhsachTacgia.Khoiphuc(newmasotacgia);
										danhsachTacgia.Sua(newmasotacgia);
										System.out.println("Dang Sua");
									return;
								default:
									return;
							}
						}
					}
			}
			break;
		case 2:while(!exitLoop){
			System.out.print("Nhap Ho va Ten moi: ");
			String newten=sc.nextLine();
			if(!newten.equals(this.getTen())) {
				this.setTen(newten);
				exitLoop=true;
			}
		}
			break;
		case 3:while(!exitLoop){
			System.out.print("Nhap Tuoi moi: ");
			String newtuoi=sc.nextLine();
				if(newtuoi.matches("\\d+")&&Integer.parseInt(newtuoi)!=this.getTuoi()&&Integer.parseInt(newtuoi)>0&&Integer.parseInt(newtuoi)<200) {
					this.setTuoi(Integer.parseInt(newtuoi));
					exitLoop=true;
				}
			}
				break;
		case 4:while(!exitLoop){
			System.out.print("Nhap Gioi tinh moi: ");
			String newgioitinh=sc.nextLine();
			if(!newgioitinh.equals(this.getGioitinh())) {
				this.setGioitinh(newgioitinh);
				exitLoop=true;
			}
		}
			break;
		case 5:
			while(!exitLoop) {
				System.out.print("Nhap que quan moi cua Tac gia: ");
				String newquequan=sc.nextLine();
				if(!newquequan.equals(this.getQuequan())) {
					this.setQuequan(newquequan);
					exitLoop=true;
				}
			}	
			break;
		default:
			break;
	}
		
}
	public void suathongtin_chopheptrunglap() {
	System.out.println("1.Sua Ma so tac gia");
	System.out.println("2.Sua Ho va Ten tac gia");
	System.out.println("3.Sua Tuoi tac gia");
	System.out.println("4.Sua Gioi tinh tac gia");
	System.out.println("5.Sua Que quan tac gia");
	System.out.print("Nhap lua chon: ");
	int luachon=Integer.parseInt(sc.nextLine());
	boolean exitLoop=false;
		switch(luachon) {
		case 1:
			while(!exitLoop) {
				tacgia new_masotacgia=new tacgia();
				System.out.print("Nhap Ma so cua tac gia: ");
				String newmasotacgia=sc.nextLine();
				if(newmasotacgia.matches("\\d+")) {
					new_masotacgia=danhsachTacgia.Trunglap(newmasotacgia);
					if(!exitLoop&&this.getMasotacgia()!=null&&!newmasotacgia.equals(this.getMasotacgia())) {
						if(new_masotacgia==null) {
							this.setMasotacgia(newmasotacgia);
			                exitLoop=true;
			                break; 
						}else {
							if(new_masotacgia.getTrangthai()==1) {
								System.out.println("Trung lap du lieu - hay lua chon:");
								System.out.println("1.Nhan thong tin Tac gia ");
								System.out.println("2.Sua thong tin Tac gia");
								System.out.println("3.Thoat");
								int luachon_1=Integer.parseInt(sc.nextLine());
								switch(luachon_1){
									case 1:System.out.println("Da khoi phuc");
										break;
									case 2:new_masotacgia=danhsachTacgia.Sua(newmasotacgia);
											System.out.println("Dang Sua");
											break;
									default:
											return;
								}
							}
							else {
								System.out.println("Tac gia da bi xoa du lieu - hay lua chon:");
								System.out.println("1.Khoi phuc va Nhan thong tin Tac gia ");
								System.out.println("2.Khoi phuc - Nhan va Sua thong tin Tac gia");
								System.out.println("3.Thoat");
								int luachon_1=Integer.parseInt(sc.nextLine());
								switch(luachon_1){
									case 1:new_masotacgia=danhsachTacgia.Khoiphuc(newmasotacgia);
											System.out.println("Da khoi phuc");
											break;
									case 2:danhsachTacgia.Khoiphuc(newmasotacgia);
											new_masotacgia=danhsachTacgia.Sua(newmasotacgia);
											System.out.println("Dang Sua");
											break;
									default:
											return;
								}
							}
						}
					}
					if(new_masotacgia!=null) {
							capnhattacgia(new_masotacgia.getMasotacgia(),new_masotacgia.getTen(),new_masotacgia.getTuoi(),new_masotacgia.getGioitinh(),new_masotacgia.getQuequan(),1);
							exitLoop=true;
							return;

					}
				}
			}
			break;
			case 2:while(!exitLoop){
				System.out.print("Nhap Ho va Ten moi: ");
				String newten=sc.nextLine();
				if(!newten.equals(this.getTen())) {
					this.setTen(newten);
					exitLoop=true;
				}
			}
				break;
			case 3:while(!exitLoop){
				System.out.print("Nhap Tuoi moi: ");
				String newtuoi=sc.nextLine();
					if(newtuoi.matches("\\d+")&&Integer.parseInt(newtuoi)!=this.getTuoi()&&Integer.parseInt(newtuoi)>0&&Integer.parseInt(newtuoi)<200) {
						this.setTuoi(Integer.parseInt(newtuoi));
						exitLoop=true;
					}
				}
					break;
			case 4:while(!exitLoop){
				System.out.print("Nhap Gioi tinh moi: ");
				String newgioitinh=sc.nextLine();
				if(!newgioitinh.equals(this.getGioitinh())) {
					this.setGioitinh(newgioitinh);
					exitLoop=true;
				}
			}
				break;
			case 5:
				while(!exitLoop) {
					System.out.print("Nhap que quan moi cua Tac gia: ");
					String newquequan=sc.nextLine();
					if(!newquequan.equals(this.getQuequan())) {
						this.setQuequan(newquequan);
						exitLoop=true;
					}
				}	
				break;
			default:
				break;
		}
			
	}
	@Override
	public String xuat() {
		// TODO Auto-generated method stub
		return super.xuat();
	}
}
