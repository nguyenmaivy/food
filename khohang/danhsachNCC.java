package sach;
import java.util.*;
public class danhsachNCC {
	public static Scanner sc = new Scanner(System.in);
	private static int soluong=0;
	private static NCC NCC[];
	private static sach sach[];
	public static int getSoluong() {
		return soluong;
	}
	public static void setSoluong(int sl) {
		soluong = sl;
	}
	//nhập thông tin
	public static void nhapdanhsach() {
		while(soluong==0) {
			System.out.print("Nhap so luong NCC: ");
			soluong=Integer.parseInt(sc.nextLine());
		}
		NCC=new NCC[soluong];
		for(int i=0;i<NCC.length;i++) {
			NCC[i]=new NCC();
			System.out.println("Nhap thong tin NCC "+(i+1));
			NCC[i].nhap();
		}
	}
	//tìm kiếm thông tin bị trùng lặp
	//trùng lặp được cho phép
	public static NCC Trunglap(String tenNCC) {
		if(NCC==null||NCC[0]==null)
			return null;
		for(int i=0;i<NCC.length;i++)
			if(NCC[i]!=null)
				if(NCC[i].getTenNCC()!=null&&NCC[i].getTenNCC().equals(tenNCC)) 
					return NCC[i];
		return null;
	}
	//xuất thông tin
	public static void xuatdanhsach() {
		if(NCC.length==0) {
			System.out.println("Khong co NCC nao");
			return;
		}
		for(int i=0;i<NCC.length;i++) {
			if(NCC[i]!=null&&NCC[i].trangthai==1) {
				System.out.println("");
				System.out.println(NCC[i].xuat());
			}
		}
	}
	//thêm thông tin đối tượng 
	public static NCC Them() {
		int i;
		if(NCC==null) {
			NCC= new NCC[1];
			i=0;
		}else {
			NCC=Arrays.copyOf(NCC, NCC.length+1);
			i=soluong;
		}
		NCC[i]=new NCC();
		System.out.println("nhap thong tin NCC");
		NCC[i].nhap();
		soluong++;
		return NCC[i];
	}
	public static void ThemNCC() {
		System.out.print("So Luong NCC can them: ");
		int n=Integer.parseInt(sc.nextLine());
		if(n==0) {
			if(soluong==0)
				System.out.println("Danh sach rong");
			else
				System.out.println("Khong them NCC");
			return;
		}
		while(n!=0){
			Them();
			n--;
		}
	}
	//tìm kiếm thông tin
	public static int Timkiem(String tenNCC) {
			for(int i=0;i<NCC.length;i++) {
				if(NCC[i].trangthai==1&&NCC[i].getTenNCC().equals(tenNCC))
					return i;
			}
			return -1;
	}
	public static void TimkiemNCC() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		System.out.print("Nhap ten NCC can tim: ");
		String tenNCC=sc.nextLine();
		int i=Timkiem(tenNCC);
		while(i==-1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon=Integer.parseInt(sc.nextLine());
			if(luachon==1) {
				System.out.print("Nhap Ten NCC can tim: ");
				i=Timkiem(sc.nextLine());
			}else
				return;
		}
			System.out.println(NCC[i].xuat());
	}
	//xóa thông tin(xóa giả => ẩn thông tin)
	public static void Xoa() {
		System.out.print("Nhap ten NCC can xoa: ");
		String tenNCC=sc.nextLine();
		int i=Timkiem(tenNCC);
		if(i==-1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon=Integer.parseInt(sc.nextLine());
			if(luachon==1)
				Xoa();
		}
		else {
			NCC[i].trangthai=0;
			return;
		}
	}
	public static void XoaNCC() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		System.out.print("Nhap so luong NCC can xoa thong tin (Khong vuot qua "+NCC.length+"): ");
		int so_luong_can_xoa=Integer.parseInt(sc.nextLine());
		if(so_luong_can_xoa==0) {
			System.out.println("Khong xoa NCC");
			return;
		}
		if(so_luong_can_xoa>NCC.length)
			return;
		while(so_luong_can_xoa!=0) {
			Xoa();
		so_luong_can_xoa--;
		}
	}
	//khôi phục thông tin đã xóa
	public static NCC Khoiphuc(String tenNCC_cankhoiphuc) {
		int i;
		for(i=0;i<NCC.length;i++)
			if(NCC[i].getTenNCC()!=null&&NCC[i].getTenNCC().equals(tenNCC_cankhoiphuc)&&NCC[i].trangthai==0) {
				NCC[i].trangthai=1;
				return NCC[i];
			}
		return null;
	}
	public static void KhoiphucNCC() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		System.out.print("Nhap so luong NCC can khoi phuc thong tin (Khong vuot qua "+NCC.length+"): ");
		int soluong_NCC_cankhoiphuc=Integer.parseInt(sc.nextLine());
		for(int i=0;i<soluong_NCC_cankhoiphuc;i++) {
			System.out.println("Nhap Ten NCC can khoi phuc: ");
			String tenNCC_cankhoiphuc=sc.nextLine();
			Khoiphuc(tenNCC_cankhoiphuc);
		}
	}
	//sửa thông tin 
	public static NCC Sua(String tenNCC) {
		int i=Timkiem(tenNCC);
		if(i==-1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon=Integer.parseInt(sc.nextLine());
			if(luachon==1) {
				System.out.print("Nhap Ten NCC can sua thong tin: ");
				return Sua(sc.nextLine());
			}
			else
				return null;
		}
		System.out.println("Ban muon sua bao nhieu thong tin cua NCC (toi da 4): ");
		int so_luong_thong_tin_can_sua=Integer.parseInt(sc.nextLine());
		while(so_luong_thong_tin_can_sua!=0) {
			System.out.println("Sua thong tin cua NCC '"+NCC[i].getTenNCC()+"'");
			NCC[i].suathongtin();
			so_luong_thong_tin_can_sua--;
		}
		return NCC[i];
	}
	public static void SuaNCC() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		System.out.print("Nhap so luong NCC can sua thong tin (Khong vuot qua "+NCC.length+"): ");
		int so_luong_can_sua=Integer.parseInt(sc.nextLine());
		if(so_luong_can_sua==0) {
			System.out.println("Khong sua NCC");
			return;
		}
		if(so_luong_can_sua>NCC.length)
			return;
		while(so_luong_can_sua!=0) {
			System.out.print("Nhap ten NCC can sua thong tin: ");
			String tenNCC=sc.nextLine();
			Sua(tenNCC);
			so_luong_can_sua--;
		}
	}
}
