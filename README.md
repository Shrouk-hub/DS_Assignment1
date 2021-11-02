# DS_Assignment1

in this Assignment, I designed the Architectural Model of a distributed monitoring system that is used in a mega-city to control traffic in the street.

in (i) I used the mobile agents and implement it in (ii).

In (ii) to implement the mobile agents, I used the sockets to create the server and client and make them communicate with each other, I make three files the sensor and driver file ,the computer file and the server file, the server file is the server, the computer file act as a Server and as a client, and the sensor and driver file is the Client , first I run the server then I run the computer then i run the client, then the client make request to computer, then computer make request to server, the server ask the computer about the two places, then the computer ask the client about them, then the sensor send the data to computer, then the computer send the data to server, then the server make recommendations and send the best way to computer then computer send it to driver  

in (iii) I designed Application-Level Protocol (ALP) that models the interaction between the different nodes in this system and implement in in (iv).

In (iv) I used the same sequence in (ii) but with alot of clients and computers so i made the system multithreading.
