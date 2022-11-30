package danhSachClass;

public class Voucher2 extends Voucher {

    public Voucher2(){
        loaiVC=2;
    }

    public Voucher2(String maSP, int tyLeGiam) {
        loaiVC=2;
        this.maSP = maSP;
        this.tyLeGiam = tyLeGiam;
    }

    public Voucher2(String maSP, int tyLeGiam, String maVC) {
        loaiVC=2;
        this.maVC=maVC;
        this.maSP = maSP;
        this.tyLeGiam = tyLeGiam;
    }
    
    public void nhapTyLeGiam(){
        System.out.println("Hay nhap tyLeGiam:");
        tyLeGiam=Integer.parseInt(sc.nextLine());
    }
    @Override
    public void nhapLoaiVC() {
        System.out.println("Voucher nay la loai 2, ban k the nhap lai");
    }

    @Override
    public void nhapTTVC() {
        super.nhapMaVC(); 
        nhapTyLeGiam();
    }
    
    @Override
    public String toString() {
        return super.toString()+String.format("%-10d|%-10s|",tyLeGiam,maSP);
    }
}

