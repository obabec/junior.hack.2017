import MySQLdb
import RPi.GPIO as GPIO
import time
import subprocess

#time.sleep(15)

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)

results = 0
numberOfWaterMinus = 0
waterStatus = 500
stavzamku = 0

# Setting maximal F, our 10mm led has max 1500 Hz so we will use 1000 Hz
#setup phase

svetlo_pin1 = 11
GPIO.setup(svetlo_pin1, GPIO.OUT)

svetlo_pin2 = 12
GPIO.setup(svetlo_pin2, GPIO.OUT)

svetlo_pin3 = 13
GPIO.setup(svetlo_pin3, GPIO.OUT)

svetlo_pin4 = 15
GPIO.setup(svetlo_pin4, GPIO.OUT)

svetlo_pin5 = 16
GPIO.setup(svetlo_pin5, GPIO.OUT)

heat_pin = 18
GPIO.setup(heat_pin, GPIO.OUT)

#Starting phase
led_pwm1 = GPIO.PWM(svetlo_pin1, 1000)
led_pwm1.start(0)

led_pwm2 = GPIO.PWM(svetlo_pin2, 1000)
led_pwm2.start(0)

led_pwm3 = GPIO.PWM(svetlo_pin3, 1000)
led_pwm3.start(0)

led_pwm4 = GPIO.PWM(svetlo_pin4, 1000)
led_pwm4.start(0)

led_pwm5 = GPIO.PWM(svetlo_pin5, 1000)
led_pwm5.start(0)

MotorPin = 35
MotorPin2 = 37

GPIO.setup(MotorPin, GPIO.OUT)   # Set LedPin's mode is output
GPIO.setup(MotorPin2,GPIO.OUT)



def getDtb():
    global numberOfWaterMinus
    global waterStatus
    global stavzamku

    db = MySQLdb.connect("localhost", "root", "pokemon123", "hackathonn")

    cursor = db.cursor()


    sql = "select argument from pins"


    cursor.execute(sql)


    results = cursor.fetchall()


    currentline = 0

    for row in results:

        if currentline == 0:
            led_pwm1.ChangeDutyCycle(int(row[0]))

        if currentline == 1:
            led_pwm2.ChangeDutyCycle(int(row[0]))


        if currentline == 2:
           led_pwm3.ChangeDutyCycle(int(row[0]))


        if currentline == 3:
            led_pwm4.ChangeDutyCycle(int(row[0]))

        if currentline == 4:
           led_pwm5.ChangeDutyCycle(int(row[0]))

        if currentline == 5:
            # Heat
            if int(row[0]) == 1:

                GPIO.output(heat_pin, GPIO.HIGH)
            else:
                GPIO.output(heat_pin, GPIO.LOW)


        if currentline == 6:
           # voda
           if int(row[0]) == 1:
               waterStatus = waterStatus - 0.2

        if currentline == 7:
            # voda
            if int(row[0]) == 1:
                waterStatus = waterStatus - 0.2

        if currentline == 8:
            # voda
            if int(row[0]) == 1:
                waterStatus = waterStatus - 0.2

        if currentline == 9:
            # voda
            if int(row[0]) == 1:
                waterStatus = waterStatus - 0.2

        if currentline == 10:
            if int(row[0]) == 1:
                if (stavzamku == 1):
                    GPIO.output(MotorPin2, GPIO.HIGH)
                    time.sleep(0.5)
                    GPIO.output(MotorPin2, GPIO.LOW)
                    stavzamku = 1

                if (stavzamku == 0):
                    GPIO.output(MotorPin, GPIO.HIGH)
                    time.sleep(0.5)
                    GPIO.output(MotorPin, GPIO.LOW)
                    stavzamku = 0
            else:
                if (stavzamku == 1):
                    GPIO.output(MotorPin2, GPIO.HIGH)
                    time.sleep(0.5)
                    GPIO.output(MotorPin2, GPIO.LOW)
                    stavzamku = 1

                if (stavzamku == 0):
                    GPIO.output(MotorPin, GPIO.HIGH)
                    time.sleep(0.5)
                    GPIO.output(MotorPin, GPIO.LOW)
                    stavzamku = 0


        if (numberOfWaterMinus % 50) == 0:
            subprocess.call(["php", "-f", "test.php", str(waterStatus)])

            print(waterStatus)
            print(numberOfWaterMinus)

        numberOfWaterMinus = numberOfWaterMinus + 1
        currentline = 1 + currentline

if __name__=='__main__':
    while True:
        getDtb()
