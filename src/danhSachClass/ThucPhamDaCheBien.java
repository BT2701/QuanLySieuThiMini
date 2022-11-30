package danhSachClass;

import java.io.BufferedReader;
import java.io.FileReader;

public class ThucPhamDaCheBien extends ThucPham{

	public ThucPhamDaCheBien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThucPhamDaCheBien(String tenSP, String maSP, String nhaCC, double tienGoc, double tenBanRa, int sl_nhap,
			int sl_ton, NGAYTHANGNAM hsd) {
		super(tenSP, maSP, nhaCC, tienGoc, tenBanRa, sl_nhap, sl_ton, hsd);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void layThongTinMotSanPham() {

		try {
			// đọc file danh sách sản phẩm
			FileReader fr = new FileReader("thucPhamDaCheBien.TXT");
			BufferedReader br = new BufferedReader(fr);
			// line đọc từng dòng của file dssp.txt
			String line = br.readLine();
			// cắt chuỗi thành mảng thông qua dấu phẩy
			String temp[] = line.split(",");

			// khởi tạo giá trị
			this.setTenSP(temp[0]);
			this.setMaSP(temp[1]);
			this.setNhaCC(temp[2]);
			this.setTienGoc(Double.parseDouble(temp[3]));
			this.setTenBanRa(Double.parseDouble(temp[4]));
			this.setSl_nhap(Integer.parseInt(temp[5]));
			this.setSl_ton(Integer.parseInt(temp[6]));
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
	@Override
	public void xuatHoaDon1SP() {
		System.out.println("---GIAN HÀNG THỰC PHẨM---");
		System.out.printf("\t\t thực phẩm đã chế biến\n");
		System.out.println("sản phẩm bạn đã mua: " + this.getTenSP());
		System.out.println("mã sản phẩm: " + this.getMaSP());
		System.out.println("số lượng bạn đã mua: "+this.getSoLuongSpDaMua());
		System.out.println("có giá: " + tongTienTren1SP()+"VND");
		System.out.println("-------------------------------------");
		System.out.println();
	}
}
