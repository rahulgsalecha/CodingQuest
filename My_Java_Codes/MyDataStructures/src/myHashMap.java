import java.util.Scanner;
public class myHashMap {
	// Get function
	// Put function
	// Remove function
	// Get Size function
	// Make empty function
	// array of list nodes
	// list node consists of key,value and next pointer
	// array indexes are hashcodes
	
	class LinkedHashEntry { // A node in the linked list 
		String key;
		int value;
		LinkedHashEntry next;
		
		LinkedHashEntry(String key,int value){
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	//Hashmap entries
	private int TABLE_SIZE;
	private int size; 
	private LinkedHashEntry[] table; //Array of linkedlists
	
	public myHashMap(int ts){
		size = 0;
		TABLE_SIZE = ts;
		table = new LinkedHashEntry[TABLE_SIZE];
		
		for (int i = 0; i < TABLE_SIZE; i++){
            table[i] = null;
		}
	}
	
	//Hash function to calculate hash from the key
	private int myhash(String x )
    {
        int hashVal = x.hashCode( );
        hashVal %= TABLE_SIZE;
        if (hashVal < 0)
            hashVal += TABLE_SIZE;
        return hashVal;
    }
	
	/* Function to get number of key-value pairs */
	public int getSize()
    {
        return size;
    }
	
	/* Function to clear hash table */
    public void makeEmpty()
    {
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }
    
    /* Function to get value of a key */
    public int get(String key) {
    	int hash = (myhash( key ) % TABLE_SIZE);
    	
    	if (table[hash] == null){ // No such key is present in hashmap
            return -1;
    	} else {
    		LinkedHashEntry entry = table[hash];
    		while(entry !=null && !entry.key.equals(key)){
    			entry = entry.next;
    		}
    		
    		if (entry == null){
    			return -1;
    		} else {
                return entry.value;
            }
    	}
    }
    
    /* Function to insert a key value pair */
    public void insert(String key, int value) {
    	int hash = (myhash( key ) % TABLE_SIZE);
    	if (table[hash] == null){
    		table[hash] = new LinkedHashEntry(key, value);
    	} else {
    		LinkedHashEntry entry = table[hash];
    		while (entry.next != null && !entry.key.equals(key)){
                entry = entry.next;
            }
    		
    		if (entry.key.equals(key)){
                entry.value = value;
            } else {
                entry.next = new LinkedHashEntry(key, value);
            }
    	}
    	size++;
    }
    

    /* Function to remove a key value pair */
    public void remove(String key) {
    	int hash = (myhash( key ) % TABLE_SIZE);
    	if (table[hash] != null) 
    	{
    		LinkedHashEntry prevEntry = null;
            LinkedHashEntry entry = table[hash];
            while (entry.next != null && !entry.key.equals(key)) {
            	prevEntry = entry;
            	entry = entry.next;
            }
            
            if (entry.key.equals(key)) {
            	if (prevEntry == null){ // head element
                    table[hash] = entry.next;
                }
                else
                {
                    prevEntry.next = entry.next;
                }
                size--;
            }
            	
    	}
    }
    
    /* Function to print hash table */
    public void printHashTable()
    {
        for (int i = 0; i < TABLE_SIZE; i++)
        {
            System.out.print("\nBucket "+ (i + 1) +" : ");
            LinkedHashEntry entry = table[i];
            while (entry != null)
            {
                System.out.print(entry.value +" ");
                entry = entry.next;
            }            
        }
    }
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
        /* Make object of HashTable */
        myHashMap ht = new myHashMap(scan.nextInt() );
 
        char ch;
        /*  Perform HashTable operations  */
        do    
        {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. get");            
            System.out.println("4. clear");
            System.out.println("5. size");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter key and value");
                ht.insert(scan.next(), scan.nextInt() ); 
                break;                          
            case 2 :                 
                System.out.println("Enter key");
                ht.remove( scan.next() ); 
                break;                        
            case 3 : 
                System.out.println("Enter key");
                System.out.println("Value = "+ ht.get( scan.next() )); 
                break;                                   
            case 4 : 
                ht.makeEmpty();
                System.out.println("Hash Table Cleared\n");
                break;
            case 5 : 
                System.out.println("Size = "+ ht.getSize() );
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /* Display hash table */
            ht.printHashTable();  
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
    }
	
}
