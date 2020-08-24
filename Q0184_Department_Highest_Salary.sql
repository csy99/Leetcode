SELECT d.Name AS Department, e.Name AS Employee, e.Salary AS Salary
FROM employee e INNER JOIN department d ON e.DepartmentId = d.Id
WHERE e.Salary = 
(
    SELECT max(others.Salary)
    FROM employee others 
    WHERE others.DepartmentId = e.DepartmentId 
);
