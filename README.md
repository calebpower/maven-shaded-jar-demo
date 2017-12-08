# Maven Shaded JAR Demo
*By Caleb Power, Updated December 8, 2017*

This small demo program demonstrates how to read from resources that are saved in a shaded JAR file. In addition, it also shows how one might load an external configuration file into RAM.

To clone, build, and run this repository, simply execute the following.

`git clone git@github.com:calebpower/maven-shaded-jar-demo.git`

`mvn clean package verify`

`java -jar target/ShadedJarDemo.jar ["input_file.txt"]`