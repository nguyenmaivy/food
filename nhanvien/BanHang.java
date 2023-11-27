
package OOP;
public class BanHang extends nhanvien{
    private int SLBan ;

    public BanHang(int SLBan, String maNV, String chucVu, double luong, int trangthai, String ten, int tuoi, String gioitinh) {
        super(maNV, chucVu, luong, trangthai, ten, tuoi, gioitinh);
        this.SLBan = SLBan;
    }

    public BanHang() {
    }

    public int getSLBan() {
        return SLBan;
    }

    public boolean setSLBan(int SLBan) {
        if(SLBan>=0){         
            this.SLBan = SLBan;
            return true;
        } else{
            System.err.print("Nhap lai so luong ban: ");
            return false;
        }           
    }        

    
    @Override
    public double tinhLuong(){     
     return getLuong()*1.4+ SLBan*2.5;
    }
        
     @Override
    public void nhap() {
        super.nhap();
        while(true){
            int newSLBan=Integer.parseInt(sc.nextLine());
            boolean check =setSLBan(newSLBan);
            if(check){
                break;
            }
	}
        
	this.trangthai=1;
    }
 @Override
	public void suathongtin() {
        System.out.println("1.Sua Ma nhan vien");
	System.out.println("2.Sua Ho va Ten nhan vien");
	System.out.println("3.Sua Tuoi nhan vien");
	System.out.println("4.Sua Gioi tinh nhan vien");
        System.out.println("5.Sua Chuc vu nhan vien");
        System.out.println("6.Sua Luong nhan vien");
        System.out.println("7.Sua so luong sach ban");        
	System.out.print("Nhap lua chon: ");
	int luachon=Integer.parseInt(sc.nextLine());
	boolean exitLoop=false;
		switch(luachon){
		case 1:while(!exitLoop) {
                            System.out.print("Nhap Ma nhan vien moi: ");
                            String newmaNV=sc.nextLine();
                            if(!newmaNV.equals(this.getMaNV())){
                                    this.setMaNV(newmaNV);
                                    exitLoop=true;
                            }
			}                       
                        break;
		case 2:while(!exitLoop) {
                            System.out.print("Nhap Ho va Ten moi: ");
                            String newten=sc.nextLine();
                            if(!newten.equals(this.getTen())){
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
		case 5:while(!exitLoop){
                            System.out.println("Nhap Chuc vu moi: ");
				String newchucVu=sc.nextLine();
				if(!newchucVu.equals(this.chucVu)) {
					this.chucVu=newchucVu;
					exitLoop=true;
				}                                   
                        }
			break;
		case 6:while(!exitLoop){
                            System.out.print("Nhap Luong moi: ");
					System.out.print("Nhap luong moi: ");
					String newluong=sc.nextLine();
					if(newluong.matches("\\d+\\d*\\.?\\,?")&&Double.parseDouble(newluong)!=this.luong&&Double.parseDouble(newluong)>0&&Double.parseDouble(newluong)<1000000000) {
						this.luong=Double.parseDouble(newluong);
						exitLoop=true;
					}
                        }
			break;
                case 7:while(!exitLoop) {
			System.out.print("Nhap So luong sach duoc ban moi: ");
			String newSLBan=sc.nextLine();
				if(newSLBan.matches("\\d+")&&Integer.parseInt(newSLBan)!=this.getSLBan()&&Integer.parseInt(newSLBan)>=0){
					this.setSLBan(Integer.parseInt(newSLBan));
					exitLoop=true;
				}
                        }                    
                        break;                        
		default:
			break;
	}
}
	public void capnhatnhanvien(String ten, int tuoi, String gioitinh,String chucVu,double luong,int trangthai,String maNV,int SLBan) {
		this.setMaNV(maNV);
                this.setTen(ten);
		this.setTuoi(tuoi);
		this.setGioitinh(gioitinh);
		this.setChucVu(chucVu);		
                this.setLuong(luong);
                this.SLBan=SLBan;
		this.trangthai=trangthai;

	}
    @Override
    public String xuat() {
        return String.format("| %s |So luong sach da ban: %-10s ",super.xuat(),SLBan);	
    }   
     
}    

   
    
