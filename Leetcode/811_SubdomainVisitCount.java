class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> count = new HashMap();
        for (String cd : cpdomains) {
            int i = cd.indexOf(' ');
            int rep = Integer.valueOf(cd.substring(0, i));
            String domain = cd.substring(i + 1);
            for (i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    count.put(subdomain, count.getOrDefault(subdomain, 0) + rep);
                }
            }
            count.put(domain, count.getOrDefault(domain, 0) + rep);
        }
        List<String> res = new ArrayList();
        for (String d: count.keySet()) res.add(count.get(d) + " " + d);
        return res;
    }
}