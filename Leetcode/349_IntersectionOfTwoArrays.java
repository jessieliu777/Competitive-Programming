class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> al=new ArrayList<>();
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int a:nums1){
            set1.add(a);
        }
        for(int b:nums2){
            set2.add(b);
        }
        for(int a:set1){
            if(set2.contains(a)){
                al.add(a);
            }
        }
        int[] arr=new int[al.size()];
        for(int k=0;k<al.size();k++){
            arr[k]=al.get(k);
        }
        return arr;
    }
}