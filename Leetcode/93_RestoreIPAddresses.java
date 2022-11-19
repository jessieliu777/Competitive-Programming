class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 4; j++){
                for(int k = 1; k < 4; k++){
                    for(int l = 1; l < 4; l++){
                        if(i + j + k + l == len){
                            StringBuilder ip = new StringBuilder();
                            int n1 = Integer.parseInt(s.substring(0, i));
                            int n2 = Integer.parseInt(s.substring(i, i+j));
                            int n3 = Integer.parseInt(s.substring(i+j, i+j+k));
                            int n4 = Integer.parseInt(s.substring(i+j+k, i+j+k+l));
                            if(n1 < 256 && n2 < 256 && n3 < 256 && n4 < 256){
                                ip.append(n1).append('.').append(n2).append('.').append(n3).append('.').append(n4);                       
                                if (ip.length() == len+3) res.add(ip.toString());
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}