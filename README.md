# A1Task3
## Task 3 REST API

мини документация по API:

пример запроса: {url}?period=year&auth=0
такой запрос вернет ответ: 
  {"success":1,
    "postings":
    [
       {  
         "Mat_Doc":6777727662,
         "Item":2,
         "Doc_Date":"25.07.2020",
         "Posting_Date":"25.07.2020",
         "Material_Description":"HeadphonesJBLC100SIUBLKblack",
         "Quantity":3,
         "BUn":"pc",
         "Amount_LC":38.1,
         "Crcy":"BYN",
         "User_Name":"NLIMONOV",
         "Auth_Post":0
       },
       ...
   ]
  }
  
period (not required): 
    day -- все поставки за сегодня
    month -- все поставки за этот месяц
    year -- все поставки за этот год
    
auth (not required): 
    1 -- авторизированные поставки
    0 -- неавторизированные поставки
    
