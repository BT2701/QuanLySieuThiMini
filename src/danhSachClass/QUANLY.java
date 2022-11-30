package danhSachClass;

public class QUANLY extends NHANVIEN {
	private String doiTuongQuanLy;
	private double heSoLuong;

	public QUANLY() {
		super();
	}

	public QUANLY(String tenNV, String maNV, String gioiTinh, String diDong, String ngaySinh, String thoiGianLamViec,
			String doiTuongQuanLy, String chucVu, double heSoLuong) {
		super(tenNV, maNV, gioiTinh, diDong, ngaySinh, thoiGianLamViec, chucVu);
		this.doiTuongQuanLy = doiTuongQuanLy;
		this.heSoLuong = heSoLuong;
	}

	public String getDoiTuongQuanLy() {
		return doiTuongQuanLy;
	}

	public void setDoiTuongQuanLy(String doiTuongQuanLy) {
		this.doiTuongQuanLy = doiTuongQuanLy;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(doiTuongQuanLy);
	}

	@Override
	public int luongCoBan() {
		return 8000000;
	}

	@Override
	public double tienThuong() {
		return heSoLuong * luongCoBan();
	}

}
