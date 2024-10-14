# ComputerNetworks_Lab
JAVA PROGRAM TO GET CONNECTED TO A WEB SERVER

I. Steps from getting connected to the web server:
Step 1: Define the URL (which is the one you want to access)
Step 2: Create a URL object (which represents the URL we connect and work with)
Step 3: Open a connection (
- We should use “HttpURLConnection” class to use specific functions of HTTP (GET, POST, …). And we follow these following steps.
	Step 3a: call “openConnection()” method => open the connection
	Step 3b: cast the returned connection to “HttpURLConnection”
)
Step 4: Set the request method (
- HTTP requests such as: GET, POST, PUT and DELETE => In this exercise, we use GET to retrieve the data. And we follow these following steps
	Step 4a: Set the request method to “GET” by using “setRequestMethod(“GET”)” on the “HttpURLConnection”.
)
Step 5: Check the response code (check the status by using “getResponseCode()” method)
Step 6: Read and Display Response Content (
- Retrieve and display content by the Web server. And we follow these following steps.
	Step 6a: Create “BufferedReader” to read the response content line by line
	Step 6b: Append each line to “StringBuilder” to construct the complete response content.
	Step 6c: Print the content
)

II. Steps to download the web page
Part 1: Code in server side:
    Step 1: create a server socket
    Step 2: listen and wait for incoming connection
    Step 3: accept the connection request
    Step 4: send/ receive data
    Step 5: close connection
Part 2: Code in client side:
    Step 1: Identify server IP and port
    Step 2: Create a TCP socket to a server
    Step 3: Establish a connection to the server
    Step 4: Send/ receive data
    Step 5: Close the connection