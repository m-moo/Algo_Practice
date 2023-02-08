-- 코드를 입력하세요
SELECT ii.INGREDIENT_TYPE, sum(fh.total_order) TOTAL_ORDER
from ICECREAM_INFO ii
    left join FIRST_HALF fh on fh.flavor = ii.flavor
group by ii.ingredient_type;