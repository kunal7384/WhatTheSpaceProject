set projectLocation=F:\Selenium Practice code Oct 2018\PracticeHybridFrameWork
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\practicehybrid.xml
pause