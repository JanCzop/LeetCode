public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smallerArr, largerArr;
        if (nums1.length <= nums2.length) {
            smallerArr = nums1;
            largerArr = nums2;
        } else {
            smallerArr = nums2;
            largerArr = nums1;
        }
        int m = smallerArr.length;
        int n = largerArr.length;
        int total = m + n;
        
        int left = 0;
        int right = m;
        
        while (left <= right){
            int i = (left + right) / 2; // smaller arr slice idx
            int j = (total + 1) / 2 - i; // larger arr slice idx
            
            int sLeft = (i == 0) ? Integer.MIN_VALUE : smallerArr[i - 1];
            int sRight = (i == m) ? Integer.MAX_VALUE : smallerArr[i];
            int lLeft  = (j == 0) ? Integer.MIN_VALUE : largerArr[j - 1];
            int lRight = (j == n) ? Integer.MAX_VALUE : largerArr[j];
            
            if (sLeft <= lRight && lLeft <= sRight) {
                if (total % 2 == 0) {
                    return (Math.max(sLeft, lLeft) + Math.min(sRight, lRight)) / 2.0;
                }
                else return Math.max(sLeft, lLeft);
            }
            else if (sLeft > lRight) 
                right = i - 1;
            else 
                left = i + 1;
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted or invalid");
    }
}