# DM2

Clone with the following command:

	git clone https://github.com/wdalmeida/dm-online-banking.git
	
	
Launch 
* Open CLI within the folder created by the clone command
* For each module do the following
	
	`cd [module-name] `

	`mvn clean install spring-boot:run`
	
Warning: Before lauching data-access ensure that your mysql database is running on port 3306 and contain a database named "banking".
If you encounter an error, you will have to change the application.properties file located in ressources
	
	cd data-access/src/main/java/fr/esipe/ressources
then re re-run the step for launching this module.

Modules Description :

* aspectj-aop-utils : Aspect module

* client-management-services : advisors' module to manage client and their account

* client-services : Client module to see their account 

* client-models : Contains DTO and entity used by 3 modules

* data-access-services : Database access module

* rest-client-utils : Called by management-services and client-services to access data-access

Documentation:

Project JavaDoc is available in the folder named "doc" at the root.


Diagramme:

* deployement.svg