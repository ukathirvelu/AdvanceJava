kafka installation steps:
------------------------
1.download zookeeper zip and extract that zip
set path as ZOOKEEPER_HOME in enveronment variables

2.after extract in conf folder rename zoo_sample.cfg file as zoo.cfg

2.download kafka zip and extract that zip
  i) after extract inside conf folder change "log.dirs" location in server.propertis file
  ii) in same folder zookeeper.propertis file change "dataDir" location to see the server log infirmation.
  
3.start zookeeper server
	.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
	
4.start kafka server
	.\bin\windows\kafka-server-start.bat .\config\server.properties
	
5.now in spring boot application in you kafka configuration properties file configur your server port and client id infirmation.

6.then run yourjava application and find messages in console.
