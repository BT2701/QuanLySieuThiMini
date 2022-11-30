package danhSachClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class SanPham {
	// CC nghĩa là cung cấp
	private String tenSP;
	private String maSP;
	private String nhaCC;
	private double tienGoc; // giá gôc
	private double tienBanRa; // giá bán
	private int sl_nhap;
	private int sl_ton;
	protected NGAYTHANGNAM hsd;
	private int soLuongSpDaMua=0;
	static Scanner sc = new Scanner(System.in);

	public SanPham() {

	}

	public SanPham(String tenSP, String maSP, String nhaCC, double tienGoc, double tenBanRa, int sl_nhap, int sl_ton,
			NGAYTHANGNAM hsd) {
		this.tenSP = tenSP;
		this.maSP = maSP;
		this.tienGoc = tienGoc;
		this.tienBanRa = tenBanRa;
		this.sl_nhap = sl_nhap;
		this.sl_ton = sl_ton;
		this.hsd = hsd;
		this.nhaCC = nhaCC;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public double getTienGoc() {
		return tienGoc;
	}

	public void setTienGoc(double tienGoc) {
		this.tienGoc = tienGoc;
	}

	public double getTenBanRa() {
		return tienBanRa;
	}

	public void setTenBanRa(double tenBanRa) {
		this.tienBanRa = tenBanRa;
	}

	public int getSl_nhap() {
		return sl_nhap;
	}

	public void setSl_nhap(int sl_nhap) {
		this.sl_nhap = sl_nhap;
	}

	public int getSl_ton() {
		return sl_ton;
	}

	public void setSl_ton(int sl_ton) {
		this.sl_ton = sl_ton;
	}

	public NGAYTHANGNAM getHsd() {
		return hsd;
	}

	public void setHsd(NGAYTHANGNAM hsd) {
		this.hsd = hsd;
	}

	public String getNhaCC() {
		return nhaCC;
	}

	public void setNhaCC(String nhaCC) {
		this.nhaCC = nhaCC;
	}

	public int getSoLuongSpDaMua() {
		return soLuongSpDaMua;
	}

	public void setSoLuongSpDaMua(int soLuongSpDaMua) {
		this.soLuongSpDaMua = soLuongSpDaMua;
	}

	public void layThongTinMotSanPham() {

		try {
			// đọc file danh sách sản phẩm
			FileReader fr = new FileReader("DSSP.TXT");
			BufferedReader br = new BufferedReader(fr);
			// line đọc từng dòng của file dssp.txt
			String line = br.readLine();
			// cắt chuỗi thành mảng thông qua dấu phẩy
			String temp[] = line.split(",");

			// khởi tạo giá trị
			this.tenSP = temp[0];
			this.maSP = temp[1];
			this.nhaCC = temp[2];
			this.tienGoc = Double.parseDouble(temp[3]);
			this.tienBanRa = Double.parseDouble(temp[4]);
			this.sl_nhap = Integer.parseInt(temp[5]);
			this.sl_ton = Integer.parseInt(temp[6]);
			// cắt chuỗi ngày tháng năm của hạn sử dụng
			String date[] = temp[7].split("-");
			hsd = new NGAYTHANGNAM();
			this.hsd.setNgay(Integer.parseInt(date[0]));
			this.hsd.setThang(Integer.parseInt(date[1]));
			this.hsd.setNam(Integer.parseInt(date[2]));
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void nhapSanPham() {
		System.out.println("sản phẩm nhập vào: ");
		System.out.println("tên sản phẩm: ");
		setTenSP(sc.nextLine());
		System.out.println("mã sản phẩm: ");
		setMaSP(sc.nextLine());
		System.out.println("nhà cung cấp: ");
		setNhaCC(sc.nextLine());
		System.out.println("tiền gốc: ");
		setTienGoc(Double.parseDouble(sc.nextLine()));
		System.out.println("tiền bán ra: ");
		setTenBanRa(Double.parseDouble(sc.nextLine()));
		System.out.println("số lượng nhập: ");
		setSl_nhap(Integer.parseInt(sc.nextLine()));
		System.out.println("số lượng tồn: ");
		setSl_ton(Integer.parseInt(sc.nextLine()));
		System.out.println("---hạn sử dụng---");
		System.out.println("nhập ngày: ");
		int ngay=Integer.parseInt(sc.nextLine());
		System.out.println("nhập tháng: ");
		int thang=Integer.parseInt(sc.nextLine());
		System.out.println("nhập năm: ");
		int nam=Integer.parseInt(sc.nextLine());
		hsd=new NGAYTHANGNAM(ngay, thang, nam);
	}
	public boolean kiemTraSP(String maSP) {
		if(maSP.equalsIgnoreCase(this.maSP))
			return true;
		return false;
	}
	public double tongTienTren1SP() {
		return this.tienBanRa * this.soLuongSpDaMua;
	}
	public double tienLoiTren1SP() {
			return this.tienBanRa-this.tienGoc;
	}
	public double tongTienLoiTren1SP() {
		return tienLoiTren1SP()*this.soLuongSpDaMua;
	}
	@Override
	public String toString() {
		return "tenSP=" + tenSP + ", maSP=" + maSP + ", nhaCC=" + nhaCC + ", giaGoc=" + tienGoc + ", giaBanRa="
				+ tienBanRa + ", sl_nhap=" + sl_nhap + ", sl_ton=" + sl_ton + ", hsd=" + hsd
				+ ", số lượng bạn đã mua cho sản phẩm này: " + this.soLuongSpDaMua;
	}
	
	public String toString1() {
        return String.format("|%-10s|%-15s|%-10d|%-6d|",maSP,tenSP,tienBanRa,this.sl_ton); 
    }

	public static String ShowHeader(){
        return String.format("|%-10s|%-15s|%-10s|%-6s|","MASP","TENSP","GIABAN","SL_TON");
    }
	public void xuatHoaDon1SP() {
		System.out.println("sản phẩm bạn đã mua: " + this.tenSP);
		System.out.println("mã sản phẩm: " + this.maSP);
		System.out.println("số lượng bạn đã mua: "+this.soLuongSpDaMua);
		System.out.println("có giá: " + tongTienTren1SP()+"VND");
		System.out.println("-------------------------------------");
		System.out.println();
	}
	public void xuatTT(){
        System.out.println(toString1());
    }
	public void xuatThongTinSanPham() {
		System.out.println(toString());
		System.out.println("--------------------");
		System.out.println();
	}
}
