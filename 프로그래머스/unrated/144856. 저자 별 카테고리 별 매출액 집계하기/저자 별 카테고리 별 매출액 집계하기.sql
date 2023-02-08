# with sales as(
#     select a.book_id, sum(a.sales) sales
#     from (SELECT *
#             from book_sales
#             where month(sales_date) = 1) a
#     group by a.book_id
# )
# select a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(s.sales)*b.price TOTAL_SALES
# from book b 
# left join sales s on b.book_id = s.book_id
# left join author a on b.author_id = a.author_id
# group by b.category, b.author_id
# order by a.author_id asc, b.category desc;

with bs as (
select b.*, sum(s.sales*b.price) total_sales
from book b 
    left join book_sales s on b.book_id = s.book_id
where month(s.sales_date) = 1
group by b.author_id, b.category
)
select a.author_id, a.author_name, bs.category, bs.total_sales
from bs bs 
    left join author a on a.author_id = bs.author_id
order by a.author_id asc, bs.category desc;