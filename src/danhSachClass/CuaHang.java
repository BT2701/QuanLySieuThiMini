package danhSachClass;

import java.util.Scanner;

public class CuaHang {
	Scanner sc = new Scanner(System.in);
	private String tenCuaHang="G5 mart";
	private String diaChi;
	private String lienHe;
	private DanhSachSanPham ds=new DanhSachSanPham();
	public CuaHang() {

	}

	public CuaHang(String tenCuaHang, String diaChi, String lienHe) {
		super();
		this.tenCuaHang = tenCuaHang;
		this.diaChi = diaChi;
		this.lienHe = lienHe;
	}

	public String getTenCuaHang() {
		return tenCuaHang;
	}

	public void setTenCuaHang(String tenCuaHang) {
		this.tenCuaHang = tenCuaHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLienHe() {
		return lienHe;
	}

	public void setLienHe(String lienHe) {
		this.lienHe = lienHe;
	}

	public void nhap() {
		do {
			System.out.println("Nháº­p tÃªn cá»­a hÃ ng");
			tenCuaHang = sc.nextLine();
		} while (tenCuaHang.length() == 0);

		do {
			System.out.println("Nháº­p Ä‘á»‹a chá»‰ cá»­a hÃ ng");
			diaChi = sc.nextLine();
		} while (diaChi.length() == 0);
		do {
			System.out.println("Nháº­p liÃªn há»‡ vá»›i cá»­a hÃ ng");
			lienHe = sc.nextLine();
		} while (lienHe.length() == 0);
	}
	
	public void nhapHang() {
		ds.layThongTinSanPham();
		SanPham []dssp=ds.getDsSanPham();
		for(int i=0;i<dssp.length;i++) {
			if(dssp[i].getSl_ton()<10) {	//nếu số lượng tồn kho dưới 10 thì sẽ nhập hàng
				dssp[i].setSl_nhap(100);	//mỗi lần nhập hàng 100 sản phẩm
				dssp[i].setSl_ton(dssp[i].getSl_ton()+100); 	//cập nhật lại số lượng tồn trong kho
			}
		}
	}
	public void banHang() {
		ds.layThongTinSanPham();
		ds.muaSP();
	}
	@Override
	public String toString() {
		return String.format("|%-15s|%-20s|%-10s|", tenCuaHang, diaChi, lienHe);
	}

	public String ShowHeader() {
		return String.format("|%-20s|%-20s|%-10s|", "Ten Cua Hang", "Dia Chi", "Lien He");
	}

	public void xuat() {
		System.out.println(toString());
	}
	
}
