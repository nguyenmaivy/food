package sach;
import java.io.*;
import java.util.*;
// import com.example.otherpackage.*;
public class danhsachTheloai {
	public static Scanner sc = new Scanner(System.in);
	private static int soluong=0;
	private static newtheloai theloai[];
	public danhsachTheloai() {
	}
	public static int getSoluong() {
		return soluong;
	}
	public static void setSoluong(int sl) {
		soluong = sl;
	}
	//nhập thông tin
	public static void nhapdanhsach() {
		while(soluong==0) {
			System.out.print("Nhap so luong The loai: ");
			String sl=sc.nextLine();
			if(sl.matches("\\d+"))
				soluong=Integer.parseInt(sl);
			else soluong=0;
		}
		theloai=new newtheloai[soluong];
		for(int i=0;i<theloai.length;i++) {
			theloai[i]=new newtheloai();
			System.out.println("Nhap thong tin The loai");
			theloai[i].nhap();
		}
	}
	public static void docfile(String filename) {
		try {
			FileReader readfile=new FileReader(filename);
			BufferedReader br = new BufferedReader(readfile);
			String line;
			int i;
			while((line=br.readLine())!=null) {
				String text[]=line.split("#");
				if(theloai==null) {
					theloai= new newtheloai[1];
					i=0;
				}else {
					i=soluong;
					theloai=Arrays.copyOf(theloai, theloai.length+1);
				}
				if(text.length==2&&Trunglap(text[0])==null&&!text[0].isEmpty()) {
					if(theloai[i]==null)
						theloai[i]= new newtheloai();
					theloai[i].capnhattheloai(text[0],text[1], 1);
					i++;
					soluong++;
				}else theloai=Arrays.copyOf(theloai, theloai.length-1);
			}
			br.close();
			readfile.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void ghifile(String filename) {
		try {
			FileWriter writefile=new FileWriter(filename);
			FileWriter bin=new FileWriter("D:\\java\\java_project\\src\\sach\\theloai_recyclebin.txt");
			int i=0;
			if(theloai==null) {
				System.out.println("Danh sach rong");
				writefile.close();
				bin.close();
				return;
			}
			while(i<theloai.length&&theloai[i]!=null){
				if(theloai[i].trangthai==1)
					writefile.write(theloai[i].getTenTheloai()+"#"+theloai[i].getMota()+"\n");
				else 
					bin.write(theloai[i].getTenTheloai()+"#"+theloai[i].getMota()+"\n");
				i++;
			}
			writefile.close();
			bin.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	//trùng lặp được cho phép
	public static newtheloai Trunglap(String tentheloai) {
		if(theloai==null||theloai[0]==null)
			return null;
		for(int i=0;i<theloai.length;i++)
			if(theloai[i]!=null)
				if(theloai[i].getTenTheloai()!=null&&theloai[i].getTenTheloai().equals(tentheloai)) 
					return theloai[i];
		return null;
	}
	//xuất thông tin
	public static void xuatdanhsach() {
		if(theloai.length==0) {
			System.out.println("Khong co The loai nao");
			return;
		}
		for(int i=0;i<theloai.length;i++) {
			if(theloai[i]!=null&&theloai[i].trangthai==1) {
				System.out.println("");
				System.out.println(theloai[i].xuat());
			}
		}
	}
	//thêm thông tin đối tượng 
	public static newtheloai Them() {
		int i;
		if(theloai==null&&soluong==0) {
			theloai= new newtheloai[1];
			i=0;
		}else {
			theloai=Arrays.copyOf(theloai, theloai.length+1);
			i=soluong;
		}
		theloai[i]=new newtheloai();
		System.out.println("nhap thong tin the loai");
		theloai[i].nhap();
		soluong++;
		return theloai[i];
	}
	public static void ThemTheloai() {
		int so_luong_can_them=-1;
		while(so_luong_can_them==-1) {
			System.out.print("So Luong the loai can them: ");
			String sl=sc.nextLine();
			if(sl.matches("\\d+")) {
				so_luong_can_them=Integer.parseInt(sl);
				if(so_luong_can_them==0) {
					if(soluong==0)
						System.out.println("Danh sach rong");
					else
						System.out.println("Khong them sach");
					return;
				}
				while(so_luong_can_them!=0){
					Them();
					so_luong_can_them--;
				}
			}else so_luong_can_them=-1;
		}
	}
	//tìm kiếm thông tin
	public static int Timkiem(String tentheloai) {
			for(int i=0;i<theloai.length;i++) {
				if(theloai[i].trangthai==1&&theloai[i].getTenTheloai().equals(tentheloai))
					return i;
			}
			return -1;
	}
	public static void TimkiemTheloai() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		System.out.print("Nhap ten the loai can tim: ");
		String tentheloai=sc.nextLine();
		int i=Timkiem(tentheloai);
		while(i==-1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon=Integer.parseInt(sc.nextLine());
			if(luachon==1) 
				TimkiemTheloai();
			else
				return;
		}
		System.out.println(theloai[i].xuat());
	}
	//xóa thông tin(xóa giả => ẩn thông tin)
	public static void Xoa() {
		System.out.print("Nhap ten the loai can xoa: ");
		String tentheloai=sc.nextLine();
		int i=Timkiem(tentheloai);
		if(i==-1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon=Integer.parseInt(sc.nextLine());
			if(luachon==1)
				Xoa();
		}
		else {
			theloai[i].trangthai=0;
			return;
		}
	}
	public static void XoaTheloai() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		int so_luong_can_xoa=-1;
		while(so_luong_can_xoa==-1) {
			System.out.print("Nhap so luong the loai can xoa thong tin(khong vuot qua "+theloai.length+"): ");
			String sl=sc.nextLine();
				if(sl.matches("\\d+")) {
					so_luong_can_xoa=Integer.parseInt(sl);
				
				if(so_luong_can_xoa==0) {
					System.out.println("Khong xoa The loai");
					return;
				}
				if(so_luong_can_xoa>theloai.length)
					return;
				while(so_luong_can_xoa!=0) {
					Xoa();
					so_luong_can_xoa--;
				}
			}else so_luong_can_xoa=-1;
		}
	}
	//khôi phục thông tin đã xóa
	public static newtheloai Khoiphuc(String tentheloai_cankhoiphuc) {
		int i;
		for(i=0;i<theloai.length;i++)
			if(theloai[i].getTenTheloai()!=null&&theloai[i].getTenTheloai().equals(tentheloai_cankhoiphuc)&&theloai[i].trangthai==0) {
				theloai[i].trangthai=1;
				return theloai[i];
			}
		return null;
	}
	public static void KhoiphucTheloai() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		int soluong_theloai_cankhoiphuc=-1;
		while(soluong_theloai_cankhoiphuc==-1) {
		System.out.print("Nhap so luong the loai can khoi phuc thong tin(khong vuot qua "+theloai.length+"): ");
		String sl=sc.nextLine();
			if(sl.matches("\\d+")) {
				soluong_theloai_cankhoiphuc=Integer.parseInt(sl);
				if(soluong_theloai_cankhoiphuc>theloai.length)
					return;
				for(int i=0;i<soluong_theloai_cankhoiphuc;i++) {
					System.out.print("Nhap ten the loai can khoi phuc: ");
					String tentheloai_cankhoiphuc=sc.nextLine();
					Khoiphuc(tentheloai_cankhoiphuc);
				}
			}else soluong_theloai_cankhoiphuc=-1;
		}
	}
	//sửa thông tin 
	public static newtheloai Sua(String ten_theloai_cansua) {
			int i=Timkiem(ten_theloai_cansua);
			if(i==-1) {
				System.out.println("Khong tim thay");
				System.out.println("1.Tiep tuc tim kiem");
				System.out.println("2.Thoat tim kiem");
				int luachon=Integer.parseInt(sc.nextLine());
				if(luachon==1) {
					System.out.print("Nhap Ten the loai can sua thong tin: ");
					return Sua(sc.nextLine());
				}
				else
					return null;
			}int so_luong_thong_tin_can_sua=-1;
			while(so_luong_thong_tin_can_sua==-1) {
				System.out.print("Ban muon sua bao nhieu thong tin cua the loai (toi da 2): ");
				String sl=sc.nextLine();
				if(sl.matches("\\d+")) {
					so_luong_thong_tin_can_sua=Integer.parseInt(sl);
					if(so_luong_thong_tin_can_sua>2)
						return null;
					while(so_luong_thong_tin_can_sua!=0) {
						System.out.println("Sua thong tin cua The loai '"+theloai[i].getTenTheloai()+"'");
						theloai[i].suathongtin();
						so_luong_thong_tin_can_sua--;
					}
				}else so_luong_thong_tin_can_sua=-1;
			}
		return theloai[i];
	}
	public static void SuaTheloai() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		int so_luong_can_sua=-1;
		while(so_luong_can_sua==-1) {
		System.out.print("Nhap so luong the loai can sua thong tin(khong vuot qua "+theloai.length+"): ");
		String sl=sc.nextLine();
			if(sl.matches("\\d+")) {
				so_luong_can_sua=Integer.parseInt(sl);
				if(so_luong_can_sua==0) {
					System.out.println("Khong sua the loai");
					return;
				}
				if(so_luong_can_sua>theloai.length)
					return;
				while(so_luong_can_sua!=0) {
					System.out.print("Nhap ten the loai can sua thong tin: ");
					String ten_theloai_cansua=sc.nextLine();
					Sua(ten_theloai_cansua);
					so_luong_can_sua--;
				}
			}else so_luong_can_sua=-1;
		}
	}
}
