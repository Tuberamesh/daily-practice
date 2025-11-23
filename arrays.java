class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         
        int n=nums1.length;
        int[] result=new int[n];

        for(int i=0;i<nums1.length;i++){

               result[i]=-1;

            for(int j=0;j<nums2.length;j++){

                if(nums1[i]==nums2[j]){

                    for(int k=j+1;k<nums2.length;k++){
                        if(nums1[i]<nums2[k]){
                        result[i]=nums2[k];

                        break;
                        }
                            
                    }
                    break;
                    
            }
           
        }
        
        
    }
    return result;
}
}