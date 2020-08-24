SELECT c.Name AS Customers
FROM customers c
WHERE c.Id NOT IN
(
    SELECT c.Id
    FROM customers c, orders o
    WHERE c.Id = o.CustomerId
);
