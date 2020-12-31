
public class inv{
        private int array[];
// If you need more attributes or methods, declare here...


        public inv(){
                array = null;
        }

        public void reset(int a[]){
                int i, size = a.length;
                array = null;
                array = new int[size];
                for(i=0;i<size;i++)     array[i] = a[i];
        }
        public void printArray(){
                int i, size = array.length;
                for(i=0;i<size;i++){
                        System.out.print(array[i]+" ");
                }
                System.out.println();
        }

        public int numOfInv(){
                int n = array.length;
                return mergeArray(array,0, n-1);
        }
        public int mergeArray(int arr[],int start, int end){
                int cnt1= 0, cnt2= 0, cnt3 = 0;
                int mid;
                if(start < end){

                        mid = (start+end)/2;
                        cnt1 = mergeArray(arr,start, mid);
                        cnt2 = mergeArray(arr,mid+1, end);
                        cnt3 = merge(arr,start, mid, end);
                }
                return cnt1+cnt2+cnt3;
        }
        public int merge(int arr[],int start, int mid, int end){
                int i = mid - start + 1;
                int j = end - mid;
                int k = start;
                int a = 0, b = 0, count= 0;
                int l[]  = new int[i];
                int r[] = new int[j];

                for(a = 0; a<i; a++)
                        l[a] = arr[start+a];
                for(b = 0; b<j;b++)
                        r[b] = arr[mid+1+b];

                a = 0;
                b= 0;
                while(a <i && b < j){
                        if (l[a] <= r[b]){
                                arr[k++] = l[a++];
                        }
                        else{
                                arr[k++] = r[b++];
                                count = count + i -a;
                        }
                }
                while(a < i){
                        arr[k++] = l[a++];
                }
                while( b<j){
                        arr[k++] = r[b++];
                }


                return count;}


}

