import MySQLdb
import RPi.GPIO as GPIO
import time

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)

results = 0

# Setting maximal F, our 10mm led has max 1500 Hz so we will use 1000 Hz
#setup phase

svetlo_pin1 = 11
GPIO.setup(svetlo_pin1, GPIO.OUT)

svetlo_pin2 = 18
GPIO.setup(svetlo_pin2, GPIO.OUT)

svetlo_pin3 = 18
GPIO.setup(svetlo_pin3, GPIO.OUT)

svetlo_pin4 = 18
GPIO.setup(svetlo_pin4, GPIO.OUT)

svetlo_pin5 = 18
GPIO.setup(svetlo_pin5, GPIO.OUT)


#Starting phase
led_pwm1 = GPIO.PWM(svetlo_pin1, 1000)
led_pwm1.start(100)

led_pwm2 = GPIO.PWM(svetlo_pin2, 1000)
led_pwm2.start(0)

led_pwm3 = GPIO.PWM(svetlo_pin3, 1000)
led_pwm3.start(0)

led_pwm4 = GPIO.PWM(svetlo_pin4, 1000)
led_pwm4.start(0)

led_pwm5 = GPIO.PWM(svetlo_pin5, 1000)
led_pwm5.start(0)


def getDtb():

    db = MySQLdb.connect("localhost", "root", "pokemon123", "hackathonn")
    cursor = db.cursor()
    sql = "select argument from pins"

    cursor.execute(sql)

    results = cursor.fetchall()

    currentline = 0

    for row in results:

        if currentline == 0:
            print(row[0])
            led_pwm1.ChangeDutyCycle(0)

        if currentline == 1:
            print(row[0])
            led_pwm2.ChangeDutyCycle(int(row[0]))


        if currentline == 2:
           print(row[0])
           led_pwm3.ChangeDutyCycle(int(row[0]))


        if currentline == 3:
            print(row[0])
            led_pwm4.ChangeDutyCycle(int(row[0]))

        if currentline == 4:
           print(row[0])
           led_pwm5.ChangeDutyCycle(int(row[0]))

        if currentline == 5:
            print(row[0])
            print("IAM HERE")
            led_pwm1.ChangeDutyCycle(50)
            print("I AM OUT")
            sleep(5)

        if currentline == 6:
            print(row[0])

        if currentline == 7:
            print(row[0])

        if currentline == 8:
            print(row[0])

        if currentline == 9:
            print(row[0])

        if currentline == 10:
            print(row[0])

        if currentline == 11:
            print(row[0])

    currentline += 1

if __name__=='__main__':
    while True:
        getDtb()