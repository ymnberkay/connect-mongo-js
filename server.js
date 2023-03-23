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
    conten2: String
}

const Note = mongoose.model("Note", notesSchema);

app.get("/", function (req, res) {
    res.sendFile(__dirname + "/index.html");
})

app.post("/", function(req, res) {
    let newNote = new Note({
        title: req.body.title,
        content: req.body.content,
        content2: req.body.content2
    });
    newNote.save();
    res.redirect('/');
})

app.listen(5500, function(){
    console.log("server is running on 5500");
})

