
# **STM32F446RE - Temperature Reading and UART Communication**

This part of the project uses STM32F446RE to:
- Read temperature data from the BMP180 sensor.
- Display the temperature on a 1602 I2C Character LCD.
- Send the temperature data to ESP32 using UART.

### **Steps**

1. **Hardware Setup**:
   - Connect BMP180 to the STM32 using I2C.
   - Connect 1602 LCD via I2C.
   - Connect STM32 and ESP32 via UART.

2. **Code Features**:
   - The BMP180 sensor data is read using the HAL I2C interface.
   - Data is displayed on the 1602 LCD using I2C.
   - The temperature is sent over UART to the ESP32.

3. **Key Libraries**:
   - STM32 HAL (for I2C, UART)
   - BMP180 Library for STM32
   - LCD I2C Library for STM32

### **Compilation and Setup**
   - Open the STM32CubeMX project.
   - Configure I2C for BMP180 and LCD.
   - Configure UART for communication with ESP32.
   - Generate the code and compile using Keil or STM32CubeIDE.

---
Here's a clear table that outlines the pin connections for the **STM32F446RE**, **LCD I2C**, **BMP180 sensor**, and **UART communication with ESP32**:

---

### **STM32 Pin Connections Table**

| **Component**   | **STM32 Pin** | **Signal/Pin**  | **Power** | **Ground** |
|-----------------|---------------|-----------------|-----------|------------|
| **LCD I2C (1602IIC)** | PB6           | SCL             | VCC (5V)  | GND        |
| **LCD I2C (1602IIC)** | PB7           | SDA             | VCC (5V)  | GND        |
| **BMP180 Sensor**     | PA8           | SCL             | VCC (3.3V) | GND        |
| **BMP180 Sensor**     | PC9           | SDA             | VCC (3.3V) | GND        |
| **ESP32 (UART)**      | PB10          | TX (ESP32 RX pin) | VCC (3.3V) | GND        |

---

### **Notes:**
1. **Power supply:**
   - **LCD I2C:** Needs 5V power for operation.
   - **BMP180 Sensor and ESP32:** Both operate at **3.3V**, so make sure to power them accordingly.
   
2. **Communication interfaces:**
   - The **LCD I2C** uses the I2C protocol, so connect its **SCL** and **SDA** to **PB6** and **PB7** of STM32.
   - The **BMP180** sensor also uses the I2C protocol, connected to **PA8** (SCL) and **PC9** (SDA).
   - **UART Communication:** The STM32 **PB10 (TX)** is connected to the **RX** pin of the ESP32 for data transmission.

Make sure the voltage levels are correctly matched when connecting the devices to prevent damage.
