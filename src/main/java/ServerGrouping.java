import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerGrouping {

    public static void main(String[] args) {
        // Create a HashMap to store return values as keys and list of servers as values
        HashMap<Integer, List<String>> serversByReturnValue = new HashMap<>();

        // Input data: servers and their return values
        HashMap<String, Integer> servers = new HashMap<>();
        servers.put("Server 1", 5);
        servers.put("Server 2", 4);
        servers.put("Server 3", 5);
        servers.put("Server 4", 6);
        servers.put("Server 5", 2);
        servers.put("Server 6", 4);

        // Iterate through each server and populate the HashMap
        for (Map.Entry<String, Integer> entry : servers.entrySet()) {
            String serverName = entry.getKey();
            int returnValue = entry.getValue();

            // Check if the return value is already a key in the HashMap
            if (serversByReturnValue.containsKey(returnValue)) {
                // If yes, add the current server to the existing list
                serversByReturnValue.get(returnValue).add(serverName);
            } else {
                // If no, create a new list with the server and put it in the HashMap
                List<String> serversList = new ArrayList<>();
                serversList.add(serverName);
                serversByReturnValue.put(returnValue, serversList);
            }
        }

        // Print the servers grouped by their return values
        for (Map.Entry<Integer, List<String>> entry : serversByReturnValue.entrySet()) {
            int returnValue = entry.getKey();
            List<String> serversList = entry.getValue();

            System.out.println("Servers with return value " + returnValue + ":");
            for (String server : serversList) {
                System.out.println(server);
            }
            System.out.println(); // Print an empty line for clarity
        }
    }
}
