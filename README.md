# TestTask_4PreciseQ
test task for PreciseQ

4) Please write test using Selenium or similar tool according to scenario:
open sinoptik.ua website
search &#39;Драгобрат&#39; in search field
open &#39;Воскресенье&#39; tab
check that &#39;Воскресенье&#39; tab is opened
check that &#39;Давление, мм&#39; row contains values in range [600,700]
any extensions to task are welcome



requirements:
 - Java (6-8)
 - maven
 - firefox driver

how to run:
mvn clean test -Dtest=SinoptikUaGetPressuresTest

it appeared that test does not work for HtmlUnit driver.
So, use of FireFox is a must.

 You can find it in this link:
https://drive.google.com/file/d/163zyyqAQ-OvYjQgP61IIAOyWMLOWdOVE/view?usp=sharing
for FireFox
 and this archive should be unpacked to folder "C:/dev/programs"
 or you can change path in Config class