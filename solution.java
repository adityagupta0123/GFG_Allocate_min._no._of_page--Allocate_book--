class Solution 
{
    public static int findPages(int[]arr,int n,int m)
    {
        int s =0; 
        int sum =0;
        for(int i=0; i<n; i++)
            sum += arr[i];
        int e = sum;
        int ans = -1;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(isPossible(arr, n, m, mid)){
                e = mid -1;
                ans = mid;
            }else{
                s = mid +1;
            }
        }
        return ans;
    }
    
    static boolean isPossible(int arr[],int n,int m,int mid){
        int stuCount = 1;
        int pageSum = 0;
        
        for(int i=0; i< n; i++){
            if(pageSum + arr[i] <= mid){
                pageSum += arr[i];
            }
            else{
                stuCount++;
                if(stuCount > m || arr[i] > mid)
                    return false;
                
                pageSum = arr[i];
            }

        }
        return true;
    } 
};
