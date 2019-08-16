# -*- coding: UTF-8 -*-
import mysql.connector
import pandas as pd
from sqlalchemy import create_engine
from yaoZhiCrawler import YaoZhiCrawler

yzc = YaoZhiCrawler()

class DataSource:
    def __init__(self):
        self.sql_engine = create_engine("mysql+mysqlconnector://root:@127.0.0.1:3306/drug?ssl_disabled='True", echo=False)
        self.conn = mysql.connector.connect(user='root', password='mysql123', database='drug', use_unicode=True, auth_plugin='mysql_native_password')
        self.cursor = self.conn.cursor()

    def saveDrug(self):
        df = yzc.getItems()
        np_df = df.as_matrix()
        print(np_df)
        for row in np_df:
            self.cursor.execute('insert into drugInfo(drugSubgroup, drugName, indication) values(%s,%s,%s)',
                                [row[0], row[1], row[2]])
        self.conn.commit()

ds = DataSource()
ds.saveDrug()
