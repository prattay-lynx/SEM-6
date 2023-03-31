
# Questionnaires 📝  
Lab session-1 📚
-------------
**1. How will you insert multiple rows in a table without typing the query in each time?**
```
INSERT ALL
INTO <TABLE NAME> [<COLUMN_LIST>] VALUES (<VALUE>, <VALUE>, <VALUE>,...)
INTO <TABLE NAME> [<COLUMN_LIST>] VALUES (<VALUE>, <VALUE>, <VALUE>,...)
INTO <TABLE NAME> [<COLUMN_LIST>] VALUES (<VALUE>, <VALUE>, <VALUE>,...)
....
INTO <TABLE NAME> [<COLUMN_LIST>] VALUES (<VALUE>, <VALUE>, <VALUE>,...)
SELECT * FROM DUAL;
```

**2. What are the DDL commands that you have used in this assignment? Write the syntaxes of the DDL commands.**

DDL commands: CREATE, ALTER, DROP

Syntax for CREATE:
```
CREATE TABLE <TABLE NAME> (
<COLUMN_NAME> <DATATYPE> [<SIZE>] [<CONSTRAINT>],
<COLUMN_NAME> <DATATYPE> [<SIZE>] [<CONSTRAINT>],
.....
<COLUMN_NAME> <DATATYPE> [<SIZE>] [<CONSTRAINT>];
```
Syntax for ALTER:
```
ALTER TABLE <TABLE_NAME> ADD <COLUMN_NAME> <DATATYPE> [<SIZE>] [<CONSTRAINT>];
ALTER TABLE <TABLE_NAME> MODIFY <COLUMN_NAME> <DATATYPE> [<SIZE>] [<CONSTRAINT>];
ALTER TABLE <TABLE_NAME> DROP COLUMN <COLUMN_NAME>;
```
Syntax for DROP:
```
DROP TABLE <TABLE_NAME>;
```
Lab session-2 📃
-------------
**1. What is primary key? What is the requirement of a primary key? What should be the properties of primary key?**

Primary Key: A primary key is a key or a minimal set of keys(obtained from the set of candidate keys) that uniquely identifies a record or a row in a table./

Requirements:
- It must be unique
- It must not be null 

Properties:
- It should not change over a period of time
- It should be a mix of alphanumeric characters

**2. What do you mean by referential integrity? How can you achieve this?**

__Referential Integerity__:  In the context of relational databases, it requires that if a value of one attribute of a relation references a value of another attribute, 
then the referenced value must exist. This is known as referential Integrity.

Referential Integrity is achieved by working with primary key and foreign key.

Lab session-3 📚
-------------
**1. Is SELECT a DML statement? Comment critically.**

No, SELECT is not a DML command. DML stands for Data Manipulation Language. And we can't manipulate data through SELECT command.\
 We need INSERT, UPDATE, DELETE to 
manipulate data. SELECT is DQL(Data Query Language). We can query the database to retrieve data using SELECT.

**2. What will happen if the WHERE clause is not given with DELETE command?**

If, the WHERE clause is not given with the DELETE command, then all the records in the table are deleted.

Lab session-4 📗
-------------
**1. What are aggregate functions? Explain how GROUP BY works?**

__Aggregate functions__: They perform calculation on a column and returns a single value. They ignore null values and are often used with group by clause.

The GROUP BY Statement in SQL is used to arrange identical data into groups with the help of some functions. i.e if a particular column has same values in different 
rows then it will arrange these rows in a group.
Syntax:
```
SELECT <[COLUMN_LIST]> <FUNCTION_NAME>(<COLUMN_NAME>)
FROM <TABLE_NAME>
WHERE <CONDITION>
GROUP BY <[COLUMN_LIST]>
HAVING <CONDITION>
ORDER BY <[COLUMN_LIST]>
```

__2. What is the content of the table DUAL? Why is it required?__

Dual table has one column 'DUMMY' defined to be VARCHAR2(1) and contains one row with a value 'X'.

Selecting from the DUAL table is useful for computing a constant expression with the select statement. Because DUAL has only one row and one column, and the constant 
is returned only once.

Lab session-5 📃
-------------
**1. What is the difference between conditional and natural join?**

Conditional join has explicit join condition, where as natural join's conditions are formed by matching all pairs of columns in the table with same name and datatype.

**2. What is the difference between inner and outer join?**

| Join Type | Description | 
| --- | --- | 
| Inner Join | Returns only the matching rows from both tables. |
| Outer Join | Returns all rows from both tables, filling in missing values with NULL if no match is found. |

**3. Explain the different types of outer joins.**

- __Left Outer Join__: Returns only unmatched rows from the left table, combined with the matching rows from the right table.
- __Right Outer Join__: Returns only unmatched rows from the right table, combined with the matching rows from the left table.
- __Full Outer Join__: Returns only unmatched rows from both the table along with the matching rows.

**4. Explain why a self-join mandatorily needs table name aliasing?**

Since self join involves the same table being used twice, in order to segregate the reference to each instance of the same table, we need aliasing.

Lab session-6 🔖
-------------
**1. Explain the difference between UNION and UNION ALL?**

UNION removes duplicate rows from the result, whereas UNION ALL shows the duplicate rows in the result.

**2. Write queries to demonstrate how UNION and INTERSECT obey De Morgan's laws.**
```
(A UNION B)' = A' INTERSECT B'
(A INTERSECT B)' = A' UNION B'
```

Lab session-7 📗
-------------
**1. What is the difference in query processing for ordinary and correlated subqueries?**

With an ordinary nested subquery, the inner query runs first and executes once, returning values to be used by the main query. A correlated subquery executes once for
each candidate row considered by the outer query. So, the inner query is driven by the outer query.

**2. How can query no. 17 be executed using join?**
```
select distinct(dname) from dept, emp where dept.dno = emp.deptno;
```
Lab session-8 📚
-------------
**1. Explain the advantages of creating a view.**

- Views don't store data in a physical location.
- Views can be used to hide some of the columns of the table.
- Views can provide access restriction, since data insertion, updatation and deletion is not possible with the views.

**2. What do you mean by updatable view? What are the conditions for a view to be updatable?**

1st part
- An updatable view is a database view that allows users to modify the underlying tables through the view. 
- This means that changes made to the view are reflected in the tables, and vice versa.

2nd part
- The view must have only one database table as its source.
- The view must not use the DISTINCT keyword in its definition.
- The view must not use any aggregate functions such as SUM, AVG, COUNT, etc. 
- The view must not contain any subqueries in the SELECT statement.

Lab session-9 ✌
-------------
**1. Explain the requirements of having stored procedures in databases.**

i) __Resuability:__ Multiple users and applications can easily use and reuse stored procedures.\
ii) __Modifiable:__ We can quickly change the statements in a stored procedure, as and when we want to.\
iii) __Security:__ Stored procedures allows us to enhance the security of an application on a database.\
iv) __Low network traffic:__ The server only process the the procedures values instead of whole query.

Lab session-10 ✔
--------------
**1. What is a trigger? When is a trigger fired?**

A trigger is a special type of stored procedure that automatically runs when an event occurs in database server.

**2. Explain the difference between row level trigger and statement level trigger.**

Row level triggers executes once for each and every row in transaction. Statement level triggers only executes once for each single transaction.

**3. Explain the difference between before, after and instead triggers.**

- Before triggers are fired before insert, update or delete operation.
- After triggers are fired after insert, update or delete operation.
- Instead of allows us to override functionality or implement functionality that otherwise isn't supported.


