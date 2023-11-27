package sach;
import java.util.*;
// import com.example.otherpackage.*;
public class sach {
	public Scanner sc=new Scanner(System.in);
	private String tensach;
	private String masach;
	private newtacgia tacgia;
	private newNXB NXB;
	private newtheloai theloai;
	private double giaban;
	private int soluong;
	public int trangthai;
	public sach(String tensach, String masach, newtacgia tacgia, newNXB NXB, newtheloai theloai, double giaban,int soluong,int trangthai) {
		this.tensach = tensach;
		this.masach = masach;
		this.tacgia = tacgia;
		this.NXB = NXB;
		this.theloai = theloai;
		this.giaban = giaban;
		this.soluong = soluong;
		this.trangthai=trangthai;
	}
	public sach() {
	}
	
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public newtacgia getTacgia() {
		return tacgia;
	}
	public void setTacgia(newtacgia tacgia) {
		this.tacgia = tacgia;
	}
	public newNXB getNXB() {
		return NXB;
	}
	public void setNXB(newNXB nXB) {
		NXB = nXB;
	}
	public newtheloai getTheloai() {
		return theloai;
	}
	public void setTheloai(newtheloai theloai) {
		this.theloai = theloai;
	}
	public double getGiaban() {
		return giaban;
	}
	public void setGiaban(double giaban) {
		this.giaban = giaban;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public void nhap() {
		while(tensach==null||this.tensach.isEmpty()) {
			System.out.print("Nhap Ten sach: ");
			this.tensach=sc.nextLine();
		}
		while(this.masach==null||this.masach.isEmpty()){
			System.out.print("Nhap ma sach: ");
			String newmasach=sc.nextLine();
            this.masach = newmasach;
            break;
		}
		System.out.println();
		while(tacgia==null) {
			tacgia=new newtacgia();
			System.out.print("Nhap Ma so Tac gia: ");
			tacgia.nhap();
		}
		System.out.println();
		while(NXB==null) {
			NXB=new newNXB();
			System.out.print("Nhap Ten NXB: ");
			NXB.nhap();
		}
		System.out.println();
		while(theloai==null) {
			System.out.println("Nhap Thong tin Tac gia");
			theloai=new newtheloai();
			theloai.nhap();
			break;		
		}
		System.out.println();
		while(this.giaban<=0||this.giaban>100000000){
			System.out.print("Nhap gia ban '"+tensach+"': ");
			String newgiaban=sc.nextLine();
			if(newgiaban.matches("\\d+"))
				this.giaban=Integer.parseInt(newgiaban);
			else
				this.giaban=0;
		}
		while(soluong<=0) {
			System.out.print("Nhap so luong sach '"+tensach+"': ");
			String newsoluong=sc.nextLine();
			if(newsoluong.matches("\\d+"))
				this.soluong=Integer.parseInt(newsoluong);
			else
				this.soluong=0;
		}
			this.trangthai=1;
			System.out.println();
	}
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
					if(!newtensach.equals(tensach)) {
						this.tensach=newtensach;
						exitLoop=true;
					}
				}	
				break;
			case 2:
				while(!exitLoop) {
					System.out.println("Nhap ma sach moi");
					String newmasach=sc.nextLine();
					if (!this.masach.equals(newmasach)) {
		                this.masach = newmasach;
		                exitLoop=true;
		                break; 
					}
				}
				break;
			case 3:tacgia.suathongtin();
				break;
			case 4:NXB.suathongtin();
				break;
			case 5:theloai.suathongtin();
				break;
			case 6:
				while(!exitLoop) {
					System.out.print("Nhap Gia ban moi cua sach: ");
					String newgiaban=sc.nextLine();
					if(newgiaban.matches("\\d+\\d*\\.?\\,?")&&Double.parseDouble(newgiaban)!=this.giaban&&Double.parseDouble(newgiaban)>0&&Double.parseDouble(newgiaban)<100000000) {
						this.giaban=Integer.parseInt(newgiaban);
						exitLoop=true;
						break;
					}
				}
				break;
			case 7:
				while(!exitLoop) {
					System.out.print("Nhap So luong moi cua sach: ");
					String newsoluong=sc.nextLine();
					if(newsoluong.matches("\\d+")&&Integer.parseInt(newsoluong)!=soluong) {
						this.soluong=Integer.parseInt(newsoluong);
						exitLoop=true;
						exitLoop=true;
					}
				}	
				break;
			default:
				break;
		}
	}
	public void capnhatsach(String tensach, String masach, newtacgia tacgia, newNXB NXB, newtheloai theloai, double giaban,int soluong,int trangthai) {
		this.tensach = tensach;
		this.masach = masach;
		this.tacgia = tacgia;
		this.NXB = NXB;
		this.theloai = theloai;
		this.giaban = giaban;
		this.soluong = soluong;
		this.trangthai=trangthai;
	}
	public String xuat() {
		return String.format("Ma Sach: %-20s  | Ten Sach: %-25s | Ten Tac gia: %-25s | Ten NXB: %-15s |The loai sach: %-15s | Gia ban: %,-15.3f%-3s | So luong sach: %,d",masach,tensach,tacgia.getTen(),NXB.getTenNXB(),theloai.getTenTheloai(),giaban,"VND",soluong);	
		//return "sach [ten sach=" + tensach + ", ma sach=" + masach+ ", tac gia=" +tacgia.getTen()+ ", NXB=" + NXB.getTenNXB() + ", The loai=" + theloai.getTenTheloai()+ ", gia ban=" + giaban + ", so luong=" + soluong;
	}
	
}
