const express = require('express');
const mongoose = require('mongoose');
const app = express();
const bodyParser = require("body-parser");

app.use(bodyParser.urlencoded({ extended: true }))

const url = "mongodb+srv://testUser:123asd123@cluster0.eqohqrx.mongodb.net/?retryWrites=true&w=majority";

mongoose.connect(url, { useNewUrlParser: true, useUnifiedTopology: true })
    .then((result) => console.log("Basarili"))
    .catch((err) => console.log(err))

const notesSchema = {
    text1: String,
    text2: String,
    text3: String,
    text4: String,
    text5: String,
    text6: String,
    text7: String,
    text8: String,
    text9: String,
    text10: String,
    text11: String,
    text12: String,
    text13: String,
    text14: String,
    text15: String,


}


const Note = mongoose.model("Note", notesSchema);

app.get("/", function (req, res) {
    res.sendFile(__dirname + "/index.html");
})

app.post("/", function(req, res) {
    let newNote = new Note({
        text1: req.body.title,
        text2: req.body.content,
        text3: req.body.text1,
        text4: req.body.text2,
        text5: req.body.text3,
        text6: req.body.text4,
        text7: req.body.text5,
        text8: req.body.text6,
        text9: req.body.text7,
        text10: req.body.text8,
        text11: req.body.text9,
        text12: req.body.text10,
        text13: req.body.text11,
        text14: req.body.text12,
        text15: req.body.text13,


    });
    newNote.save();
    res.redirect('/');
})

app.listen(5500, function(){
    console.log("server is running on 5500");
})

const resultsSchema = {
    allSentence: String,
    time: Number
}
const Result = mongoose.model("Result", resultsSchema);
var cumle = "";

async function getData(){
    try {
        const post = await Result.find({}).sort({_id:-1}).limit(1);
        console.log(post);
    } catch (error) {
        console.log(error.message);
    }
}
function display() {
    alert("Hello world!");
 }


