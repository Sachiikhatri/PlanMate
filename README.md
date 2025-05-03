


 🌐 PlanMate - Home Internet Service Provider Analysis

PlanMate is a Java-based application designed to analyze and compare home Internet Service Providers (ISPs) across Canada. The system gathers data from major ISP websites, evaluates key internet service features, and provides intelligent recommendations tailored to user needs.



📊 Project Overview

The project focuses on four leading Canadian ISPs:

- Bell
- Cogeco
- Rogers
- Shaw

The application scrapes relevant data, compares available plans, and suggests the best option based on speed, budget, location, and service bundles.


🔍 Key Features

✅ Data Extraction
- Web crawlers built using **Java** and libraries like **JSoup** collect:
  - **Plan details**: pricing, speed, data caps
  - **Connection types**: cable, fiber, DSL
  - **Bundled services**: TV, phone, installation, equipment
  - **Geographic availability**: urban vs rural
  - **Customer features**: support quality, contracts, termination fees

📈 Data Comparison
- Compares ISP plans on multiple parameters:
  - Speed-to-price ratio
  - Coverage by region
  - Additional services and limitations

🤖 Recommendation Engine
- Recommends the best ISP based on:
  - User's internet usage (light, moderate, heavy)
  - Budget constraints
  - Location type
  - Bundle preferences

---

🛠️ Tech Stack

- **Java 17**
- **JSoup** – HTML parsing and web scraping
- **Jackson / Gson** – JSON processing
- **JavaFX / Swing** – *(optional)* GUI
- **Maven / Gradle** – Dependency management & build

---

🚀 How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/planmate.git
   cd planmate
````

2. **Build the project (using Maven)**

   ```bash
   mvn clean install
   ```

3. **Run the application**

   ```bash
   java -jar target/planmate.jar
   ```

   Or if using a GUI:

   ```bash
   java -cp target/planmate.jar com.planmate.ui.Main
   ```

---

## 📂 Project Structure

```
planmate/
│
├── src/
│   ├── com.planmate.crawlers/       # Website-specific scrapers (Bell, Cogeco, Rogers, Shaw)
│   ├── com.planmate.model/          # Data models for plans and ISPs
│   ├── com.planmate.logic/          # Comparison and recommendation engine
│   └── com.planmate.ui/             # Optional UI module (JavaFX or Swing)
│
├── data/                            # Sample outputs or mock data
├── README.md
├── pom.xml                          # Maven build file
└── planmate.jar                     # Compiled executable (after build)
```

---

## 👥 Team Roles

Each team member was responsible for crawling data from one ISP:

* **Bell** – Member A
* **Cogeco** – Member B
* **Rogers** – Member C
* **Shaw** – Member D

---

## 📌 Future Enhancements

* Add additional ISPs (e.g., Videotron, Telus)
* Region-based availability lookup via postal code
* Enhance GUI with interactive filtering
* Deploy as a desktop or web app

---

## 📜 License

MIT License

---

## 📫 Contact

For questions, feedback, or contributions, please open an issue or reach out to the project team.


