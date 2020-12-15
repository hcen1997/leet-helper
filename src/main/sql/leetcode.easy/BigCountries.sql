-- 输出表中所有大国家的名称、人口和面积。
-- name            | continent  | area       | population   | gdp
select name,population   ,area from World
where area>3000000 or population    >25000000;