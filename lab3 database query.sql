-- Simple Queries
-- Q1
select guestName, guestAddress
from Guest G
where G.guestAddress like '%London%';


-- Q2
select * 
from Room R 
where (R.type = 'double' OR R.type = 'family' )
AND (R.price <= 40);

-- Q3
select * 
from Booking B
where B.dateTo IS Null;




