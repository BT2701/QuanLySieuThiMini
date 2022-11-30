package danhSachClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanPham {
	private SanPham[] dsSanPham = new SanPham[0];
	static Scanner sc = new Scanner(System.in);

	public DanhSachSanPham(SanPham[] dsSanPham) {
		this.dsSanPham = dsSanPham;
	}

	public DanhSachSanPham() {
		layThongTinSanPham();
	}

	public SanPham[] getDsSanPham() {
		return dsSanPham;
	}

	public void setDsSanPham(SanPham[] dsSanPham) {
		this.dsSanPham = dsSanPham;
	}

	public void themSP(SanPham SP) {
		// len lưu độ dài của mảng
		int len = dsSanPham.length;
		dsSanPham = Arrays.copyOf(dsSanPham, len + 1);
		dsSanPham[len] = SP;
	}

	public void layThongTinSanPham() {

		try {
			// đọc file danh sách sản phẩm
			FileReader fr = new FileReader("DSSP.TXT");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				// line đọc từng dòng của file dssp.txt
				line = br.readLine();
				if (line == null) {
					break;
				}
				// cắt chuỗi thành mảng thông qua dấu phẩy
				String temp[] = line.split(",");

				// khởi tạo giá trị
				String tenSP = temp[0];
				String maSP = temp[1];
				String NCC = temp[2];
				double tienGoc = Double.parseDouble(temp[3]);
				double tienBanRa = Double.parseDouble(temp[4]);
				int slNhap = Integer.parseInt(temp[5]);
				int slTon = Integer.parseInt(temp[6]);
				// cắt chuỗi ngày tháng năm của hạn sử dụng
				// ví dụ 22-12-2022
				String date[] = temp[7].split("-");

				int ngay = Integer.parseInt(date[0]);
				int thang = Integer.parseInt(date[1]);
				int nam = Integer.parseInt(date[2]);
				NGAYTHANGNAM hsd = new NGAYTHANGNAM(ngay, thang, nam);
				int loaiSP=Integer.parseInt(maSP.charAt(0)+"");	//nếu kí tự đầu tiên của mã sản phẩm là 1 thì đó là đồ gia dụng, 2 là thực phẩm
				switch(loaiSP) {
				case 1:
					SanPham DGD=new DoGiaDung(tenSP, maSP, NCC, tienGoc, tienBanRa, slNhap, slTon, hsd);
					themSP(DGD);
					break;
				case 2:
					int loaiThucPham=Integer.parseInt(maSP.charAt(1)+"");
					/*
					 * nếu kí tự tại vị trí thứ 1 là 1 thì đó là thực phẩm đã chế biến
					 * 2 là thực phẩm chưa chế biến
					 * 3 là rau củ quả
					 */
					switch(loaiThucPham) {
					case 1:
						SanPham TPDCB=new ThucPhamDaCheBien(tenSP, maSP, NCC, tienGoc, tienBanRa, slNhap, slTon, hsd);
						themSP(TPDCB);
						break;
					case 2:
						SanPham TPCCB=new ThucPhamChuaCheBien(tenSP, maSP, NCC, tienGoc, tienBanRa, slNhap, slTon, hsd);
						themSP(TPCCB);
						break;
					case 3:
						SanPham RCQ=new RauCuQua(tenSP, maSP, NCC, tienGoc, tienBanRa, slNhap, slTon, hsd);
						themSP(RCQ);
						break;
					}
					break;
				}
//				SanPham sanPham = new SanPham(tenSP, maSP, NCC, tienGoc, tienBanRa, slNhap, slTon, hsd);
//				themSP(sanPham);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void muaSP() {
		System.out.print("nhập tên hoặc mã của sản phẩm cần mua: ");
		String SpCanMua = sc.nextLine();
		System.out.println();
		
		while (true) {
			int luaChon=-1;
			for (int i = 0; i < dsSanPham.length; i++) {
				if (SpCanMua.equalsIgnoreCase(dsSanPham[i].getTenSP())|| SpCanMua.equalsIgnoreCase(dsSanPham[i].getMaSP())) {
					System.out.println("Bạn đã lựa chọn sản phầm "+dsSanPham[i].getTenSP());
					System.out.printf("1.tiếp tục \t\t0.thoát");
					System.out.println();
					luaChon = Integer.parseInt(sc.nextLine()); // xác nhận lựa chọn sản phẩm
					int demSpDaMua = 0; // đếm sản phẩm đã mua

					int soLuongTon = dsSanPham[i].getSl_ton(); // lấy số lượng tồn kho của sản phẩm thứ i trong danh
																// sách
					while (luaChon != 0) {
						System.out.println("sản phẩm " + dsSanPham[i].getTenSP() + " có giá: " + dsSanPham[i].getTenBanRa());
						System.out.printf("1.mua 1 sản phẩm\t\t2.mua nhiều sản phẩm\t\t3.bỏ qua");
						System.out.println();
						int luaChonMuaSP = Integer.parseInt(sc.nextLine()); // lựa chọn có mua sản phẩm hay không
						switch (luaChonMuaSP) {
						case 1:
							System.out.println("---đã thêm vào giỏ hàng---");
							demSpDaMua++;
							soLuongTon--;
							break;
						case 2:
							System.out.println("mời bạn nhập số lượng sản phẩm cần mua: ");
							int soLuongSanPhamCanMua=Integer.parseInt(sc.nextLine());
							while(soLuongSanPhamCanMua<1||soLuongSanPhamCanMua>dsSanPham[i].getSl_ton()) {
								System.out.println("---số lượng nhập không hợp lệ!!!---");
								System.out.println("mời bạn nhập lại số lượng sản phẩm cần mua: ");
								soLuongSanPhamCanMua=Integer.parseInt(sc.nextLine());
							}
							System.out.println("---đã thêm vào giỏ hàng---");
							demSpDaMua+=soLuongSanPhamCanMua;
							soLuongTon-=soLuongSanPhamCanMua;
							break;
						case 3:
							System.out.println("---mời bạn chọn sản phẩm khác---");
							break;
							
						}
						System.out.println("bạn có muốn tiếp tục mua sản phầm này?");
						System.out.printf("1.mua\t\t0.thoát");
						System.out.println();
						luaChon = Integer.parseInt(sc.nextLine());
					}
					// cập nhật lại số lượng đã mua
					dsSanPham[i].setSoLuongSpDaMua(demSpDaMua);
					// cập nhật lại số lượng tồn kho
					dsSanPham[i].setSl_ton(soLuongTon);
					
				}
			}
			if(luaChon==-1)
				System.out.println("---San Pham Khong Ton Tai---");
			System.out.println("---bạn có muốn mua tiếp những sản phẩm khác không?---");
			System.out.printf("1.có\t\t0.không");
			System.out.println();
			int luaChonMuaTiep = Integer.parseInt(sc.nextLine());	//lựa chọn mua những sản phẩm khác
			if (luaChonMuaTiep == 1) {
				System.out.println("---mời bạn nhập sản phẩm tiếp theo cần mua---");
				SpCanMua = sc.nextLine();
			} else {
				System.out.println("===cảm ơn quý khách===");
				break;
			}
		}
	}
	public void ThemSpVaoDS() {
		System.out.println("---Moi Ban Nhap Thong Tin San Pham Moi---");
		SanPham sanP=new SanPham();
		sanP.nhapSanPham();
		themSP(sanP);
		try {
			FileWriter fw=new FileWriter("DSSP.TXT",true);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write("\n");
			bw.write(sanP.getTenSP()+",");
			bw.write(sanP.getMaSP()+",");
			bw.write(sanP.getNhaCC()+",");
			bw.write(sanP.getTienGoc()+",");
			bw.write(sanP.getTenBanRa()+",");
			bw.write(sanP.getSl_nhap()+",");
			bw.write(sanP.getSl_ton()+",");
			bw.write(sanP.getHsd().getNgay()+"-");
			bw.write(sanP.getHsd().getThang()+"-");
			bw.write(sanP.getHsd().getNam()+"");
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void timSP() {
		System.out.println("nhập tên hoặc mã của sản phẩm cần tìm.");
		String spCanTim=sc.nextLine();
		for(int i=0;i<dsSanPham.length;i++) {
			if(spCanTim.equalsIgnoreCase(dsSanPham[i].getTenSP())||spCanTim.equalsIgnoreCase(dsSanPham[i].getMaSP())) {
				dsSanPham[i].xuatThongTinSanPham();
			}
		}
	}
	public int tongSpDaMua() {
		int tongSP=0;
		for(int i=0;i<dsSanPham.length;i++) {
			tongSP+=dsSanPham[i].getSoLuongSpDaMua();
		}
		return tongSP;
	}
	public double tongTien() {
		double tongSoTienBanRa=0;
		for(int i=0;i<dsSanPham.length;i++) {
			tongSoTienBanRa+=dsSanPham[i].tongTienTren1SP();
		}
		return tongSoTienBanRa;
	}
	public double tongTienLoi() {
		double tongSoTienLoi=0;
		for(int i=0;i<dsSanPham.length;i++) {
			tongSoTienLoi+=dsSanPham[i].tongTienLoiTren1SP();
		}
		return tongSoTienLoi;
	}
	public void xuatHoaDon() {
		for(int i=0;i<dsSanPham.length;i++) {
			if(dsSanPham[i].getSoLuongSpDaMua()>0)
				dsSanPham[i].xuatHoaDon1SP();
		}
		System.out.println("thành tiền: "+tongTien()+"VND");
		System.out.println("*************************");
	}
	public void xuatDSSP() {
		for (int i = 0; i < dsSanPham.length; i++) {
			dsSanPham[i].xuatThongTinSanPham();
		}
	}

}
