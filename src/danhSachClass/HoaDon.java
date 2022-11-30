package danhSachClass;

import static java.lang.Math.pow;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;

public class HoaDon implements XuatTT {
	protected static int soHD = 0;
	protected int indexKH;
	protected int vCIndex[] = new int[0];
	protected Date date;
	private DanhSachSanPham danhSachSP=new DanhSachSanPham();
	private SanPham []DSSP=danhSachSP.getDsSanPham();
	private DSNHANVIEN danhSachNV=new DSNHANVIEN();
	private NHANVIEN []DSNV=danhSachNV.getDs();
	private CuaHang cH=new CuaHang();
	private DSKH danhSachKH=new DSKH() {
	};
	private DSVC danhSachVoucher=new DSVC() {
	};
	protected double tienGiam = 0;
	protected String chiTietTT;
	protected Scanner sc = new Scanner(System.in);

	public HoaDon() {
		setMaHD();
	}

	public static void setMaHD() {
		soHD += 1;
	}

	public static int getSoHD() {
		return soHD;
	}

	public static void setSoHD(int soHD) {
		HoaDon.soHD = soHD;
	}

	public int getIndexKH() {
		return indexKH;
	}

	public void setIndexKH(int indexKH) {
		this.indexKH = indexKH;
	}

	public int[] getvCIndex() {
		return vCIndex;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTienGiam() {
		return tienGiam;
	}

	public void setTienGiam(double tienGiam) {
		this.tienGiam = tienGiam;
	}

	public String getChiTietTT() {
		return chiTietTT;
	}

	public void setChiTietTT(String chiTietTT) {
		this.chiTietTT = chiTietTT;
	}

	public void nhapKH() {
		System.out.println("---------------------------Nhap KH----------------------------\n");
		String maKH;
		do {
			System.out.println("Hay nhap maKH hop le:");
			maKH = sc.nextLine();
			if (!danhSachKH.checkMaKH(maKH))
				break;
		} while (true);
		indexKH = DSKH.KHIndex(maKH);
	}

	public void nhapVC() {
		System.out.println("---------------------------Nhap Voucher----------------------------\n");
		String maVC;
		while(true) {
			System.out.println("Hay nhap maVC hop le (Nhap 0 de ket thuc):");
			maVC = sc.nextLine();
			if(Integer.parseInt(maVC)==0)
				break;
			else if(DSVC.checkMaVC(maVC)) {
				System.out.println("maVC k hop le");
			}
			else
				System.out.println("nhap ma VC thanh cong");
		}
	}

	public void banHang() {
		danhSachSP.muaSP();
	}
	public void timTTSP() {
		danhSachSP.timSP();
	}
	public void xuatDSSP() {
		danhSachSP.xuatDSSP();
	}
	public void xuatDSVC() {
		danhSachVoucher.xuatTT();
	}
	public void xuatDSNV() {
		danhSachNV.xuatDSNV();
	}
	public void timTTNV() {
		danhSachNV.timKiemNV();
	}
	public void themSpDS() {
		danhSachSP.ThemSpVaoDS();
	}
	public void nhapChiTietTT() {
		System.out.println("---------------------------Nhap CTTT----------------------------\n");
		int temp;
		do {
			System.out.println("Hay nhap pt thanh toan: \n1. The ngan hang \n2. Tien mat\n ");
			temp = Integer.parseInt(sc.nextLine());
		} while (temp > 2 || temp < 1);
		if (temp == 1)
			chiTietTT = "The ngan hang ";
		else
			chiTietTT = "Tien mat ";
	}
	
	public void nhapTTHD() {
		nhapKH();
		nhapVC();
		nhapChiTietTT();
	}
	public int ranDomNV() {
		return(int)((Math.random())*(2)+1);
	}
	int viTriNV=ranDomNV();
	@Override
	public String toString() { // and total
		String toString = "";
		toString += "----------------------------------------------------------------------------------------------\n";
		toString += "----------------------Phieu Tinh Tien-----------------------\n";
		toString += String.format("Thoi gian lap phieu: %s\n", stringDate());
		toString += "NV: " + DSNV[viTriNV].getMaNV() + "-" + DSNV[viTriNV].getTenNV() + "     " + "So HD: "
				+ String.format("%d", soHD) + "\n";
		toString += "----------------------------------------------------------------------\n";
		toString += String.format("|%-10s|%-25s|%-10s|%-10s|%-10s|\n", "MaSP", "Ten", "SL", "Don Gia", "Thanh Tien");
		toString += "----------------------------------------------------------------------\n";
		for (int i = 0; i < DSSP.length; i++) {
			if(DSSP[i].getSoLuongSpDaMua()>0) {
				toString += String.format("|%-10s|%-25s|%-10d|%-10f|%-10f|\n", DSSP[i].getMaSP(),
						DSSP[i].getTenSP(), DSSP[i].getSoLuongSpDaMua(), DSSP[i].getTenBanRa(),
						DSSP[i].tongTienTren1SP());
			}
		}
		toString += "----------------------------------------------------------------------\n";
		toString += String.format("%-33s%10f\n", "Tong tien", danhSachSP.tongTien());
		for (int i = 0; i < vCIndex.length; i++) {
			if (DSVC.DSVC[vCIndex[i]].loaiVC == 1)
				tienGiam += DSVC.DSVC[vCIndex[i]].soTienGiam;
			else {
				for (int j = 0; j < DSSP.length; j++) {
					if (DSVC.DSVC[vCIndex[i]].maSP.equals(DSSP[j].getMaSP()))
						tienGiam += DSVC.DSVC[vCIndex[i]].tyLeGiam * DSSP[i].getTenBanRa() / 100;
				}
			}
		}
		toString += "----------------------------------------------------------------------\n";
		toString += String.format("%-33s%10f\n", "Tong tien giam gia", tienGiam);
		toString += "----------------------------------------------------------------------\n";
		toString += String.format("%-43s\n", "Chi tiet thanh toan");
		double temp = danhSachSP.tongTien() - tienGiam;
		toString += String.format("%-33s%10f\n", chiTietTT, temp);
		toString += "----------------------------------------------------------------------\n";
		toString += "Tran trong cam on Quy Khach da den mua hang tai " + cH.getTenCuaHang() + ". Hen gap lai.\n";
		toString += "----------------------------------------------------------------------------------------------\n";
		return toString;
	}

	public String stringDate() {
		date = new Date();
		return date.toString();
	}

	@Override
	public void xuatTT() { // va ghi file
		String temp = toString();
		System.out.println(temp);
		// Ghi File de
	}

	public void kiemTraTichDiem() {
		if (danhSachSP.tongTien() > pow(10, 6))
			DSKH.DSKH[indexKH].updateDiemTichLuy((int) (danhSachSP.tongTien() / 8000));
		else if (danhSachSP.tongTien() > pow(10, 5))
			DSKH.DSKH[indexKH].updateDiemTichLuy((int) (danhSachSP.tongTien() / 9000));// 800k 100
		else
			DSKH.DSKH[indexKH].updateDiemTichLuy((int) (danhSachSP.tongTien() / 10000)); // 90k 9
	}
	public void thongKe() {
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println(String.format("---vào ngày: %s\n", stringDate())); 
		System.out.printf("\t\tNHUNG SAN PHAM DA DUOC BAN\n");
		System.out.println(String.format("|%-10s|%-25s|%-10s|%-10s|%-10s|%-20s|\n", "MaSP", "Ten", "SL", "Don Gia", "Thanh Tien","số lượng tồn kho"));
		for (int i = 0; i < DSSP.length; i++) {
			if(DSSP[i].getSoLuongSpDaMua()>0) {
				System.out.println(String.format("|%-10s|%-25s|%-10d|%-10f|%-10f|%-20d|\n", DSSP[i].getMaSP(),
						DSSP[i].getTenSP(), DSSP[i].getSoLuongSpDaMua(), DSSP[i].getTenBanRa(),
						DSSP[i].tongTienTren1SP(),DSSP[i].getSl_ton()));
			}
		}
		System.out.printf("TONG SO SAN PHAM BAN DUOC: %d\n",danhSachSP.tongSpDaMua());
		System.out.printf("TONG SO TIEN BAN DUOC: %f\n",danhSachSP.tongTien());
		System.out.printf("SO TIEN LOI KHI BAN HANG: %f\n",danhSachSP.tongTienLoi());
	}

}
