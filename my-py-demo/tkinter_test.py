#!/usr/bin/python
# -*- coding: UTF-8 -*-

import tkinter
import tkinter.messagebox
import playsound
import requests
import json
from aip import AipSpeech

""" 你的 APPID AK SK """
APP_ID = "16684201"
API_KEY = "GlosBGu5OUQVCDgH4UpVo732"
SECRET_KEY = "ZKArK2b0104ehIGq6V2qBsDNCfvTSIWK"
client = AipSpeech(APP_ID, API_KEY, SECRET_KEY)

root = tkinter.Tk()
root.title("Let's talk")
L1 = tkinter.Label(root, text="你想对我说：")
L1.pack(side=tkinter.LEFT)

E1 = tkinter.Entry(root, bd=5, width=50)
E1.pack(side=tkinter.RIGHT)


def convertMsg(message):
    url = 'http://api.qingyunke.com/api.php?key=free&appid=0&msg=' + message
    res = requests.get(url)
    result = json.loads(res.text).get('result')
    if result == 0:
        message = json.loads(res.text).get('content')
    else:
        message = '突然不想聊啦，休息会儿再说'
    return message


def click():
    msg = convertMsg(E1.get())
    res = client.synthesis(msg, "zh", 1)
    with open("hello.mp3", "wb") as fi:
        fi.write(res)
    playsound.playsound("hello.mp3")
    tkinter.messagebox.askokcancel("Hello", msg)
    fi.close()


B = tkinter.Button(root, text="发送", command=click)
B.pack()

root.mainloop()
# package commend: pyinstaller -F -w tkinter_test.py
