
public class Main {

	public static void bubbleSort(int tab[]) {
		for (int i = tab.length - 1 ; i > 0;i--)
			for (int j = 0; j < i; j ++) {
				if (tab[j] > tab[j+1]) {
					int tmp = tab[j];
					tab[j] = tab[j+1];
					tab[j+1] = tmp;
				}
			}
 	}
	
	
	private static int partition(int tab[], int i, int j) {	
		int p = tab[i];
		boolean right = true;
		while (i < j) {
			
			if (right) {
			
				if (p > tab[j]) {
					int tmp = tab[j];
					tab[j] = tab[i];
					tab[i] = tmp;
					right = false;
					i++;
				} else {			
					j--;
				}
			}
			
			if (!right) {
				
				if (p <= tab[i]) {
					int tmp = tab[j];
					tab[j] = tab[i];
					tab[i] = tmp;
					right = true;
					j--;
				} else {			
					i++;
				}
			}			
		}	
	
		return i;
		
	}
	
	private static void swap(int tab[],int i ,int j) {
		int tmp = tab[j];
		tab[j] = tab[i];
		tab[i] = tmp;		
	}
	
	private static int partition2(int tab[], int i, int j) {
		int pivot_value = tab[i];
		int store_index = i;
		swap(tab,i,j);
		for (int id = i; id < j;id++) {
			if (tab[id] < pivot_value){
				swap(tab,id,store_index);
				store_index++;
			}
		}
		swap(tab,store_index,j);
		return store_index;
	}
	
	
	public static void quickSort(int tab[], int i, int j) {
		if (i < j) {
			int q = partition2 (tab,i,j);	
			quickSort(tab,i,q);	
			quickSort(tab,q+1,j);
		}
	}
	
	
	public static int[] initTab(int length) {
		int tab []  = new int[length];
		for (int i = 0;i < tab.length;i++) {
			tab[i] = (int)(Math.random() * 100000.0);
		}
		return tab;
	}
	
	public static void main(String argv[]) {
		for (int i = 0;i < 100;i++) {
			sortTest(100);
		}
	}
	
	public static void sortTest(int nbElement) {
		int tab[] = initTab(nbElement);		
		int tab2[] = tab.clone();
		//displayTab(tab2);
		long millis  = System.currentTimeMillis();
		
		System.out.println("Launching bubbleSort");
		bubbleSort(tab);
		
		long currentmillis  = System.currentTimeMillis();
		System.out.println("Elapsed : " +(currentmillis - millis) + "ms");
		
		millis  = System.currentTimeMillis();
		System.out.println("Launching quickSort");
		
		quickSort(tab2,0,tab2.length-1);

		currentmillis  = System.currentTimeMillis();
		System.out.println("Elapsed : " +(currentmillis - millis) + "ms");
		

		for (int i = 0;i < tab2.length;i++) {
			if (tab[i] != tab2[i]){
				System.out.println("ERROR");
				displayTab(tab);
				displayTab(tab2);
				System.exit(0) ;
			}
		}
		
		
	}
	
	
	private static void displayTab(int tab[]) {
		for (int i = 0;i < tab.length;i++) {
			System.out.print(i+":"+tab[i] + " ");
		}
		System.out.println("");		
	}
}
