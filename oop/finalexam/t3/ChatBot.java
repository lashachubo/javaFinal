package oop.finalexam.t3;

import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;

public class ChatBot {
    private String url;
    private String botName;

    public ChatBot(String configFilePath) throws IOException {
        loadConfig(configFilePath);
    }

    private void loadConfig(String path) throws IOException {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(path)) {
            props.load(input);
        }
        url = props.getProperty("url");
        botName = props.getProperty("name");
        if (url == null || botName == null) {
            throw new IllegalArgumentException("url and name must be defined in config");
        }
    }

    private String sendGetRequest(String query) throws IOException {
        URL requestUrl = new URL(url + "?" + query);
        HttpURLConnection con = (HttpURLConnection) requestUrl.openConnection();
        con.setRequestMethod("GET");
        return readResponse(con);
    }

    private String sendPostRequest(String query, String jsonBody) throws IOException {
        URL requestUrl = new URL(url + "?" + query);
        HttpURLConnection con = (HttpURLConnection) requestUrl.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setDoOutput(true);

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        return readResponse(con);
    }

    private String readResponse(HttpURLConnection con) throws IOException {
        int status = con.getResponseCode();
        InputStream stream = (status < 400) ? con.getInputStream() : con.getErrorStream();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line.trim());
            }
            return response.toString();
        }
    }

    public void printAllBlogs() throws IOException, JSONException {
        String response = sendGetRequest("api=blogs");
        JSONObject obj = new JSONObject(response);
        JSONArray data = obj.getJSONArray("data");

        System.out.println("\nAll Blog Posts:");
        for (int i = 0; i < data.length(); i++) {
            JSONObject blog = data.getJSONObject(i);
            System.out.printf("ID: %d, Title: %s, Author: %s\nContent: %s\n\n",
                    blog.getInt("id"),
                    blog.getString("title"),
                    blog.getString("author"),
                    blog.getString("content"));
        }
    }

    public void printStats() throws IOException, JSONException {
        String response = sendGetRequest("api=stats");
        JSONObject obj = new JSONObject(response);

        System.out.println("\nBlog Site Statistics:");
        System.out.println("Total posts: " + obj.getInt("total_posts"));
        System.out.println("Max posts: " + obj.getInt("max_posts"));
        System.out.println("Remaining posts: " + obj.getInt("remaining_posts"));
        System.out.println("Percentage used: " + obj.getDouble("percentage_used") + "%");
        System.out.println("Can add more: " + obj.getBoolean("can_add_more"));
    }

    public void createNewPost(String title, String author, String content) throws IOException {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("author", author);
        json.put("content", content);

        String response = sendPostRequest("api=blogs", json.toString());
        System.out.println("Response from server: " + response);
    }

    public void startChat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Chatbot '" + botName + "' started.");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1 - View all blog posts");
            System.out.println("2 - View blog statistics");
            System.out.println("3 - Create a new blog post");
            System.out.println("0 - Exit");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        printAllBlogs();
                        break;
                    case "2":
                        printStats();
                        break;
                    case "3":
                        System.out.print("Enter blog title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author name: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter content: ");
                        String content = scanner.nextLine();
                        createNewPost(title, author, content);
                        break;
                    case "0":
                        System.out.println("Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try {
            ChatBot bot = new ChatBot("oop/finalexam/t3/config.txt");
            bot.startChat();
        } catch (Exception e) {
            System.err.println("Failed to start chatbot: " + e.getMessage());
        }
    }
}
