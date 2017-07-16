package pack1;

public class MemoryControl {

	public static void main(String[] args) {
	
	// get a reference to a runtime environment	
	Runtime runtime = Runtime.getRuntime();
	
	// Declare variable for different steps	
	long memo1,memo2;
	
	//Declare data to be allocated	
	Integer [] data = new Integer [1000];
	
	//Print total memory available for the program
	System.out.println("Total memory is: "+ runtime.totalMemory());
	
	//Instantiate memo1 with the free memory and print it	
	memo1 = runtime.freeMemory();	
	System.out.println("Initial memory is :" + memo1);
	
	// garbage collect the runtime	
	runtime.gc();
	
	// check memory status after garbage collection 
	memo1 = runtime.freeMemory();	
	System.out.println("Initial memory after garbage collection is :" + memo1);
	
	//allocate memory to the 'data' variable by creating 1000 instances of Integer Object.
	for (int i= 0;i<1000;i++){ data[i] = new Integer(i);}
	
	memo2 = runtime.freeMemory();
	System.out.println("Free memory after allocation is :" + memo2);
	
	//Memory allocated
	System.out.println("Menory allocated to data: "+ (memo1-memo2));
	
	// discard data loaded in the memory	
	for(int i = 0; i<1000; i++){ data[i] = null;}
	
	//Let's garbage collect object on the heap
	
	runtime.gc();
	
	// get the new available memory after the cleaning
	
	memo2 = runtime.freeMemory();	
	System.out.println("Available memory after the Integers are discarded: "+ memo2);
	

	}

}
