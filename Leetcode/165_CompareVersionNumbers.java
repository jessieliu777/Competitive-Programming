class Solution {
    public int compareVersion(String version1, String version2) {
        // escape the dot . to avoid using the regex . which means any char
        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");
        
        int len = Math.max(revisions1.length, revisions2.length);
        for (int i=0; i<len; i++) {
            // given if cur revision isn't given the assume 0
            Integer revision1 = i < revisions1.length ? Integer.parseInt(revisions1[i]) : 0;
            Integer revision2 = i < revisions2.length ? Integer.parseInt(revisions2[i]) : 0;
            int compare = revision1.compareTo(revision2);
            // if cur revision is the same the check the next revision. Otherwise return the result
            if (compare != 0) return compare;
        }
        return 0;
    }
}