# 📱 Connect Hub

## 🚀 Project Overview  
Connect Hub is a foundational social 
networking platform entirely in Java, using Swing for the frontend and core Java 
for the backend. The platform enables users to manage accounts, groups, create and interact with
posts and stories, manage friendships, view and update profiles. A file-based 
database is used for simplicity, with emphasis on security, usability, and 
collaborative development. 
The project follows SOLID principles and the implementation includes 
creational, structural and behavioral design patterns.

---

## 📑 Features  
- User Account Management
- Profile Management
- Group Management
- Friend Management
- Content Creation
- Interacting with posts
- Newsfeed Page
- Search Functionality
- Notification System
- Private Chatting 

---

## 🛠️ Tech Stack  
| **Technology/Tool** | **Purpose**                     |
|----------------------|---------------------------------|
| **Java**          | Core programming language                    |
| **Swing/JavaFX**          | GUI framework for frontend                    |
| **FasterXML Jackson**          | JSON file handling                    |
| **Maven**          | Project management and build tool                    |

---

## 📂 Project Structure  
    
    new-java-project/
    │
    ├── Connect-Hub/
    │   ├── main/
    │   │   ├── java/
    │   │       ├── authenticators/       # Validations and passwords handeling 
    │   │       ├── databases/            # Database handeling
    │   │       ├── entities/             # All features    
    │   │       ├── enums/                # Flags
    │   │       |── managers/             # Deals with databases
    │   │       |── resources/            # Json files 
    │   │       |── frontend/             # GUI
    |   |       └── icons/                # Icons used in frontend
    │   │
    │   ├── test/                         # Unit tests
    │   ├── diagrams/                     # UML diagrams
    │   └─── README.md/                   # Project documentation
    │
    |
    ├── safe/
    ├── target/
    └── pom.xml                           # Maven configuration

---

## 🛠️ Setup and Installation  

1. **Create a new java project with Maven**.
2. **Navigate to the source packages folder**:  
   ```bash
   cd src
3. **Clone the Repository**:  
   ```bash
   git clone https://github.com/Youssef-Keshk/Connect-Hub.git
4. **Add the Jackson dependencies to your pom.xml file**:  
   ```bash
   <dependencies>
        <dependency>

            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.15.2</version> <!-- Replace with the latest version -->
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.datatype</groupId>
            <artifactId>jackson-datatype-jsr310</artifactId>
            <version>2.15.0</version> <!-- Use the latest compatible version -->
        </dependency>
    </dependencies>
5. **Build and run**


