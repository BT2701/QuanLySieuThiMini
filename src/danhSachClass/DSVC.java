package danhSachClass;

import java.util.Arrays;
public abstract class DSVC {
    protected static Voucher[] DSVC=new Voucher[3];
    public DSVC() {
    	khoiTaoVouCher();
    }
    public static void addVC1(long soTienGiam, String maVC){
        int a=DSVC.length;
        DSVC=Arrays.copyOf(DSVC, a+1);
        DSVC[a]=new Voucher1(soTienGiam, maVC);
    }
    public static void addVC2(String maSP, int tyLeGiam, String maVC){
        int a=DSVC.length;
        DSVC=Arrays.copyOf(DSVC, a+1);
        DSVC[a]=new Voucher2(maSP, tyLeGiam, maVC);
    }
    public static void addVC(){
        int a=DSVC.length;
        DSVC=Arrays.copyOf(DSVC, a+1);
        DSVC[a]=new Voucher();
        DSVC[a].nhapTTVC();
        if(DSVC[a].loaiVC==1){
            DSVC[a]=new Voucher1();
            DSVC[a].nhapTTVC();
        }
        else {
            DSVC[a]=new Voucher2();
            DSVC[a].nhapTTVC();
        }
            
    }
    public static void deleteVC(String maVC){
        int length=DSVC.length;
        for(int i=0;i<length;i++){
            if(DSVC[i].maVC.equals(maVC))
            {
                swapVC(i,length-1);
                DSVC=Arrays.copyOf(DSVC, DSVC.length-1);
                break;
            }
        }
    }
    public static void deleteVCIndex(int a){
        swapVC(a,DSVC.length-1);
        DSVC=Arrays.copyOf(DSVC, DSVC.length-1);
    }
    public static int VCIndex(String maVC){
        for(int i=0;i<DSVC.length;i++){
            if(DSVC[i].maVC.equals(maVC))
            {
                return i;
            }
        }
        return -1;
    }
    public static void searchVC(String maVC){
        int i=VCIndex(maVC);
        if(i!=-1){
            Voucher.ShowHeader();
            DSVC[i].xuatTT();
            }
    }
    public static void showVCIndex(int i){
        Voucher.ShowHeader();
        DSVC[i].xuatTT();
    }
    public static void swapVC(int b,int c){
        Voucher temp=new Voucher();
        temp=DSVC[b];
        DSVC[b]=DSVC[c];
        DSVC[c]=temp;
    }
    public static boolean checkMaVC(String maVC){
        for(int i=0;i<DSVC.length;i++){
            if(DSVC[i].maVC.equals(maVC))
                return false;
        }
        return true;
    }
    public void khoiTaoVouCher() {
    	DSVC[0]=new  Voucher1(10, "111111");//10k
        DSVC[1]=new  Voucher1(20, "222222");//20k
        DSVC[2]=new  Voucher1(50, "555555");//50k
//        DSVC.addVC2("111111", 30, "333333");
//        DSVC.addVC2("222222", 40, "444444");
    }
    
    public static void xuatTT(){
        System.out.println("-----------------------------------Hien thi DSVC-------------------------------------------");
        System.out.println(Voucher.ShowHeader());
        for(int i=0;i<DSVC.length;i++)
            DSVC[i].xuatTT();
        System.out.println("-------------------------------------------------------------------------------------------");
    }
}

