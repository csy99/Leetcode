SELECT distinct(t1.Num) AS ConsecutiveNums
FROM logs AS t1, logs AS t2, logs AS t3
WHERE t1.Id = t2.Id - 1 AND t2.Id = t3.Id - 1 AND t1.Num = t2.Num AND t2.Num = t3.Num;
