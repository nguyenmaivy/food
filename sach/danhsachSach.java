package sach;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// import com.example.otherpackage.*;
import java.util.*;
public class danhsachSach {
	public static Scanner sc = new Scanner(System.in);
	private static int soluong=0;
	private static newsach sach[];
	public danhsachSach() {
	}
	public static int getSoluong() {
		return soluong;
	}
	public static void setSoluong(int soluong) {
		danhsachSach.soluong = soluong;
	}
	//nhập thông tin
	public static void nhapdanhsach() {
		while(soluong==0) {
			System.out.print("Nhap so luong sach: ");
			String sl=sc.nextLine();
			if(sl.matches("\\d+"))
				soluong=Integer.parseInt(sl);
			else soluong=0;
		}
		sach=new newsach[soluong];
		for(int i=0;i<sach.length;i++) {
			sach[i]=new newsach();
			System.out.println("Nhap thong tin sach");
			sach[i].nhap();
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
				if(sach==null) {
					sach= new newsach[1];
					i=0;
				}else {
					i=soluong;
					sach=Arrays.copyOf(sach, sach.length+1);
				}
				if(text.length==8&&Trunglap(text[0])==null&&!text[3].matches(".\\d.*")&&text[6].matches("\\d+\\d*\\.?\\,?")&&text[7].matches("\\d+")&&danhsachTacgia.Trunglap(text[3])!=null&&danhsachNXB.Trunglap(text[4])!=null&&danhsachTheloai.Trunglap(text[5])!=null) {
					if(sach[i]==null)
						sach[i]= new newsach();
					sach[i].capnhatsach(text[0], text[1], danhsachTacgia.Trunglap(text[3]), danhsachNXB.Trunglap(text[4]), danhsachTheloai.Trunglap(text[5]), Double.parseDouble(text[6]), Integer.parseInt(text[7]), 1);
					i++;
					soluong++;
					}else sach=Arrays.copyOf(sach, sach.length-1);
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
			FileWriter bin=new FileWriter("D:\\java\\java_project\\src\\sach\\sach_recyclebin.txt");
			int i=0;
			if(sach==null) {
				System.out.println("Danh sach rong");
				writefile.close();
				bin.close();
				return;
			}
			while(i<sach.length&&sach[i]!=null){
				if(sach[i].trangthai==1)
					writefile.write(sach[i].getTensach()+"#"+sach[i].getMasach()+"#"+sach[i].getTacgia().getTen()+"#"+sach[i].getNXB().getTenNXB()+"#"+sach[i].getTheloai().getTenTheloai()+"#"+sach[i].getGiaban()+"#"+sach[i].getSoluong()+"\n");
				else 
					bin.write(sach[i].getTensach()+"#"+sach[i].getMasach()+"#"+sach[i].getTacgia().getTen()+"#"+sach[i].getNXB().getTenNXB()+"#"+sach[i].getTheloai().getTenTheloai()+"#"+sach[i].getGiaban()+"#"+sach[i].getSoluong()+"\n");
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
	public static newsach Trunglap(String masach) {
		if(sach==null||sach[0]==null)
			return null;
		for(int i=0;i<sach.length;i++)
			if(sach[i]!=null)
				if(sach[i].getMasach()!=null&&sach[i].getMasach().equals(masach)) 
					return sach[i];
		return null;
	}
	//xuất thông tin
	public static void xuatdanhsach() {
		if(sach.length==0) {
			System.out.println("Khong co sach nao");
			return;
		}
		for(int i=0;i<sach.length;i++) {
			if(sach[i]!=null&&sach[i].trangthai==1) {
				System.out.println("");
				System.out.println(sach[i].xuat());
			}
		}
	}
	//thêm thông tin đối tượng 
	public static newsach Them() {
		int i;
		if(sach==null||sach[0]==null) {
			sach = new newsach[1];
			i=0;
		}else {
			sach=Arrays.copyOf(sach, sach.length+1);
			i=soluong;
		}
		sach[i]=new newsach();
		System.out.println("nhap thong tin sach");
		sach[i].nhap();
		soluong++;
		return sach[i];
	}
	public static void ThemSach() {
		int so_luong_can_them=-1;
		while(so_luong_can_them==-1) {
			System.out.print("So Luong sach can them: ");
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
	public static int Timkiem(String masach) {
		for(int i=0;i<sach.length;i++) {
			if(sach[i]!=null&&sach[i].trangthai==1&&sach[i].getMasach()!=null&&sach[i].getMasach().equals(masach))
				return i;
		}
		return -1;
	}
	public static void TimkiemSach() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		System.out.print("Nhap ma sach can tim: ");
		String masach=sc.nextLine();
		int i=Timkiem(masach);
		while(i==-1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon=Integer.parseInt(sc.nextLine());
			if(luachon==1) 
				TimkiemSach();
			else
				return;
		}
			 System.out.println(sach[i].xuat());
	}
	//xóa thông tin(xóa giả => ẩn thông tin)
	public static void Xoa() {
		System.out.print("Nhap ma sach can xoa: ");
		String masach=sc.nextLine();
		int i=Timkiem(masach);
		if(i==-1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon=Integer.parseInt(sc.nextLine());
			if(luachon==1)
				Xoa();
		}
		else {
			sach[i].trangthai=0;
			return;
		}
	}
	public static void XoaSach() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		int so_luong_can_xoa=-1;
		while(so_luong_can_xoa==-1) {
			System.out.print("Nhap so luong sach can xoa thong tin(khong vuot qua "+sach.length+"): ");
			String sl=sc.nextLine();
			if(sl.matches("\\d+")) {
				so_luong_can_xoa=Integer.parseInt(sl);
				if(so_luong_can_xoa==0) {
					System.out.println("Khong xoa sach");
					return;
				}
				if(so_luong_can_xoa>sach.length)
					return;
				while(so_luong_can_xoa!=0) {
					Xoa();
					so_luong_can_xoa--;
				}
			}
			else so_luong_can_xoa=-1;
		}
	}
	//khôi phục thông tin đã xóa
	public static newsach Khoiphuc(String masach_cankhoiphuc) {
		for(int i=0;i<sach.length;i++)
			if(sach[i].getMasach()!=null&&sach[i].getMasach().equals(masach_cankhoiphuc)&&sach[i].trangthai==0) {
				sach[i].trangthai=1;
				return sach[i];
			}
		return null;
	}
	public static void KhoiphucSach() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		int soluong_sach_cankhoiphuc=-1;
		while(soluong_sach_cankhoiphuc==-1) {
		System.out.print("Nhap so luong sach can khoi phuc thong tin(khong vuot qua "+sach.length+"): ");
		String sl=sc.nextLine();
			if(sl.matches("\\d+")) {
				soluong_sach_cankhoiphuc=Integer.parseInt(sl);
				if(soluong_sach_cankhoiphuc>sach.length)
					return;
				for(int i=0;i<soluong_sach_cankhoiphuc;i++) {
					System.out.print("Nhap ma sach can khoi phuc: ");
					String tensach_cankhoiphuc=sc.nextLine();
					Khoiphuc(tensach_cankhoiphuc);
				}
			}else soluong_sach_cankhoiphuc=-1;
		}
	}
	//sửa thông tin 
	public static newsach Sua(String ten_sach_cansua) {
			int i=Timkiem(ten_sach_cansua);
			if(i==-1) {
				System.out.println("Khong tim thay");
				System.out.println("1.Tiep tuc tim kiem");
				System.out.println("2.Thoat tim kiem");
				int luachon=Integer.parseInt(sc.nextLine());
				System.out.print("Nhap Ma sach can sua thong tin: ");
				switch(luachon) {
				case 1: System.out.print("Nhap Ma sach can sua thong tin: ");
					 	return Sua(sc.nextLine());
				default:		
						return null;
				}
			}
			int so_luong_thong_tin_can_sua=-1;
			while(so_luong_thong_tin_can_sua==-1) {
				System.out.println("Ban muon sua bao nhieu thong tin cua sach(toi da 7): ");
				String sl=sc.nextLine();
				if(sl.matches("\\d+")) {
					so_luong_thong_tin_can_sua=Integer.parseInt(sl);
					if(so_luong_thong_tin_can_sua>7)
						return null;
					while(so_luong_thong_tin_can_sua!=0) {
						System.out.println("Sua thong tin cua sach '"+sach[i].getTensach()+"'");
					sach[i].suathongtin();
					so_luong_thong_tin_can_sua--;
					}
				}else so_luong_thong_tin_can_sua=-1;
			}
		return sach[i];
	}
	public static void SuaSach() {
		if(soluong==0) {
			System.out.println("Danh sach rong");
			return;
		}
		int so_luong_can_sua=-1;
		while(so_luong_can_sua==-1) {
			System.out.print("Nhap so luong sach can sua thong tin(khong vuot qua "+sach.length+"): ");
			String sl=sc.nextLine();
			if(sl.matches("\\d+")) {
				so_luong_can_sua=Integer.parseInt(sl);
				if(so_luong_can_sua==0) {
					System.out.println("Khong sua sach");
					return;
				}
				if(so_luong_can_sua>sach.length)
					return;
				while(so_luong_can_sua!=0) {
					System.out.print("Nhap Ma sach can sua thong tin: ");
					String maso_sach_cansua=sc.nextLine();
					Sua(maso_sach_cansua);
					so_luong_can_sua--;
					}
				}else so_luong_can_sua=-1;
		}
	}
}
