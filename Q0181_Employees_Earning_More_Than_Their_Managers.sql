SELECT e.Name AS Employee
FROM employee e, employee m
WHERE e.ManagerId = m.Id AND e.Salary > m.Salary;
