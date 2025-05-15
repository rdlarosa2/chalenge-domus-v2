# challenge-domus
Challenge Domus Global

The solution is implemented as an API REST called 'API Movie Director'.

# Prerequisites (Windows 64 bits OS)

1. You need to have installed jdk 21 in the machine where you will execute the API.
2. You need to have installed a recent version of git
3. You need to have installed a recent version of maven 

# Installation (Windows 64 bits OS)

1. Execute a 'Command Prompt' application.
2. Change the current directory to the directory where you will download the project.
   Example: cd C:\ws_springb
3. Get the source code of the project executing the command: git clone https://github.com/rdlarosa2/chalenge-domus-v2.git
4. Change the current directory (example: C:\ws_springb) to the directory C:\ws_springb\chalenge-domus-v2 
executing the command: cd chalenge-domus-v2  

# Running the API

1. In the last directory (example: C:\ws_springb\chalenge-domus-v2) execute the command: mvn install
2. To run the API REST execute the command: mvn spring-boot:run 
3. To test the API you can open http://localhost:8080/api/directors?threshold=<i>threshold</i> in any browser.
You need to replace <i>threshold</i> with a non-negative number.   
For example: http://localhost:8080/api/directors?threshold=3

