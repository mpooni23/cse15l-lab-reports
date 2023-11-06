# Week 3 - Servers and SSH Keys

# **1. Code for StringServer.java**

```
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler2 implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> strings = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Hello Manasa");
        } else if (url.getPath().contains("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                strings.add(String.format(parameters[1]));
                StringBuffer sb = new StringBuffer();
                for (int index = 0; index < strings.size(); index++) {
                    sb.append((index + 1) + ". " + strings.get(index) + "\n");
                }
                return String.format(sb.toString());
            }
        } else if (url.getPath().contains("/search")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                return find(String.format(parameters[1]));
            }
        }
        return "404 Not Found!";
    }

    public String find(String searchString) {
        ArrayList<String> newStrings = new ArrayList<>();
        for (int index =0; index < strings.size(); index++) {
            if (strings.get(index).contains(searchString)) {
                newStrings.add(strings.get(index));
            }
        }
        return newStrings.toString();
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler2());
    }
}

```

# **2. Two screen shots of /add-message**

![Image](Add message 1.png)

1. Which methods in your code are called?
   
When the SearchEngine class is invovked from the command line with the command line argument "4000" it invokes the main() method in SearchEngine which inturn invokes the method server.start() providing the port and an instance of the handler (handler2) which will start the server at the required port. The server is listening for incoming messages at the specified port (4000). When we click http://localhost:4000/add-message?s=Hello in the browser, on receiving this message the webserver calls the handlerequest() method of the Handler2 class passing in the provided URI /add-message?s=Hello. This method checks if the URL path contains "/add-message". If such is the case , it then then extracts the given querystring and parses the querystring to extract the key and the value. It checks to see if the key is equal to "s" and then adds the given value to an arraylist strings. When this method returns it walks through all the entries in the arraylist and for each entry in the arraylist, it adds an entry into a stringbuffer, by concatenating the current index in the arraylist (incremented by 1) followed by a ". ", the string stored at that location, followed by a new line. It then converts the contents of the stringbuffer to a string and returns it as the return value (responds with the entire string so far).

```
   1. handleRequest(URI url)
   2. url.getPath() 
   3. url.getQuery()
   4. String[] parameters = url.getQuery.split("=")  <-- call split on the query string to split it into key and value based on "=" 
   5. strings.add(parameters[0]) <-- method on arraylist strings to append the value parameters[0] 
   6. StringBuffer sb = new StringBuffer() - > create string buffer sb
   7. sb.append() method on the String buffer for each entry in arraylist strings
   8. sb.toString()
   9. sb.StringFormat()
```

2. What are the relevant arguments to those methods, and the values of any relevant fields of the class?
   
The handlerequest method is provided the URI string as a parameter url /add-message?s=Hello. We extract the path from the passed in parameter url by calling the helper method getPath() method on the url -> url.gethPath(). The getPath() method does not take any parameters. If the path contains "/add-messages" we then call the getQuery() helper method on the url to get the query string. The method getQuery() does not take any parameter. We call the split method on the query string based on regex "=". split takes the regex "=" as parameter and splits the string into two parts. If the key matches "s" then we append the value to an arraylist strings by calling the add() method on the arraylist passing the value to add. When this method returns it walks through all the entries in the arraylist and for each entry in the arraylist, it adds an entry into a stringbuffer, by concatenating the current index in the arraylist (incremented by 1) followed by a ". ", the string stored at that location, followed by a new line. It then converts the contents of the stringbuffer to a string by called sb.toString() which does not take any parameters and returns it as the return value by calling String.Format with this string as the argument value (responds with the entire string so far).

```
url <- /add-message?s=Hello
url.getpath() <- /add-message
url.getQuery() <- s=Hello
String[] parameters = url.getQuery().split("=") <- parameters[0] = "s"; parameters[1] = "Hello"
strings.add("Hello") -> strings["Hello"]  
sb.append() -> "1. Hello"
sb.toString() ->"1. Hello"
```

3. How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.

for each specific request, if it is a add-message request the passed in string is appended to the string arraylist. 
   
When we click http://localhost:4000/add-message?s=Hello in the browser, on receiving this message the webserver calls the handlerequest() method of the Handler2 class passing in the provided URI /add-message?s=Hello. This method checks if the URL path contains "/add-message". If such is the case , it then then extracts the given querystring ("s=hello") and parses the querystring by splitting it based on "=" to extract the key and the value. The string array parameters contains the key at index 0 and the value at index 1. It checks to see if the key is equal to "s" and then adds the given value to an arraylist strings. The value Hello gets appended to the String arraylist strings. When this method returns it walks through all the entries in the arraylist and for each entry in the arraylist, it adds an entry into a stringbuffer sb, by concatenating the current index in the arraylist (incremented by 1) followed by a ". ", the string stored at that location, followed by a new line. It then converts the contents of the stringbuffer to a string and returns it as the return value (responds with the entire string so far).

