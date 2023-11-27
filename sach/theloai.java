package sach;
// import com.example.otherpackage.*;
import java.util.*;
enum check{
	TRUE,
	FALSE,
	EXIT,
}
public class theloai {
	public Scanner sc=new Scanner(System.in);
	private String tenTheloai;
	private String mota;
	public int trangthai;
	public theloai() {
	}
	
	public theloai(String tenTheloai, String mota, int trangthai) {
		this.tenTheloai = tenTheloai;
		this.mota = mota;
		this.trangthai = trangthai;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getTenTheloai() {
		return tenTheloai;
	}
	public void setTenTheloai(String tenTheloai) {
		this.tenTheloai = tenTheloai;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public void nhap() {
		while(this.tenTheloai==null||this.tenTheloai.isEmpty()){
			System.out.print("Nhap The loai sach: ");
			String newtenTheloai=sc.nextLine();
			theloai new_theloai=danhsachTheloai.Trunglap(newtenTheloai);
			if (new_theloai==null) {
                this.tenTheloai = newtenTheloai;
                break;    
			}
		}
		while(this.mota==null||this.mota.isEmpty()){
			System.out.print("Nhap mo ta ve the loai "+getTenTheloai()+": ");
			this.mota=sc.nextLine();
		}
			this.trangthai=1;
	}
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
				if (!this.tenTheloai.equals(newtenTheloai)) {
	                this.tenTheloai = newtenTheloai;
	                exitLoop=true;
				}
			}
			break;
		case 2:
			while(!exitLoop) {
				System.out.println("Nhap mo ta moi cua The loai");
				String newmota=sc.nextLine();
				if(!newmota.equals(mota)) {
					this.mota=newmota;
					exitLoop=true;
				}
			}	
			break;
		default:
			break;
		}
	}
	public void capnhattheloai(String tenTheloai, String mota, int trangthai) {
		this.tenTheloai = tenTheloai;
		this.mota = mota;
		this.trangthai = trangthai;
	}
	public String xuat() {
		return String.format("The loai sach: %-15s | Mo ta ve the loai: %s",tenTheloai,mota);
		
	}
	
}
