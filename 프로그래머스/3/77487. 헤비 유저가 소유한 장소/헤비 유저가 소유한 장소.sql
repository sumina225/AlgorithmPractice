-- 코드를 입력하세요
SELECT A.ID AS ID
     , A.NAME AS NAME
     , A.HOST_ID AS HOST_ID
  FROM PLACES A
 WHERE HOST_ID IN (SELECT AA.HOST_ID
                     FROM PLACES AA
                    GROUP BY AA.HOST_ID
                   HAVING COUNT(*) >= 2
                  )
 ORDER BY A.ID