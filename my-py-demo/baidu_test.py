from aip import AipSpeech

""" 你的 APPID AK SK """
APP_ID = "16684201"
API_KEY = "GlosBGu5OUQVCDgH4UpVo732"
SECRET_KEY = "ZKArK2b0104ehIGq6V2qBsDNCfvTSIWK"

client = AipSpeech(APP_ID, API_KEY, SECRET_KEY)

res = client.synthesis("Hello 兰州牛肉面", "zh", 1)

print(res)

with open("hello.mp3", "wb") as fi:
    fi.write(res)
