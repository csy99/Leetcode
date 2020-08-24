SELECT d.name AS Department, e1.name AS Employee, e1.Salary
FROM employee e1 JOIN department d ON e1.DepartmentId = d.Id
WHERE 3 > 
(
    SELECT count(distinct e2.Salary)
    FROM employee e2
    WHERE e1.DepartmentId = e2.DepartmentId AND e2.Salary > e1.Salary
)
;
