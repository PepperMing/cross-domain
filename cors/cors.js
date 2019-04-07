let express = require('express')
let app = express()

app.use(function (req,res,next){
    // 允许源，如果是 * ，则与 允许 cookie 不兼容
    res.setHeader('Access-Control-Allow-Origin',req.headers.origin)
    // 允许头
    res.setHeader("access-control-allow-headers","*")
    // 允许方法
    res.setHeader("access-control-allow-methods","*")
    // 允许 cookie
    res.setHeader("access-control-allow-credentials",true)
    // 预检测存活时间
    res.setHeader("access-control-max-age",6000)
    // 允许返回的头
    res.setHeader("access-control-expose-headers","*")
    next()
})

app.get('/say',function(req,res){
    res.end('end')
})

app.listen(3000)
