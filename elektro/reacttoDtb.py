import MySQLdb
import RPi.GPIO as GPIO
import time

results = 0
db = MySQLdb.connect("localhost", "root", "pokemon123", "hackathonn")
cursor = db.cursor()
sql = "select argument from pins"


def getDtb():


    GPIO.setwarnings(False)
    GPIO.setmode(GPIO.BOARD)

    #setup phase
    svetlo_pin1 = 18
    GPIO.setup(svetlo_pin1, GPIO.OUT)

    svetlo_pin2 = 18
    GPIO.setup(svetlo_pin2, GPIO.OUT)

    svetlo_pin3 = 18
    GPIO.setup(svetlo_pin3, GPIO.OUT)

    svetlo_pin4 = 18
    GPIO.setup(svetlo_pin4, GPIO.OUT)

    svetlo_pin5 = 18
    GPIO.setup(svetlo_pin5, GPIO.OUT)






    cursor.execute(sql)

    results = cursor.fetchall()

    currentline = 0

    for row in results:

        print("SUCKERINO: "+str(currentline)+" "+str(row[0]))
        if currentline == 0:
            #print(row[0])

            # Setting maximal F, our 10mm led has max 1500 Hz so we will use 1000 Hz
            led_pwm1 = GPIO.PWM(svetlo_pin1, 1000)

            # Procentuali nastaveni intenzity svetla
            led_pwm1.start(100)
            led_pwm1.ChangeDutyCycle(int(row[0]))

        if currentline == 1:
            # print("Now you are fucked for second time")

            # Setting maximal F, our 10mm led has max 1500 Hz so we will use 1000 Hz
            led_pwm2 = GPIO.PWM(svetlo_pin1, 1000)

            # Procentuali nastaveni intenzity svetla
            led_pwm2.start(100)
            led_pwm2.ChangeDutyCycle(int(row[0]))


        if currentline == 2:
            # print("Now 3 times")

            # Setting maximal F, our 10mm led has max 1500 Hz so we will use 1000 Hz
            led_pwm3 = GPIO.PWM(svetlo_pin3, 1000)

            # Procentuali nastaveni intenzity svetla
            led_pwm3.start(100)
            led_pwm3.ChangeDutyCycle(int(row[0]))


        if currentline == 3:
            #print("Now 4 times! ")

            # Setting maximal F, our 10mm led has max 1500 Hz so we will use 1000 Hz
            led_pwm4 = GPIO.PWM(svetlo_pin4, 1000)

            # Procentuali nastaveni intenzity svetla
            led_pwm4.start(100)
            led_pwm4.ChangeDutyCycle(int(row[0]))

        if currentline == 4:

            # Setting maximal F, our 10mm led has max 1500 Hz so we will use 1000 Hz
            led_pwm5 = GPIO.PWM(svetlo_pin5, 1000)

            # Procentuali nastaveni intenzity svetla
            led_pwm5.start(100)
            led_pwm5.ChangeDutyCycle(int(row[0]))

        if currentline == 5:
            print("5")

        if currentline == 6:
            print("6")

        if currentline == 7:
            print("7")

        if currentline == 8:
            print("8")

        if currentline == 9:
            print("9")

        if currentline == 10:
            print("10")

        if currentline == 11:
            print("11")

    currentline += 1

    # setup phase
    GPIO.setup(svetlo_pin1, GPIO.IN)

    GPIO.setup(svetlo_pin2, GPIO.IN)

    GPIO.setup(svetlo_pin3, GPIO.IN)

    GPIO.setup(svetlo_pin4, GPIO.IN)

    GPIO.setup(svetlo_pin5, GPIO.IN)

if __name__=='__main__':
    while True:
        getDtb()