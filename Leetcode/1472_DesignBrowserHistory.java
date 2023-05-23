class BrowserHistory {
    String[] arr;
    int pres, futureBound;

    public BrowserHistory(String homepage) {
        arr = new String[5000]; // given at most 5000 calls
        pres = 0; futureBound = 0;
        arr[pres] = homepage;
    }
    
    public void visit(String url) {
        arr[++pres] = url;
        futureBound = pres; // the max future is cur since we reset the history upon visit
    }
    
    public String back(int steps) {
        pres = Math.max(pres - steps, 0);
        return arr[pres];
    }
    
    public String forward(int steps) {
        pres = Math.min(pres + steps, futureBound);
        return arr[pres];
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */