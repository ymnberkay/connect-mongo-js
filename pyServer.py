from crypt import methods
from math import degrees
from flask import Flask, render_template, request, url_for, redirect
import pymongo
from pymongo import MongoClient
import urllib.parse



app = Flask(__name__)
client = pymongo.MongoClient("mongodb+srv://testUser:123asd123@cluster0.eqohqrx.mongodb.net/?retryWrites=true&w=majority")
db = client.test
mydb = client["test"]
mycol = mydb["results"]
@app.route('/index',methods=['GET'])
def get_data():
   data = mycol.find()
   details = list(data)
   print(details)
   k = details
   return render_template('index.html',details= k)


if __name__ == '__main__':
    app.run(debug=True)

