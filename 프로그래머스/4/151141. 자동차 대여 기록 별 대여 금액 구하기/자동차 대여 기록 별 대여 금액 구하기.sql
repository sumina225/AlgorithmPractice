-- 코드를 입력하세요
SELECT A.HISTORY_ID AS HISTORY_ID
     , FLOOR((A.END_DATE - A.START_DATE + 1) * B.DAILY_FEE * ((100 - NVL(C.DISCOUNT_RATE,0))/100)) AS FEE
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
 INNER JOIN CAR_RENTAL_COMPANY_CAR B
    ON A.CAR_ID = B.CAR_ID
  LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
    ON B.CAR_TYPE = C.CAR_TYPE
   AND C.DURATION_TYPE = CASE
                            WHEN A.END_DATE - A.START_DATE + 1 >= 90
                            THEN '90일 이상'
                            WHEN A.END_DATE - A.START_DATE + 1 >= 30
                            THEN '30일 이상'
                            WHEN A.END_DATE - A.START_DATE + 1 >= 7
                            THEN '7일 이상'
                            ELSE NULL
                         END
 WHERE B.CAR_TYPE = '트럭'
 ORDER BY FEE DESC
        , A.HISTORY_ID DESC