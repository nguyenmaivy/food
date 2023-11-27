package sach;
import java.util.*;
import java.io.*;
// import com.example.otherpackage.*;
public class danhsachTacgia {
	public static Scanner sc = new Scanner(System.in);
	private static int soluong=0;
	private static newtacgia tacgia[];
	public danhsachTacgia() {
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
			System.out.print("Nhap so luong tac gia: ");
			String sl=sc.nextLine();
			if(sl.matches("\\d+"))
				soluong=Integer.parseInt(sl);
			else soluong=0;
		}
		tacgia=new newtacgia[soluong];
		for(int i=0;i<tacgia.length;i++) {
			tacgia[i]=new newtacgia();
			System.out.println("Nhap thong tin tac gia:");
			tacgia[i].nhap();
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
				if(tacgia==null) {
					tacgia= new newtacgia[1];
					i=0;
				}else {
					i=soluong;
					tacgia=Arrays.copyOf(tacgia, tacgia.length+1);
				}
				if(text.length==5&&text[0].matches("\\d+")&&Trunglap(text[0])==null&&!text[1].matches(".*\\d.*")&&text[2].matches("\\d+")) {
					if(tacgia[i]==null)
						tacgia[i]= new newtacgia();
					tacgia[i].capnhattacgia(text[0],text[1], Integer.parseInt(text[2]), text[3], text[4], 1);
					i++;
					soluong++;
					}else tacgia=Arrays.copyOf(tacgia, tacgia.length-1);
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
			FileWriter bin=new FileWriter("D:\\java\\java_project\\src\\sach\\tacgia_recyclebin.txt");
			int i=0;
			if(tacgia==null) {
				System.out.println("Danh sach rong");
				writefile.close();
				bin.close();
				return;
			}
			while(i<tacgia.length&&tacgia[i]!=null){
				if(tacgia[i].trangthai==1)
					writefile.write(tacgia[i].getMasotacgia()+"#"+tacgia[i].getTen()+"#"+tacgia[i].getTuoi()+"#"+tacgia[i].getGioitinh()+"#"+tacgia[i].getQuequan()+"\n");
				else 
					bin.write(tacgia[i].getMasotacgia()+"#"+tacgia[i].getTen()+"#"+tacgia[i].getTuoi()+"#"+tacgia[i].getGioitinh()+"#"+tacgia[i].getQuequan()+"\n");
				i++;
			}
			writefile.close();
			bin.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	//tìm kiếm thông tin bị trùng lặp
	//trùng lặp được cho phép
	public static newtacgia Trunglap(String masotacgia) {
		if(tacgia==null||tacgia[0]==null)
			return null;
		for(int i=0;i<tacgia.length;i++)
			if(tacgia[i]!=null)
				if(tacgia[i].getMasotacgia()!=null&&tacgia[i].getMasotacgia().equals(masotacgia)) 
					return tacgia[i];
		return null;
	}
	//xuất thông tin
	public static void xuatdanhsach() {
		if(tacgia.length==0) {
			System.out.println("Khong co tac gia nao");
			return;
		}
		for(int i=0;i<tacgia.length;i++) {
			if(tacgia[i]!=null&&tacgia[i].trangthai==1) {
				System.out.println("");
				System.out.println(tacgia[i].xuat());
			}
		}
	}
	//thêm thông tin đối tượng 
	public static newtacgia Them() {
		int i;
		if(tacgia==null) {
			tacgia= new newtacgia[1];
			i=0;
		}else {
			i=soluong;
			tacgia=Arrays.copyOf(tacgia, tacgia.length+1);
		}
		tacgia[i]=new newtacgia();
		System.out.println("nhap thong tin tac gia");
		tacgia[i].nhap();
		soluong++;
		return tacgia[i];
	}
	public static void ThemTacgia() {
		int so_luong_can_them=-1;
		while(so_luong_can_them==-1) {
			System.out.print("Nhap so luong tac gia can them: ");
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
			}
			else so_luong_can_them=-1;
		}
	}
	//tìm kiếm thông tin
	public static int Timkiem(String masotacgia) {
			for(int i=0;i<tacgia.length;i++) {
				if(tacgia[i].trangthai==1&&tacgia[i].getMasotacgia()!=null&&tacgia[i].getMasotacgia().equals(masotacgia))
					return i;
			}
			return -1;
	}
	public static void TimkiemTacgia() {
		System.out.print("Nhap ma so tac gia can tim: ");
		String masotacgia=sc.nextLine();
		int i=Timkiem(masotacgia);
		while(i==-1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon=Integer.parseInt(sc.nextLine());
			if(luachon==1)
				TimkiemTacgia();
			else
				return;
		}
			System.out.println(tacgia[i].xuat());
		
	}
	//xóa thông tin(xóa giả => ẩn thông tin)
	public static void Xoa() {
		System.out.print("Nhap ma tac gia can xoa: ");
		String masotacgia=sc.nextLine();
		int i=Timkiem(masotacgia);
		if(i==-1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon=Integer.parseInt(sc.nextLine());
			if(luachon==1)
				Xoa();
			}
			else {
			tacgia[i].trangthai=0;
			return;
		}
	}
	public static void XoaTacgia() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		int so_luong_can_xoa=-1;
		while(so_luong_can_xoa==-1) {
			System.out.print("Nhap so luong tac gia can xoa (Khong vuot qua "+tacgia.length+"): ");
			String sl=sc.nextLine();
			if(sl.matches("\\d+")) {
				so_luong_can_xoa=Integer.parseInt(sl);
				if(so_luong_can_xoa==0) {
					System.out.println("Khong xoa Tac gia");
					return;
				}
				if(so_luong_can_xoa>tacgia.length)
					return;
				while(so_luong_can_xoa!=0) {
					Xoa();
					so_luong_can_xoa--;
				}
			}else so_luong_can_xoa=-1;
		}
	}
	//khôi phục thông tin đã xóa
	public static newtacgia Khoiphuc(String matacgia_cankhoiphuc) {
		int i;
		for(i=0;i<tacgia.length;i++)
			if(tacgia[i].getMasotacgia()!=null&&tacgia[i].getMasotacgia().equals(matacgia_cankhoiphuc)&&tacgia[i].trangthai==0) {
				tacgia[i].trangthai=1;
				return tacgia[i];
			}
		return null;
	}
	public static void KhoiphucTacgia() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		int soluong_tacgia_cankhoiphuc=-1;
		while(soluong_tacgia_cankhoiphuc==-1) {
			System.out.print("Nhap so luong tac gia can khoi phuc (Khong vuot qua "+tacgia.length+"): ");
			String sl=sc.nextLine();
			if(sl.matches("\\d+")) {
				soluong_tacgia_cankhoiphuc=Integer.parseInt(sl);
				if(soluong_tacgia_cankhoiphuc>tacgia.length)
					return;
				for(int i=0;i<soluong_tacgia_cankhoiphuc;i++) {
					System.out.print("Nhap ma tac gia can khoi phuc: ");
					String matacgia_cankhoiphuc=sc.nextLine();
					Khoiphuc(matacgia_cankhoiphuc);
				}
			}else soluong_tacgia_cankhoiphuc=-1;
		}
	}
	//sửa thông tin 
	public static newtacgia Sua(String maso_tacgia_cansua) {
		int i=Timkiem(maso_tacgia_cansua);
		if(i==-1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon=Integer.parseInt(sc.nextLine());
			if(luachon==1) {
				System.out.print("Nhap Ma so tac gia can sua thong tin: ");
				return Sua(sc.nextLine());
			}
			else
				return null;
		}
		int so_luong_thong_tin_can_sua=-1;
		while(so_luong_thong_tin_can_sua==-1) {
			System.out.print("Ban muon sua bao nhieu thong tin cua tac gia (toi da 5): ");
			String sl=sc.nextLine();
			if(sl.matches("\\d+")) {
				so_luong_thong_tin_can_sua=Integer.parseInt(sl);
				if(so_luong_thong_tin_can_sua>5)
					return null;
				while(so_luong_thong_tin_can_sua!=0) {
					System.out.println("Sua thong tin cua tac gia '"+tacgia[i].getTen()+"'");
					tacgia[i].suathongtin();
					so_luong_thong_tin_can_sua--;
				}
			}else so_luong_thong_tin_can_sua=-1;
		}
		return tacgia[i];
	}
	public static void SuaTacgia() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		int so_luong_can_sua=-1;
		while(so_luong_can_sua==-1) {
		System.out.print("Nhap so luong tac gia can sua (Khong vuot qua "+tacgia.length+"): ");
		String sl=sc.nextLine();
			if(sl.matches("\\d+")) {
					so_luong_can_sua=Integer.parseInt(sl);
				if(so_luong_can_sua==0) {
					System.out.println("Khong sua tac gia");
					return;
				}
				if(so_luong_can_sua>tacgia.length)
					return;
				while(so_luong_can_sua!=0) {
					System.out.print("Nhap ma so tac gia can sua: ");
					String maso_tacgia_cansua=sc.nextLine();
					Sua(maso_tacgia_cansua);
					so_luong_can_sua--;
				}
			}else so_luong_can_sua=-1;
		}
	}
}
