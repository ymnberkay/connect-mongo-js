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
    title: String,
    content: String,
    text: String,
    text2: String,
    text3: String,
    text4: String,
    text5: String,
    text6: String,
    text7: String,

}


const Note = mongoose.model("Note", notesSchema);

app.get("/", function (req, res) {
    res.sendFile(__dirname + "/index.html");
})

app.post("/", function(req, res) {
    let newNote = new Note({
        title: req.body.title,
        content: req.body.content,
        text: req.body.text1,
        text2: req.body.text2,
        text3: req.body.text3,
        text4: req.body.text4,
        text5: req.body.text5,
        text6: req.body.text6,
        text7: req.body.text7,

    });
    newNote.save();
    res.redirect('/');
})

app.listen(5500, function(){
    console.log("server is running on 5500");
})

