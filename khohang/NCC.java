package sach;
import java.util.*;
public class NCC {
	public Scanner sc=new Scanner(System.in);
	private String tenNCC;
	private String dcNCC;
	private String sdtNCC;
	private sach sach;
	public int trangthai;
	public NCC() {
	}
	
	public NCC(String tenNCC, String dcNCC, String sdtNCC, sach sach, int trangthai) {
		this.tenNCC = tenNCC;
		this.dcNCC = dcNCC;
		this.sdtNCC = sdtNCC;
		this.sach = sach;
		this.trangthai = trangthai;
	}
	
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDcNCC() {
		return dcNCC;
	}
	public void setDcNCC(String dcNCC) {
		this.dcNCC = dcNCC;
	}
	
	public String getsdtNCC() {
		return sdtNCC;
	}
	public void setsdtNCC(String sdtNCC) {
		this.sdtNCC = sdtNCC;
	}

	public sach getsach() {
		return sach;
	}
	public void setsach(sach sach) {
		this.sach = sach;
	}

	public void nhap() {
		while(this.tenNCC==null||this.tenNCC.isEmpty()){
			System.out.print("Nhap Ten NCC sach: ");
			String newtenNCC=sc.nextLine();
			NCC new_NCC=danhsachNCC.Trunglap(newtenNCC);
			if (new_NCC==null) {
                this.tenNCC = newtenNCC;
                break;
			}else if(new_NCC!=null&&new_NCC.getTrangthai()==1){
				System.out.println("Trung lap NCC- hay lua chon:");
				System.out.println("1.Sua thong tin NCC");
				System.out.println("2.Tao NCC moi");
				int luachon=Integer.parseInt(sc.nextLine());
					switch(luachon){
					case 1:System.out.println("Dang Sua");
							danhsachNCC.Sua(newtenNCC);
							return;
					default:
							nhap();
						return;
					}				
				}      
		}

		while(this.sdtNCC==null||this.sdtNCC.isEmpty()){
			System.out.print("Nhap So dien thoai NCC: ");
			String newsdtNCC=sc.nextLine();
			if(newsdtNCC.matches("\\d+"))
				this.sdtNCC=newsdtNCC;
			else
				this.sdtNCC=null;
		}

		while(this.dcNCC==null||this.dcNCC.isEmpty()){
			System.out.print("Nhap Dia chi NCC: ");
			this.dcNCC=sc.nextLine();
		}

		while(sach == null){
			sach = new sach();
			if (danhsachSach.getSoluong() == 0) {
				sach = danhsachSach.Them();
				break;
			}
		}
			this.trangthai=1;
	}
	public void suathongtin() {
		System.out.println("1.Sua ten NCC");
		System.out.println("2.Sua So dien thoai NBX");
		System.out.println("3.Sua Dia chi NCC");
		System.out.println("4.Sua thong tin sach");
		System.out.print("Nhap lua chon: ");
		int luachon=Integer.parseInt(sc.nextLine());
		boolean exitLoop=false;
		switch(luachon) {
		case 1:
			while(!exitLoop) {
				System.out.println("Nhap ten NCC moi");
				String newtenNCC=sc.nextLine();
				NCC new_NCC=danhsachNCC.Trunglap(newtenNCC);
				if (new_NCC==null&&!this.tenNCC.equals(newtenNCC)) {
	                this.tenNCC = newtenNCC;
	                exitLoop=true;
	                break; 
				}
				else if(new_NCC!=null&&new_NCC.getTrangthai()==1){
						System.out.println("Trung lap NCC moi nhap lai:");
						exitLoop=false;
					} else {
						System.out.println("NCC da bi xoa du lieu - hay lua chon:");
						System.out.println("1.Khoi phuc NCC");
						System.out.println("2.Sua thong tin NCC");
						System.out.println("3.Tao NCC moi");
						int luachon_1=Integer.parseInt(sc.nextLine());
						switch(luachon_1){
							case 1:danhsachNCC.Khoiphuc(newtenNCC);
									System.out.println("Da khoi phuc");
								return;
							case 2:danhsachNCC.Khoiphuc(newtenNCC);
									danhsachNCC.Sua(newtenNCC);
									System.out.println("Dang Sua");
								return;
							default:danhsachNCC.Them();
								return ;
							}
					}
			}
			break;
		case 2:
			while(!exitLoop) {
				System.out.print("Nhap so dien thoai moi cua NCC: ");
				String newsdtNCC=sc.nextLine();
				if(newsdtNCC.matches("\\d+")&&!newsdtNCC.equals(sdtNCC)) {
					this.sdtNCC=newsdtNCC;
					exitLoop=true;
				}
			}
			break;
		case 3:
			while(!exitLoop) {
				System.out.print("Nhap Dia chi moi cua NCC: ");
				String newdcNCC=sc.nextLine();
				if(!newdcNCC.equals(dcNCC)) {
					this.dcNCC=newdcNCC;
					exitLoop=true;
				}
			}	
			break;
		case 4:
			while (!exitLoop) {
				System.out.print("Nhap thong tin sach moi: ");
				this.sach.suathongtin();
			}
			break;
		default:
			break;
		}
	}
	public void suathongtin_chopheptrunglap() {
		System.out.println("1.Sua ten NCC");
		System.out.println("2.Sua So dien thoai NCC");
		System.out.println("3.Sua Dia chi NCC");
		System.out.println("4.Sua thong tin sach");
		System.out.print("Nhap lua chon: ");
		int luachon=Integer.parseInt(sc.nextLine());
		boolean exitLoop=false;
		switch(luachon) {
		case 1:
			while(!exitLoop) {
				NCC new_tenNCC=new NCC();
				System.out.print("Nhap Ten moi cua NCC: ");
				String newtenNCC=sc.nextLine();
				new_tenNCC=danhsachNCC.Trunglap(newtenNCC);
				if(!exitLoop&&this.tenNCC!=null&&!newtenNCC.equals(this.tenNCC)) {
					if(new_tenNCC==null) {
						this.tenNCC=newtenNCC;
						exitLoop=true;
						break;
					}else {
						if(new_tenNCC.getTrangthai()==1) {
							System.out.println("Trung lap NCC - hay lua chon:");
							System.out.println("1.Nhan thon tin NCC ");
							System.out.println("2.Sua thong tin NCC");
							System.out.println("3.Tao NCC moi");
							int luachon_1=Integer.parseInt(sc.nextLine());
							switch(luachon_1){
								case 1:System.out.println("Da khoi phuc");
										break;
								case 2:new_tenNCC=danhsachNCC.Sua(newtenNCC);
										System.out.println("Dang Sua");
										break;
								default:new_tenNCC=danhsachNCC.Them();
										break;
							}
						}
						else {
							System.out.println("NCC da bi xoa du lieu - hay lua chon:");
							System.out.println("1.Nhan thong tin NCC ");
							System.out.println("2.Sua thong tin NCC");
							System.out.println("3.Tao NCC moi");
							int luachon_1=Integer.parseInt(sc.nextLine());
							switch(luachon_1){
								case 1:new_tenNCC=danhsachNCC.Khoiphuc(newtenNCC);
										System.out.println("Da khoi phuc");
										break;
								case 2:danhsachNCC.Khoiphuc(newtenNCC);
										new_tenNCC=danhsachNCC.Sua(newtenNCC);
										System.out.println("Dang Sua");
										break;
								default:new_tenNCC=danhsachNCC.Them();
										break;
							}
						}
					}
				}
				if(new_tenNCC!=null) {
					capnhatNCC(new_tenNCC.getTenNCC(),new_tenNCC.getDcNCC(),new_tenNCC.getsdtNCC(),1);
					exitLoop=true;
					return;
				}
			}
			break;
		case 2:
				while(!exitLoop) {
					System.out.print("Nhap so dien thoai moi cua NCC: ");
					String newsdtNCC=sc.nextLine();
					if(newsdtNCC.matches("\\d+")&&!newsdtNCC.equals(sdtNCC)) {
						this.sdtNCC=newsdtNCC;
						exitLoop=true;
					}
				}
			break;
		case 3:
			while(!exitLoop) {
				System.out.print("Nhap Dia chi moi cua NCC: ");
				String newdcNCC=sc.nextLine();
				if(!newdcNCC.equals(dcNCC)) {
					this.dcNCC=newdcNCC;
					exitLoop=true;
				}
			}	
			break;
		case 4: 
			while(!exitLoop) {
				this.sach.suathongtin();
			}
		default:
			break;
		}
	}

	
	public void capnhatNCC(String tenNCC, String dcNCC, String sdtNCC, int trangthai) {
		this.tenNCC = tenNCC;
		this.dcNCC = dcNCC;
		this.sdtNCC = sdtNCC;
		//this.sach = sach;
		this.trangthai = trangthai;
	}
	public String xuat() {
		return String.format("Ten NCC: %-21s | So dien thoai NCC: %-16s | Dia chia NCC: %s | sach: %s",tenNCC,sdtNCC, dcNCC, sach.xuat());	
	}		
}

