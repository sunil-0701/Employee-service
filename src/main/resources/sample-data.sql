-- Run this after the application has created the tables.
INSERT INTO departments (id, name, location) VALUES
  (1, 'Engineering', 'Bengaluru'),
  (2, 'Human Resources', 'Mumbai'),
  (3, 'Finance', 'Pune');

INSERT INTO employees (first_name, last_name, email, phone_number, date_of_birth, join_date, salary, designation, address, department_id) VALUES
  ('Aarav', 'Sharma', 'aarav.sharma@example.com', '9876543210', '1992-04-12', '2020-01-15', 85000.00, 'Senior Developer', 'Bengaluru', 1),
  ('Diya', 'Patel', 'diya.patel@example.com', '9876543211', '1994-07-22', '2021-03-10', 70000.00, 'Developer', 'Bengaluru', 1),
  ('Rohan', 'Gupta', 'rohan.gupta@example.com', '9876543212', '1990-11-03', '2019-06-01', 110000.00, 'Engineering Manager', 'Bengaluru', 1),
  ('Ananya', 'Singh', 'ananya.singh@example.com', '9876543213', '1995-02-18', '2022-04-20', 62000.00, 'QA Engineer', 'Bengaluru', 1),
  ('Kabir', 'Mehta', 'kabir.mehta@example.com', '9876543214', '1993-09-09', '2020-08-17', 68000.00, 'Business Analyst', 'Bengaluru', 1),
  ('Isha', 'Verma', 'isha.verma@example.com', '9876543215', '1991-05-14', '2018-10-05', 75000.00, 'HR Manager', 'Mumbai', 2),
  ('Vivaan', 'Reddy', 'vivaan.reddy@example.com', '9876543216', '1996-12-30', '2023-01-09', 48000.00, 'HR Executive', 'Mumbai', 2),
  ('Meera', 'Nair', 'meera.nair@example.com', '9876543217', '1989-03-27', '2017-07-11', 95000.00, 'Finance Manager', 'Pune', 3),
  ('Arjun', 'Kapoor', 'arjun.kapoor@example.com', '9876543218', '1994-08-16', '2021-09-13', 72000.00, 'Accountant', 'Pune', 3),
  ('Sara', 'Khan', 'sara.khan@example.com', '9876543219', '1997-01-25', '2023-05-22', 52000.00, 'Financial Analyst', 'Pune', 3);

SELECT setval(pg_get_serial_sequence('departments', 'id'), (SELECT MAX(id) FROM departments));
