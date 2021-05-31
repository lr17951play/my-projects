import requests
from lxml import etree

my_header = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36"

res = requests.get(url='https://www.jianshu.com/users/5aa8494a18c8/timeline', headers={'user-agent': my_header})

if '大神带我来搬砖' in res.text:
    print('found')
page = etree.HTML(res.text)
last_li = page.xpath('''//ul[@class="note-list"]/li[last()]''')[0]
max_id = int(last_li.get('id').split('-')[1]) - 1

file = open("activity.txt", 'w', encoding='utf-8')

page = 2
while True:
    res = requests.get(url='https://www.jianshu.com/users/5aa8494a18c8/timeline?max_id=%s&page=%s' %(max_id, page),
                       headers={'user-agent': my_header, 'X-INFINITESCROLL': 'true'})

    last_li = etree.HTML(res.text).xpath('''/html/body/li[last()]''')[0]
    max_id = int(last_li.get('id').split('-')[1]) - 1
    page = page + 1
    file.write(res.text)
    file.write("\n")
    if '加入了简书' in res.text:
        print('end')
        break

file.close()
