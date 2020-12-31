
import java.io.*;

public class concat{
        private pri[] pa;
// Define additional variables or functions if you need...

        public concat(){
                this.pa = null;
        }

        public concat(int[] priority, String[] words){
                int i = 0, n = priority.length;
                this.pa = new pri[n];
                for(i=0;i<n;i++)        this.pa[i] = new pri(priority[i], words[i]);
                return;
        }

        public String concatenate(){
                String result = "";
                int i = 0;
                int n = pa.length;
                while(i <n/2){
                        pa[i].word = "-";
                        i++;
                }

                pri[] F = new pri[n];
                F = Countsort(pa,n);
                StringBuffer sb = new StringBuffer();
                for(i = 0; i<n;i++){
                        sb.append(F[i].word);
                        if(i != n-1)
                                sb.append(" ");
                }

                result = sb.toString();
                return result;
        }
        public pri[] Countsort(pri[] pa,int n){
                int max = 0;
                int i = 0;
                pri[] B;//복사
                int[] C;//누적개수

                B = null; C = null;
                B = new pri[n];

                for(i = 0; i< n; i++){
                        if(max <pa[i].pr)
                                max = pa[i].pr;
                }
                C = new int[max+1];
                for(i = 0; i<n;i++)
                        C[pa[i].pr] = C[pa[i].pr]+1;
                for(i = 1; i<max+1; i++)
                        C[i] =C[i]+C[i-1];
                for(i=n-1; i>=0; i--){
                        C[pa[i].pr] = C[pa[i].pr]-1;
                        B[C[pa[i].pr]] = pa[i];
                }
                return B;

        }
}

