class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>(); list.add(1);
        for(long i=1,temp=1,l=rowIndex,r=1;i<=rowIndex;i++)
            list.add((int)(temp=(temp*l--)/r++));
        return list;
    }
}