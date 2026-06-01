-- 코드를 입력하세요
SELECT A.ANIMAL_ID AS ANIMAL_ID
     , A.NAME AS NAME
     , CASE
           WHEN SEX_UPON_INTAKE LIKE '%Neutered%'
             OR SEX_UPON_INTAKE LIKE '%Spayed%'
           THEN 'O'
           ELSE 'X'
       END AS 중성화
  FROM ANIMAL_INS A
 