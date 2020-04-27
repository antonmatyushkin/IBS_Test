# IBS_Test
1. API тестирование.
Задача: Используя этот сервис с тестовым REST-API https://reqres.in/, написать 2 теста.
* получить список пользователей (GET  https://reqres.in/api/users?page=2), замапить на объект и проверить, что все поля пришли (достаточно на notNull).
* создать пользователя (POST https://reqres.in/api/users) с данными из примера на сайте: 
    - подготовить тело запроса, 
    - отправить запрос с телом, 
    - замапить ответ на объект 
    - проверить, что в ответе те же самые значения из запроса.

Автотесты необходимо написать,  используя данный стек:
Java, testNG, restAssured.

2. UI тестирование
Задача:
· запустить Chrome
· открыть https://www.google.com/
· написать в строке поиска «Открытие»
· нажать Поиск
· проверить, что результатах поиска есть https://www.open.ru
· перейти на сайт https://www.open.ru
· проверить в блоке «Курс обмена в интернет-банке», что курс продажи больше курса покупки, для USD и для EUR.

Автотест необходимо написать,  используя данный стек:
Java, testNG, Selenide