# **ESP32 - Wi-Fi Communication and Data Transmission**

This part of the project is responsible for:
- Receiving data from STM32 via UART.
- Connecting to a Wi-Fi network.
- Sending temperature data to a Flask server using HTTP.

### **Steps**

1. **Hardware Setup**:
   - Connect ESP32 to STM32 using UART.

2. **Code Features**:
   - UART communication with STM32 to receive temperature data.
   - Wi-Fi connection to the local network.
   - Sending the received data to the Flask server using HTTP POST requests.

3. **Key Libraries**:
   - Arduino Core for ESP32
   - WiFi.h for Wi-Fi connectivity
   - HTTPClient.h for sending HTTP requests

### **Flask Server Communication**

- The ESP32 sends the temperature data to the Flask server by making an HTTP POST request to the `/data` endpoint.
- The data is sent in the form of a key-value pair, where the key is `Temp` and the value is the temperature.

```cpp
http.begin("http://<FLASK_SERVER_IP>:5000/data");
http.addHeader("Content-Type", "application/x-www-form-urlencoded");
String httpRequestData = "Temp=" + String(tempValue);
int httpResponseCode = http.POST(httpRequestData);
```

### **Compilation and Setup**
   - Open the Arduino IDE.
   - Install the ESP32 board support.
   - Flash the code to ESP32 via USB.

---

### **Flask Server Subproject README**

---

# **Flask Server for Data Collection**

The Flask server collects temperature data from ESP32 and provides an API to show and retrieve the data.

### **API Endpoints**

1. `/data` (POST): Receives temperature data from ESP32.
2. `/show-data` (GET): Displays the latest temperature in a webpage with live updates.
3. `/get-data` (GET): Returns the latest temperature data as JSON.

### **Key Code**

- **Receiving Data**:
  ```python
  @app.route('/data', methods=['POST'])
  def handle_data():
      global latest_temp
      temp = request.form.get('Temp')
      if temp:
          latest_temp = temp
          return jsonify({"message": "Data received", "temperature": temp}), 200
      return jsonify({"error": "No data received"}), 400
  ```

- **Displaying Data**:
  ```python
  @app.route('/show-data')
  def show_data():
      return render_template_string("""
          <html>
          <head>
              <title>Latest Temperature Data</title>
              <script>
                  function fetchData() {
                      fetch('/get-data')
                          .then(response => response.json())
                          .then(data => {
                              document.getElementById('temp-value').textContent = data.latest_temp || 'No data yet';
                          });
                  }
                  setInterval(fetchData, 1000);
              </script>
          </head>
          <body>
              <h1>Latest Temperature</h1>
              <p>Current Temperature: <span id="temp-value">No data yet</span></p>
          </body>
          </html>
      """)
  ```

### **Running the Server**

- Install dependencies: `pip install flask`
- Run the server:
  ```bash
  python app.py
  ```

---
