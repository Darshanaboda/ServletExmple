package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Servlet implementation class MyServlet
 */

public class MyServlet {
 
    public static void main(String[] args) throws Exception {
		/*
		 * Thread thread = new Thread(new Runnable() {
		 * 
		 * @Override public void run() { try { MyServlet servlet = new MyServlet();
		 * servlet.service(null, null); } catch (ServletException | IOException e) {
		 * e.printStackTrace(); } } });
		 */
		/*
		 * thread.start(); thread.join();
		 */
    	try {
            // URL of the servlet
            URL url = new URL("http://localhost:8080/ServletExamples/Demo");
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Set the request method (GET, POST, etc.)
            connection.setRequestMethod("GET");
            // Get the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Redirect successful!");
                // You can perform additional actions after successful redirection here
            } else {
                System.out.println("Redirect failed. Response Code: " + responseCode);
            }
            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}