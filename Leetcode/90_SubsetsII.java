class Solution {
    private void sub(int index, int arr[],List<List<Integer>> subsets,List<Integer> subset){
        subsets.add(new ArrayList<>(subset));
        
        for(int i=index;i<arr.length;i++){
            // skip duplicates
            if(i>index && arr[i]==arr[i-1]) continue;
            // get the subsets with this element
            subset.add(arr[i]);
            sub(i+1,arr,subsets,subset);
            // get the subsets without this element
            subset.remove(subset.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        sub(0,nums,subsets,new ArrayList<>());
        return subsets;
    }
}