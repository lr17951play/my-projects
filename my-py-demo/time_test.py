import time
import calendar
import datetime

lt = time.asctime(time.localtime(time.time()))
print(lt)

ts = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
print(ts)

tstr = "2019-06-23 19:13:52"
tm = time.mktime(time.strptime(tstr, "%Y-%m-%d %H:%M:%S"))
print(tm)

cal = calendar.month(2019, 6)
print(cal)

now = datetime.datetime.now()
print(now)
print("yyyy-MM-dd HH:mm:ss 格式是  %s/%s/%s %s:%s:%s" % (now.year, now.month, now.day, now.hour, now.minute, now.second))
