package danhSachClass;

import java.util.Scanner;

public class DSNHANVIEN {
	private NHANVIEN ds[];
	public DSNHANVIEN() {
		khoiTaoDS();
	}
	
	public DSNHANVIEN(NHANVIEN[] ds) {
		this.ds = ds;
	}

	
	public NHANVIEN[] getDs() {
		return ds;
	}

	public void setDs(NHANVIEN[] ds) {
		this.ds = ds;
	}

	public static Scanner getSc() {
		return sc;
	}

	public static void setSc(Scanner sc) {
		DSNHANVIEN.sc = sc;
	}


	static Scanner sc = new Scanner(System.in);

	public void xuatDSNV() {
		System.out.println(String.format("%-20s %-8s %-15s %-14s %-10s", "Ten NV" , "Ma NV" , "Gioi Tinh" , "Di Dong","Ngay Sinh")  + "\t" + String.format("%-20s %-20s %-20s %-10s", "thoiGianLamViec" , "chucVu","\tDoi Tuong/Nguoi QL","Luong")+ "\t");
		for (NHANVIEN i : ds) {
			System.out.println(i.toString());
		}
	}

	public void timKiemNV() { // tÃ¬m kiáº¿m vÃ  xuáº¥t thÃ´ng tin theo mÃ£ nhÃ¢n viÃªn
		System.out.print("Vui long nhap ma nhan vien : ");
		String maso = sc.nextLine();
		for (NHANVIEN i : ds) {
			if ((i.getMaNV().equals(maso))) {
				System.out.println(i.toString());
			}
		}
	}

	public void khoiTaoDS() {
		ds = new NHANVIEN[5];
		ds[0] = new QUANLY("Duong Thanh Truong", "QL1011", "Nam", "0811351942", "12-11-1995", "7h-22h",
				"Tat ca nhan vien", "Quan Ly", 0.5);
		ds[1] = new NHANVIENBANHANG("Tran Trong Hieu", "BH1032", "Nam", "0948215031", "9-10-2003", "7h-14h",
				"Nhan vien ban thit", "Duong Thanh Truong", 28);
		ds[2] = new NHANVIENBANHANG("Nguyen Dinh Hoan Duy", "BH1033", "Nam", "0902221152", "11-10-2000", "15h-22h",
				"Nhan vien tu van", "Duong Thanh Truong", 29);
		ds[3] = new NHANVIENTHUNGAN("Nguyen Dang Vu Tien", "TN1034", "Nu", "0946213205", "29-1-1999", "7h-14h",
				"Duong Thanh Truong", "Thu ngan ", 28);
		ds[4] = new NHANVIENTHUNGAN("Nguyen Van Minh Phuc", "TN1035", "Nu", "0984213151", "28-2-2001", "15h-22h",
				"Duong Thanh Truong", "Thu ngan ", 29);
	}

}
