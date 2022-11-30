package danhSachClass;

import java.util.Scanner;

public class NGAYTHANGNAM {
	private int ngay;
	private int thang;
	private int nam;
	Scanner sc = new Scanner(System.in);

	public NGAYTHANGNAM() {
	}

	public NGAYTHANGNAM(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}

	public int getNgay() {
		return ngay;
	}

	public void setNgay(int ngay) {
		this.ngay = ngay;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public void nhap() {
		System.out.println("Nhap ngay: ");
		for (;;) {
			ngay = Integer.parseInt(sc.nextLine());
			if (ngay > 31)
				System.out.println("Nhap lai ngay: ");
			else
				break;
		}
		System.out.println("Nhap thang: ");
		for (;;) {
			thang = Integer.parseInt(sc.nextLine());
			if (thang > 12)
				System.out.println("Nhap lai thang: ");
			else
				break;
		}
		System.out.println("Nhap nam: ");
		for (;;) {
			nam = Integer.parseInt(sc.nextLine());
			if (nam > 9999)
				System.out.println("Nhap lai nam: ");
			else
				break;
		}
	}

	public void inNgay() {
		System.out.println("Ngay: " + ngay);
	}

	public void inThang() {
		System.out.println("Thang: " + thang);
	}

	public void inNam() {
		System.out.println("Nam: " + nam);
	}

	public void inNgayThangNam() {
		System.out.println("NTN: " + ngay + "/" + thang + "/" + nam);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ngay + "/" + thang + "/" + nam;
	}
}
