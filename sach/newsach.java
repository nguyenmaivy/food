package sach;
// import com.example.otherpackage.*;/
public class newsach extends sach {

	public newsach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public newsach(String tensach, String masach, newtacgia tacgia, newNXB NXB, newtheloai theloai, double giaban,
			int soluong, int trangthai) {
		super(tensach, masach, tacgia, NXB, theloai, giaban, soluong, trangthai);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void nhap() {
		while(this.getTensach()==null||this.getTensach().isEmpty()) {
			System.out.print("Nhap Ten sach: ");
			this.setTensach(sc.nextLine());
		}
		while(this.getMasach()==null||this.getMasach().isEmpty()){
			System.out.print("Nhap ma sach: ");
			String newmasach=sc.nextLine();
			sach new_masach=danhsachSach.Trunglap(newmasach);
			if (new_masach==null) {
                this.setMasach(newmasach);
                break;
			}else if(new_masach!=null&&new_masach.getTrangthai()==1)
				System.out.println("Trung lap ma sach - hay nhap lai");     
		}
		System.out.println();
		while(this.getTacgia()==null) {
			this.setTacgia(new newtacgia());
			if(danhsachTacgia.getSoluong()==0) {
				this.setTacgia(danhsachTacgia.Them());
				break;
			}
			System.out.print("Nhap Ma so Tac gia: ");
			String newtentacgia=sc.nextLine();
			this.setTacgia(danhsachTacgia.Trunglap(newtentacgia));
			if(this.getTacgia()==null) {
				System.out.println("Tac gia chua co trong danh sach - hay tao Tac gia");
				this.setTacgia(danhsachTacgia.Them());
				break;
			}
			else if(this.getTacgia().getTrangthai()==1){
				System.out.println("Trung lap Tac gia- hay lua chon:");
				System.out.println("1.Nhan thong tin Tac gia");
				System.out.println("2.Sua thong tin Tac gia");
				System.out.println("3.Tao Tac gia moi");
				int luachon=Integer.parseInt(sc.nextLine());
					switch(luachon){
					case 1:System.out.println("Da nhan thong tin");
							break;
					case 2:System.out.println("Dang Sua");
							this.setTacgia(danhsachTacgia.Sua(newtentacgia));
							break;
					default:
							this.setTacgia(danhsachTacgia.Them());
							break;
					}				
				}
				else {
					System.out.println("Tac gia da bi xoa du lieu - hay lua chon:");
					System.out.println("1.Nhan thong tin Tac gia ");
					System.out.println("2.Sua thong tin Tac gia");
					System.out.println("3.Tao Tac gia moi");
					int luachon_1=Integer.parseInt(sc.nextLine());
					switch(luachon_1){
						case 1:this.setTacgia(danhsachTacgia.Khoiphuc(newtentacgia));
								System.out.println("Da khoi phuc");
								break;
						case 2:danhsachTacgia.Khoiphuc(newtentacgia);
								this.setTacgia(danhsachTacgia.Sua(newtentacgia));
								System.out.println("Dang Sua");
								break;
						default:this.setTacgia(danhsachTacgia.Them());
								break;
					}
				}
		}
		System.out.println();
		while(this.getNXB()==null) {
			this.setNXB(new newNXB()); 
			if(danhsachNXB.getSoluong()==0) {
				setNXB(danhsachNXB.Them());
				break;
			}
			System.out.print("Nhap Ten NXB: ");
			String newtenNXB=sc.nextLine();
			this.setNXB(danhsachNXB.Trunglap(newtenNXB));
			if(this.getNXB()==null) {
				System.out.println("NXB chua co trong danh sach - hay tao NXB");
				this.setNXB(danhsachNXB.Them());
				break;
			}
			else if(this.getNXB().getTrangthai()==1){
				System.out.println("Trung lap NXB- hay lua chon:");
				System.out.println("1.Nhan thong tin NXB");
				System.out.println("2.Sua thong tin NXB");
				System.out.println("3.Tao NXB moi");
				int luachon=Integer.parseInt(sc.nextLine());
					switch(luachon){
					case 1:System.out.println("Da nhan thong tin");
							break;
					case 2:System.out.println("Dang Sua");
							this.setNXB(danhsachNXB.Sua(newtenNXB));
							break;
					default:
							this.setNXB(danhsachNXB.Them());
							break;
					}				
				}
				else {
					System.out.println("NXB da bi xoa du lieu - hay lua chon:");
					System.out.println("1.Nhan thong tin NXB ");
					System.out.println("2.Sua thong tin NXB");
					System.out.println("3.Tao NXB moi");
					int luachon_1=Integer.parseInt(sc.nextLine());
					switch(luachon_1){
						case 1:this.setNXB(danhsachNXB.Khoiphuc(newtenNXB));
								System.out.println("Da khoi phuc");
								break;
						case 2:danhsachNXB.Khoiphuc(newtenNXB);
								this.setNXB(danhsachNXB.Sua(newtenNXB));
								System.out.println("Dang Sua");
								break;
						default:this.setNXB(danhsachNXB.Them());
								break;
					}
				}
		}
		System.out.println();
		while(this.getTheloai()==null) {
			this.setTheloai(new newtheloai());
			if(danhsachTheloai.getSoluong()==0) {
				this.setTheloai(danhsachTheloai.Them());
				break;
			}
			System.out.print("Nhap Ten the loai sach: ");
			String newtentheloai=sc.nextLine();
			this.setTheloai(danhsachTheloai.Trunglap(newtentheloai));
			if(this.getTheloai()==null) {
				System.out.println("The loai chua co trong danh sach - hay tao The loai");
				this.setTheloai(danhsachTheloai.Them());
				break;
			}
			else if(this.getTheloai().getTrangthai()==1){
				System.out.println();
				System.out.println("1.Nhan thong tin The loai");
				System.out.println("2.Sua thong tin The loai");
				System.out.println("3.Tao The loai moi");
				int luachon=Integer.parseInt(sc.nextLine());
					switch(luachon){
					case 1:System.out.println("Da nhan thong tin");
							break;
					case 2:System.out.println("Dang Sua");
							this.setTheloai(danhsachTheloai.Sua(newtentheloai));
							break;
					default:
							this.setTheloai(danhsachTheloai.Them());
							break;
					}				
				}
				else {
					System.out.println("The loai da bi xoa du lieu - hay lua chon:");
					System.out.println("1.Nhan thong tin The loai ");
					System.out.println("2.Sua thong tin The loai");
					System.out.println("3.Tao The loai moi");
					int luachon_1=Integer.parseInt(sc.nextLine());
					switch(luachon_1){
						case 1:this.setTheloai(danhsachTheloai.Khoiphuc(newtentheloai));
								System.out.println("Da khoi phuc");
								break;
						case 2:danhsachTheloai.Khoiphuc(newtentheloai);
								this.setTheloai(danhsachTheloai.Sua(newtentheloai));
								System.out.println("Dang Sua");
								break;
						default:this.setTheloai(danhsachTheloai.Them());
								break;
					}
				}
		}
		System.out.println();
		while(this.getGiaban()<=0||this.getGiaban()>100000000){
			System.out.print("Nhap gia ban '"+getTensach()+"': ");
			String newgiaban=sc.nextLine();
			if(newgiaban.matches("\\d+"))
				this.setGiaban(Integer.parseInt(newgiaban));
			else
				this.setGiaban(0);
		}
		while(this.getSoluong()<=0) {
			System.out.print("Nhap so luong sach '"+getTensach()+"': ");
			String newsoluong=sc.nextLine();
			if(newsoluong.matches("\\d+"))
				this.setSoluong(Integer.parseInt(newsoluong));
			else
				this.setSoluong(0);
		}
			this.trangthai=1;
			System.out.println();
	}
	@Override
	public void suathongtin() {
		System.out.println("1.Sua Ten sach");
		System.out.println("2.Sua Ma sach");
		System.out.println("3.Sua Tac gia cua sach");
		System.out.println("4.Sua NXB cua sach");
		System.out.println("5.Sua The loai sach");
		System.out.println("6.Sua Gia ban sach");
		System.out.println("7.Sua So luong sach");
		System.out.print("Nhap lua chon: ");
		int luachon=Integer.parseInt(sc.nextLine());
		boolean exitLoop=false;
			switch(luachon) {
			case 1:
				while(!exitLoop) {
					System.out.print("Nhap Ten moi cua sach: ");
					String newtensach=sc.nextLine();
					if(!newtensach.equals(this.getTensach())) {
						this.setTensach(newtensach);
						exitLoop=true;
					}
				}	
				break;
			case 2:
				while(!exitLoop) {
					System.out.println("Nhap ma sach moi");
					String newmasach=sc.nextLine();
					sach new_masach=danhsachSach.Trunglap(newmasach);
					if (new_masach==null&&!this.getMasach().equals(newmasach)) {
		                this.setMasach(newmasach);
		                exitLoop=true;
		                break; 
					}
					else if(new_masach!=null&&new_masach.getTrangthai()==1){
						System.out.println("Trung lap Sach moi nhap lai:");
						exitLoop=false;
						} else {
								System.out.println("Sach da bi xoa du lieu - hay lua chon:");
								System.out.println("1.Khoi phuc Sach");
								System.out.println("2.Khoi phuc Va Sua thong tin Sach");
								System.out.println("3.Thoat");
								int luachon_1=Integer.parseInt(sc.nextLine());
								switch(luachon_1){
									case 1:danhsachSach.Khoiphuc(newmasach);
											System.out.println("Da khoi phuc");
										return;
									case 2:danhsachSach.Khoiphuc(newmasach);
											danhsachSach.Sua(newmasach);
											System.out.println("Dang Sua");
										return;
									default:
										return ;
								}
						}
				}
				break;
			case 3:this.getTacgia().suathongtin_chopheptrunglap();
				break;
			case 4:this.getNXB().suathongtin_chopheptrunglap();
				break;
			case 5:this.getTheloai().suathongtin_chopheptrunglap();
				break;
			case 6:
				while(!exitLoop) {
					System.out.print("Nhap Gia ban moi cua sach: ");
					String newgiaban=sc.nextLine();
					if(newgiaban.matches("\\d+")&&Double.parseDouble(newgiaban)!=this.getGiaban()&&Double.parseDouble(newgiaban)>0&&Double.parseDouble(newgiaban)<100000000) {
						this.setGiaban(Integer.parseInt(newgiaban));
						exitLoop=true;
						break;
					}
				}
				break;
			case 7:
				while(!exitLoop) {
					System.out.print("Nhap So luong moi cua sach: ");
					String newsoluong=sc.nextLine();
					if(newsoluong.matches("\\d+\\d*\\.?\\,?")&&Integer.parseInt(newsoluong)!=getSoluong()) {
						this.setSoluong(Integer.parseInt(newsoluong));
						exitLoop=true;
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
		return super.xuat();
	}
}
