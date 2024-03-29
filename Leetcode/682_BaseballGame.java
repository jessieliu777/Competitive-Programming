class Solution {
    public int calPoints(String[] operations) {
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (String op : operations) {
            if (op.equals("C")) sum -= list.removeLast();
            else if (op.equals("D")) {
                list.add(list.peekLast() * 2);
                sum += list.peekLast();
            }
            else if (op.equals("+")) {
                list.add(list.peekLast() + list.get(list.size() - 2));
                sum += list.peekLast();
            }
            else {
                list.add(Integer.parseInt(op));
                sum += list.peekLast();
            }
        }
        return sum;
    }
}