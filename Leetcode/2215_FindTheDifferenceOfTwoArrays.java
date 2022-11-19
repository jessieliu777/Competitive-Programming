class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> a= new HashSet<>();
        HashSet<Integer> b= new HashSet<>();
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        l.add(new ArrayList<Integer>());
        l.add(new ArrayList<Integer>());
        for(int x:nums1){
            a.add(x);
        }
        for(int x:nums2){
            b.add(x);
        }
        for(int x:a){
            if(!b.contains(x)){
                l.get(0).add(x);
            }
        }
        for(int x:b){
            if(!a.contains(x)){
                l.get(1).add(x);
            }
        }
        return l;
    }
}