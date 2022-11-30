package danhSachClass;

public class Voucher1 extends Voucher{

    public Voucher1(){
        loaiVC=1;
    }
    public Voucher1(long soTienGiam) {
        loaiVC=1;
        this.soTienGiam = soTienGiam;
    }

    public Voucher1(long soTienGiam, String maVC) {
        loaiVC=1;
        this.maVC=maVC;
        this.soTienGiam = soTienGiam;
    }
    
    public void nhapSoTienGiam(){
        System.out.println("Hay nhap soTienGiam:");
        soTienGiam=Long.parseLong(sc.nextLine());
    }

    @Override
    public void nhapLoaiVC() {
        System.out.println("Voucher nay la loai 1, ban k the nhap lai");
    }

    
    @Override
    public void nhapTTVC() {
        super.nhapMaVC();
        nhapSoTienGiam();
    }
    
    @Override
    public String toString() {
        return super.toString()+String.format("%-10d",soTienGiam);
    }
}

