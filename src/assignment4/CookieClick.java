package assignment4;

import java.util.Scanner;
import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;

public class CookieClick {
    public static void main(String[] args) {
        // Declare all game state variables inside main method
Scanner in = new Scanner(System.in);
		
		Color TAN = new Color(210, 180, 140);
		Color BROWN = new Color(139, 69, 19);

        int cookieCount = 0;
        int cookiesPerClick = 1;
        int cookiesPerSecond = 1;
        int clickPowerCost = 20;
        int idlePowerCost = 60;
        long lastIdleTime = System.currentTimeMillis();  // Initialize idle timer

        // Store random positions for the chocolate chips (one-time generation)
        double[][] chocolateChips = new double[10][2];  // 10 chips with [x, y] positions

        // Generate chips using polar coordinates to ensure they stay within the cookie
        for (int i = 0; i < 10; i++) {
            double angle = Math.random() * 2 * Math.PI;  // Random angle between 0 and 2π
            double radius = Math.random() * 0.3;  // Random radius between 0 and the cookie radius (0.3)
            double x = 0.5 + radius * Math.cos(angle);  // Convert polar to Cartesian (x)
            double y = 0.5 + radius * Math.sin(angle);  // Convert polar to Cartesian (y)
            chocolateChips[i][0] = x;  // Store the x-coordinate
            chocolateChips[i][1] = y;  // Store the y-coordinate
        }

       
        StdDraw.enableDoubleBuffering();  // Enable double-buffering for smoother visuals

        // Main game loop
        while (true) {
            StdDraw.clear();  // Clear the canvas to avoid overlapping drawings
            
            // Draw the cookie
            StdDraw.setPenColor(TAN);
            StdDraw.filledCircle(0.5, 0.5, 0.3);  // Draw a large brown cookie in the center
            
            // Draw the pre-generated random chocolate chips on the cookie
            for (int i = 0; i < 10; i++) {
                double x = chocolateChips[i][0];  // Use the stored random x position
                double y = chocolateChips[i][1];  // Use the stored random y position
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledCircle(x, y, 0.02);  // Draw a small black chocolate chip
               
            }

            // Draw game info (cookie count, power-up costs, etc.)
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(0.5, 0.9, "Cookies: " + cookieCount);
            StdDraw.text(0.25, 0.85, "Cookies Per Click: " + cookiesPerClick);
            StdDraw.text(0.25, 0.8, "Cookies Per Second: " + cookiesPerSecond);
            StdDraw.text(0.75, 0.85, "Click Power Cost: " + clickPowerCost + " cookies");
            StdDraw.text(0.75, 0.8, "Idle Power Cost: " + idlePowerCost + " cookies");
            StdDraw.text(0.5, 0.95, "Cookie Clicker!");

            // Detect if the user clicks on the cookie
            if (StdDraw.isMousePressed()) {
                double mouseX = StdDraw.mouseX();
                double mouseY = StdDraw.mouseY();
                double distance = Math.sqrt(Math.pow(mouseX - 0.5, 2) + Math.pow(mouseY - 0.5, 2));
                
                if (distance <= 0.3) {  // Check if the click is within the cookie's radius
                    cookieCount += cookiesPerClick;  // Increment cookies by the click power
                    System.out.println("Cookies: " + cookieCount);  // Print to console (for debugging)
                }
            }

            // Add idle cookies every second
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastIdleTime >= 1000) {  // Check if 1 second has passed
                cookieCount += cookiesPerSecond;  // Add idle cookies per second
                lastIdleTime = currentTime;  // Update the last idle time
            }

            // Automatically purchase upgrades
            if (cookieCount >= clickPowerCost) {
                cookiesPerClick++;  // Increase cookies per click
                cookieCount -= clickPowerCost;  // Deduct the cost from the total cookies
                clickPowerCost *= 2;  // Double the cost for the next upgrade
                System.out.println("Upgraded click power! New click power: " + cookiesPerClick);
            }

            if (cookieCount >= idlePowerCost) {
                cookiesPerSecond++;  // Increase idle cookies per second
                cookieCount -= idlePowerCost;  // Deduct the cost from the total cookies
                idlePowerCost *= 2;  // Double the cost for the next upgrade
                System.out.println("Upgraded idle power! New cookies per second: " + cookiesPerSecond);
            }

            // Display information about power upgrades on the screen
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.text(0.25, 0.2, "Upgrade Status:");
            StdDraw.text(0.25, 0.15, "Next Click Power Cost: " + clickPowerCost + " cookies");
            StdDraw.text(0.25, 0.1, "Next Idle Power Cost: " + idlePowerCost + " cookies");

            // Render everything on the canvas (buffered drawing)
            StdDraw.show();
            StdDraw.pause(50);  // Limit the frame rate to avoid excessive updates (20 FPS)
        }
    }
}
	