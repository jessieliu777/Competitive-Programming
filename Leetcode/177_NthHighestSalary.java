CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N-1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT(salary) from Employee order by salary DESC
      # take 1 from top n. Since order is desc, the first salary returned is actually the nth highest
      LIMIT N, 1
  );
END