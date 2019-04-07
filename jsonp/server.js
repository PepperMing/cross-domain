let express = require('express')
let app = express()

app.get('/say',function(req,res){
    let {word,callback} = req.query
    res.end(`${callback}('is res')`)
})
app.listen(3000)