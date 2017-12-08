import MySQLdb


def getDtb():
    db = MySQLdb.connect("localhost", "", "", "kappa")

    cursor = db.cursor()
    sql = "select Stav from kappaTable"
    cursor.execute(sql)
    results = cursor.fetchall()

    currentLine = 0
    GPIO.setmode(GPIO.BOARD)

    for row in results:
        #print("SUCKERINO: "+str(k)+" "+str(row[0]))
        if currentLine == 0:
            #print(row[0])
            svetlo_pin1 = 18

            GPIO.setup(svetlo_pin1, GPIO.OUT)

            # Setting maximal F, our 10mm led has max 1500 Hz so we will use 1000 Hz
            led_pwm1 = GPIO.PWM(svetlo_pin1, 1000)

            # Procentuali nastaveni intenzity svetla
            led_pwm1.start(100)
            led_pwm1.ChangeDutyCycle(int(row[0]))

        if currentLine == 1:
            # print("Now you are fucked for second time")
            svetlo_pin2 = 18

            GPIO.setup(svetlo_pin2, GPIO.OUT)

            # Setting maximal F, our 10mm led has max 1500 Hz so we will use 1000 Hz
            led_pwm2 = GPIO.PWM(svetlo_pin1, 1000)

            # Procentuali nastaveni intenzity svetla
            led_pwm2.start(100)
            led_pwm2.ChangeDutyCycle(int(row[0]))


        if currentLine == 2:
            # print("Now 3 times")
            svetlo_pin3 = 18

            GPIO.setup(svetlo_pin3, GPIO.OUT)

            # Setting maximal F, our 10mm led has max 1500 Hz so we will use 1000 Hz
            led_pwm3 = GPIO.PWM(svetlo_pin3, 1000)

            # Procentuali nastaveni intenzity svetla
            led_pwm3.start(100)
            led_pwm3.ChangeDutyCycle(int(row[0]))


        if currentLine == 3:
            #print("Now 4 times! ")
            svetlo_pin4 = 18

            GPIO.setup(svetlo_pin4, GPIO.OUT)

            # Setting maximal F, our 10mm led has max 1500 Hz so we will use 1000 Hz
            led_pwm4 = GPIO.PWM(svetlo_pin4, 1000)

            # Procentuali nastaveni intenzity svetla
            led_pwm4.start(100)
            led_pwm4.ChangeDutyCycle(int(row[0]))

        if currentLine == 4:
            svetlo_pin5 = 18

            GPIO.setup(svetlo_pin5, GPIO.OUT)

            # Setting maximal F, our 10mm led has max 1500 Hz so we will use 1000 Hz
            led_pwm5 = GPIO.PWM(svetlo_pin5, 1000)

            # Procentuali nastaveni intenzity svetla
            led_pwm5.start(100)
            led_pwm5.ChangeDutyCycle(int(row[0]))

        

        currentLine = currentLine + 1
    db.close()

if __name__=='__main__':
    while True:
        getDtb()
