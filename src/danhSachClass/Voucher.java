package danhSachClass;

import java.util.Scanner;
public class Voucher implements XuatTT{
    protected String maVC;
    protected int loaiVC=0;
    protected long soTienGiam;
    protected int tyLeGiam;
    protected String maSP;
    protected Scanner sc=new Scanner(System.in);
    //1 la Voucher theo tien 10k,20k
    //2 la Voucher di kem maVC
    public Voucher(){
    }

    public Voucher(String maVC, int loaiVC) {
        this.maVC = maVC;
        this.loaiVC = loaiVC;
    }

    public String getMaVC() {
        return maVC;
    }

    public void setMaVC(String maVC) {
        this.maVC = maVC;
    }

    public int getLoaiVC() {
        return loaiVC;
    }

    public void setLoaiVC(int loaiVC) {
        this.loaiVC = loaiVC;
    }
    
    public void nhapMaVC(){
        do{
            System.out.println("Hay nhap maVC hop le(6 so):");
            maVC=sc.nextLine();
        }
        while(maVC.length()!=6 || !DSVC.checkMaVC(maVC));
    }
    public void nhapLoaiVC(){
        do{
        System.out.println("Hay nhap loaiVC: \n1. Voucher theo tien 10k,20k \n2. Voucher di kem SP\n ");
        loaiVC=Integer.parseInt(sc.nextLine());
        }
        while(loaiVC>2 || loaiVC<1);
    }
    public void nhapTTVC(){
        nhapMaVC();
        nhapLoaiVC();
    }
    
    public String stringLoaiVC(){
        if(loaiVC==1)
            return "Voucher giam tien";
        if(loaiVC==2)
            return "Voucher giam gia SP";
        return null;
    }
    public static String ShowHeader(){
        return String.format("|%-10s|%-20s|%-10s|%-10s|", "MaVC","LoaiVC","MenhGia/TyLe","MaSP_neuco");
    }
    @Override
    public String toString(){
        return String.format("|%-10s|%-20s|",maVC,stringLoaiVC());
    }
    
    @Override
    public void xuatTT(){
        System.out.println(toString());
    }
}

