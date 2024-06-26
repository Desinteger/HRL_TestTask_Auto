# Название проекта

Тестовое задание HR-link (Junior QA Auto).

# Технологии

Java 11, maven 3.9.1, JUnit 5.10.2, allure 2.27.0, selenium 4.20.0

# Описание

Автоматизированный тест-кейс: Проверка недоступности юрлица, на которое у кадровика нет прав.

**Предварительное условие:**

  В пространстве существуют:  
- Юрлицо ОАО "Тепло".
- Юрлицо ООО "Кот".

  В ОАО "Тепло" существует:  
- Сотрудник с ролью "Кадровик".

  В ООО "Кот" существуют:  
- Сотрудник Орлов Д.
- Заявление от Орлова Д.
- Документ, в котором в качестве сотрудника указан Орлов Д.

**Сценарий:**

1. Выполнить вход в ЛК кадровика.
   Ожидаемый результат: в реестре документов не отображается документ, в котором в качестве сотрудника указан Орлов Д.
2. В верхнем фильтре нажать на фильтр "Юрлицо".
   Ожидаемый результат: в списке юрлиц нет ООО "Кот".
3. Открыть реестр заявлений.
   Ожидаемый результат: в реестре заявлений не отображается заявление от Орлова Д.
4. Открыть реестр сотрудников.
   Ожидаемый результат: в реестре сотрудников не отображается сотрудник Орлов Д.
5. Открыть раздел "Справочники".
   Ожидаемый результат: в справочнике юрлиц нет ООО "Кот"

  Для написания автотеста использовался паттерн проектирования Page Object Mode, согласно которому каждой странице приложения соответствует свой класс со своими локаторами и методами.  
  URI тестового приложения вынесен в отдельный класс ru.myhrlink.apptest.config.AppConfig.  
  Для навигации по вкладкам бокового меню создан вспомогательный класс ru.myhrlink.apptest.menu.TabNavigationManager.  
  Метод авторизации, настройки и параметры WebDriver, а также открытие и закрытие браузера хранятся в отдельном классе BaseTest.  
  Креды и тестовые данные вынесены в отдельный класс TestData.

# Склонировать репозиторий

`git clone https://github.com/Desinteger/HRL_TestTask_Auto.git`

# Настройки

В методе setUp() в классе BaseTest:
- Можно изменить параметры ожиданий в строке `webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));` в случае медленной загрузки страниц.
- Можно изменить параметры разрешения, с которым будет открываться браузер при запуске автотеста, в строке `webdriver.manage().window().setSize(new Dimension(1920,1080));`

# Запустить тест и сгененировать отчёт

`mvn clean test`

# Сформировать и открыть отчёт в Allure

`mvn allure:serve`
