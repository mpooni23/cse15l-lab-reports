import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler2 implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> s = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Hello Manasa");
        } else if (url.getPath().contains("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                s.add(parameters[1]);
                StringBuffer sb = new StringBuffer();
                for (int index=0; index < s.size(); index++) {
                    sb.append((index+1) + ". " + s.get(index) + "\n");
                }
                return String.format(sb.toString());
            }
        } else if (url.getPath().contains("/search")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                return find((String) parameters[1]);
            }
        }
        return "404 Not Found!";
    }
    public String find(String searchString) {
        ArrayList<String> temp = new ArrayList<String>();
        for (int index=0; index < s.size(); index++){
            if (s.get(index).indexOf(searchString) > 0){
                temp.add(s.get(index));
            }
        }
        return temp.toString();
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