
      # Write your MySQL query statement below.'
     select (
      SELECT DISTINCT salary  
      FROM (
          SELECT salary, 
                 DENSE_RANK() OVER (ORDER BY salary DESC) AS rn
          FROM Employee
      ) t
      WHERE rn = 2
     ) as SecondHighestSalary

