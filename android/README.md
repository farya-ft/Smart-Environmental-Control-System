Here’s a concise `README.md` specifically for the **Android part** of your project:

---

# **Data Receiver Android App**

This Android app displays real-time temperature data received from an ESP32 via a Flask server. The ESP32 sends the temperature data collected from a BMP180 sensor to the server, and the app fetches and displays the latest data.

## **Features**
- Fetches temperature data from a Flask server endpoint.
- Displays real-time updates every second.

## **Tech Stack**
- **Kotlin** (MainActivity.kt)
- **Android Studio** (UI and logic)
- **Coroutine** for periodic data fetching.

## **Main Functionality**
- The app fetches data from the `/get-data` endpoint of the Flask server every second using a coroutine.
- Displays the temperature in the app’s `TextView`.

## **Setup Instructions**
1. Clone the repository.
2. Open the project in **Android Studio**.
3. Update the Flask server URL in `MainActivity.kt`:
   ```kotlin
   val url = "http://<your-server-ip>:5000/get-data"
   ```
4. Run the app on your Android device or emulator.

---

