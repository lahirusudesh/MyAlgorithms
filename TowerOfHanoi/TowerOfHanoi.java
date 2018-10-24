public class TowerOfHanoi {
	public static void towerOfHanoi(int n, char beg, char aux, char end) {
		if(n==1)
			System.out.println(beg +" to "+ end);
		else {
			towerOfHanoi(n-1,beg,end,aux);
			towerOfHanoi(1,beg,aux,end);
			towerOfHanoi(n-1,aux,beg,end);
		}
	}
	public static void main(String[] args) {
		towerOfHanoi(4,'A','B','C');
	}
}
