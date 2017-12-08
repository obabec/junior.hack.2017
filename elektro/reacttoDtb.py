import MySQLdb
import RPi.GPIO as GPIO
import time
#time.sleep(15)

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)

results = 0
numberOfWaterMinus = 0
waterStatus = 500

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

heat_pin = 13
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



def getDtb():

    db = MySQLdb.connect("localhost", "root", "pokemon123", "hackathonn")

    cursor = db.cursor()


    sql = "select argument from pins"


    cursor.execute(sql)


    results = cursor.fetchall()


    currentline = 0

    for row in results:

        if currentline == 0:
            #print(row[0])
            led_pwm1.ChangeDutyCycle(int(row[0]))

        if currentline == 1:
            #print(row[0])
            led_pwm2.ChangeDutyCycle(int(row[0]))


        if currentline == 2:
           #print(row[0])
           led_pwm3.ChangeDutyCycle(int(row[0]))


        if currentline == 3:
            #print(row[0])
            led_pwm4.ChangeDutyCycle(int(row[0]))

        if currentline == 4:
           #print(row[0])
           led_pwm5.ChangeDutyCycle(int(row[0]))

        if currentline == 5:
            # Heat
            print(row[0])
            if int(row[0]) == 1:
                GPIO.output(heat_pin, GPIO.HIGH)
            else:
                GPIO.output(heat_pin, GPIO.LOW)

        if currentline == 6:
           print("")


        if currentline == 7:
            # voda
            #print(row[0])
            if int(row[0]) == 1:
                waterStatus = waterStatus - (1/2)




        if currentline == 8:
            # voda
            #print(row[0])
            if int(row[0]) == 1:
                waterStatus = waterStatus - (1/2)

        if currentline == 9:
            # voda
            #print(row[0])
            if int(row[0]) == 1:
                waterStatus = waterStatus - (1/2)

        if currentline == 10:
            # voda
            #print(row[0])
            if int(row[0]) == 1:
                waterStatus = waterStatus - (1/2)

        if currentline == 11:
            print("")

        """if (numberOfWaterMinus % 50) == 0:
            print("Updatuju!")
            dbWater = MySQLdb.connect("localhost", "root", "pokemon123", "hackathonn")
            cursorWater = dbWater.cursor()


            sqlWater = "UPDATE pins SET argument = %d WHERE id = 12"
            cursorWater.execute(sqlWater,waterStatus)

        numberOfWaterMinus = numberOfWaterMinus + 1"""
        currentline = 1 + currentline

if __name__=='__main__':
    while True:
        getDtb()