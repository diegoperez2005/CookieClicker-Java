# 🍪 Cookie Clicker (Java)

This project was developed as part of the **CSE 131** course that I took at **Washington University in St. Louis**. The assignment focused on building a simplified version of the popular idle game **Cookie Clicker** using Java and the StdDraw graphics library.

The main objective was to simulate an incremental clicker game where the user clicks on a cookie to earn "cookies" (currency), while also implementing idle earnings and progressive power-ups. This project encouraged students to practice **mouse event handling**, **random drawing**, **real-time logic**, and **prompt engineering with AI tools**.

---

## 🎯 Project Goals

The assignment required the following features:

- **Clickable cookie** drawn on-screen with a "Cookie Clicker!" title.
- **Randomly placed chocolate chips** (5 total) on the cookie that remain fixed throughout the game.
- **Mouse click detection** to increment a cookie counter.
- **Idle cookie generation**, where the player earns cookies automatically every second.
- **Click power-up**: After reaching 20 cookies, each click is worth more (scales with usage and cost increases).
- **Idle power-up**: After reaching 60 cookies, the idle cookie rate increases (also scales).
- Power-ups **automatically trigger** when thresholds are met (no buttons required).
- The game runs **endlessly** and updates the display in real time.

**Game Image:**
<img src="https://github.com/diegoperez2005/CookieClicker-Java/blob/main/CookieClicker%20Picutre.png?raw=true" height="375em" align="center" alt="Cookie" title="Cookie Clicker"/>
---

## 🧠 Key Concepts Practiced

- Real-time game loops
- Event-driven programming with mouse input
- Conditional logic for upgrades
- Variable scope and state persistence
- Prompt engineering and debugging with generative AI tools

---

## 🛠️ Technologies

- Java
- Eclipse IDE
- StdDraw graphics library (from course starter code)

---

## ▶️ How to Run

1. Compile the code:
```bash
javac -d bin src/assignment4/*.java
