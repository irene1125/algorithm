import java.io.*;

// DO NOT modify class point, function closest(), and function setPoints(point p[])!

class point{
        public double x;
        public double y;
        public point(){
                x = 0.0;
                y = 0.0;
        }
}

public class closest{
        private point pnt[];

// If you need more member variables or member functions, declare here...
        private int m;
        private point sort[];
        private point temp[];

        public closest(){
                this.pnt = null;
        }

        public void setPoints(point p[]){
                int i = 0, n = p.length;
                this.pnt = null;
                this.pnt = new point[n];
                for(i=0;i<n;i++){
                        this.pnt[i] = new point();
                        this.pnt[i].x = p[i].x;
                        this.pnt[i].y = p[i].y;
                }
        }

        public double getMinDist(){
                //Input source code here...
                m = pnt.length;
                sort = null;
                sort = new point[m];
                temp = new point[m];
                //copy
                for(int i = 0 ; i < m ; i++){
                        sort[i] = pnt[i];
                }
                //x 정렬
                mergeArray(sort,0,m-1);

                return  CalDist(sort, 0, m-1);

}
        public void mergeArray(point s[], int start, int end){
                int mid;
                if(start<end){
                        mid = (start+end)/2;
                        mergeArray(s, start, mid);
                        mergeArray(s, mid+1, end);
                        merge(s, start, mid, end);
                }
        }
        public void merge(point s[],int start,int mid, int end){

        int a = start;
        int b = mid+1;
        int c = start;

        while(a<=mid && b<=end) {
                if(s[a].x<s[b].x)
                        temp[c++]=s[a++];
                else
                        temp[c++] = s[b++];
        }
        while(a<=mid)
                temp[c++] = s[a++];
        while(b<=end)
                temp[c++] = s[b++];

        for (int i=start;i<=end;i++) {
            s[i]=temp[i];}

        }
        //point 배열 두개,, 1개로 만들자 !
        /*public void merge(point arr[],int start, int mid, int end){
                 int i = mid - start + 1;
                 int j = end - mid;
                 int k = start;
                 int a = 0, b = 0;
                 point l[]  = new point[i];
                 point r[] = new point[j];

                 for(a = 0; a<i; a++)
                         l[a] = arr[start+a];
                 for(b = 0; b<j;b++)
                         r[b] = arr[mid+1+b];

                 a = 0; b= 0;
                while(a <i && b < j){
                         if (l[a].x <= r[b].x){
                                 arr[k++] = l[a++];
                 }
                        else{
                                 arr[k++] = r[b++];
                 }
         }
                 while(a < i){
                         arr[k++] = l[a++];
         }
                while( b<j){
                         arr[k++] = r[b++];
         }
 }*/


        public double CalDist(point s[], int start,int end)
        {
                int mid, i=0, k=0;
                double x1, x2, y1, y2, x3, y3;
                double get_d = 0, d = 0.0, d1 = 0.0, d2 = 0.0, d3= 0.0;

                mid = (start+end)/2;
                //좌표 1개일 땐 무한대 리턴
                if(start == end) return Double.POSITIVE_INFINITY;
                //conquer시 거리 계산할 좌표 2개
                else if(end == start+1){
                        d = Math.sqrt(Math.pow((s[end].x -s[start].x),2) + Math.pow((s[end].y-s[start].y),2));
                        return d;}
               //좌표 3개일때
                else if(end-start ==2){
                        x1 = s[start].x;        x2 = s[end].x;    x3 = s[mid].x;
                        y1 = s[start].y;        y2 = s[end].y;  y3 = s[mid].y;
                        d1 = Math.sqrt(Math.pow((x2-x1),2)+ Math.pow((y2-y1),2));
                        d2 = Math.sqrt(Math.pow((x3-x2),2)+Math.pow((y3-y2),2));
                        d = d1>d2 ? d2 : d1;
                        d3 = Math.sqrt(Math.pow((x3-x1),2)+Math.pow((y3-y1),2));
                        if(d>d3) d = d3;
                        if(d == 0) return 0;

                        return d;
                }
               //좌표 4개 이상일 때
                else{
                        d1 = CalDist(s, start, mid);
                        d2 = CalDist(s, mid+1, end);
                        d = (d1>d2) ? d2 : d1;
                        if(d==0) return 0;

                        x2 = s[mid].x; y2 = s[mid].y;
                        for(i = start; i<=end; i++){
                                if((s[i].x >= s[mid].x-d) &&(s[i].x<=s[mid].x+d)&&(i!=mid)){
                                        x1 = s[i].x; y1 = s[i].y;
                                        get_d = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
                                        if(d>get_d) d = get_d;
                                }
                        }
                        return d;
                }
        }
}

