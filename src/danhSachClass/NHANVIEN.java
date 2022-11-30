package danhSachClass;

public abstract class NHANVIEN{
    private String tenNV , maNV , gioiTinh , diDong ;
    private String ngaySinh ;
    private String thoiGianLamViec ;
    private String chucVu;
    public NHANVIEN(){
    }
    public NHANVIEN(String tenNV, String maNV, String gioiTinh, String diDong, String ngaySinh,
    String thoiGianLamViec,String chucVu) {
        this.tenNV = tenNV;
        this.maNV = maNV;
        this.gioiTinh = gioiTinh;
        this.diDong = diDong;
        this.ngaySinh = ngaySinh;
        this.thoiGianLamViec = thoiGianLamViec;
        // this.luong = getLuong();
        this.chucVu = chucVu;
    }
    public String getTenNV() {
        return tenNV;
    }
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getDiDong() {
        return diDong;
    }
    public void setDiDong(String diDong) {
        this.diDong = diDong;
    }
    public String getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getThoiGianLamViec() {
        return thoiGianLamViec;
    }
    public void setThoiGianLamViec(String thoiGianLamViec) {
        this.thoiGianLamViec = thoiGianLamViec;
    }
    public double getLuong() {
        return luongCoBan() + tienThuong() ;
    }
    public String getChucVu() {
        return chucVu;
    }
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    // Phương thức abstract 
    public abstract int luongCoBan();
    public abstract double tienThuong();
    
    @Override
    public String toString() {
        return String.format("%-20s %-8s %-15s %-14s", tenNV , maNV , gioiTinh , diDong) + ngaySinh.toString() + "\t" + String.format("%-20s %-20s %-10f", thoiGianLamViec , chucVu,getLuong())+ "\t";
    }
}
