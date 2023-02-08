-- 코드를 입력하세요
select fp.category, p.price, fp.product_name
from food_product fp
    right join (
        SELECT category, max(price) price
        from food_product
        group by category
    ) p on fp.price = p.price and fp.category = p.category
group by category
having category in ('과자', '국', '김치', '식용유')
order by p.price desc