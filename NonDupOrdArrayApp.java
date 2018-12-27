package nondupordarrayapp;

class NonDupOrdArray {     
    private long[] a;  
    private int nElems; 

    public NonDupOrdArray (int max) { 
        a= new long[max];
        nElems = 0;
    }    

    public int size(){
        return a.length;
    }
    public int find(long searchKey){
        for(int i=0;i<nElems;i++){
            if(a[i]==searchKey)
                return i;
        }
        return -1;
    }
    public void insert(long value){
        if(find(value) == -1){
        if(size()==nElems)
            System.out.println("Array is Full.");
        else{
            long temp;
            for(int i=0;i<nElems;i++){
                if(value<a[i]){
                    temp=a[i];
                    a[i]=value;
                    value=temp;
                }
            }
            a[nElems]=value;
            nElems++;
        }
        }
        else{
            System.out.println("Value is already Exist in the Array");
        }
    }
    public boolean delete(long value) {
        if(nElems==0){
            System.out.println("Array is Empty.");
            return false;
        }
        for(int i=0;i<nElems;i++){
            if(value==a[i]){
                for(int j=i;j<nElems-1;j++){
                    a[j]=a[j+1];
                }
                nElems--;
                System.out.println("Value was deleted.");
                return true;
            }
        
        }
        System.out.println("Value was not found.");
        return false;
        
    }
    public void display() {
        if(nElems==0){
            System.out.println("Array is Empty.");
        }
        else{
            for(int i =0;i<nElems;i++){
                System.out.print(a[i]+" ");
            }
        }
    }
}   
public class NonDupOrdArrayApp {
    public static void main(String[] args) {
        NonDupOrdArray noduparry = new NonDupOrdArray(5);
        noduparry.insert(10);
        noduparry.insert(5);
        noduparry.insert(11);
        noduparry.insert(10);
        noduparry.insert(12);
        noduparry.insert(16);
        noduparry.insert(14);
        noduparry.display();
    }
    
}
