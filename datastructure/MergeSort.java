public class MergeSort{
   private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for(int k =lo; k <=hi; k++)
             aux[k]=a[k];
       int i =lo, j=mid+1;    //Error, forget this
        for(int k =lo; k <=hi; k++){
           if(i>mid) a[k]= aux[j++];
           if(j>hi)  a[k]= aux[i++];
           if(less(aux[i], aux[j])) a[k]=aux[i++];
           else a[k]=aux[j++];

         }
    }

   private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
         int mid = lo+(hi-lo)/2;
         sort(a,aux,lo,mid);
         sort(a,aux,mid+1,hi);
         merge(a,aux,lo,mid,hi);
    }
    
   public static void sort(Comparable[] a){
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        sort(a,aux,0,N-1) ;
   }

}
