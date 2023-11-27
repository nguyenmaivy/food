package sach;
// import com.example.otherpackage.*;
public class newtheloai extends theloai {

	public newtheloai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public newtheloai(String tenTheloai, String mota, int trangthai) {
		super(tenTheloai, mota, trangthai);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void nhap() {
		while(this.getTenTheloai()==null||this.getTenTheloai().isEmpty()){
			System.out.print("Nhap The loai sach: ");
			String newtentheloai=sc.nextLine();
			theloai new_theloai=danhsachTheloai.Trunglap(newtentheloai);
			if (new_theloai==null) {
                this.setTenTheloai(newtentheloai);
                break;
			}else if(new_theloai!=null&&new_theloai.getTrangthai()==1)
				System.out.println("Trung lap The loai - hay nhap lai:");    
			else {
				System.out.println("The loai da bi xoa du lieu - hay lua chon:");
				System.out.println("1.Khoi phuc thong tin The loai ");
				System.out.println("2.Khoi phuc va Sua thong tin The loai");
				System.out.println("3.Tao The loai moi");
				int luachon_1=Integer.parseInt(sc.nextLine());
				switch(luachon_1){
					case 1:danhsachTheloai.Khoiphuc(newtentheloai);
							System.out.println("Da khoi phuc");
						return;
					case 2:danhsachTheloai.Khoiphuc(newtentheloai);
							danhsachTheloai.Sua(newtentheloai);
							System.out.println("Dang Sua");
						return;
					default:danhsachTheloai.Them();
						return;
				}
			}
		}
		while(this.getMota()==null||this.getMota().isEmpty()){
			System.out.print("Nhap mo ta ve the loai "+getTenTheloai()+": ");
			this.setMota(sc.nextLine());
		}
			this.setTrangthai(1);
	}
	@Override
	public void suathongtin() {
		System.out.println("1.Sua Ten The loai");
		System.out.println("2.Sua Mo ta The loai");
		System.out.print("Nhap lua chon: ");
		int luachon=Integer.parseInt(sc.nextLine());
		boolean exitLoop=false;
		switch(luachon) {
		case 1:
			while(!exitLoop) {
				System.out.println("Nhap The loai sach moi");
				String newtenTheloai=sc.nextLine();
				theloai new_theloai=danhsachTheloai.Trunglap(newtenTheloai);
				if (new_theloai==null&&!this.getTenTheloai().equals(newtenTheloai)) {
	                this.setTenTheloai(newtenTheloai);
	                exitLoop=true;
	                break; 
				}
				else if(new_theloai!=null&&new_theloai.getTrangthai()==1){
						System.out.println("Trung lap The loai moi nhap lai:");
						exitLoop=false;
					} else {
						System.out.println("The loai da bi xoa du lieu - hay lua chon:");
						System.out.println("1.Khoi phuc The loai");
						System.out.println("2.Khoi phuc va Sua thong tin The loai");
						System.out.println("3.Thoat");
						int luachon_1=Integer.parseInt(sc.nextLine());
						switch(luachon_1){
							case 1:danhsachTheloai.Khoiphuc(newtenTheloai);
									System.out.println("Da khoi phuc");
								return;
							case 2:danhsachTheloai.Khoiphuc(newtenTheloai);
									danhsachTheloai.Sua(newtenTheloai);
									System.out.println("Dang Sua");
								return;
							default:
								return ;
						}
					}
			}
			break;
		case 2:
			while(!exitLoop) {
				System.out.println("Nhap mo ta moi cua The loai");
				String newmota=sc.nextLine();
				if(!newmota.equals(this.getMota())) {
					this.setMota(newmota);
					exitLoop=true;
				}
			}	
			break;
		default:
			break;
		}
	}
	public void suathongtin_chopheptrunglap() {
		System.out.println("1.Sua Ten The loai");
		System.out.println("2.Sua Mo ta The loai");
		System.out.print("Nhap lua chon: ");
		int luachon=Integer.parseInt(sc.nextLine());
		boolean exitLoop=false;
		switch(luachon) {
		case 1:
			while(!exitLoop) {
				theloai new_tentheloai=new theloai();
				System.out.println("Nhap ten moi cua the loai");
				String newtentheloai=sc.nextLine();
				new_tentheloai=danhsachTheloai.Trunglap(newtentheloai);
				if(!exitLoop&&this.getTenTheloai()!=null&&!newtentheloai.equals(this.getTenTheloai())) {
					if(new_tentheloai==null) {
						this.setTenTheloai(newtentheloai);
		                exitLoop=true;
		                break; 
					}else {
						if(new_tentheloai.getTrangthai()==1) {
							System.out.println("Trung lap du lieu - hay lua chon:");
							System.out.println("1.Nhan thong tin The loai ");
							System.out.println("2.Sua thong tin The loai");
							System.out.println("3.Thoat");
							int luachon_1=Integer.parseInt(sc.nextLine());
							switch(luachon_1){
								case 1:
										System.out.println("Da khoi phuc");
										break;
								case 2:new_tentheloai=danhsachTheloai.Sua(newtentheloai);
										System.out.println("Dang Sua");
										break;
								default:
										return;
							}
						}
						else {
							System.out.println("The loai da bi xoa du lieu - hay lua chon:");
							System.out.println("1.Khoi phuc va Nhan thong tin The loai ");
							System.out.println("2.khoi phuc va Sua thong tin The loai");
							System.out.println("3.Thoat");
							int luachon_1=Integer.parseInt(sc.nextLine());
							switch(luachon_1){
								case 1:new_tentheloai=danhsachTheloai.Khoiphuc(newtentheloai);
										System.out.println("Da khoi phuc");
									break;
								case 2:danhsachTheloai.Khoiphuc(newtentheloai);
										new_tentheloai=danhsachTheloai.Sua(newtentheloai);
										System.out.println("Dang Sua");
									break;
								default:
									return;
							}
						}
					}
				}
				if(new_tentheloai!=null) {
					capnhattheloai(new_tentheloai.getTenTheloai(),new_tentheloai.getMota(),1);
					exitLoop=true;
					return;
				}
			}
			break;
		case 2:
			while(!exitLoop) {
				System.out.println("Nhap mo ta moi cua the loai");
				String newmota=sc.nextLine();
				if(!newmota.equals(this.getMota())) {
					this.setMota(newmota);
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
