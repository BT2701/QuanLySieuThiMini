package danhSachClass;

import java.util.Arrays;

public abstract class DSKH {
	protected static KhachHang[] DSKH = new KhachHang[5];

	public DSKH() {
		khoiTaoKH();
		
	}

	public static void addKH(String MaKH, String TenKH, String DiaChi, int diemTichLuy) {
		int a = DSKH.length;
		DSKH = Arrays.copyOf(DSKH, a + 1);
		DSKH[a] = new KhachHang(MaKH, TenKH, DiaChi, diemTichLuy);
	}

	public static void addKH() {
		int a = DSKH.length;
		DSKH = Arrays.copyOf(DSKH, a + 1);
		DSKH[a] = new KhachHang();
		DSKH[a].nhapTTKH();
	}

	public static void deleteKH(String maKH) {
		int length = DSKH.length;
		for (int i = 0; i < length; i++) {
			if (DSKH[i].maKH.equals(maKH)) {
				swapKH(i, length - 1);
				DSKH = Arrays.copyOf(DSKH, DSKH.length - 1);
				break;
			}
		}
	}

	public static void deleteKHIndex(int a) {
		swapKH(a, DSKH.length - 1);
		DSKH = Arrays.copyOf(DSKH, DSKH.length - 1);
	}

	public static int KHIndex(String maKH) {
		for (int i = 0; i < DSKH.length; i++) {
			if (DSKH[i].maKH.equals(maKH)) {
				return i;
			}
		}
		return -1;
	}

	public static void searchKH(String maKH) {
		int i = KHIndex(maKH);
		if (i != -1) {
			KhachHang.ShowHeader();
			DSKH[i].xuatTT();
		}
	}

	public static void showKHIndex(int i) {
		KhachHang.ShowHeader();
		DSKH[i].xuatTT();
	}

	public static void swapKH(int b, int c) {
		KhachHang temp = new KhachHang();
		temp = DSKH[b];
		DSKH[b] = DSKH[c];
		DSKH[c] = temp;
	}

	public static int partition(int low, int high) {
		KhachHang pivot = DSKH[high];
		int left = low;
		int right = high - 1;
		while (true) {
			while (left <= right && DSKH[left].tenKH.compareTo(pivot.tenKH) < 0)
				left++;
			while (right >= left && DSKH[right].tenKH.compareTo(pivot.tenKH) > 0)
				right--;
			if (left >= right)
				break;
			swapKH(left, right);
			left++;
			right--;
		}
		swapKH(left, high);
		return left;
	}

	// vua thuc hien vua tra ve vi tri
	public static void quicksort(int low, int high) {
		if (low < high) {
			int out = partition(low, high);
			quicksort(low, out - 1);
			quicksort(out + 1, high);
		}
	}

	public static boolean checkMaKH(String maKH) {
		for (int i = 0; i < DSKH.length; i++) {
			if (DSKH[i].maKH.equals(maKH))
				return false;
		}
		return true;
	}

	public static void khoiTaoKH() {
		DSKH[0] = new KhachHang("111111", "KH_Truong", "DiaChi", 0);
		DSKH[1] = new KhachHang("222222", "KH_Hieu", "DiaChi", 0);
		DSKH[2] = new KhachHang("333333", "KH_Phuc", "DiaChi", 0);
		DSKH[3] = new KhachHang("444444", "KH_Tien", "DiaChi", 0);
		DSKH[4] = new KhachHang("555555", "KH_Duy", "DiaChi", 0);
	}

	public static void xuatTT() {
		System.out
				.println("-----------------------------------Hien thi DSKH-------------------------------------------");
		System.out.println(KhachHang.ShowHeader());
		for (int i = 0; i < DSKH.length; i++)
			DSKH[i].xuatTT();
		System.out
				.println("-------------------------------------------------------------------------------------------");
	}
}
