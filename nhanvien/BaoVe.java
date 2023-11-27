
package OOP;
public class BaoVe extends nhanvien{
    private String kynang;

    public BaoVe(String kynang, String maNV, String chucVu, double luong, int trangthai, String ten, int tuoi, String gioitinh) {
        super(maNV, chucVu, luong, trangthai, ten, tuoi, gioitinh);
        this.kynang = kynang;
    }



    public BaoVe(){
    }

    public String getKynang() {
        return kynang;
    }

    public boolean setKynang(String kynang) {
        if(kynang !=null&& !kynang.isEmpty()){
            this.kynang = kynang;
            return true;
        } else{
            System.err.println("Moi nhap lai ky nang: ");
            return false;
        }
    }

    
    @Override
    public double tinhLuong(){     
     return getLuong()*1.3;
    }
        
     @Override
    public void nhap() {
        super.nhap();
        while(true){
            String newkynang=sc.nextLine();
            boolean check =setKynang(newkynang);
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
        System.out.println("7.Sua Ky nang nhan vien");        
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
                            System.out.print("Nhap Ky nang moi: ");
                            String newkynang=sc.nextLine();
                            if(!newkynang.equals(this.getKynang())){
                                    this.setKynang(newkynang);
                                    exitLoop=true;
                            }
			}                       
                        break;                        
		default:
			break;
	}
}
	public void capnhatnhanvien(String ten, int tuoi, String gioitinh,String chucVu,double luong,int trangthai,String maNV,String kynang) {
		this.setMaNV(maNV);
                this.setTen(ten);
		this.setTuoi(tuoi);
		this.setGioitinh(gioitinh);
		this.setChucVu(chucVu);		
                this.setLuong(luong);
                this.kynang=kynang;
		this.trangthai=trangthai;

	}
    @Override
    public String xuat() {
        return String.format("| %s |Ky nang: %-13s ",super.xuat(),kynang);	
    }   
     
}