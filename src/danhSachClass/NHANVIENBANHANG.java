package danhSachClass;

public class NHANVIENBANHANG extends NHANVIEN{
    private String nguoiQuanLy ;
    private int ngayCong;
    public NHANVIENBANHANG() {
        super();
    }
    
    public NHANVIENBANHANG(String tenNV, String maNV, String gioiTinh, String diDong, String ngaySinh,
    String thoiGianLamViec,String chucVu, String nguoiQuanLy, int ngayCong) {
        super(tenNV, maNV, gioiTinh, diDong, ngaySinh, thoiGianLamViec,chucVu);
        this.nguoiQuanLy = nguoiQuanLy;
        this.ngayCong = ngayCong;
    }

    public String getNguoiQuanLy() {
        return nguoiQuanLy;
    }

    public void setNguoiQuanLy(String nguoiQuanLy) {
        this.nguoiQuanLy = nguoiQuanLy;
    }

    public int getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }
    @Override
    public int luongCoBan() {
        return ngayCong * 210000;
    }
    @Override
    public double tienThuong() {
        return 0.25*luongCoBan();
    }
    @Override
    public String toString() {
        return super.toString() + String.format(nguoiQuanLy );
    }
}

