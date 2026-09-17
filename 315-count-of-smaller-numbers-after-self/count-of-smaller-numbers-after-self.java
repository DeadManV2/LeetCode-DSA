class Solution {
    int[] count;
    int[][] arr;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        arr = new int[n][2];
        for(int i = 0; i < n ; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        mergeSort(0, n-1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(count[i]);
        }

        return ans;

        
    }
    private void merge(int left, int mid, int right) {
        int[][] tmp = new int[right - left + 1][2];
        int cnt = 0;
        int i = left;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= right) {
            if(arr[j][0] < arr[i][0]){
                cnt++;
                tmp[k++] = arr[j++];
            }
            else{
                count[arr[i][1]] += cnt;
                tmp[k++] = arr[i++];
            }
        }
        while (i <= mid) {

            count[arr[i][1]] += cnt;

            tmp[k++] = arr[i++];
        }

        while (j <= right) {
            tmp[k++] = arr[j++];
        }
        for (int x = 0; x < tmp.length; x++) {
            arr[left + x] = tmp[x];
        }
    }
    private void mergeSort(int left, int right) {
        if(left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);

    }
} 