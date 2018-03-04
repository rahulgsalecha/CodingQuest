/* Java implementation of HashTable */

import java.util.Scanner;

public class HashTable {

    /* A node in the linked list*/
    class LinkedHashEntry {
        /* Node Entries */
        String key;
        int value;
        LinkedHashEntry next;

        LinkedHashEntry(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /*HashTable Entries */
    private int TABLE_SIZE;
    private int size;
    private LinkedHashEntry[] table; /*Array of LinkedLists*/

    public HashTable(int table_size){
        size = 0;
        TABLE_SIZE = table_size;
        table = new LinkedHashEntry[TABLE_SIZE];

        for(int i=0; i<TABLE_SIZE;i++){
            table[i] = null;
        }
    }

    /* Hash function to calculate hash from the key */
    private int myhash(String x){
        int hashVal = x.hashCode();
        hashVal %= TABLE_SIZE;
        if(hashVal < 0)
            hashVal += TABLE_SIZE;
        return hashVal;
    }

    /* Size of HashTable */
    public int getSize(){
        return size;
    }

    /* Clear the HashTable */
    public void makeEmpty() {
        for(int i=0; i<TABLE_SIZE;i++)
            table[i] = null;
    }

    /* Get value of a given key*/
    public int get(String key) {

        /* find the hash from the key */
        int hash = (myhash(key) % TABLE_SIZE);

        if(table[hash] == null) { /* No such key exists */
            return -1;
        } else {
            /*Get the linkedlist pointer */
            LinkedHashEntry entry = table[hash];

            while(entry != null && !entry.key.equals(key)){
                entry = entry.next;
            }

            if (entry == null) {
                return -1;
            } else {
                return entry.value;
            }
        }
    }

    /* Insert a Key-Value pair */
    public void insert(String key, int value) {
        int hash = (myhash(key) % TABLE_SIZE);
        if(table[hash] == null) {
            table[hash] = new LinkedHashEntry(key,value);
        } else {
            LinkedHashEntry entry = table[hash];

            while(entry.next != null && !entry.key.equals(key)){
                entry = entry.next;
            }

            if(entry.key.equals(key)){
                /* If key already exists, update the value*/
                entry.value = value;
            } else {
                /* Create a new entry into the linkedList */
                entry.next = new LinkedHashEntry(key,value);
            }
        }
        size++;
    }

    /* Remove a Key-Value pair */
    public void remove(String key) {
        int hash = (myhash(key) % TABLE_SIZE);
        if(table[hash] != null) {
            LinkedHashEntry prev = null;
            LinkedHashEntry entry = table[hash];

            while(entry.next != null && !entry.key.equals(key)){
                prev = entry;
                entry = entry.next;
            }

            if(entry.key.equals(key)){ /* Key exists */
                if(prev == null) { /*Head Element*/
                    table[hash] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
            }
        }
    }

    /* Print entire HashTable */
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
        HashTable ht = new HashTable(scan.nextInt() );

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

/* 
 * Output:
 * Hash Table Test
 *
 *
 * Enter size
 * 5
 *
 * Hash Table Operations
 *
 * 1. insert 
 * 2. remove
 * 3. get
 * 4. clear
 * 5. size
 * 1
 * Enter key and value
 * 3
 * 4
 *
 * Bucket 1 : 
 * Bucket 2 : 4 
 * Bucket 3 : 
 * Bucket 4 : 
 * Bucket 5 : 
 * Do you want to continue (Type y or n) 
 *
 * y
 *
 * Hash Table Operations
 *
 * 1. insert 
 * 2. remove
 * 3. get
 * 4. clear
 * 5. size
 * 1
 * Enter key and value
 * 3
 * 6
 *
 * Bucket 1 : 
 * Bucket 2 : 6 
 * Bucket 3 : 
 * Bucket 4 : 
 * Bucket 5 : 
 * Do you want to continue (Type y or n) 
 *
 * y
 *
 * Hash Table Operations
 *
 * 1. insert 
 * 2. remove
 * 3. get
 * 4. clear
 * 5. size
 * 1
 * Enter key and value
 * 4
 * 15
 *
 * Bucket 1 : 
 * Bucket 2 : 6 
 * Bucket 3 : 15 
 * Bucket 4 : 
 * Bucket 5 : 
 * Do you want to continue (Type y or n) 
 *
 * y
 *
 * Hash Table Operations
*
* 1. insert 
* 2. remove
* 3. get
* 4. clear
* 5. size
* 5
* Size = 3
*
* Bucket 1 : 
* Bucket 2 : 6 
* Bucket 3 : 15 
* Bucket 4 : 
* Bucket 5 : 
* Do you want to continue (Type y or n) 
    *
    * y
    *
    * Hash Table Operations
    *
    * 1. insert 
    * 2. remove
    * 3. get
    * 4. clear
    * 5. size
    * 3
    * Enter key
    * 5
    * Value = -1
    *
    * Bucket 1 : 
    * Bucket 2 : 6 
    * Bucket 3 : 15 
    * Bucket 4 : 
    * Bucket 5 : 
    * Do you want to continue (Type y or n) 
    *
    * y
    *
    * Hash Table Operations
    *
    * 1. insert 
    * 2. remove
    * 3. get
    * 4. clear
    * 5. size
    * 3
    * Enter key
    * 6
    * Value = -1
    *
    * Bucket 1 : 
    * Bucket 2 : 6 
    * Bucket 3 : 15 
    * Bucket 4 : 
    * Bucket 5 : 
    * Do you want to continue (Type y or n) 
    *
    * y
    *
    * Hash Table Operations
    *
    * 1. insert 
    * 2. remove
    * 3. get
    * 4. clear
    * 5. size
    * 3
    * Enter key
    * 4
    * Value = 15
    *
    * Bucket 1 : 
    * Bucket 2 : 6 
    * Bucket 3 : 15 
    * Bucket 4 : 
    * Bucket 5 : 
    * Do you want to continue (Type y or n) 
    *
    * y
    *
    * Hash Table Operations
    *
    * 1. insert 
    * 2. remove
    * 3. get
    * 4. clear
    * 5. size
    * 3
    * Enter key
    * 3
    * Value = 6
    *
    * Bucket 1 : 
    * Bucket 2 : 6 
    * Bucket 3 : 15 
    * Bucket 4 : 
    * Bucket 5 : 
    * Do you want to continue (Type y or n) 
    *
    */