```
url <- /add-message?s=Hello
url.getpath() <- /add-message
url.getQuery() <- s=Hello
String[] parameters = url.getQuery().split("=") <- parameters[0] = "s"; paraneters[1] = "Hello"
strings.add("Hello") -> strings["Hello"]  
sb.append() -> "1. Hello"
sb.toString() ->"1. Hello"
Stringformat("1. Hello")
```

![Image](Add message 2.png)

1. Which methods in your code are called?
   
When we click http://localhost:4000/add-message?s="How%20are%20you" in the browser, on receiving this message the webserver calls the handlerequest() method of the Handler2 class passing in the provided URI /add-message?s=How%20are%20you. This method checks if the URL path contains "/add-message". If such is the case, it then then extracts the given querystring and parses the querystring to extract the key and the value. It checks to see if the key is equal to "s" and then adds the given value to an arraylist. When this method returns it walks through all the entries in the arraylist and for each entry in the arraylist, it adds an entry into a stringbuffer, by concatenating the current index in the arraylist (incremented by 1) followed by a ". ", the string stored at that location, followed by a new line. It then converts the contents of the stringbuffer to a string and returns it as the return value (responds with the entire string so far).

```
   1. handleRequest(URI url)
   2. url.getPath() 
   3. url.getQuery()
   4. String[] parameters = url.getQuery.split("=")  <-- call split on the query string to split it into key and value based on "=" 
   5. strings.add(parameters[0]) <-- method on arraylist strings to append the value parameters[0] 
   6. StringBuffer sb = new StringBuffer() - > create string buffer sb
   7. sb.append() method on the String buffer for each entry in arraylist strings
   8. sb.toString()
   9. sb.StringFormat()
```

2. What are the relevant arguments to those methods, and the values of any relevant fields of the class?
   
The handlerequest method is provided the URI string as a parameter url /add-message?s=How are you. We extract the path from the passed in parameter url by calling the helper method getPath() method on the url -> url.gethPath(). The getPath() method does not take any parameters. If the path contains "/add-messages" we then call the getQuery() helper method on the url to get the query string. The method getQuery() does not take any parameter. We call the split method on the query string based on regex "=". split takes the regex "=" as parameter and splits the string into two parts. If the key matches "s" then we append the value to an arraylist strings by calling the add() method on the arraylist passing in the value to add. When this method returns it walks through all the entries in the arraylist and for each entry in the arraylist, it adds an entry into a stringbuffer, by concatenating the current index in the arraylist (incremented by 1) followed by a ". ", the string stored at that location, followed by a new line. It then converts the contents of the stringbuffer to a string by called sb.toString() which does not take any parameters and returns it as the return value by calling String.Format with this string as the argument value (responds with the entire string so far).

```
url <- /add-message?s=How%20are%20you
url.getpath() <- /add-message
url.getQuery() <- s="How are you"
String[] parameters = url.getQuery().split("=") <- parameters[0] = "s"; parameters[1] = "How are you"
s.add("How are you") -> s["Hello", "How are you"]  
sb.append() -> "1. Hello"
                "2. How are you"
sb.toString() ->"1. Hello
                 2. How are you"
```

3. How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.

For each specific request, if it is a add-message request the passed in string is appended to the string arraylist. 

When we click http://localhost:4000/add-message?s=How are you in the browser, on receiving this message the webserver calls the handlerequest() method of the Handler2 class passing in the provided URI /add-message?s=How are you. This method checks if the URL path contains "/add-message". If such is the case , it then then extracts the given querystring ("s=How are you") and parses the querystring by splitting it based on "=" to extract the key and the value. The string array parameters contains the key at index 0 and the value at index 1. It checks to see if the key is equal to "s" and then adds the given value "How are you" to an string arraylist strings. The value "How are you gets" appended to the String arraylist s. When this method returns it walks through all the entries in the arraylist and for each entry in the arraylist, it adds an entry into a stringbuffer sb, by concatenating the current index in the arraylist (incremented by 1) followed by a ". ", the string stored at that location, followed by a new line. Since there would be two entries in the arraylist at index 0 and 1 namely "Hello" and "How are you" we would produce a String buffer containing these values.It then converts the contents of the stringbuffer to a string and returns it as the return value (responds with the entire string so far).

```
url <- /add-message?s=How are you
url.getpath() <- /add-message
url.getQuery() <- s=How%20are%20you
String[] parameters = url.getQuery().split("=") <- parameters[0] = "s"; parameters[1] = "How are you"
s.add("How are you") -> s["Hello", "How are you"]  
sb.append() ->
"1. Hello"
"2. How are you"
sb.toString() ->
"1. Hello
 2. How are you"
```
