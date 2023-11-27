package final0;
import java.util.Scanner;
public abstract class ConNguoi {
    public Scanner sc=new Scanner(System.in);
    //thuoc tinh
    private String ten, gioiTinh;
    private int tuoi;
    //constructor
    public ConNguoi(String ten, String gioiTinh, int tuoi){
        this.ten=ten;
        this.tuoi=tuoi;
        this.gioiTinh=gioiTinh;
    }
    public ConNguoi(){

    }
    //getter_setter
    public String getTen(){
        return ten;
    }
    public void setTen(String ten){
        this.ten=ten;
    }
    public String getGioiTinh(){
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh){
        this.gioiTinh=gioiTinh;
    }
    public int getTuoi(){
        return tuoi;
    }
    public void setTuoi(int tuoi){
        this.tuoi=tuoi;
    }
    //cac phuong thuc nhap_xuat
    public void nhap() {
		while(this.ten==null||this.ten.isEmpty()){
			System.out.print("Nhap Ho va Ten: ");
			String newTen=sc.nextLine();
			if(!newTen.matches(".*\\d.*"))
				this.ten=newTen;
			else
				this.ten=null;
		}
		while(this.tuoi<=0||this.tuoi>200){
			System.out.print("Nhap Tuoi: ");
			String newTuoi=sc.nextLine();
			if(newTuoi.matches("\\d+"))
				this.tuoi=Integer.parseInt(newTuoi);
			else
				this.tuoi=0;
		}
		while(this.gioiTinh==null||this.gioiTinh.isEmpty()){
			System.out.print("Nhap Gioi tinh: ");
			this.gioiTinh=sc.nextLine();
		}
	}
    public void suaThongTin() {
		System.out.println("1.Sua Ho va Ten");
		System.out.println("2.Sua Tuoi");
        System.out.println("3.Sua Gioi tinh");
		System.out.print("Nhap lua chon: ");
		int chon=Integer.parseInt(sc.nextLine());
		boolean exitLoop=false;
		switch(chon) {
		case 1:
			while(!exitLoop){
				System.out.print("Nhap Ho va Ten moi: ");
				String newTen=sc.nextLine();
				if(!newTen.equals(this.ten)) {
					this.ten=newTen;
					exitLoop=true;
				}
			}
			break;
		case 2:	while(!exitLoop){
				System.out.print("Nhap Tuoi moi: ");
				String newTuoi=sc.nextLine();
					if(newTuoi.matches("\\d+")&&Integer.parseInt(newTuoi)!=this.tuoi&&Integer.parseInt(newTuoi)>0&&Integer.parseInt(newTuoi)<200) {
						this.tuoi=Integer.parseInt(newTuoi);
						exitLoop=true;
					}
				}
			break;
		case 3:	while(!exitLoop){
				System.out.print("Nhap Gioi tinh moi: ");
				String newGioiTinh=sc.nextLine();
				if(!newGioiTinh.equals(this.gioiTinh)) {
					this.gioiTinh=newGioiTinh;
					exitLoop=true;
				}
			}
			break;
		}
	}
    public String xuat() {
		return String.format("Ho va Ten: %-20s|Tuoi: %-3s|Gioi tinh: %-3s",ten,tuoi,gioiTinh);
	}
}
