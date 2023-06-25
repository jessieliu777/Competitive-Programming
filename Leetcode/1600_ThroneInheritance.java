class ThroneInheritance {
    Map<String, Boolean> alive;
    Map<String, LinkedList<String>> family;
    String root;
    List<String> order;
    public ThroneInheritance(String kingName) {
        root = kingName;
        alive = new HashMap<>();
        family = new HashMap<>();
        family.put(kingName, new LinkedList<>());
        alive.put(kingName, true);
    }
    
    public void birth(String parentName, String childName) {
        // given parentName must already exist (alive)
        family.get(parentName).add(childName);
        family.put(childName, new LinkedList<>());
        alive.put(childName, true);
    }
    
    public void death(String name) {
        // given name already exist
        alive.put(name, false);
    }
    
    public List<String> getInheritanceOrder() {
        order = new LinkedList<>();
        dfs(root);
        return order;
    }

    private void dfs(String root) {
        // if root is alive add it to order
        if (alive.get(root)) order.add(root);
        // if root has any children go iterate through its chilren
        if (family.get(root) != null) {
            for (String child : family.get(root)) dfs(child);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */