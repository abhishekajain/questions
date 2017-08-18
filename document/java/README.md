# Install Open JDK 8 on debian jessie using jessie-backports
	$ sudo apt-get remove ca-certificates-java
	$ sudo apt-get remove openjdk-7*
	$ echo "deb [trusted=yes] http://ftp.us.debian.org/debian jessie-backports main" | sudo tee -a /etc/apt/sources.list.d/jessie-backports.list
	$ sudo apt-get update
	$ sudo apt-get install -t jessie-backports  openjdk-8-jdk ca-certificates-java

