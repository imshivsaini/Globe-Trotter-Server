# Globetrotter

Globetrotter is a fun and interactive web application where players guess famous destinations based on cryptic clues, pictures, and multiple-choice options. Users can also invite friends for challenge sessions and track their progress.

## Technologies Used
- **Java 17**
- **Spring Boot 3.4.3**
- **PostgreSQL** (Database)

## Features
- Guess destinations based on clues and images.
- Multiple-choice answer selection.
- Fun facts upon answering.
- User registration and profile retrieval.
- Challenge friends in competitive sessions.

## API Endpoints

### Game API
#### Get a Random Question
```
GET /api/game/question
```
Retrieves a random destination with clues and multiple-choice options.

#### Submit an Answer
```
POST /api/game/answer
```
Validates the user's answer and returns feedback with fun facts.

### User API
#### Register a New User
```
POST /api/users/register
```
Registers a new user with a unique username.

#### Retrieve User Profile
```
GET /api/users/{username}
```
Retrieves the user profile based on the provided username.

#### Create a Challenge Session
```
POST /api/users/challenge
```
Creates a challenge session for inviting friends.

#### Retrieve Challenge Session Info
```
GET /api/users/session/{sessionId}
```
Retrieves user information from a challenge session.

## Installation and Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/imshivsaini/Globe-Trotter-Server
   cd globetrotter
   ```
2. Configure the database connection in `application.properties`.
3. Build and run the application:
   ```sh
   ./mvnw spring-boot:run
   ```
4. Access the application at `http://localhost:505`.

## Contributing
Contributions are welcome! Feel free to submit issues or pull requests.
