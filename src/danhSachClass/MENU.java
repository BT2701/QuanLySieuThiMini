package danhSachClass;

import java.util.Scanner;

public class MENU {
	public static void main(String[] args) {
		HoaDon hd=new HoaDon();
		Scanner sc=new Scanner(System.in);
		int op;
		do{
            System.out.println("""
                               ---------------------------------Menu--------------------------------------
                               1.Ban Hang 
                               2.San Pham
                               3.Voucher
                               4.Khach Hang 
                               5.Nhan Vien
                               6.Thong Ke
                               0.Thoat
                               Hay nhap lua chon:
                               """);
            op=Integer.parseInt(sc.nextLine());
            if(op==1){
                hd.banHang();
                hd.nhapTTHD();
        		hd.xuatTT();
                op=1;//gan lai gia tri
            }
            if(op==2){
                do{
                	System.out.println("--------------------------------------");
                    System.out.println("""
                                       1.Xuat DSSP
                                       2.tìm thông tín San Pham
                                       3.thêm sản phẩm vào danh sách sản phẩm và ghi vào file
                                       0.Thoat
                                       Hay nhap lua chon:
                                       """);
                    op=Integer.parseInt(sc.nextLine());
                    if(op==0)
                        break;
                    if(op==1)
                        hd.xuatDSSP();
                    if(op==2)
                        hd.timTTSP();
                    if(op==3) {
                    	hd.themSpDS();
                    }
                    
                }
                while(true);
                op=1;//gan lai gia tri
            }
            if(op==3){
                do{
                	System.out.println("--------------------------------------");
                    System.out.println("""
                                       1.Xuat DSVC 
                                       2.Search TT Voucher
                                       0.Thoat
                                       Hay nhap lua chon:
                                       """);
                    op=Integer.parseInt(sc.nextLine());
                    if(op==0)
                        break;
                    if(op==1)
                        DSVC.xuatTT();
         
                    if(op==2){
                        String maVC;
                        do{
                            System.out.println("Nhap maVC hop le");
                            maVC=sc.nextLine();
                        }
                        while(DSVC.checkMaVC(maVC));
                        DSVC.searchVC(maVC);
                    }
                }
                while(true);
                op=1;//gan lai gia tri
            }
            if(op==4){
                do{
                	System.out.println("--------------------------------------");
                    System.out.println("""
                                       1.Xuat DSKH 
                                       2.Search TT Khach Hang
                                       0.Thoat
                                       Hay nhap lua chon:
                                       """);
                    op=Integer.parseInt(sc.nextLine());
                    if(op==0)
                        break;
                    if(op==1)
                        DSKH.xuatTT();
                    
                    if(op==2){
                        String maKH;
                        do{
                        	System.out.println("--------------------------------------");
                            System.out.println("Nhap maKH hop le");
                            maKH=sc.nextLine();
                        }
                        while(DSKH.checkMaKH(maKH));
                        DSKH.searchKH(maKH);
                    }
                }
                while(true);
                op=1;//gan lai gia tri
            }
            if(op==5){
            	
                do{
                	System.out.println("--------------------------------------");
                    System.out.println("""
                                       1.Xuat DSNV 
                                       2.Search TT Nhan Vien
                                       0.Thoat
                                       Hay nhap lua chon:
                                       """);
                    op=Integer.parseInt(sc.nextLine());
                    if(op==0)
                        break;
                    if(op==1)
                        hd.xuatDSNV();
                    if(op==2)
                        hd.timTTNV();
                }
                while(true);
                op=1;//gan lai gia tri
            }
            
            if(op==6){
                hd.thongKe();
                op=1;//gan lai gia tri
            }
        }
        while(op!=0);
	}
}
