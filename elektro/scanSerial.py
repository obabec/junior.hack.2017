import serial
import time
ser = serial.Serial('/dev/ttyUSB0',9600)


while 1 :
	var = ser.readline()
	if var != "":
		f = open('testFile.txt','w')
		f.write(var)
		print (var)
		f.close
