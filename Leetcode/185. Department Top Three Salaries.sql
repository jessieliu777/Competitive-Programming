# Write your MySQL query statement below
Select dep.Name as Department, emp.Name as Employee, emp.Salary 
from Department dep, Employee emp where emp.DepartmentId=dep.Id and 
# the number of distinct salaries from Employee join Department that are higher than this emp's salary must be less than 3 for this emp to be in the top 3 salary in this department
(Select count(distinct Salary) From Employee where DepartmentId=dep.Id and Salary > emp.Salary) < 3