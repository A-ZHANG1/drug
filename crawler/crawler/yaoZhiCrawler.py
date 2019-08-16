#!/usr/bin/python
# -*- coding: UTF-8 -*-

import urllib
import urllib2
import cookielib
import re
from bs4 import BeautifulSoup
import ssl
import pandas as pd

class YaoZhiCrawler:

    def __init__(self):

        self.requestUrl = 'https://db.yaozh.com/clinicaldrug?name=&yaoli=&zhuzhi=%E5%8F%91%E7%83%AD&xianghuzuoyong=&yaodong=&first=%E5%85%A8%E9%83%A8&pageSize=1000'
        self.cookies = cookielib.CookieJar()

        self.opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(self.cookies))
        self.headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0'}

        self.drugInfo = []

    def getPage(self):

        ssl._create_default_https_context = ssl._create_unverified_context

        request  = urllib2.Request(
            url = self.requestUrl,
            headers=self.headers)

        result = self.opener.open(request)
        return result

        # print result.read().decode('UTF-8')

    def getItems(self):
        page = self.getPage()

        soup = BeautifulSoup(page)
        tables = soup.findAll('table')
        tab = tables[0]

        skipStr = '查看'

        l = []
        row = []
        table_rows = tab.tbody.findAll('tr')
        for tr in table_rows:
            for td in tr.findAll('td'):
                text = td.getText().encode('UTF-8')
                if text != skipStr:
                    row.append(text)
            l.append(row)
            row =[]
        return pd.DataFrame(l)

yzc = YaoZhiCrawler()
page = yzc.getItems()
print(page)





