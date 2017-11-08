# DM2

Clone with the following command:

	git clone https://github.com/wdalmeida/dm-online-banking.git
	
	
Launch with
* Open CLI within the folder create by the clone command
* Then for each module to do the following
	
	`cd [module-name] `

	`mvn clean install spring-boot:run`
	
Warning: Before lauching data-access ensure that your mysql database is running on port 3306 and contain a database named "banking".
Therefore you will have to change the application.properties file located in
	
	cd data-access/src/main/java/fr/esipe/ressources
then re re-run the step for launching this module.

Modules Description :

* aspectj-aop-utils : Aspect module

* client-management-services : Advisor module to manage client and their account

* client-services : Client module to see their account 

* client-models : Contains DTO and entity used by 3 modules

* data-access-services : Database access module

* rest-client-utils : Called by management and client to access data-access

Documentation:

Project JavaDoc is available in the folder named "doc" at the root.