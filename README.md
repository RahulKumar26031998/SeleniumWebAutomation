This is a dummy test project build with java testNG framework design replicating the features i tested while working in my previous company for a Logistics Client. please note that i have kept the code as simple as i can and there is not much complexity involved.

The version of selenium is greater than 4 and the java version used is 21. If you are using an older version of selenium then there are chances that few tests may not run successfully. This is a maven project.

This project incorporates end to end testing of a websites using various locators , data driven testing , use of listeners, grouping of methods etc.

There are 2 ways you can run the project tests after importing it into your system.(Windows)

Using Command Line Interface For running in cmd all you have to do is install maven into your system and then make sure you add it to the system environment variables. To make sure that maven is installed you can give the command : mvn --version
i) open cmd and navigate to your workspace or the location where you have the project diretory and then just give the command : mvn test -PRegression I have used two profile names, which you can see in the pom.xml file in the project. One of them is Regression.

Using Jenkins download jenkins LTS file from the url : https://www.jenkins.io/download/ open cmd and cd to the folder where jenkins war file is downloaded and give command : java -jar jenkins.war --httpPort=9090 let it download the dependencies and then enter the secret key which will will be stored in your system. Jenkins will give you the folder path as well. Once you enter the secret key, let the installation complete and then setup a username and password.
now open any browser and type -> localhost:9090

give the userid and passwor and setup your account. i) click on new Item and select 'Freestyle project' and give a name to your item. Click OK. ii) from advanced select 'use custom workspace'. give your project directory path. iii) Scroll down to 'Add build step' and select 'invoke top-level maven targets'. iv) In the 'Goals' box give the command you want to run : test -PRegression -Dbrowser=Firefox. Click on Save v) Click on Build Now.

Note : There is a test which should fail because we intentionally want it to since we want to see that in the 'Extent Report'.