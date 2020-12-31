
public class maxSum{
        private int []money;

// Declare and define additional variables or functions here if you need...

        public maxSum(int[] m){

                // DO NOT modify constructor

                int i=0, n=m.length;
                money = new int[n];
                for(i=0;i<n;i++)        this.money[i] = m[i];
                return;
        }

        public int max(){
                int r = 0;
                int len = money.length;
                int[] pocket;
                pocket = new int[len];

                r = memorizedMax(money,len-1, pocket);
                return r;
        }
        public int memorizedMax(int[] m,int n, int[] p) {
                int max = 0;
                if(p[n]>0) return p[n];
                if(n == 0) return p[0] =  m[0];
                if(n == 1) return p[1] = m[0]+m[1];
                if(n == 2)  {
                        int a = Math.max(m[0]+m[2], m[1]+m[2]);
                        return p[2] = Math.max(a, m[0]+m[1]);

                }
                else{
                        int tmp1 = memorizedMax(m,n-3, p)+m[n-1]+m[n];
                        int tmp2 = memorizedMax(m,n-2, p)+m[n];
                        int tmp3 = memorizedMax(m,n-1,p);;

                        if(tmp1 >= tmp2) max = tmp1;
                        else max = tmp2;
                        if(max >= tmp3) p[n] = max;
                        else p[n] = tmp3;

                        return p[n];
                 }

        }
}

