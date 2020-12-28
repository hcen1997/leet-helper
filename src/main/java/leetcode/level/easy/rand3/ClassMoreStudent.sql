--

select class,count(class) as cou from courses group by class

select c.class as class from
(select d.class,count(d.class) as cou from (select distinct class, student from courses) d group by class) c
where c.cou >=5;

select distinct class, student from courses

