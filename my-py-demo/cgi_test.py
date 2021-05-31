#!D:/Program Files/Python 3.7.3/python.exe
# -*- coding: UTF-8 -*-

import codecs
import sys
import cgi

# 解决中文乱码
sys.stdout = codecs.getwriter('utf8')(sys.stdout.buffer)

# 创建 FieldStorage 的实例化
form = cgi.FieldStorage()

# 获取数据
site_id = form.getvalue('id')
site_name = form.getvalue('name')

print("Content-type:text/html")
print()                              # 空行，告诉服务器结束头部
print('<html>')
print('<head>')
print('<meta charset="utf-8">')
print('<title>Hello World - 我的第一个 CGI 程序！</title>')
print('</head>')
print('<body>')
print('<h2>Hello World! 这是我的第一个 CGI 程序</h2>')
print('<h3>id = %s; name = %s</h3>' % (site_id, site_name))
print('</body>')
print('</html>')
