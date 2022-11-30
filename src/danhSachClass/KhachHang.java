package danhSachClass;

import java.util.Scanner;
public class KhachHang implements XuatTT{
    protected String maKH;
    protected String tenKH;
    protected String diaChi;
    protected int diemTichLuy=0;
    Scanner sc=new Scanner(System.in);

    public KhachHang(String MaKH, String TenKH, String DiaChi, int diemTichLuy) {
        this.maKH = MaKH;
        this.tenKH = TenKH;
        this.diaChi = DiaChi;
        this.diemTichLuy = diemTichLuy;
    }

    public KhachHang() {
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String MaKH) {
        this.maKH = MaKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String TenKH) {
        this.tenKH = TenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }
    
    public void nhapMaKH(){
        do{
            System.out.println("Hay nhap maKH hop le(6 so):");
            maKH=sc.nextLine();
        }
        while(maKH.length()!=6 || !DSKH.checkMaKH(maKH));
    }
    public void nhapTenKH(){
        System.out.println("Hay nhap ten KH:");
        tenKH=sc.nextLine();
    }
    public void nhapDiaChi(){
        System.out.println("Hay nhap DiaChi:");
        diaChi=sc.nextLine();
    }
    protected void updateDiemTichLuy(int a){
        this.diemTichLuy+=a;
    }
    public void nhapTTKH(){
        nhapMaKH();
        nhapTenKH();
        nhapDiaChi();
    }
    public static String ShowHeader(){
        return String.format("|%-10s|%-15s|%-15s|","MAKH","TENKH","DIACHI");
    }
    @Override
    public String toString() {
        return String.format("|%-10s|%-15s|%-15s|",maKH,tenKH,diaChi); 
    }
    @Override
    public void xuatTT(){
        System.out.println(toString());
    }
    
}

