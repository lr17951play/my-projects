import requests
import datetime
import time


def get_articles_obj(category, shown_offset):

    my_header = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36"
    res = requests.get(url='https://www.csdn.net/api/articles?type=more&category=%s&shown_offset=%s' % (category, shown_offset), headers={'user-agent': my_header})

    response_obj = res.json()
    return response_obj


datetime_now = datetime.datetime.now()
date_stamp = str(int(time.mktime(datetime.datetime.now().timetuple())))
data_microsecond = str("%06d" % datetime_now.microsecond)

offset = date_stamp+data_microsecond
total = match = 0
while True:

    resp = get_articles_obj('python', offset)
    offset = resp.get('shown_offset')
    articles = resp.get('articles')
    size = len(articles)
    if size == 0:
        break
    total += size
    for i in range(size):
        title = articles[i].get('title')
        desc = articles[i].get('desc')
        url = articles[i].get('url')
        if '爬虫' in title or '爬虫' in desc:
            match += 1
            print(str(title) + "url: " + str(url))
    if offset == 0:
        # offset 为零时，使用offset会重复循环，此时使用Header中的X-Tingyun-Id作为标识
        break

print("全栈搜索完毕，共找到python文章%s篇，其中涉及“爬虫”技术的文章共%s篇" % (total, match))
